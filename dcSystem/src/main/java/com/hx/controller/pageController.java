package com.hx.controller;

import com.hx.entity.Menu;
import com.hx.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/pageController")
public class pageController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpSession session;
    @RequestMapping("/goURL/{fwc}/{xmz}")
    public ModelAndView login1(@PathVariable String fwc, @PathVariable String xmz){
        return new ModelAndView("forward:/WEB-INF/"+fwc+"/"+xmz+".jsp");
    }

    @RequestMapping("/goURL1/{fwc}/{xmz}")
    public ModelAndView login2(@PathVariable String fwc, @PathVariable String xmz){
        return new ModelAndView("forward:/"+fwc+"/"+xmz+".jsp");
    }

    @RequestMapping("/permis")
    @ResponseBody
    public Object login2(String permissions){
        session = request.getSession();
        Users users = (Users) session.getAttribute("users");
        List<Menu> list = users.getRoles().getMenus();
        for (Menu menu:list){
            if (menu.getPermissions().equals(permissions)){
                return true;
            }
        }
        return false;
}
}
