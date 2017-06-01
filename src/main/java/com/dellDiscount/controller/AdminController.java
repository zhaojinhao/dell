package com.dellDiscount.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dellDiscount.model.DiscountUser;
import com.dellDiscount.model.ReceiveBean;
import com.dellDiscount.service.DiscountUserService;
import com.dellDiscount.util.CamelCaseUtils;
import com.dellDiscount.util.ExcelUtils;

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

	@RequestMapping(value = "/discount/export")
	public String exportMatrixLeaderSheet(HttpServletResponse response, String columnName, String orderDir,
			DiscountUser discountUser) throws IOException {
		String fileName = "优惠码使用统计";

		List<Map<String, Object>> discountUsers = discountUserService.findDiscountUsers(discountUser, null, null,
				CamelCaseUtils.toUnderlineName(columnName), orderDir);
		List<Map<String, Object>> list = createExcelRecord(discountUsers);
		String columnNames[] = { "优惠码", "领取方式", "机型", "数量", "SN编码", "地区", "城市", "门店", "时间" };// 列名
		String keys[] = { "code", "codeType", "type", "num", "sn", "area", "city", "stores", "createdTime" };// map中的key
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtils.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}

	private List<Map<String, Object>> createExcelRecord(List<Map<String, Object>> projects) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Map<String, Object> project = null;
		for (int j = 0; j < projects.size(); j++) {
			// "code", "codeType", "type", "num", "sn", "area", "city",
			// "stores", "createdTime"
			project = projects.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("code", project.get("code"));
			mapValue.put("type", project.get("type"));
			mapValue.put("num", project.get("num"));
			mapValue.put("sn", project.get("sn"));
			mapValue.put("area", project.get("area"));
			mapValue.put("city", project.get("city"));
			mapValue.put("stores", project.get("stores"));
			mapValue.put("createdTime", project.get("createdTime"));
			String codeType = "";
			if (project.get("codeType") != null) {
				if (project.get("codeType").equals(0)) {
					codeType = "网址领取";
				}
				if (project.get("codeType").equals(1)) {
					codeType = "二维码领取";
				}
			}
			mapValue.put("codeType", codeType);
			listmap.add(mapValue);
		}
		return listmap;
	}
}
