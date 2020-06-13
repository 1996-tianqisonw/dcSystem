package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Role;
import com.hx.service.DepartmentService;
import com.hx.service.MenuService;
import com.hx.service.RoleService;
import com.hx.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/RoleController")
public class RoleController {

    @Resource
    DepartmentService departmentService;
    @Resource
    MenuService menuService;
    @Resource
    UsersService usersService;
    @Resource
    RoleService roleService;

        @RequestMapping("/selectRole")
        @ResponseBody
        public Object login1(String page,String rows) {
            PageInfo<Role> pageInfo = roleService.selectRole(Integer.parseInt(page),Integer.parseInt(rows));
            Map<String,Object> map = new HashMap<>();
            map.put("total",pageInfo.getTotal());
            map.put("rows",pageInfo.getList());
            return map;
        }

        @RequestMapping("/insertRole")
        @ResponseBody
        public Object login2(Role role) {
            if (role.getState().equals("可用")){
                role.setState("1");
            }else {
                role.setState("0");
            }
            Integer integer = roleService.insertRole(role);
            return integer;
        }

        @RequestMapping("/updateRole")
        @ResponseBody
        public Object login3(Role role) {
            if (role.getState().equals("可用")){
                role.setState("1");
            }else {
                role.setState("0");
            }
            Integer integer = roleService.updateByPrimaryKeySelective(role);
            return integer;
        }

    @RequestMapping("/selectRoleMenu")
    @ResponseBody
    public Object login4(Role role) {
        return roleService.selectRoleMenu(role);
    }

    @RequestMapping("/insertRoleMenu")
    @ResponseBody
    public Object login5(String[] pks,String roleId) {
            return roleService.insertRoleMenu(pks,roleId);
    }

    @RequestMapping("/selectusers")
    @ResponseBody
    public Object login6() {
        return roleService.selectusers();
    }

    @RequestMapping("/selectRoleusers")
    @ResponseBody
    public Object login7(String roleId) {
        return roleService.selectRoleusers(roleId);
    }

    @RequestMapping("/insertRoleusers")
    @ResponseBody
    public Object login8(String[] pks,String roleId) {
        return roleService.insertRoleusers(roleId,pks);
    }

    @RequestMapping("/deleteRoleusers")
    @ResponseBody
    public Object login9(String[] pks,String roleId) {
        return roleService.deleteRoleusers(roleId,pks);
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public Object login10(String[] pks) {
        return roleService.deleteRole(pks);
    }
}
