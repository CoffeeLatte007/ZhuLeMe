package com.fengfeng.service;

import com.fengfeng.common.pojo.EUITreeNode;
import com.fengfeng.mapper.TbItemCatMapper;
import com.fengfeng.pojo.TbItemCat;
import com.fengfeng.pojo.TbItemCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lz on 2016/6/4.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public List<EUITreeNode> getItemCatList(long parentId) {
        TbItemCatExample example=new TbItemCatExample();
        //设置查询条件
        TbItemCatExample.Criteria criteria=example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list=itemCatMapper.selectByExample(example);
        //转换成EUITreeNode列表
        List<EUITreeNode> resultList=new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            EUITreeNode node=new EUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            resultList.add(node);
        }
        return resultList;
    }
}
