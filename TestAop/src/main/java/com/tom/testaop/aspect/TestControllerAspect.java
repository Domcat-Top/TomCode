package com.tom.testaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @author: Tom
 * @description: 测试是否可以拉取到Controller的切面
 */

@Aspect
@Component
public class TestControllerAspect {

    /**
     * 监听所有的 Controller 的所有方法
     */
    @Before(value = "execution(* com.tom.testaop.controller.*Controller.*())")
    private void aspectAllController() {
        System.out.println("这里监听所有的 Controller------方法执行之前");

    }

    @After(value = "execution(* com.tom.testaop.controller.TestController.test())")
    private void aspectSpecialMethod() {
        System.out.println("监听了test方法，方法执行之后出现");
    }

    /**
     * 环绕方法
     * @param proceedingJoinPoint 反射机制获取切点方法信息
     */
    @Around(value = "execution(* com.tom.testaop.controller.TestController.test())")
    private void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        // 类名字 + 方法名
        String methodName = proceedingJoinPoint.getTarget().getClass().getSimpleName()
                + "#"
                + proceedingJoinPoint.getSignature().getName();
        System.out.println("环绕方法" + methodName);
    }

    /**
     * 抛出异常时
     * @param joinPoint 获取到切点方法的信息，利用了反射机制
     */
    @AfterThrowing(value = "execution(* com.tom.testaop.controller.TestController.throwException())")
    private void exceptionMethod(JoinPoint joinPoint) {
        // 类名 + 方法名
        String info = joinPoint.getTarget().getClass().getSimpleName()
                + "#"
                + joinPoint.getSignature().getName();
        System.out.println("抛出异常了" + info);
    }

}
























