package com.mmall.concurrency.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yliao
 * @Date: Created in 2018/9/5
 */
public class ExecutorsNewScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        // 允许设置延迟时间 延迟3秒
        executorService.schedule(()->{
            System.out.println("执行");
        }, 3, TimeUnit.SECONDS);

        // 延迟1秒 每个3秒执行执行一次任务
        executorService.scheduleAtFixedRate(()-> {
            System.out.println("执行1");
        },1, 3,TimeUnit.SECONDS);
        executorService.shutdown();

        // 每5秒执行一次
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行3");
            }
        }, new Date(), 5*1000);
    }
}
