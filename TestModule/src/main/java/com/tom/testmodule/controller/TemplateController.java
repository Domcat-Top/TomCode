package com.tom.testmodule.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

/**
 * @author: Tom
 * @date: 2023/10/23 8:14
 * @description:
 */
@Controller
@ResponseBody
public class TemplateController {

    @GetMapping("/test")
    public String test() {
        return "index";
    }

    /**
     * 方法四 LineCaptcha
     * 图片的base64编码字符串
     * session存储
     * 接口需添加白名单放行
     *
     * @param response HttpServletResponse
     * @return String
     */
    @GetMapping("/testTemp")
    public void getVerifyTwo(HttpServletResponse response) {
        // 随机生成 4 位验证码，范围是0-9
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        // 定义图片的显示大小
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(95, 30);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try {
            // 调用父类的 setGenerator() 方法，设置验证码的类型
            lineCaptcha.setGenerator(randomGenerator);
            // 输出到页面
            lineCaptcha.write(response.getOutputStream());
            // 打印验证码
            String code = lineCaptcha.getCode();
            System.out.println("生成的验证码:" + code);

            // 关闭流
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
