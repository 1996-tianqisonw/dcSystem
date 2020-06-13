package com.hx.mapper;

import com.hx.entity.Categories;

import java.util.List;

public interface CategoriesMapper extends BaseMapper<Categories> {
    List<Categories> selectCategories(Categories categories);
    int delCategories(Categories categories);
}