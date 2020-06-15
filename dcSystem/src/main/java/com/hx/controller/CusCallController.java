package com.hx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.CusCall;
import com.hx.service.CusCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/5/17.
 */
@Controller
@RequestMapping("cus_call")
public class CusCallController extends BaseController {
    @Autowired
    private CusCallService cus_callService;
    //获取用户列表
    @RequestMapping(value = "list")
    @ResponseBody
    public Object Call_List(String page, String rows, CusCall cus_call) {
        System.out.println("@@@@@@");
        PageInfo<CusCall> pageInfo = cus_callService.selectPage(Integer.parseInt(page), Integer.parseInt(rows), cus_call);
        return getEasyUIResult(pageInfo);
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public Object Call_Add(CusCall cus_call, HttpServletResponse response) throws IOException {
        cus_call.setBeginTime(cus_callService.getDatetoString());
        cus_call.setDealState("0");//设置状态为未处理
        int result=cus_callService.insertSelective(cus_call);
        Map<String,String> map= new HashMap<String,String>();
        ObjectMapper objectMapper=new ObjectMapper();
        map.put("result",""+result);
        String jsonString=objectMapper.writeValueAsString(map);
        PrintWriter printWriter=response.getWriter();
        printWriter.print(jsonString);//
        printWriter.flush();
        printWriter.close();
        return null;
    }

/*    @RequestMapping(value = "dealCall")
    @ResponseBody
    public Object dealCall(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        String pno = request.getParameter("pno");
        String custId = request.getParameter("custId");//得到客户信息
        int message =cus_callService.updateByPrimaryKeySelective(Integer.parseInt(pno));
        String rep = "";
        if(message == 1) {
            SystemWebSocketHandler socket=new SystemWebSocketHandler();
            String s=socket.sendMessageToOne(custId,"服务人员将马上过来");//同时给客户推送信息
            rep = "{\"code\":\"200\",\"message\":\"处理成功\"}";
        }else {
            rep = "{\"code\":\"999\",\"message\":\"处理失败\"}";
        }
        PrintWriter printWriter=response.getWriter();
        printWriter.write(rep);
        printWriter.flush();
        printWriter.close();;
        return null;
    }*/

    @RequestMapping(value = "dealCall")
    @ResponseBody
    public Object dealCall(String[] callId,String[] custId){
     int rows =cus_callService.updateByPrimaryKeySelective(callId);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result",rows);
        return map;
    }
}
