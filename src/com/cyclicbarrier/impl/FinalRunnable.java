package com.cyclicbarrier.impl;

import java.util.List;
import java.util.Map;

public class FinalRunnable implements Runnable{

    private final Result result;

    public FinalRunnable(Result result) {
        this.result = result;
    }

    @Override
    public void run() {

        List<String> resultList = result.getResult();
        System.out.println("Result ---> ");
        resultList
                .stream()
                .forEach(System.out :: println);
    }
}
