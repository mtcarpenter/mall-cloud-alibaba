package com.mtcarpenter.mall.controller;

import com.mtcarpenter.mall.common.api.CommonPage;
import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.model.CmsSubject;
import com.mtcarpenter.mall.model.CmsSubjectProductRelation;
import com.mtcarpenter.mall.service.CmsSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.mtcarpenter.mall.common.CmsSubjectProductRelationInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品专题Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "CmsSubjectController", description = "商品专题管理")
@RequestMapping("/subject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService subjectService;

    @ApiOperation("获取全部商品专题")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> listAll() {
        List<CmsSubject> subjectList = subjectService.listAll();
        return CommonResult.success(subjectList);
    }

    @ApiOperation(value = "根据专题名称分页获取专题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CmsSubject>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<CmsSubject> subjectList = subjectService.list(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(subjectList));
    }

    @ApiOperation("批量插入关联优选")
    @RequestMapping(value = "/relateAndInsertList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult relateAndInsertList(@RequestBody List<CmsSubjectProductRelationInput> productRelationInputs ,
                                            @RequestParam("productId") Long productId ) {
        subjectService.relateAndInsertList(productRelationInputs,productId);
        return CommonResult.success(null);
    }

    @ApiOperation("批量更新关联优选")
    @RequestMapping(value = "/relateAndUpdateList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult relateAndUpdateList(@RequestBody List<CmsSubjectProductRelationInput> productRelationInputs ,
                                            @RequestParam("productId") Long productId ) {
        subjectService.relateAndUpdateList(productRelationInputs,productId);
        return CommonResult.success(null);
    }

    @ApiOperation("通过id查询关联优选")
    @RequestMapping(value = "/relationByProductId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubjectProductRelationInput>> relationByProductId(@RequestParam("productId") Long productId ) {
        List<CmsSubjectProductRelationInput> productRelationList = subjectService.relationByProductId(productId);
        return CommonResult.success(productRelationList);
    }
}
