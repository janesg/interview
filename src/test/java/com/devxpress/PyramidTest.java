package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class PyramidTest {
    @Test
    public void pyramidIterative() throws Exception {
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
    public void pyramidRecursive() throws Exception {
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
        String[] results = Pyramid.pyramidJavaScript(4, "pyramidIterative");
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = Pyramid.pyramidJavaScript(1, "pyramidIterative");
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = Pyramid.pyramidJavaScript(0, "pyramidIterative");
        checkResults(expectedResults, results);
    }

    @Test
    public void pyramidJavaScriptRecursive() throws Exception {
        String[] expectedResults = new String[]{"   #   ", "  ###  ", " ##### ", "#######"};
        String[] results = Pyramid.pyramidJavaScript(4, "pyramidRecursive");
        checkResults(expectedResults, results);

        expectedResults = new String[]{"#"};
        results = Pyramid.pyramidJavaScript(1, "pyramidRecursive");
        checkResults(expectedResults, results);

        expectedResults = new String[0];
        results = Pyramid.pyramidJavaScript(0, "pyramidRecursive");
        checkResults(expectedResults, results);
    }

    private void checkResults(String[] expectedResults, String[] results) {
        for (int i = 0; i < results.length ; i++) {
            System.out.println("[" + results[i] + "]");
            assertEquals(expectedResults[i], results[i]);
        }
    }

}