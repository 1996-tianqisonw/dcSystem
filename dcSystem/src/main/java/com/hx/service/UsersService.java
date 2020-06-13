package com.hx.service;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Department;
import com.hx.entity.UserDept;
import com.hx.entity.Users;
import com.hx.mapper.BaseMapper;

public interface UsersService extends BaseService<Users> {
    PageInfo<UserDept> selectUsers(Users users, Integer pageIndex, Integer pageSize);
    Integer insertUsers(Users users, Department department);
    Integer deleteUsers(String[] pks);
    Integer updateUsers(Users users, Department department);
    Boolean selectPassword(Users users);
    Users select(Users users);
}
