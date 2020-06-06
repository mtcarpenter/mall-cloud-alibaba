package com.mtcarpenter.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.mtcarpenter.mall.dao.CmsSubjectProductRelationDao;
import com.mtcarpenter.mall.mapper.CmsSubjectMapper;
import com.mtcarpenter.mall.mapper.CmsSubjectProductRelationMapper;
import com.mtcarpenter.mall.model.CmsSubject;
import com.mtcarpenter.mall.model.CmsSubjectExample;
import com.mtcarpenter.mall.model.CmsSubjectProductRelation;
import com.mtcarpenter.mall.model.CmsSubjectProductRelationExample;
import com.mtcarpenter.mall.service.CmsSubjectService;
import com.mtcarpenter.mall.common.CmsSubjectProductRelationInput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品专题Service实现类
 * Created by macro on 2018/6/1.
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Autowired
    private CmsSubjectProductRelationDao subjectProductRelationDao;

    @Autowired
    private CmsSubjectProductRelationMapper subjectProductRelationMapper;


    @Override
    public List<CmsSubject> listAll() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }

    @Override
    public List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andTitleLike("%" + keyword + "%");
        }
        return subjectMapper.selectByExample(example);
    }

    @Override
    public void relateAndInsertList(List<CmsSubjectProductRelationInput> productRelationInputs, Long productId) {
        List<CmsSubjectProductRelation> productRelationList = relationConvert(productRelationInputs, productId);
        subjectProductRelationDao.insertList(productRelationList);
    }



    @Override
    public void relateAndUpdateList(List<CmsSubjectProductRelationInput> productRelationInputs, Long productId) {
        List<CmsSubjectProductRelation> productRelationList = relationConvert(productRelationInputs, productId);
        //关联专题
        CmsSubjectProductRelationExample subjectProductRelationExample = new CmsSubjectProductRelationExample();
        subjectProductRelationExample.createCriteria().andProductIdEqualTo(productId);
        subjectProductRelationMapper.deleteByExample(subjectProductRelationExample);
        subjectProductRelationDao.insertList(productRelationList);
    }

    @Override
    public List<CmsSubjectProductRelationInput> relationByProductId(Long productId) {
        List<CmsSubjectProductRelation> productRelationList = subjectProductRelationDao.selectSubjectProductRelationByProductId(productId);
        List<CmsSubjectProductRelationInput> productRelationInputs = productRelationList.stream().map(p -> {
            CmsSubjectProductRelationInput cmsSubjectProductRelationInput = new CmsSubjectProductRelationInput();
            BeanUtils.copyProperties(p, cmsSubjectProductRelationInput);
            return cmsSubjectProductRelationInput;
        }).collect(Collectors.toList());
        return productRelationInputs;
    }


    private List<CmsSubjectProductRelation> relationConvert(List<CmsSubjectProductRelationInput> productRelationInputs, Long productId) {
        return productRelationInputs.stream().map(p -> {
            CmsSubjectProductRelation cmsSubjectProductRelation = new CmsSubjectProductRelation();
            BeanUtils.copyProperties(p, cmsSubjectProductRelation);
            cmsSubjectProductRelation.setProductId(productId);
            return cmsSubjectProductRelation;
        }).collect(Collectors.toList());
    }
}
