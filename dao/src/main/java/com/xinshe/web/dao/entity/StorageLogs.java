package com.xinshe.web.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class StorageLogs {
    /**
     * 序号
     */
    private Long id;

    /**
     * 原材id
     */
    private Integer materialId;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 进出库(0 : in, 1 : out)
     */
    private Integer inOrOut;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private Date createTime;

}