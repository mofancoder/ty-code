package com.ty.redis;

public interface RedisService {

    public void save(Object key,String value);

    public String get(Object key);

}
