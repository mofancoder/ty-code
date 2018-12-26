package com.ty.toubiao.dao;

import com.ty.toubiao.bean.UserInfo;
import org.springframework.data.domain.Page;

/**
 * @author MOFAN889
 * @ProjectName com.ty.toubiao.dao
 * @Description: TODO
 * @date 2018/12/25 16:10
 */
public interface UserInfoRepositoryCustom {

    public UserInfo queryById(Integer id);

    public Page<UserInfo> queryByPage();

}
