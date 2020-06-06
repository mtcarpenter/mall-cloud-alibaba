package com.mtcarpenter.mall.dao;

import com.mtcarpenter.mall.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品和专题关系操作Dao
 * Created by macro on 2018/4/26.
 */
public interface CmsSubjectProductRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);

    /**
     * 根据商品id 查询专题信息
     * @param productId
     * @return
     */
    List<CmsSubjectProductRelation> selectSubjectProductRelationByProductId(@Param("productId") Long productId);

}
