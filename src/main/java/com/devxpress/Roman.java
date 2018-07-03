package com.devxpress;

import java.util.Map;
import java.util.TreeMap;

public class Roman {

    private static final TreeMap<Integer, String> D_2_R = new TreeMap<>();

    static {
        D_2_R.put(1000, "M");
        D_2_R.put(900, "CM");
        D_2_R.put(500, "D");
        D_2_R.put(400, "CD");
        D_2_R.put(100, "C");
        D_2_R.put(90, "XC");
        D_2_R.put(50, "L");
        D_2_R.put(40, "XL");
        D_2_R.put(10, "X");
        D_2_R.put(9, "IX");
        D_2_R.put(5, "V");
        D_2_R.put(4, "IV");
        D_2_R.put(1, "I");
    }

    public static String decimalToRoman(int decimal) {
        StringBuilder sb = new StringBuilder();

        while (decimal > 0) {
            Map.Entry<Integer, String> entry = D_2_R.floorEntry(decimal);
            sb.append(entry.getValue());
            decimal -= entry.getKey();
        }

        return sb.toString();
    }

    public static int romanToDecimal(String roman) {
        int result = 0;

        if (roman == null || roman.length() < 1) {
            return 0;
        }

        int charVal = value(roman.charAt(0));

        for (int i = 0; i < roman.length() - 1; i++) {
            int nextCharVal = value(roman.charAt(i + 1));

            if (nextCharVal > charVal) {
                result -= charVal;
            } else {
                result += charVal;
            }

            charVal = nextCharVal;
        }

        result += charVal;

        return result;
    }

    private static int value(char c) {
        switch(c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}
