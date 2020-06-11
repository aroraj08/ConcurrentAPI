package com.multithreading.evenodd;

public class EvenThread implements Runnable {

    private Printer printer;

    public EvenThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {

        for (int i=2; i<=10; i=i+2) {

            synchronized (printer) {

                while (printer.printOdd == true) {
                    try {
                        printer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printer.print(i, Thread.currentThread().getName());
                printer.printOdd = true;
                printer.notify();

            }
        }
    }
}
