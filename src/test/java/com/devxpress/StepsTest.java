package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class StepsTest {
    @Test
    public void stepsIterative() throws Exception {
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
    public void stepsRecursive() throws Exception {
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
        String[] results = Steps.stepsJavaScript(4, "stepsIterative");
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = Steps.stepsJavaScript(1, "stepsIterative");
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = Steps.stepsJavaScript(0, "stepsIterative");
        checkResults(expectedResults, results);
    }

    @Test
    public void stepsJavaScriptRecursive() throws Exception {
        String[] expectedResults = new String[]{"#   ", "##  ", "### ", "####"};
        String[] results = Steps.stepsJavaScript(4, "stepsRecursive");
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = Steps.stepsJavaScript(1, "stepsRecursive");
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = Steps.stepsJavaScript(0, "stepsRecursive");
        checkResults(expectedResults, results);
    }

    private void checkResults(String[] expectedResults, String[] results) {
        for (int i = 0; i < results.length ; i++) {
            System.out.println("[" + results[i] + "]");
            assertEquals(expectedResults[i], results[i]);
        }
    }
}