package com.mtcarpenter.mall.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */

@SpringBootApplication(scanBasePackages = "com.mtcarpenter.mall")
public class MallPortalProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPortalProductApplication.class, args);
    }

}
