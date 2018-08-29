package com.mmall.concurrency.concurrent;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/29
 */
public class CyclicBarrierExample {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            exec.execute(() -> {
                try {
                    rece(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

    private static void rece(int i) throws Exception {
        Thread.sleep(1000);
        System.out.println("输出：" + i);
        cyclicBarrier.await();
        System.out.println("该线程执行完毕：" + i);
    }
}
