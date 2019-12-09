package com.xinshe.web.common.authentication;

import com.xinshe.web.common.util.AgentConstant;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * zhangjinglei 2017/8/31 下午5:29
 */
@Data
public class User {

    public User() {}

    /**
     * 用户Id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 数据权限
     * //TODO 需要登录的时候补充数据权限
     */
    private HashMap<String, String> dataRule = new HashMap<>();

    /**
     * 角色编码
     */
    private Integer roleKey;


    public static User getCurrent() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        UserAuth userAuth = (UserAuth) request.getAttribute(AgentConstant.USER_AUTH);

        User user = new User();
        if (null != userAuth) {
            BeanUtils.copyProperties(userAuth, user);
        }
        return user;
    }
}
