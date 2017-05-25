package com.dellDiscount.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dellDiscount.model.DiscountUser;

public interface DiscountUserMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(DiscountUser record);

	int insertSelective(DiscountUser record);

	DiscountUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(DiscountUser record);

	int updateByPrimaryKey(DiscountUser record);

	DiscountUser findByDiscountId(Integer discountId);

	List<Map<String, Object>> findDiscountUsers(@Param("discountUser") DiscountUser discountUser, @Param("start") Integer start,
			@Param("length") Integer length, @Param("columnsName") String columnsName, @Param("dir") String dir);

	int queryDataCount(@Param("discountUser") DiscountUser discountUser);
}