package com.shareness.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.shareness.domain.Site;
import com.shareness.service.SiteService;
import com.shareness.web.support.SupportAction;

/**
 *@Copy Right Information  501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2015年12月23日
 */
@Controller
@RequestMapping("main")
public class MainController extends SupportAction{
	
	@Resource
	private SiteService siteService;
	
	/**
	 * 访问首页
	 * @return
	 */
	@RequestMapping("index")
	public String sharenessMain(){
		return "main/index";
	}
	
	/**
	 * 初始化主页数据
	 * @param response
	 * @param page
	 */
	@RequestMapping("initMain")
	public void queryByPage(HttpServletResponse response){
		List<Site> siteList=new ArrayList<Site>();
		siteList=siteService.queryTopSite(4);
		if(siteList!=null){
			String siteListJson=JSONObject.toJSONString(siteList);
			writeInfo(response, siteListJson);
		}
	}
	
	/**
	 * 景点详情跳转
	 * @param model
	 * @param siteId
	 * @return
	 */
	@RequestMapping("siteDetail")
	public String siteDetail(Model model,Long siteId){
		model.addAttribute("siteId", siteId);
		return "site/siteDetail";
	}
	
	/**
	 * 美食详情跳转
	 * @param model
	 * @param foodId
	 * @return
	 */
	@RequestMapping("foodDetail")
	public String foodDetail(Model model,Long foodId){
		model.addAttribute("foodId", foodId);
		return "food/foodDetail";
	}
	
}
