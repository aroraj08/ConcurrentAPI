package com.multithreading.diningphilospher;

public class Main {

    public static void main(String[] args) {

        Philospher[] ph = new Philospher[5];
        Object[] forks = new Object[5];

        for (int i=0; i<forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i=0; i< ph.length; i++) {

            Object leftFork = forks[i];
            Object rightFork = forks[(i+1)%forks.length];

            if (i== ph.length-1) {
                ph[i] = new Philospher(leftFork, rightFork);
            } else {
                ph[i] = new Philospher(leftFork, rightFork);
            }

            Thread t1 = new Thread(ph[i]);
            t1.start();
        }
    }
}
