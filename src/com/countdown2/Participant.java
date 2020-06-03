package com.countdown2;

public class Participant implements Runnable{

    private final VideoConference videoConference;
    private final String threadName;

    public Participant(VideoConference conference, String name) {
        this.videoConference = conference;
        this.threadName = name;
    }

    @Override
    public void run() {
        this.videoConference.arrive(threadName);
    }
}
