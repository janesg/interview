package com.devxpress;

import static org.junit.Assert.*;
import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void fizzBuzz() throws Exception {
        String[] expectedResults = new String[] {
            "1", "2", "FIZZ", "4", "BUZZ", "FIZZ", "7", "8", "FIZZ", "BUZZ",
            "11", "FIZZ", "13", "14", "FIZZBUZZ", "16", "17", "FIZZ", "19", "BUZZ",
            "FIZZ", "22", "23", "FIZZ", "BUZZ", "26", "FIZZ", "28", "29", "FIZZBUZZ"
        };

        String[] results = FizzBuzz.fizzBuzz(30);

        for (int i = 0; i < results.length ; i++) {
            assertEquals(expectedResults[i], results[i]);
        }
    }

    @Test
    public void fizzBuzzJavaScript() throws Exception {
        String[] expectedResults = new String[] {
                "1", "2", "FIZZ", "4", "BUZZ", "FIZZ", "7", "8", "FIZZ", "BUZZ",
                "11", "FIZZ", "13", "14", "FIZZBUZZ", "16", "17", "FIZZ", "19", "BUZZ",
                "FIZZ", "22", "23", "FIZZ", "BUZZ", "26", "FIZZ", "28", "29", "FIZZBUZZ"
        };

        String[] results = FizzBuzz.fizzBuzzJavaScript(30, "fizzBuzz");

        for (int i = 0; i < results.length ; i++) {
            assertEquals("Unexpected result", expectedResults[i], results[i]);
        }
    }

}