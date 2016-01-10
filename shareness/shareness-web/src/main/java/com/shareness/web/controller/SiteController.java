package com.shareness.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.shareness.domain.Site;
import com.shareness.service.SiteService;
import com.shareness.web.support.SupportAction;

/**
 *@Copy Right Information  501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2015年12月28日
 */
@Controller
@RequestMapping("site")
public class SiteController extends SupportAction{
	
	@Resource
	private SiteService siteService;
	
	/**
	 * 景点详情
	 * @param response
	 * @param siteId
	 */
	@RequestMapping("siteDetail")
	public void siteDetail(HttpServletResponse response,Long siteId){
		Site site=null;
		site=siteService.queryById(siteId);
		if(site==null){
			writeMsg2(response, 9,"查询异常");
		}else{
			String siteStr=JSONObject.toJSONString(site);
			writeInfo(response, siteStr);
		}
	}
	
	/**
	 * 查询指定数量的正热推荐的景点
	 * @param response
	 */
	@RequestMapping("topSite")
	public void topSite(HttpServletResponse response){
		List<Site> siteList=new ArrayList<Site>();
		siteList=siteService.queryTopSite(4);
		if(siteList==null){
			writeMsg2(response, 9, "查询出现异常!");
		}else{
			String siteListStr=JSONObject.toJSONString(siteList);
			writeInfo(response, siteListStr);
		}
	}
}
