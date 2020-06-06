package com.mtcarpenter.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@SpringBootApplication
@EnableFeignClients
public class PmsAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(PmsAdminApplication.class, args);
    }
}
