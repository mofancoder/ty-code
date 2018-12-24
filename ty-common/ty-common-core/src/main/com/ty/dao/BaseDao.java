package com.ty.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author MOFAN889
 * @ProjectName ty-core
 * @Description: 基础DAO对象
 * @date 2018/12/23 002316:15
 */
@NoRepositoryBean
public interface BaseDao<T,ID> extends JpaRepository<T,ID>, JpaSpecificationExecutor<T>, Serializable {

}
