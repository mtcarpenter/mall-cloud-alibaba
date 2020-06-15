package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.SmsCouponHistoryDetailOutput;
import com.mtcarpenter.mall.common.SmsCouponHistoryOutput;
import com.mtcarpenter.mall.common.api.CommonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@FeignClient(name = "mall-admin-cms", path = "prefrenceArea")
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
    public CommonResult add(@PathVariable Long couponId, @RequestParam("memberId") Long memberId, @RequestParam("nickName") String nickName);


    /**
     * 优惠券筛选类型:0->未使用；1->已使用；2->已过期
     *
     * @param memberId  会员id
     * @param useStatus 筛选
     * @return
     */
    @GetMapping(value = "/list")
    public CommonResult<List<SmsCouponHistoryOutput>> list(@RequestParam(value = "memberId", required = false) Long memberId,
                                                           @RequestParam(value = "useStatus", required = false) Integer useStatus);

    @ApiOperation("")
    @ApiImplicitParam(name = "type", value = "使用可用:0->不可用；1->可用",
            defaultValue = "1", allowableValues = "0,1", paramType = "query", dataType = "integer")


    /**
     * 获取登录会员购物车的相关优惠券
     */
    @GetMapping(value = "/list/cart/{type}")
    public CommonResult<List<SmsCouponHistoryDetailOutput>> listCart(@PathVariable Integer type,
                                                                     @RequestParam(value = "memberId", required = false) Long memberId);

}
