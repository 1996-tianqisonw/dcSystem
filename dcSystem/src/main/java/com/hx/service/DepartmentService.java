package com.hx.service;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Department;
import com.hx.mapper.BaseMapper;

import java.util.List;

public interface DepartmentService extends BaseService<Department> {
    PageInfo<Department> selectdept(Department department, Integer pageIndex, Integer pageSize);
    List<Department> selectdepartment(Department department);
}
