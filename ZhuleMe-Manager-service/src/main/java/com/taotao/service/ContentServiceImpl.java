package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUIResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TaotaoResult insertContent(TbContent content) {
        content.setCreated(new Date());
        content.setUpdated(new Date());
        tbContentMapper.insert(content);
        //添加同步逻辑
        try{
            HttpClientUtil.doGet("localhost:8081/cache/sync/content/"+content.getCategoryId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return TaotaoResult.ok();
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
