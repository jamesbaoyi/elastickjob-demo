package com.fintecher.cn.elasticjobdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/11 15:29
 * @Description:
 */
@RestController
public class ElasticJobController {

    @GetMapping("/sayHello")
    public String hello() {
        return "hello world";

    }
}
