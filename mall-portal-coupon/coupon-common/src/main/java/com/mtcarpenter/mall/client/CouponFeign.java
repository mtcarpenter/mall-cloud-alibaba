package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.CartPromotionItemOutput;
import com.mtcarpenter.mall.common.SmsCouponHistoryDetailOutput;
import com.mtcarpenter.mall.common.SmsCouponHistoryOutput;
import com.mtcarpenter.mall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@FeignClient(name = "coupon-server", path = "prefrenceArea")
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
     * 优惠券筛选类型:0->未使用；1->已使用；2->已过期
     *
     * @param memberId  会员id
     * @param useStatus 筛选
     * @return
     */
    @GetMapping(value = "/list")
    CommonResult<List<SmsCouponHistoryOutput>> list(@RequestParam(value = "memberId", required = false) Long memberId,
                                                    @RequestParam(value = "useStatus", required = false) Integer useStatus);


    /**
     * 获取登录会员购物车的相关优惠券
     */
    @GetMapping(value = "/list/cart/{type}")
    CommonResult<List<SmsCouponHistoryDetailOutput>> listCart(@PathVariable Integer type,
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
    CommonResult<List<SmsCouponHistoryDetailOutput>> listCartPromotion(@PathVariable Integer type,
                                                                       List<CartPromotionItemOutput> cartPromotionItemList,
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
}
