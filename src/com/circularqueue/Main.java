package com.circularqueue;

public class Main {

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.remove();
        queue.remove();
        queue.add(5);
        queue.add(6);

        System.out.println(queue.size());
        queue.printQueue();
    }
}
