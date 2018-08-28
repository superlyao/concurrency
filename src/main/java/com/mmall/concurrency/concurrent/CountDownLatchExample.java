package com.mmall.concurrency.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/28
 */
public class CountDownLatchExample {
    private final static Integer threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    // 计数器减1
                    countDownLatch.countDown();
                }
            });
        }
        //等待所有线程执行完毕(只有等到countDownLatch的值减到0才会执行后面的语句)
        countDownLatch.await();
        System.out.println("执行完成");
        // 关闭线程池
        exec.shutdown();
    }

    public static void test(int i) throws InterruptedException {
        Thread.sleep(100);
        System.out.println("threadNum:" + i);
        Thread.sleep(100);
    }
}
