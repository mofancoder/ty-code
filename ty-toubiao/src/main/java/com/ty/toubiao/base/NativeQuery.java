package com.ty.toubiao.base;

import com.google.common.collect.Maps;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

/**
 * @author MOFAN889
 * @ProjectName com.ty.toubiao.base
 * @Description: 自定义sql以及hql工具类,使用:占位符
 * @date 2018/12/26 11:23
 */
public class NativeQuery {

    private EntityManager entityManager;

    private Map<String,Object> map;

    private NativeQuery(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.map = Maps.newHashMap();
    }

    /**
     * 初始化参数
     * @param entityManager
     * @return
     */
    public static NativeQuery init(EntityManager entityManager){
        return new NativeQuery(entityManager);
    }

    public void setParameter(String key,Object value){
        map.put(key,value);
    }

    public void clearParameter(){
        map.clear();
    }

    /**
     * 通过sql更新数据
     * @param sql 语句
     */
    public void modifyBySql(String sql){
        Query query = entityManager.createNativeQuery(sql);
        setQueryParameter(query);
        query.executeUpdate();
    }

    /**
     * 通过hql更新数据
     * @param hql hql语句
     */
    public void modifyByHql(String hql){
        Query query = entityManager.createQuery(hql);
        setQueryParameter(query);
        query.executeUpdate();
    }

    /**
     * 通过sql查询语句
     * @param sql
     * @return
     */
    public List queryBySql(String sql){
        Query query = entityManager.createNativeQuery(sql);
        setQueryParameter(query);
        return query.getResultList();
    }

    /**
     * 通过hql查询
     * @param hql
     * @return
     */
    public List queryByHql(String hql){
        Query query = entityManager.createQuery(hql);
        setQueryParameter(query);
        return query.getResultList();
    }

    private void setQueryParameter(Query query){
        if(map!=null){
            for (Map.Entry<String, Object> entrySet : map.entrySet()) {
                query.setParameter(entrySet.getKey(),entrySet.getValue());
            }
        }
    }

}
