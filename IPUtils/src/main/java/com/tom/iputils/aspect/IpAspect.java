package com.tom.iputils.aspect;

import com.tom.iputils.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: Tom
 * @description:
 */

@Component
@Aspect
public class IpAspect {

    @Resource
    private HttpServletRequest httpServletRequest;

    @After(value = "execution(* com.tom.iputils.controller.TestController.test())")
    private void testRecord(JoinPoint joinPoint) {
        String ipAddress = IpUtils.getIpAddress(httpServletRequest);
        String holdPlace = IpUtils.getIpSource(ipAddress);
        System.out.println(ipAddress + holdPlace);
    }
}















































