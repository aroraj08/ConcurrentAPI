package com.multithreading.synchronization;

public class Main {

    public static void main(String[] args) {

        Account account = new Account(50);
        AccountOperations ops = new AccountOperations(account);

        Thread t1 = new Thread(ops);
        Thread t2 = new Thread(ops);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance());

    }
}
