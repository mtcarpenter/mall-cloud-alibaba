package com.mtcarpenter.mall.portal.service;

import com.mtcarpenter.mall.model.CmsSubject;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
public interface SubjectService {
    /**
     * 获取推荐专题
     * @param offset
     * @param limit
     * @return
     */
    List<CmsSubject> getRecommendSubjectList(Integer offset, Integer limit);
}
