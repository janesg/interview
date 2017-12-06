package com.devxpress;

import java.util.function.BiFunction;

public class LinkedList<T> {

    private Node<T> head = null;
    private int size = 0;

    public void addFirst(T data) {
        this.head = new Node<>(data, this.head);
        this.size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        // Check for empty list
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> n = this.head;

            while (n.next != null) {
                n = n.next;
            }

            n.next = newNode;
        }

        this.size++;
    }

    public int size() {
        return this.size;
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
        this.size = 0;
    }

    public T removeFirst() {
        T result = null;

        if (this.head != null) {
            result = this.head.data;
            this.head = this.head.next;
            this.size--;
        }

        return result;
    }

    public T removeLast() {
        T result = null;

        // Check for empty list
        if (this.head != null) {
            // Check for single item list
            if (this.head.next == null) {
                result = this.head.data;
                this.head = null;
            } else {
                Node<T> n = this.head;

                while (n.next != null) {
                    if (n.next.next == null) {
                        result = n.next.data;
                        n.next = null;
                    } else {
                        n = n.next;
                    }
                }
            }

            this.size--;
        }

        return result;
    }

    public T get(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        Node<T> n = this.head;

        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        return n.data;
    }

    public T remove(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        if (index == 0) {
            return this.removeFirst();
        } else if (index == this.size - 1) {
            return this.removeLast();
        }

        // If we get to here then we know that the node to be
        // removed has nodes both before and after it
        Node<T> n = this.head;

        // Find the node previous to the one to be removed
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
        }

        Node<T> remove = n.next;
        n.next = remove.next;
        this.size--;

        return remove.data;
    }

    public void add(T data, int index) {
        // In this scenario we can specify an index equal to the size
        // so handle head and tail additions before checking for valid element index
        if (index == 0) {
            this.addFirst(data);
            return;
        } else if (index == this.size) {
            this.addLast(data);
            return;
        }

        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        // If we get to here then we know that the node to be
        // added has nodes both before and after it
        Node<T> beforeAdd = this.head;

        // Find the node previous to the one to be added
        for (int i = 0; i < index - 1; i++) {
            beforeAdd = beforeAdd.next;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> afterAdd = beforeAdd.next;
        beforeAdd.next = newNode;
        newNode.next = afterAdd;
        this.size++;
    }

    public void forEach(BiFunction<? super T, ? super Integer, ? extends T> f) {
        Node<T> n = this.head;

        for (int i = 0; i < this.size; i++) {
            n.data = f.apply(n.data, i);
            n = n.next;
        }
    }

    public T mid() {
        if (this.size == 0) {
            return null;
        }

        Node<T> slow = this.head;
        Node<T> fast = this.head;

        // Checking fast pointer's next and next.next handles
        // case for both odd and even number of elements.
        // In case of even number of elements we want to return
        // the element at the end of the first half.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // Note: an instance of this LinkedList class can never be circular
    // because Node is a private class never exposed in the API.
    // For the purposes of interview questions this is how it would be implemented
    // if it were possible.
    public boolean isCircular() {
        if (this.size <= 1) {
            return false;
        }

        Node<T> slow = this.head;
        Node<T> fast = this.head.next;

        while (fast.next != null && fast.next.next != null) {
            if (slow.equals(fast)) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    // Assumption is that offset should be less than size of list
    public T fromLast(int offset) {
        if (offset >= this.size) {
            throw new IllegalArgumentException("Offset: " + offset + ", Size: " + this.size);
        }

        Node<T> slow = this.head;
        Node<T> fast = this.head;

        // Initialise by moving fast forward 'offset' nodes
        for (int i = 0; i < offset; i++) {
            fast = fast.next;
        }

        // Now advance both at same rate until fast looking at the end node
        // At that point slow will be looking at the node required
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    private boolean isElementIndex(int idx) {
        return idx >= 0 && idx < this.size;
    }

    @Override
    public String toString() {
        return "{head: => " + (this.head == null ? "NULL" : this.head.toString()) + "}";
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data) {
            this(data, null);
        }

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[data: <" + this.data.toString() + "> next => " + (this.next == null ? "NULL" : this.next.toString()) + "]";
        }
    }

}

