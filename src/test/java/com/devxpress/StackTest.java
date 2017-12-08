package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void stackJavaScriptPushPop() throws Exception {
        assertEquals("7", stackJavaScript("testStackPushPop"));
    }

    @Test
    public void stackJavaScriptPeek() throws Exception {
        assertEquals("2", stackJavaScript("testStackPeek"));
    }

    @Test
    public void stackJavaScriptWeave() throws Exception {
        assertEquals("1,2,Salt,3,Pepper,4", stackJavaScript("testWeave"));
    }

    @Test
    public void queueFromStackJavaScriptAddRemove() throws Exception {
        assertEquals("9", stackJavaScript("testQueueFromStackAddRemove"));
    }

    @Test
    public void queueFromStackJavaScriptPeek() throws Exception {
        assertEquals("3", stackJavaScript("testQueueFromStackPeek"));
    }

    @Test
    public void queueFromStackJavaScriptWeave() throws Exception {
        assertEquals("1,Salt,2,Pepper,3,4", stackJavaScript("testQueueFromStackWeave"));
    }

    private static String stackJavaScript(String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/stack.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String) ((Invocable) engine).invokeFunction(functionName);
    }

}