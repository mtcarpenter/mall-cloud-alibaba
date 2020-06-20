package com.mtcarpenter.mall.portal.service;

import com.mtcarpenter.mall.common.UmsIntegrationConsumeSettingOutput;
import com.mtcarpenter.mall.portal.domain.MemberProductCollection;
import org.springframework.data.domain.Page;

/**
 * 会员收藏Service
 * Created by macro on 2018/8/2.
 */
public interface MemberCollectionService {
    int add(MemberProductCollection productCollection);

    int delete(Long productId);

    Page<MemberProductCollection> list(Integer pageNum, Integer pageSize);

    /**
     * 获取积分规则
     *
     * @param id
     * @return
     */
    UmsIntegrationConsumeSettingOutput integrationConsumeSetting(Long id);
}
