package com.multithreading.waitnotify;

import java.util.Date;

public class EventStoreAddThread implements Runnable{

    private EventStore eventStore;

    public EventStoreAddThread(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void run() {

        for (int i=0; i<= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " adding event to store");
            eventStore.addDataToEventStore(new Date());
        }
    }
}
