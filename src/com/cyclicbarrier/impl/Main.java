package com.cyclicbarrier.impl;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

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

        Thread[] threads = new Thread[10];
        RowProcessor[] rowProcessors = new RowProcessor[10];

        Result result = new Result();
        FinalRunnable runnable = new FinalRunnable(result);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, runnable);


        for (int i=0; i < rowProcessors.length; i++) {
            rowProcessors[i] = new RowProcessor(cyclicBarrier, matrix[i], i, 5, result);
            threads[i] = new Thread(rowProcessors[i]);
            threads[i].start();
        }

        System.out.println("I am here..");
    }
}
