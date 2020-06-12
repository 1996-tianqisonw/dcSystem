package com.hx.controller;

import com.hx.handler.SystemWebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/5/23.
 * 用于处理前台客人需求功能
 */
@Controller
@RequestMapping("reception")
public class ReceptionController {

    /* 客户登录后讲标志存到session里面*/
    @RequestMapping("login/{id}")
    public String Login(HttpSession session, @PathVariable String id) {
        session.setAttribute("yonlie", id);
        return "call_queuing/call_service";
    }
    /* 通过异步请求给客户发消息*/
    @RequestMapping(value = "sendMessage")
    public Object sendMessage(String userId,String message ) throws IOException {
        SystemWebSocketHandler socket = new SystemWebSocketHandler();
        String s = socket.sendMessageToOne(userId, message);
        Map<String,Object> messageMap=new HashMap<>();
        if ("ok".equals(s)) {
            messageMap.put("result","消息发送成功");
        } else {
            messageMap.put("result","消息发送失败");
        }

        return messageMap;
    }
}
