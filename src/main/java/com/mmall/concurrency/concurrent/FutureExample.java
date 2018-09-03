package com.mmall.concurrency.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: yliao
 * @Date: Created in 2018/9/3
 */
public class FutureExample {
    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("开始执行");
            Thread.sleep(5000);
            return "ok";
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> submit = service.submit(new MyCallable());
        System.out.println("其他job");
        Thread.sleep(1000);
        String result = submit.get();
        System.out.println("结果:"+result);
    }
}
