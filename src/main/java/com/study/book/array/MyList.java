package com.study.book.array;

public class MyList<E> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public MyList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        if (size == elements.length) {
            this.resize();
        }
        elements[size++] = element;
    }

    public E get(int index) {
        if (index < 0 || this.size >= elements.length) {
            throw new ArrayIndexOutOfBoundsException("throw");
        }

        return (E) elements[index];
    }

    public void resize() {
        int newCapacity = INITIAL_CAPACITY * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0,  newElements, 0, elements.length);
        elements = newElements;
    }
}
