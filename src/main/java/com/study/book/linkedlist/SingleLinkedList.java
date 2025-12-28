package com.study.book.linkedlist;

public class SingleLinkedList<T> {

    private Node<T> head;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> current = this.head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        this.size++;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("유효하지 않은 index: " + index);
        }

        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public int size() {
        return this.size;
    }

    public void print() {
        if (this.head == null) {
            System.out.println("[]");
            return;
        }

        Node<T> current = this.head;
        System.out.print("[");
        while (current.next != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println(current.data + "]");
    }

    public static void main(String[] args) {
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.add("apple");
        linkedList.add("orange");
        linkedList.add("pineApple");

        linkedList.print();
        System.out.println("사이즈: " + linkedList.size());
        System.out.println("첫 번째 요소의 data: " +linkedList.get(0));
    }
}
