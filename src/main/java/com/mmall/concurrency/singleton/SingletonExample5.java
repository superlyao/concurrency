package com.mmall.concurrency.singleton;


import java.util.Map;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/21
 */
public class SingletonExample5 {
    private SingletonExample5() {}
    public static SingletonExample5 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample5 instance = null;

        Singleton() {
            instance = new SingletonExample5();
        }

        public SingletonExample5 getInstance() {
            return instance;
        }
    }
}
