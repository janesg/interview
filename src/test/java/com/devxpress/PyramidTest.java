package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class PyramidTest {
    @Test
    public void pyramidIterative() {
        String[] expectedResults = new String[]{"   #   ", "  ###  ", " ##### ", "#######"};
        String[] results = Pyramid.pyramidIterative(4);
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = Pyramid.pyramidIterative(1);
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = Pyramid.pyramidIterative(0);
        checkResults(expectedResults, results);
    }

    @Test
    public void pyramidRecursive() {
        String[] expectedResults = new String[]{"   #   ", "  ###  ", " ##### ", "#######"};
        String[] results = Pyramid.pyramidRecursive(4);
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = Pyramid.pyramidRecursive(1);
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = Pyramid.pyramidRecursive(0);
        checkResults(expectedResults, results);
    }

    @Test
    public void pyramidJavaScriptIterative() throws Exception {
        String[] expectedResults = new String[]{"   #   ", "  ###  ", " ##### ", "#######"};
        String[] results = pyramidJavaScript(4, "pyramidIterative");
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = pyramidJavaScript(1, "pyramidIterative");
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = pyramidJavaScript(0, "pyramidIterative");
        checkResults(expectedResults, results);
    }

    @Test
    public void pyramidJavaScriptRecursive() throws Exception {
        String[] expectedResults = new String[]{"   #   ", "  ###  ", " ##### ", "#######"};
        String[] results = pyramidJavaScript(4, "pyramidRecursive");
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = pyramidJavaScript(1, "pyramidRecursive");
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = pyramidJavaScript(0, "pyramidRecursive");
        checkResults(expectedResults, results);
    }

    private void checkResults(String[] expectedResults, String[] results) {
        for (int i = 0; i < results.length ; i++) {
            System.out.println("[" + results[i] + "]");
            assertEquals(expectedResults[i], results[i]);
        }
    }

    private static String[] pyramidJavaScript(int num, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/pyramid.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String[]) ((Invocable) engine).invokeFunction(functionName, num);
    }

}