package com.dellDiscount.dao;

import com.dellDiscount.model.DiscountCoupon;

public interface DiscountCouponMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DiscountCoupon record);

    int insertSelective(DiscountCoupon record);

    DiscountCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiscountCoupon record);

    int updateByPrimaryKey(DiscountCoupon record);

	DiscountCoupon findDiscount();
}