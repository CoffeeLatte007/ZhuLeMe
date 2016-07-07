package com.taotao.service;

import com.taotao.common.pojo.EUITreeNode;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lz on 2016/6/13.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<EUTreeNode> getCategoryList(long parentId) {
        //使用parentid查询节点列表
        TbContentCategoryExample example=new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria=example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbContentCategory> list=contentCategoryMapper.selectByExample(example);
        List<EUTreeNode> resultList=new ArrayList<>();
        for (TbContentCategory tbContentCategory : list){
            //创建一个节点
            EUTreeNode node=new EUTreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            node.setParentId(tbContentCategory.getParentId());
            resultList.add(node);
        }
        return resultList;
    }

    /**
     * 这里能添加的广告只有是叶子节点
     * @param parentId
     * @param name
     * @return
     */
    @Override
    public TaotaoResult insertContentCategory(long parentId, String name) {
        //创建一个pojo
        TbContentCategory contentCategory=new TbContentCategory();
        contentCategory.setName(name);
        contentCategory.setIsParent(false);
        //状态。可选值:1(正常)，2(删除)
        contentCategory.setStatus(1);
        contentCategory.setParentId(parentId);
        contentCategory.setSortOrder(1);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        //添加记录
        contentCategoryMapper.insert(contentCategory);
        //查看父节点isParent列是否为true，如果不是true变为true
        TbContentCategory parentCat=contentCategoryMapper.selectByPrimaryKey(parentId);
        //判断是否为true
        if (!parentCat.getIsParent()){
            parentCat.setIsParent(true);
            //更新父节点
            contentCategoryMapper.updateByPrimaryKey(parentCat);
        }
        //返回结果
        return TaotaoResult.ok(contentCategory);
    }

    @Override
    public TaotaoResult deleteContentCategory(Long parentId, Long id) {
        contentCategoryMapper.deleteByPrimaryKey(id);
        TbContentCategoryExample example=new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria=example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> list=contentCategoryMapper.selectByExample(example);
        if (list.size()==0){
            TbContentCategory parentCat=contentCategoryMapper.selectByPrimaryKey(parentId);
            parentCat.setIsParent(false);
            //更新
            contentCategoryMapper.updateByPrimaryKey(parentCat);
        }
        return TaotaoResult.ok();
    }
}
