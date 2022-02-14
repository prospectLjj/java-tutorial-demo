package com.prospect.aop.annotation.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    @GetMapping("/aop")
    public String aop(){
        System.out.println("进入方法");
        return "aop";
    }
}
