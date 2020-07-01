package com.cyclicbarrier.impl;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class RowProcessor implements Runnable{

    private final CyclicBarrier cyclicBarrier;
    private final int[] row;
    private int elementToSearch;
    private Result result;
    private int rowNum;

    public RowProcessor(CyclicBarrier cyclicBarrier, int[] row, int rowNum, int elementToSearch,
                        Result result) {
            this.row = row;
            this.cyclicBarrier = cyclicBarrier;
            this.elementToSearch = elementToSearch;
            this.result = result;
            this.rowNum = rowNum;
    }

    @Override
    public void run() {

        try {
            // process and search for data

            if (rowNum == 5) {
                throw new RuntimeException("exception occurred");
            }
            for (int i=0; i<row.length; i++) {
                if (row[i] == elementToSearch) {
                    synchronized (result) {
                        result.addPair(rowNum, i);
                    }
                }
            }
            //TimeUnit.SECONDS.sleep(1);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
