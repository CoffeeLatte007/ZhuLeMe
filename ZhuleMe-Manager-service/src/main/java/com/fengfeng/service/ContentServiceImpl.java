package com.fengfeng.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fengfeng.common.pojo.EUIResult;
import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.common.utils.HttpClientUtil;
import com.fengfeng.mapper.TbContentMapper;
import com.fengfeng.pojo.TbContent;
import com.fengfeng.pojo.TbContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 内容管理
 * Created by lz on 2016/6/14.
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    TbContentMapper tbContentMapper;
    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_CONTENT_SYNC_URL}")
    private String REST_CONTENT_SYNC_URL;
    @Override
    public EUIResult getContentList(Integer page, Integer rows, Long categoryId) {
        TbContentExample contentExample=new TbContentExample();
        TbContentExample.Criteria criteria=contentExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        PageHelper.startPage(page, rows);
        List<TbContent> list = tbContentMapper.selectByExample(contentExample);
        EUIResult result = new EUIResult();
        result.setRows(list);
        PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public FengfengResult insertContent(TbContent content) {
        content.setCreated(new Date());
        content.setUpdated(new Date());
        tbContentMapper.insert(content);
        //添加同步逻辑
        try{
            HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL+content.getCategoryId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return FengfengResult.ok();
    }

    @Override
    public List<TbContent> getContentListById(long contentCid) {
        //根据内容分类id查询内容列表
        TbContentExample example=new TbContentExample();
        TbContentExample.Criteria criteria=example.createCriteria();
        criteria.andCategoryIdEqualTo(contentCid);
        List<TbContent> list=tbContentMapper.selectByExample(example);
        return list;
    }
}
