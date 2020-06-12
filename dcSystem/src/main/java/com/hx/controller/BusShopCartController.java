package com.hx.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hx.entity.Goods;
import com.hx.service.BusShopCartService;
import com.hx.util.EntitySave;
import com.hx.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Controller
@RequestMapping("busShopCart")
public class BusShopCartController extends BaseController {

    @Resource
    private BusShopCartService busShopCartService;

    //添加商品
    @RequestMapping("/addGoods")
    @ResponseBody
    public Object add(HttpServletRequest request) {

        String jsonStr = request.getParameter("params");

         System.out.println("Ajax -- list = "+ jsonStr.toString());

        List<Goods> list = new ArrayList<Goods>();

        Goods goods = null;

        JSONArray jsonArray = JsonUtil.parseArray(jsonStr);
        for(Object ob : jsonArray){
            JSONObject jObject = (JSONObject) ob;
            goods = new Goods();
            goods.setGoodsNo(jObject.getString("goodsNo"));
            goods.setGoodsTitle(jObject.getString("goodsTitle"));
            goods.setGoodsPrice(jObject.getInteger("goodsPrice"));
            goods.setGoodsImg(jObject.getString("goodsImg"));
            list.add(goods);
        }

        EntitySave.goodsList = list;
        System.out.println("add EntitySave.goodsList = "+ EntitySave.goodsList);
        Map<String,Object> map = new HashMap<>();

        if(list.size()!=0)
        {
            map.put("msg","添加成功！");

        }else {
            map.put("msg","添加失败!");
        }
        return map;
    }

    //分页查询商品到查询购物车
    @RequestMapping("/selectGoods")
    @ResponseBody
    public Object selectGoods(Goods goods, Integer page, Integer rows)
    {
        List<Goods> list = EntitySave.goodsList;
       // System.out.println("select goods list = "+list);
        //封装查询信息，便于使用
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);

        return getPageMap(pageInfo);
    }

    //删除商品
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public Object deleteGoods(HttpServletRequest request)
    {
        List<Goods> list = new ArrayList<>();
        Goods goods = new Goods();
        list = EntitySave.goodsList;
        String g = request.getParameter("ids");
        //System.out.println("ids 121312 asda= "+g.split(","));
        String[] dd = g.split(",");

        // System.out.println("dd length 121312= "+dd.length);
        //System.out.println("dd  121312= "+dd[0]);

        for(int j=0;j<dd.length;j++)
        {
            for(int i=0;i<list.size();i++)
            {
                //.out.println("dd  12312aaa ="+dd[j]);
               // System.out.println("list  12312aaa ="+list.get(i));
                if(list.get(i).getGoodsNo()!=null)
                {
                    if(list.get(i).getGoodsNo().equals(dd[j]))
                    {
                        list.get(i).setGoodsNo(null);
                        list.get(i).setGoodsTitle(null);
                        list.get(i).setGoodsPrice(0);
                        list.get(i).setGoodsImg(null);
                    }
                }
            }
        }
        EntitySave.goodsList=list;

/*        if(EntitySave.goodsList==null)
        {

        }*/


        return list;
    }
}
