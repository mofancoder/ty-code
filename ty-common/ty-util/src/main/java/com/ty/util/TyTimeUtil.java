package com.ty.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TimeUtil created by MOFAN
 * 2018-12-16 12:01
 */
@Slf4j
public class TyTimeUtil {

    private TyTimeUtil(){}

    private static SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前时间字符串 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getNowTime(){
        return yyyyMMddHHmmssSdf.format(new Date());
    }

}
