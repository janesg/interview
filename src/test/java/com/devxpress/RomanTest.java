package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanTest {

    @Test
    public void decimalToRoman() {
        assertEquals("", Roman.decimalToRoman(0));
        assertEquals("XXXIX", Roman.decimalToRoman(39));
        assertEquals("XLVIII", Roman.decimalToRoman(48));
        assertEquals("MCMIV", Roman.decimalToRoman(1904));
        assertEquals("MMMCDLXXXIX", Roman.decimalToRoman(3489));
    }

    @Test
    public void romanToDecimal() {
        assertEquals(0, Roman.romanToDecimal(""));
        assertEquals(0, Roman.romanToDecimal(null));
        assertEquals(39, Roman.romanToDecimal("XXXIX"));
        assertEquals(48, Roman.romanToDecimal("XLVIII"));
        assertEquals(1904, Roman.romanToDecimal("MCMIV"));
        assertEquals(3489, Roman.romanToDecimal("MMMCDLXXXIX"));
    }
}