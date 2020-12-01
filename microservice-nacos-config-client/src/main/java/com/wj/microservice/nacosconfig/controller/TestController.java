package com.wj.microservice.nacosconfig.controller;

import com.wj.microservice.nacosconfig.model.Test;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RefreshScope
public class TestController {

    @Value("${config.title}")
    String title;

    private static final String template = "Hello, docker user: %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hi")
    public String hi() {
        return String.format("[nacos config client] hi : config.title= %s", title);
    }

    @GetMapping("/test")
    public Test dealTest(@RequestParam(value="name", defaultValue="World") String name) {
        return new Test(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/testpost")
    public Test dealTestPost(@RequestBody Test prm) {
        Test result = new Test(counter.incrementAndGet(), String.format(template, "Post World"));
        if(prm != null) {
            result = new Test(counter.incrementAndGet(),
                    StringUtils.isBlank(prm.getContent()) ? String.format(template, "Post World") : String.format(template, prm.getContent()),
                    prm.getTime()!=null ? prm.getTime() : null,
                    prm.getDate()!=null ? prm.getDate() : null);
        }
        return result;
    }

}
