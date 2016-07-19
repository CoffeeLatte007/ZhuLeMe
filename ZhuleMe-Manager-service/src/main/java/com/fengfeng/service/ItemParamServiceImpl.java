package com.fengfeng.service;

import com.fengfeng.pojo.TbItemParam;
import com.fengfeng.pojo.TbItemParamExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fengfeng.common.pojo.EUIResult;
import com.fengfeng.common.pojo.FengfengResult;
import com.fengfeng.mapper.TbItemParamMapper;
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
    public FengfengResult getItemParamByCid(long cid) {
        TbItemParamExample example=new TbItemParamExample();
        TbItemParamExample.Criteria criteria=example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        if (list != null && !list.isEmpty()){
            return FengfengResult.ok(list.get(0));
        }
        return FengfengResult.ok();
    }

    @Override
    public FengfengResult insertItemParam(long cid,String itemParam) {
        //创建TbItemParam对象
        TbItemParam param =new TbItemParam();
        param.setItemCatId(cid);
        param.setParamData(itemParam);
        param.setCreated(new Date());
        param.setUpdated(new Date());
        itemParamMapper.insert(param);
        return FengfengResult.ok();
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
