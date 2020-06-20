package com.mtcarpenter.mall.domain;


import com.mtcarpenter.mall.model.PmsProductAttribute;
import com.mtcarpenter.mall.model.PmsProduct;
import com.mtcarpenter.mall.model.PmsSkuStock;
import lombok.Data;

import java.util.List;

/**
 * 购物车中选择规格的商品信息
 * Created by macro on 2018/8/2.
 */
@Data
public class CartProduct extends PmsProduct {
    private List<PmsProductAttribute> productAttributeList;
    private List<PmsSkuStock> skuStockList;

}
