package com.devxpress;

import java.util.Arrays;

public class Pyramid {

    public static String[] pyramidIterative(int num) {

        String[] results = new String[num];
        int stringSize = (2 * num) - 1;
        int midIdx = stringSize / 2;

        for (int i = 0; i < num ; i++) {
            char[] chars = new char[stringSize];
            Arrays.fill(chars, 0, midIdx - i, ' ');
            Arrays.fill(chars, midIdx - i, midIdx + 1 + i, '#');
            Arrays.fill(chars, midIdx + 1 + i, stringSize, ' ');
            results[i] = String.valueOf(chars);
        }

        return results;
    }

    public static String[] pyramidRecursive(int num) {

        return recursionHelper(new String[num], num);
    }

    private static String[] recursionHelper(String[] strArr, int num) {
        if (num <= 0) {
            return strArr;
        }

        int arrSize = getLength(strArr);
        int stringSize = (2 * (num + arrSize)) - 1;
        int midIdx = stringSize / 2;

        char[] chars = new char[stringSize];
        Arrays.fill(chars, 0, midIdx - arrSize, ' ');
        Arrays.fill(chars, midIdx - arrSize, midIdx + 1 + arrSize, '#');
        Arrays.fill(chars, midIdx + 1 + arrSize, stringSize, ' ');
        strArr[arrSize] = String.valueOf(chars);

        return recursionHelper(strArr, num - 1);
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
