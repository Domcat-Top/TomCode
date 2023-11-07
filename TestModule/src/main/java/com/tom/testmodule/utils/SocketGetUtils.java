package com.tom.testmodule.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author: Tom
 * @date: 2023/11/6 10:09
 * @description:
 */
public class SocketGetUtils {

    public static void main(String[] args) {
        // 创建OkHttpClient实例
        OkHttpClient client = new OkHttpClient();

        // 创建GET请求
        Request request = new Request.Builder()
                .url("http://localhost:8989/tomInfo") // 设置请求的URL
                .build();
        try {
            // 发送请求并获取响应
            Response response = client.newCall(request).execute();

            // 检查响应是否成功
            if (response.isSuccessful()) {
                // 获取并处理响应数据
                String responseBody = response.body().string();
                System.out.println("Response: " + responseBody);
            } else {
                System.out.println("Request failed with code: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}












