package com.hx.controller;

import com.hx.service.GoodsService;
import com.hx.service.SpecificationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

@Controller
@RequestMapping("/base")
public class BaseController {
    @Resource
    ServletContext application;
    @Resource
    private SpecificationService specificationService;
    @Resource
    private GoodsService goodsService;
    @RequestMapping("goURL/{folder}/{file}")
    public String goURL(@PathVariable("folder")String folder, @PathVariable("file") String file)
    {
        System.out.println("url = "+folder+"/"+file);
        return "forward:/WEB-INF/"+folder+"/"+file+".jsp";
    }
}
