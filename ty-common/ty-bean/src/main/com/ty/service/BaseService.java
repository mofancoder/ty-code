package com.ty.service;

import com.hello.dto.HelloDto;

import javax.transaction.Transactional;

@Transactional
public interface BaseService<T,ID> {

    T queryById(ID id);

}
