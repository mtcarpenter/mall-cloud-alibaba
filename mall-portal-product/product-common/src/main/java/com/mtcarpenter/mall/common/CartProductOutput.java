package com.mtcarpenter.mall.common;


import lombok.Data;

import java.util.List;

/**
 * 购物车中选择规格的商品信息
 * Created by macro on 2018/8/2.
 */
@Data
public class CartProductOutput extends PmsProductOutput {
    private List<PmsProductAttributeOutput> productAttributeList;
    private List<PmsSkuStockOutput> skuStockList;

}
