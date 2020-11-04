package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class CloudGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }

//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        String httpUri = "http://httpbin.org:80";
//        return builder.routes()
//                .route(p->p
//                        .path("/get") //用path断言是否进入该路由
//                        .filters(f -> f.addRequestHeader("Hello", "world"))
//                        .uri(httpUri))
//                .route(p->p
//                        .host("*.hystrix.com")//用host断言是否进入该路由
//                        .filters(f->f
//                                .hystrix(config -> config
//                                        .setName("mycmd")
//                                        .setFallbackUri("forward:/fallback")))
//                        .uri(httpUri))
//                .build();
//    }
//
//    @RequestMapping("/fallback")
//    public Mono<String> fallback() {
//        System.out.println("fallback");
//        return Mono.just("fallback");
//    }


    @RequestMapping("/hi")
    public String test() {
        return "hi, cloud-gateway";
    }

}
