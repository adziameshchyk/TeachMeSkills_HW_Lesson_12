package com.tms.collections_and_generic.additional_task.models;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList<T> {

    private Object[] elements;
    public int size = 0;

    public CustomArrayList() {
        this.elements = new Object[10];
    }

    public CustomArrayList(int capacity) {
        this.elements = new Object[capacity];
    }

    public void add(Object element) {
        if (this.size + 1 <= elements.length) {
            this.elements[this.size++] = element;
        } else {
            increaseCapacity();
            add(element);
        }
    }

    public void delete(Object element) {
        int deleteIndex;
        for (deleteIndex = 0; deleteIndex < this.size; deleteIndex++) {
            if (elements[deleteIndex].equals(element)) {
                System.arraycopy(elements, deleteIndex + 1, elements, deleteIndex, this.size - 1 - deleteIndex);
                elements[--this.size] = null;
            }
        }
    }

    public int indexOf(Object element) {
        for (int i = 0; i < this.size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    public void clear() {
        for (int i = 0; i < this.size; i++) {
            elements[i] = null;
        }
        this.size = 0;
    }

    @Override
    public String toString() {
        Object[] trimElements = new Object[this.size];
        System.arraycopy(this.elements, 0, trimElements, 0, this.size);
        return Arrays.toString(trimElements);
    }

    public void increaseCapacity() {
        Object[] newElements = new Object[elements.length / 2 * 3 + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        this.elements = newElements;
    }
}
