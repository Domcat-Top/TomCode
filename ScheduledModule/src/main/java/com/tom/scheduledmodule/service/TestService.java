package com.tom.scheduledmodule.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: Tom
 * @date: 2023/7/7 14:16
 * @description:
 */
@Service
public class TestService {

    /**
     * cron表达式：指定任务在特定时间执行
     * fixedDelay:表示上一次任务执行完成后多久再执行，参数类型long,单位：ms
     * fixedDelayString:与fixedDelay一样，只是参数类型是String
     * fixedRate:表示按一定的频率执行任务，参数类型long,单位：ms 如： fixedRate = 5000 ，表示这个定时器任务每5秒执行一次
     * fixedRateString:与fixedRate一样，只是参数类型变为String
     * initialDelay:表示延迟多久再第一次执行任务，参数类型为long ,单位：ms
     * initialDelayString：与initialDelay一样，只是参数类型String
     */
    // 还有corn表达式
    @Scheduled(fixedRate = 1000)
    public void testScheduled() {
        System.out.println(new Date().toString());
    }


}
