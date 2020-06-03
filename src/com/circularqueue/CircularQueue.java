package com.circularqueue;

import java.util.NoSuchElementException;

public class CircularQueue<T> {

    private T[] arr;
    private int size;
    private int front;
    private int back;

    public CircularQueue(int initialCapacity) {
        arr = (T[]) new Object[initialCapacity];
    }

    public void add(T element) {

        if (size() == arr.length -1) {  // this is when we need to resize the array

            T[] newArr = (T[]) new Object[2 * arr.length];
            System.arraycopy(arr, front, newArr, 0,arr.length - front);
            System.arraycopy(arr, 0, newArr, arr.length - front, back);

            // after array is resized, we need to change front and back pointers
            arr = newArr;
            front = 0;
            back = size();
        }

        arr[back] = element;
        if (back == arr.length -1) {
            back =0;
        } else {
            back++;
        }
    }

    public T remove() {

        if (size() == 0) {
            throw new NoSuchElementException("no elements in queue");
        }

        T element = arr[front];
        arr[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == arr.length) {
            front = 0;
        }
        return element;
    }

    public T peek() {

        if (size() == 0) {
            throw new NoSuchElementException("no elements in queue");
        }
        return arr[front];
    }

    public int size() {

        if (front < back) {
            return back - front;
        } else {
            return back - front + arr.length;
        }
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(arr[i]);
            }
        }
        else {
            for (int i = front; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(arr[i]);
            }
        }
    }

}
