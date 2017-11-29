package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class VowelsTest {
    @Test
    public void vowels() throws Exception {
        assertEquals(3, Vowels.vowels("Hi There!"));
        assertEquals(4, Vowels.vowels("Why do you ask?"));
        assertEquals(0, Vowels.vowels("Why?"));
    }

    @Test
    public void vowelsJavaScript() throws Exception {
        assertEquals(3, Vowels.vowelsJavaScript("Hi There!", "vowels"));
        assertEquals(4, Vowels.vowelsJavaScript("Why do you ask?", "vowels"));
        assertEquals(0, Vowels.vowelsJavaScript("Why?", "vowels"));
    }

}