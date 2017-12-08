package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void testTraverseBF() throws Exception {

        List<String> results = new ArrayList<>();
        List<String> expectedResults = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i");

        Tree<String> tree = new Tree<>("a");
        Tree.Node<String> root = tree.getRoot();

        root.add("b");
        root.add("c");
        root.add("d");

        root.getChildren().get(0).add("e");
        root.getChildren().get(0).add("f");
        root.getChildren().get(0).add("g");
        root.getChildren().get(2).add("h");
        root.getChildren().get(2).add("i");

        tree.traverseBF(node -> results.add(node.getData()));

        assertEquals(expectedResults, results);
    }

    @Test
    public void testTraverseDF() throws Exception {

        List<String> results = new ArrayList<>();
        List<String> expectedResults = Arrays.asList("a", "b", "e", "f", "g", "c", "d", "h", "i");

        Tree<String> tree = new Tree<>("a");
        Tree.Node<String> root = tree.getRoot();

        root.add("b");
        root.add("c");
        root.add("d");

        root.getChildren().get(0).add("e");
        root.getChildren().get(0).add("f");
        root.getChildren().get(0).add("g");
        root.getChildren().get(2).add("h");
        root.getChildren().get(2).add("i");

        tree.traverseDF(node -> results.add(node.getData()));

        assertEquals(expectedResults, results);
    }

    @Test
    public void testRemove() throws Exception {

        List<String> results = new ArrayList<>();
        List<String> prevRemoveExpectedResults = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i");
        List<String> postRemoveExpectedResults = Arrays.asList("a", "b", "c", "e", "f", "g");

        Tree<String> tree = new Tree<>("a");
        Tree.Node<String> root = tree.getRoot();

        root.add("b");
        root.add("c");
        root.add("d");

        root.getChildren().get(0).add("e");
        root.getChildren().get(0).add("f");
        root.getChildren().get(0).add("g");
        root.getChildren().get(2).add("h");
        root.getChildren().get(2).add("i");

        tree.traverseBF(node -> results.add(node.getData()));
        assertEquals(prevRemoveExpectedResults, results);

        results.clear();

        root.remove("d");
        tree.traverseBF(node -> results.add(node.getData()));
        assertEquals(postRemoveExpectedResults, results);
    }

    @Test
    public void testLevelWidth() throws Exception {

        int[] expectedResults = new int[]{ 1, 3, 5 };

        Tree.Node<String> root = new Tree.Node<>("a");

        root.add("b");
        root.add("c");
        root.add("d");

        root.getChildren().get(0).add("e");
        root.getChildren().get(0).add("f");
        root.getChildren().get(0).add("g");
        root.getChildren().get(2).add("h");
        root.getChildren().get(2).add("i");

        int[] results = Tree.Node.levelWidth(root);

        assertArrayEquals(expectedResults, results);
    }

    @Test
    public void testJavaScript() throws Exception {
        treeJavaScript("testTree");
    }

    public static Void treeJavaScript(String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/tree.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (Void) ((Invocable) engine).invokeFunction(functionName);
    }

}