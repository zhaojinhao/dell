package com.dellDiscount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dellDiscount.dao.CouponMapper;
import com.dellDiscount.model.Coupon;

@Service
public class CouponService {
	@Autowired
	private CouponMapper couponMapper;

	public Coupon findByCode(String code) {
		return couponMapper.findByCode(code);
	}
	
}
