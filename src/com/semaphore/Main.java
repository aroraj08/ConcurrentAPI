package com.semaphore;

public class Main {

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Object[] documents = new Object[10];

        for (int i=0; i< documents.length; i++) {

            documents[i] = "hey -> " + i;
            Thread t = new Thread(new Job(printQueue, documents[i]));
            t.start();
        }
    }
}
