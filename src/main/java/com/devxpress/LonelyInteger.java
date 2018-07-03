package com.devxpress;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LonelyInteger {

    // Only appropriate if input array contains pairs of numbers + the single number
    public int unpairedInteger(int[] input) {
        if (input.length < 1) {
            throw new IllegalArgumentException("Input array has no elements.");
        }

        int result = 0;

        for (int i = 0; i < input.length; i++) {
            // XOR number with itself = 0
            // - all pairs should produce 0 leaving result equal to the single unpaired number
            result ^= input[i];
        }

        return result;
    }

    // Can be used when input array contains multiple copies (2 or more) of numbers + the single number
    public int singleInteger(int[] input) {
        if (input.length < 1) {
            throw new IllegalArgumentException("Input array has no elements.");
        }

        Map<Integer, Integer> numCount = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            Integer count = numCount.get(input[i]);

            if (count == null) {
                numCount.put(input[i], 1);
            } else {
                numCount.put(input[i], ++count);
            }
        }

        Integer result = null;
        Iterator<Integer> it = numCount.keySet().iterator();

        while (result == null && it.hasNext()) {
            Integer key = it.next();

            if (numCount.get(key) == 1) {
                result = key;
            }
        }

        if (result == null) {
            throw new IllegalStateException("Input array does not contain a lonely integer.");
        }

        return result;
    }
}
