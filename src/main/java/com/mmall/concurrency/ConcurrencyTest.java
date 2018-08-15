package com.mmall.concurrency;

import com.mmall.concurrency.annoations.NotRecommend;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/15
 */
@NotRecommend
@Slf4j
public class ConcurrencyTest {
    private static final int clientTol = 1000;

    private static final int thread = 200;

    private static volatile  int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(thread);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTol);
        for (int i = 0; i < clientTol; i++) {
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("值：" + count);
    }

    private static void add() {
        count++ ;
    }
}
