package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {
    @Test
    public void palindromeBuilderReverse() throws Exception {
        assertEquals(false, Palindrome.palindromeBuilderReverse("Abba"));
        assertEquals(true, Palindrome.palindromeBuilderReverse("abba"));
    }

    @Test
    public void palindromeForLoop() throws Exception {
        assertEquals(false, Palindrome.palindromeForLoop("Abba"));
        assertEquals(true, Palindrome.palindromeForLoop("abba"));
    }

    @Test
    public void palindromeJavaScriptSplitJoin() throws Exception {
        assertEquals(false, Palindrome.palindromeJavaScript("Abba", "palindromeSplitJoin"));
        assertEquals(true, Palindrome.palindromeJavaScript("abba", "palindromeSplitJoin"));
        assertEquals(false, Palindrome.palindromeJavaScript("rotOr", "palindromeSplitJoin"));
        assertEquals(true, Palindrome.palindromeJavaScript("RotoR", "palindromeSplitJoin"));
    }

    @Test
    public void palindromeJavaScriptEvery() throws Exception {
        assertEquals(false, Palindrome.palindromeJavaScript("Abba", "palindromeEvery"));
        assertEquals(true, Palindrome.palindromeJavaScript("abba", "palindromeEvery"));
        assertEquals(false, Palindrome.palindromeJavaScript("rotOr", "palindromeEvery"));
        assertEquals(true, Palindrome.palindromeJavaScript("RotoR", "palindromeEvery"));
    }

}