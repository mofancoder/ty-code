package com.bean.constants;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author MOFAN889
 * @ProjectName com.bean.constants
 * @Description: 返回结果
 * @date 2018/12/24 14:48
 */
public class Result<T> {

    private Map<String,Object> result;

    public Result(T data) {
        result = Maps.newHashMap();
        result.put("retCode",ReturnMessageCode.SUCCESS.getRetCode());
        result.put("retMessage",ReturnMessageCode.SUCCESS.getRetMessage());
        result.put("data",data);
    }

    private Result(ReturnMessageCode returnMessageCode){
        result = Maps.newHashMap();
        if(returnMessageCode != null){
            result.put("retCode",returnMessageCode.getRetCode());
            result.put("retMessage",returnMessageCode.getRetMessage());
        }
    }

    private Result(ReturnMessageCode returnMessageCode,T data){
        result = Maps.newHashMap();
        result.put("retCode",returnMessageCode.getRetCode());
        result.put("retMessage",returnMessageCode.getRetMessage());
        result.put("data",data);
    }
}
