package com.tom.iputils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class IpUtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpUtilsApplication.class, args);
    }

}
