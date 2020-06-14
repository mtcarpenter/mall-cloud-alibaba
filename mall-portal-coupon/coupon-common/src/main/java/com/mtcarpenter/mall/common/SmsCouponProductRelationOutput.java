package com.mtcarpenter.mall.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SmsCouponProductRelationOutput implements Serializable {
    private Long id;

    private Long couponId;

    private Long productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品编码")
    private String productSn;

    private static final long serialVersionUID = 1L;


}