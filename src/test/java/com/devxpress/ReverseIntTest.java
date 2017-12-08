package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class ReverseIntTest {

    @Test
    public void reverseInt() {
        assertEquals(15, ReverseInt.reverseInt(51));
        assertEquals(-15, ReverseInt.reverseInt(-51));
        assertEquals(5, ReverseInt.reverseInt(500));
        assertEquals(-5, ReverseInt.reverseInt(-500));
        assertEquals(0, ReverseInt.reverseInt(0));
    }

    @Test
    public void reverseIntJavaScriptForLoop() throws Exception {
        assertEquals(15, reverseIntJavaScript(51, "reverseIntForLoop"));
        assertEquals(-15, reverseIntJavaScript(-51, "reverseIntForLoop"));
        assertEquals(5, reverseIntJavaScript(500, "reverseIntForLoop"));
        assertEquals(-5, reverseIntJavaScript(-500, "reverseIntForLoop"));
        assertEquals(0, reverseIntJavaScript(0, "reverseIntForLoop"));
    }

    @Test
    public void reverseIntJavaScriptSplitJoin() throws Exception {
        assertEquals(15, reverseIntJavaScript(51, "reverseIntSplitJoin"));
        assertEquals(-15, reverseIntJavaScript(-51, "reverseIntSplitJoin"));
        assertEquals(5, reverseIntJavaScript(500, "reverseIntSplitJoin"));
        assertEquals(-5, reverseIntJavaScript(-500, "reverseIntSplitJoin"));
        assertEquals(0, reverseIntJavaScript(0, "reverseIntSplitJoin"));
    }

    private static int reverseIntJavaScript(int num, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/reverseInt.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (Integer) ((Invocable) engine).invokeFunction(functionName, num);
    }

}