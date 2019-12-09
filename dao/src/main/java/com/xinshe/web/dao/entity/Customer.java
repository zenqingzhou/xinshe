package com.xinshe.web.dao.entity;

import lombok.Data;

@Data
public class Customer {
    /**
     * 客户id
     */
    private Long id;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;
}