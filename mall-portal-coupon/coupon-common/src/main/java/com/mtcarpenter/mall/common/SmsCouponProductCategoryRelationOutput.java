package com.mtcarpenter.mall.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SmsCouponProductCategoryRelationOutput implements Serializable {
    private Long id;

    private Long couponId;

    private Long productCategoryId;

    @ApiModelProperty(value = "产品分类名称")
    private String productCategoryName;

    @ApiModelProperty(value = "父分类名称")
    private String parentCategoryName;

    private static final long serialVersionUID = 1L;


}