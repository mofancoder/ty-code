package com.ty.toubiao.dao;

import com.ty.toubiao.base.bak.BaseRepository;
import com.ty.toubiao.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * UserInfo jpa service
 */
@Repository
public interface UserInfoRepository extends BaseRepository<UserInfo, Integer>,UserInfoRepositoryCustom, JpaSpecificationExecutor<UserInfo> {

}
