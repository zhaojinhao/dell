package com.dellDiscount.dao;

import com.dellDiscount.model.Coupon;

public interface CouponMapper{

    int deleteByPrimaryKey(Integer id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);

	Coupon findByCode(String code);

	void updateMakeUseByDiscountId(Integer id);

}