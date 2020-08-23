package com.mtcarpenter.mall.portal.controller;

import com.mtcarpenter.mall.client.OrderFeign;
import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.domain.CartPromotionItem;
import com.mtcarpenter.mall.domain.SmsCouponHistoryDetail;
import com.mtcarpenter.mall.model.*;
import com.mtcarpenter.mall.portal.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@RestController
@RequestMapping("/coupon")
@Api(tags = "用户优惠券管理")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @Autowired
    private OrderFeign orderFeign;

    @ApiOperation("领取指定优惠券")
    @RequestMapping(value = "/add/{couponId}", method = RequestMethod.POST)
    public CommonResult add(@PathVariable Long couponId,
                            @RequestParam("memberId") Long memberId,
                            @RequestParam("nickName") String nickName) {
        couponService.add(couponId, memberId, nickName);
        return CommonResult.success(null, "领取成功");
    }

    @ApiOperation("获取用户优惠券历史列表")
    @ApiImplicitParam(name = "useStatus", value = "优惠券筛选类型:0->未使用；1->已使用；2->已过期",
            allowableValues = "0,1,2", paramType = "query", dataType = "integer")
    @RequestMapping(value = "/listHistory", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsCouponHistory>> listHistory(@RequestParam(value = "memberId", required = false) Long memberId,
                                                            @RequestParam(value = "useStatus", required = false) Integer useStatus) {
        List<SmsCouponHistory> couponHistoryList = couponService.listHistory(memberId, useStatus);
        return CommonResult.success(couponHistoryList);
    }

    @ApiOperation("获取用户优惠券列表")
    @ApiImplicitParam(name = "useStatus", value = "优惠券筛选类型:0->未使用；1->已使用；2->已过期",
            allowableValues = "0,1,2", paramType = "query", dataType = "integer")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<List<SmsCoupon>> list(@RequestParam(value = "memberId", required = false) Long memberId,
                                              @RequestParam(value = "useStatus", required = false) Integer useStatus) {
        List<SmsCoupon> couponHistoryList = couponService.list(memberId, useStatus);
        return CommonResult.success(couponHistoryList);
    }

    @ApiOperation("获取登录会员购物车的相关优惠券")
    @ApiImplicitParam(name = "type", value = "使用可用:0->不可用；1->可用",
            defaultValue = "1", allowableValues = "0,1", paramType = "query", dataType = "integer")
    @RequestMapping(value = "/list/cart/{type}", method = RequestMethod.GET)
    public CommonResult<List<SmsCouponHistoryDetail>> listCart(@PathVariable Integer type,
                                                               @RequestParam(value = "memberId", required = false) Long memberId) {
        List<CartPromotionItem> cartPromotionItemList = orderFeign.listPromotion(null).getData();
        List<SmsCouponHistoryDetail> couponHistoryList = couponService.listCart(cartPromotionItemList, memberId, type);
        return CommonResult.success(couponHistoryList);
    }

    @ApiOperation("获取登录会员购物车的相关优惠券")
    @ApiImplicitParam(name = "type", value = "使用可用:0->不可用；1->可用",
            defaultValue = "1", allowableValues = "0,1", paramType = "query", dataType = "integer")
    @RequestMapping(value = "/list/cart/{type}", method = RequestMethod.POST)
    public CommonResult<List<SmsCouponHistoryDetail>> listCartPromotion(@PathVariable Integer type,
                                                                        List<CartPromotionItem> cartPromotionItemList,
                                                                        @RequestParam(value = "memberId", required = false) Long memberId) {
        List<SmsCouponHistoryDetail> couponHistoryList = couponService.listCart(cartPromotionItemList, memberId, type);
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


    /**
     * 商品可用优惠券
     *
     * @param productId
     * @param productCategoryId
     * @return
     */
    @ApiOperation("商品优惠券")
    @RequestMapping(value = "/getAvailableCouponList", method = RequestMethod.GET)
    public CommonResult<List<SmsCoupon>> getAvailableCouponList(@RequestParam(value = "productId") Long productId,
                                                                @RequestParam(value = "productCategoryId") Long productCategoryId) {
        List<SmsCoupon> smsCouponList = couponService.getAvailableCouponList(productId, productCategoryId);
        return CommonResult.success(smsCouponList);
    }

    /**
     * 获取下一个场次信息
     *
     * @param date
     * @return
     */
    @ApiOperation("获取下一个场次信息")
    @RequestMapping(value = "/getNextFlashPromotionSession", method = RequestMethod.GET)
    public CommonResult<SmsFlashPromotionSession> getNextFlashPromotionSession(@RequestParam(value = "date") Date date) {
        SmsFlashPromotionSession smsFlashPromotionSession = couponService.getNextFlashPromotionSession(date);
        return CommonResult.success(smsFlashPromotionSession);
    }


    /**
     * 获取下一个场次信息
     *
     * @return
     */
    @ApiOperation("获取首页广告")
    @RequestMapping(value = "/getHomeAdvertiseList", method = RequestMethod.GET)
    public CommonResult<List<SmsHomeAdvertise>> getHomeAdvertiseList() {
        List<SmsHomeAdvertise> smsHomeAdvertise = couponService.getHomeAdvertiseList();
        return CommonResult.success(smsHomeAdvertise);
    }


    /**
     * 根据时间获取秒杀活动
     *
     * @param date
     * @return
     */
    @ApiOperation("根据时间获取秒杀活动")
    @RequestMapping(value = "/getFlashPromotion", method = RequestMethod.GET)
    public CommonResult<SmsFlashPromotion> getFlashPromotion(@RequestParam(value = "date") Date date) {
        SmsFlashPromotion smsFlashPromotion = couponService.getFlashPromotion(date);
        return CommonResult.success(smsFlashPromotion);
    }

    /**
     * 根据时间获取秒杀场次
     *
     * @param date
     * @return
     */
    @ApiOperation("根据时间获取秒杀场次")
    @RequestMapping(value = "/getFlashPromotionSession", method = RequestMethod.GET)
    public CommonResult<SmsFlashPromotionSession> getFlashPromotionSession(@RequestParam(value = "date") Date date) {
        SmsFlashPromotionSession smsFlashPromotion = couponService.getFlashPromotionSession(date);
        return CommonResult.success(smsFlashPromotion);
    }

    @ApiOperation("获取当前商品相关优惠券")
    @RequestMapping(value = "/listByProduct/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsCoupon>> listByProduct(@PathVariable Long productId) {
        List<SmsCoupon> couponHistoryList = couponService.listByProduct(productId);
        return CommonResult.success(couponHistoryList);
    }

}
