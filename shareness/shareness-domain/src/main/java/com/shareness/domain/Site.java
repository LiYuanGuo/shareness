package com.shareness.domain;

import java.util.Date;

/**
 *@Copy Right Information  501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2015年12月24日
 *
 *景点
 */
public class Site {
	private Long id;
	private String name;//景点名称
	private String image;//景点图片
	private String briefContent;//景点简介
	private String detailContent;//景点详细介绍
	private String ticket;//门票介绍
	private String address;//景点地址
	private String route;//线路
	private Integer traffic;//交通方式
	private String playMode;//游玩方式
	private String tip;//温馨提示
	private String shisu;//宿食问题
	private Date addTime;//添加时间
	private Date refreshTime;//修改时间
	
	/**
	 * @return the addTime
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * @param addTime the addTime to set
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * @return the refreshTime
	 */
	public Date getRefreshTime() {
		return refreshTime;
	}
	/**
	 * @param refreshTime the refreshTime to set
	 */
	public void setRefreshTime(Date refreshTime) {
		this.refreshTime = refreshTime;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the briefContent
	 */
	public String getBriefContent() {
		return briefContent;
	}
	/**
	 * @param briefContent the briefContent to set
	 */
	public void setBriefContent(String briefContent) {
		this.briefContent = briefContent;
	}
	/**
	 * @return the detailContent
	 */
	public String getDetailContent() {
		return detailContent;
	}
	/**
	 * @param detailContent the detailContent to set
	 */
	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}
	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}
	/**
	 * @param route the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	/**
	 * @return the traffic
	 */
	public Integer getTraffic() {
		return traffic;
	}
	/**
	 * @param traffic the traffic to set
	 */
	public void setTraffic(Integer traffic) {
		this.traffic = traffic;
	}
	/**
	 * @return the playMode
	 */
	public String getPlayMode() {
		return playMode;
	}
	/**
	 * @param playMode the playMode to set
	 */
	public void setPlayMode(String playMode) {
		this.playMode = playMode;
	}
	/**
	 * @return the tip
	 */
	public String getTip() {
		return tip;
	}
	/**
	 * @param tip the tip to set
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}
	/**
	 * @return the shisu
	 */
	public String getShisu() {
		return shisu;
	}
	/**
	 * @param shisu the shisu to set
	 */
	public void setShisu(String shisu) {
		this.shisu = shisu;
	}
	
}
