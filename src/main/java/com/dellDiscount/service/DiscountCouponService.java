package com.dellDiscount.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellDiscount.dao.CouponMapper;
import com.dellDiscount.dao.DiscountCouponMapper;
import com.dellDiscount.model.Coupon;
import com.dellDiscount.model.DiscountCoupon;
import com.dellDiscount.util.StrUtil;

@Service
public class DiscountCouponService {
	@Autowired
	private DiscountCouponMapper discountCouponMapper;
	@Autowired
	private CouponMapper couponMapper;
	/**
	 * 抓取优惠码
	 * @param type  0 网址领取  1二维码领取
	 * @return
	 */
	@Transactional
	public DiscountCoupon findByCode(Integer type) {
		DiscountCoupon discount = discountCouponMapper.findDiscount();
		if(discount != null){
			if(discountCouponMapper.deleteByPrimaryKey(discount.getId())==1){
				Coupon c = new Coupon();
				c.setCode(discount.getCode());
				c.setMakeUse(0);
				c.setType(type);
				c.setCreatedTime(new Date());
				couponMapper.insert(c);
			}
		}
		return discount;
	}
	
	public void insertCoupnt(){
		for(int i=0; i<500;i++){
			String str = StrUtil.randomString(8);
			if(discountCouponMapper.find(str)==null){
				DiscountCoupon coupon = new DiscountCoupon();
				coupon.setCode(str);
				discountCouponMapper.insertSelective(coupon);
			}
		}
	}
	
	
}
