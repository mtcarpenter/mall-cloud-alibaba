package com.mtcarpenter.mall.portal.controller;

import com.mtcarpenter.mall.common.CartPromotionItemOutput;
import com.mtcarpenter.mall.common.SmsCouponHistoryDetailOutput;
import com.mtcarpenter.mall.common.SmsCouponHistoryOutput;
import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.portal.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@RestController("/coupon")
@Api(tags = "用户优惠券管理")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @ApiOperation("领取指定优惠券")
    @RequestMapping(value = "/add/{couponId}", method = RequestMethod.POST)
    public CommonResult add(@PathVariable Long couponId,
                            @RequestParam("memberId") Long memberId,
                            @RequestParam("nickName") String nickName) {
        couponService.add(couponId, memberId, nickName);
        return CommonResult.success(null, "领取成功");
    }

    @ApiOperation("获取用户优惠券列表")
    @ApiImplicitParam(name = "useStatus", value = "优惠券筛选类型:0->未使用；1->已使用；2->已过期",
            allowableValues = "0,1,2", paramType = "query", dataType = "integer")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<List<SmsCouponHistoryOutput>> list(@RequestParam(value = "memberId", required = false) Long memberId,
                                                           @RequestParam(value = "useStatus", required = false) Integer useStatus) {
        List<SmsCouponHistoryOutput> couponHistoryList = couponService.list(memberId, useStatus);
        return CommonResult.success(couponHistoryList);
    }

    @ApiOperation("获取登录会员购物车的相关优惠券")
    @ApiImplicitParam(name = "type", value = "使用可用:0->不可用；1->可用",
            defaultValue = "1", allowableValues = "0,1", paramType = "query", dataType = "integer")
    @RequestMapping(value = "/list/cart/{type}", method = RequestMethod.GET)
    public CommonResult<List<SmsCouponHistoryDetailOutput>> listCart(@PathVariable Integer type,
                                                                     @RequestParam(value = "memberId", required = false) Long memberId) {
        List<CartPromotionItemOutput> cartPromotionItemList = new ArrayList<>();
        //@todo  cartItemService.listPromotion(memberService.getCurrentMember().getId(), null);
        List<SmsCouponHistoryDetailOutput> couponHistoryList = couponService.listCart(cartPromotionItemList, memberId, type);
        return CommonResult.success(couponHistoryList);
    }

    @ApiOperation("获取登录会员购物车的相关优惠券")
    @ApiImplicitParam(name = "type", value = "使用可用:0->不可用；1->可用",
            defaultValue = "1", allowableValues = "0,1", paramType = "query", dataType = "integer")
    @RequestMapping(value = "/list/cart/{type}", method = RequestMethod.POST)
    public CommonResult<List<SmsCouponHistoryDetailOutput>> listCartPromotion(@PathVariable Integer type,
                                                                              List<CartPromotionItemOutput> cartPromotionItemList,
                                                                              @RequestParam(value = "memberId", required = false) Long memberId
    ) {
        List<SmsCouponHistoryDetailOutput> couponHistoryList = couponService.listCart(cartPromotionItemList, memberId, type);
        return CommonResult.success(couponHistoryList);
    }

    /**
     * 将优惠券信息更改为指定状态
     *
     * @param couponId  优惠券id
     * @param memberId  会员id
     * @param useStatus 0->未使用；1->已使用
     */
    @ApiOperation("将优惠券信息更改为指定状态")
    @RequestMapping(value = "/updateCouponStatus", method = RequestMethod.GET)
    public CommonResult updateCouponStatus(@RequestParam(value = "couponId") Long couponId,
                                           @RequestParam(value = "memberId") Long memberId,
                                           @RequestParam(value = "useStatus") Integer useStatus) {
        couponService.updateCouponStatus(couponId, memberId, useStatus);
        return CommonResult.success(null);
    }

}
