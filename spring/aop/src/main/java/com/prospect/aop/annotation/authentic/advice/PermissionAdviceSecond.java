package com.prospect.aop.annotation.authentic.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component("permissionAdviceSecond")
@Order(2)
public class PermissionAdviceSecond {

    @Pointcut("@annotation(com.prospect.aop.annotation.authentic.annotation.PermissionAnnotation)")
    public void permissionCheckSecond(){}

    @Around("permissionCheckSecond()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String name = ((JSONObject) args[0]).getString("name");
        if(!"admin".equals(name)){
            return JSON.parseObject("{\"code\": 403, \"message\": \"不是管理员\"}");
        }
        return joinPoint.proceed();
    }

}
