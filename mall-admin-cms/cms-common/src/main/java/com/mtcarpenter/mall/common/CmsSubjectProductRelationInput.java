package com.mtcarpenter.mall.common;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author mtcarpenter
 * @github https://github.com/mtcarpenter/mall-cloud-alibaba
 * @desc 微信公众号：山间木匠
 */
@Getter
@Setter
public class CmsSubjectProductRelationInput implements Serializable {

    private static final long serialVersionUID = -4079484815593829058L;
    private Long id;

    private Long subjectId;

    private Long productId;


}
