package com.ty.toubiao.controller;

import com.ty.redis.RedisService;
import com.ty.toubiao.bean.UserInfo;
import com.ty.toubiao.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    private UserInfoDao userInfoService;

    @Autowired
    public RedisService redisService;

    @Autowired
    public UserInfoController(UserInfoDao userInfoService){
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    public UserInfo queryBetRecdById(@RequestParam("id") Integer id){
        redisService.save("123","123");
        return  userInfoService.getOne(id);
    }

}
