package com.multithreading.waitnotify;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventStore {

    private int maxSize;
    private Queue<Date> storage;

    public EventStore(int maxSize) {
        this.maxSize = maxSize;
        this.storage = new LinkedList<>();
    }

    public void addDataToEventStore(Date data) {

        synchronized (storage) {

            while(storage.size() == maxSize) {
                try {
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.storage.add(data);
            storage.notifyAll();
        }
    }

    public Date getEventFromStore() {

        Date event = null;

        synchronized (storage) {
            while (storage.size() == 0) {
                try {
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            event = storage.poll();
            storage.notifyAll();
        }

        return event;
    }

}
