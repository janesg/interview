package com.devxpress;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

    // Note: anagram check should ignore case and non-alphabetic strings
    public static boolean anagramCharMap(String str1, String str2) {

        if (str1.equals(str2)) {
            return true;
        }

        // Generate letter count frequency map for each string
        Map<Character, Long> str1Map = str1.toUpperCase().chars().
                filter(Character::isAlphabetic).
                mapToObj(c -> (char) c).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Map<Character, Long> str2Map = str2.toUpperCase().chars().
                filter(Character::isAlphabetic).
                mapToObj(c -> (char) c).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        if (str1Map.keySet().size() != str2Map.keySet().size()) {
            return false;
        }

        for (Map.Entry entry1 : str1Map.entrySet()) {
            Long value2 = str2Map.get(entry1.getKey());

            if (!entry1.getValue().equals(value2)) {
                return false;
            }
        }

        return true;
    }

    public static boolean anagramSort(String str1, String str2) {

        if (str1.equals(str2)) {
            return true;
        }

        // Generate sorted list of characters
        List<Character> str1Sorted = str1.toUpperCase().chars().
                filter(Character::isAlphabetic).
                mapToObj(c -> (char) c).
                sorted().
                collect(Collectors.toList());

        List<Character> str2Sorted = str2.toUpperCase().chars().
                filter(Character::isAlphabetic).
                mapToObj(c -> (char) c).
                sorted().
                collect(Collectors.toList());

        // List equality is true if same elements in same order
        return str1Sorted.equals(str2Sorted);
    }

    public static boolean anagramJavaScript(String str1, String str2, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/anagram.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return ((Boolean) ((Invocable) engine).invokeFunction(functionName, str1, str2)).booleanValue();
    }

}
