package com.mtcarpenter.mall.portal;

import com.mtcarpenter.mall.client.ProductFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@EnableFeignClients(basePackages = "com.mtcarpenter.mall.client")
@SpringBootApplication(scanBasePackages = "com.mtcarpenter.mall")
public class MallPortalOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPortalOrderApplication.class, args);
    }

}