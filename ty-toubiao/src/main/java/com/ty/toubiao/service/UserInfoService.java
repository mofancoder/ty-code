package com.ty.toubiao.service;

import com.ty.toubiao.bean.UserInfo;

import javax.transaction.Transactional;

/**
 * @author MOFAN889
 * @ProjectName com.ty.toubiao.service
 * @Description: TODO
 * @date 2018/12/25 15:03
 */
@Transactional
public interface UserInfoService {
    UserInfo getOne(Integer id);

    /**
     * 原生sql及hql测试：占位符
     * @param id
     * @return
     */
    UserInfo test1(Integer id);

    /**
     * 原生sql及hql测试？占位符
     * @param id
     * @return
     */
    UserInfo test2(Integer id);

    /**
     * 原生sql及hql测试 delete操作
     * @param id
     * @return
     */
    UserInfo test3(Integer id);

    /**
     * 分页查询
     * @param id
     * @return
     */
    UserInfo test4(Integer id);
}
