package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Parameter;
import com.hx.entity.cookingManagement;
import com.hx.mapper.CookingMapper;
import com.hx.mapper.cookDetailMapper;
import com.hx.service.cookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/5/25.
 */
@Service("cookingService")
public class cookingServiceImpl extends BaseServiceImpl implements cookingService{
    @Autowired
    private CookingMapper cookingMapper;

    @Autowired
    private cookDetailMapper cookDetailMapper;

    @Override
    public <K> int deleteByPrimaryKey(K dcId) {
        //这是删除做菜订单的方法
       int i = cookingMapper.deleteByPrimaryKey(dcId);
       //同步删除做菜订单详情的方法
        int i1 = cookDetailMapper.deleteByPrimaryKey(dcId);//都删除成功返回i；

        if(i>0&&i1>0){
            return i;
        }
        //否则返回0，表示失败！
        return 0;
    }

    @Override
    public int insert(cookingManagement record) {
        return 0;
    }

    @Override
    public int insertSelective(cookingManagement record) {
        return 0;
    }

    @Override
    public <K> cookingManagement selectByPrimaryKey(K dcId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(cookingManagement record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(cookingManagement record) {
        return 0;
    }

    //这是订单完成的方法
    @Override
    public int updateByPrimaryKey(cookingManagement record,String mark) {
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
        cookingManagement cookingManagement = cookingMapper.selectByPrimaryKey(record.getKcOrdernumber());
        record.setKcBacksingular(cookingManagement.getKcBacksingular());
        record.setKcOperation(cookingManagement.getKcOperation());
        record.setKcOrdertime(cookingManagement.getKcOrdertime());
        record.setKcPlaceorder(cookingManagement.getKcPlaceorder());
        record.setKcRmeountshould(cookingManagement.getKcRmeountshould());

       int i = cookingMapper.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public PageInfo<cookingManagement> selectServiceAll(cookingManagement table, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<cookingManagement> list = cookingMapper.selectAll(table);
/*        System.out.println(list);*/
        //这里是获取text值
        for(cookingManagement lsi:list){
            if(lsi.getKcCooking()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("kc_cooking");
                String ui = String.valueOf(lsi.getKcCooking());
                System.out.println(ui);
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setKcCookingText(text);
            }
        }
        /*System.out.print(list.get(0).getKcCooking());*/
        PageInfo<cookingManagement> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
