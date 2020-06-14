package com.mtcarpenter.mall.common;

import lombok.Data;


import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@Data
public class SmsCouponHistoryDetailOutput extends SmsCouponHistoryOutput {
    /**
     * 相关优惠券信息
     */
    private SmsCouponOutput coupon;
    /**
     * 优惠券关联商品
     */
    private List<SmsCouponProductRelationOutput> productRelationList;
    /**
     * 优惠券关联商品分类
     */
    private List<SmsCouponProductCategoryRelationOutput> categoryRelationList;


}
