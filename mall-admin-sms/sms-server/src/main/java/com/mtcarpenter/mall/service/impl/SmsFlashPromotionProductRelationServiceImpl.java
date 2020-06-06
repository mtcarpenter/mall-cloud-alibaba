package com.mtcarpenter.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.mtcarpenter.mall.client.PmsProductClient;
import com.mtcarpenter.mall.common.PmsProductOutput;
import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.common.api.ResultCode;
import com.mtcarpenter.mall.dao.SmsFlashPromotionProductRelationDao;
import com.mtcarpenter.mall.dto.SmsFlashPromotionProduct;
import com.mtcarpenter.mall.mapper.SmsFlashPromotionProductRelationMapper;
import com.mtcarpenter.mall.model.SmsFlashPromotionProductRelation;
import com.mtcarpenter.mall.model.SmsFlashPromotionProductRelationExample;
import com.mtcarpenter.mall.service.SmsFlashPromotionProductRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 限时购商品关联管理Service实现类
 * Created by macro on 2018/11/16.
 */
@Service
public class SmsFlashPromotionProductRelationServiceImpl implements SmsFlashPromotionProductRelationService {
    @Autowired
    private SmsFlashPromotionProductRelationMapper relationMapper;
    @Autowired
    private SmsFlashPromotionProductRelationDao relationDao;

    @Autowired
    private PmsProductClient pmsProductClient;

    @Override
    public int create(List<SmsFlashPromotionProductRelation> relationList) {
        for (SmsFlashPromotionProductRelation relation : relationList) {
            relationMapper.insert(relation);
        }
        return relationList.size();
    }

    @Override
    public int update(Long id, SmsFlashPromotionProductRelation relation) {
        relation.setId(id);
        return relationMapper.updateByPrimaryKey(relation);
    }

    @Override
    public int delete(Long id) {
        return relationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SmsFlashPromotionProductRelation getItem(Long id) {
        return relationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<SmsFlashPromotionProduct> promotionProducts = relationDao.getList(flashPromotionId, flashPromotionSessionId);
        for (SmsFlashPromotionProduct smsFlashPromotionProduct : promotionProducts) {
            CommonResult<PmsProductOutput> result = pmsProductClient.getProductByProductId(smsFlashPromotionProduct.getProductId());
            if (result.getCode() == ResultCode.SUCCESS.getCode()){
                Gson gson = new Gson();
                PmsProductOutput pmsProductOutput = gson.fromJson(JSON.toJSONString(result.getData()), PmsProductOutput.class);
                smsFlashPromotionProduct.setProduct(pmsProductOutput);
            }

        }
        return promotionProducts;
    }

    @Override
    public long getCount(Long flashPromotionId, Long flashPromotionSessionId) {
        SmsFlashPromotionProductRelationExample example = new SmsFlashPromotionProductRelationExample();
        example.createCriteria()
                .andFlashPromotionIdEqualTo(flashPromotionId)
                .andFlashPromotionSessionIdEqualTo(flashPromotionSessionId);
        return relationMapper.countByExample(example);
    }
}
