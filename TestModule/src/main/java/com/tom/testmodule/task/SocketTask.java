package com.tom.testmodule.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: Tom
 * @date: 2023/11/24 12:53
 * @description:
 */
@Slf4j
@Component
public class SocketTask implements ApplicationRunner {


    /**
     * 服务启动，就自动开始给UTU发送数据
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String ipAddress = "127.0.0.1"; // 目标IP地址
        int port = 8888; // 目标端口号
        byte[] data = {0, 1, 2}; // 要发送的字节数组

        try {
            // 创建Socket连接
            Socket socket = new Socket(ipAddress, port);

            // 获取输出流，用于发送数据
            OutputStream outputStream = socket.getOutputStream();

            // 将字节数组写入输出流--发送
            outputStream.write(data);
            log.info("发送完了 ===> {}", data.toString());
            // 关闭输出流和套接字
            outputStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}















