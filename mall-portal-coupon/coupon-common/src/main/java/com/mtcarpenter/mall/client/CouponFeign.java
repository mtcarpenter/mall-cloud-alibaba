package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.domain.CartPromotionItem;
import com.mtcarpenter.mall.domain.SmsCouponHistoryDetail;
import com.mtcarpenter.mall.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@FeignClient(name = "mall-portal-coupon", path = "coupon")
public interface CouponFeign {

    /**
     * 条件优惠券
     *
     * @param couponId
     * @param memberId
     * @param nickName
     * @return
     */
    @PostMapping(value = "/add/{couponId}")
    CommonResult add(@PathVariable Long couponId, @RequestParam("memberId") Long memberId, @RequestParam("nickName") String nickName);

    /**
     * 获取用户优惠券历史列表
     *
     * @param memberId
     * @param useStatus
     * @return
     */
    @GetMapping(value = "/listHistory")
    CommonResult<List<SmsCouponHistory>> listHistory(@RequestParam(value = "memberId", required = false) Long memberId,
                                                     @RequestParam(value = "useStatus", required = false) Integer useStatus);


    /**
     * 优惠券筛选类型:0->未使用；1->已使用；2->已过期
     *
     * @param memberId  会员id
     * @param useStatus 筛选
     * @return
     */
    @GetMapping(value = "/list")
    CommonResult<List<SmsCoupon>> list(@RequestParam(value = "memberId", required = false) Long memberId,
                                       @RequestParam(value = "useStatus", required = false) Integer useStatus);


    /**
     * 获取登录会员购物车的相关优惠券
     */
    @GetMapping(value = "/list/cart/{type}")
    CommonResult<List<SmsCouponHistoryDetail>> listCart(@PathVariable Integer type,
                                                        @RequestParam(value = "memberId", required = false) Long memberId);

    /**
     * 获取登录会员购物车的相关优惠券
     *
     * @param type
     * @param cartPromotionItemList
     * @param memberId
     * @return
     */
    @PostMapping(value = "/list/cart/{type}")
    CommonResult<List<SmsCouponHistoryDetail>> listCartPromotion(@PathVariable Integer type,
                                                                 List<CartPromotionItem> cartPromotionItemList,
                                                                 @RequestParam(value = "memberId", required = false) Long memberId);

    /**
     * 将优惠券信息更改为指定状态
     *
     * @param couponId  优惠券id
     * @param memberId  会员id
     * @param useStatus 0->未使用；1->已使用
     */
    @GetMapping(value = "/updateCouponStatus")
    CommonResult updateCouponStatus(@RequestParam(value = "couponId") Long couponId,
                                    @RequestParam(value = "memberId") Long memberId,
                                    @RequestParam(value = "useStatus") Integer useStatus);


    /**
     * 商品可用优惠券
     *
     * @param productId
     * @param productCategoryId
     * @return
     */
    @RequestMapping(value = "/getAvailableCouponList", method = RequestMethod.GET)
    CommonResult<List<SmsCoupon>> getAvailableCouponList(@RequestParam(value = "productId") Long productId,
                                                         @RequestParam(value = "productCategoryId") Long productCategoryId);


    /**
     * 获取下一个场次信息
     *
     * @param date
     * @return
     */
    @RequestMapping(value = "/getNextFlashPromotionSession", method = RequestMethod.GET)
    CommonResult<SmsFlashPromotionSession> getNextFlashPromotionSession(@RequestParam(value = "date") Date date);


    /**
     * 获取下一个场次信息
     *
     * @return
     */
    @RequestMapping(value = "/getHomeAdvertiseList", method = RequestMethod.GET)
    CommonResult<List<SmsHomeAdvertise>> getHomeAdvertiseList();


    /**
     * 根据时间获取秒杀活动
     *
     * @param date
     * @return
     */
    @RequestMapping(value = "/getFlashPromotion", method = RequestMethod.GET)
    CommonResult<SmsFlashPromotion> getFlashPromotion(@RequestParam(value = "date") Date date);

    /**
     * 根据时间获取秒杀场次
     *
     * @param date
     * @return
     */
    @RequestMapping(value = "/getFlashPromotionSession", method = RequestMethod.GET)
    CommonResult<SmsFlashPromotionSession> getFlashPromotionSession(@RequestParam(value = "date") Date date);
}
