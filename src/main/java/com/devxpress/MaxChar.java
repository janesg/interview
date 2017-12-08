package com.devxpress;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxChar {

    public static String maxChar(String str) {

        Map<Character, Long> countMap =
                str.chars().
                        mapToObj(c -> (char) c).
                        collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long max = 0L;
        Character maxChar = ' ';

        for (Map.Entry<Character, Long> entry : countMap.entrySet()) {
            if (entry.getValue().compareTo(max) > 0) {
                max = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        return maxChar.toString();
    }

}
