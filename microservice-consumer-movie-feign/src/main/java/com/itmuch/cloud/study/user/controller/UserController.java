package com.itmuch.cloud.study.user.controller;

import com.itmuch.cloud.study.user.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/test")
    public String dealTest(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("[from user feign] : Hello, %s!", name);
    }

    @GetMapping("/instanceinfo")
    public String instanceinfo() {
        return "[from user feign] : " + userFeignClient.instanceinfo();
    }

}
