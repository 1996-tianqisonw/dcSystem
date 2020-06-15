package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.service.StatementLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by huangyu on 2020/6/8.
 */
@Controller
@RequestMapping("/sysLog")
public class StatementLogController extends BaseController {
    @Autowired
    private StatementLogService statementLogService;
    @ResponseBody
    @RequestMapping("/logData")
    public Object getData1(String page, String rows, String startDate) {
        PageInfo pageInfo = statementLogService.selectByTimes1(Integer.parseInt(page), Integer.parseInt(rows), startDate);
        Map map = getPageMap(pageInfo);
        return map;
    }
}
