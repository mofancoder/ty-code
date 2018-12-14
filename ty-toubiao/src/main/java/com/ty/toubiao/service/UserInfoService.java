package com.ty.toubiao.service;

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
public interface UserInfoService extends JpaRepository<UserInfo,Integer>, JpaSpecificationExecutor<BetRecd>, Serializable {


}
