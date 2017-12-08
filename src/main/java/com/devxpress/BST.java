package com.devxpress;

public class BST<T extends Comparable<T>> {

    private final Node<T> root;

    public BST(T data) {
        this.root = new Node<>(data);
    }

    public Node<T> getRoot() {
        return this.root;
    }

    @Override
    public String toString() {
        return "BST{" +
                "root=" + root +
                '}';
    }

    public static class Node<T extends Comparable<T>> {
        private final T data;
        private Node<T> left = null;
        private Node<T> right = null;

        public Node(T data) {
            this.data = data;
        }

        public void add(T data) {
            if (data != null && data.compareTo(this.data) != 0) {
                if (data.compareTo(this.data) < 0) {
                    if (this.left != null) {
                        this.left.add(data);
                    } else {
                        this.left = new Node<>(data);
                    }
                } else {
                    if (this.right != null) {
                        this.right.add(data);
                    } else {
                        this.right = new Node<>(data);
                    }
                }
            }
        }

        public boolean contains(T data) {
            if (data == null) {
                return false;
            }

            if (data.compareTo(this.data) != 0) {
                if (data.compareTo(this.data) < 0) {
                    return this.left != null && this.left.contains(data);
                } else {
                    return this.right != null && this.right.contains(data);
                }
            } else {
                return true;
            }
        }

        public boolean validate() {
            return validationHelper(this, null, null);
        }

        private boolean validationHelper(Node<T> node, T minValue, T maxValue) {

            // If max is specified, current node value cannot be greater than max
            if (maxValue != null && node.data.compareTo(maxValue) > 0) {
                return false;
            }

            // If min is specified, current node value cannot be less than min
            if (minValue != null && node.data.compareTo(minValue) < 0) {
                return false;
            }

            // Processing left so pass a maximum valid value
            if (node.left != null && !validationHelper(node.left, null, node.data)) {
                return false;
            }

            // Processing right so pass a minimum valid value
            if (node.right != null && !validationHelper(node.right, node.data, null)) {
                return false;
            }

            return true;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", L=" + left +
                    ", R=" + right +
                    '}';
        }
    }
}
