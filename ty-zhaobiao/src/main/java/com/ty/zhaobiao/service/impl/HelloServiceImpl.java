package com.ty.zhaobiao.service.impl;

import com.bean.dto.HelloDto;
import com.ty.zhaobiao.dao.HelloDao;
import com.ty.zhaobiao.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MOFAN889
 * @ProjectName ty-core
 * @Description: helloServiec
 * @date 2018/12/23 002316:12
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService  {

    private HelloDao helloDao;

    @Autowired
    public HelloServiceImpl(HelloDao helloDao){
        this.helloDao = helloDao;
    }

    @Override
    public HelloDto queryById(String id) {
        return helloDao.getOne(id);
    }
}
