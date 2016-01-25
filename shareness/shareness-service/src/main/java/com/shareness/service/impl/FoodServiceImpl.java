package com.shareness.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareness.dao.FoodDao;
import com.shareness.domain.Food;
import com.shareness.service.FoodService;

/**
 *@Copy Right Information  www.501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2016年1月25日
 */
@Transactional(rollbackFor=Exception.class)
@Service("foodService")
public class FoodServiceImpl implements FoodService{
	
	@Resource
	private FoodDao foodDao;
	
	
	/**
	 * 保存美食
	 */
	@Override
	public Long insertFood(Food food) {
		Long foodId=null;
		try {
			foodId=foodDao.insertFood(food);
			return foodId;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 通过id查询美食
	 */
	@Override
	public Food queryById(Long id) {
		Food food=null;
		try {
			food=foodDao.queryById(id);
			return food;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 分页查询美食
	 */
	@Override
	public List<Food> queryByPage(int page, int pageSize) {
		List<Food> foodList=new ArrayList<Food>();
		Long begin=(long) (pageSize*(page-1));
		try {
			foodList=foodDao.queryByPage(begin, pageSize);
			return foodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Food> queryTopFood(int limitNum) {
		List<Food> foodList=new ArrayList<Food>();
		try {
			foodList=foodDao.queryTopFood(limitNum);
			return foodList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer update(Food food) {
		Integer flag=0;
		try {
			foodDao.update(food);
			flag=1;
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

}
