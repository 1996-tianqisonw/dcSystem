package com.hx.service.Impl;

import com.hx.entity.Specification;
import com.hx.service.SpecificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("specificationService")
public class SpecificationServiceImpl extends BaseServiceImpl<Specification> implements SpecificationService {
    @Override
    public List<Specification> selectSpecification(Specification specification) {
        return specificationMapper.selectSpecification(specification);
    }

    @Override
    public int delSpecification(String[] strings) {
        return specificationMapper.delSpecification(strings);
    }
}
