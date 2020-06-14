package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Department;
import com.hx.entity.Role;
import com.hx.entity.UserDept;
import com.hx.entity.Users;
import com.hx.service.DepartmentService;
import com.hx.service.MenuService;
import com.hx.service.RoleService;
import com.hx.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/UsersController")
public class UsersController {

    @Resource
    DepartmentService departmentService;
    @Resource
    MenuService menuService;
    @Resource
    UsersService usersService;
    @Resource
    RoleService roleService;
    @Autowired
    HttpSession session;
    @RequestMapping("/selectUsers")
    @ResponseBody
    public Object login1(Users users, Department department,Integer page, Integer rows) {
        if (users.getUserName()==""){users.setUserName(null);}
        if (users.getName()==""){users.setName(null);}
        if (users.getState()!=null){
        if (users.getState().equals("可用")){
            users.setState("1");
        }
        if (users.getState().equals("禁用")){
            users.setState("0");
        }
        }
        if (department.getCompany()==""){department.setCompany(null);}
        if (department.getStore()==""){department.setStore(null);}
        if (department.getPosition()==""){department.setPosition(null);}
        System.out.println(department);
        users.setDepartment(department);
        PageInfo<UserDept> pageInfo = usersService.selectUsers(users,page,rows);
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;

    }

    @RequestMapping("/insertUsers")
    @ResponseBody
    public Object login2(Users users,Department department) {
        if (department.getCompany()==""){department.setCompany(null);}
        if (department.getStore()==""){department.setStore(null);}
        if (department.getPosition()==""){department.setPosition(null);}
        if (users.getState().equals("可用")){
            users.setState("1");
        }else {
            users.setState("0");
        }
        return usersService.insertUsers(users,department);
    }

    @RequestMapping("/updateUsers")
    @ResponseBody
    public Object login3(Users users,Department department) {
        if (users.getDeparture().equals("")){users.setDeparture(null);}
        if (department.getCompany()==""){department.setCompany(null);}
        if (department.getStore()==""){department.setStore(null);}
        if (department.getPosition()==""){department.setPosition(null);}
        if (users.getState().equals("可用")){
            users.setState("1");
        }else {
            users.setState("0");
        }
        return usersService.updateUsers(users,department);

    }

    @RequestMapping("/deleteUsers")
    @ResponseBody
    public Object login4(String[] pks) {
        return usersService.deleteUsers(pks);

    }

    @RequestMapping("/selectPassword")
    public ModelAndView  login5(Users users) {
        users.setState("1");
        if (usersService.selectPassword(users)){
            Users users1 = usersService.select(users);
            session.setAttribute("users",users1);
            return new ModelAndView("forward:/WEB-INF/fwc/zjm.jsp");
        }
        return new ModelAndView("forward:/index.jsp");
    }
}
