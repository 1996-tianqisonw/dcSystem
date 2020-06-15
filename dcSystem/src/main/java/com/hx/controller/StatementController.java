package com.hx.controller;
import com.github.pagehelper.PageInfo;
import com.hx.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/statement")
public class StatementController extends BaseController {

    @Autowired
    private StatementService statementService;

    @ResponseBody
    @RequestMapping("/data")
    public Object getData(String page, String rows, String startDate, String endDate, String shopId) {
        PageInfo pageInfo = statementService.selectByTimes(Integer.parseInt(page), Integer.parseInt(rows), startDate, endDate);
        Map map = getPageMap(pageInfo);
        return map;
    }
}



