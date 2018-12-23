package com.ty.toubiao.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("zhaobiao-service/ty-zhaobiao/hello")
public interface FeignTestService {

    /**
     * get请求，参数一定要加get请求
     * @param id
     * @return
     */
    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String hello(@RequestParam("id") String id);

}
