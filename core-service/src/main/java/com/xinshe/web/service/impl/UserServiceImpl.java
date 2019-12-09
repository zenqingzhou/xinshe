package com.xinshe.web.service.impl;

import com.xinshe.web.common.util.CookieUtils;
import com.xinshe.web.dao.entity.User;
import com.xinshe.web.dao.entity.UserQuery;
import com.xinshe.web.dao.mapper.UserDao;
import com.xinshe.web.domain.user.UserDoQuery;
import com.xinshe.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zengqingzhou on 2019/7/8 22:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 登录
     * @param userDoQuery
     * @param request
     * @param response
     * @return
     */
    @Override
    public String login(UserDoQuery userDoQuery, HttpServletRequest request , HttpServletResponse response) {
        UserQuery userQuery = new UserQuery();
        UserQuery.Criteria criteria = userQuery.createCriteria();
        criteria.andUserNameEqualTo(userDoQuery.getUserName());
        criteria.andPassWordEqualTo(userDoQuery.getPassWord());
        List<User> users = userDao.selectByExample(userQuery);
        if (null!=users&&users.size()>0){
            User user = users.get(0);
            CookieUtils.setCookie(response, CookieUtils.PRE_LOGIN_USER, user.getUserId().toString());
            return "success";
        }
        return "fail";
    }

    /**
     * 获取用户信息
     * @return
     */
    @Override
    public User getUserInfo(HttpServletRequest request) {
        String cookie = CookieUtils.getCookie(request, CookieUtils.PRE_LOGIN_USER);
        User user = userDao.selectUserInfo(Integer.valueOf(cookie));
        return user;
    }
}
