package com.tom.testmodule.utils;

import com.alibaba.fastjson2.JSON;
import com.tom.testmodule.entity.TomVO;

import java.io.*;
import java.net.Socket;

/**
 * @author: Tom
 * @date: 2023/11/6 10:33
 * @description:
 */
public class SocketPostUtils {

    public static void main(String[] args) {
        String host = "www.example.com";
        int port = 80;
        String endpoint = "/api/endpoint";
        // VO对象转JSON -- JSON格式
        String requestBody = JSON.toJSONString(TomVO.builder().name("tom").age(18).build());

        try {
            // 创建Socket并连接到指定的主机和端口
            Socket socket = new Socket(host, port);

            // 获取输出流，发送请求
            OutputStream out = socket.getOutputStream();

            // 构造POST请求，包括请求头和请求体 -- 固定格式
            out.write(("POST " + endpoint + " HTTP/1.1\r\n").getBytes());
            out.write(("Host: " + host + "\r\n").getBytes());
            out.write(("Content-Type: application/json\r\n").getBytes());
            out.write(("Content-Length: " + requestBody.length() + "\r\n").getBytes());
            out.write("\r\n".getBytes());
            out.write(requestBody.getBytes());

            // 获取输入流，读取响应
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            // 读取响应并打印出来
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            // 关闭资源
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
