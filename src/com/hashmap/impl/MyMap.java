package com.hashmap.impl;

import java.util.Set;

public interface MyMap<K,V> {

    V put(K key, V value);
    V get(K key);
    int size();
    Set<K> keySet();
    MyHashMap.Entry<K,V> entrySet();
}
