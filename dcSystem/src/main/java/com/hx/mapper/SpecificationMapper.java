package com.hx.mapper;

import com.hx.entity.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SpecificationMapper extends BaseMapper<Specification> {
    List<Specification> selectSpecification(Specification specification);
    int delSpecification(String[] strings);
}