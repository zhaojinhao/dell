package com.dellDiscount.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dellDiscount.model.Coupon;
import com.dellDiscount.model.DiscountUser;
import com.dellDiscount.service.CouponService;
import com.dellDiscount.service.DiscountUserService;
import com.dellDiscount.util.JsonUtil;
import com.dellDiscount.util.StrKit;

@Controller
@RequestMapping("/coupon")
public class CouponController {
	@Autowired
	private CouponService couponService;
	@Autowired
	private DiscountUserService discountUserService;

	@RequestMapping("/getCode/{code}")
	public String getCode(@PathVariable String code, Model model) {
		Coupon coupon = couponService.findByCode(code);
		if (coupon == null) {
			return "used";
		}
		model.addAttribute("coupon", coupon);
		return "code";
	}

	@RequestMapping("/step1")
	public String step1() {
		return "step1";
	}

	@RequestMapping("/checkDiscount")
	@ResponseBody
	public String checkDiscount(String code) {
		Coupon coupon = couponService.findByCode(code);
		if (coupon == null)
			return JsonUtil.error("优惠码不可使用");
		return JsonUtil.success();
	}

	@RequestMapping("/step1Do")
	public String step1Do(DiscountUser discountUser, Model model) {
		if(StrKit.notBlank(discountUser.getCode())){
			Coupon coupon = couponService.findByCode(discountUser.getCode());
			if (coupon == null)
				return "step1";
			discountUser.setDiscountId(coupon.getId());
		}
		model.addAttribute("discountUser", discountUser);
		return "step2";
	}

	@RequestMapping("/step2Do")
	public String step2Do(DiscountUser discountUser) {
		discountUser.setCreatedTime(new Date());
		DiscountUser discount = discountUserService.insert(discountUser);
		if (discount == null)
			return "step1";
		/*if (discountUserService.update(discountUser))
			return "step1";*/
		return "systemError";
	}

}
