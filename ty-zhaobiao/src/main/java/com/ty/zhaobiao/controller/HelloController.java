package com.ty.zhaobiao.controller;

import com.bean.dto.HelloDto;
import com.bean.vo.HelloVO;
import com.ty.zhaobiao.service.HelloService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
//API 放在controller上面介绍controller使用
@Api("招标hello controller")
public class HelloController {

    private HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }

    @ApiOperation(value = "hello controller get测试方法",notes = "get测试方法")
    @RequestMapping(value="/test",method = RequestMethod.GET)
    /**
     * header：请求参数放置于Request Header，使用@RequestHeader获取
     * query：请求参数放置于请求地址，使用@RequestParam获取
     * path：（用于restful接口）-->请求参数的获取：@PathVariable
     * body：POST 请求，使用@RequestBody获取
     * form（不常用）
     */
    @ApiImplicitParams(@ApiImplicitParam(name="id",value = "helloVO id",required = true,dataType = "String",paramType = "query"))
    public String hello(String id){
        HelloDto helloDto = helloService.queryById(id);
        if(helloDto!=null){
            return "zhaobiao hello:"+helloDto.getUserName();
        }
        return "zhaobiao hello:"+id;
    }

    //ApiOperation放在方法上做描述
    @ApiOperation(value = "hello controller 测试方法",notes="测试方法，返回zhaobiao hello+userName")
    /**
     * paramType类型介绍
     * header：请求参数放置于Request Header，使用@RequestHeader获取
     * query：请求参数放置于请求地址，使用@RequestParam获取
     * path：（用于restful接口）-->请求参数的获取：@PathVariable
     * body：（不常用）
     * form（不常用）
     */
    @ApiImplicitParams(@ApiImplicitParam(name="vo",value = "HelloVO实体类",required = true,dataType = "HelloVO",paramType = "body"))
    @RequestMapping(value="/test",method = RequestMethod.POST)
    public String helloPost(@RequestBody HelloVO vo){
        return "zhaobiao hello:"+vo.getUserName();
    }

}
