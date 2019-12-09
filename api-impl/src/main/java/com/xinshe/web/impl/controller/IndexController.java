package com.xinshe.web.impl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zengqingzhou on 2019/7/31 0:46
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String index(){
        return "/index";
    }
}
