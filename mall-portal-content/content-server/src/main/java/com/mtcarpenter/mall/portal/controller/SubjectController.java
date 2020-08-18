package com.mtcarpenter.mall.portal.controller;

import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.model.CmsSubject;
import com.mtcarpenter.mall.portal.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@RestController
@Api(tags = "MemberCollectionController", description = "专题")
@RequestMapping("/member/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;


    @ApiOperation("获取推荐专题")
    @RequestMapping(value = "/getRecommendSubjectList", method = RequestMethod.GET)
    public CommonResult<List<CmsSubject>> getRecommendSubjectList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        List<CmsSubject> cmsSubjects = subjectService.getRecommendSubjectList(offset, limit);
        return CommonResult.success(cmsSubjects);
    }

}
