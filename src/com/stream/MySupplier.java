package com.stream;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class MySupplier implements Supplier {

    private AtomicInteger counter;

    public MySupplier(int initialValue) {
        counter = new AtomicInteger(initialValue);
    }

    @Override
    public String get() {
        int value = this.counter.getAndAdd(1);
        return "String " + value;
    }
}
