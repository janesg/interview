package com.devxpress;

import static org.junit.Assert.*;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzzTest {

    @Test
    public void fizzBuzz() {
        String[] expectedResults = new String[] {
            "1", "2", "FIZZ", "4", "BUZZ", "FIZZ", "7", "8", "FIZZ", "BUZZ",
            "11", "FIZZ", "13", "14", "FIZZBUZZ", "16", "17", "FIZZ", "19", "BUZZ",
            "FIZZ", "22", "23", "FIZZ", "BUZZ", "26", "FIZZ", "28", "29", "FIZZBUZZ"
        };

        String[] results = FizzBuzz.fizzBuzz(30);

        for (int i = 0; i < results.length ; i++) {
            assertEquals(expectedResults[i], results[i]);
        }
    }

    @Test
    public void fizzBuzzJavaScript() throws Exception {
        String[] expectedResults = new String[] {
                "1", "2", "FIZZ", "4", "BUZZ", "FIZZ", "7", "8", "FIZZ", "BUZZ",
                "11", "FIZZ", "13", "14", "FIZZBUZZ", "16", "17", "FIZZ", "19", "BUZZ",
                "FIZZ", "22", "23", "FIZZ", "BUZZ", "26", "FIZZ", "28", "29", "FIZZBUZZ"
        };

        String[] results = fizzBuzzJavaScript(30, "fizzBuzz");

        for (int i = 0; i < results.length ; i++) {
            assertEquals("Unexpected result", expectedResults[i], results[i]);
        }
    }

    private static String[] fizzBuzzJavaScript(int num, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/fizzBuzz.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String[]) ((Invocable) engine).invokeFunction(functionName, num);
    }

}