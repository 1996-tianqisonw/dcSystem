package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.SysParam;
import com.hx.service.SysParamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Controller
@RequestMapping("sysParam")
public class SysParamController extends BaseController {

    @Resource
    SysParamService sysParamService;

    @PostConstruct
    public void loadSysParam()
    {
        System.out.println("启动时初始化参数的方法!");
        Map<String,Object> sysParam = sysParamService.loadSysParam();
        application.setAttribute("sysParam",sysParam);

        System.out.println("完成时初始化参数的方法!");
    }
    @RequestMapping("/selectPage")
    @ResponseBody
    public Object selectPage(String page, String rows, SysParam sysParam){
        PageInfo<SysParam> pageInfo = sysParamService.selectPage(sysParam,Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("total",pageInfo.getTotal());
        returnMap.put("rows",pageInfo.getList());
        return returnMap;
    }
    @RequestMapping("/selectPage1")
    @ResponseBody
    public Object selectPage1(String page, String rows, SysParam sysParam){
        sysParam.setSysParamField("copy");
        PageInfo<SysParam> pageInfo = sysParamService.selectPage(sysParam,Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("total",pageInfo.getTotal());
        returnMap.put("rows",pageInfo.getList());
        return returnMap;
    }
    @RequestMapping("/updateParam")
    @ResponseBody
    public Object updateParam(SysParam sysParam) throws Exception {
        sysParam.setSysParamField("copy");
        sysParamService.updateSysParam(sysParam);
        sysParamService.setSysParam(sysParam);
        Map map = new HashMap();
        map.put("msg","启动成功");
        return map;
    }

    @RequestMapping("/selectAppo")
    @ResponseBody
    public Object selectAppo(String page, String rows, SysParam sysParam){
        sysParam.setSysParamField("appo");
        PageInfo<SysParam> pageInfo = sysParamService.selectPage(sysParam,Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("total",pageInfo.getTotal());
        returnMap.put("rows",pageInfo.getList());
        return returnMap;
    }
    @RequestMapping("/updateAppo")
    @ResponseBody
    public Object updateAppo(SysParam sysParam) throws Exception {
        sysParam.setSysParamField("appo");
        sysParamService.updateSysParam(sysParam);
        sysParamService.setSysParam(sysParam);
        Map map = new HashMap();
        map.put("msg","启动成功");
        return map;
    }
}