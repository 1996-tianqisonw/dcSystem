package com.hx.mapper;

import com.hx.entity.Users;

import java.util.List;

public interface UsersMapper extends BaseMapper<Users>{
    /*员工角色关联查询*/
    Users selectusersro(Users users);
    /*员工部门关联查询*/
    List<Users> selectusersdept(Users users);
    /*验证员工账号是否存在*/
    Users usersname(Users users);
    /*验证员工账号密码*/
    Users userspass(Users users);
   /* 批量删除员工*/
    Integer deleteUsers(String[] pks);
    /*查询所有可用员工*/
    List<Users> usersstate(Users users);
}