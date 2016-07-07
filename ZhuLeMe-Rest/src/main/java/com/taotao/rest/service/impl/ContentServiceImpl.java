package com.taotao.rest.service.impl;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lz on 2016/6/15.
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    TbContentMapper tbContentMapper;
    @Autowired
    JedisClient jedisClient;
    @Value("INDEX_CONTENT_REDIS_KEY")
    String INDEX_CONTENT_REDIS_KEY;
    @Override
    public List<TbContent> getContentListById(long contentCid) {
        //从缓存中取内容
        try{
            String result=jedisClient.hget(INDEX_CONTENT_REDIS_KEY,contentCid+"");
            if (!StringUtils.isBlank(result)){
                //转换为List
                List<TbContent> res= JsonUtils.jsonToList(result,TbContent.class);
                return res;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //根据内容分类id查询内容列表
        TbContentExample example=new TbContentExample();
        TbContentExample.Criteria criteria=example.createCriteria();
        criteria.andCategoryIdEqualTo(contentCid);
        List<TbContent> list=tbContentMapper.selectByExample(example);
        //向缓存中添加内容
        try {
            //把list转换成字符串
            String cacheString = JsonUtils.objectToJson(list);
            jedisClient.hset(INDEX_CONTENT_REDIS_KEY,contentCid+"",cacheString);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
