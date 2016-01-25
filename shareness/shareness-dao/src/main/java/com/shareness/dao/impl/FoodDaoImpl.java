package com.shareness.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shareness.dao.FoodDao;
import com.shareness.dao.util.MyBatisSupport;
import com.shareness.domain.Food;

/**
 *@Copy Right Information  www.501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2016年1月25日
 */
@Repository("foodDao")
public class FoodDaoImpl extends MyBatisSupport<FoodDao,FoodDao> implements  FoodDao{

	@Override
	public Long insertFood(Food food) {
		return getMapper().insertFood(food);
	}

	@Override
	public Food queryById(Long id) {
		return getMapper().queryById(id);
	}

	@Override
	public List<Food> queryByPage(Long begin, int pageSize) {
		return getMapper().queryByPage(begin, pageSize);
	}

	@Override
	public List<Food> queryTopFood(int limitNum) {
		return getMapper().queryTopFood(limitNum);
	}

	@Override
	public void update(Food food) {
		getMapper().update(food);
	}

}
