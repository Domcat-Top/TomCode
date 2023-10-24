package com.tom.testwebsocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author: Tom
 * @date: 2023/10/21 13:27
 * @description: 配置类，通用配置--WebSocket
 */
@Configuration
public class WebSocket {

    /**
     * bean注册：会自动扫描带有@ServerEndpoint注解声明的Websocket Endpoint(端点)，注册成为Websocket bean。
     * 要注意，如果项目使用外置的servlet容器，而不是直接使用springboot内置容器的话，就不要注入ServerEndpointExporter，因为它将由容器自己提供和管理。
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}




