package com.mtcarpenter.mall.portal.service;

import com.mtcarpenter.mall.common.CartPromotionItemOutput;
import com.mtcarpenter.mall.common.SmsCouponHistoryDetailOutput;
import com.mtcarpenter.mall.common.SmsCouponHistoryOutput;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
public interface CouponService {
    /**
     * 添加优惠券
     *
     * @param couponId
     * @param memberId
     * @param nickName
     */
    void add(Long couponId, Long memberId, String nickName);

    /**
     * 获取用户优惠券列表
     *
     * @param memberId
     * @param useStatus
     * @return
     */
    List<SmsCouponHistoryOutput> list(Long memberId, Integer useStatus);

    /**
     * 获取登录会员购物车的相关优惠券
     *
     * @param cartPromotionItemList
     * @param memberId
     * @param type
     * @return
     */
    List<SmsCouponHistoryDetailOutput> listCart(List<CartPromotionItemOutput> cartPromotionItemList, Long memberId, Integer type);
}
