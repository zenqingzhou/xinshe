package com.xinshe.web.service;

import com.xinshe.web.common.util.ResultUtil;
import com.xinshe.web.domain.product.ProductDo;
import com.xinshe.web.domain.product.ProductionListQuery;
import com.xinshe.web.domain.product.ProductionQuery;
import com.xinshe.web.request.ProductionRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zengqingzhou on 2019/7/31 1:12
 */
public interface ProductionService {

    ResultUtil getProductionList(ProductionListQuery productionListQuery);

    ResultUtil getProduction(String productId);

    ResultUtil insertProduction(ProductionQuery productionQuery, HttpServletRequest request);

    ResultUtil updateProduction(ProductionRequest productionRequest, HttpServletRequest request);

    ResultUtil deleteProduction(String productId);
}
