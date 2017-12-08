package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class PalindromeTest {
    @Test
    public void palindromeBuilderReverse() {
        assertEquals(false, Palindrome.palindromeBuilderReverse("Abba"));
        assertEquals(true, Palindrome.palindromeBuilderReverse("abba"));
    }

    @Test
    public void palindromeForLoop() {
        assertEquals(false, Palindrome.palindromeForLoop("Abba"));
        assertEquals(true, Palindrome.palindromeForLoop("abba"));
    }

    @Test
    public void palindromeJavaScriptSplitJoin() throws Exception {
        assertEquals(false, palindromeJavaScript("Abba", "palindromeSplitJoin"));
        assertEquals(true, palindromeJavaScript("abba", "palindromeSplitJoin"));
        assertEquals(false, palindromeJavaScript("rotOr", "palindromeSplitJoin"));
        assertEquals(true, palindromeJavaScript("RotoR", "palindromeSplitJoin"));
    }

    @Test
    public void palindromeJavaScriptEvery() throws Exception {
        assertEquals(false, palindromeJavaScript("Abba", "palindromeEvery"));
        assertEquals(true, palindromeJavaScript("abba", "palindromeEvery"));
        assertEquals(false, palindromeJavaScript("rotOr", "palindromeEvery"));
        assertEquals(true, palindromeJavaScript("RotoR", "palindromeEvery"));
    }

    private static boolean palindromeJavaScript(String str, String functionName) throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        if (!(engine instanceof Invocable)) {
            throw new RuntimeException("Invoking methods is not supported.");
        }

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        // Get script from JS File on classpath (from resources)
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     loader.getResourceAsStream("js/palindrome.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (Boolean) ((Invocable) engine).invokeFunction(functionName, str);
    }

}