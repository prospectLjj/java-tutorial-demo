package com.prospect.aop.annotation.authentic.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)     //装载顺序
public class PermissionAdvice {

    @Pointcut("@annotation(com.prospect.aop.annotation.authentic.annotation.PermissionAnnotation)")
    public void permissionCheck(){}

    @Around("permissionCheck()")
    public Object doCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] object = proceedingJoinPoint.getArgs();
        Long id = ((JSONObject)object[0]).getLong("id");

        if(id < 0){
            System.out.println("参数不合法");
            return JSON.parseObject("{\"code\":403, \"message\":\"参数不合法\"}");
        }
        return proceedingJoinPoint.proceed();
    }
}
