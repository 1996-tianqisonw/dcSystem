package com.hx.service;

import com.hx.entity.Menu;
import com.hx.entity.Tree;
import com.hx.mapper.BaseMapper;

import java.util.List;

public interface MenuService extends BaseService<Menu> {
    List<Tree> selectMenu();
    Integer deleteMenu(String[] pks);
}
