package com.dellDiscount.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dellDiscount.model.DiscountUser;
import com.dellDiscount.model.ReceiveBean;
import com.dellDiscount.service.DiscountUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DiscountUserService discountUserService;

	@RequestMapping("")
	public String admin() {
		return "/admin/index";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "/admin/welcome";
	}

	@RequestMapping("/discount")
	public String index() {
		return "/admin/discount";
	}

	/**
	 * 消息数据列表
	 */
	@RequestMapping("/discount/data")
	@ResponseBody
	public Map<String, Object> data(DiscountUser discountUser, Integer start, Integer length, ReceiveBean order,
			Integer draw) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> discountUsers = discountUserService.findDiscountUsers(discountUser, start, length,
				order.getColumnsName(), order.getDir());
		int count = discountUserService.queryDataCount(discountUser);
		map.put("data", discountUsers);
		map.put("recordsFiltered", count); // 总条数
		map.put("draw", draw);
		map.put("recordsTotal", length);
		return map;
	}
}
