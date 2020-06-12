package com.hx.controller;


import com.github.pagehelper.PageInfo;
import com.hx.entity.Categories;
import com.hx.entity.Specification;
import com.hx.service.BaseService;
import com.hx.service.SpecificationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("Specification")
public class SpecificationController {
    @Resource
    SpecificationService specificationService;

    @RequestMapping("/insertSpecification")
    @ResponseBody
    public Object insertSpecification(Specification specification, Categories categories){
        specification.setCategories(categories);
        return  specificationService.insertSelective(specification);
    }

    @RequestMapping("/selectSpecification")
    @ResponseBody
    public Object selectSpecification(Categories categories,Integer page,Integer rows){

        Specification specification = new Specification();
        specification.setCategories(categories);
        PageInfo<Specification> pageInfo = specificationService.selectPage(specification, page, rows);
        Map< String, Object> map = new HashMap<String, Object>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;

    }
    @RequestMapping("/selectSpe")
    @ResponseBody
    public Object selectSpe(Categories categories){

        Specification specification = new Specification();
        specification.setCategories(categories);
        return  specificationService.selectSpecification(specification);

    }
    @RequestMapping("/updataSpecification")
    @ResponseBody
    public Object updataSpecification(Specification specification, Categories categories){
        specification.setCategories(categories);
        return specificationService.updateByPrimaryKeySelective(specification);
    }
    @RequestMapping("/delSpecification")
    @ResponseBody
    public Object delSpecification(String[] ids){
        return specificationService.delSpecification(ids);
    }

}
