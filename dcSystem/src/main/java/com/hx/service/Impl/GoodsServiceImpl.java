package com.hx.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Goods;
import com.hx.entity.GoodsCategories;
import com.hx.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {
    @Override
    public PageInfo<GoodsCategories> selectGoods(Goods goods, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        //查询数据
        List<Goods> list = baseMapper.selectPage(goods);
        PageInfo<Goods> pageInfo1 = new PageInfo<Goods>(list);
        long l= pageInfo1.getTotal();
        GoodsCategories gc= null;
        List<GoodsCategories> list1 = new ArrayList<GoodsCategories>();
        //将数据转到商品-菜单实体
        for (Goods g:list){
            gc = new GoodsCategories();
            gc.setGoodsId(g.getGoodsId());
            gc.setGoodsName(g.getGoodsName());
            gc.setGoodsDescriptive(g.getGoodsDescriptive());
            gc.setGoodsImg(g.getGoodsImg());
            gc.setAddTime(g.getAddTime());
            gc.setGoodsNo(g.getGoodsNo());
            gc.setGoodsPrice(g.getGoodsPrice());
            //0,1改为上架下架
            if(g.getGoodsStatus().equals(1)){
                gc.setGoodsStatus("下架");
            }else{
                gc.setGoodsStatus("上架");
            }
            gc.setGoodsTitle(g.getGoodsTitle());
            gc.setcName(g.getCategories().getcName());
            gc.setcCompany(g.getCategories().getcCompany());
            gc.setcStore(g.getCategories().getcStore());
            gc.setcId(g.getCategories().getcId());
            list1.add(gc);
        }

        //封装查询信息，便于使用，返回商品-菜单实体
        PageInfo<GoodsCategories> pageInfo = new PageInfo<GoodsCategories>(list1);
        pageInfo.setTotal(l);
        return pageInfo;
    }
}
