package com.heap;

public class Heap {

    int[] array;
    int size;

    public Heap(int initialCapacity) {
        array = new int[initialCapacity];
    }

    public void insert(int value) {

        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        array[size] = value;
        fixHeapAbove(size);
        size++;
    }

    private void fixHeapAbove(int index) {

        int newValue = array[index];
        while (index > 0 && newValue > array[getParentIndex(index)]) {
            array[index] = array[getParentIndex(index)];
            index = getParentIndex(index);
        }
        array[index] = newValue;
    }

    public int getParentIndex(int index) {

        return (index-1)/2;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
