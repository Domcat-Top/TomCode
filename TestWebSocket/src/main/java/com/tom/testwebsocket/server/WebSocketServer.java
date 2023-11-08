package com.tom.testwebsocket.server;

import com.alibaba.fastjson2.JSON;
import com.tom.testwebsocket.pojo.TestPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: Tom
 * @date:
 * @description:
 */
@Component
// 定义websocket服务器端，它的功能主要是将目前的类定义成一个websocket服务器端。
// 注解的值将被用于监听用户连接的终端访问URL地址
@ServerEndpoint("/websocket")
@Slf4j
public class WebSocketServer {

    //实例一个session，这个session是websocket的session
    private Session session;

    //存放websocket的集合（本次demo不会用到，聊天室的demo会用到）
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    //前端请求时一个websocket时
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("【websocket消息】有新的连接, 总数:{}", webSocketSet.size());
    }

    //前端关闭时一个websocket时
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("【websocket消息】连接断开, 总数:{}", webSocketSet.size());
    }

    //前端向后端发送消息
    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }

    //  try-catch 中的那一行是最重要的~
    public void sendMessage(String message) {
        for (WebSocketServer webSocketServer: webSocketSet) {
            try {
                log.info("【websocket消息】广播消息, message={}", message);
                webSocketServer.session.getBasicRemote().sendText(JSON.toJSONString(new TestPojo("tom", 72)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
