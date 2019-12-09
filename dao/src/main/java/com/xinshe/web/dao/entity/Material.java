package com.xinshe.web.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Material {
    /**
     * 序号
     */
    private Long id;

    /**
     * 简图
     */
    private String diagram;

    /**
     * 原料名称
     */
    private String materialName;

    /**
     * 原料料号
     */
    private String materialId;

    /**
     * 原料材质
     */
    private String materialMaterials;

    /**
     * 位置编号
     */
    private Integer locationId;

    /**
     * 库存数量
     */
    private Integer inventoryQuantity;

    /**
     * 产品规格
     */
    private String materialSpece;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 备注
     */
    private String remarks;

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

}