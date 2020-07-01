package com.locking.conditions;

public class Producer implements Runnable{

    private final Buffer buffer;
    private final FileMock file;

    public Producer(Buffer buffer, FileMock file) {
        this.buffer = buffer;
        this.file = file;
    }

    @Override
    public void run() {

        buffer.setPendingLines(true);
        while (file.hasMoreLines()) {
            String line = file.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
