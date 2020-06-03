package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Participant implements Runnable {

    private final CountDownLatch countDownLatch;

    public Participant(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : " + "participated" );
        this.countDownLatch.countDown();
    }
}
