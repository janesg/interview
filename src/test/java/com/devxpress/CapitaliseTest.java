package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class CapitaliseTest {
    @Test
    public void capitalise() {

        assertEquals("This Is How We Roll", Capitalise.capitalise("This is how we roll"));
        assertEquals("A Short Sentence", Capitalise.capitalise("a short sentence"));
        assertEquals("A Lazy Fox", Capitalise.capitalise("a lazy fox"));
        assertEquals("Look, It's Working!", Capitalise.capitalise("look, it's working!"));
    }

    @Test
    public void capitaliseJavaScript() throws Exception {

        assertEquals("This Is How We Roll", capitaliseJavaScript("This is how we roll", "capitalise"));
        assertEquals("A Short Sentence", capitaliseJavaScript("a short sentence", "capitalise"));
        assertEquals("A Lazy Fox", capitaliseJavaScript("a lazy fox", "capitalise"));
        assertEquals("Look, It's Working!", capitaliseJavaScript("look, it's working!", "capitalise"));
    }

    private static String capitaliseJavaScript(String str, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/capitalise.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String) ((Invocable) engine).invokeFunction(functionName, str);
    }

}