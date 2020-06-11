package com.multithreading.waitnotify;

import java.util.Date;

public class EventStoreRemoveThread implements  Runnable {

    private EventStore eventStore;

    public EventStoreRemoveThread(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void run() {

        for (int i=0; i<= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " removing event from store");
            System.out.println(eventStore.getEventFromStore());
        }
    }
}
