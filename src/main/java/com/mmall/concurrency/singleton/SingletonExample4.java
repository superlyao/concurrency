package com.mmall.concurrency.singleton;

import com.mmall.concurrency.annoations.Recommend;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/21
 */
@Recommend
public class SingletonExample4 {
    private SingletonExample4(){}

    private static volatile SingletonExample4 instance = null;

    public static  SingletonExample4 getInstance() {
        if (null == instance) {
            synchronized (SingletonExample4.class) {
                if (null == instance) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
