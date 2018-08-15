package com.mmall.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/15
 * 用来标记不推荐的方法或则类
 */
// 作用在类这个级别上
@Target(ElementType.TYPE)
// 存在运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface NotRecommend {
    String value() default "";
}
