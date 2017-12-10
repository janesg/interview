package com.devxpress;

import org.junit.Ignore;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void bubbleSortInteger() throws Exception {

        List<Integer> expectedResults = Arrays.asList(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        Integer[] array = Arrays.asList(3, -1, 7, 2, 8, -2, 1, 5, 4, 0, 6).toArray(new Integer[0]);
        List<Integer> results = Arrays.asList(Sort.bubbleSort(array));

        assertEquals(expectedResults, results);
    }

    @Test
    public void bubbleSortString() throws Exception {

        List<String> expectedResults = Arrays.asList("abc", "bcd", "cde", "def", "efg", "fgh");
        String[] array = Arrays.asList("def", "cde", "bcd", "fgh", "efg", "abc").toArray(new String[0]);
        List<String> results = Arrays.asList(Sort.bubbleSort(array));

        assertEquals(expectedResults, results);
    }

    @Test
    public void selectionSortInteger() throws Exception {

        List<Integer> expectedResults = Arrays.asList(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        Integer[] array = Arrays.asList(3, -1, 7, 2, 8, -2, 1, 5, 4, 0, 6).toArray(new Integer[0]);
        List<Integer> results = Arrays.asList(Sort.selectionSort(array));

        assertEquals(expectedResults, results);
    }

    @Test
    public void selectionSortString() throws Exception {

        List<String> expectedResults = Arrays.asList("abc", "bcd", "cde", "def", "efg", "fgh");
        String[] array = Arrays.asList("def", "cde", "bcd", "fgh", "efg", "abc").toArray(new String[0]);
        List<String> results = Arrays.asList(Sort.selectionSort(array));

        assertEquals(expectedResults, results);
    }

    @Test
    public void mergeSortInteger() throws Exception {

        List<Integer> input = Arrays.asList(3, -1, 7, 2, 8, -2, 1, 5, 4, 0, 6);
        List<Integer> expectedResults = Arrays.asList(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> results = Arrays.asList(Sort.mergeSort(input.toArray(new Integer[0])));
        assertEquals(expectedResults, results);

        results = Sort.mergeSort(input);
        assertEquals(expectedResults, results);
    }

    @Test
    public void mergeSortString() throws Exception {

        List<String> input = Arrays.asList("def", "cde", "bcd", "fgh", "efg", "abc");
        List<String> expectedResults = Arrays.asList("abc", "bcd", "cde", "def", "efg", "fgh");

        List<String> results = Arrays.asList(Sort.mergeSort(input.toArray(new String[0])));
        assertEquals(expectedResults, results);

        results = Sort.mergeSort(input);
        assertEquals(expectedResults, results);
    }

    @Test
    public void bubbleSortJavaScript() throws Exception {

        int[] expectedResults = new int[] {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] results = sortJavaScript(new int[]{3, -1, 7, 2, 8, -2, 1, 5, 4, 0, 6}, "testBubbleSort");
        assertArrayEquals(expectedResults, results);
    }

    @Test
    public void selectionSortJavaScript() throws Exception {

        int[] expectedResults = new int[] {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] results = sortJavaScript(new int[]{3, -1, 7, 2, 8, -2, 1, 5, 4, 0, 6}, "testSelectionSort");
        assertArrayEquals(expectedResults, results);
    }

    @Test
    @Ignore
    // Can't get mergeSort to work due to recursive passing of arrays in Nashorn
    public void mergeSortJavaScript() throws Exception {
        int[] expectedResults = new int[] {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] results = sortJavaScript(new int[]{3, -1, 7, 2, 8, -2, 1, 5, 4, 0, 6}, "testMergeSort");
        assertArrayEquals(expectedResults, results);
    }

    private static int[] sortJavaScript(int[] arr, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/sort.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (int[]) ((Invocable) engine).invokeFunction(functionName, arr);
    }

}