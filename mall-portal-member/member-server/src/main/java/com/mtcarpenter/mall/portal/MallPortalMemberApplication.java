package com.mtcarpenter.mall.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@SpringBootApplication(scanBasePackages = "com.mtcarpenter.mall")
@EnableFeignClients(basePackages = "com.mtcarpenter.mall.client")
public class MallPortalMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallPortalMemberApplication.class, args);
    }


}
