package com.ty.toubiao.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ty.redis.RedisService;
import com.ty.toubiao.bean.BetRecd;
import com.ty.toubiao.bean.UserInfo;
import com.ty.toubiao.service.BetRecdService;
import com.ty.toubiao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    private UserInfoService userInfoService;

    @Autowired
    public RedisService redisService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService){
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    public UserInfo queryBetRecdById(@RequestParam("id") Integer id){
        redisService.save("123","123");
        return  userInfoService.getOne(id);
    }

}
