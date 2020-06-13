package com.hx.service;

import com.hx.entity.Specification;

import java.util.List;

public interface SpecificationService extends BaseService<Specification> {
    List<Specification> selectSpecification(Specification specification);
    int delSpecification(String[] strings);
}
