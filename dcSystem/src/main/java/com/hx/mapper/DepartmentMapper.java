package com.hx.mapper;

import com.hx.entity.Department;

import java.util.List;

public interface DepartmentMapper extends BaseMapper<Department>{
    List<Department> selectdept(Department department);
}