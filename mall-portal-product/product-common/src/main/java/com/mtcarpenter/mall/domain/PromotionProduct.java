package com.mtcarpenter.mall.domain;


import com.mtcarpenter.mall.model.PmsProduct;
import com.mtcarpenter.mall.model.PmsProductFullReduction;
import com.mtcarpenter.mall.model.PmsProductLadder;
import com.mtcarpenter.mall.model.PmsSkuStock;
import lombok.Data;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@Data
public class PromotionProduct extends PmsProduct {
    //商品库存信息
    private List<PmsSkuStock> skuStockList;
    //商品打折信息
    private List<PmsProductLadder> productLadderList;
    //商品满减信息
    private List<PmsProductFullReduction> productFullReductionList;
}
