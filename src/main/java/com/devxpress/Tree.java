package com.devxpress;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Tree<T> {

    private final Node<T> root;

    public Tree(T data) {
        this.root = new Node<>(data);
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void traverseBF(Consumer<Node<T>> func) {
        List<Node<T>> nodeList = new ArrayList<>();
        nodeList.add(this.root);

        while (!nodeList.isEmpty()) {
            Node<T> node = nodeList.remove(0);
            // Add to end of list
            nodeList.addAll(node.children);
            func.accept(node);
        }
    }

    public void traverseDF(Consumer<Node<T>> func) {
        List<Node<T>> nodeList = new ArrayList<>();
        nodeList.add(this.root);

        while (!nodeList.isEmpty()) {
            Node<T> node = nodeList.remove(0);
            // Add to start of list
            nodeList.addAll(0, node.children);
            func.accept(node);
        }
    }

    static class Node<T> {
        private final T data;
        private final List<Node<T>> children;

        Node(T data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        T getData() {
            return this.data;
        }

        List<Node<T>> getChildren() {
            return new ArrayList<>(this.children);
        }

        void add(T data) {
            this.children.add(new Node<>(data));
        }

        void remove(T data) {
            this.children.removeAll(this.children.stream().
                                filter(e -> e.data.equals(data)).
                                collect(Collectors.toList()));
        }

        static int[] levelWidth(Node root) {
            List<Integer> counts = new ArrayList<>();

            List<Node> currentLevel = new ArrayList<>();
            List<Node> nextLevel = new ArrayList<>();

            // Prime the current level for the root node
            currentLevel.add(root);
            counts.add(0);

            while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
                // Remove first node at current level
                Node node = currentLevel.remove(0);
                // Increment the last counter
                counts.set(counts.size() - 1, counts.get(counts.size() - 1) + 1);
                // Stick children in next level list
                nextLevel.addAll(node.children);

                if (currentLevel.isEmpty()) {
                    // Check whether there is a next level
                    if (!nextLevel.isEmpty()) {
                        // Start of the next level so add counter
                        counts.add(0);
                        // Now swap current and next
                        List<Node> temp = currentLevel;
                        currentLevel = nextLevel;
                        nextLevel = temp;
                    }
                }
            }

            return counts.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
