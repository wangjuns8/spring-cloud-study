package com.itmuch.cloud.study.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用@FeignClient("microservice-provider-user")
 * 注解绑定microservice-provider-user服务
 * 还可以使用url参数指定一个URL。
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping("/user/instanceinfo")
    public String instanceinfo();

}
