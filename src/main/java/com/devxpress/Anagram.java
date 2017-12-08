package com.devxpress;

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

}
