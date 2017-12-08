package com.devxpress;

import java.util.Arrays;

public class Steps {

    public static String[] stepsIterative(int num) {

        String[] results = new String[num];

        for (int i = 0; i < num; i++) {
            char[] chars = new char[num];
            Arrays.fill(chars, 0, i + 1, '#');
            Arrays.fill(chars, i + 1, num, ' ');
            results[i] = String.valueOf(chars);
        }

        return results;
    }

    public static String[] stepsRecursive(int num) {

        return stepHelper(new String[num], num);
    }

    private static String[] stepHelper(String[] arr, int num) {
        if (num == 0) {
            return arr;
        } else {
            // The next array index to fill is equivalent to the number of steps created so far
            // These can only be detected by looking for non-null array elements since length is fixed @ num
            int idx = getLength(arr);
            char[] chars = new char[num + idx];
            Arrays.fill(chars, 0, idx + 1, '#');
            Arrays.fill(chars, idx + 1, num + idx, ' ');
            arr[idx] = String.valueOf(chars);

            return stepHelper(arr, num - 1);
        }
    }

    private static int getLength(String[] arr) {
        int count = 0;
        for (String str : arr) {
            if (str != null) {
                count++;
            }
        }

        return count;
    }

}
