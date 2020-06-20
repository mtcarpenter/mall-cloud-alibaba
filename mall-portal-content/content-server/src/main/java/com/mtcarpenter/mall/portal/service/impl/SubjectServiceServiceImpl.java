package com.mtcarpenter.mall.portal.service.impl;

import com.mtcarpenter.mall.model.CmsSubject;
import com.mtcarpenter.mall.portal.dao.SubjectDao;
import com.mtcarpenter.mall.portal.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@Service
public class SubjectServiceServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;


    /**
     * 获取推荐专题
     *
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public List<CmsSubject> getRecommendSubjectList(Integer offset, Integer limit) {
        return subjectDao.getRecommendSubjectList(offset, limit);
    }
}
