package com.concurrentmodificationexception;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        List<String> avengers = new ArrayList<>();
        avengers.add("Ant-Man");
        avengers.add("Black Widow");
        avengers.add("Captain America");
        avengers.add("Doctor Strange");

        System.out.println("Simple loop example:\n");
        for (int i = 0; i < avengers.size(); i++) {
            if (avengers.get(i).equals("Doctor Strange")) {
                avengers.remove(i);
            }
            System.out.println(avengers.get(i));
        }
    }
}
