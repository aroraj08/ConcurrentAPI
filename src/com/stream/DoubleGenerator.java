package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoubleGenerator {

    public static List<Double> generateDoubleList(int size, int max) {

        Random random=new Random();
        List<Double> numbers=new ArrayList<>();

        for (int i=0; i<size; i++) {
            double value=random.nextDouble()*max;
            numbers.add(value);
        }
        return numbers;
    }
}
