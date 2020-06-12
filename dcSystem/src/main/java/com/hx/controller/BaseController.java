package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.service.*;
import com.hx.util.EasyUIResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2020/5/20.
 */
@Controller
@RequestMapping("/BaseController")
public class BaseController {
    @Resource
    TableService tableService;
    @Resource
    CookingsService cookingService;
    @Resource
    TableStateService tableStateService;
    @Resource
    CookDetailService cookDetailService;
    @Resource
    ServletContext application;
    @Resource
    private SpecificationService specificationService;
    @Resource
    GoodsService goodsService;

     //这是分页的json数据转换的方法
    public <T> Map<String,Object> getPageMap(PageInfo<T> pageInfo) {
        Map<String, Object> tableMap = new HashMap<>();
        tableMap.put("total", pageInfo.getTotal());
        tableMap.put("rows", pageInfo.getList());
        //这是分页的json数据转换的方法
        public <T> Map<String, Object> getPageMap (PageInfo < T > pageInfo) {
            Map<String, Object> tableMap = new HashMap<>();
            tableMap.put("total", pageInfo.getTotal());
            tableMap.put("rows", pageInfo.getList());
            return tableMap;
        }

        //这是公共路径发起请求的方法
 /*   @RequestMapping("/path/{bag}/{file}")*/
  /*  public String getPath(@PathVariable("bag") String bag, @PathVariable("file") String file, HttpSession session, @RequestParam("ID") String ID) {
        String path = null;
        System.out.println(file);*/

    public String getPath(@PathVariable("bag") String bag, @PathVariable("file") String file, HttpSession session, @RequestParam("ID") String ID) {
        String path = null;
        //当ID传过来的等于0时，为没ID的,取非时，证明有ID，把Id传给页面。
        if (!(ID.equals("0"))) {
            System.out.println(ID);
            session.setAttribute("Id", ID);
        }

        //如果有包名的情况下
        if (bag != null && file != null) {
            path = "forward:/" + bag + "/" + file + ".jsp";
            //如果在没包名的情况下
        }
        return path;
    }
    //这里还可以写查询所有数据的方法，所有关于数据展示的界面，都会用到这个方法
    //但也存在一些问题：主要是参数带来的问题：比如有些参数要进行处理，才不会带来查询不出的问题，
    //但参数有的需要，有点不需要，这样就无法进行参数的统一和抽取。
    //方案是把它们传到业务层在进行参数处理，controller层不进行处理。controller只进行跳转的业务逻辑的抽取。
    //因为该业务的逻辑代码不多，进行抽取还要进行对象的赋值处理，这样做得不偿失。


    //关于只做业务删除，不做数据库删除的问题！
    //其实简单的做法就是用一个map或list作为中间的过度容器，作为单独与两方进行数据交互的中间体。
    //但最原始的肯定都只面向各自的对象，所以能不能作为一个独特的容器，已面向所有对象呢？
    //由此就要抽离这个容器的最一般的特性，比如储存功能，那么储存的类型是否受限，如受限就只能存取一种或多种
    //无法实现存取所有数据类型的目的，泛型可以有效的解决该问题。
    //另一个就是与外部对象的数据传输的耦合程度的问题，如何高度耦合，哪怕即使实现了数据存取广泛性，也无法实现理想的状态。

    /**
     * 在原基础加入分页工具类，余忠
     */
    public <T> EasyUIResult<T> getEasyUIResult(PageInfo<T> pageInfo) {
        EasyUIResult easyUIResult = new EasyUIResult();
        easyUIResult.setTotal(pageInfo.getTotal());
        easyUIResult.setRows(pageInfo.getList());
        return easyUIResult;
    }

    @RequestMapping(value = "/findUrl/{folder}/{file}")
    public String findUrl(@PathVariable String folder, @PathVariable String file) {
        return folder + "/" + file;
    }

}
