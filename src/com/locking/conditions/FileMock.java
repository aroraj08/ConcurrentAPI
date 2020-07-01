package com.locking.conditions;

import java.util.Random;

public class FileMock {

    private String[] data;
    private int index;

    public FileMock(int size, int length) {
        data = new String[size];
        Random random = new Random();
        String allChars = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i< size; i++){
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++){
                int randomInt= random.nextInt(26) ;
                buffer.append(allChars.charAt(randomInt));
            }
            data[i] = buffer.toString();
        }
        index=0;
    }

    public boolean hasMoreLines() {
        return index < data.length;
    }

    public String getLine() {
        if (hasMoreLines()) {
            return data[index++];
        } else {
            return null;
        }
    }
}
