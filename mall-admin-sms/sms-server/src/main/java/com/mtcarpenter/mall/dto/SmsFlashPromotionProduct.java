package com.mtcarpenter.mall.dto;

import com.mtcarpenter.mall.common.PmsProductOutput;
import com.mtcarpenter.mall.model.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 限时购及商品信息封装
 * Created by macro on 2018/11/16.
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation{

    @Getter
    @Setter
    @ApiModelProperty("关联商品")
    private PmsProductOutput product;
}
