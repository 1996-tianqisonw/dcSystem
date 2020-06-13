package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.*;
import com.hx.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceimpl extends BaseServiceImpl<Role> implements RoleService {
    @Override
    public PageInfo<Role> selectRole(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Role> list1 = roleMapper.rolelist();
        PageInfo<Role> pageInfo1 = new PageInfo<>(list1);
        Long aLong = pageInfo1.getTotal();
        List<Role> list = new ArrayList<>();
        for (Role role:list1){
            if (role.getState().equals("1")){
                role.setState("可用");
            }else {
                role.setState("禁用");
            }
            list.add(role);
        }
        PageInfo<Role> pageInfo = new PageInfo<Role>(list);
        pageInfo.setTotal(aLong);
        return pageInfo;
    }

    @Override
    public Integer insertRole(Role role) {
        Integer t = 0;
        if (roleMapper.rolename(role)==null){
            t = roleMapper.insertSelective(role);
        }else {
            t = 2;
        }
        return t;
    }

    @Override
    public List<Tree> selectRoleMenu(Role role) {
        Role role1 = roleMapper.selectrolemenu(role);
        List<Menu> menus = role1.getMenus();
        System.out.println(menus);
        List<Tree> trees=new ArrayList<>();
        Tree t1 = null;
        Tree t2 = null;
        Tree t3 = null;
        Menu menu = new Menu();
        menu.setOrgId(0);
        menu.setState("1");
        for (Menu m:menuMapper.selectmenulist(menu)){
            t1 = new Tree();
            t1.setMenuId(m.getMenuId());
            t1.setMenuName(m.getMenuName());
            t1.setUrl(m.getUrl());
            t1.setPermissions(m.getPermissions());
            t1.setType(m.getType());
            t1.setOrgId(m.getOrgId());
            t1.setStaste("可用");
            t1.setSorting(m.getSorting());
            for (Menu menu1:menus){
                if (m.getMenuId().equals(menu1.getMenuId())){
                    t1.setChecked(true);
                }
            }
            t1.setChildren(new ArrayList<Tree>());
            Menu menu1 = new Menu();
            menu1.setOrgId(m.getMenuId());
            menu1.setState(m.getState());
            for (Menu m1:menuMapper.selectmenulist(menu1)){
                t2 = new Tree();
                t2.setMenuId(m1.getMenuId());
                t2.setMenuName(m1.getMenuName());
                t2.setUrl(m1.getUrl());
                t2.setPermissions(m1.getPermissions());
                t2.setType(m1.getType());
                t2.setOrgId(m1.getOrgId());
                t2.setStaste("可用");
                t2.setSorting(m1.getSorting());
                for (Menu menu2:menus) {
                    if (m1.getMenuId().equals(menu2.getMenuId())) {
                        t2.setChecked(true);
                    }
                }
                t2.setChildren(new ArrayList<Tree>());
                Menu menu2 = new Menu();
                menu2.setOrgId(m1.getMenuId());
                menu2.setState(m1.getState());
                for (Menu m2:menuMapper.selectmenulist(menu2)){
                    t3 = new Tree();
                    t3.setMenuId(m2.getMenuId());
                    t3.setMenuName(m2.getMenuName());
                    t3.setUrl(m2.getUrl());
                    t3.setPermissions(m2.getPermissions());
                    t3.setType(m2.getType());
                    t3.setOrgId(m2.getOrgId());
                    t3.setStaste("可用");
                    t3.setSorting(m2.getSorting());
                    for (Menu menu3:menus) {
                        if (m2.getMenuId().equals(menu3.getMenuId())) {
                            t3.setChecked(true);
                        }
                    }
                    t2.getChildren().add(t3);
                }
                t1.getChildren().add(t2);
            }
            trees.add(t1);
        }
        return trees;
    }

    @Override
    public Integer insertRoleMenu(String[] pks, String roleId) {
        roleMapper.deleteroleme(roleId);
        Integer integer = 0;
        for (String str:pks){
            roleMapper.insertroleme(roleId,str);
            integer++;
        }
        return integer;
    }

    @Override
    public Integer deleteRole(String[] pks) {
        Integer integer = roleMapper.deleteRole(pks);
        return integer;
    }

    @Override
    public List<Treegrid> selectusers() {
        List<Treegrid> list = new ArrayList<>();
        Treegrid t1=null;
        Users users = new Users();
        users.setState("1");
        for (Users users1:usersMapper.usersstate(users)){
            t1 = new Treegrid();
            t1.setUserId(users1.getUserId());
            t1.setUserName(users1.getUserName());
            list.add(t1);
        }
        return list;
    }

    @Override
    public List<Treegrid> selectRoleusers(String roleId) {
        Role role = roleMapper.selectroleuser(roleId);
        List<Treegrid> list = new ArrayList<>();
        List<Users> list1 = role.getUsers();
        Treegrid t1=null;
        if (list1.get(0).getUserName()!=null){
        for (Users users:list1){
            t1 = new Treegrid();
            t1.setUserId(users.getUserId());
            t1.setUserName(users.getUserName());
            list.add(t1);
        }
        }else {
            t1 = new Treegrid();
            t1.setUserId(0);
            t1.setUserName("暂无员工");
            list.add(t1);
        }
        return list;
    }

    @Override
    public Integer insertRoleusers(String roleId, String[] pks) {
        System.out.println(pks);
        roleMapper.deleteusersrole(pks);
        Integer integer = 0;
        for (String userId:pks){
            roleMapper.insertusersro(userId,roleId);
            integer++;
        }
        return integer;
    }

    @Override
    public Integer deleteRoleusers(String roleId, String[] pks) {
        Integer integer = 0;
        for (String userId:pks){
            roleMapper.deleteusersro(userId,roleId);
            integer++;
        }
        return integer;
    }
}
