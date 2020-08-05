package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.domain.CartProduct;
import com.mtcarpenter.mall.domain.PromotionProduct;
import com.mtcarpenter.mall.model.PmsProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */

@FeignClient(name = "mall-portal-product", path = "product")
public interface ProductFeign {

    /**
     * 获取购物车中某个商品的规格,用于重选规格
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/getProduct/{productId}", method = RequestMethod.GET)
    CommonResult<CartProduct> getCartProduct(@PathVariable Long productId);


    /**
     * 获取促销商品
     *
     * @param productIdList
     * @return
     */
    @RequestMapping(value = "/getPromotionProductList", method = RequestMethod.POST)
    CommonResult<List<PromotionProduct>> getPromotionProductList(@RequestBody(required = false) List<Long> productIdList);


    /**
     * 锁定下单商品的所有库存
     *
     * @param productSkuId
     * @param quantity
     * @return
     */
    @RequestMapping(value = "/lockStock", method = RequestMethod.POST)
    CommonResult lockStock(@RequestParam(required = false) Long productSkuId, @RequestParam(required = false) Integer quantity);

    /**
     * 获取商品详情
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/getPmsProductById/{productId}", method = RequestMethod.GET)
    CommonResult<PmsProduct> getPmsProductById(@PathVariable Long productId);
}
