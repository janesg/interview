package com.devxpress;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static String[] fizzBuzz(int max) {
        return IntStream.rangeClosed(1, max).
                mapToObj(i -> (i % 3 == 0 && i % 5 == 0 ? "FIZZBUZZ" :
                                    (i % 3 == 0 ? "FIZZ" :
                                            (i % 5 == 0 ? "BUZZ" : String.valueOf(i))))
                ).
                toArray(String[]::new);
    }

    public static String[] fizzBuzzJavaScript(int num, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/fizzBuzz.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String[]) ((Invocable) engine).invokeFunction(functionName, num);
    }

}
