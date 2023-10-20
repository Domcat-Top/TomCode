package com.tom.testwebsocket.task;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: Tom
 * @date: 2023/10/20 14:43
 * @description: 启动任务，模拟一下
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Resource
    private RedisTemplate redisTemplate;


    /**
     * 启动的时候塞进去，看下可不可以
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisTemplate.opsForValue().set("tom", "jerry");

        
    }
}













