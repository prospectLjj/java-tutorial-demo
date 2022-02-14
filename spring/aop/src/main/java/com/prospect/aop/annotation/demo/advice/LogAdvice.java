package com.prospect.aop.annotation.demo.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("logAdvice1")
public class LogAdvice {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void logAdvicePointcut(){}

    @Before(value = "logAdvicePointcut()")
    public void logBefore(){
        System.out.println("在get方法前执行advice");
    }

    @After(value = "logAdvicePointcut()")
    public void logAfter(){
        System.out.println("在get方法后执行advice");
    }
}
