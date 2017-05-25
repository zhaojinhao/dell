package com.dellDiscount.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellDiscount.dao.CouponMapper;
import com.dellDiscount.dao.DiscountUserMapper;
import com.dellDiscount.model.DiscountUser;

@Service
public class DiscountUserService {
	@Autowired
	private DiscountUserMapper discountUserMapper;
	@Autowired
	private CouponMapper couponMapper;

	public DiscountUser insert(DiscountUser discountUser) {
		if(discountUser.getDiscountId()!=null){
			DiscountUser discount = discountUserMapper.findByDiscountId(discountUser.getDiscountId());
			if (discount != null) {// 判断该优惠码信息是否已经保存
				return discount;
			}
		}
		if (discountUserMapper.insertSelective(discountUser) == 1) {
			return discountUserMapper.selectByPrimaryKey(discountUser.getId());
		}
		return null;
	}

	@Transactional
	public boolean update(DiscountUser discountUser) {
		if (discountUserMapper.updateByPrimaryKeySelective(discountUser) == 1) {
			couponMapper.updateMakeUseByDiscountId(discountUser.getDiscountId());
			return true;
		}
		// 更新数据失败，删除原有数据从新操作
		discountUserMapper.deleteByPrimaryKey(discountUser.getId());
		return false;
	}

	public List<Map<String, Object>> findDiscountUsers(DiscountUser discountUser, Integer start, Integer length, String columnsName,
			String dir) {
		return discountUserMapper.findDiscountUsers(discountUser, start, length, columnsName, dir);
	}

	public int queryDataCount(DiscountUser discountUser) {
		return discountUserMapper.queryDataCount(discountUser);
	}
}
