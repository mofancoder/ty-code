package com.ty.toubiao.controller;

import com.ty.toubiao.bean.BetRecd;
import com.ty.toubiao.dao.BetRecdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/betRecd")
public class BetRecdController {

    private BetRecdDao betRecdService;

    @Autowired
    public BetRecdController(BetRecdDao betRecdService){
        this.betRecdService = betRecdService;
    }

    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    public BetRecd queryBetRecdById(@RequestParam("id") BigInteger id){
        return  betRecdService.getOne(id);
    }

}
