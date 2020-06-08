package com.mtcarpenter.mall;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@SpringBootApplication
@EnableAdminServer
public class MallBootMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallBootMonitorApplication.class, args);
    }
}
