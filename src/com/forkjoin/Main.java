package com.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        List<Product> productList = ProductGenerator.getProducts(10000);
        Task task = new Task(productList, 0, productList.size(), 2.0);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //forkJoinPool.invoke(task);
        forkJoinPool.execute(task);
        do {
            System.out.printf("Main: Thread Count:%d\n",
                    forkJoinPool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal:%d\n",
                    forkJoinPool.getStealCount());
            System.out.printf("Main: Parallelism:%d\n",
                    forkJoinPool.getParallelism());
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        forkJoinPool.shutdown();
        if (task.isCompletedNormally()) {
            System.out.println("The process has completed normally");
        }

        for (int i=0; i<productList.size(); i++){
            Product product=productList.get(i);
            if (product.getPrice()!=12) {
                System.out.printf("Product %s: %f\n",
                        product.getName(),product.getPrice());
            }
        }

        System.out.println("Main: end of program");
    }
}
