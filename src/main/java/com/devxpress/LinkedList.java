package com.devxpress;

public class LinkedList<T> {

    private Node<T> head = null;

    public void addFirst(T data) {
        Node<T> n = new Node<>(data);

        // Add new node before current head
        if (this.head == null) {
            this.head = n;
        } else {
            n.next = this.head;
            this.head = n;
        }
    }

    public int size() {
        int count = 0;
        Node<T> n = this.head;

        while (n != null) {
            count++;
            n = n.next;
        }

        return count;
    }

    public T getFirst() {
        return (this.head != null) ? this.head.data : null;
    }

    public T getLast() {
        if (this.head == null) {
            return null;
        }

        Node<T> n = this.head;

        while (n.next != null) {
            n = n.next;
        }

        return n.data;
    }

    public void clear() {
        this.head = null;
    }

    public T removeFirst() {
        T result = null;

        if (this.head != null) {
            result = this.head.data;
            this.head = this.head.next;
        }

        return result;
    }

    public T removeLast() {
        T result = null;

        Node<T> n = this.head;

        while (n.next != null) {
            if (n.next.next == null) {
                result = n.next.data;
                n.next = null;
            } else {
                n = n.next;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "{head: => " + (this.head == null ? "NULL" : this.head.toString()) + "}";
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[data: <" + this.data.toString() + "> next => " + (this.next == null ? "NULL" : this.next.toString()) + "]";
        }
    }

}

