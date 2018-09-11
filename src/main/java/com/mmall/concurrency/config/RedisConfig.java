package com.mmall.concurrency.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @Author: yliao
 * @Date: Created in 2018/9/11
 */
@Configuration
public class RedisConfig {
    public JedisPool jedisPool(@Value("${jedis.host}")String host, @Value("${jedis.port}") int port) {
        return new JedisPool(host, port);
    }
}
