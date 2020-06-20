package com.mtcarpenter.mall.domain;


import com.mtcarpenter.mall.model.SmsCoupon;
import com.mtcarpenter.mall.model.SmsCouponHistory;
import com.mtcarpenter.mall.model.SmsCouponProductCategoryRelation;
import com.mtcarpenter.mall.model.SmsCouponProductRelation;
import lombok.Data;

import java.util.List;


/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@Data
public class SmsCouponHistoryDetail extends SmsCouponHistory {
    /**
     * 相关优惠券信息
     */
    private SmsCoupon coupon;
    /**
     * 优惠券关联商品
     */
    private List<SmsCouponProductRelation> productRelationList;
    /**
     * 优惠券关联商品分类
     */
    private List<SmsCouponProductCategoryRelation> categoryRelationList;


}
