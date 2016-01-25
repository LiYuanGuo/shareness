package com.shareness.service;

import java.util.List;

import com.shareness.domain.Food;

/**
 *@Copy Right Information  www.501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2016年1月25日
 */
public interface FoodService {
	
	/**
	 * 插入美食
	 * @param food
	 * @return
	 */
	public Long insertFood(Food food);
	
	/**
	 * 通过id查询美食
	 * @param id
	 * @return
	 */
	public Food queryById(Long id);
	
	/**
	 * 分页查询美食
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<Food> queryByPage(int page,int pageSize);
	
	/**
	 * 查询指定数量的正热推荐的美食
	 * @param limitNum
	 * @return
	 */
	public List<Food> queryTopFood(int limitNum); 
	
	/**
	 * 更新美食
	 * @param food
	 */
	public Integer update(Food food);
}
