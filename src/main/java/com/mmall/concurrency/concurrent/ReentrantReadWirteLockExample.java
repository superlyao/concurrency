package com.mmall.concurrency.concurrent;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/29
 */
public class ReentrantReadWirteLockExample {
    private final Map<String, Data> map = new TreeMap<>();
    private final  ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();
    private final Lock readLock = LOCK.readLock();
    private final Lock writeLock = LOCK.writeLock();

    public static void main(String[] args) {

    }

    public Data get(String key) {
        readLock.lock();
        try {
           return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public Set<String> getKeyAll() {
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }

    public void setValue(String key, Data data) {
        writeLock.lock();
        try {
            map.put(key, data);
        }finally {
            writeLock.unlock();
        }
    }
    class Data {

    }
}
