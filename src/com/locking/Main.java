package com.locking;

public class Main {

    public static void main(String[] args) {

        PrintQueue printQueue = new PrintQueue(false);
        Job[] jobs = new Job[5];
        /*for (Job job : jobs) {
            job = new Job(printQueue);
        }*/

        for (int i=0; i<jobs.length; i++) {
            jobs[i] = new Job(printQueue);
        }

        Thread[] threads = new Thread[5];

        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(jobs[i]);
            threads[i].start();
        }

        for(int i=0; i<threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
