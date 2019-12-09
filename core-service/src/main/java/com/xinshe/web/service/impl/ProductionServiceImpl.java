package com.xinshe.web.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xinshe.web.common.util.ResultUtil;
import com.xinshe.web.dao.entity.Product;
import com.xinshe.web.dao.entity.ProductQuery;
import com.xinshe.web.dao.entity.User;
import com.xinshe.web.dao.mapper.ProductDao;
import com.xinshe.web.domain.product.ProductDo;
import com.xinshe.web.domain.product.ProductionListQuery;
import com.xinshe.web.domain.product.ProductionQuery;
import com.xinshe.web.request.ProductionRequest;
import com.xinshe.web.service.ProductionService;
import com.xinshe.web.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zengqingzhou on 2019/7/31 1:13
 */
@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserService userService;

    /**
     * 查询产品列表
     * @param productionListQuery
     * @return
     */
    @Override
    public ResultUtil getProductionList(ProductionListQuery productionListQuery) {
        ProductQuery productQuery = new ProductQuery();
        if (StringUtils.hasText(productionListQuery.getProdName())){
            productQuery.createCriteria().andProdNameEqualTo(productionListQuery.getProdName());
        }
        Page<Object> objects = PageHelper.startPage(productionListQuery.getPage(), productionListQuery.getLimit());
        List<Product> products = productDao.selectByExample(productQuery);
        List<ProductDo> productDos = JSONArray.parseArray(JSONArray.toJSONString(products), ProductDo.class);
        return ResultUtil.ok(objects.getTotal(), productDos);
    }

    /**
     * 获取产品信息
     * @param productId
     * @return
     */
    @Override
    public ResultUtil getProduction(String productId) {
        ProductDo productDo = new ProductDo();
        ProductQuery productQuery = new ProductQuery();
        productQuery.createCriteria().andProdIdEqualTo(productId);
        List<Product> products = productDao.selectByExample(productQuery);
        if (null!=products&&products.size()>0){
            Product product = products.get(0);
            BeanUtils.copyProperties(product,productDo);
        }
        return ResultUtil.ok(productDo);
    }

    /**
     * 增加产品
     * @param productionQuery
     * @return
     */
    @Override
    public ResultUtil insertProduction(ProductionQuery productionQuery, HttpServletRequest request) {
        User userInfo = userService.getUserInfo(request);
        Product product = new Product();
        BeanUtils.copyProperties(productionQuery,product);
        product.setCreateId(userInfo.getUserId());
        product.setUpdateId(userInfo.getUserId());
        int i = productDao.insertSelective(product);
        if (i>0){
            ResultUtil.ok();
        }
        return ResultUtil.error();
    }

    /**
     * 更新产品
     * @param productionRequest
     * @param request
     * @return
     */
    @Override
    public ResultUtil updateProduction(ProductionRequest productionRequest, HttpServletRequest request) {
        User userInfo = userService.getUserInfo(request);
        Product product = new Product();
        BeanUtils.copyProperties(productionRequest,product);
        product.setUpdateId(userInfo.getUserId());
        ProductQuery productQuery = new ProductQuery();
        productQuery.createCriteria().andProdIdEqualTo(productionRequest.getProdId());
        int i = productDao.updateByExampleSelective(product, productQuery);
        if (i>0){
            return ResultUtil.ok();
        }
        return ResultUtil.error();
    }

    /**
     * s
     * @param productId
     * @return
     */
    @Override
    public ResultUtil deleteProduction(String productId) {
        ProductQuery productQuery = new ProductQuery();
        productQuery.createCriteria().andProdIdEqualTo(productId);
        int i = productDao.deleteByExample(productQuery);
        if (i>0){
            return ResultUtil.ok();
        }
        return ResultUtil.error();
    }
}
