package com.devxpress;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxChar {

    public static String maxChar(String str) {

        Map<Character, Long> countMap =
                str.chars().
                        mapToObj(c -> (char) c).
                        collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long max = 0L;
        Character maxChar = ' ';

        for (Map.Entry<Character, Long> entry : countMap.entrySet()) {
            if (entry.getValue().compareTo(max) > 0) {
                max = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        return maxChar.toString();
    }

    public static String maxCharJavaScript(String str, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/maxChar.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String) ((Invocable) engine).invokeFunction(functionName, str);
    }

}
