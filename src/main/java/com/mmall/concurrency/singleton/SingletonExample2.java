package com.mmall.concurrency.singleton;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annoations.Recommend;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/21
 */
@Recommend
@Slf4j
public class SingletonExample2 {
    private SingletonExample2(){}

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {

        Maps.newHashMap();
        return instance;
    }
}
