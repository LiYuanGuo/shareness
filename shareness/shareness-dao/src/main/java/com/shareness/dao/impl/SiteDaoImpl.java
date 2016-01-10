package com.shareness.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shareness.dao.SiteDao;
import com.shareness.dao.util.MyBatisSupport;
import com.shareness.domain.Site;

/**
 *@Copy Right Information  501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2015年12月28日
 */
@Repository("siteDao")
public class SiteDaoImpl extends MyBatisSupport<SiteDao, SiteDao> implements SiteDao{

	@Override
	public Long insert(Site site) {
		return getMapper().insert(site);
	}

	@Override
	public Site queryById(Long id) {
		return getMapper().queryById(id);
	}

	@Override
	public List<Site> queryByPage(int begin, int pageSize) {
		return getMapper().queryByPage(begin, pageSize);
	}

	@Override
	public void update(Site site) {
		getMapper().update(site);
	}

	@Override
	public List<Site> queryTopSite(int limitNum) {
		return getMapper().queryTopSite(limitNum);
	}

}
