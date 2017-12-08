package com.devxpress;

public class ReverseInt {

    public static int reverseInt(int num) {

        String numStr = String.valueOf(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            if (Character.isDigit(c)) {
                sb.insert(0, c);
            }
        }

        return Integer.signum(num) * Integer.valueOf(sb.toString());
    }

}
