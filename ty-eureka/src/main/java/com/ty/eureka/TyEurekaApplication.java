package com.ty.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启用注册中心
@EnableEurekaServer
@SpringBootApplication
public class TyEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TyEurekaApplication.class,args);
    }

}
