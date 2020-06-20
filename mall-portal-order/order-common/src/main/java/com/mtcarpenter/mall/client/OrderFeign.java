package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.domain.CartPromotionItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@FeignClient(name = "mall-portal-order")
public interface OrderFeign {

    /**
     * 获取某个会员的购物车列表,包括促销信息
     */
    @RequestMapping(value = "/cart/list/promotion", method = RequestMethod.GET)
    CommonResult<List<CartPromotionItem>> listPromotion(@RequestParam(required = false) List<Long> cartIds);
}
