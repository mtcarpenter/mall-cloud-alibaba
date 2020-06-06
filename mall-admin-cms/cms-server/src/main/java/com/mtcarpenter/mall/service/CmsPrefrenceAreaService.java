package com.mtcarpenter.mall.service;

import com.mtcarpenter.mall.model.CmsPrefrenceArea;
import com.mtcarpenter.mall.common.CmsPrefrenceAreaProductRelationInput;

import java.util.List;

/**
 * 优选专区Service
 * Created by macro on 2018/6/1.
 */
public interface CmsPrefrenceAreaService {
    /**
     * 获取所有优选专区
     */
    List<CmsPrefrenceArea> listAll();

    /**
     * 批量 插入 优选专区
     * @param productRelationInput
     * @param productId
     */
    void relateAndInsertList(List<CmsPrefrenceAreaProductRelationInput> productRelationInput, Long productId);

    /**
     * 批量 更新 优选专区
     * @param productRelationInput
     * @param productId
     */
    void relateAndUpdateList(List<CmsPrefrenceAreaProductRelationInput> productRelationInput, Long productId);

    /**
     * 通过id 查询  优选专区
     * @param productId
     * @return
     */
    List<CmsPrefrenceAreaProductRelationInput> relationByProductId(Long productId);
}
