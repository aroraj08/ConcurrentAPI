package com.locking;

public class Job implements Runnable{

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        printQueue.printJob("This is a sample document");
    }
}
