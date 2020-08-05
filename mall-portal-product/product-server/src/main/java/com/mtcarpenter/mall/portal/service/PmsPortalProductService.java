package com.mtcarpenter.mall.portal.service;

import com.mtcarpenter.mall.domain.CartProduct;
import com.mtcarpenter.mall.domain.PromotionProduct;
import com.mtcarpenter.mall.model.PmsProduct;
import com.mtcarpenter.mall.portal.domain.PmsPortalProductDetail;
import com.mtcarpenter.mall.portal.domain.PmsProductCategoryNode;

import java.util.List;

/**
 * 前台商品管理Service
 * Created by macro on 2020/4/6.
 */
public interface PmsPortalProductService {
    /**
     * 综合搜索商品
     */
    List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    /**
     * 以树形结构获取所有商品分类
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * 获取前台商品详情
     */
    PmsPortalProductDetail detail(Long id);

    /**
     * 获取购物车中某个商品的规格,用于重选规格
     *
     * @param productId
     * @return
     */
    CartProduct getCartProduct(Long productId);

    /**
     * 获取促销商品
     *
     * @param productIdList
     * @return
     */
    List<PromotionProduct> getPromotionProductList(List<Long> productIdList);


    /**
     * 锁定下单商品的所有库存
     *
     * @param productSkuId
     * @param quantity
     * @return
     */
    void lockStock(Long productSkuId, Integer quantity);

    /**
     * 获取商品详情
     * @param productId
     * @return
     */
    PmsProduct getPmsProductById(Long productId);

}
