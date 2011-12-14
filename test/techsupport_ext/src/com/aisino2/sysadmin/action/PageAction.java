package com.aisino2.sysadmin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class PageAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 442165876833019790L;
	public String dir;
	public String sort;
	public Integer start;
	public Integer limit;
	public Integer pageNo;
	public Integer pageSize;
	public Integer total;
	
	public HttpServletRequest request;
	public HttpServletResponse response;
	public String returnMessage;
	public Integer returnNo;
	public String returnMessageDebug;
	
	@JSON(serialize=true)
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	@JSON(serialize=true)
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
		
	}
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}
	@JSON(serialize=true)
	public String getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@JSON(serialize=true)
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@JSON(serialize=true)
	public Integer getReturnNo() {
		return returnNo;
	}
	public void setReturnNo(Integer returnNo) {
		this.returnNo = returnNo;
	}
	@JSON(serialize=true)
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	@JSON(serialize=true)
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getReturnMessageDebug() {
		return returnMessageDebug;
	}
	public void setReturnMessageDebug(String returnMessageDebug) {
		this.returnMessageDebug = returnMessageDebug;
	}
	
	
	
}
