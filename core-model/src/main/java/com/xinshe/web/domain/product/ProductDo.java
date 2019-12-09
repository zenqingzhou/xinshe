package com.xinshe.web.domain.product;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by zengqingzhou on 2019/7/31 1:20
 */
@Data
public class ProductDo {
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

    /**
     * 产品原料
     */
    private String prodMaterial;

}
