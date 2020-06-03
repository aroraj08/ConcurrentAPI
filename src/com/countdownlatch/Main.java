package com.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        List<Participant> participantList = new ArrayList<>(50);

        CountDownLatch countDownLatch = new CountDownLatch(50);
        IntStream.iterate(1, n -> n+1)
                .limit(50)
                .forEach(n -> participantList.add(new Participant(countDownLatch)));

        VideoConference videoConference = new VideoConference(participantList, countDownLatch);
        Thread videoConThread = new Thread(videoConference);
        videoConThread.start();

        participantList.forEach(p -> {
            new Thread(p).start();
        });

    }
}
