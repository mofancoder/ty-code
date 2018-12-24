package com.ty.service;

import javax.transaction.Transactional;

@Transactional
public interface BaseService<T,ID> {

    T queryById(ID id);

}
