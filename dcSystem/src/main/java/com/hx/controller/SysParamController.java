package com.hx.controller;

import com.hx.service.SysParamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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
}
