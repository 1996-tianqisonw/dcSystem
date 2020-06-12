package com.hx.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Parameter;
import com.hx.entity.CookDetail;
import com.hx.service.CookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/5/25.
 */
@Service
public class CookDetailServiceImpl extends BaseServiceImpl<CookDetail> implements CookDetailService {
    @Override
    public <K> int deleteByPrimaryKey(K dcId) {
        return 0;
    }

    @Override
    public int insert(CookDetail record) {
        return 0;
    }

    @Override
    public int insertSelective(CookDetail record) {
        return 0;
    }

    @Override
    public <K> CookDetail selectByPrimaryKey(K dcId) {
        CookDetail cookDetail = cookDetailMapper.selectByPrimaryKey(dcId);
        return cookDetail;
    }

    @Override
    public int updateByPrimaryKeySelective(CookDetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CookDetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CookDetail record, String mark) {

        if(mark.equals("cookingFinished")){
            record.setDsStatus(3);
        }else if(mark.equals("cookingProgress")){
           record.setDsStatus(2);
        }
        int i = cookDetailMapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public PageInfo<CookDetail> selectServiceAll(CookDetail table, Integer pageIndex, Integer pageSize) {
        //这里是封装当前页和页大小
        PageHelper.startPage(pageIndex,pageSize);
        //查询所有的数据
        List<CookDetail> list = cookDetailMapper.selectAll(table);
        //与系统参数匹配，返回相对应的值
        for(CookDetail lsi:list){
            if(lsi.getDsStatus()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("ds_status");
                String ui = String.valueOf(lsi.getDsStatus());
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDsStatusText(text);
            }
            if(lsi.getDsComponent()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("ds_component");
                String ui = String.valueOf(lsi.getDsComponent());
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDsComponentText(text);
            }
            if(lsi.getDsDegreechilli()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("ds_degreeChilli");
                String ui = String.valueOf(lsi.getDsDegreechilli());
                System.out.println(ui);
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDsDegreeechilliText(text);
            }
        }
        PageInfo<CookDetail> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
