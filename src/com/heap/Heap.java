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

    public void delete(int indexToRemove) {

        int lastIndex = size-1;
        array[indexToRemove] = array[lastIndex];

        size--;

        if (indexToRemove > 0 &&
                array[indexToRemove] > array[getParentIndex(indexToRemove)]) {
            // check fix heap above
            fixHeapAbove(indexToRemove);
        } else {

            while(indexToRemove <= size) {
                // get left child
                int leftChildIndex = getChild(indexToRemove, true);
                // get right child
                int rightChildIndex = getChild(indexToRemove, false);

                boolean isLeftIndexInbound = true;
                boolean isRightIndexInbound = true;
                if (leftChildIndex > size) {
                    isLeftIndexInbound = false;
                }
                if (rightChildIndex > size) {
                    isRightIndexInbound = false;
                }

                if (isLeftIndexInbound && isRightIndexInbound) {
                    // comparison
                    if (array[leftChildIndex] > array[rightChildIndex]) {
                        array[indexToRemove] = array[leftChildIndex];
                        indexToRemove = leftChildIndex;
                    } else {
                        array[indexToRemove] = array[rightChildIndex];
                        indexToRemove = rightChildIndex;
                    }
                } else if (isLeftIndexInbound) {
                    // just swap with leftChildIndex
                    array[indexToRemove] = array[leftChildIndex];
                    indexToRemove = leftChildIndex;
                }
            }
        }
    }

    private int getChild(int index, boolean isLeft) {
        return (index*2) + (isLeft ? 1 : 2);
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
    public void print() {
        System.out.println();
        for(int a : array) {
            System.out.print(a + " ");
        }

    }
}
