package com.mtcarpenter.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class StorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }
}
