package com.lru;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K,V> {

    private final ConcurrentHashMap<K,V> map = new ConcurrentHashMap<>();
    private final ConcurrentLinkedQueue<K> queue = new ConcurrentLinkedQueue<>();
    private final int MAX_CAPACITY;
    private int size;

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    private static LRUCache LRU_CACHE;
    private LRUCache(int maxCapacity) {
        this.MAX_CAPACITY = maxCapacity;
    }

    public static LRUCache getInstance(int maxCapacity) {

        if (LRU_CACHE == null) {
            synchronized (LRUCache.class) {
                if (LRU_CACHE == null) {
                    LRU_CACHE = new LRUCache(maxCapacity);
                }
            }
        }
        return LRU_CACHE;
    }

    public V put(K key, V value) {

        this.writeLock.lock();
        try {
            V oldValue = null;
            if (map.containsKey(key)) {
                queue.remove(key);
            } else {
                if (queue.size() == MAX_CAPACITY) {
                    K eldestElementKey = queue.poll();
                    map.remove(eldestElementKey);
                } else {
                    size++;
                }
            }
            oldValue = map.put(key, value);
            queue.add(key);
            return oldValue;
        } finally {
            this.writeLock.unlock();
        }
    }

    public V get(K key) {
        this.readLock.lock();
        try{
            if (map.containsKey(key)) {
                queue.remove(key); // reordering in queue
                queue.add(key);
                return map.get(key);
            } else {
                return  null;
            }
        } finally {
            this.readLock.unlock();
        }
    }

    public boolean evict(K key) {

        this.readLock.lock();
        try{
            if (map.containsKey(key)) {
                queue.remove(key);
                map.remove(key);
                size--;
                return true;
            }
            return false;
        } finally {
            this.readLock.unlock();
        }
    }

    public int size() {
        return size;
    }
}
