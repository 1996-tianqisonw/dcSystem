package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Department;
import com.hx.entity.Role;
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
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/DepartmentController")
public class DepartmentController {

    @Resource
    DepartmentService departmentService;
    @Resource
    MenuService menuService;
    @Resource
    UsersService usersService;
    @Resource
    RoleService roleService;

    @RequestMapping("/selectdept")
    @ResponseBody
    public Object login1(Department department,String page,String rows) {
        if (department.getCompany()==""){department.setCompany(null);}
        if (department.getStore()==""){department.setStore(null);}
        if (department.getPosition()==""){department.setPosition(null);}
        if (department.getDepartmentAdd()==""){department.setDepartmentAdd(null);}
        PageInfo<Department> pageInfo = departmentService.selectdept(department,Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;

    }

    @RequestMapping("/insertdept")
    @ResponseBody
    public Object login2(Department department) {
        if (department.getStore()==""){department.setStore(null);}
        if (department.getPosition()==""){department.setPosition(null);}
        if (department.getDepartmentAdd()==""){department.setDepartmentAdd(null);}
        System.out.println(department);
        return departmentService.insertSelective(department);

    }

    @RequestMapping("/updatedept")
    @ResponseBody
    public Object login3(Department department) {
        if (department.getStore()==""){department.setStore(null);}
        if (department.getPosition()==""){department.setPosition(null);}
        if (department.getDepartmentAdd()==""){department.setDepartmentAdd(null);}
        return departmentService.updateByPrimaryKeySelective(department);

    }

    @RequestMapping("/selectdepartment")
    @ResponseBody
    public Object login4(Department department) {
        return departmentService.selectdepartment(department);
    }
}
