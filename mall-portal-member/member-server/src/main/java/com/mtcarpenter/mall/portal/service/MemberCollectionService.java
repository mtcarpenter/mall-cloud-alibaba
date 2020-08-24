package com.mtcarpenter.mall.portal.service;

import com.mtcarpenter.mall.model.UmsIntegrationConsumeSetting;
import com.mtcarpenter.mall.portal.domain.MemberProductCollection;
import org.springframework.data.domain.Page;

/**
 * 会员商品收藏管理Service
 * Created by macro on 2018/8/2.
 */
public interface MemberCollectionService {
    /**
     * 添加收藏
     *
     * @param productCollection
     * @return
     */
    int add(MemberProductCollection productCollection);

    /**
     * 删除收藏
     *
     * @param productId
     * @return
     */
    int delete(Long productId);

    /**
     * 分页查询收藏
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<MemberProductCollection> list(Integer pageNum, Integer pageSize);

    /**
     * 获取积分规则
     *
     * @param id
     * @return
     */
    UmsIntegrationConsumeSetting integrationConsumeSetting(Long id);

    /**
     * 显示收藏商品详情
     *
     * @param productId
     * @return
     */
    MemberProductCollection detail(Long productId);

    /**
     * 清空收藏列表
     */
    void clear();

}
