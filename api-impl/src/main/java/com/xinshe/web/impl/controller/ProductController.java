package com.xinshe.web.impl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinshe.web.common.assertUtils.First;
import com.xinshe.web.common.util.ResultUtil;
import com.xinshe.web.domain.product.ProductDo;
import com.xinshe.web.domain.product.ProductionListQuery;
import com.xinshe.web.domain.product.ProductionQuery;
import com.xinshe.web.request.ProductionListRequest;
import com.xinshe.web.request.ProductionRequest;
import com.xinshe.web.service.ProductionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zengqingzhou on 2019/7/30 23:34
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductionService productionService;

    /**
     * 产品列表页
     */
    @RequestMapping(value = "/getProductListPage")
    public String getProductListPage(){
        return "/product-list";
    }

    /**
     * 产品详情页
     */
    @GetMapping(value = "/getProductDetailsPage")
    public String getProductDetailsPage(){
        return "/product-add";
    }

    /**
     * 原料列表页
     */
    @RequestMapping(value = "/getMaterialListPage")
    public String getMaterialListPage(){
        return "/material-list";
    }

    /**
     * 查询产品列表
     * @param productionListRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getProductionList", method = RequestMethod.GET)
    public ResultUtil getProductionList(@Validated ProductionListRequest productionListRequest){
        ProductionListQuery productionListQuery = JSONObject.parseObject(JSON.toJSONString(productionListRequest), ProductionListQuery.class);
        return productionService.getProductionList(productionListQuery);
    }

    /**
     * 获取产品信息
     * @param productId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getProduction", method = RequestMethod.GET)
    public ResultUtil getProduction(@RequestParam String productId){
        return productionService.getProduction(productId);
    }

    /**
     * 新增产品
     */
    @ResponseBody
    @PostMapping(value = "/insertProduction")
    public ResultUtil insertProduction(@Validated(First.class) ProductionRequest productionRequest, HttpServletRequest request){
        ProductionQuery productionQuery = new ProductionQuery();
        BeanUtils.copyProperties(productionRequest,productionQuery);
        return productionService.insertProduction(productionQuery, request);
    }

    /**
     * 修改产品
     */
    @ResponseBody
    @PostMapping(value = "/updateProduction")
    public ResultUtil updateProduction(ProductionRequest productionRequest, HttpServletRequest request){
        ProductionQuery productionQuery = new ProductionQuery();
        BeanUtils.copyProperties(productionRequest,productionQuery);
        return productionService.updateProduction(productionRequest, request);
    }

    /**
     * 删除产品
     */
    @ResponseBody
    @PostMapping(value = "/deleteProduction")
    public ResultUtil deleteProduction(@RequestParam String productId){
        return productionService.deleteProduction(productId);
    }

}
