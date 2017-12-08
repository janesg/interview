package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void matrix() {
        // Spiral square matrix
        int[][] expectedResults = new int[][] {
                {  1,  2,  3,  4 },
                { 12, 13, 14,  5 },
                { 11, 16, 15,  6 },
                { 10,  9,  8,  7 }};
        int[][] results = Matrix.matrix(4);
        checkResults(expectedResults, results);

        expectedResults = new int[][] {{ 1 }};
        results = Matrix.matrix(1);
        checkResults(expectedResults, results);

        expectedResults = new int[][] {};
        results = Matrix.matrix(0);
        checkResults(expectedResults, results);
    }

    @Test
    public void matrixJavaScript() throws Exception {

        int[][] expectedResults = new int[][] {
                {  1,  2,  3,  4 },
                { 12, 13, 14,  5 },
                { 11, 16, 15,  6 },
                { 10,  9,  8,  7 }};
        int[][] results = matrixJavaScript(4, "matrix");
        checkResults(expectedResults, results);

        expectedResults = new int[][] {{ 1 }};
        results = matrixJavaScript(1, "matrix");
        checkResults(expectedResults, results);

        expectedResults = new int[][] {};
        results = matrixJavaScript(0, "matrix");
        checkResults(expectedResults, results);
    }

    private static int[][] matrixJavaScript(int num, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/matrix.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (int[][]) ((Invocable) engine).invokeFunction(functionName, num);
    }

    private static void checkResults(int[][] expectedResults, int[][] results) {
        assertEquals(expectedResults.length, results.length);

        for (int i = 0 ; i < expectedResults.length; i++) {
            assertArrayEquals(expectedResults[i], results[i]);
        }
    }
}