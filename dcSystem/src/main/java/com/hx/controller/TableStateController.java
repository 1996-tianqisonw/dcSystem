package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.TableState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by admin on 2020/5/24.
 */
@Controller
@RequestMapping("/tableState")
public class TableStateController extends BaseController{

    //这是查询界面的所有数据的方法
    @RequestMapping("/stateSelect")
    @ResponseBody
    public Object stateSelect(TableState tableState,Integer page,Integer rows){
        //这是为了避免查询条件没填写，系统把其当成null.
        if(tableState.getDtEnvironment()==null){
            tableState.setDtEnvironment(0);
        }
        if(tableState.getDtId()==""){
            tableState.setDtId(null);
        }
        if(tableState.getDtUsername()==""){
            tableState.setDtUsername(null);
        }
        //这是调用业务层的查询的方法
       PageInfo<TableState> pageInfo = tableStateService.selectServiceAll(tableState,page,rows);
       return getPageMap(pageInfo);
    }

    //这是修改的方法
    @RequestMapping("/stateUpdate")
    @ResponseBody
    public int stateUpdate(TableState tableState){
        //这是调用业务层的方法
        int i = tableStateService.updateByPrimaryKey(tableState);
        if(i>0){
            return i;
        }
        return 0;
    }

    @RequestMapping("/stateUsedUp")
    @ResponseBody
    public int stateUseUp(TableState tableState){
        //这是将id放入类中。
        tableState.setDtId(tableState.getDtId());
        //这是调用业务层的完成方法。
        int i = tableStateService.stateUsedUp(tableState);
        if(i>0){
            return i;
        }
        return 0;
    }
}
