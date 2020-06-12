package com.hx.controller;

import com.hx.entity.Categories;
import com.hx.service.BaseService;
import com.hx.service.CategoriesService;
import com.hx.service.GoodsService;
import com.hx.service.SpecificationService;
import com.hx.util.CategoriesTree;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Categories")
public class CategoriesController {
    @Resource
    CategoriesService categoriesService;

   @RequestMapping("/insertCategories")
   @ResponseBody
    public int insertCategories(Categories categories){
       //获取登录账户数据
       categories.setcCompany("公司1");
       categories.setcStore("店铺1");
       return categoriesService.insertSelective(categories);
    }
    @RequestMapping("/updataCategories")
    @ResponseBody
    public int updataCategories(Categories categories){
       return categoriesService.updateByPrimaryKeySelective(categories);

    }
    @RequestMapping("/delCategories")
    @ResponseBody
    public int delCategories(Categories categories){
        return categoriesService.delCategories(categories);
    }
    @RequestMapping("/selectCategories")
    @ResponseBody
    public Object selectCategories(Categories categories){
        //获取登录用户公司店铺
        categories.setcCompany("公司1");
        categories.setcStore("店铺1");
        categoriesService.selectCategories(categories);
        CategoriesTree categoriesTree1 = new CategoriesTree();
        categoriesTree1.setId(1);
        categoriesTree1.setText("菜单");
        categoriesTree1.setChildren(new ArrayList<CategoriesTree>());

        CategoriesTree categoriesTree2;
        for (Categories c:categoriesService.selectCategories(categories)){
            categoriesTree2 = new CategoriesTree();
            categoriesTree2.setId(c.getcId());
            categoriesTree2.setText(c.getcName());
            categoriesTree1.getChildren().add(categoriesTree2);
        }
        List l = new ArrayList();
        l.add(categoriesTree1);
        return l;
    }

}
