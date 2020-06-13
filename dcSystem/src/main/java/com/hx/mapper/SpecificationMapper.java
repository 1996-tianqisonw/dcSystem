package com.hx.mapper;

import com.hx.entity.Specification;

import java.util.List;

public interface SpecificationMapper extends BaseMapper<Specification> {
    List<Specification> selectSpecification(Specification specification);
    int delSpecification(String[] strings);
}