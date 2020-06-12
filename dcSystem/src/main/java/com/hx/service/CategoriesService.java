package com.hx.service;

import com.hx.entity.Categories;

import java.util.List;

public interface CategoriesService extends BaseService<Categories> {
    List<Categories> selectCategories(Categories categories);
    int delCategories(Categories categories);
}
