package com.tom.reptiletest.utils;

import org.apache.commons.io.IOUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;

/**
 * @author: Tom
 * @date: 2023/7/14 14:10
 * @description: 一个模板实例，指出了如何从网页爬取一些信息，但是当前这个网站已经关停了
 */
public class JsoupTest {

    public static void main(String[] args) throws Exception {
        // Jsoup 模拟浏览器发起请求
        String website = "http://dou.yuanmazg.com";

        // 模拟客户端向对应网站发送数据
        Connection.Response response = Jsoup
                // 网址
                .connect("https://dou.yuanmazg.com/doutu?page=1")
                // 请求头
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36")
                // 忽略内容内省
                .ignoreContentType(true)
                // 请求超时设置
                .timeout(10000)
                // 执行
                .execute();
        // 响应头
        System.out.println(response.header("Content-Type"));
        // 响应体
        System.out.println(response.body());


        // 从响应体中拿到html部分
        String html = response.body();
        // Jsoup 解析HTML
        Document dom = Jsoup.parse(html);
        // 选择器
        //#pic-detail > div > div.col-sm-9 > div.page-content > a:nth-child(2) > img
        Elements select = dom.select("#pic-detail > div > div.col-sm-9 > div.page-content > a > img");
        // 获取单个
        for (Element element : select) {
            // 取出相应数据---这个是当前标签下的data-original属性
            String imgUrl = element.attr("data-original");
            // 真实网站的图片URL一般都是website + imgUrl
            String realUrl = website + imgUrl;
            int i = imgUrl.lastIndexOf("/");
            String filename = imgUrl.substring(i + 1);

            System.out.println(filename);
            System.out.println(realUrl);

            // 下载到 imgResponse 对象里面
            Connection.Response imgResponse = Jsoup.connect(realUrl)
                    .ignoreContentType(true)
                    .timeout(10000)
                    // 10M的缓冲区
                    .maxBodySize(10 * 1024 * 1024)
                    .execute();
            // 取出写入的字节
            byte[] bytes = imgResponse.bodyAsBytes();
            // 输出到对应文件夹下
            IOUtils.write(bytes, new FileOutputStream("e://Test//picture//" + filename));
        }
    }

}
