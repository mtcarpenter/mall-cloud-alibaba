package com.mtcarpenter.mall.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by macro on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.mtcarpenter.mall.mapper","com.mtcarpenter.mall.portal.dao"})
public class MyBatisConfig {
}
