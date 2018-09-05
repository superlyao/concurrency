package com.mmall.concurrency.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yliao
 * @Date: Created in 2018/9/5
 */
public class ExecutorsNewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            executorService.submit(() -> System.out.println(temp));
        }
        executorService.shutdown();
    }
}
