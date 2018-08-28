package com.mmall.concurrency.concurrent;

import com.mmall.concurrency.annoations.NotRecommend;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/15
 */
@NotRecommend
@Slf4j
public class CopyOnWriteArrayListConcurrent {
    private static final int clientTol = 1000;

    private static final int thread = 200;

    private static volatile List<Integer> list = new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(thread);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTol);
        for ( int i = 0; i < clientTol; i++) {
            final int cont = i;
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    add(cont);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("值：" + list.size());
    }

    private static void add(int i) {
        list.add(i);
    }
}
