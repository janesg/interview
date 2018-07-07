package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntStringTest {

    @Test
    public void stringToInt() {
        assertEquals(0, IntString.stringToInt("0"));
        assertEquals(-1, IntString.stringToInt("-1"));
        assertEquals(3, IntString.stringToInt("3"));
        assertEquals(1234, IntString.stringToInt("1234"));
        assertEquals(-5678, IntString.stringToInt("-5678"));

        try {
            IntString.stringToInt(null);
            fail("Should have thrown an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            assertEquals("Input must not be null.", e.getMessage());
        }

        try {
            IntString.stringToInt("-637T£34");
            fail("Should have thrown an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            assertEquals("Input contains non-numeric characters.", e.getMessage());
        }
    }

    @Test
    public void intToString() {
        assertEquals("0", IntString.intToString(0));
        assertEquals("-1", IntString.intToString(-1));
        assertEquals("3", IntString.intToString(3));
        assertEquals("1234", IntString.intToString(1234));
        assertEquals("-5678", IntString.intToString(-5678));
    }
}