package com.bean.constants;

/**
 * @author MOFAN889
 * @ProjectName com.bean.constants
 * @Description: 返回对象结果参数常量类
 * @date 2018/12/24 14:42
 */
public class ReturnMessageCode {

    private String retCode;

    private String retMessage;

    public static ReturnMessageCode SUCCESS = new ReturnMessageCode("200","处理成功");
    public static ReturnMessageCode ERROE = new ReturnMessageCode("-1","处理失败");
    public static ReturnMessageCode NOAUTH = new ReturnMessageCode("50001","没有权限");
    public static ReturnMessageCode PARAMETER_INCORRENT = new ReturnMessageCode("50002","非法请求参数");
    public static ReturnMessageCode ACCOUNT_OR_PASSWORD_WRONG = new ReturnMessageCode("50003","账号或者密码错误");
    public static ReturnMessageCode LOGIN_TIMEOUT = new ReturnMessageCode("50004","登录超时");


    public ReturnMessageCode(String retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }
}
