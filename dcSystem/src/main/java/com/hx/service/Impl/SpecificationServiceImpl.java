package com.hx.service.Impl;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Specification;
import com.hx.mapper.SpecificationMapper;
import com.hx.service.SpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public PageInfo<Specification> selectPage(Specification specification, Integer page, Integer rows) {
        return null;
    }
}
