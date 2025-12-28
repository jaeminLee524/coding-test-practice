package com.study.book.linkedlist;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<T> {

        Node<T> prev;
        T data;
        Node<T> next;

        public Node(T data) {
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        this.size++;
    }

    public boolean remove(T data) {
        Node<T> current = this.head;

        while (current != null) {
            if (current.data.equals(data)) {
                // 노드를 찾았기에 삭제 진행
                Node<T> prevNode = current.prev;
                Node<T> nextNode = current.next;

                // 1. 삭제 할 노드가 head 인 경우
                if (prevNode == null) {
                    this.head = prevNode;
                } else {
                    prevNode.next = nextNode;
                }

                // 2. 삭제 할 노드가 tail 인 경우
                if (nextNode == null) {
                    this.tail = prevNode;
                } else {
                    nextNode.prev = prevNode;
                }

                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void printForward() {
        System.out.print("Forward: [");
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.data + (current.next == null ? "" : ", "));
            current = current.next;
        }
        System.out.println("]");
    }

    public void printBackward() {
        System.out.print("Backward: [");
        Node<T> current = this.tail;
        while (current != null) {
            System.out.print(current.data + (current.prev == null ? "" : ", "));
            current = current.prev;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        linkedList.printForward();
        linkedList.printBackward();

        System.out.println("20 요소 제거 중 ");
        linkedList.remove(20);

        linkedList.printForward();
        linkedList.printBackward();
    }
}
