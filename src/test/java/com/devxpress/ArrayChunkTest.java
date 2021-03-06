package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class ArrayChunkTest {
    @Test
    public void arrayChunk() {

        int[][] results = ArrayChunk.arrayChunk(new int[]{ 1, 2, 3, 4 }, 2);

        int[] subArr0 = new int[]{1, 2};
        int[] subArr1 = new int[]{3, 4};
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = ArrayChunk.arrayChunk(new int[]{ 1, 2, 3, 4, 5 }, 2);

        subArr0 = new int[]{1, 2};
        subArr1 = new int[]{3, 4};
        int[] subArr2 = new int[]{ 5 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = ArrayChunk.arrayChunk(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 }, 3);

        subArr0 = new int[]{1, 2, 3};
        subArr1 = new int[]{4, 5, 6};
        subArr2 = new int[]{ 7, 8 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = ArrayChunk.arrayChunk(new int[]{ 1, 2, 3, 4, 5 }, 4);

        subArr0 = new int[]{ 1, 2, 3, 4 };
        subArr1 = new int[]{ 5 };
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = ArrayChunk.arrayChunk(new int[]{ 1, 2, 3, 4, 5 }, 10);

        subArr0 = new int[]{ 1, 2, 3, 4, 5 };
        assertEquals(1, results.length);
        assertArrayEquals(subArr0, results[0]);

    }

    @Test
    public void arrayChunkArrayCopy() {

        int[][] results = ArrayChunk.arrayChunkArrayCopy(new int[]{ 1, 2, 3, 4 }, 2);

        int[] subArr0 = new int[]{1, 2};
        int[] subArr1 = new int[]{3, 4};
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = ArrayChunk.arrayChunkArrayCopy(new int[]{ 1, 2, 3, 4, 5 }, 2);

        subArr0 = new int[]{1, 2};
        subArr1 = new int[]{3, 4};
        int[] subArr2 = new int[]{ 5 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = ArrayChunk.arrayChunkArrayCopy(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 }, 3);

        subArr0 = new int[]{1, 2, 3};
        subArr1 = new int[]{4, 5, 6};
        subArr2 = new int[]{ 7, 8 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = ArrayChunk.arrayChunkArrayCopy(new int[]{ 1, 2, 3, 4, 5 }, 4);

        subArr0 = new int[]{ 1, 2, 3, 4 };
        subArr1 = new int[]{ 5 };
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = ArrayChunk.arrayChunkArrayCopy(new int[]{ 1, 2, 3, 4, 5 }, 10);

        subArr0 = new int[]{ 1, 2, 3, 4, 5 };
        assertEquals(1, results.length);
        assertArrayEquals(subArr0, results[0]);

    }

    @Test
    public void arrayChunkJavaScript() throws Exception {

        int[][] results = arrayChunkJavaScript(new int[]{ 1, 2, 3, 4 }, 2, "arrayChunk");

        int[] subArr0 = new int[]{1, 2};
        int[] subArr1 = new int[]{3, 4};
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 2, "arrayChunk");

        subArr0 = new int[]{1, 2};
        subArr1 = new int[]{3, 4};
        int[] subArr2 = new int[]{ 5 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 }, 3, "arrayChunk");

        subArr0 = new int[]{1, 2, 3};
        subArr1 = new int[]{4, 5, 6};
        subArr2 = new int[]{ 7, 8 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 4, "arrayChunk");

        subArr0 = new int[]{ 1, 2, 3, 4 };
        subArr1 = new int[]{ 5 };
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 10, "arrayChunk");

        subArr0 = new int[]{ 1, 2, 3, 4, 5 };
        assertEquals(1, results.length);
        assertArrayEquals(subArr0, results[0]);
    }

    @Test
    public void arrayChunkSliceJavaScript() throws Exception {

        int[][] results = arrayChunkJavaScript(new int[]{ 1, 2, 3, 4 }, 2, "arrayChunkSlice");

        int[] subArr0 = new int[]{1, 2};
        int[] subArr1 = new int[]{3, 4};
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 2, "arrayChunkSlice");

        subArr0 = new int[]{1, 2};
        subArr1 = new int[]{3, 4};
        int[] subArr2 = new int[]{ 5 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 }, 3, "arrayChunkSlice");

        subArr0 = new int[]{1, 2, 3};
        subArr1 = new int[]{4, 5, 6};
        subArr2 = new int[]{ 7, 8 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 4, "arrayChunkSlice");

        subArr0 = new int[]{ 1, 2, 3, 4 };
        subArr1 = new int[]{ 5 };
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 10, "arrayChunkSlice");

        subArr0 = new int[]{ 1, 2, 3, 4, 5 };
        assertEquals(1, results.length);
        assertArrayEquals(subArr0, results[0]);
    }

    private static int[][] arrayChunkJavaScript(int[] array, int size, String functionName) throws Exception {

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