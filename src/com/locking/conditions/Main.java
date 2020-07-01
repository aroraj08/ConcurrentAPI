package com.locking.conditions;

public class Main {

    public static void main(String[] args) {
        FileMock file = new FileMock(100, 5);
        Buffer buffer = new Buffer(5);

        Producer producer = new Producer(buffer, file);
        Thread producerThread = new Thread(producer);

        /*
        Consumer consumer = new Consumer(buffer);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        */

        Consumer consumers[] = new Consumer[3];
        Thread consumersThreads[] = new Thread[3];

        for (int i=0; i<3; i++){
            consumers[i] = new Consumer(buffer);
            consumersThreads[i] = new Thread(consumers[i],"Consumer "+i);
        }

        producerThread.start();
        for (int i = 0; i< 3; i++){
            consumersThreads[i].start();
        }
    }
}
