package com.multithreading.waitnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Mai {

    public static void main(String[] args) {

        EventStore eventStore = new EventStore(5);

        EventStoreAddThread add = new EventStoreAddThread(eventStore);
        EventStoreRemoveThread removeThread = new EventStoreRemoveThread(eventStore);

        Thread t1 = new Thread(add);
        Thread t2 = new Thread(removeThread);

        t1.start();;
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
