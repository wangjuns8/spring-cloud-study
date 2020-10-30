package com.itmuch.cloud.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/userribbon")
public class UserRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String dealTest(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("[from ribbon] : Hello, %s!", name);
    }

    @GetMapping("/instanceinfo")
    public String ribbonTest() {
        String result = this.restTemplate.getForObject("http://microservice-provider-user/user/instanceinfo", String.class);
        return result;
    }
}
