# mall-cloud-alibaba

## 微服务学习教程

[Spring Cloud Alibaba 微服务教程](https://github.com/mtcarpenter/spring-cloud-learning)

## 前言
`mall-cloud-alibaba`通过 spring cloud alibaba 微服务体系对 mall 进行改造学习。  [原商城 mall 传送门](https://github.com/macrozheng/mall)

## 公众号
欢迎微信搜索「山间木匠」，定期分享 JAVA 相关知识

![](http://mtcarpenter.oss-cn-beijing.aliyuncs.com/logo/qrcode.jpg)

## 项目介绍

mall-cloud-alibaba 是一套基于开源商城 mall 改造的 spring cloud alibaba 体系微服务商城系统。采用了spring cloud alibaba 、 Spring Cloud Greenwich、Spring Boot 2、MyBatis、Docker、Elasticsearch等核心技术。前台商城系统包含首页门户、商品推荐、商品搜索、商品展示、购物车、订单流程、会员中心、客户服务、帮助中心等模块。 后台管理系统包含商品管理、订单管理、会员管理、促销管理、运营管理、内容管理、统计报表、财务管理、权限管理、设置等模块。

## 演示地址
前端代码地址：https://github.com/mtcarpenter/mall-admin-web

演示地址：http://148.70.69.18:8090 用户名:admin 密码:123456

## 技术栈

- 注册中心：Nacos
- 配置中心：Nacos
- 服务网关：Spring cloud Gateway
- 服务调用：Spring cloud open-Feign
- 负载均衡：Spring cloud loadbalancer
- 链路追踪：zipkin - sleuth
- 权限认证：Spring security 
- 熔断降级：Sentinel
- 消息队列：RabbitMQ 
- 项目部署：Docker

## 组织架构

```
mall-cloud-alibaba
├─mall-common    -- 工具类及通用代码
├─mall-mbg MBG   -- 代码生成器
├─mall-security  -- Spring Security 公共配置类
├─mall-gateway   -- 网关服务 ,端口 8080 
├─mall-boot-admin -- spring boot admin 监控，端口 8095
├─mall-admin-cms -- 内容管理模块服务，端口 8085
├─mall-admin-oms -- 订单管理模块服务，端口 8084      
├─mall-admin-pms -- 商品管理模块服务，端口 8083
├─mall-admin-sms -- 营销管理模块服务，端口 8082
├─mall-admin-ums -- 会员管理模块服务，端口 8081
├─mall-storage   --  文件存储服务,端口 8086
├─mall-portal-content   --  内容模块服务,端口 8073
├─mall-portal-coupon    --  营销模块服务,端口 8074
├─mall-portal-member    --  会员模块服务,端口 8070
├─mall-portal-order     --  会员模块服务,端口 8072
└─mall-portal-product   --  商品模块服务,端口 8071
```
## Dubbo 版本

### 下载源码

```bash
# 1、克隆 mall-cloud-alibaba 项目
git clone git@github.com:mtcarpenter/mall-cloud-alibaba.git
# 2、切换dubbo 分支
git checkout dubbo

```

## mall实现的功能概览

- 商品模块  
    - 商品管理
    - 商品分类管理
    - 商品类型管理
    - 品牌管理
- 订单模块
    - 订单管理
    - 订单设置
    - 退货申请处理
    - 退货原因设置
- 营销模块
    - 秒杀活动管理
    - 优惠价管理
    - 品牌推荐管理
    - 新品推荐管理
    - 人气推荐管理
    - 专题推荐管理
    - 首页广告管理
- 用户模块
    - 用户管理
    - 角色管理
    - 菜单管理

## 架构图

![ba176adb-a207-d216-a850-0a73ae053ebd.png](http://mtcarpenter.oss-cn-beijing.aliyuncs.com/logo/ba176adb-a207-d216-a850-0a73ae053ebd.png)

## 构建与运行

### 开发环境

| 工具          | 版本号 | 下载                                                         |
| ------------- | ------ | ------------------------------------------------------------ |
| JDK           | 1.8    | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql         | 5.7    | https://www.mysql.com/                                       |
| Redis         | 5.0    | https://redis.io/download                                    |
| Zipkin        | 2.12.9 | https://zipkin.io/ |
| Elasticsearch | 6.2.2  | https://www.elastic.co/downloads                             |
| MongoDb       | 4.2.5    | https://www.mongodb.com/download-center                      |
| RabbitMq      | 3.7.14 | http://www.rabbitmq.com/download.html                        |
| nginx         | 1.10   | http://nginx.org/en/download.html                            |


###  启动先后顺序

- 启动 `mall-admin-ums`模块
- 启动 `mall-admin-pms`模块
- 启动 `mall-admin-cms`模块
- 启动 `mall-admin-sms`模块
- 启动 `mall-admin-oms`模块
- 启动 `mall-storage`模块
- 启动 `mall-gateway`模块
- 启动 `mall-boot-admin`模块


## 许可证

[Apache License 2.0](https://github.com/mtcarpenter/mall-cloud-alibaba/blob/master/LICENSE)

Copyright (c) 2018-2020 macrozheng

