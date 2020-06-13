package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Department;
import com.hx.entity.Role;
import com.hx.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceimpl extends BaseServiceImpl<Department> implements DepartmentService {
    @Override
    public PageInfo<Department> selectdept(Department department, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Department> list = departmentMapper.selectdept(department);
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Department> selectdepartment(Department department) {
        List<Department> list= departmentMapper.selectdept(department);
        return list;
    }
}
