package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.model.CmsSubject;
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
@FeignClient(name = "mall-portal-content")
public interface SubjectFeign {

    /**
     * 获取推荐专题
     *
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value = "/member/subject/getRecommendSubjectList", method = RequestMethod.GET)
    CommonResult<List<CmsSubject>> getRecommendSubjectList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);
}
