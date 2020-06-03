package com.hashmap.impl;

public class Main {

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>(4);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(2, "twoo");
        map.put(5, "five");

        System.out.println(map.size());

        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(5));

    }
}
