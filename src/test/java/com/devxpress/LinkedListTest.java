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
    public void emptyList() throws Exception {
        LinkedList<String> linked = new LinkedList<>();

        assertEquals(0, linked.size());
        assertNull(linked.getFirst());
        assertNull(linked.getLast());
        assertNull(linked.removeFirst());
        assertNull(linked.removeLast());
    }

    @Test
    public void singleItemList() throws Exception {
        LinkedList<String> linked = new LinkedList<>();

        assertEquals(0, linked.size());

        linked.addLast("Mule");

        assertEquals(1, linked.size());
        assertEquals("Mule", linked.getFirst());
        assertEquals("Mule", linked.getLast());
        assertEquals("Mule", linked.removeLast());
        assertEquals(0, linked.size());
        assertNull(linked.removeFirst());
    }

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
    public void addLast() throws Exception {
        LinkedList<String> linked = new LinkedList<>();

        assertEquals(0, linked.size());
        linked.addLast("Three");
        assertEquals(1, linked.size());
        linked.addLast("Cheers");
        linked.addLast("For");
        linked.addLast("Bob");

        assertEquals(4, linked.size());
        assertEquals("Three", linked.getFirst());
        assertEquals("Bob", linked.getLast());
        assertEquals("Three", linked.removeFirst());
        assertEquals(3, linked.size());
        assertEquals("Bob", linked.removeLast());
        assertEquals(2, linked.size());
        assertEquals("Cheers", linked.getFirst());
        assertEquals("For", linked.getLast());
    }

    @Test
    public void get() throws Exception {
        LinkedList<String> linked = new LinkedList<>();

        try {
            linked.get(-1);
            fail("Negative index should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: -1, Size: 0", e.getMessage());
        }

        try {
            linked.get(0);
            fail("Index equal to size should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 0, Size: 0", e.getMessage());
        }

        try {
            linked.get(1);
            fail("Index greater than size should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 1, Size: 0", e.getMessage());
        }

        linked.addLast("Spud");
        assertEquals("Spud", linked.get(0));

        try {
            linked.get(1);
            fail("Index equal to size should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 1, Size: 1", e.getMessage());
        }

        linked.addFirst("Potato");
        assertEquals("Potato", linked.get(0));
        assertEquals("Spud", linked.get(1));

    }

    @Test
    public void remove() throws Exception {
        LinkedList<String> linked = new LinkedList<>();

        try {
            linked.remove(-1);
            fail("Negative index should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: -1, Size: 0", e.getMessage());
        }

        try {
            linked.remove(0);
            fail("Index equal to size should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 0, Size: 0", e.getMessage());
        }

        try {
            linked.remove(1);
            fail("Index greater than size should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 1, Size: 0", e.getMessage());
        }

        linked.addLast("Spud");
        assertEquals("Spud", linked.remove(0));
        assertEquals(0, linked.size());

        try {
            linked.remove(0);
            fail("Index equal to size should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 0, Size: 0", e.getMessage());
        }

        linked.addLast("Spud");
        linked.addFirst("Chips");
        linked.addFirst("Potato");
        assertEquals(3, linked.size());
        assertEquals("Chips", linked.remove(1));
        assertEquals("Spud", linked.remove(1));
        assertEquals("Potato", linked.remove(0));
        assertEquals(0, linked.size());
    }

    @Test
    public void add() throws Exception {
        LinkedList<String> linked = new LinkedList<>();

        try {
            linked.add("Whelks", -1);
            fail("Negative index should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: -1, Size: 0", e.getMessage());
        }

        try {
            linked.add("Whelks", 1);
            fail("Index greater than size should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 1, Size: 0", e.getMessage());
        }

        linked.add("Whelks", 0);
        assertEquals(1, linked.size());
        linked.add("Cockles", 1);
        assertEquals(2, linked.size());
        linked.add("Muscles", 0);
        assertEquals(3, linked.size());
        linked.add("Winkles", 1);
        assertEquals(4, linked.size());
        assertEquals("Muscles", linked.get(0));
        assertEquals("Winkles", linked.get(1));
        assertEquals("Whelks", linked.get(2));
        assertEquals("Cockles", linked.get(3));
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