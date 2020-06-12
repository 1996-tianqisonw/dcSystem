package com.hx.mapper;

import com.hx.entity.Categories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoriesMapper extends BaseMapper<Categories> {
    List<Categories> selectCategories(Categories categories);
    int delCategories(Categories categories);
}