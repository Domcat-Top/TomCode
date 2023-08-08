package com.tom;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tom.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JwtUtilsApplicationTests {

	@Test
	void contextLoads() {
		Map<String, Object> map = new HashMap<>();
		// 二百秒后过期
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.SECOND, 200);
		String token = JWT.create()
				// 也就意味着，请求头里面也是可以保持有具体的参数的
				// 需要的是一个Map作为头，可以不写，也就是说这一行可以删掉
				.withHeader(map)
				// 这里是payload，放的是用的信息，比如头像啥的
				.withClaim("username", "tom")
				.withClaim("password", 123)
				// 设置过期时间
				.withExpiresAt(instance.getTime())
				// 放签名---里面是算法，对你的签名有进行了加密
				.sign(Algorithm.HMAC256("tomName"));

		System.out.println(token);
	}

	/**
	 * 用户带着Token发请求后，服务端对Token的验证
	 */
	@Test
	void test02() {
		// 生成所谓的验证对象
		JWTVerifier tomName = JWT.require(Algorithm.HMAC256("tomName")).build();
		// 进行验证，获取到payload信息
		DecodedJWT verify = tomName.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMyIsImV4cCI6MTY4NjU1MTU0MiwidXNlcm5hbWUiOiJ0b20ifQ.fiRqqNaDItXA9YkdqaHT7aGnPL2RbNcvW-EdMAfYxuE");
		// 获取用这种方式--里面是map的存储形式
		System.out.println(verify.getClaims().get("username").asString());
		System.out.println(verify.getClaims().get("password").asInt());
	}

	/**
	 * 工具类的调用
	 */
	@Test
	void test03 () {
		String token = JwtUtils.getToken(null);
		System.out.println(token);
	}
}


















