package com.tom.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author: Tom
 * @date: 2023/6/12 14:33
 * @description: 对生成Token和解析Token进行封装--详情见test测试类里面的调用
 */
public class JwtUtils {

    // 全局定义静态常量作为签名
    private static final String SIGN = "tomSign";

    /**
     * 生成Token的方法
     * @param map 外部需要放入到payload的内容--比如：用户名、邮箱之类的
     * @return 生成好的token
     */
    public static String getToken(Map<String, String> map) {

        // 设置token七天过期
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);

        JWTCreator.Builder builder = JWT.create();

        if(null != map) {
            map.forEach((k, v) -> {
                builder.withClaim(k, v);
            });
        }

        // 指定令牌的过期时间
        String token = builder.withExpiresAt(instance.getTime())
                // 选择加密算法
                .sign(Algorithm.HMAC256(SIGN));
        return token;
    }


    /**
     * 验证token---有返回值，那么Token是正确的
     * 并且通过返回的对象获取token中的信息
     * @param token 外部传入的token
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }



}

















