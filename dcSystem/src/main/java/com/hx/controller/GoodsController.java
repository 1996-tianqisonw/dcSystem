package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Goods;
import com.hx.service.GoodsService;
import com.hx.util.EntitySave;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Controller
@RequestMapping("goods")
public class GoodsController extends BaseController {

    @Resource
    private GoodsService goodsService;

    //分页查询商品
    @RequestMapping("selectGoodsPage")
    @ResponseBody
    public Object selectPage(Goods goods, Integer page, Integer rows) {
        //调用业务层查询数据
        PageInfo<Goods> pageInfo = goodsService.selectPage(goods, page, rows);
        //System.out.println("goods = " + getPageMap(pageInfo));

        return getPageMap(pageInfo);
    }



    @RequestMapping("/selectGoods1")
    @ResponseBody
    public void selectGoods1()
    {
        List<Goods> list = EntitySave.goodsList;
        //System.out.println("select goods111111 list = "+list);

    }
}
