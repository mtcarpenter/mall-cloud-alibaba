package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.PmsProductOutput;
import com.mtcarpenter.mall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@FeignClient(name = "mall-admin-pms", path = "product")
public interface PmsProductClient {

    /**
     * 通过id查询商品信息
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/getProductByProductId", method = RequestMethod.GET)
    CommonResult<PmsProductOutput> getProductByProductId(@RequestParam("productId") Long productId);


}
