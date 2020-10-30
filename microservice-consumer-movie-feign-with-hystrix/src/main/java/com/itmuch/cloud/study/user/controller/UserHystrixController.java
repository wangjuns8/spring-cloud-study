package com.itmuch.cloud.study.user.controller;

import com.itmuch.cloud.study.user.feign.UserFeignHystrixClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userhystrix")
@Slf4j
public class UserHystrixController {

    @Autowired
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("/test")
    public String dealTest(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("[from user hystrix feign] : Hello, %s!", name);
    }

    @GetMapping("/instanceinfo")
    public String instanceinfo() {
        String result = "[from user hystrix feign] : " + userFeignHystrixClient.instanceinfo();
        log.info(result);
        return result;
    }

}
