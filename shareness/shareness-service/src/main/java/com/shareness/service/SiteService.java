package com.shareness.service;

import java.util.List;

import com.shareness.domain.Site;

/**
 *@Copy Right Information  501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2015年12月28日
 */
public interface SiteService {
	/**
	 * 新增景点
	 * @param site
	 * @return
	 */
	public Long insert(Site site);
	
	/**
	 * 查询指定景点
	 * @param id
	 * @return
	 */
	public Site queryById(Long id);
	
	/**
	 * 分页查询
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Site> queryByPage(int page,int pageSize);
	
	/**
	 * 查询指定数量的正热推荐的景点
	 * @param num
	 * @return
	 */
	public List<Site> queryTopSite(int num);
	
	/**
	 * 更新景点信息
	 * @param site
	 */
	public void update(Site site);
}
