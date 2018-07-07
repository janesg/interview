package com.devxpress;

// Convert between integer and String without using JDK utility functions
public class IntString {

    static int stringToInt(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input must not be null.");
        }

        int sign = (str.charAt(0) == '-') ? -1 : 1;

        if (sign == -1) {
            str = str.substring(1);
        }

        int val = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // Check within ascii character range of numerals
            if (c < 48 || c > 57) {
                throw new IllegalArgumentException("Input contains non-numeric characters.");
            }

            int multiplier = 1;

            for (int m = i + 1; m < str.length(); m++) {
                multiplier *= 10;
            }

            val += (c - 48) * multiplier;
        }

        return val * sign;
    }

    static String intToString(int theInt) {

        String result = "";
        boolean negative = false;

        if (theInt < 0) {
            negative = true;
            theInt *= -1;
        }

        while (theInt > 9) {
            int i = theInt % 10;
            result = i + result;
            theInt /= 10;
        }

        result = theInt + result;

        return (negative) ? '-' + result : result;
    }
}
