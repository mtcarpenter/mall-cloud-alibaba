package com.mtcarpenter.mall.portal.service;

import com.mtcarpenter.mall.common.CartPromotionItemOutput;
import com.mtcarpenter.mall.common.SmsCouponHistoryDetailOutput;
import com.mtcarpenter.mall.common.SmsCouponHistoryOutput;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户优惠券管理Service
 * Created by macro on 2018/8/29.
 */
public interface UmsMemberCouponService {
    /**
     * 会员添加优惠券
     */
    @Transactional
    void add(Long couponId);

    /**
     * 获取优惠券列表
     *
     * @param useStatus 优惠券的使用状态
     */
    List<SmsCouponHistoryOutput> list(Integer useStatus);

    /**
     * 根据购物车信息获取可用优惠券
     *
     * @param type
     * @return
     */
    List<SmsCouponHistoryDetailOutput> listCart(Integer type);
}
