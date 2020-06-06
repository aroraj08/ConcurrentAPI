package com.heap;

public class Main {

    public static void main(String[] args) {

        Heap heap = new Heap(5);
        heap.insert(75);
        heap.insert(35);
        heap.insert(15);
        heap.insert(40);

        heap.print();
        heap.insert(80);
        heap.print();

        heap.delete(0);
        heap.print();
    }
}
