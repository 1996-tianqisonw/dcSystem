package com.hx.service.Impl;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Categories;
import com.hx.mapper.CategoriesMapper;
import com.hx.service.CategoriesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public <K> int deleteByPrimaryKey(K dcId) {
        return 0;
    }

    @Override
    public int insertSelective(Categories record) {
        return 0;
    }

   /* @Override
    public int insert(T record) {
        return 0;
    }*/

/*
    @Override
    public <K> T selectByPrimaryKey(K dcId) {
        return null;
    }
*/

    @Override
    public int updateByPrimaryKeySelective(Categories record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Categories record) {
        return 0;
    }

    @Override
    public PageInfo<Categories> selectServiceAll(Categories table, Integer pageIndex, Integer pageSize) {
        return null;
    }
}
