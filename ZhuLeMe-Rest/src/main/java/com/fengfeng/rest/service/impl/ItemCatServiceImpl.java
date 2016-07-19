package com.fengfeng.rest.service.impl;

import com.fengfeng.mapper.TbItemCatMapper;
import com.fengfeng.pojo.TbItemCat;
import com.fengfeng.pojo.TbItemCatExample;
import com.fengfeng.rest.pojo.ItemCat;
import com.fengfeng.rest.pojo.ItemCatResult;
import com.fengfeng.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lz on 2016/6/12.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public ItemCatResult queryAllCategory() {
        ItemCatResult result=new ItemCatResult();
        result.setData(getItemCatList(0));
        return result;
    }

    /**
     * 查询分类列表
     * @param parentid
     * @return
     */
    private List<?> getItemCatList(long parentid) {
        TbItemCatExample example=new TbItemCatExample();
        TbItemCatExample.Criteria criteria= example.createCriteria();
        //传入为0首先查为0的
        criteria.andParentIdEqualTo(parentid);
        List<TbItemCat> list=itemCatMapper.selectByExample(example);
        List dataList = new ArrayList();
        int count = 0;
        for (TbItemCat tbItemCat : list){
            //判断是否为父节点
            if (tbItemCat.getIsParent()){
               ItemCat itemCat=new ItemCat();
                if (parentid == 0){
                    itemCat.setName("<a href='/products/'"+tbItemCat.getId()+".html'>" + tbItemCat.getName()+"</a>");
                }else {
                    itemCat.setName(tbItemCat.getName());
                }
                itemCat.setUrl("/products/"+tbItemCat.getId()+".html");
                itemCat.setItem(getItemCatList(tbItemCat.getId()));
                dataList.add(itemCat);
                count ++;
                //第一层只取14条记录
                if (parentid == 0 && count >=14){
                    break;
                }
                //如果是叶子节点
            }else {
                dataList.add("/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName());
            }
        }
        return dataList;
    }
}
