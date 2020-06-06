package com.mtcarpenter.mall.service.impl;

import com.mtcarpenter.mall.dao.CmsPrefrenceAreaProductRelationDao;
import com.mtcarpenter.mall.mapper.CmsPrefrenceAreaMapper;
import com.mtcarpenter.mall.mapper.CmsPrefrenceAreaProductRelationMapper;
import com.mtcarpenter.mall.model.*;
import com.mtcarpenter.mall.service.CmsPrefrenceAreaService;
import com.mtcarpenter.mall.common.CmsPrefrenceAreaProductRelationInput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品优选Service实现类
 * Created by macro on 2018/6/1.
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Autowired
    private CmsPrefrenceAreaProductRelationDao cmsPrefrenceAreaProductRelationDao;

    @Autowired
    private CmsPrefrenceAreaProductRelationMapper cmsPrefrenceAreaProductRelationMapper;


    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }

    @Override
    public void relateAndInsertList(List<CmsPrefrenceAreaProductRelationInput> productRelationInput, Long productId) {
        List<CmsPrefrenceAreaProductRelation> productRelationList = relationConvert(productRelationInput, productId);
        cmsPrefrenceAreaProductRelationDao.insertList(productRelationList);
    }



    @Override
    public void relateAndUpdateList(List<CmsPrefrenceAreaProductRelationInput> productRelationInput, Long productId) {
        List<CmsPrefrenceAreaProductRelation> productRelationList = relationConvert(productRelationInput, productId);
        //关联优选
        CmsPrefrenceAreaProductRelationExample preferenceAreaExample = new CmsPrefrenceAreaProductRelationExample();
        preferenceAreaExample.createCriteria().andProductIdEqualTo(productId);
        cmsPrefrenceAreaProductRelationMapper.deleteByExample(preferenceAreaExample);
        cmsPrefrenceAreaProductRelationDao.insertList(productRelationList);
    }

    /**
     * 通过id 查询  优选专区
     *
     * @param productId
     * @return
     */
    @Override
    public List<CmsPrefrenceAreaProductRelationInput> relationByProductId(Long productId) {
        List<CmsPrefrenceAreaProductRelation> productRelationList = cmsPrefrenceAreaProductRelationDao.selectPrefrenceAreaProductRelationByProductId(productId);
        List<CmsPrefrenceAreaProductRelationInput> productRelationInputs = productRelationList.stream().map(p -> {
            CmsPrefrenceAreaProductRelationInput relationInput = new CmsPrefrenceAreaProductRelationInput();
            BeanUtils.copyProperties(p, relationInput);
            return relationInput;
        }).collect(Collectors.toList());
        return productRelationInputs;
    }

    private List<CmsPrefrenceAreaProductRelation> relationConvert(List<CmsPrefrenceAreaProductRelationInput> productRelationInput, Long productId) {
        return productRelationInput.stream().map(p -> {
            CmsPrefrenceAreaProductRelation cmsSubjectProductRelation = new CmsPrefrenceAreaProductRelation();
            BeanUtils.copyProperties(p, cmsSubjectProductRelation);
            cmsSubjectProductRelation.setProductId(productId);
            return cmsSubjectProductRelation;
        }).collect(Collectors.toList());
    }
}
