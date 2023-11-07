package com.tom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@MapperScan("com.tom.mapper")
public class PageHelperTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PageHelperTestApplication.class, args);
    }

}
