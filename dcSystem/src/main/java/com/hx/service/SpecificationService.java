package com.hx.service;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Specification;

import java.util.List;

public interface SpecificationService extends BaseService<Specification> {
    List<Specification> selectSpecification(Specification specification);
    int delSpecification(String[] strings);

    PageInfo<Specification> selectPage(Specification specification, Integer page, Integer rows);
}
