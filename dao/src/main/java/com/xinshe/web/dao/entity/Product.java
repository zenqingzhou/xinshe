package com.xinshe.web.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Product {
    /**
     * 序号
     */
    private Long id;

    /**
     * 产品编号
     */
    private String prodId;

    /**
     * 产品名称
     */
    private String prodName;

    /**
     * 产品颜色
     */
    private String prodColor;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人id
     */
    private Integer updateId;

    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

    /**
     * 产品原料
     */
    private String prodMaterial;

}