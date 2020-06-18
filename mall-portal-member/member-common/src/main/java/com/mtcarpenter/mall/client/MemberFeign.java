package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.UmsMemberReceiveAddressOutput;
import com.mtcarpenter.mall.common.api.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@FeignClient(name = "mall-portal-member")
public interface MemberFeign {

    /**
     * 显示所有收货地址
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/member/address/list", method = RequestMethod.GET)
    CommonResult<List<UmsMemberReceiveAddressOutput>> list(@RequestParam(value = "memberId",required = false) Long memberId);

    }
