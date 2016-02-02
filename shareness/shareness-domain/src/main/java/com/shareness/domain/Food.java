package com.shareness.domain;

import java.util.Date;

/**
 *@Copy Right Information  www.501314.love
 *@version  1.0
 *@author  liyuanguo
 *@date 2016年1月25日
 */

public class Food {

	private Long id;
	private String image;//图片
	private String name;//名称
	private String briefContent;//好吃的地方简介
	private String detailContent;//美食店详细简介
	private String consumption;//消费情况
	private String address;//地址
	private String route;//路线
	private String traffic;//交通方式
	private String tip;//建议
	private Date addTime;//添加时间
	private Date refreshTime;//修改时间
	
	/**
	 * @return the addTime
	 */
	public Date getAddTime() {
		return addTime;
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
	 * @param addTime the addTime to set
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
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
	 * @return the consumption
	 */
	public String getConsumption() {
		return consumption;
	}
	/**
	 * @param consumption the consumption to set
	 */
	public void setConsumption(String consumption) {
		this.consumption = consumption;
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
	public String getTraffic() {
		return traffic;
	}
	/**
	 * @param traffic the traffic to set
	 */
	public void setTraffic(String traffic) {
		this.traffic = traffic;
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
	
}
