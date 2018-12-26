package com.ty.toubiao.specification;

import lombok.Data;

/**
 * @author MOFAN889
 * @ProjectName com.ty.toubiao.specification
 * @Description: 操作运算符枚举
 * @date 2018/12/26 9:09
 */
public enum SpecifcationOprEnum {

    EQUAL("=","等于"),
    NOTEQUAL("!=","不等于"),
    GREATERTHAN(">","大于"),
    GREATERTHANOREQUALTO(">=","大于并且等于"),
    LESSTHAN("<","小于"),
    LESSTHANOREQUALTO("<=","小于并且等于"),
    LIKE(":","模糊匹配命中"),//需要自己加%
    NOTLIKE("!:","模糊查询不命中"),//需要自己加%
    ISNULL("null","是否为空"),
    NOTNULL("!null","不为空"),
    ISTRUE("isTrue","是否为真"),
    ISFALSE("isFalse","是否为假"),
    BETWEEN("between","在某个区间");

    private String code;

    private String describe;

    private SpecifcationOprEnum(String code,String describe){
        this.code = code;
        this.describe = describe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


    public static SpecifcationOprEnum getSystemExectionEnum(String code) {

        for(SpecifcationOprEnum se : SpecifcationOprEnum.values()) {
            if(se.getCode().equals(code)) {
                return se;
            }
        }
        return null;
    }

    public static String getName(String code) {

        for(SpecifcationOprEnum se : SpecifcationOprEnum.values()) {
            if(se.getCode().equals(code)) {
                return se.name();
            }
        }
        return null;
    }

}
