package com.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        List<Participant> participantList = new ArrayList<>(50);

        CountDownLatch countDownLatch = new CountDownLatch(50);

        for (int i=0; i<50; i++) {
            participantList.add(new Participant(countDownLatch, i));
        }

        VideoConference videoConference = new VideoConference(participantList, countDownLatch);
        Thread videoConThread = new Thread(videoConference);
        videoConThread.start();

        participantList.forEach(p -> {
            new Thread(p).start();
        });

        System.out.println("EOP");
    }
}
