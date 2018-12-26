package com.ty.toubiao.base;

import com.google.common.collect.Lists;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author MOFAN889
 * @ProjectName com.ty.toubiao.base
 * @Description: 自定义sql以及hql工具类使用？占位符
 * @date 2018/12/26 11:23
 */
public class NativeFinder {

    private EntityManager entityManager;

    private List<Object> list;

    private NativeFinder(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.list = Lists.newArrayList();
    }

    public static NativeFinder init(EntityManager entityManager){
        return new NativeFinder(entityManager);
    }

    public void setParameter(Object object){
        list.add(object);
    }

    public void clearParameter(){
        list.clear();
    }

    /**
     * 通过sql更新数据
     * @param sql 语句
     * @param args 参数
     */
    public void modifyBySql(String sql,Object... args){
        Query query = entityManager.createNativeQuery(sql);
        setQueryParameter(query,false);
        query.executeUpdate();
    }

    /**
     * 通过hql更新数据
     * @param hql hql语句
     * @param args 参数
     */
    public void modifyByHql(String hql,Object... args){
        Query query = entityManager.createQuery(hql);
        setQueryParameter(query,true);
        query.executeUpdate();
    }

    /**
     * 通过sql查询语句
     * @param sql
     * @return
     */
    public List queryBySql(String sql){
        Query query = entityManager.createNativeQuery(sql);
        setQueryParameter(query,false);
        return query.getResultList();
    }

    /**
     * 通过hql查询
     * @param hql
     * @return
     */
    public List queryByHql(String hql){
        Query query = entityManager.createQuery(hql);
        setQueryParameter(query,true);
        return query.getResultList();
    }

    private void setQueryParameter(Query query,boolean isHql){
        if(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                if(isHql)
                    query.setParameter(i,list.get(i));
                else
                    query.setParameter(i+1,list.get(i));
            }
        }
    }

}
