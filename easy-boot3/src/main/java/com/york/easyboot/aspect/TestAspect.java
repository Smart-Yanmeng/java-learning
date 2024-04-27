package com.york.easyboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    @Before("execution(public void com.york.easyboot.service.impl.AOPTestServiceImpl.TestAOP())")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("before");
    }
}
