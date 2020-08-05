package com.mtcarpenter.mall.portal.service;


import com.mtcarpenter.mall.domain.CartPromotionItem;
import com.mtcarpenter.mall.domain.SmsCouponHistoryDetail;
import com.mtcarpenter.mall.model.*;

import java.util.Date;
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
    List<SmsCoupon> list(Long memberId, Integer useStatus);

    /**
     * 获取登录会员购物车的相关优惠券
     *
     * @param cartPromotionItemList
     * @param memberId
     * @param type
     * @return
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartPromotionItemList, Long memberId, Integer type);

    /**
     * 将优惠券信息更改为指定状态
     *
     * @param couponId
     * @param memberId
     * @param useStatus
     */
    void updateCouponStatus(Long couponId, Long memberId, Integer useStatus);

    /**
     * 商品优惠券
     * @param productId
     * @param productCategoryId
     * @return
     */
    List<SmsCoupon> getAvailableCouponList(Long productId, Long productCategoryId);

    /**
     * 获取下一个场次
     * @param date
     * @return
     */
    SmsFlashPromotionSession getNextFlashPromotionSession(Date date);

    /**
     * 获取首页广告
     * @return
     */
    List<SmsHomeAdvertise> getHomeAdvertiseList();

    /**
     * 根据时间获取秒杀活动
     * @param date
     * @return
     */
    SmsFlashPromotion getFlashPromotion(Date date);

    /**
     * 根据时间获取秒杀场次
     * @param date
     * @return
     */
    SmsFlashPromotionSession getFlashPromotionSession(Date date);

    /**
     *获取优惠券历史列表
     * @param memberId
     * @param useStatus
     * @return
     */
    List<SmsCouponHistory> listHistory(Long memberId, Integer useStatus);

    /**
     *获取当前商品相关优惠券
     * @param productId
     * @return
     */
    List<SmsCoupon> listByProduct(Long productId);
}
