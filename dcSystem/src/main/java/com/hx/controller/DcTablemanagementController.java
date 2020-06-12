package com.hx.controller;

import com.hx.service.DcTablemanagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Controller
@RequestMapping("dcTablemanagement")
public class DcTablemanagementController extends BaseController {

    @Resource
    private DcTablemanagementService dcTablemanagementService;
}
