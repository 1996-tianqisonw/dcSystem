package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Department;
import com.hx.entity.Role;
import com.hx.entity.UserDept;
import com.hx.entity.Users;
import com.hx.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("usersService")
public class UsersServiceimpl extends BaseServiceImpl<Users> implements UsersService {
    @Override
    public PageInfo<UserDept> selectUsers(Users users,Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Users> list1 = usersMapper.selectusersdept(users);
        PageInfo<Users> pageInfo1 = new PageInfo<>(list1);
        Long aLong = pageInfo1.getTotal();
        List<UserDept> list = new ArrayList<>();
        UserDept userDept = null;
        for (Users users1:list1){
            if (users1.getState().equals("1")){
                users1.setState("可用");
            }else {
                users1.setState("禁用");
            }
            Department department = users1.getDepartment();
            userDept = new UserDept();
            userDept.setUserId(users1.getUserId());
            userDept.setUserName(users1.getUserName());
            userDept.setUserPassword(users1.getUserPassword());
            userDept.setName(users1.getName());
            userDept.setState(users1.getState());
            userDept.setPhone(users1.getPhone());
            userDept.setWork(users1.getWork());
            userDept.setOnjob(users1.getOnjob());
            userDept.setDeparture(users1.getDeparture());
            userDept.setDepartmentId(department.getDepartmentId());
            userDept.setDepartmentName(department.getDepartmentName());
            userDept.setCompany(department.getCompany());
            userDept.setStore(department.getStore());
            userDept.setPosition(department.getPosition());
            userDept.setDepartmentAdd(department.getDepartmentAdd());
            userDept.setOrgName(department.getOrgName());
            list.add(userDept);
        }
        PageInfo<UserDept> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal(aLong);
        return pageInfo;
    }

    @Override
    public Integer insertUsers(Users users,Department department) {
        Integer integer=0;
        List<Department> list = departmentMapper.selectdept(department);
        System.out.println(list);
        users.setDepartmentId(list.get(0).getDepartmentId());
        if (usersMapper.usersname(users)==null){
            integer = usersMapper.insertSelective(users);
        }else {
            integer=2;
        }
        return integer;
    }

    @Override
    public Integer deleteUsers(String[] pks) {
        Integer integer = usersMapper.deleteUsers(pks);
        return integer;
    }

    @Override
    public Integer updateUsers(Users users,Department department) {
        Integer integer=0;
        List<Department> list = departmentMapper.selectdept(department);
        users.setDepartmentId(list.get(0).getDepartmentId());
            integer = usersMapper.updateByPrimaryKeySelective(users);
        return integer;
    }

    @Override
    public Boolean selectPassword(Users users) {
        if (usersMapper.userspass(users)!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Users select(Users users) {
        Users users1 = usersMapper.selectusersro(users);
        Role role = users1.getRoles();
        Role role1 = roleMapper.selectrolemenu(role);
        System.out.println(role1);
        users1.setRoles(role1);
        return users1;
    }
}
