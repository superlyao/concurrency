package com.mmall.concurrency.singleton;

import com.mmall.concurrency.annoations.Recommend;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/21
 */
@Recommend
public class SingletonExample3 {
    private SingletonExample3(){}

    private static SingletonExample3 instance = null;

    public static synchronized SingletonExample3 getInstance() {
        if (null == instance) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
