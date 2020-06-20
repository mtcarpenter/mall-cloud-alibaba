package com.mtcarpenter.mall.portal.dao;


import com.mtcarpenter.mall.domain.SmsCouponHistoryDetail;
import com.mtcarpenter.mall.model.SmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员优惠券领取历史自定义Dao
 * Created by macro on 2018/8/29.
 */
public interface SmsCouponHistoryDao {
    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);

    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId,@Param("productCategoryId") Long productCategoryId);
}
