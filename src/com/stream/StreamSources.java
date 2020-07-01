package com.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamSources {

    public static void main(String[] args) {

        // using generate
        Supplier<String> mySupplier = new MySupplier(1);
        Stream.generate(mySupplier)
                .limit(50)
                .forEach(System.out :: println);

        // using of
        Stream.of("Jatin", "Kapil", "Arora")
                .forEach(System.out :: println);

        // creating stream from Array
        Arrays.stream(new Integer[]{1,2,3,4,5,6})
               .mapToInt(s -> s)
                .min();

        // stream of random Double numbers
        Random random = new Random();
        DoubleStream  doubleStream = random.doubles(10);
        Double optionalDouble = doubleStream
                .peek(System.out :: println)
                .average()
                .getAsDouble();

        System.out.println(optionalDouble);

        // Concatenation two streams
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> stream2 = Stream.of(4, 5, 6, 7, 8);
        Stream<Integer> finalStream = Stream.concat(stream1, stream2);
        finalStream.forEach(System.out :: println);
     }
}
