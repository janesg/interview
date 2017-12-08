package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class StepsTest {
    @Test
    public void stepsIterative() {
        String[] expectedResults = new String[]{"#   ", "##  ", "### ", "####"};
        String[] results = Steps.stepsIterative(4);
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = Steps.stepsIterative(1);
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = Steps.stepsIterative(0);
        checkResults(expectedResults, results);
    }

    @Test
    public void stepsRecursive() {
        String[] expectedResults = new String[]{"#   ", "##  ", "### ", "####"};
        String[] results = Steps.stepsRecursive(4);
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = Steps.stepsRecursive(1);
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = Steps.stepsRecursive(0);
        checkResults(expectedResults, results);
    }

    @Test
    public void stepsJavaScriptIterative() throws Exception {
        String[] expectedResults = new String[]{"#   ", "##  ", "### ", "####"};
        String[] results = stepsJavaScript(4, "stepsIterative");
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = stepsJavaScript(1, "stepsIterative");
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = stepsJavaScript(0, "stepsIterative");
        checkResults(expectedResults, results);
    }

    @Test
    public void stepsJavaScriptRecursive() throws Exception {
        String[] expectedResults = new String[]{"#   ", "##  ", "### ", "####"};
        String[] results = stepsJavaScript(4, "stepsRecursive");
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = stepsJavaScript(1, "stepsRecursive");
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = stepsJavaScript(0, "stepsRecursive");
        checkResults(expectedResults, results);
    }

    private static String[] stepsJavaScript(int num, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/steps.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String[]) ((Invocable) engine).invokeFunction(functionName, num);
    }

    private void checkResults(String[] expectedResults, String[] results) {
        for (int i = 0; i < results.length ; i++) {
            System.out.println("[" + results[i] + "]");
            assertEquals(expectedResults[i], results[i]);
        }
    }
}