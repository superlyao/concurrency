package com.mmall.concurrency.threadlocal;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/27
 */
public class RequsetHolder {
    private final static ThreadLocal<Long> requeset_holder = new ThreadLocal<>();

    public static Long getLong(){
        return requeset_holder.get();
    }

    public static void add(Long id) {
        requeset_holder.set(id);
    }

    public static void remove() {
        requeset_holder.remove();
    }
}
