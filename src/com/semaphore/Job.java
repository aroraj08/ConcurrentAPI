package com.semaphore;

public class Job implements Runnable{

    private PrintQueue printQueue;
    private final Object document;

    public Job(PrintQueue printQueue, Object document) {
        this.printQueue = printQueue;
        this.document = document;
    }

    @Override
    public void run() {
        this.printQueue.printJob(document);
    }
}
