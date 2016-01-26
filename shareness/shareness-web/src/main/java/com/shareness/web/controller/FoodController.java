package com.shareness.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.shareness.domain.Food;
import com.shareness.service.FoodService;
import com.shareness.web.support.SupportAction;

/**
 *@Copy Right Information  www.501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2016年1月26日
 */
@Controller
@RequestMapping("food")
public class FoodController  extends SupportAction{
	
	@Resource
	private FoodService foodService;
	
	/**
	 * 获取当前热点美食
	 * @param response
	 */
	@RequestMapping("topFood")
	public void topFood(HttpServletResponse response){
		List<Food> foodList=new ArrayList<Food>();
		foodList=foodService.queryTopFood(4);
		if(foodList==null){
			writeMsg2(response, 9, "查询出现异常!");
		}else{
			String foodListStr=JSONObject.toJSONString(foodList);
			writeInfo(response, foodListStr);
		}
	}
	
	/**
	 * 获取指定id的美食详情
	 * @param response
	 * @param foodId
	 */
	@RequestMapping("foodDetail")
	public void foodDetail(HttpServletResponse response,Long foodId){
		Food food=null;
		food=foodService.queryById(foodId);
		if(food==null){
			writeMsg2(response, 9, "查询出现异常!");
		}else{
			String foodStr=JSONObject.toJSONString(food);
			writeInfo(response, foodStr);
		}
	}
	
}
