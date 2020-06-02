package com.mtcarpenter.mall.service;

import com.mtcarpenter.mall.model.OmsCompanyAddress;

import java.util.List;

/**
 * 收货地址管Service
 * Created by macro on 2018/10/18.
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OmsCompanyAddress> list();
}
