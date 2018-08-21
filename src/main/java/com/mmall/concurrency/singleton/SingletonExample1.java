package com.mmall.concurrency.singleton;

import com.mmall.concurrency.annoations.NotRecommend;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/21
 */
@NotRecommend
public class SingletonExample1 {
    private SingletonExample1(){}

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance() {
        if (null == instance) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
