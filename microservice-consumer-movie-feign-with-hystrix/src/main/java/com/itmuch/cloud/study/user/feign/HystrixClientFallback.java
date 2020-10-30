package com.itmuch.cloud.study.user.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HystrixClientFallback implements UserFeignHystrixClient {

    /**
     * hystrix fallback方法
     * @return 默认
     */
    @Override
    public String instanceinfo() {
        log.info("[HystrixClientFallback]instanceinfo 异常发生，进入fallback方法");
        return "[HystrixClientFallback] exception-instance-info";
    }
}
