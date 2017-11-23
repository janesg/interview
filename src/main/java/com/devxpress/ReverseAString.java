package com.devxpress;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseAString {

    public static String reverseForLoop(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1 ; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static String reverseStack(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        char[] rev = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            rev[i] = stack.pop();
        }

        return String.valueOf(rev);
    }

    public static String reverseCharSwap(String str) {

        char[] strArr = str.toCharArray();

        for(int i = 0, j = str.length() - 1 ; i < j ; i++, j--) {
            char temp = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = temp;
        }

        return String.valueOf(strArr);
    }

    public static String reverseCollection8(String str) {

        // Use CharSequence to create list of characters via stream
        List<Character> charList = str.chars().
                                        mapToObj(c -> (char) c).
                                        collect(Collectors.toList());

        // Reverse the list in place
        Collections.reverse(charList);

        // Now stream the character list and join into String
        return charList.stream().
                    map(Object::toString).
                    collect(Collectors.joining());
    }
}
