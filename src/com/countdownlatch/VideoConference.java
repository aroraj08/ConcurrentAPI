package com.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable{

    private final List<Participant> participants;
    private final CountDownLatch countDownLatch;

    public VideoConference(List<Participant> participants, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.participants = participants;
    }

    @Override
    public void run() {
        System.out.println("Waiting for all participants to join...");
        try {
            this.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Starting presentation");
    }
}
