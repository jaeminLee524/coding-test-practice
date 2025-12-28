package com.study.book.stack;

import java.util.EmptyStackException;

public class Stack<T> {

    private Node<T> top;
    private int size = 0;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // push
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = this.top;
        this.top = newNode;
        this.size++;
    }

    // pop
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T returnData = this.top.data;
        this.top = this.top.next;
        this.size--;

        return returnData;
    }

    // peek
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return this.top.data;
    }

    // isEmpty
    public boolean isEmpty() {
        return this.top == null;
    }

    // size
    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("Pushing 10, 20, 30...");
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Current top (peek): " + stack.peek()); // 30
        System.out.println("Current size: " + stack.size()); // 3

        System.out.println("Popping item: " + stack.pop()); // 30
        System.out.println("Popping item: " + stack.pop()); // 20

        System.out.println("Current top (peek): " + stack.peek()); // 10
        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        System.out.println("Popping item: " + stack.pop()); // 10
        System.out.println("Is stack empty? " + stack.isEmpty()); // true
    }
}
