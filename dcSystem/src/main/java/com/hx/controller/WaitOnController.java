package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.WaitOn;
import com.hx.service.WaitOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2020/5/17.
 */
@Controller
@RequestMapping("wait_on")
public class WaitOnController extends BaseController {
    @Autowired
    private WaitOnService wait_onService;

    //获取店铺启用状态
    @RequestMapping(value = "list")
    @ResponseBody
    public Object sysList(String page, String rows, WaitOn wait_on) {
        PageInfo<WaitOn> pageInfo = wait_onService.selectPage(Integer.parseInt(page), Integer.parseInt(rows), wait_on);
        return getEasyUIResult(pageInfo);
    }

    @RequestMapping(value = "update_on")
    public String  dealCall(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        String pno = request.getParameter("state");
        String on_id=request.getParameter("on_id");
        int message =wait_onService.updateOn_state(Integer.parseInt(on_id),pno);
        String rep = "";
        if(message == 1) {
            rep = "{\"code\":\"200\",\"message\":\"修改成功\"}";
        }else {
            rep = "{\"code\":\"999\",\"message\":\"处理失败\"}";
        }
        PrintWriter printWriter=response.getWriter();
        printWriter.write(rep);
        printWriter.flush();
        printWriter.close();;
        return null;
    }
}
