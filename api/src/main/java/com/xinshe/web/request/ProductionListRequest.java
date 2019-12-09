package com.xinshe.web.request;

import lombok.Data;

/**
 * Created by zengqingzhou on 2019/7/31 1:23
 */
@Data
public class ProductionListRequest {
    /**
     * 产品名称
     */
    private String prodName;
    /**
     * 当前页数
     */
    private Integer page;

    /**
     * 分页大小
     */
    private Integer limit;
}
