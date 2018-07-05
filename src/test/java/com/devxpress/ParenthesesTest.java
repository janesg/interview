package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParenthesesTest {

    @Test
    public void isBalanced() {
        assertTrue(Parentheses.isBalanced("[{[([])]}]"));
        assertTrue(Parentheses.isBalanced("[[[{[[[[([[[   ]]])]]]]}]]]"));
        assertTrue(Parentheses.isBalanced(""));
        assertTrue(Parentheses.isBalanced("   "));
        assertFalse(Parentheses.isBalanced("["));
        assertFalse(Parentheses.isBalanced("[[]]666{([]))} []"));
        assertTrue(Parentheses.isBalanced("[[1]234]{DFFH(( [])g)} 7[]"));
    }
}