package com.mtcarpenter.mall.portal.dao;

import com.mtcarpenter.mall.model.CmsSubject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
public interface SubjectDao {

    /**
     *
     * 获取推荐专题
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);

}
