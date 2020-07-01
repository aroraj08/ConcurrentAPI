package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Participant implements Runnable {

    private final CountDownLatch countDownLatch;

    private final int counter;

    public Participant(CountDownLatch countDownLatch, int counter) {
        this.countDownLatch = countDownLatch;
        this.counter = counter;
    }

    @Override
    public void run() {

        try {
            if (counter == 25) {
                throw new RuntimeException("exception occurred..");
            }
            System.out.println(Thread.currentThread().getName() + " : " + "participated" );
        } finally {
            this.countDownLatch.countDown();
        }
    }
}
