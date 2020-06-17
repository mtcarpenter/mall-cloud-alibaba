package com.mtcarpenter.mall.common;

import lombok.Data;

import java.util.List;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@Data
public class PromotionProductOutput extends PmsProductOutput {
    //商品库存信息
    private List<PmsSkuStockOutput> skuStockList;
    //商品打折信息
    private List<PmsProductLadderOutput> productLadderList;
    //商品满减信息
    private List<PmsProductFullReductionOutput> productFullReductionList;
}
