package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void queueJavaScriptAddRemove() throws Exception {
        assertEquals("9", queueJavaScript("testQueueAddRemove"));
    }

    @Test
    public void queueJavaScriptPeek() throws Exception {
        assertEquals("3", queueJavaScript("testQueuePeek"));
    }

    @Test
    public void queueJavaScriptWeave() throws Exception {
        assertEquals("1,Salt,2,Pepper,3,4", queueJavaScript("testWeave"));
    }

    private static String queueJavaScript(String functionName) throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        if (!(engine instanceof Invocable)) {
            throw new RuntimeException("Invoking methods is not supported.");
        }

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        // Get script from JS File on classpath (from resources)
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     loader.getResourceAsStream("js/queue.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String) ((Invocable) engine).invokeFunction(functionName);
    }

}