package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class MaxCharTest {

    @Test
    public void maxChar() {
        assertEquals("t", MaxChar.maxChar("jjewtryqtwqyrytfdt"));
    }

    @Test
    public void maxCharJavaScript() throws Exception {
        assertEquals("t", maxCharJavaScript("jjewtryqtwqyrytfdt", "maxChar"));
    }

    private static String maxCharJavaScript(String str, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/maxChar.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String) ((Invocable) engine).invokeFunction(functionName, str);
    }

}