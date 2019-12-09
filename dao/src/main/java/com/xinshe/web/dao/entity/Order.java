package com.xinshe.web.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    /**
     * 序号
     */
    private Long id;

    /**
     * 产品id
     */
    private Integer prodId;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 订单数量
     */
    private Integer orderNum;

    /**
     * 出售时间
     */
    private Date saleTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 更新人id
     */
    private Integer updateId;

    /**
     * 更新时间
     */
    private Date updateTime;

}