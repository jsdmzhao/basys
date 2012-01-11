package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Skxx;
import com.aisino2.icksystem.domain.Ycskqy;
import com.aisino2.icksystem.service.IYcskqyService;
import com.aisino2.sysadmin.domain.Globalpar;

public class YcskqyAction extends PageAction{
	private IYcskqyService ycskqyService;
	private String tabledata;
	private int totalrows;
	private String result="";
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

	public void setYcskqyService(IYcskqyService ycskqyService) {
		this.ycskqyService = ycskqyService;
	}

	public void setTabledata(List lData,Ycskqy setYcskqy) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qybm");
		if("1".equals(setYcskqy.getGxdwbz())){
			lPro.add("gxdwmc");
		} else if("1".equals(setYcskqy.getFxjbz())){
			lPro.add("fxjmc");
		} else if("1".equals(setYcskqy.getDsjgbz())){
			lPro.add("dsjgmc");
		}
		
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("yyztmc");
		lPro.add("dwfzr");
		lPro.add("dwfzrlxfs");
		
    	List lModify=new ArrayList();
    	lModify.add("setSkxx");
    	lModify.add("刷卡信息");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	Ycskqy getYcskqy = new Ycskqy();
        this.setData(getYcskqy,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataSkxx(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("cyrybh");
		lPro.add("sksj");
		lPro.add("scsj");
		
    	List lCol=new ArrayList();
    	Skxx getSkxx = new Skxx();
        this.setData(getSkxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public String querylist() throws Exception{
		try {
			Ycskqy setYcskqy = new Ycskqy();
			setYcskqy = (Ycskqy)this.setClass(setYcskqy, null);
			Map map = new HashMap();
			map.put("dsjgdm", setYcskqy.getDsjgdm());
			map.put("fxjdm", setYcskqy.getFxjdm());
			map.put("gxdwdm", setYcskqy.getGxdwdm());
			map.put("qssj", setYcskqy.getQssj());
			map.put("jzsj", setYcskqy.getJzsj());
			
	        Page page = ycskqyService.getYcskqy(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledata(page.getData(),setYcskqy); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
    }
	public String querylistExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Ycskqy setYcskqy = new Ycskqy();
			setYcskqy = (Ycskqy)this.setClass(setYcskqy, null);
			Map map = new HashMap();
			map.put("dsjgdm", setYcskqy.getDsjgdm());
			map.put("fxjdm", setYcskqy.getFxjdm());
			map.put("gxdwdm", setYcskqy.getGxdwdm());
			map.put("qssj", setYcskqy.getQssj());
			map.put("jzsj", setYcskqy.getJzsj());
			Page page = ycskqyService.getYcskqy(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("ycskqyList", page.getData());
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	public void querylistExcel() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Ycskqy setYcskqy = new Ycskqy();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("ycskqyList"));
			lResult.add(setYcskqy);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	/**
	 * 刷卡信息 请求列表
	 * @return
	 * @throws Exception
	 */
	public String querylistSkxx() throws Exception{
		try {
			Ycskqy setYcskqy = new Ycskqy();
			setYcskqy = (Ycskqy)this.setClass(setYcskqy, null);
			Map map = new HashMap();
			map.put("qssj", setYcskqy.getQssj());
			map.put("jzsj", setYcskqy.getJzsj());
			map.put("qybm", setYcskqy.getQybm());
			
	        Page page = ycskqyService.getSkxx(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataSkxx(page.getData());
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
    }
}