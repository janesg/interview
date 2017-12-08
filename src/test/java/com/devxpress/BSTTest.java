package com.devxpress;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class BSTTest {

    @Test
    public void add() {
        BST<Integer> bst = new BST<>(27);
        BST.Node<Integer> root = bst.getRoot();

        root.add(56);
        root.add(58);
        root.add(30);
        root.add(57);

        assertEquals("BST{root=Node{data=27, L=null, R=Node{data=56, L=Node{data=30, L=null, R=null}, R=Node{data=58, L=Node{data=57, L=null, R=null}, R=null}}}}",
                     bst.toString());
    }

    @Test
    public void contains() {
        BST<Integer> bst = new BST<>(27);
        BST.Node<Integer> root = bst.getRoot();

        root.add(56);
        root.add(58);
        root.add(30);
        root.add(57);

        assertTrue(root.contains(30));
        assertFalse(root.contains(-12));
        assertTrue(root.contains(27));
        assertFalse(root.contains(55));
    }

    @Test
    public void validate() {
        BST<Integer> bst = new BST<>(27);
        BST.Node<Integer> root = bst.getRoot();

        root.add(56);
        root.add(58);
        root.add(30);
        root.add(57);

        assertTrue(root.validate());

        // As we don't have access to the left and right nodes of a node
        // it is not possible to construct an invalid node graph
    }

    @Test
    public void testJavaScript() throws Exception {
        bstJavaScript("testBST");
    }

    public static Void bstJavaScript(String functionName) throws Exception {

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
                                     loader.getResourceAsStream("js/bst.js")))) {
            engine.eval(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JavaScript file: " + e.getMessage());
        }

        // Call the JavaScript function by name passing source String as parameter
        return (Void) ((Invocable) engine).invokeFunction(functionName);
    }

}