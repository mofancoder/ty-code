package com.ty.toubiao.specification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MOFAN889
 * @ProjectName com.ty.toubiao.specification
 * @Description: 连接关系枚举
 * @date 2018/12/26 9:09
 */
public enum SpecifcationRelationEnum {

    AND("and","与"),
    OR("or","或");

    private String code;

    private String describe;

    private SpecifcationRelationEnum(String code, String describe){
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


    public static SpecifcationRelationEnum getSystemExectionEnum(String code) {

        for(SpecifcationRelationEnum se : SpecifcationRelationEnum.values()) {
            if(se.getCode().equals(code)) {
                return se;
            }
        }
        return null;
    }

    public static String getName(String code) {

        for(SpecifcationRelationEnum se : SpecifcationRelationEnum.values()) {
            if(se.getCode().equals(code)) {
                return se.name();
            }
        }
        return null;
    }

}
