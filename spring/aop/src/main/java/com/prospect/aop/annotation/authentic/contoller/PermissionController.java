package com.prospect.aop.annotation.authentic.contoller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.prospect.aop.annotation.authentic.annotation.PermissionAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermissionController {

    @PermissionAnnotation
    @GetMapping("/permission")
    public JSONObject  permission(@RequestBody JSONObject request){
        return JSON.parseObject("{\"code\":200, \"message\": \"permission\"}");
    }
}
