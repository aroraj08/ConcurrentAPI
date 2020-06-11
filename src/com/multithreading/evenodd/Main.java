package com.multithreading.evenodd;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer();
        printer.printOdd = true;

        EvenThread evenThreadRunnable = new EvenThread(printer);
        OddThread oddThreadRunnable = new OddThread(printer);

        Thread t1 = new Thread(evenThreadRunnable);
        Thread t2 = new Thread(oddThreadRunnable);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
