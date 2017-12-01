package com.devxpress;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrix {

    public static int[][] matrix(int num) {

        int[][] results = new int[num][num];

        int count = 1;
        int startRow = 0;
        int endRow = num - 1;
        int startCol = 0;
        int endCol = num - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Fill current start row
            for (int i = startCol; i <= endCol; i++) {
                results[startRow][i] = count++;
            }

            startRow++;

            // Fill current end column
            for (int i = startRow; i <= endRow; i++) {
                results[i][endCol] = count++;
            }

            endCol--;

            // Fill current end row
            for (int i = endCol; i >= startCol; i--) {
                results[endRow][i] = count++;
            }

            endRow--;

            // Fill current start column
            for (int i = endRow; i >= startRow; i--) {
                results[i][startCol] = count++;
            }

            startCol++;
        }

        return results;
    }

    public static int[][] matrixJavaScript(int num, String functionName) throws Exception {

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

}
