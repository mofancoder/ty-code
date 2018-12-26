package com.ty.toubiao.dao.impl;

import com.ty.toubiao.bean.UserInfo;
import com.ty.toubiao.dao.UserInfoRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author MOFAN889
 * @ProjectName com.ty.toubiao.dao.impl
 * @Description: TODO
 * @date 2018/12/25 15:29
 */
@Repository
public class UserInfoRepositoryImpl implements UserInfoRepositoryCustom {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserInfo queryById(Integer id) {
        UserInfo userInfo = entityManager.find(UserInfo.class, id);
        return userInfo;
    }

    @Override
    public Page<UserInfo> queryByPage() {
        return null;
    }
}
