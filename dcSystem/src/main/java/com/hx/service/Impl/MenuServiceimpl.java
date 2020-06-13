package com.hx.service.Impl;

import com.hx.entity.Menu;
import com.hx.entity.Tree;
import com.hx.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuService")
public class MenuServiceimpl extends BaseServiceImpl<Menu> implements MenuService {
    @Override
    public List<Tree> selectMenu() {
        List<Tree> trees=new ArrayList<>();
        Tree t1 = null;
        Tree t2 = null;
        Tree t3 = null;
        Menu menu = new Menu();
        menu.setOrgId(0);
        for (Menu m:menuMapper.selectmenulist(menu)){
            t1 = new Tree();
            if (m.getState().equals("1")){
                t1.setStaste("可用");
            }else {
                t1.setStaste("禁用");
            }
            t1.setMenuId(m.getMenuId());
            t1.setMenuName(m.getMenuName());
            t1.setUrl(m.getUrl());
            t1.setPermissions(m.getPermissions());
            t1.setType(m.getType());
            t1.setOrgId(m.getOrgId());
            t1.setSorting(m.getSorting());
            t1.setChildren(new ArrayList<Tree>());
            Menu menu1 = new Menu();
            menu1.setOrgId(m.getMenuId());
            for (Menu m1:menuMapper.selectmenulist(menu1)){
                t2 = new Tree();
                if (m1.getState().equals("1")){
                    t2.setStaste("可用");
                    System.out.println(t2.getStaste());
                }else {
                    t2.setStaste("禁用");
                }
                t2.setMenuId(m1.getMenuId());
                t2.setMenuName(m1.getMenuName());
                t2.setUrl(m1.getUrl());
                t2.setPermissions(m1.getPermissions());
                t2.setType(m1.getType());
                t2.setOrgId(m1.getOrgId());
                t2.setSorting(m1.getSorting());
                t2.setChildren(new ArrayList<Tree>());
                Menu menu2 = new Menu();
                menu2.setOrgId(m1.getMenuId());
                for (Menu m2:menuMapper.selectmenulist(menu2)){
                    t3 = new Tree();
                    if (m2.getState().equals("1")){
                        t3.setStaste("可用");
                    }else {
                        t3.setStaste("禁用");
                    }
                    t3.setMenuId(m2.getMenuId());
                    t3.setMenuName(m2.getMenuName());
                    t3.setUrl(m2.getUrl());
                    t3.setPermissions(m2.getPermissions());
                    t3.setType(m2.getType());
                    t3.setOrgId(m2.getOrgId());
                    t3.setSorting(m2.getSorting());
                    t2.getChildren().add(t3);
                }
                t1.getChildren().add(t2);
            }
            trees.add(t1);
        }
        return trees;
    }

    @Override
    public Integer deleteMenu(String[] pks) {
        return menuMapper.deleteMenu(pks);
    }
}
