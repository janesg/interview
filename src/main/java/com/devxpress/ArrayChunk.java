package com.devxpress;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayChunk {

    public static int[][] arrayChunk(int[] array, int size) {

        int remainder = array.length % size;
        int numSubArrays = remainder > 0 ? (array.length / size) + 1 : (array.length / size) ;

        int[][] result = new int[numSubArrays][];

        for (int i = 0; i < numSubArrays; i++) {
            for (int j = 0; j < size; j++) {
                // Allocate the correct size inner sub array
                if (j == 0) {
                    // Handle non-standard size of last inner array
                    if (i == (numSubArrays - 1)) {
                        result[i] = (remainder == 0) ? new int[size] : new int[remainder];
                    } else {
                        result[i] = new int[size];
                    }
                }

                // Derive index into the original array
                // Note: as I don't iterate through the original array, this
                //       solution will perform (size - remainder) unnecessary passes
                //       if the array length is not a multiple of the size.
                int idx = (i * size) + j;
                if (idx < array.length) {
                    result[i][j] = array[idx];
                }
            }
        }

        return result;
    }

    public static int[][] arrayChunkJavaScript(int[] array, int size, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/arrayChunk.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (int[][]) ((Invocable) engine).invokeFunction(functionName, array, size);
    }

}
