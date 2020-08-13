package com.mtcarpenter.mall.controller;

import com.mtcarpenter.mall.common.CmsPrefrenceAreaProductRelationInput;
import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.model.CmsPrefrenceArea;
import com.mtcarpenter.mall.service.CmsPrefrenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品优选管理Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "CmsPrefrenceAreaController", description = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {
    @Autowired
    private CmsPrefrenceAreaService prefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsPrefrenceArea>> listAll() {
        List<CmsPrefrenceArea> prefrenceAreaList = prefrenceAreaService.listAll();
        return CommonResult.success(prefrenceAreaList);
    }

    @ApiOperation("批量关联专题")
    @RequestMapping(value = "/relateAndInsertList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult relateAndInsertList(@RequestBody List<CmsPrefrenceAreaProductRelationInput> productRelationInput,
                                            @RequestParam("productId") Long productId) {
        prefrenceAreaService.relateAndInsertList(productRelationInput, productId);
        return CommonResult.success(null);
    }

    @ApiOperation("批量更新关联专题")
    @RequestMapping(value = "/relateAndUpdateList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult relateAndUpdateList(@RequestBody List<CmsPrefrenceAreaProductRelationInput> productRelationInput,
                                            @RequestParam("productId") Long productId) {

        prefrenceAreaService.relateAndUpdateList(productRelationInput, productId);
        return CommonResult.success(null);
    }


    @ApiOperation("通过id查询关联专题")
    @RequestMapping(value = "/relationByProductId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsPrefrenceAreaProductRelationInput>> relationByProductId(@RequestParam("productId") Long productId) {
        List<CmsPrefrenceAreaProductRelationInput> productRelationList = prefrenceAreaService.relationByProductId(productId);
        return CommonResult.success(productRelationList);
    }

}
