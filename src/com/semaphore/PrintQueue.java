package com.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private final Semaphore semaphore;
    private final Lock lock;
    private final boolean[] freePrinters;

    public PrintQueue() {
        this.semaphore = new Semaphore(3);
        this.lock = new ReentrantLock(true);
        this.freePrinters = new boolean[3];
        for (int i=0; i<freePrinters.length; i++) {
            freePrinters[i] = true;
        }
    }

    public void printJob(Object document) {

        try {
            this.semaphore.acquire();

            int printerIndex = getPrinter();
            System.out.println("Printing job with printer having index : " + printerIndex);
            TimeUnit.SECONDS.sleep(2);
            freePrinters[printerIndex] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.semaphore.release();
        }

    }

    private int getPrinter() {

        this.lock.lock();
        try{
            for (int i=0; i<freePrinters.length; i++) {
                if (freePrinters[i] == true) {
                    freePrinters[i] = false;
                    return i;
                }
            }
        } finally {
            this.lock.unlock();
        }
        return -1;
    }


}
