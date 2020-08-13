package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.CmsPrefrenceAreaProductRelationInput;
import com.mtcarpenter.mall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@FeignClient(name = "mall-admin-cms", path = "prefrenceArea")
public interface CmsPrefrenceAreaProductRelationClient {

    /**
     * 批量关联商品
     *
     * @param productRelationInput
     * @return
     */
    @RequestMapping(value = "/relateAndInsertList", method = RequestMethod.POST)
    CommonResult relateAndInsertList(@RequestBody List<CmsPrefrenceAreaProductRelationInput> productRelationInput, @RequestParam("productId") Long productId);


    /**
     * 批量更新关联商品
     *
     * @param productRelationInputs
     * @param productId
     */
    @RequestMapping(value = "/relateAndUpdateList", method = RequestMethod.POST)
    CommonResult relateAndUpdateList(@RequestBody List<CmsPrefrenceAreaProductRelationInput> productRelationInputs, @RequestParam("productId") Long productId);


    /**
     * 通过id查询关联专题
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/relationByProductId", method = RequestMethod.GET)
    CommonResult<List<CmsPrefrenceAreaProductRelationInput>> relationByProductId(@RequestParam("productId") Long productId);
}
