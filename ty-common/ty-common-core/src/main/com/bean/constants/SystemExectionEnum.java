package com.bean.constants;

/**
 * 系统异常枚举
 */
public enum SystemExectionEnum implements BaseEnum<String>{

    LOGINEXECTION("1001","系统登录异常"),
    IllegalArgumentException("1002","参数异常");

    private String code;

    private String message;

    private SystemExectionEnum(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static SystemExectionEnum getSystemExectionEnum(String code) {

        for(SystemExectionEnum se : SystemExectionEnum.values()) {
            if(se.getCode().equals(code)) {
                return se;
            }
        }
        return null;
    }

    public static String getName(String code) {

        for(SystemExectionEnum se : SystemExectionEnum.values()) {
            if(se.getCode().equals(code)) {
                return se.name();
            }
        }
        return null;
    }

}
