package com.ty.zhaobiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableAsync
@RestController
public class ZhaoBiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhaoBiaoApplication.class,args);
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(String id){
        return "hello:"+id;
    }

}
