package com.cache.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> CACHE_MAP;

    private static volatile LRUCache CACHE = null;
    private final int CAPACITY;

    private LRUCache(int capacity) {
        CAPACITY = capacity;
        CACHE_MAP = new LinkedHashMap<>(CAPACITY, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return CACHE_MAP.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        CACHE_MAP.put(key, value);
    }
    public static LRUCache getInstance(int capacity) {

         if (CACHE == null) {
             synchronized (LRUCache.class) {
                 if (CACHE == null) {
                     CACHE = new LRUCache(capacity);
                 }
             }
         }
         return CACHE;
    }

}
