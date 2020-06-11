package com.executors;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Server server = new Server();
        for (int i=0; i<100; i++) {
            server.runTask(new Task("" + i, new Date()));
        }

        server.stopServer();

        server.runTask(new Task("aa", new Date()));
        System.out.printf("Main: End.\n");
    }
}
