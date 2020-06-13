package com.hx.service;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Goods;
import com.hx.entity.GoodsCategories;

public interface GoodsService extends BaseService<Goods> {
    public PageInfo<GoodsCategories> selectGoods(Goods goods, Integer pageIndex, Integer pageSize);
}
