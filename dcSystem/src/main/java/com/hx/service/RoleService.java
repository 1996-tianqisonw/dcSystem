package com.hx.service;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Role;
import com.hx.entity.Tree;
import com.hx.entity.Treegrid;
import com.hx.entity.Users;
import com.hx.mapper.BaseMapper;

import java.util.List;

public interface RoleService extends BaseService<Role> {
    PageInfo<Role> selectRole(Integer pageIndex, Integer pageSize);
    Integer insertRole(Role role);
    List<Tree> selectRoleMenu(Role role);
    Integer insertRoleMenu(String[] pks, String roleId);
    Integer deleteRole(String[] pks);
    List<Treegrid> selectusers();
    List<Treegrid> selectRoleusers(String roleId);
    Integer insertRoleusers(String roleId, String[] pks);
    Integer deleteRoleusers(String roleId, String[] pks);
}
