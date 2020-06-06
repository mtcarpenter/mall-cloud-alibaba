package com.mtcarpenter.mall.service;

import com.mtcarpenter.mall.model.CmsSubject;
import com.mtcarpenter.mall.common.CmsSubjectProductRelationInput;

import java.util.List;

/**
 * 商品专题Service
 * Created by macro on 2018/6/1.
 */
public interface CmsSubjectService {
    /**
     * 查询所有专题
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询专题
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 批量插入专题
     * @param productRelationInputs
     * @param productId
     */
    void relateAndInsertList(List<CmsSubjectProductRelationInput> productRelationInputs, Long productId);

    /**
     * 批量更新
     * @param productRelationInputs
     * @param productId
     */
    void relateAndUpdateList(List<CmsSubjectProductRelationInput> productRelationInputs, Long productId);

    /**
     * 通过id查询关联优选
     * @param productId
     * @return
     */
    List<CmsSubjectProductRelationInput> relationByProductId(Long productId);
}
