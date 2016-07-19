package com.fengfeng.rest.service;

import com.fengfeng.common.pojo.FengfengResult;
import org.springframework.stereotype.Service;

/**
 * Created by lz on 2016/6/16.
 */
@Service
public interface RedisService {
    public FengfengResult syncContent(long contentCid);
}
