package com.xinshe.web.impl.controller;

import com.xinshe.web.common.util.CookieUtils;
import com.xinshe.web.common.util.ResultUtil;
import com.xinshe.web.dao.entity.User;
import com.xinshe.web.domain.user.UserDoQuery;
import com.xinshe.web.request.UserRequest;
import com.xinshe.web.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zengqingzhou on 2019/7/8 22:52
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil login(@Validated @RequestBody UserRequest userRequest, HttpServletRequest request, HttpServletResponse response){
        UserDoQuery userDoQuery = new UserDoQuery();
        BeanUtils.copyProperties(userRequest,userDoQuery);
        String result =  userService.login(userDoQuery, request, response);
        if ("success".equals(result)){
            return ResultUtil.ok();
        }
        return ResultUtil.error("账户或者密码错误! ");
    }

    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        CookieUtils.deleteCookie(request, response, CookieUtils.PRE_LOGIN_USER);
        return "/login";
    }

    @GetMapping("/getUserInfo")
    @ResponseBody
    public ResultUtil getUserInfo(HttpServletRequest request){
        User userInfo = userService.getUserInfo(request);
        return ResultUtil.ok(userInfo);
    }
}
