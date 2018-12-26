package com.ty.toubiao;

import com.ty.toubiao.service.feign.FeignTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@RestController
@ComponentScan(basePackages = "com")
@EntityScan("com.*.*")
@EnableSwagger2
public class TouBiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TouBiaoApplication.class,args);
    }

    @Autowired
    private FeignTestService feignTestService;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(String id){
        System.out.println(feignTestService.hello("889"));
        return "TY-TOUBIAO:"+id;
    }

}
