package com.itmuch.cloud.study.controller;

import com.itmuch.cloud.study.model.Test;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Qualifier("eurekaRegistration")
    @Autowired
    private Registration registration; // 服务注册

    @Value("${server.port}")
    private String serverPort;

    private static final String template = "Hello, user: %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/test")
    public Test dealTest(@RequestParam(value="name", defaultValue="World") String name) {
        return new Test(counter.incrementAndGet(), String.format(template, name));
    }
    
    /**
     * 本地服务实例的信息
     * @return
     */
    @GetMapping("/instanceinfo")
    public String showInfo() {
        String result = "NULL!";
        ServiceInstance instance = serviceInstance();
        if(instance!=null)
            result = String.format("host:port= %s, service_id: %s", instance.getUri(), instance.getServiceId());
        log.info(result);
        return "[INSTANCE-INFO] : " + result;
    }

    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if(!StringUtils.isBlank(serverPort) && itm.getPort() == Integer.valueOf(serverPort))
                    return itm;
            }
        }
        return null;
    }
}
