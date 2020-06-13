package com.hx.mapper;

import com.hx.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu>{
    /*批量删除菜单*/
    Integer deleteMenu(String[] pks);
    /*获取相关层次的菜单*/
    List<Menu> selectmenulist(Menu menu);
}