package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class ReverseAStringTest {
    @Test
    public void reverseStringBuilder() {
        assertEquals("xoBrettO", ReverseAString.reverseStringBuilder("OtterBox"));
    }

    @Test
    public void reverseForLoop() {
        assertEquals("xoBrettO", ReverseAString.reverseForLoop("OtterBox"));
    }

    @Test
    public void reverseStack() {
        assertEquals("xoBrettO", ReverseAString.reverseStack("OtterBox"));
    }

    @Test
    public void reverseCharSwap() {
        assertEquals("xoBrettO", ReverseAString.reverseCharSwap("OtterBox"));
        assertEquals("119xoBrettO", ReverseAString.reverseCharSwap("OtterBox911"));
    }

    @Test
    public void reverseCollection8() {
        assertEquals("xoBrettO", ReverseAString.reverseCollection8("OtterBox"));
    }

    @Test
    public void reverseJavaScriptSplitJoin() throws Exception {
        assertEquals("xoBrettO", reverseJavaScript("OtterBox", "reverseStringSplitJoin"));
    }

    @Test
    public void reverseJavaScriptForLoop() throws Exception {
        assertEquals("xoBrettO", reverseJavaScript("OtterBox", "reverseStringForLoop"));
    }

    @Test
    public void reverseJavaScriptReduce() throws Exception {
        assertEquals("xoBrettO", reverseJavaScript("OtterBox", "reverseStringReduce"));
    }

    private static String reverseJavaScript(String str, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/reverseString.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String) ((Invocable) engine).invokeFunction(functionName, str);
    }

}