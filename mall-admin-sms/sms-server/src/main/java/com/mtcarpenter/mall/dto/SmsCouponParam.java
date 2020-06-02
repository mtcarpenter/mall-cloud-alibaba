package com.mtcarpenter.mall.dto;

import com.mtcarpenter.mall.model.SmsCoupon;
import com.mtcarpenter.mall.model.SmsCouponProductCategoryRelation;
import com.mtcarpenter.mall.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 优惠券信息封装，包括绑定商品和绑定分类
 * Created by macro on 2018/8/28.
 */
public class SmsCouponParam extends SmsCoupon {
    @ApiModelProperty("优惠券绑定的商品")
    private List<SmsCouponProductRelation> productRelationList;
    @ApiModelProperty("优惠券绑定的商品分类")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;

    public List<SmsCouponProductRelation> getProductRelationList() {
        return productRelationList;
    }

    public void setProductRelationList(List<SmsCouponProductRelation> productRelationList) {
        this.productRelationList = productRelationList;
    }

    public List<SmsCouponProductCategoryRelation> getProductCategoryRelationList() {
        return productCategoryRelationList;
    }

    public void setProductCategoryRelationList(List<SmsCouponProductCategoryRelation> productCategoryRelationList) {
        this.productCategoryRelationList = productCategoryRelationList;
    }
}
