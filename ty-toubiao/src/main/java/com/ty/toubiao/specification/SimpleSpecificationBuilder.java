package com.ty.toubiao.specification;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MOFAN889
 * @ProjectName com.ty.toubiao.specification
 * @Description: 操作运算符枚举
 * @date 2018/12/26 9:09
 */
public class SimpleSpecificationBuilder<T> {

    /**
     * 条件列表
     */
    private List<SpecificationOperator> opers;
    
	public static<T> SimpleSpecificationBuilder init() {
    	return new SimpleSpecificationBuilder<T>();
    }

    /**
     * 构造函数，初始化的条件是and
     */
    public SimpleSpecificationBuilder(String key,Object value,SpecifcationOprEnum opr,Class clazz) {
        SpecificationOperator so = new SpecificationOperator();
        so.setRelation(SpecifcationRelationEnum.AND);
        so.setKey(key);
        so.setOpr(opr);
        so.setValue(value);
        so.setClazz(clazz);
        opers = new ArrayList<SpecificationOperator>();
        opers.add(so);
    }

    public SimpleSpecificationBuilder() {
        opers = new ArrayList<SpecificationOperator>();
    }

    /**
     * 完成条件的添加
     * @return
     */
    private SimpleSpecificationBuilder<T> add(String key,Object value,SpecifcationOprEnum opr,SpecifcationRelationEnum relation,Class clazz) {
        SpecificationOperator so = new SpecificationOperator();
        so.setKey(key);
        so.setValue(value);
        so.setOpr(opr);
        so.setRelation(relation);
        so.setClazz(clazz);
        opers.add(so);
        return this;
    }

    /**
     * 添加or条件的重载
     * @return this，方便后续的链式调用
     */
    public SimpleSpecificationBuilder<T> addOr(String key,Object value,SpecifcationOprEnum opr,Class clazz) {
        return this.add(key,value,opr,SpecifcationRelationEnum.OR,clazz);
    }

    /**
     * 添加and的条件
     * @return
     */
    public SimpleSpecificationBuilder<T> addAnd(String key,Object value,SpecifcationOprEnum opr,Class clazz) {
        return this.add(key,value,opr,SpecifcationRelationEnum.AND,clazz);
    }


    public Specification<T> generateSpecification() {
        Specification<T> specification = new SimpleSpecification<T>(opers);
        return specification;
    }
}