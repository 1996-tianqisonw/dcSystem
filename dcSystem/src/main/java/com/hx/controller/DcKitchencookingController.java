package com.hx.controller;

import com.hx.service.DcKitchencookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Lenovo on 2020/5/28.
 */
@Controller
@RequestMapping("dcKitchencooking")
public class DcKitchencookingController extends BaseController {

    @Resource
    private DcKitchencookingService dcKitchencookingService;
}
