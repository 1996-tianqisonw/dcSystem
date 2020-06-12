package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Table;
import com.hx.entity.TableState;
import com.hx.exceptions.CustomEcxeption;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.net.HttpCookie;

/**
 * Created by admin on 2020/5/20.
 */
@Controller
@RequestMapping("/tableController")
public class TableController extends BaseController {
    @RequestMapping("/table")
    @ResponseBody
    public Object table(Table table,Integer page,Integer rows){
        System.out.println(page+","+rows);
        //这是调用业务层的查询全部的方法
        PageInfo<Table> pageInfo = tableService.selectServiceAll(table,page,rows);
        return getPageMap(pageInfo);
    }

    //这是添加餐桌的controller方法
    @RequestMapping("/insert")
    @ResponseBody
    public int insert(Table table,HttpSession httpSession) throws Exception {
        //这是将界面的数据转换成数据库表对应的数据
        table.setDcId(table.getDcId());
        table.setDcName(table.getDcName());
        table.setDcForm(Integer.valueOf(table.getDcFormText()));
        table.setDcUsestatus(Integer.valueOf(table.getDcUsestatusText()));
        table.setDcSpecifications(Integer.valueOf(table.getDcSpecificationsText()));
        table.setDcShop(table.getDcShop());
        table.setDcCompanies(table.getDcCompanies());
        //这是实现双业务的同步
        TableState tableState = new TableState();
        tableState.setDtId(table.getDcId());
        //这是调用业务层的添加的方法
        int i = tableService.insert(table);
        //实现与状态表的同步
        int i1 = tableStateService.insert(tableState);
        if(i>0&&i1>0){
            return 1;
        }
        return 0;
    }

    //这是修改餐桌的controller方法
    @RequestMapping("/update")
    @ResponseBody
    public int update(Table table) throws CustomEcxeption, ClassNotFoundException {
        //这是根据界面的数据进行餐桌的数据处理
        table.setDcId(table.getDcId());
        table.setDcName(table.getDcName());
        //因为修改会带原有的界面信息，除非进行改动。
        //进行修改的项为一个单数字字符，将其转换为Integer
        if(table.getDcFormText().length()==1) {
            table.setDcForm(Integer.valueOf(table.getDcFormText()));
        }else{
            //如果传过来的数据为界面原有的信息，则根据原约定的规则进行注入
            if(table.getDcFormText().equals("整桌")){
                table.setDcForm(1);
                //多重if表示多选一
            }else if(table.getDcFormText().equals("拼桌")) {
                table.setDcForm(2);
            }
        }
        //同上
        if(table.getDcUsestatusText().length()==1) {
            table.setDcUsestatus(Integer.valueOf(table.getDcUsestatusText()));
        }else {
            if(table.getDcUsestatusText().equals("就餐中")){
                table.setDcUsestatus(1);
            }else if(table.getDcUsestatusText().equals("可使用")){
                table.setDcUsestatus(2);
            }else if(table.getDcUsestatusText().equals("维修中")){
                table.setDcUsestatus(3);
            }else if(table.getDcUsestatusText().equals("清洁中")){
                table.setDcUsestatus(4);
            }
        }
        if(table.getDcSpecificationsText().length()==1) {
            table.setDcSpecifications(Integer.valueOf(table.getDcSpecificationsText()));
        }else{
            if(table.getDcSpecificationsText().equals("大桌")){
                table.setDcSpecifications(1);
            }else if(table.getDcSpecificationsText().equals("中桌")){
                table.setDcSpecifications(2);
            }else if(table.getDcSpecificationsText().equals("小桌")){
                table.setDcSpecifications(3);
            }
        }
        table.setDcShop(table.getDcShop());
        table.setDcCompanies(table.getDcCompanies());
        //这是调用业务层的修改的方法
        int i = tableService.updateByPrimaryKey(table);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //这是删除餐桌的controller方法
    @RequestMapping("/delete")
    @ResponseBody
    public int delete(Table table,TableState tableState){
        if(table!=null){
            //这是散出餐桌管理的餐桌信息
            int i = tableService.deleteByPrimaryKey(table.getDcId());

            //这是删除该餐桌的状态信息
            //实现账号的同步
            tableState.setDtId(table.getDcId());
            tableStateService.deleteByPrimaryKey(tableState.getDtId());
            if(i>0){
                System.out.print("删除成功!");
                return 1;
            }
        }
        return 0;
    }
    /*@RequestMapping("/insertTable")
    public String insertTable(Table table){
        System.out.print(table.getDcId());
        TableState tableState = new TableState();
        tableState.setDtId(table.getDcId());
        int i = tableService.insert(table);
       //实现与状态表的同步
        int i1 = tableStateService.insert(tableState);
       if(i>0&&i1>0){
           System.out.print("添加成功！");
       }
       return "forward:/table/tableManage.jsp";
    }*/

   /* @RequestMapping("/updateTable")
    public String updateTable(Table table){
        int i = tableService.updateByPrimaryKey(table);
        if(i>0){
            System.out.print("修改成功!");
        }
        return "forward:/table/tableManage.jsp";
    }*/

   /* @RequestMapping("/deleteTable")
    public String deleteTable(@RequestParam("ID")String ID){
        //这是散出餐桌管理的餐桌信息
        int i = tableService.deleteByPrimaryKey(ID);

        //这是删除该餐桌的状态信息
        //实现账号的同步
        TableState tableState = new TableState();
        tableState.setDtId(ID);
        tableStateService.deleteByPrimaryKey(tableState.getDtId());
        if(i>0){
            System.out.print("删除成功!");
        }
        return "forward:/table/tableManagement.jsp";
    }*/
}
