package com;

import com.ty.jobtask.service.ElasticJobService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
public class TyJobTaskApplication implements CommandLineRunner {

    @Resource
    private ElasticJobService elasticJobService;

    public static void main(String[] args) {
        SpringApplication.run(TyJobTaskApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        elasticJobService.scanAddJob();
    }
}
