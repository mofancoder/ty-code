package com.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * @author MOFAN889
 * @ProjectName com.bean.enums
 * @Description: 前端返回对象
 * @date 2018/12/24 12:02
 */
@ApiModel
public class Results implements Serializable {
    public static final Result SUCCESS = new Result(Result.SUCCESS, "处理成功");
    public static final Result ACCOUNT_INVALID = new Result(Result.ACCOUNT_INVALID, "账号无效");
    public static final Result NO_REGIST = new Result(Result.NO_REGIST, "未注册");
    public static final Result SEND_FAIL = new Result(Result.SEND_FAIL, "发送失败");
    public static final Result SYSTEM_BUSY = new Result(Result.SYSTEM_BUSY, "系统繁忙");
    public static final Result PARAMETER_INCORRENT = new Result(Result.PARAMETER_INCORRENT, "请求参数有误");
    public static final Result ACCOUNT_EXIST = new Result(Result.ACCOUNT_EXIST, "帐户已注册");
    public static final Result CAPTCHA_INCORRENT = new Result(Result.CAPTCHA_INCORRENT, "验证码错误");
    public static final Result TOKEN_INCORRECT = new Result(Result.TOKEN_INCORRECT, "验证失效，请重新登录");
    public static final Result CAPTCHA_INVALID = new Result(Result.CAPTCHA_INVALID, "验证码失效");
    public static final Result ACCOUNT_NOT_EXIST = new Result(Result.ACCOUNT_NOT_EXIST, "帐号不存在");
    public static final Result ACCOUNT_OR_PASSWORD_WRONG = new Result(Result.ACCOUNT_OR_PASSWORD_WRONG, "帐号或者密码错误");
    public static final Result PASSWORD_WRONG = new Result(Result.PASSWORD_WRONG, "密码错误");
    public static final Result ACCOUNT_IS_PULL_THE_BLACK = new Result(Result.ACCOUNT_IS_PULL_THE_BLACK, "账号已被拉黑");
    public static Result No_Authority = new Result(Result.No_Authority, "没有访问权限");
    public static Result No_MakeUpdate = new Result(Result.No_Authority, "没有修改权限");
    private Map<String, Object> result;

    public Results() {
        this.result = Maps.newHashMap();
    }

    public static Results of() {
        return new Results();
    }

    public Results put(String name, Object value) {
        this.result.put(name, value);
        return this;
    }

    public Map<String, Object> toMap() {
        return this.result;
    }

    @ApiModel
    public static class Result<T> implements Serializable {

        // 处理成功
        public final static int SUCCESS = 200;
        // 系统繁忙
        public final static int SYSTEM_BUSY = -1;
        //未注册
        public final static int NO_REGIST = 3000;
        //发送失败
        public final static int SEND_FAIL = 40000;
        // 请求参数有误
        public final static int PARAMETER_INCORRENT = 40002;
        // 帐户已注册
        public final static int ACCOUNT_EXIST = 40003;
        // 帐号或者密码错误
        public final static int ACCOUNT_OR_PASSWORD_WRONG = 40004;
        //账号无效
        public final static int ACCOUNT_INVALID = -40004;
        //暂无权限
        public final static int No_Authority = -40022;
        // 验证码错误
        public final static int CAPTCHA_INCORRENT = 40007;
        // TOKEN失效
        public final static int TOKEN_INCORRECT = 40008;
        // 账号未注册
        public final static int ACCOUNT_NOT_EXIST = 40009;
        //手机验证码失效
        public final static int CAPTCHA_INVALID = 40010;
        // 1分钟内重复发送
        public final static int REPEAT_SEND = 40011;
        //密码错误
        public final static int PASSWORD_WRONG = 40012;
        //账号已被拉黑
        public final static int ACCOUNT_IS_PULL_THE_BLACK = 40013;

        @ApiModelProperty("返回码")
        private int code;
        @ApiModelProperty("返回描述")
        private String msg;
        @JSONField(serialzeFeatures = SerializerFeature.DisableCircularReferenceDetect)
        @ApiModelProperty("返回结果")
        private T result;

        public Result(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Result(int code, String msg, T result) {
            this.code = code;
            this.msg = msg;
            this.result = result;
        }

        public Result(Result rest, T result) {
            this.code = rest.getCode();
            this.msg = rest.getMsg();
            this.result = result;
        }

        public Result() {
        }

        public T getResult() {
            return result;
        }

        public void setResult(T result) {
            this.result = result;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
