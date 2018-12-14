package com.ty.toubiao.controller;

import com.ty.toubiao.bean.BetRecd;
import com.ty.toubiao.service.BetRecdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/betRecd")
public class BetRecdController {

    private BetRecdService betRecdService;

    @Autowired
    public BetRecdController(BetRecdService betRecdService){
        this.betRecdService = betRecdService;
    }

    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    public BetRecd queryBetRecdById(@RequestParam("id") BigInteger id){
        return  betRecdService.getOne(id);
    }

}
