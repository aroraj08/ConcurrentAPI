package com.countdown2;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {

    private final CountDownLatch countDownLatch;

    public VideoConference(CountDownLatch latch) {
        this.countDownLatch = latch;
    }

    public void arrive(String name){
        System.out.println("arrived :" + name);
        this.countDownLatch.countDown();
    }

    @Override
    public void run() {

        try {
            this.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Meeting started...");
    }
}
