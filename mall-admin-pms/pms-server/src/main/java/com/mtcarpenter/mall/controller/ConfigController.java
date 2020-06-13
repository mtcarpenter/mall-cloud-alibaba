package com.mtcarpenter.mall.controller;

import com.mtcarpenter.mall.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/get")
    public CommonResult get() {
        return CommonResult.success("nacos config RefreshScope :" + applicationName);
    }


}
