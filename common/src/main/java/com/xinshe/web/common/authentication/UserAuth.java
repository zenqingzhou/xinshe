package com.xinshe.web.common.authentication;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author WuShoulei on 2018/1/29
 */
@Data
public class UserAuth implements Serializable {

    /**
     * 用户Id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 角色编码
     */
    private Integer roleKey;

    /**
     * 功能权限数组
     */
    private String[] modelAuth;

    /**
     * 接口权限数组
     */
    private String[] interfaceAuth;

    /**
     * 数据权限
     */
    private HashMap<String, String> dataRule;
    /**
     * 用户真实姓名
     */
    private String realName;
}
