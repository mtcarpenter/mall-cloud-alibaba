package com.mtcarpenter.mall.dto;

import com.mtcarpenter.mall.model.SmsCoupon;
import com.mtcarpenter.mall.model.SmsCouponProductCategoryRelation;
import com.mtcarpenter.mall.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 优惠券信息封装，包括绑定商品和绑定分类
 * Created by macro on 2018/8/28.
 */
public class SmsCouponParam extends SmsCoupon {
    @ApiModelProperty("优惠券绑定的商品")
    @Getter
    @Setter
    private List<SmsCouponProductRelation> productRelationList;
    @ApiModelProperty("优惠券绑定的商品分类")
    @Getter
    @Setter
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;

}
