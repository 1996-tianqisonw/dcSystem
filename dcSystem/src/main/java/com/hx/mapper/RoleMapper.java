package com.hx.mapper;

import com.hx.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role>{
    /*角色菜单关联查询*/
    Role selectrolemenu(Role role);
    /*验证角色是否存在*/
    Role rolename(Role role);
    /*批量删除角色*/
    Integer deleteRole(String[] pks);

    Integer deleteusersrole(String[] pks);
    /*删除员工角色关系*/
    Integer deleteusersro(@Param("userId") String uid, @Param("roleId") String rid);
    /*增加员工角色关系*/
    Integer insertusersro(@Param("userId") String uid, @Param("roleId") String rid);
    /*删除角色菜单关系*/
    Integer deleteroleme(String rid);
    /*增加角色菜单关系*/
    Integer insertroleme(@Param("roleId") String rid, @Param("menuId") String mid);
    /*查询所有角色*/
    List<Role> rolelist();
    /*查询角色所有的员工*/
    Role selectroleuser(String roleId);
}