package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.CartProduct;
import com.mtcarpenter.mall.common.CartProductOutput;
import com.mtcarpenter.mall.common.PromotionProductOutput;
import com.mtcarpenter.mall.common.api.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */

@FeignClient(name = "product-server", path = "product")
public interface ProductFeign {

    /**
     * 获取购物车中某个商品的规格,用于重选规格
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/getProduct/{productId}", method = RequestMethod.GET)
    CommonResult<CartProductOutput> getCartProduct(@PathVariable Long productId);


    /**
     * 获取促销商品
     *
     * @param productIdList
     * @return
     */
    @ApiOperation("获取促销商品")
    @RequestMapping(value = "/getPromotionProductList", method = RequestMethod.POST)
    CommonResult<List<PromotionProductOutput>> getPromotionProductList(@RequestBody(required = false) List<Long> productIdList);
}
