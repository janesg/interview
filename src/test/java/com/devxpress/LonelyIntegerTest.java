package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class LonelyIntegerTest {

    @Test
    public void unpairedInteger() {
        try {
            new LonelyInteger().unpairedInteger(new int[]{});
            fail("Should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Input array has no elements.", e.getMessage());
        }

        assertEquals(3, new LonelyInteger().unpairedInteger(new int[]{3}));
        assertEquals(3, new LonelyInteger().unpairedInteger(new int[]{1,2,3,4,5,6,7,8,1,2,4,5,6,7,8}));
        assertEquals(3, new LonelyInteger().unpairedInteger(new int[]{1,2,3,4,5,6,7,8,1,2,4,5,3,3,6,7,8}));
        assertEquals(0, new LonelyInteger().unpairedInteger(new int[]{1,2,0,4,5,6,7,8,1,2,4,5,6,7,8}));
        assertEquals(-3, new LonelyInteger().unpairedInteger(new int[]{1,2,-3,-4,5,6,-7,8,1,2,-4,5,6,-7,8}));
    }

    @Test
    public void singleInteger() {
        try {
            new LonelyInteger().singleInteger(new int[]{});
            fail("Should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Input array has no elements.", e.getMessage());
        }

        try {
            new LonelyInteger().singleInteger(new int[]{1,1,1,2,2,4,4,4,4,4});
            fail("Should have thrown an exception");
        } catch (IllegalStateException e) {
            assertEquals("Input array does not contain a lonely integer.", e.getMessage());
        }

        assertEquals(3, new LonelyInteger().singleInteger(new int[]{1,2,3,4,5,6,7,8,1,2,4,5,6,7,8}));
        assertEquals(3, new LonelyInteger().singleInteger(new int[]{1,1,1,1,2,5,3,4,5,6,7,8,1,7,2,2,4,5,6,7,8}));
    }
}