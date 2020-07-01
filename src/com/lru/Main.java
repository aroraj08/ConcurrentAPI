package com.lru;

public class Main {

    public static void main(String[] args) {

        LRUCache<String, Integer> cache = LRUCache.getInstance(4);
        cache.put("A" , 1);
        cache.put("B" , 2);
        cache.put("C" , 3);
        cache.put("D" , 4);
        cache.put("E" , 5);
        cache.get("B");
        cache.put("F" , 6);

        System.out.println(cache.size());
    }
}
