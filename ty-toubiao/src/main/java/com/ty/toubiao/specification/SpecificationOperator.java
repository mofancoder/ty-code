package com.ty.toubiao.specification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 操作符类，这个类中存储了键值对和操作符号，另外存储了连接下一个条件的类型是and还是or
 * 创建时通过 id>=7,其中id就是key,>=就是oper操作符，7就是value
 * 特殊的自定义几个操作符(:表示like %v%，b:表示v%,:b表示%v)
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationOperator {

    /**
     * key 对应字段名称
     */
    private String key;

    /**
     * key 对应传入的值
     */
    private Object value;

    /**
     * opr对应操作的方式
     */
    private SpecifcationOprEnum opr;

    /**
     * 传入值的类型
     */
    private Class clazz;

    /**
     * 对应连接的方式
     */
    private SpecifcationRelationEnum relation;

}
