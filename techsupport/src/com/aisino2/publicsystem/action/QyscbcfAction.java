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
import com.aisino2.publicsystem.domain.Qyscbcf;
import com.aisino2.publicsystem.service.IQyscbcfService;
import com.aisino2.sysadmin.domain.Globalpar;

public class QyscbcfAction extends PageAction{
	private IQyscbcfService qyscbcfService;
	private List lQyscbcf=new ArrayList();
	private Qyscbcf qyscbcf=new Qyscbcf();
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

	public Qyscbcf getQyscbcf() {
		return qyscbcf;
	}
	
	public List getLQyscbcf() {
		return lQyscbcf;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyscbcfService(IQyscbcfService qyscbcfService) {
		this.qyscbcfService = qyscbcfService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyscbcfid");
		lPro.add("hylbdm");
		lPro.add("hylb");
		lPro.add("wdbrq");
		lPro.add("dsjgdm");
		lPro.add("dsjgmc");
		lPro.add("fxjdm");
		lPro.add("fxjmc");
		lPro.add("gxdwdm");
		lPro.add("gxdwmc");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("lxdh");
		lPro.add("zrs");
		lPro.add("sskrs");
		lPro.add("hdskb");
		lPro.add("sjsrb");
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
    	
    	Qyscbcf getQyscbcf=new Qyscbcf();
    	
        this.setData(getQyscbcf,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	
//上传不充分

	
	public void setTabledatabcf(List lData,Qyscbcf getQyscbc,String flag) throws Exception{
		List lPro=new ArrayList();
		
		 if("1".equals(getQyscbc.getGxdwbz())){
			lPro.add("gxdwdm");
			lPro.add("gxdwmc");
		} else if("1".equals(getQyscbc.getFxjbz())){
			lPro.add("fxjdm");
			lPro.add("fxjmc");
		} else if("1".equals(getQyscbc.getDsjgbz())){
			lPro.add("dsjgdm");
			lPro.add("dsjgmc");
		}else{
			 lPro.add("qybm");
		}  
		   lPro.add("qybm");
		   lPro.add("qymc");
		   lPro.add("wdbts");
		   lPro.add("yljts");
		   lPro.add("nljts");

		
    	  List lCol=new ArrayList();
    
   
    	
      Qyscbcf getQyscbcf=new Qyscbcf();
    	
        this.setData(getQyscbcf,lData,lPro,lCol);
    	
  
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		
		try {
			  Qyscbcf setQyscbcf=new Qyscbcf();
			  setQyscbcf = (Qyscbcf)this.setClass(setQyscbcf, null);
			Map map = new HashMap();
			map.put("dsjgbz", setQyscbcf.getDsjgbz());
			map.put("fxjbz", setQyscbcf.getFxjbz());
			map.put("gxdwbz", setQyscbcf.getGxdwbz());
			map.put("dsjgdm", setQyscbcf.getDsjgdm());
			map.put("fxjdm", setQyscbcf.getFxjdm());
			map.put("gxdwdm", setQyscbcf.getGxdwdm());
			
			map.put("qsrq", setQyscbcf.getQssj());
			map.put("jzrq", setQyscbcf.getJzsj());
			map.put("hylbdm", setQyscbcf.getHylbdm());
		
			
			map.put("ztdm", setQyscbcf.getZtdm());
		
			map.put("shenheFlagCx", "yes");//统计已审核的
			map.put("sftjyg",  "1");//是否统计异构系统，1统计，0不统计
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

			  
			
	        Page page = qyscbcfService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledatabcf(page.getData(),setQyscbcf,"all"); 
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
			
			  Qyscbcf setQyscbcf=new Qyscbcf();
			  setQyscbcf = (Qyscbcf)this.setClass(setQyscbcf, null);
			Map map = new HashMap();
			map.put("dsjgbz", setQyscbcf.getDsjgbz());
			map.put("fxjbz", setQyscbcf.getFxjbz());
			map.put("gxdwbz", setQyscbcf.getGxdwbz());
	
			map.put("dsjgdm", setQyscbcf.getDsjgdm());
			map.put("fxjdm", setQyscbcf.getFxjdm());
			map.put("gxdwdm", setQyscbcf.getGxdwdm());
	
			map.put("qsrq", setQyscbcf.getQssj());
			map.put("jzrq", setQyscbcf.getJzsj());
			map.put("hylbdm", setQyscbcf.getHylbdm());
			
			

			
			map.put("ztdm", setQyscbcf.getZtdm());
		
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

			
		      Page page = qyscbcfService.getListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("qyscbcfList", page.getData());
			
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
			  Qyscbcf setQyscbcf=new Qyscbcf();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("qyscbcfList"));
			lResult.add(setQyscbcf);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	
	
	
	
	//场所上传不充分统计详细

	
	public void setTabledatabcfxx(List lData,Qyscbcf getQyscbc,String flag) throws Exception{
		List lPro=new ArrayList();
		
		 if("1".equals(getQyscbc.getGxdwbz())){
			lPro.add("gxdwdm");
			lPro.add("gxdwmc");
		} else if("1".equals(getQyscbc.getFxjbz())){
			lPro.add("fxjdm");
			lPro.add("fxjmc");
		} else if("1".equals(getQyscbc.getDsjgbz())){
			lPro.add("dsjgdm");
			lPro.add("dsjgmc");
		}else{
			 lPro.add("qybm");
		}  
		   lPro.add("qybm");
		   lPro.add("qymc");
		   lPro.add("zrs");
		   lPro.add("sskrs");
		   lPro.add("lxdh");
		   lPro.add("hdskbstring");
		   lPro.add("sjsrbstring");
		   lPro.add("wdbrq");

		
    	  List lCol=new ArrayList();
    	
      Qyscbcf getQyscbcf=new Qyscbcf();
        this.setData(getQyscbcf,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	public String querylistxx() throws Exception{
		try {
			  Qyscbcf setQyscbcf=new Qyscbcf();
			  setQyscbcf = (Qyscbcf)this.setClass(setQyscbcf, null);
			Map map = new HashMap();
			map.put("dsjgbz", setQyscbcf.getDsjgbz());
			map.put("fxjbz", setQyscbcf.getFxjbz());
			map.put("gxdwbz", setQyscbcf.getGxdwbz());
			map.put("dsjgdm", setQyscbcf.getDsjgdm());
			map.put("fxjdm", setQyscbcf.getFxjdm());
			map.put("gxdwdm", setQyscbcf.getGxdwdm());
			
			map.put("qsrq", setQyscbcf.getQssj());
			map.put("jzrq", setQyscbcf.getJzsj());
			map.put("hylbdm", setQyscbcf.getHylbdm());
			map.put("qybm", setQyscbcf.getQybm());
			
			map.put("ztdm", setQyscbcf.getZtdm());
		
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

			  
			
	        Page page = qyscbcfService.getXxListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledatabcfxx(page.getData(),setQyscbcf,"all"); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
      return "success";
		
    }
	
	
	
	
	public String querylistExcelTempxx(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			  Qyscbcf setQyscbcf=new Qyscbcf();
			  setQyscbcf = (Qyscbcf)this.setClass(setQyscbcf, null);
			Map map = new HashMap();
			map.put("dsjgbz", setQyscbcf.getDsjgbz());
			map.put("fxjbz", setQyscbcf.getFxjbz());
			map.put("gxdwbz", setQyscbcf.getGxdwbz());
	
			map.put("dsjgdm", setQyscbcf.getDsjgdm());
			map.put("fxjdm", setQyscbcf.getFxjdm());
			map.put("gxdwdm", setQyscbcf.getGxdwdm());
	
			map.put("qsrq", setQyscbcf.getQssj());
			map.put("jzrq", setQyscbcf.getJzsj());
			map.put("hylbdm", setQyscbcf.getHylbdm());
			map.put("qybm", setQyscbcf.getQybm());
			

			
			map.put("ztdm", setQyscbcf.getZtdm());
		
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

			
		    Page page = qyscbcfService.getXxListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("qyscbcfxxList", page.getData());
			
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
		
	}
	public void querylistExcelxx() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			  Qyscbcf setQyscbcf=new Qyscbcf();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("qyscbcfxxList"));
			lResult.add(setQyscbcf);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String query() throws Exception{
		try {
			Qyscbcf setQyscbcf=new Qyscbcf();
			qyscbcf=(Qyscbcf)this.setClass(setQyscbcf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyscbcf=qyscbcfService.getQyscbcf(qyscbcf);
        lQyscbcf.clear();
        lQyscbcf.add(qyscbcf);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyscbcf setQyscbcf=new Qyscbcf();
			qyscbcf=(Qyscbcf)this.setClass(setQyscbcf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyscbcf=qyscbcfService.insertQyscbcf(qyscbcf);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyscbcf setQyscbcf=new Qyscbcf();
			qyscbcf=(Qyscbcf)this.setClass(setQyscbcf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyscbcfService.updateQyscbcf(qyscbcf);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyscbcf setQyscbcf=new Qyscbcf();
			qyscbcf=(Qyscbcf)this.setClass(setQyscbcf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyscbcfService.deleteQyscbcf(qyscbcf);
        this.result="success";
        return "success";
    }
}