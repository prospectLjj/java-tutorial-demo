package com.prospect.aop.annotation.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Test {

    @Pointcut
    public void before(){
        System.out.println("开始");
    }
}

