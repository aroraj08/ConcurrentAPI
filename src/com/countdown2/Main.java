package com.countdown2;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(10);
        VideoConference conference = new VideoConference(countDownLatch);

        Thread threadConference = new Thread(conference);
        threadConference.start();

        for (int i=0; i<10; i++){
            Participant p=new Participant(conference, "Participant "+i);
            Thread t=new Thread(p);
            t.start();
        }
    }
}
