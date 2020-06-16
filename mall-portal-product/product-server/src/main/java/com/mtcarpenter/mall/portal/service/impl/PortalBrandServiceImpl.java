package com.mtcarpenter.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.mtcarpenter.mall.common.api.CommonPage;
import com.mtcarpenter.mall.mapper.PmsBrandMapper;
import com.mtcarpenter.mall.mapper.PmsProductMapper;
import com.mtcarpenter.mall.model.PmsBrand;
import com.mtcarpenter.mall.model.PmsProduct;
import com.mtcarpenter.mall.model.PmsProductExample;
import com.mtcarpenter.mall.portal.dao.HomeDao;
import com.mtcarpenter.mall.portal.service.PortalBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 前台品牌管理Service实现类
 * Created by macro on 2020/5/15.
 */
@Service
public class PortalBrandServiceImpl implements PortalBrandService {
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public List<PmsBrand> recommendList(Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return homeDao.getRecommendBrandList(offset, pageSize);
    }

    @Override
    public PmsBrand detail(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andBrandIdEqualTo(brandId);
        List<PmsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }
}
