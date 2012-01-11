package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Asjtj;
import com.aisino2.basicsystem.service.IAsjtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Globalpar;

public class AsjtjAction extends PageAction{
	private IAsjtjService asjtjService;
	private List lAsjtj=new ArrayList();
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
	
	public void setAsjtjService(IAsjtjService asjtjService) {
		this.asjtjService = asjtjService;
	}

	public void setTabledata(List lData,Asjtj getAsjtj) throws Exception{
		List lPro=new ArrayList();
		
		lPro.add("qybm");
		if("1".equals(getAsjtj.getCsbz())){
			lPro.add("qybm");
			lPro.add("qymc");
		} else if("1".equals(getAsjtj.getGxdwbz())){
			lPro.add("gxdwmc");
		} else if("1".equals(getAsjtj.getFxjbz())){
			lPro.add("fxjmc");
		} else if("1".equals(getAsjtj.getDsjgbz())){
			lPro.add("dsjgmc");
		}
		lPro.add("fazsT");
		lPro.add("zzajsT");
		lPro.add("xsajsT");
		lPro.add("fazs");
		lPro.add("zzajs");
		lPro.add("xsajs");
    	
    	List lCol=new ArrayList();
    	Asjtj setAsjtj = new Asjtj();
        this.setData(setAsjtj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			int fazsT = 0;
			int zzajsT = 0;
			int xsajsT = 0;
			int fazs = 0;
			int zzajs = 0;
			int xsajs = 0;
			Asjtj sumAsjtj = new Asjtj();
			Asjtj setAsjtj = new Asjtj();
			setAsjtj = (Asjtj)this.setClass(setAsjtj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setAsjtj.getDsjgbz());
			map.put("fxjbz", setAsjtj.getFxjbz());
			map.put("gxdwbz", setAsjtj.getGxdwbz());
			map.put("csbz", setAsjtj.getCsbz());
			map.put("dsjgdm", setAsjtj.getDsjgdm());
			map.put("fxjdm", setAsjtj.getFxjdm());
			map.put("gxdwdm", setAsjtj.getGxdwdm());
			map.put("qybm", setAsjtj.getCsbm());
			map.put("qsrq", setAsjtj.getQssj());
			map.put("jzrq", setAsjtj.getJzsj());
			map.put("hylbdm", setAsjtj.getHylbdm());
			
	        Page page = asjtjService.getAsjtjList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lAsjtj=page.getData();
	        for(java.util.Iterator iter = lAsjtj.iterator(); iter.hasNext();){
	        	Asjtj oneAsjtj = (Asjtj)iter.next();
	        	fazsT += oneAsjtj.getFazsT().intValue();
	        	zzajsT += oneAsjtj.getZzajsT().intValue();
	        	xsajsT += oneAsjtj.getXsajsT().intValue();
	        	fazs += oneAsjtj.getFazs().intValue();
	        	zzajs += oneAsjtj.getZzajs().intValue();
	        	xsajs += oneAsjtj.getXsajs().intValue();
	        }
	        sumAsjtj.setFazsT(fazsT);
	        sumAsjtj.setZzajsT(zzajsT);
	        sumAsjtj.setXsajsT(xsajsT);
	        sumAsjtj.setFazs(fazs);
	        sumAsjtj.setZzajs(zzajs);
	        sumAsjtj.setXsajs(xsajs);
	        sumAsjtj.setDsjgmc("总计");
	        if("1".equals(setAsjtj.getDsjgbz())){
	            lAsjtj.add(sumAsjtj);
	        }
	        
	        //setTabledata(page.getData(),setAsjtj); 
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
			
			Asjtj setAsjtj = new Asjtj();
			setAsjtj = (Asjtj)this.setClass(setAsjtj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setAsjtj.getDsjgbz());
			map.put("fxjbz", setAsjtj.getFxjbz());
			map.put("gxdwbz", setAsjtj.getGxdwbz());
			map.put("csbz", setAsjtj.getCsbz());
			map.put("dsjgdm", setAsjtj.getDsjgdm());
			map.put("fxjdm", setAsjtj.getFxjdm());
			map.put("gxdwdm", setAsjtj.getGxdwdm());
			map.put("qybm", setAsjtj.getCsbm());
			map.put("qssj", setAsjtj.getQssj());
			map.put("jzsj", setAsjtj.getJzsj());
			map.put("hylbdm", setAsjtj.getHylbdm());
			Page page = asjtjService.getAsjtjList(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("asjtjList", page.getData());
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
			Asjtj setAsjtj = new Asjtj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("asjtjList"));
			lResult.add(setAsjtj);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }

	public List getLAsjtj() {
		return lAsjtj;
	}
}