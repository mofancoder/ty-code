package com.ty.toubiao.controller;

import com.ty.redis.RedisService;
import com.ty.toubiao.bean.UserInfo;
import com.ty.toubiao.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
@Api("投标userInfo")
public class UserInfoController {

    private UserInfoService userInfoService;

    @Autowired
    public RedisService redisService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService){
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    @ApiOperation(value = "通过id查询",notes = "通过id")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "helloVO id",required = true,dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name="page",value = "helloVO id",required = true,dataType = "String",paramType = "query"),
                        @ApiImplicitParam(name="rows",value = "helloVO id",required = true,dataType = "String",paramType = "query"),})
    public UserInfo queryBetRecdById(@RequestParam("id") Integer id,@RequestParam("page") Integer page,@RequestParam("rows") Integer rows){
        userInfoService.test1(null);
//        userInfoService.test2(null);
        return  userInfoService.getOne(id);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    public void deleteById(@RequestParam("id") Integer id){
        userInfoService.test3(null);
    }

    @RequestMapping(value = "/queryByPageTest",method = RequestMethod.GET)
    public void queryByPageTest(){
        userInfoService.test4(null);
    }

}
