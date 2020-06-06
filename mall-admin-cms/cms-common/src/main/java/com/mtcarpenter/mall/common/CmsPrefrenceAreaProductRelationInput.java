package com.mtcarpenter.mall.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@Setter
@Getter
public class CmsPrefrenceAreaProductRelationInput implements Serializable {
    private static final long serialVersionUID = -8635290899991174718L;
    private Long id;

    private Long prefrenceAreaId;

    private Long productId;
}
