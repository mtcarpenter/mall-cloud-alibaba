package com.mtcarpenter.mall.controller;

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


    @RequestMapping("/get")
    public String get() {
        return "nacos config";
    }


}
