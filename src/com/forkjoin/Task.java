package com.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {

    private int start;
    private int end;
    private double increment;
    private static final int REFERENCE_SIZE  = 10;
    private List<Product> products;

    public Task(List<Product> products, int start, int end, double increment) {
        this.products = products;
        this.start = start;
        this.end = end;
        this.increment = increment;
    }

    /**
     * if a synchronous method is called while invoking sub-tasks, that will allow the ForkJoinPool class to use the
     * work-stealing algorithm to assign a new task to the worker thread that executed the sleeping task.
     */
    @Override
    protected void compute() {

        int diff = end - start;
        if (diff > REFERENCE_SIZE) {
            // divide tasks in sub tasks

            int mid = (start + end)/2;
            System.out.println("Pending Tasks : " + getQueuedTaskCount());
            Task t1 = new Task(products, start, mid+1, increment);
            Task t2 = new Task(products, mid+1, end, increment);
            invokeAll(t1, t2); // this is a synchronous execution and hence, blocking

        } else {
            // compute the task
            incrementProduct();
        }
    }

    private void incrementProduct() {
        for (int i = start; i < end; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice() + increment);
        }
    }
}
