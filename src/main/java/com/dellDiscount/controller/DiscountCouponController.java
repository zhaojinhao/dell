package com.dellDiscount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dellDiscount.model.DiscountCoupon;
import com.dellDiscount.service.DiscountCouponService;

@Controller
public class DiscountCouponController {
	@Autowired
	private DiscountCouponService discountCouponService;

	/**
	 * 二维码领取
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String getCoupon(Model model) {
		DiscountCoupon coupon = discountCouponService.findByCode(1);
		if (coupon == null) {
			return "over";
		}
		model.addAttribute("coupon", coupon);
		return "gift";
	}
	
	@RequestMapping("/getCouponByPc")
	public String getCouponByPc(Model model) {
		DiscountCoupon coupon = discountCouponService.findByCode(0);
		if (coupon == null) {
			return "over";
		}
		model.addAttribute("coupon", coupon);
		return "gift";
	}
	
	@RequestMapping("/addCoupntD")
	public void insertCoupnt(){
		discountCouponService.insertCoupnt();
	}

}
