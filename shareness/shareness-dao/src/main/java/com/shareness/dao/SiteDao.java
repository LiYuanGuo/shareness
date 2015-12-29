package com.shareness.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shareness.domain.Site;

/**
 *@Copy Right Information  501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2015年12月28日
 */
public interface SiteDao {
	
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
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<Site> queryByPage(@Param(value="begin")int begin,@Param(value="pageSize")int pageSize);
	
	/**
	 * 更新景点信息
	 * @param site
	 */
	public void update(Site site);
}
