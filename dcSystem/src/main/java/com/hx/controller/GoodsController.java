package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.Categories;
import com.hx.entity.Goods;
import com.hx.entity.GoodsCategories;
import com.hx.service.GoodsService;
import com.hx.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Goods")
public class GoodsController {
    @Resource
    FileUploadUtil fileUploadUtil;
    @Resource
    GoodsService goodsService;

    @RequestMapping("/selectGoods")
    @ResponseBody
    public Object selectGoods(Goods goods, Categories categories, Integer page, Integer rows) {
        if(goods.getGoodsName()==""){
            goods.setGoodsName(null);
        }
        if(goods.getGoodsNo()==""){
            goods.setGoodsNo(null);
        }
        if(categories.getcStore()==""){
            categories.setcStore(null);
        }
        if(categories.getcCompany()==""){
            categories.setcCompany(null);
        }
        if(categories.getcName()==""){
            categories.setcName(null);
        }
        goods.setCategories(categories);
        PageInfo<GoodsCategories> pageInfo = goodsService.selectGoods(null, page, rows);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @RequestMapping("/t")
    @ResponseBody
    public Object t(String content1) {
        System.out.println(content1);
        return content1;
    }

    @RequestMapping("/insetGoods")
    @ResponseBody
    public Object insetGoods(@RequestParam("file") MultipartFile file, Goods goods, Categories categories) {
        goods.setCategories(categories);
        String path = fileUploadUtil.upload(file);
        goods.setGoodsImg(path);
        return goodsService.insertSelective(goods);
    }

    @RequestMapping("/updataGoods")
    @ResponseBody
    public Object updataGoods(Goods goods) {
        return goodsService.updateByPrimaryKeySelective(goods);
    }

}
