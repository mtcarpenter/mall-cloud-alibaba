package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.CmsSubjectProductRelationInput;
import com.mtcarpenter.mall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@FeignClient(name = "mall-admin-cms",path = "subject")
public interface CmsSubjectProductRelationClient {
    /**
     * 关联优选
     *
     * @param productRelationInputs
     */
    @RequestMapping(value = "/relateAndInsertList", method = RequestMethod.POST)
    CommonResult relateAndInsertList(@RequestBody List<CmsSubjectProductRelationInput> productRelationInputs, @RequestParam("productId") Long productId);

    /**
     * 批量更新关联优选
     * @param productRelationInputs
     * @param productId
     */
    @RequestMapping(value = "/relateAndUpdateList", method = RequestMethod.POST)
    CommonResult relateAndUpdateList(@RequestBody List<CmsSubjectProductRelationInput> productRelationInputs,@RequestParam("productId") Long productId);


    /**
     * 通过id查询关联优选
     * @param productId
     * @return
     */
    @RequestMapping(value = "/relationByProductId", method = RequestMethod.GET)
    CommonResult<List<CmsSubjectProductRelationInput>> relationByProductId(@RequestParam("productId") Long productId ) ;

}