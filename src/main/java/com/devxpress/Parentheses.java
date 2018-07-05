package com.devxpress;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parentheses {

    public static boolean isBalanced(String brackets) {

        if (brackets == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++) {
            char c = brackets.charAt(i);

            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (c == ']' || c == '}' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char topChar = stack.pop();

                    if ((c == ']' && topChar != '[') ||
                        (c == '}' && topChar != '{') ||
                        (c == ')' && topChar != '(')) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
