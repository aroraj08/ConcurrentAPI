package com.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<String> blockingQueue;
    private final String poisonPill;
    private final int poisonPillPerProducer;

    public Producer(BlockingQueue<String> blockingQueue, String poisonPill, int poisonPillPerProducer) {
        this.blockingQueue = blockingQueue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    @Override
    public void run() {

        try {
            for (int i=0; i<10000; i++) {
                 blockingQueue.put("" + i);
             }
            // after this is done, add poison pill
            for (int i=0; i<poisonPillPerProducer; i++) {
                blockingQueue.put(poisonPill);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
