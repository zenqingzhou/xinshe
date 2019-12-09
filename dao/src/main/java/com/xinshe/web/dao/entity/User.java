package com.xinshe.web.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

}