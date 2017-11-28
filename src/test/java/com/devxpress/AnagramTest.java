package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {
    @Test
    public void anagramCharMap() throws Exception {
        assertTrue(Anagram.anagramCharMap("Otterbox", "xoOtebrt"));
        assertFalse(Anagram.anagramCharMap("Otterbox", "xoOxxbrt"));
        assertTrue(Anagram.anagramCharMap("rail safety", "fairytales"));
        assertTrue(Anagram.anagramCharMap("RAIL! SAFETY!", "fairy tales"));
        assertFalse(Anagram.anagramCharMap("Hi there", "Bye there"));
    }

    @Test
    public void anagramSort() throws Exception {
        assertTrue(Anagram.anagramSort("Otterbox", "xoOtebrt"));
        assertFalse(Anagram.anagramSort("Otterbox", "xoOxxbrt"));
        assertTrue(Anagram.anagramSort("rail safety", "fairytales"));
        assertTrue(Anagram.anagramSort("RAIL! SAFETY!", "fairy tales"));
        assertFalse(Anagram.anagramSort("Hi there", "Bye there"));
    }

    @Test
    public void anagramJavaScriptCharMap() throws Exception {
        assertTrue(Anagram.anagramJavaScript("Otterbox", "xoOtebrt", "anagramCharMap"));
        assertFalse(Anagram.anagramJavaScript("Otterbox", "xoOxxbrt", "anagramCharMap"));
        assertTrue(Anagram.anagramJavaScript("rail safety", "fairytales", "anagramCharMap"));
        assertTrue(Anagram.anagramJavaScript("RAIL! SAFETY!", "fairy tales", "anagramCharMap"));
        assertFalse(Anagram.anagramJavaScript("Hi there", "Bye there", "anagramCharMap"));
    }

    @Test
    public void anagramJavaScriptSort() throws Exception {
        assertTrue(Anagram.anagramJavaScript("Otterbox", "xoOtebrt", "anagramSort"));
        assertFalse(Anagram.anagramJavaScript("Otterbox", "xoOxxbrt", "anagramSort"));
        assertTrue(Anagram.anagramJavaScript("rail safety", "fairytales", "anagramSort"));
        assertTrue(Anagram.anagramJavaScript("RAIL! SAFETY!", "fairy tales", "anagramSort"));
        assertFalse(Anagram.anagramJavaScript("Hi there", "Bye there", "anagramSort"));
    }

}