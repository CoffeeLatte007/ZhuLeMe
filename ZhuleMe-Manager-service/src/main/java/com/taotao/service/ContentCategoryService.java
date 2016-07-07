package com.taotao.service;

import com.taotao.common.pojo.EUITreeNode;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * Created by lz on 2016/6/13.
 */
public interface ContentCategoryService {
    public List<EUTreeNode> getCategoryList(long parentId);
    public TaotaoResult insertContentCategory(long parentId,String name);

    public TaotaoResult deleteContentCategory(Long parentId, Long id);
}
