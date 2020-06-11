package com.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    private ThreadPoolExecutor executor;

    public Server() {
        this.executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.executor.setRejectedExecutionHandler(new RejectedTaskController());
    }

    public void runTask(Task task) {
        executor.execute(task);
    }

    public void stopServer() {
        executor.shutdown();
    }
}
