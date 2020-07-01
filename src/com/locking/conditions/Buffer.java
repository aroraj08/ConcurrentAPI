package com.locking.conditions;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private final LinkedList<String> buffer;
    private final int maxSize;
    private final Lock lock;
    private final Condition space;
    private final Condition lines;
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines =true;
    }

    public void insert(String value) {
        this.lock.lock();

        try {
            while (buffer.size() == maxSize) {
                try {
                    space.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.offer(value);
            System.out.printf("%s: Inserted Line: %d : %s\n",
                    Thread.currentThread().getName(),
                    buffer.size(), value);
            lines.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    public String get() {
        String line = null;
        this.lock.lock();
        try {

            while (buffer.size() == 0 && hasPendingLines()) {
                try {
                    lines.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (hasPendingLines()) {
                line = buffer.removeFirst();
                System.out.printf("%s: Line Readed: %d : %s\n",
                        Thread.currentThread().getName(),
                        buffer.size(), line);
                space.signalAll();
            }
        } finally {
            this.lock.unlock();
        }

        return line;
    }

    public synchronized boolean hasPendingLines() {
        boolean hasPendingLines = this.pendingLines || buffer.size() > 0;
        return hasPendingLines;
    }

    public synchronized void setPendingLines(boolean hasPendingLines) {
        this.pendingLines = hasPendingLines;
    }
}
