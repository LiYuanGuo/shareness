package com.shareness.dao.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页模型
 */
public class PageModel<T> {
	/**
	 * 当前页数
	 */
	private int page = 1;
	/**
	 * 每页显示的记录数
	 */
	private int rows = 10;
	/**
	 * 总记录数
	 */
	private long totalRecord;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 对应的当前页记录
	 */
	private List<T> results;
	/**
	 * 其他的参数我们把它分装成为Map对象
	 */
	private Map<String, Object> params = new HashMap<String, Object>();
	
	public void addParams(String key,Object value){
		this.params.put(key, value);
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
		this.setTotalPage((int)((totalRecord%rows)==0?(totalRecord/rows):(totalRecord/rows)+1));
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [page=").append(page).append(",").append("rows=").append(rows).append(",");
		builder.append("params=").append(params).append("results=").append(results).append(",");
		builder.append("totalPage=").append(totalPage).append(",totalRecord=").append(totalRecord).append("]");
		return builder.toString();
	}
}
