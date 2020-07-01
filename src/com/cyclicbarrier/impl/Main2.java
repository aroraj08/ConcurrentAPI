package com.cyclicbarrier.impl;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main2 {

    public static void main(String[] args) {

        int[][] matrix = new int[10][10];
        Random random = new Random();

        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }

        for (int i=0; i<10; i++) {
            System.out.println();
            for (int j=0; j<10; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }

        RowProcessor[] rowProcessors = new RowProcessor[10];

        Result result = new Result();
        FinalRunnable runnable = new FinalRunnable(result);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, runnable);

        for (int i=0; i < rowProcessors.length; i++) {
            rowProcessors[i] = new RowProcessor(cyclicBarrier, matrix[i], i, 5, result);
        }

        //ThreadPoolExecutor executor =
          //      (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor executor =
        (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        for (int i=0; i<rowProcessors.length; i++) {
            executor.submit(rowProcessors[i]);
        }

        System.out.println("I am here...");
        executor.shutdown();

    }
}
