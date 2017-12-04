package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void addFirstLastClear() throws Exception {
        LinkedList<String> linked = new LinkedList<>();

        assertEquals(0, linked.size());

        linked.addFirst("Three");
        linked.addFirst("Cheers");
        linked.addFirst("For");
        linked.addFirst("Bob");

        assertEquals(4, linked.size());
        assertEquals("Bob", linked.getFirst());
        assertEquals("Three", linked.getLast());
        linked.clear();
        assertEquals(0, linked.size());
    }

    @Test
    public void removeFirst() throws Exception {
        LinkedList<String> linked = new LinkedList<>();

        linked.addFirst("Three");
        linked.addFirst("Cheers");
        linked.addFirst("For");
        linked.addFirst("Bob");

        assertEquals(4, linked.size());
        assertEquals("Bob", linked.removeFirst());
        assertEquals(3, linked.size());
        assertEquals("For", linked.getFirst());
    }

    @Test
    public void removeLast() throws Exception {
        LinkedList<String> linked = new LinkedList<>();

        linked.addFirst("Three");
        linked.addFirst("Cheers");
        linked.addFirst("For");
        linked.addFirst("Bob");

        assertEquals(4, linked.size());
        assertEquals("Three", linked.removeLast());
        assertEquals(3, linked.size());
        assertEquals("Cheers", linked.getLast());
    }

    @Test
    public void addFirstJavaScript() throws Exception {
        linkedListJavaScript("testLinkedList");
    }

    public static String linkedListJavaScript(String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/linkedlist.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (String) ((Invocable) engine).invokeFunction(functionName);
    }

}