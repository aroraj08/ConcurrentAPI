package com.multithreading.evenodd;

public class OddThread implements Runnable {

    private Printer printer;

    public OddThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {

        for (int i=1; i<=10; i=i+2) {

            synchronized (printer) {

                while (printer.printOdd == false) {
                    try {
                        printer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printer.print(i, Thread.currentThread().getName());
                printer.printOdd = false;
                printer.notify();

            }
        }
    }
}
