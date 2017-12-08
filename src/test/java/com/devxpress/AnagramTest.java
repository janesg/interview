package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class AnagramTest {
    @Test
    public void anagramCharMap() {
        assertTrue(Anagram.anagramCharMap("Otterbox", "xoOtebrt"));
        assertFalse(Anagram.anagramCharMap("Otterbox", "xoOxxbrt"));
        assertTrue(Anagram.anagramCharMap("rail safety", "fairytales"));
        assertTrue(Anagram.anagramCharMap("RAIL! SAFETY!", "fairy tales"));
        assertFalse(Anagram.anagramCharMap("Hi there", "Bye there"));
    }

    @Test
    public void anagramSort() {
        assertTrue(Anagram.anagramSort("Otterbox", "xoOtebrt"));
        assertFalse(Anagram.anagramSort("Otterbox", "xoOxxbrt"));
        assertTrue(Anagram.anagramSort("rail safety", "fairytales"));
        assertTrue(Anagram.anagramSort("RAIL! SAFETY!", "fairy tales"));
        assertFalse(Anagram.anagramSort("Hi there", "Bye there"));
    }

    @Test
    public void anagramJavaScriptCharMap() throws Exception {
        assertTrue(anagramJavaScript("Otterbox", "xoOtebrt", "anagramCharMap"));
        assertFalse(anagramJavaScript("Otterbox", "xoOxxbrt", "anagramCharMap"));
        assertTrue(anagramJavaScript("rail safety", "fairytales", "anagramCharMap"));
        assertTrue(anagramJavaScript("RAIL! SAFETY!", "fairy tales", "anagramCharMap"));
        assertFalse(anagramJavaScript("Hi there", "Bye there", "anagramCharMap"));
    }

    @Test
    public void anagramJavaScriptSort() throws Exception {
        assertTrue(anagramJavaScript("Otterbox", "xoOtebrt", "anagramSort"));
        assertFalse(anagramJavaScript("Otterbox", "xoOxxbrt", "anagramSort"));
        assertTrue(anagramJavaScript("rail safety", "fairytales", "anagramSort"));
        assertTrue(anagramJavaScript("RAIL! SAFETY!", "fairy tales", "anagramSort"));
        assertFalse(anagramJavaScript("Hi there", "Bye there", "anagramSort"));
    }

    private static boolean anagramJavaScript(String str1, String str2, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/anagram.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (Boolean) ((Invocable) engine).invokeFunction(functionName, str1, str2);
    }

}