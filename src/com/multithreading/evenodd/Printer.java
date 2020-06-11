package com.multithreading.evenodd;

public class Printer {

    public volatile boolean printOdd;

    public void print(int number, String threadName) {
        System.out.println(threadName + " printing " + number);
    }
}
