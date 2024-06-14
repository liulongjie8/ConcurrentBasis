package org.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K,V> {
    final Map<K,V> map = new HashMap<>();

    /**
     * 读写锁
     */
    final ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 读锁
     */
    final Lock readLock = lock.readLock();

    /**
     * 写锁
     */
    final Lock writeLock = lock.writeLock();

    V get(K key){
        readLock.lock();
        try{
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    void put(K key,V value){
        writeLock.lock();
        try {
            map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }

}
