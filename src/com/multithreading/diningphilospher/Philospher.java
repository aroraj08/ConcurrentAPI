package com.multithreading.diningphilospher;

import java.util.concurrent.TimeUnit;

public class Philospher implements Runnable{

    Object leftFork, rightFork;

    public Philospher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {

        while(true) {

            doAction("thinking");
            synchronized (leftFork) {

                doAction("Picked left fork for eating");
                synchronized (rightFork) {
                    doAction("Picked right fork for eating");
                    doAction("Eating...");
                    doAction("put down right fork");
                }
                doAction("put down left fork");
            }
        }


    }

    private void doAction(String action) {

        System.out.println(Thread.currentThread().getName() + " Doing action "  + action);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
