package com.devxpress;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseInt {

    public static int reverseInt(int num) {

        String numStr = String.valueOf(num);
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            if (Character.isDigit(c)) {
                sb.insert(0, c);
            }
        }

        return Integer.signum(num) * Integer.valueOf(sb.toString()).intValue();
    }

    public static int reverseIntJavaScript(int num, String functionName) throws Exception {

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
        return ((Integer) ((Invocable) engine).invokeFunction(functionName, num)).intValue();
    }

}
