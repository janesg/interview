package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class VowelsTest {
    @Test
    public void vowels() {
        assertEquals(3, Vowels.vowels("Hi There!"));
        assertEquals(4, Vowels.vowels("Why do you ask?"));
        assertEquals(0, Vowels.vowels("Why?"));
    }

    @Test
    public void vowelsJavaScript() throws Exception {
        assertEquals(3, vowelsJavaScript("Hi There!", "vowels"));
        assertEquals(4, vowelsJavaScript("Why do you ask?", "vowels"));
        assertEquals(0, vowelsJavaScript("Why?", "vowels"));
    }

    private static int vowelsJavaScript(String str, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/vowels.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (int) ((Invocable) engine).invokeFunction(functionName, str);
    }

}