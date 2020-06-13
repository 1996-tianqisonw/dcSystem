package com.hx.controller;

import com.hx.entity.Department;
import com.hx.entity.Menu;
import com.hx.service.DepartmentService;
import com.hx.service.MenuService;
import com.hx.service.RoleService;
import com.hx.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/MenuController")
public class MenuController {

    @Resource
    DepartmentService departmentService;
    @Resource
    MenuService menuService;
    @Resource
    UsersService usersService;
    @Resource
    RoleService roleService;

    @RequestMapping("/selectMenu")
    @ResponseBody
    public Object login1() {
        return menuService.selectMenu();
    }

    @RequestMapping("/insertMenu")
    @ResponseBody
    public Object login2(Menu menu) {
        System.out.println(menu.getState());
        if (menu.getState().equals("可用")){
            menu.setState("1");
        }else {
            menu.setState("0");
        }
        System.out.println(menu);
        Integer t = menuService.insertSelective(menu);
        return t;

    }

    @RequestMapping("/updateMenu")
    @ResponseBody
    public Object login3(Menu menu) {
        if (menu.getState().equals("可用")){
            menu.setState("1");
        }else {
            menu.setState("0");
        }
        Integer t = menuService.updateByPrimaryKeySelective(menu);
        return t;
    }

    @RequestMapping("/deleteMenu")
    @ResponseBody
    public Object login4(String[] pks) {
        Integer t = menuService.deleteMenu(pks);
        return t;
    }
}
