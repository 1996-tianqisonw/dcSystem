package com.hx.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Parameter;
import com.hx.entity.cookDetail;
import com.hx.mapper.cookDetailMapper;
import com.hx.service.cookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/5/25.
 */
@Service
public class cookDetailServiceImpl extends BaseServiceImpl implements cookDetailService {

    @Autowired
    private cookDetailMapper cookDetailMapper;

    @Override
    public <K> int deleteByPrimaryKey(K dcId) {
        return 0;
    }

    @Override
    public int insert(cookDetail record) {
        return 0;
    }

    @Override
    public int insertSelective(cookDetail record) {
        return 0;
    }

    @Override
    public <K> cookDetail selectByPrimaryKey(K dcId) {
        cookDetail cookDetail = cookDetailMapper.selectByPrimaryKey(dcId);
        return cookDetail;
    }

    @Override
    public int updateByPrimaryKeySelective(cookDetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(cookDetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(cookDetail record,String mark) {

        if(mark.equals("cookingFinished")){
            record.setDsStatus(3);
        }else if(mark.equals("cookingProgress")){
           record.setDsStatus(2);
        }
        int i = cookDetailMapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public PageInfo<cookDetail> selectServiceAll(cookDetail table, Integer pageIndex, Integer pageSize) {
        System.out.print(table.getKcOrdernumber());
        PageHelper.startPage(pageIndex,pageSize);
        List<cookDetail> list = cookDetailMapper.selectAll(table);
        for(cookDetail lsi:list){
            if(lsi.getDsStatus()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("ds_status");
                String ui = String.valueOf(lsi.getDsStatus());
                System.out.println(ui);
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDsStatusText(text);
            }
            if(lsi.getDsComponent()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("ds_component");
                String ui = String.valueOf(lsi.getDsComponent());
                System.out.println(ui);
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
        PageInfo<cookDetail> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
