package com.mmall.concurrency.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: yliao
 * @Date: Created in 2018/9/3
 */
public class FutureTaskExample {
    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("开始执行");
                Thread.sleep(5000);
                return "ok";
            }
        });

        new Thread(futureTask).start();
        System.out.println("main job");
        Thread.sleep(1000);
        String result = futureTask.get();
        System.out.println("结果:" + result);
    }
}
