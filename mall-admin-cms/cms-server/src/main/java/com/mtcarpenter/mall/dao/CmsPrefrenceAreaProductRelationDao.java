package com.mtcarpenter.mall.dao;

import com.mtcarpenter.mall.model.CmsPrefrenceAreaProductRelation;
import com.mtcarpenter.mall.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义优选和商品关系操作Dao
 * Created by macro on 2018/4/26.
 */
public interface CmsPrefrenceAreaProductRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);

    /**
     * 根据商品 id 获取 优选
     * @param productId
     * @return
     */
    List<CmsPrefrenceAreaProductRelation> selectPrefrenceAreaProductRelationByProductId(@Param("productId") Long productId);
 }
