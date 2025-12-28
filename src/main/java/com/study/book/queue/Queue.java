package com.study.book.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // enqueue
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.size++;
    }

    // dequeue
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T returnData = this.head.data;
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;
        }

        this.size--;
        return returnData;
    }

    // peek
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return this.head.data;
    }

    // isEmpty
    public boolean isEmpty() {
        return this.head == null;
    }

    // size
    public int size() {
        return this.size;
    }

    // main 함수에서 테스트
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        System.out.println("Enqueuing A, B, C...");
        queue.enqueue("A"); // A
        queue.enqueue("B"); // A -> B
        queue.enqueue("C"); // A -> B -> C

        System.out.println("Current front (peek): " + queue.peek()); // A
        System.out.println("Current size: " + queue.size()); // 3

        System.out.println("Dequeuing item: " + queue.dequeue()); // A
        System.out.println("Current front (peek): " + queue.peek()); // B

        System.out.println("Dequeuing item: " + queue.dequeue()); // B
        System.out.println("Dequeuing item: " + queue.dequeue()); // C

        System.out.println("Is queue empty? " + queue.isEmpty()); // true
    }
}
