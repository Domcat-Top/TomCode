package com.tom.iputils.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: Tom
 * @description:
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "info";
    }





}


















