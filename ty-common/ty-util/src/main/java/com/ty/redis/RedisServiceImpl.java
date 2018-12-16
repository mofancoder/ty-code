package com.ty.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService{

    @Autowired(required = false)
    public RedisTemplate<String,Object> redisTemplate;

    @Override
    public void save(Object key,String value) {
        redisTemplate.opsForValue().set(key.toString(),value);
    }

    @Override
    public String get(Object key) {
        Object o = redisTemplate.opsForValue().get(key);
        return String.valueOf(o);
    }
}
