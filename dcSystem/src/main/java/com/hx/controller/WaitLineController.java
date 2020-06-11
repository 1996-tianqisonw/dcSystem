package com.hx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.WaitLine;
import com.hx.service.WaitLineService;
import com.hx.service.WaitOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/5/17.
 */
@Controller
@RequestMapping("wait_line")
public class WaitLineController extends BaseController {
    @Autowired
    private WaitLineService wait_lineService;
    @Autowired
    private WaitOnService waitOnService;

    //获取用户列表
    @RequestMapping(value = "list")
    @ResponseBody
    public Object sysList(String page, String rows, WaitLine wait_line) {
        PageInfo<WaitLine> pageInfo = wait_lineService.selectPage(Integer.parseInt(page), Integer.parseInt(rows), wait_line);
        return getEasyUIResult(pageInfo);
    }

    @RequestMapping(value = "add/{dp_id}")
    public Object CallAdd(@PathVariable String dp_id) {
        Map<String, Object> map = new HashMap<>();
        if (waitOnService.WaitOnorOff(dp_id)) {
            map.put("result", "1");
            return map;
        } else {
            map.put("result", "0");
            return map;
        }
    }

    @RequestMapping(value = "add")
    public String Line_Add(WaitLine wait_line,HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        if (waitOnService.WaitOnorOff(wait_line.getDpId().toString())) {
            int result = wait_lineService.insertSelective(wait_line);
            map.put("result", result);
        }else {
            map.put("result", "店铺未开启排队功能" );
        }
        String jsonString = objectMapper.writeValueAsString(map);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonString);//
        printWriter.flush();
        printWriter.close();
        return null;
    }

    //根据前端传过来的主键和修改状态进行排队状态修改，lineState：0排队中；1已就餐；2客户中途取消；3已过号
    @RequestMapping(value = "updateState/{id}/{state}")
    @ResponseBody
    public String updateState(@PathVariable String id, @PathVariable String state) {
        WaitLine wait_line = new WaitLine();
        wait_line.setLineId(Integer.parseInt(id));
        wait_line.setLineState(state);
        wait_lineService.updateByPrimaryKeySelective(wait_line);
        return null;
    }

    @RequestMapping("reloadxh")
    public String ReloadXh(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        int message = wait_lineService.ReloadPx();
        String rep = "";
        if (message == 1) {
            rep = "{\"code\":\"200\",\"message\":\"重置成功\"}";
        } else {
            rep = "{\"code\":\"999\",\"message\":\"再试一下\"}";
        }
        PrintWriter printWriter = response.getWriter();
        printWriter.write(rep);
        printWriter.flush();
        printWriter.close();
        return null;
    }

    @RequestMapping(value = "update_state")
    public String dealCall(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        String pno = request.getParameter("state");
        String on_id = request.getParameter("on_id");
        int message = wait_lineService.updateByPrimaryKeySelective(Integer.parseInt(on_id), pno);
        String rep = "";
        if (message == 1) {
            rep = "{\"code\":\"200\",\"message\":\"修改成功\"}";
        } else {
            rep = "{\"code\":\"999\",\"message\":\"处理失败\"}";
        }
        PrintWriter printWriter = response.getWriter();
        printWriter.write(rep);
        printWriter.flush();
        printWriter.close();
        return null;
    }
}
