package com.aisino2.publicsystem.action;

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
import com.aisino2.publicsystem.domain.Qyryxxtj;
import com.aisino2.publicsystem.domain.Qysctj;
import com.aisino2.publicsystem.service.IQyryxxtjService;
import com.aisino2.sysadmin.domain.Globalpar;

public class QyryxxtjAction extends PageAction{
	private IQyryxxtjService qyryxxtjService;
	private List lQyryxxtj=new ArrayList();
	private Qyryxxtj qyryxxtj=new Qyryxxtj();
	private String tabledata="";
	private int totalrows=0;
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

	public Qyryxxtj getQyryxxtj() {
		return qyryxxtj;
	}
	
	public List getLQyryxxtj() {
		return lQyryxxtj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyryxxtjService(IQyryxxtjService qyryxxtjService) {
		this.qyryxxtjService = qyryxxtjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyryxxtj");
		lPro.add("hylbdm");
		lPro.add("hylb");
		lPro.add("dsjgdm");
		lPro.add("dsjgmc");
		lPro.add("fxjdm");
		lPro.add("fxjmc");
		lPro.add("gxdwdm");
		lPro.add("gxdwmc");
		lPro.add("qymc");
		lPro.add("qybm");
		lPro.add("zrs");
		lPro.add("dyzcrs");
		lPro.add("dylzrs");
		lPro.add("zjqrzcrs");
		lPro.add("zjqrlzrs");
		lPro.add("dqzzrs");
		lPro.add("zdskb");
		lPro.add("qyrsks");
		lPro.add("ztdm");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyryxxtj getQyryxxtj=new Qyryxxtj();
    	
        this.setData(getQyryxxtj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	
	
	
//刷卡统计
	
	public void setTabledataQyryxxtj(List lData,Qyryxxtj getQyryxxtj,String flag) throws Exception{
		List lPro=new ArrayList();
		
		
		
		if("1".equals(getQyryxxtj.getCsbz())){
			lPro.add("qybm");
			lPro.add("qybm");
			lPro.add("qymc");
		} else if("1".equals(getQyryxxtj.getGxdwbz())){
			lPro.add("gxdwdm");
			lPro.add("gxdwmc");
		} else if("1".equals(getQyryxxtj.getFxjbz())){
			lPro.add("fxjdm");
			lPro.add("fxjmc");
		} else if("1".equals(getQyryxxtj.getDsjgbz())){
			lPro.add("dsjgdm");
			lPro.add("dsjgmc");
		}
		
		lPro.add("zrs");
		lPro.add("dqzzrs");
		lPro.add("dyzcrs");
		lPro.add("zjqrzcrs");
	
		
		
		
    
    	List lCol=new ArrayList();
    
    	
    
    	
    	Qyryxxtj setQyryxxt=new Qyryxxtj();
        this.setData(setQyryxxt,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
public String querylist() throws Exception{
		
		try {
			
	        Qyryxxtj setQyryxxtj=new Qyryxxtj();
	        setQyryxxtj = (Qyryxxtj)this.setClass(setQyryxxtj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setQyryxxtj.getDsjgbz());
			map.put("fxjbz", setQyryxxtj.getFxjbz());
			map.put("gxdwbz", setQyryxxtj.getGxdwbz());
			map.put("csbz", setQyryxxtj.getCsbz());
			map.put("dsjgdm", setQyryxxtj.getDsjgdm());
			map.put("fxjdm", setQyryxxtj.getFxjdm());
			map.put("gxdwdm", setQyryxxtj.getGxdwdm());
			map.put("qybm", setQyryxxtj.getCsbm());
		
			map.put("hylbdm", setQyryxxtj.getHylbdm());
			map.put("ztdm", setQyryxxtj.getZtdm());
			
		
			map.put("shenheFlagCx", "yes");//统计已审核的
			map.put("sftjyg",  "1");//是否统计异构系统，1统计，0不统计
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的
		    
		
			  
			
		    Page page = qyryxxtjService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataQyryxxtj(page.getData(),setQyryxxtj,"all"); 
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
			
			   Qyryxxtj setQyryxxtj=new Qyryxxtj();
		        setQyryxxtj = (Qyryxxtj)this.setClass(setQyryxxtj, null);
			Map map = new HashMap();
			map.put("dsjgbz", setQyryxxtj.getDsjgbz());
			map.put("fxjbz", setQyryxxtj.getFxjbz());
			map.put("gxdwbz", setQyryxxtj.getGxdwbz());
			map.put("csbz", setQyryxxtj.getCsbz());
			map.put("dsjgdm", setQyryxxtj.getDsjgdm());
			map.put("fxjdm", setQyryxxtj.getFxjdm());
			map.put("gxdwdm", setQyryxxtj.getGxdwdm());
			map.put("qybm", setQyryxxtj.getCsbm());
			map.put("hylbdm", setQyryxxtj.getHylbdm());
			map.put("ztdm", setQyryxxtj.getZtdm());

			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

	

			Page page = qyryxxtjService.getListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("qyryxxtjList", page.getData());
			
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
			Qysctj setqysctj=new Qysctj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("qyryxxtjList"));
			lResult.add(setqysctj);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	
	
	
	
	
	
	
	
	
	
	public String query() throws Exception{
		try {
			Qyryxxtj setQyryxxtj=new Qyryxxtj();
			qyryxxtj=(Qyryxxtj)this.setClass(setQyryxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxxtj=qyryxxtjService.getQyryxxtj(qyryxxtj);
        lQyryxxtj.clear();
        lQyryxxtj.add(qyryxxtj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyryxxtj setQyryxxtj=new Qyryxxtj();
			qyryxxtj=(Qyryxxtj)this.setClass(setQyryxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxxtj=qyryxxtjService.insertQyryxxtj(qyryxxtj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyryxxtj setQyryxxtj=new Qyryxxtj();
			qyryxxtj=(Qyryxxtj)this.setClass(setQyryxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxxtjService.updateQyryxxtj(qyryxxtj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyryxxtj setQyryxxtj=new Qyryxxtj();
			qyryxxtj=(Qyryxxtj)this.setClass(setQyryxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxxtjService.deleteQyryxxtj(qyryxxtj);
        this.result="success";
        return "success";
    }
}