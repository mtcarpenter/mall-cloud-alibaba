package com.mtcarpenter.mall.client;

import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.model.UmsIntegrationConsumeSetting;
import com.mtcarpenter.mall.model.UmsMemberReceiveAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
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
     *
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/member/address/list", method = RequestMethod.GET)
    CommonResult<List<UmsMemberReceiveAddress>> list(@RequestParam(value = "memberId", required = false) Long memberId);


    /**
     * 获取积分使用规则
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/member/productCollection/integrationConsumeSetting", method = RequestMethod.GET)
    CommonResult<UmsIntegrationConsumeSetting> integrationConsumeSetting(@RequestParam(value = "id", defaultValue = "1") Long id);


    /**
     * 获取收货地址详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/member/address/{id}", method = RequestMethod.GET)
    CommonResult<UmsMemberReceiveAddress> getItem(@PathVariable Long id);


    /**
     * 根据会员id修改会员积分
     *
     * @param id
     * @param integration
     * @return
     */
    @RequestMapping(value = "/sso/updateIntegration", method = RequestMethod.GET)
    CommonResult updateIntegration(@RequestParam("id") Long id, @RequestParam("integration") Integer integration);

}
