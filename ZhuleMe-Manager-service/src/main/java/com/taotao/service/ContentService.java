package com.taotao.service;

import com.taotao.common.pojo.EUIResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * Created by lz on 2016/6/14.
 */
public interface ContentService {
    public EUIResult getContentList(Integer page,Integer rows,Long categoryId);
    public TaotaoResult insertContent(TbContent content);
    public List<TbContent> getContentListById(long contentCid);
}
