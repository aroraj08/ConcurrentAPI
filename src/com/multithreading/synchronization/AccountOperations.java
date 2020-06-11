package com.multithreading.synchronization;

public class AccountOperations implements Runnable {

    private final Account account;

    public AccountOperations(Account account) {
        this.account = account;
    }

    @Override
    public void run() {

        for (int i =0; i<5; i++) {

            synchronized (this) {
                if (this.account.getBalance() >= 10) {
                    System.out.println(Thread.currentThread().getName() + " withdrawing...");
                    this.account.withdraw(10);
                }
            }

        }
    }
}
