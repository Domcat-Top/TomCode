package com.tom.testaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Tom
 * @description:
 */
@RestController
public class TestController {

    // 测试接口
    @GetMapping("/test")
    public String test() {
        return "testInfo";
    }

    @GetMapping("/throwException")
    public String throwException() {
        throw new RuntimeException("随便抛个异常");
    }

}
