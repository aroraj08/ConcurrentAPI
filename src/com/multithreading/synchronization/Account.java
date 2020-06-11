package com.multithreading.synchronization;

public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        this.balance = this.balance - amount;
        System.out.println("balance after withdraw : " + balance);
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
