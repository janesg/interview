package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void matrix() throws Exception {
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
        int[][] results = Matrix.matrixJavaScript(4, "matrix");
        checkResults(expectedResults, results);

        expectedResults = new int[][] {{ 1 }};
        results = Matrix.matrixJavaScript(1, "matrix");
        checkResults(expectedResults, results);

        expectedResults = new int[][] {};
        results = Matrix.matrixJavaScript(0, "matrix");
        checkResults(expectedResults, results);
    }

    private static void checkResults(int[][] expectedResults, int[][] results) {
        assertEquals(expectedResults.length, results.length);

        for (int i = 0 ; i < expectedResults.length; i++) {
            assertArrayEquals(expectedResults[i], results[i]);
        }
    }
}