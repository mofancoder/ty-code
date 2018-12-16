package com.ty.toubiao.dao;

import com.ty.toubiao.bean.BetRecd;
import com.ty.toubiao.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * UserInfo jpa service
 */
@Service
public interface UserInfoDao extends JpaRepository<UserInfo,Integer>, JpaSpecificationExecutor<BetRecd>, Serializable {


}
