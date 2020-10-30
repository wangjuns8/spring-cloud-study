package com.itmuch.cloud.study.user.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用@FeignClient注解的fallback属性，指定fallback类
 */
@FeignClient(value = "microservice-provider-user",
        configuration= FeignClientsConfiguration.class,
        fallback = HystrixClientFallback.class)
public interface UserFeignHystrixClient {

    @RequestMapping("/user/instanceinfo")
    public String instanceinfo();


}
