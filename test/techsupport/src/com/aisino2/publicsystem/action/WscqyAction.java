package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Wscqy;
import com.aisino2.publicsystem.service.IWscqyService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;

public class WscqyAction extends PageAction{
	private IWscqyService wscqyService;
	private List lWscqy=new ArrayList();
	private Wscqy wscqy=new Wscqy();
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

	public Wscqy getWscqy() {
		return wscqy;
	}
	
	public List getLWscqy() {
		return lWscqy;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setWscqyService(IWscqyService wscqyService) {
		this.wscqyService = wscqyService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("wscqyid");
		lPro.add("hylbdm");
		lPro.add("hylb");
		lPro.add("wscrq");
		lPro.add("dsjgdm");
		lPro.add("dsjgmc");
		lPro.add("fxjdm");
		lPro.add("fxjmc");
		lPro.add("gxdwdm");
		lPro.add("gxdwmc");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("lxdh");
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
    	
    	Wscqy getWscqy=new Wscqy();
    	
        this.setData(getWscqy,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
//上传不充分

	
	public void setTabledatawsc(List lData,Wscqy getWscqys,String flag) throws Exception{
		List lPro=new ArrayList();
		
		 if("1".equals(getWscqys.getGxdwbz())){
			lPro.add("gxdwdm");
			lPro.add("gxdwmc");
		} else if("1".equals(getWscqys.getFxjbz())){
			lPro.add("fxjdm");
			lPro.add("fxjmc");
		} else if("1".equals(getWscqys.getDsjgbz())){
			lPro.add("dsjgdm");
			lPro.add("dsjgmc");
		}else{
			 lPro.add("qybm");
		}  
		   lPro.add("qybm");
		   lPro.add("qymc");
		   lPro.add("wscts");
		   lPro.add("yljts");
		   lPro.add("nljts");

		
    	  List lCol=new ArrayList();
    
    		Wscqy getWscqy=new Wscqy();
    	

    	
        this.setData(getWscqy,lData,lPro,lCol);
    	
  
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	
	public String querylist() throws Exception{
    
        
        try {
            Wscqy setWscqy=new Wscqy();
            setWscqy = (Wscqy)this.setClass(setWscqy, null);
			Map map = new HashMap();
			map.put("dsjgbz", setWscqy.getDsjgbz());
			map.put("fxjbz", setWscqy.getFxjbz());
			map.put("gxdwbz", setWscqy.getGxdwbz());
			map.put("dsjgdm", setWscqy.getDsjgdm());
			map.put("fxjdm", setWscqy.getFxjdm());
			map.put("gxdwdm", setWscqy.getGxdwdm());
			
			map.put("qsrq", setWscqy.getQssj());
			map.put("jzrq", setWscqy.getJzsj());
			map.put("hylbdm", setWscqy.getHylbdm());
			
			
			map.put("ztdm", setWscqy.getZtdm());
		
			map.put("shenheFlagCx", "yes");//统计已审核的
			map.put("sftjyg",  "1");//是否统计异构系统，1统计，0不统计
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

			  
			
	        Page page = wscqyService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledatawsc(page.getData(),setWscqy,"all"); 
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
			
		    Wscqy setWscqy=new Wscqy();
			
			
			
		    setWscqy = (Wscqy)this.setClass(setWscqy, null);
			Map map = new HashMap();
			map.put("dsjgbz", setWscqy.getDsjgbz());
			map.put("fxjbz", setWscqy.getFxjbz());
			map.put("gxdwbz", setWscqy.getGxdwbz());
	
			map.put("dsjgdm", setWscqy.getDsjgdm());
			map.put("fxjdm", setWscqy.getFxjdm());
			map.put("gxdwdm", setWscqy.getGxdwdm());
	
			map.put("qsrq", setWscqy.getQssj());
			map.put("jzrq", setWscqy.getJzsj());
			map.put("hylbdm", setWscqy.getHylbdm());
			
			

			
			map.put("ztdm", setWscqy.getZtdm());
		
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

			
		      Page page = wscqyService.getListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("wscqyList", page.getData());
			
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
			  Wscqy setWscqy=new Wscqy();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("wscqyList"));
			lResult.add(setWscqy);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	
	
	
	

	
	
	//场所未上传统计详细

	
	public void setTabledatawscxx(List lData,Wscqy getWscqys,String flag) throws Exception{
		List lPro=new ArrayList();
		
		 if("1".equals(getWscqys.getGxdwbz())){
			lPro.add("gxdwdm");
			lPro.add("gxdwmc");
		} else if("1".equals(getWscqys.getFxjbz())){
			lPro.add("fxjdm");
			lPro.add("fxjmc");
		} else if("1".equals(getWscqys.getDsjgbz())){
			lPro.add("dsjgdm");
			lPro.add("dsjgmc");
		}else{
			 lPro.add("qybm");
		}  
		   lPro.add("qybm");
		   lPro.add("qymc");
		   lPro.add("wscrq");
		

		
    	  List lCol=new ArrayList();
    	
    	  Wscqy getWscqy=new Wscqy();
        this.setData(getWscqy,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	public String querylistxx() throws Exception{
		try {
			Wscqy setWscqy=new Wscqy();
			setWscqy = (Wscqy)this.setClass(setWscqy, null);
			Map map = new HashMap();
			map.put("dsjgbz", setWscqy.getDsjgbz());
			map.put("fxjbz", setWscqy.getFxjbz());
			map.put("gxdwbz", setWscqy.getGxdwbz());
			map.put("dsjgdm", setWscqy.getDsjgdm());
			map.put("fxjdm", setWscqy.getFxjdm());
			map.put("gxdwdm", setWscqy.getGxdwdm());
			
			map.put("qsrq", setWscqy.getQssj());
			map.put("jzrq", setWscqy.getJzsj());
			map.put("hylbdm", setWscqy.getHylbdm());
			map.put("qybm", setWscqy.getQybm());
			
			map.put("ztdm", setWscqy.getZtdm());
		
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

			  
			
	        Page page = wscqyService.getXxListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledatawscxx(page.getData(),setWscqy,"all"); 
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
			
			Wscqy setWscqy=new Wscqy();
			setWscqy = (Wscqy)this.setClass(setWscqy, null);
			Map map = new HashMap();
			map.put("dsjgbz", setWscqy.getDsjgbz());
			map.put("fxjbz", setWscqy.getFxjbz());
			map.put("gxdwbz", setWscqy.getGxdwbz());
	
			map.put("dsjgdm", setWscqy.getDsjgdm());
			map.put("fxjdm", setWscqy.getFxjdm());
			map.put("gxdwdm", setWscqy.getGxdwdm());
	
			map.put("qsrq", setWscqy.getQssj());
			map.put("jzrq", setWscqy.getJzsj());
			map.put("hylbdm", setWscqy.getHylbdm());
			map.put("qybm", setWscqy.getQybm());
			

			
			map.put("ztdm", setWscqy.getZtdm());
		
			map.put("shenheFlagCx", "yes");//统计已审核的
		    map.put("scbzFlagCx",  "yes");//删除标志等于0的

			map.put("yyzt", "yes");//只显示装机开业

			
		    Page page = wscqyService.getXxListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("wscqyxxList", page.getData());
			
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
			Wscqy setWscqy=new Wscqy();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("wscqyxxList"));
			lResult.add(setWscqy);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	 
	public String query() throws Exception{
		try {
			Wscqy setWscqy=new Wscqy();
			wscqy=(Wscqy)this.setClass(setWscqy, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wscqy=wscqyService.getWscqy(wscqy);
        lWscqy.clear();
        lWscqy.add(wscqy);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Wscqy setWscqy=new Wscqy();
			wscqy=(Wscqy)this.setClass(setWscqy, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wscqy=wscqyService.insertWscqy(wscqy);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Wscqy setWscqy=new Wscqy();
			wscqy=(Wscqy)this.setClass(setWscqy, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wscqyService.updateWscqy(wscqy);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Wscqy setWscqy=new Wscqy();
			wscqy=(Wscqy)this.setClass(setWscqy, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wscqyService.deleteWscqy(wscqy);
        this.result="success";
        return "success";
    }
	
	/**
	 * 未上传企业信息查询 采集点台账用
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryWscqyList() throws Exception {

		try {
			Wscqy setWscqy = new Wscqy();
			setWscqy = (Wscqy) this.setClass(setWscqy, null);
			Map map = new HashMap();

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session= request.getSession();
			User user= (User)session.getAttribute(Constants.userKey);
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			Page page = wscqyService.getWscqyListForPage(map, pagesize, pagerow,
					sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			setWscqyTabledata(page.getData());
			this.result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
		}
		return "success";
	}

	public void setWscqyTabledata(List wscqyList) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qyid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("qyzflmc");
		lPro.add("yyztmc");
		lPro.add("zrs");
		lPro.add("yljts");
		lPro.add("nljts");

		List lCol=new ArrayList();
		
		Wscqy getWscqy = new Wscqy();

		this.setData(getWscqy, wscqyList, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	
	/**
	 * 企业刷卡统计
	 * 
	 * @return
	 * @throws Exception
	 */
	public String querySkcstjList() throws Exception {

		try {
			Wscqy setWscqy = new Wscqy();
			setWscqy = (Wscqy) this.setClass(setWscqy, null);
			Map map = new HashMap();
			map.put("dsjgdm", setWscqy.getDsjgdm());
			map.put("fxjdm", setWscqy.getFxjdm());
			map.put("gxdwdm", setWscqy.getGxdwdm());
			map.put("dsjgbz", setWscqy.getDsjgbz());
			map.put("fxjbz", setWscqy.getFxjbz());
			map.put("gxdwbz", setWscqy.getGxdwbz());
			map.put("hylbdm", setWscqy.getHylbdm());
			map.put("qssj", setWscqy.getQssj());
			map.put("jzsj", setWscqy.getJzsj());
			Page page = wscqyService.getSkcstjListForPage(map, pagesize, pagerow,
					sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			setSkcstjTabledata(page.getData(),setWscqy);
			this.result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
		}
		return "success";
	}
	public void setSkcstjTabledata(List wscqyList,Wscqy setWscqy) throws Exception {
		List lPro = new ArrayList();
		if ("1".equals(setWscqy.getGxdwbz())) {
			lPro.add("gxdwdm");
		} else if ("1".equals(setWscqy.getFxjbz())) {
			lPro.add("fxjdm");
		} else if ("1".equals(setWscqy.getDsjgbz())) {
			lPro.add("dsjgdm");
		} else {
			lPro.add("dsjgdm");
		}
		lPro.add("dsjgmc");
		lPro.add("fxjmc");
		lPro.add("gxdwmc");
		lPro.add("qyzs");
		lPro.add("wscqys");
		lPro.add("scqys");
		List lCol=new ArrayList();
		Wscqy getWscqy = new Wscqy();
		this.setData(getWscqy, wscqyList, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	public String querySkcstjListExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Wscqy setWscqy = new Wscqy();
			setWscqy = (Wscqy) this.setClass(setWscqy, null);
			Map map = new HashMap();
			map.put("dsjgdm", setWscqy.getDsjgdm());
			map.put("fxjdm", setWscqy.getFxjdm());
			map.put("gxdwdm", setWscqy.getGxdwdm());
			map.put("dsjgbz", setWscqy.getDsjgbz());
			map.put("fxjbz", setWscqy.getFxjbz());
			map.put("gxdwbz", setWscqy.getGxdwbz());
			map.put("hylbdm", setWscqy.getHylbdm());
			map.put("qssj", setWscqy.getQssj());
			map.put("jzsj", setWscqy.getJzsj());
			
		    Page page = wscqyService.getSkcstjListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("skcstjList", page.getData());
			
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
		
	}
	public void querySkcstjListExcel() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Wscqy setWscqy=new Wscqy();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("skcstjList"));
			lResult.add(setWscqy);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	/**
	 * 企业刷卡未上传明细
	 * 
	 * @return
	 * @throws Exception
	 */
	public String querySkwscmxList() throws Exception {

		try {
			Wscqy setWscqy = new Wscqy();
			setWscqy = (Wscqy) this.setClass(setWscqy, null);
			Map map = new HashMap();
			map.put("dsjgdm", setWscqy.getDsjgdm());
			map.put("fxjdm", setWscqy.getFxjdm());
			map.put("gxdwdm", setWscqy.getGxdwdm());
			map.put("dsjgbz", setWscqy.getDsjgbz());
			map.put("fxjbz", setWscqy.getFxjbz());
			map.put("gxdwbz", setWscqy.getGxdwbz());
			map.put("hylbdm", setWscqy.getHylbdm());
			map.put("qssj", setWscqy.getQssj());
			map.put("jzsj", setWscqy.getJzsj());
			Page page = wscqyService.getSkwscmxListForPage(map, pagesize, pagerow,
					sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			setSkwscmxTabledata(page.getData(),setWscqy);
			this.result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
		}
		return "success";
	}
	public void setSkwscmxTabledata(List wscqyList,Wscqy setWscqy) throws Exception {
		List lPro=new ArrayList();
		lPro.add("wscqyid");
		lPro.add("wscrq");
		lPro.add("qymc");
		lPro.add("qybm");
		lPro.add("zrs");
		lPro.add("lxdh");
		lPro.add("qyzflmc");
		lPro.add("yyztmc");
		lPro.add("zajbmc");
		List lCol=new ArrayList();
		Wscqy getWscqy = new Wscqy();
		this.setData(getWscqy, wscqyList, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	
}