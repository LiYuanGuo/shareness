package com.shareness.web.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.shareness.domain.Food;
import com.shareness.domain.Site;
import com.shareness.service.FoodService;
import com.shareness.service.SiteService;
import com.shareness.web.support.SupportAction;

/**
 *@Copy Right Information  www.501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2016年2月1日
 */
@Controller
@RequestMapping("manage")
public class ManageController extends SupportAction{
	
	@Resource
	private SiteService siteService;
	
	@Resource
	private FoodService foodService;
	
	/**
	 * 跳转到景点添加页面
	 * @return
	 */
	@RequestMapping("siteUpload")
	public String siteManage(){
		return "houtai/upload/siteupload";
	}
	
	/**
	 * 跳转到美食添加页面
	 * @return
	 */
	@RequestMapping("foodUpload")
	public String foodManage(){
		return "houtai/upload/foodupload";
	}
	
	
	/**
	 * 添加景点
	 * @param response
	 * @param site
	 */
	@RequestMapping("addSite")
	public void addSite(HttpServletResponse response,String siteStr){
		if(null!=siteStr&&""!=siteStr){
			Site site=JSONObject.parseObject(siteStr, Site.class);
			site.setAddTime(new Date());
			site.setRefreshTime(new Date());
			try {
				siteService.insert(site);
				writeMsg2(response, 1, "成功添加景点!");
			} catch (Exception e) {
				e.printStackTrace();
				writeMsg2(response, 2, "插入异常!");
			}
		}else{
			writeMsg2(response, 9, "传参异常!");
		}
	}
	
	/**
	 * 添加美食
	 * @param response
	 * @param foodStr
	 */
	@RequestMapping("addFood")
	public void addFood(HttpServletResponse response,String foodStr){
		if(null!=foodStr&&""!=foodStr){
			Food food=JSONObject.parseObject(foodStr,Food.class);
			food.setAddTime(new Date());
			food.setRefreshTime(new Date());
			try {
				foodService.insertFood(food);
				writeMsg2(response, 1, "成功添加美食!");
			} catch (Exception e) {
				e.printStackTrace();
				writeMsg2(response, 2, "插入异常");
			}
		}else{
			writeMsg2(response, 9, "传参异常!");
		}
	}
	
}
