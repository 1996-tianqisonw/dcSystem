package com.hx.service.Impl;

import com.hx.entity.Categories;
import com.hx.service.CategoriesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoriesService")
public class CategoriesServiceImpl extends BaseServiceImpl<Categories> implements CategoriesService {
    @Override
    public List<Categories> selectCategories(Categories categories) {
        return categoriesMapper.selectCategories(categories);
    }

    @Override
    public int delCategories(Categories categories) {
        return categoriesMapper.delCategories(categories);
    }
}
