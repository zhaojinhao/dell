package com.dellDiscount.model;

import java.util.List;
import java.util.Map;

import com.dellDiscount.util.CamelCaseUtils;

public class ReceiveBean {
	List<Map<String, Object>> columns;

	public List<Map<String, Object>> getColumns() {
		return columns;
	}

	public void setColumns(List<Map<String, Object>> columns) {
		this.columns = columns;
	}

	List<Map<String, Object>> order;

	public List<Map<String, Object>> getOrder() {
		return order;
	}

	public void setOrder(List<Map<String, Object>> order) {
		this.order = order;
	}

	public String getColumnsName() {
		return CamelCaseUtils.toUnderlineName(
				(String) this.columns.get(Integer.parseInt((String) this.order.get(0).get("column"))).get("data"));

	}

	public String getDir() {
		return (String) this.order.get(0).get("dir");
	}
}
