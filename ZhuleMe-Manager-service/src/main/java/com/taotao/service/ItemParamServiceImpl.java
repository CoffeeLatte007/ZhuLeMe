package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUIResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lz on 2016/6/11.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    TbItemParamMapper itemParamMapper;
    @Override
    public TaotaoResult getItemParamByCid(long cid) {
        TbItemParamExample example=new TbItemParamExample();
        TbItemParamExample.Criteria criteria=example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        if (list != null && !list.isEmpty()){
            return TaotaoResult.ok(list.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(long cid,String itemParam) {
        //创建TbItemParam对象
        TbItemParam param =new TbItemParam();
        param.setItemCatId(cid);
        param.setParamData(itemParam);
        param.setCreated(new Date());
        param.setUpdated(new Date());
        itemParamMapper.insert(param);
        return TaotaoResult.ok();
    }

    @Override
    public EUIResult getItemList(Integer page, Integer rows) {
        TbItemParamExample example=new TbItemParamExample();
        PageHelper.startPage(page, rows);
        List<TbItemParam> list=itemParamMapper.selectByExampleWithBLOBs(example);
        EUIResult result=new EUIResult();
        result.setRows(list);
        PageInfo<TbItemParam> pageInfo=new PageInfo<TbItemParam>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
