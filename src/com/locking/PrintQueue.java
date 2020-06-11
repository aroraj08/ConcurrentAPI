package com.locking;

import com.multithreading.evenodd.Printer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private Lock queueLock;
    public PrintQueue(boolean fairness) {
        this.queueLock = new ReentrantLock(fairness);
    }

    public void printJob(Object document) {
           this.queueLock.lock();

        try {
            Long duration=(long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+ ":PrintQueue: Printing a Job during "+
            (duration/1000)+" seconds");
            Thread.sleep(duration);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.queueLock.unlock();
        }

        this.queueLock.lock();
        try {
            Long duration=(long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+ ":PrintQueue: Printing a Job again during "+
                    (duration/1000)+" seconds");
            Thread.sleep(duration);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.queueLock.unlock();
        }
    }
}
