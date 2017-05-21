package com.dellDiscount.util;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

	public static String success() {
		return success(null);
	}

	public static String success(Object detail) {
		Result result = new Result();
		result.setCode(200);
		result.setDescription("操作成功!");
		result.setDetail(detail);
		return JSON.toJSONString(result);

	}

	public static String error() {
		return error(null);
	}

	public static String error(String description) {
		Result result = new Result();
		result.setCode(201);
		result.setDescription(description);
		result.setDetail(null);
		return JSON.toJSONString(result);
	}

	public static String overdue() {
		Result result = new Result();
		result.setCode(202);
		result.setDescription("");
		result.setDetail(null);
		return JSON.toJSONString(result);
	}

	public static String toLogin() {
		Result result = new Result();
		result.setCode(205);
		result.setDescription(null);
		result.setDetail(null);
		return JSON.toJSONString(result);
	}
	
	public static String emailRegistSuccess() {
		Result result = new Result();
		result.setCode(300);
		result.setDescription(null);
		result.setDetail(null);
		return JSON.toJSONString(result);
	}
}
