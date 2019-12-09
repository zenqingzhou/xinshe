package com.xinshe.web.service;

import com.xinshe.web.dao.entity.User;
import com.xinshe.web.domain.user.UserDoQuery;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zengqingzhou on 2019/7/8 22:56
 */
@Service
public interface UserService {

    String login(UserDoQuery userDoQuery, HttpServletRequest request , HttpServletResponse response);

    User getUserInfo(HttpServletRequest request);
}
