package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lz on 2016/6/16.
 */
@Service
public interface RedisService {
    public TaotaoResult syncContent(long contentCid);
}
