package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Parameter;
import com.hx.entity.Table;
import com.hx.entity.TableState;
import com.hx.entity.cookingManagement;
import com.hx.mapper.TableStateMapper;
import com.hx.service.tableStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2020/5/24.
 */
@Service("tableStateService")
public class tableStateServiceImpl extends BaseServiceImpl implements tableStateService {

    @Autowired
    private TableStateMapper tableStateMapper;

    @Override
    public <K> int deleteByPrimaryKey(K dcId) {
        int i = tableStateMapper.deleteByPrimaryKey(dcId);
        return i;
    }

    @Override
    public int insert(TableState record) {
        System.out.print(record.getDtId());
        int i = tableStateMapper.insert(record);
        return i;
    }

    @Override
    public int insertSelective(TableState record) {
        return 0;
    }

    @Override
    public <K> TableState selectByPrimaryKey(K dcId) {
       TableState tableState = tableStateMapper.selectByPrimaryKey(dcId);
        return tableState;
    }

    @Override
    public int updateByPrimaryKeySelective(TableState record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TableState tableState) {
        //如果所传字符长度为1，代表为char的数字,否则为字符串
        System.out.println(tableState.getDtEnvironmentText().length());
        if(tableState.getDtEnvironmentText().length()==1){
            tableState.setDtEnvironment(Integer.valueOf(tableState.getDtEnvironmentText()));
        }else {
            //如果所传数据为堂厅，则为1
            if ((tableState.getDtEnvironmentText()).equals("堂厅")) {
                System.out.println(tableState.getDtEnvironmentText());
                tableState.setDtEnvironment(1);
                //如果所传数据为包厢，则为2
            } else if ((tableState.getDtEnvironmentText()).equals("包厢")) {
                tableState.setDtEnvironment(2);
            }
        }
        //这是调用dao层的方法
        int i = tableStateMapper.updateByPrimaryKey(tableState);
        return i;
    }

    @Override
    public PageInfo<TableState> selectServiceAll(TableState table, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TableState> list = tableStateMapper.selectAll(table);
        for(TableState lsi:list){
            if(lsi.getDtEnvironment()!=null){
                Parameter parameter = new Parameter();
                parameter.setField("dt_environment");
                String ui = String.valueOf(lsi.getDtEnvironment());
                System.out.println(ui);
                parameter.setValue(ui);
                String text = sysParameterCheck(parameter);
                lsi.setDtEnvironmentText(text);
            }
        }
        PageInfo<TableState> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    //这是已完成的方法
    @Override
    public int stateUsedUp(TableState tableState) {
        /*
        页面传来已完成，代表客户用餐完成。
        1.将该餐桌的相关客户信息清除
        2.将餐桌状态置为可使用
        3.提交并修改
        */
        //将餐桌的相关信息清除，因该tableState的信息为空，正好符合，所以保留相关信息
        tableState.setDtEndtime(null);
        tableState.setDtStarttime(null);
        tableState.setDtNewtime(getSystemTime());
        TableState tableState1 = selectByPrimaryKey(tableState.getDtId());
        tableState.setDtCreatetime(tableState1.getDtCreatetime());

        //将餐桌状态置为可用

        //这是提交并修改
        int i = tableStateMapper.stateUsedUp(tableState);
        return i;
    }
}
