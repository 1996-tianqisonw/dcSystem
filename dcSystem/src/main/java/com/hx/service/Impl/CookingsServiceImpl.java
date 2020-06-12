package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Cooking;
import com.hx.entity.Parameter;
import com.hx.service.CookingsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/6/11.
 */
@Service
public class CookingsServiceImpl extends BaseServiceImpl<Cooking> implements CookingsService {
    @Override
    public <K> int deleteByPrimaryKey(K dcId) {
        //这是删除做菜订单的方法
        int i = cookingMapper.deleteByPrimaryKey(dcId);
        //同步删除做菜订单详情的方法
        int i1 = cookDetailMapper.deleteByPrimaryKey(dcId);//都删除成功返回i；

        if(i>0){
            return i;
        }
        //否则返回0，表示失败！
        return 0;
    }


    //这是订单完成的方法
    @Override
    public int updateByPrimaryKey(Cooking record,String mark) {
        /*
        1.根据界面的要求修改订单的状态
        2.查询出来该订单的信息，在重新赋值回去
        */
        //根据界面要求修改订单的状态,1代表未处理 2代表处理中 3代表已完成
        if(mark.equals("cookingDone")) {
            record.setKcCooking(3);
        }else if(mark.equals("orderProcessing")){
            record.setKcCooking(2);
        }

        //将查询的数据赋值回去
        Cooking cookingManagement = cookingMapper.selectByPrimaryKey(record.getKcOrdernumber());
        record.setKcBacksingular(cookingManagement.getKcBacksingular());
        record.setKcOperation(cookingManagement.getKcOperation());
        record.setKcOrdertime(cookingManagement.getKcOrdertime());
        record.setKcPlaceorder(cookingManagement.getKcPlaceorder());
        record.setKcRmeountshould(cookingManagement.getKcRmeountshould());

        int i = cookingMapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public PageInfo<Cooking> selectServiceAll(Cooking table, Integer pageIndex, Integer pageSize) {
        //这是为了避免查询条件没填写，系统把其当成null.
        if(table.getKcOrdernumber()==""){
            table.setKcOrdernumber(null);
        }
        if(table.getKcCooking()==null){
            table.setKcCooking(0);
        }

        PageHelper.startPage(pageIndex,pageSize);
        List<Cooking> list = cookingMapper.selectAll(table);
        //这里是获取text值
        for(Cooking lsi:list){
            if(lsi.getKcCooking()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("kc_cooking");
                String ui = String.valueOf(lsi.getKcCooking());
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setKcCookingText(text);
            }
        }
        PageInfo<Cooking> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
