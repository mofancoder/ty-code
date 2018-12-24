package com.ty.zhaobiao.dao;

import com.bean.dto.HelloDto;
import com.ty.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author MOFAN889
 * @ProjectName ty-core
 * @Description: helloDao
 * @date 2018/12/23 002316:02
 */
@Repository
public interface HelloDao extends BaseDao<HelloDto,String>, Serializable {

}
