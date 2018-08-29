package com.mmall.concurrency.concurrent;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/29
 */
public class SemaphoreExample3 {
    private final static Integer threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只允许10个线程同时访问
        final Semaphore semaphore = new Semaphore(13);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    // 获取一个许可
                    if(semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
                        test(threadNum);
                        // 释放一个许可
                        semaphore.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("执行完成");
        // 关闭线程池
        exec.shutdown();
    }

    public static void test(int i) throws InterruptedException {
        System.out.println("threadNum:" + i);
        Thread.sleep(1000);
    }
}
