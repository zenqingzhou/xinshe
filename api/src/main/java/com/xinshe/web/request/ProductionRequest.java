package com.xinshe.web.request;

import com.xinshe.web.common.assertUtils.First;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by zengqingzhou on 2019/8/4 14:27
 */
@Data
public class ProductionRequest {
    /**
     * 产品编号
     */
    @NotNull(groups = First.class)
    private String prodId;

    /**
     * 产品名称
     */
    @NotNull(groups = First.class)
    private String prodName;

    /**
     * 产品颜色
     */
    private String prodColor;

    /**
     * 产品原料
     */
    @NotNull(groups = First.class)
    private String prodMaterial;
}
