package com.bean.constants;

/**
 * @author MOFAN889
 * @ProjectName com.bean.enums
 * @Description: 枚举基类接口
 * @date 2018/12/2412:02
 */
public interface  BaseEnum<T> {

    public T getCode();

    public String name();

    public String getMessage() ;

}
