package com.shareness.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareness.dao.SiteDao;
import com.shareness.domain.Site;
import com.shareness.service.SiteService;

/**
 *@Copy Right Information  501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2015年12月28日
 */
@Transactional(rollbackFor=Exception.class)
@Service("siteService")
public class SiteServiceImpl implements SiteService{
	
	@Resource
	private SiteDao siteDao;
	
	@Override
	public Long insert(Site site) {
		return siteDao.insert(site);
	}

	@Override
	public Site queryById(Long id) {
		Site site=null;
		try {
			site=siteDao.queryById(id);
			return site;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Site> queryByPage(int page, int pageSize) {
		List<Site> siteList=new ArrayList<Site>();
		int begin=0;
		begin=pageSize*(page-1);
		try {
			siteList=siteDao.queryByPage(begin, pageSize);
			return siteList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void update(Site site) {
		siteDao.update(site);
	}

}
