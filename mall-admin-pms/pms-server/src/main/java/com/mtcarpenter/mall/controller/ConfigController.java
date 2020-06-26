package com.mtcarpenter.mall.controller;

import com.mtcarpenter.mall.common.api.CommonResult;
import com.mtcarpenter.mall.service.CmsSubjectService;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Reference(version = "1.0.0", retries = 0, check = false)
    private CmsSubjectService cmsSubjectService;

    @RequestMapping("/get")
    public CommonResult get() {
        return CommonResult.success("nacos config RefreshScope :" + applicationName);
    }


    @GetMapping("/test")
    public String test() {
        System.out.println(cmsSubjectService.listAll());
        return cmsSubjectService.cmsTest("name");
    }
}
