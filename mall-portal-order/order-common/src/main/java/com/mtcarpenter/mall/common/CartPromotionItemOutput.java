package com.mtcarpenter.mall.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@Data
public class CartPromotionItemOutput extends OmsCartItemOutput  {
    /**
     * 促销活动信息
     */
    private String promotionMessage;
    /**
     * 促销活动减去的金额，针对每个商品
     */
    private BigDecimal reduceAmount;
    /**
     * 商品的真实库存（剩余库存-锁定库存）
     */
    private Integer realStock;
    /**
     * 购买商品赠送积分
     */
    private Integer integration;
    /**
     * 购买商品赠送成长值
     */
    private Integer growth;
}
