package com.executors;

import java.util.Date;

public class Task implements Runnable{

    private final String name;
    private final Date initDate;

    public Task(String name, Date initDate) {
        this.name = name;
        this.initDate = initDate;
    }

    @Override
    public void run() {

        System.out.println(String.format("%s running task $s at time %s",
                Thread.currentThread().getName(), name, initDate));

    }
}
