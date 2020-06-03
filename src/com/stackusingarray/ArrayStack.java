package com.stackusingarray;

public class ArrayStack {

    private Employee[] arr;
    private int top;

    public ArrayStack(int capacity) {
        arr = new Employee[capacity];
    }

    public void push(Employee obj) {
        if (top == arr.length -1 ) {
            // array is full and needs resizing
            Employee[] newArr = new Employee[2 * arr.length];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }

        arr[top++] = obj;
    }

    public Employee pop() {

        if (top == 0) {
            throw new RuntimeException("");
        }
        Employee e = arr[--top];
        arr[top] = null;
        return e;
    }

    public Employee peek() {
        if (top == 0) {
            throw new RuntimeException("");
        }
        return arr[top-1];
    }

    public int size() {
        return top;
    }
}
