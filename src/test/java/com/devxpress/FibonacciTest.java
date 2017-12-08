package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class FibonacciTest {
    @Test
    public void fibonacciIterative() {

        try {
            Fibonacci.fibonacciIterative(-1);
            fail("Negative entry should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Entry in series cannot be less than 0", e.getMessage());
        }

        assertEquals(0, Fibonacci.fibonacciIterative(0));
        assertEquals(1, Fibonacci.fibonacciIterative(1));
        assertEquals(1, Fibonacci.fibonacciIterative(2));
        assertEquals(2, Fibonacci.fibonacciIterative(3));
        assertEquals(34, Fibonacci.fibonacciIterative(9));
        assertEquals(75025, Fibonacci.fibonacciIterative(25));

        long start = System.nanoTime();
        // 47 is the first value of num that returns a value too big for an int
        long result = Fibonacci.fibonacciIterative(47);
        System.out.println("fibonacciIterative(47) = [" + result + "] took (nanosecs) : " + (System.nanoTime() - start));
        assertEquals(2971215073L, result);
    }

    @Test
    public void fibonacciRecursive() {

        try {
            Fibonacci.fibonacciRecursive(-1);
            fail("Negative entry should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Entry in series cannot be less than 0", e.getMessage());
        }

        assertEquals(0, Fibonacci.fibonacciRecursive(0));
        assertEquals(1, Fibonacci.fibonacciRecursive(1));
        assertEquals(1, Fibonacci.fibonacciRecursive(2));
        assertEquals(2, Fibonacci.fibonacciRecursive(3));
        assertEquals(34, Fibonacci.fibonacciRecursive(9));
        assertEquals(75025, Fibonacci.fibonacciRecursive(25));

        long start = System.nanoTime();
        // 47 is the first value of num that returns a value too big for an int
        long result = Fibonacci.fibonacciRecursive(47);
        System.out.println("fibonacciRecursive(47) = [" + result + "] took (nanosecs) : " + (System.nanoTime() - start));
        assertEquals(2971215073L, result);
    }

    @Test
    public void fibonacciRecursiveMemo() {

        try {
            Fibonacci.fibonacciRecursiveMemo(-1);
            fail("Negative entry should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Entry in series cannot be less than 0", e.getMessage());
        }

        assertEquals(0, Fibonacci.fibonacciRecursiveMemo(0));
        assertEquals(1, Fibonacci.fibonacciRecursiveMemo(1));
        assertEquals(1, Fibonacci.fibonacciRecursiveMemo(2));
        assertEquals(2, Fibonacci.fibonacciRecursiveMemo(3));
        assertEquals(34, Fibonacci.fibonacciRecursiveMemo(9));
        assertEquals(75025, Fibonacci.fibonacciRecursiveMemo(25));

        long start = System.nanoTime();
        // 47 is the first value of num that returns a value too big for an int
        long result = Fibonacci.fibonacciRecursiveMemo(47);
        System.out.println("fibonacciRecursiveMemo(47) = [" + result + "] took (nanosecs) : " + (System.nanoTime() - start));
        assertEquals(2971215073L, result);
    }

    @Test
    public void fibonacciRecursiveMemoGenericFunc() {

        try {
            Fibonacci.fibonacciRecursiveMemoGenericFunc(-1);
            fail("Negative entry should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Entry in series cannot be less than 0", e.getMessage());
        }

        assertEquals(0, Fibonacci.fibonacciRecursiveMemoGenericFunc(0));
        assertEquals(1, Fibonacci.fibonacciRecursiveMemoGenericFunc(1));
        assertEquals(1, Fibonacci.fibonacciRecursiveMemoGenericFunc(2));
        assertEquals(2, Fibonacci.fibonacciRecursiveMemoGenericFunc(3));
        assertEquals(34, Fibonacci.fibonacciRecursiveMemoGenericFunc(9));
        assertEquals(75025, Fibonacci.fibonacciRecursiveMemoGenericFunc(25));

        long start = System.nanoTime();
        // 47 is the first value of num that returns a value too big for an int
        long result = Fibonacci.fibonacciRecursiveMemoGenericFunc(47);
        System.out.println("fibonacciRecursiveMemoGenericFunc(47) = [" + result + "] took (nanosecs) : " + (System.nanoTime() - start));
        assertEquals(2971215073L, result);
    }

    @Test
    public void fibonacciJavaScriptIterative() throws Exception {
        try {
            fibonacciJavaScript(-1, "fibonacciIterative");
            fail("Negative entry should have thrown an exception");
        } catch (ScriptException e) {
            assertTrue(e.getMessage().startsWith("Entry in series cannot be less than 0"));
        }

        assertEquals(0, fibonacciJavaScript(0, "fibonacciIterative"));
        assertEquals(1, fibonacciJavaScript(1, "fibonacciIterative"));
        assertEquals(1, fibonacciJavaScript(2, "fibonacciIterative"));
        assertEquals(2, fibonacciJavaScript(3, "fibonacciIterative"));
        assertEquals(34, fibonacciJavaScript(9, "fibonacciIterative"));
        assertEquals(75025, fibonacciJavaScript(25, "fibonacciIterative"));

        long start = System.currentTimeMillis();
        // 47 is the first value of num that returns a value too big for an int
        long result = fibonacciJavaScript(47, "fibonacciIterative");
        System.out.println("JS fibonacciIterative(47) = [" + result + "] took (ms) : " + (System.currentTimeMillis() - start));
        assertEquals(2971215073L, result);
    }

    @Test
    public void fibonacciJavaScriptRecursive() throws Exception {
        try {
            fibonacciJavaScript(-1, "fibonacciRecursive");
            fail("Negative entry should have thrown an exception");
        } catch (ScriptException e) {
            assertTrue(e.getMessage().startsWith("Entry in series cannot be less than 0"));
        }

        assertEquals(0, fibonacciJavaScript(0, "fibonacciRecursive"));
        assertEquals(1, fibonacciJavaScript(1, "fibonacciRecursive"));
        assertEquals(1, fibonacciJavaScript(2, "fibonacciRecursive"));
        assertEquals(2, fibonacciJavaScript(3, "fibonacciRecursive"));
        assertEquals(34, fibonacciJavaScript(9, "fibonacciRecursive"));
        assertEquals(75025, fibonacciJavaScript(25, "fibonacciRecursive"));

        long start = System.currentTimeMillis();
        // 47 is the first value of num that returns a value too big for an int
        long result = fibonacciJavaScript(47, "fibonacciRecursive");
        System.out.println("JS fibonacciRecursive(47) = [" + result + "] took (ms) : " + (System.currentTimeMillis() - start));
        assertEquals(2971215073L, result);
    }

    @Test
    public void fibonacciJavaScriptRecursiveMemo() throws Exception {
        try {
            fibonacciJavaScript(-1, "fibonacciRecursiveMemo");
            fail("Negative entry should have thrown an exception");
        } catch (ScriptException e) {
            assertTrue(e.getMessage().startsWith("Entry in series cannot be less than 0"));
        }

        assertEquals(0, fibonacciJavaScript(0, "fibonacciRecursiveMemo"));
        assertEquals(1, fibonacciJavaScript(1, "fibonacciRecursiveMemo"));
        assertEquals(1, fibonacciJavaScript(2, "fibonacciRecursiveMemo"));
        assertEquals(2, fibonacciJavaScript(3, "fibonacciRecursiveMemo"));
        assertEquals(34, fibonacciJavaScript(9, "fibonacciRecursiveMemo"));
        assertEquals(75025, fibonacciJavaScript(25, "fibonacciRecursiveMemo"));

        long start = System.currentTimeMillis();
        // 47 is the first value of num that returns a value too big for an int
        long result = fibonacciJavaScript(47, "fibonacciRecursiveMemo");
        System.out.println("JS fibonacciRecursiveMemo(47) = [" + result + "] took (ms) : " + (System.currentTimeMillis() - start));
        assertEquals(2971215073L, result);
    }

    private static long fibonacciJavaScript(int num, String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/fibonacci.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        // Returns an Integer unless value is too large in which case Double is returned
        Object result = ((Invocable) engine).invokeFunction(functionName, num);

        if (result instanceof Integer) {
            return ((Integer) result).longValue();
        }

        // Otherwise a Double is returned
        return ((Double) result).longValue();
    }

}