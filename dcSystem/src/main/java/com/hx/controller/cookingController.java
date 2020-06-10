package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Table;
import com.hx.entity.TableState;
import com.hx.entity.cookDetail;
import com.hx.entity.cookingManagement;
import com.hx.service.cookDetailService;
import com.hx.service.cookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by admin on 2020/5/25.
 */
@Controller
@RequestMapping("/cooking")
public class cookingController extends BaseController {
    @Resource
    private cookingService cookingService;

    @Resource
    private cookDetailService cookDetailService;

    //这是查询页面数据的方法
    @RequestMapping("/selectCooking")
    @ResponseBody
    public Object select(cookingManagement cookingManagement,Integer page,Integer rows){
        //这是为了避免查询条件没填写，系统把其当成null.
        if(cookingManagement.getKcOrdernumber()==""){
            cookingManagement.setKcOrdernumber(null);
        }
        //这是调用业务层的查询的方法
        PageInfo<cookingManagement> pageInfo = cookingService.selectServiceAll(cookingManagement,page,rows);
        return getPageMap(pageInfo);
    }

     //这是查询的方法
    @RequestMapping("/orderDetails")
    @ResponseBody
    public Object cookDetail(cookDetail cookDetail,Integer page,Integer rows,@RequestParam("ID") String ID){
        cookDetail.setKcOrdernumber(ID);
        PageInfo<cookDetail> pageInfo = cookDetailService.selectServiceAll(cookDetail,page,rows);
        return getPageMap(pageInfo);
    }

    //这是订单已完成的方法
    @RequestMapping("/cookingDone")
    @ResponseBody
    public int cookingDone(cookingManagement cookingManagement){
        //这是调用业务层的方法
        int i = cookingService.updateByPrimaryKey(cookingManagement,"cookingDone");
        if(i>0) {
            return i;
        }
        return 0;
    }

    //这是做菜订单处理的方法
    @RequestMapping("/orderProcessing")
    @ResponseBody
    public int orderProcessing(cookingManagement cookingManagement){
        int i = cookingService.updateByPrimaryKey(cookingManagement,"orderProcessing");
        if(i>0) {
            return i;
        }
        return 0;
    }

    //这是做菜订单取消的方法
    @RequestMapping("/orderCancellations")
    @ResponseBody
    public int orderCancellations(cookingManagement cookingManagement){
        int i = cookingService.deleteByPrimaryKey(cookingManagement.getKcOrdernumber());
        System.out.println(i);
        if(i>0){
            return i;
        }
        return 0;
    }

    //这是做菜详情的做菜完成的方法
    @RequestMapping("/cookingFinished")
    @ResponseBody
    public int cookingFinished(cookDetail record){
        //如果查询的条件存在菜单和名称一样的情况，查询就会出现异常，因为返回回来的是一个集合对象，而不是单个对象。
        //但实际一般不会存在一个订单点两个相同的菜品的情况，但为了更健壮考虑，可用主键ID配合订单或名称查询，因主键唯一。
        //这是根据id和编号查询该菜品信息
        cookDetail cookDetail = cookDetailService.selectByPrimaryKey(record);
        //这是调用业务层的方法
       int i = cookDetailService.updateByPrimaryKey(cookDetail,"cookingFinished");
       if(i>0){
           return i;
       }
       return 0;
    }

    //这是做菜详情的做菜中的方法
    @RequestMapping("/cookingProgress")
    @ResponseBody
    public int cookingProgress(cookDetail record){
        //根据id和订单号查询该条信息
        cookDetail cookDetail = cookDetailService.selectByPrimaryKey(record);
        //这是调用业务层的方法
        int i = cookDetailService.updateByPrimaryKey(cookDetail,"cookingProgress");
        if(i>0){
            return i;
        }
        return 0;
    }
}
