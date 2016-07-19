package com.fengfeng.rest.service.impl;

import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.common.utils.ExceptionUtil;
import com.fengfeng.rest.dao.JedisClient;
import com.fengfeng.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by lz on 2016/6/16.
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private JedisClient jedisClient;
    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;
    @Override
    public FengfengResult syncContent(long contentCid) {
        try{
            jedisClient.hdel(INDEX_CONTENT_REDIS_KEY,contentCid+"");
        }catch (Exception e){
            e.printStackTrace();
            return FengfengResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return FengfengResult.ok();
    }
}
