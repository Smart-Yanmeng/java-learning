package com.mashang.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class Log {

    public void beforeLog() {
        System.out.println("前置通知");
        System.out.println("日志入库");
    }

    public void afterLog() {
        System.out.println("后置通知");

    }

    public void exceptionLog() {
        System.out.println("异常通知");

    }

    public void afterReturning() {
        System.out.println("返回通知");

    }

    public void aroundLog(ProceedingJoinPoint point) {
        System.out.println("环绕通知");
        try {
            // 调用目标类的方法
            point.proceed();
            System.out.println("业务代码执行之后的通知");
        } catch (Throwable e) {
            System.out.println("异常通知");

            throw new RuntimeException(e);
        }
    }


}
