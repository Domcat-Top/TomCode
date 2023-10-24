package com.tom.testwebsocket.controller;

import com.tom.testwebsocket.server.WebSocketServer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author: Tom
 * @date: 2023/10/23 14:27
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private WebSocketServer webSocketServer;


    /**
     * 后端向前端发送
     * @throws InterruptedException
     */
    @Scheduled(fixedRate = 1000)
    @RequestMapping("/send")
    public void sendMessage() throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            sb.append("a");
            Thread.sleep(2500);
            webSocketServer.sendMessage(sb.toString());
        }
    }



}















