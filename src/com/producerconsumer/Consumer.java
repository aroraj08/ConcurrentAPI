package com.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> blockingQueue;
    private final String poisonPill;

    public Consumer(BlockingQueue<String> blockingQueue, String poisonPill) {
        this.blockingQueue = blockingQueue;
        this.poisonPill = poisonPill;
    }


    @Override
    public void run() {

        while(true) {
            try {
                String str = this.blockingQueue.take();
                System.out.println("Consumed : " + str);
                if (str.equals(poisonPill)) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
