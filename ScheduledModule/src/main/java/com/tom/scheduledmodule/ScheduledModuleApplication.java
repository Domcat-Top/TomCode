package com.tom.scheduledmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// 开启定时器
@EnableScheduling
@SpringBootApplication
public class ScheduledModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledModuleApplication.class, args);
    }

}
