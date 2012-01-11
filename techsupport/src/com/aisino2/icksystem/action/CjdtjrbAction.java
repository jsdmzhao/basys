package com.aisino2.icksystem.action;

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
import com.aisino2.icksystem.domain.Cjdtjrb;
import com.aisino2.icksystem.service.ICjdtjrbService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;

public class CjdtjrbAction extends PageAction{
	private ICjdtjrbService cjdtjrbService;
	private List lCjdtjrb;
	private Cjdtjrb cjdtjrb;
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

	public Cjdtjrb getCjdtjrb() {
		return cjdtjrb;
	}
	
	public List getLCjdtjrb() {
		return lCjdtjrb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setcjdtjrbService(ICjdtjrbService cjdtjrbService) {
		this.cjdtjrbService = cjdtjrbService;
	}
	
	public void setTabledata(List lData,Cjdtjrb setcjdtjrb) throws Exception{
		List lPro=new ArrayList();
		lPro.add("cjdtjrbid");
		
		if("1".equals(setcjdtjrb.getSsdsbz())){
			lPro.add("ssdsmc");
		}
		if("1".equals(setcjdtjrb.getCjdbz())){
			lPro.add("cjdmc");
		}
		lPro.add("lrcss");
		lPro.add("lrcyrys");
		lPro.add("yslicks");
		lPro.add("yjss");
		lPro.add("yffs");

    	List lCol=new ArrayList();
    	
    	Cjdtjrb getCjdtjrb=new Cjdtjrb();
    	
        this.setData(getCjdtjrb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Cjdtjrb setcjdtjrb = new Cjdtjrb();
			setcjdtjrb = (Cjdtjrb)this.setClass(setcjdtjrb, null);
			Map map = new HashMap();
			map.put("ssdsbm", setcjdtjrb.getSsdsbm());
			map.put("hylbdm", setcjdtjrb.getHylbdm());
			map.put("cjdbm", setcjdtjrb.getCjdbm());
			map.put("ssdsbz", setcjdtjrb.getSsdsbz());
			map.put("cjdbz", setcjdtjrb.getCjdbz());
			map.put("qssj", setcjdtjrb.getQssj());
			map.put("jzsj", setcjdtjrb.getJzsj());
			Page page = cjdtjrbService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lCjdtjrb=page.getData();
			setTabledata(lCjdtjrb,setcjdtjrb); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	public String querylistExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Cjdtjrb setcjdtjrb = new Cjdtjrb();
			setcjdtjrb = (Cjdtjrb)this.setClass(setcjdtjrb, null);
			Map map = new HashMap();
			map.put("ssdsbm", setcjdtjrb.getSsdsbm());
			map.put("cjdbm", setcjdtjrb.getCjdbm());
			map.put("ssdsbz", setcjdtjrb.getSsdsbz());
			map.put("cjdbz", setcjdtjrb.getCjdbz());
			map.put("qssj", setcjdtjrb.getQssj());
			map.put("jzsj", setcjdtjrb.getJzsj());
			Page page = cjdtjrbService.getListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("cjdtjrbList", page.getData());
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
			Cjdtjrb setcjdtjrb = new Cjdtjrb();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("cjdtjrbList"));
			lResult.add(setcjdtjrb);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	public void setTabledataQyd(List lData,Cjdtjrb setcjdtjrb) throws Exception{
		List lPro=new ArrayList();
		lPro.add("cjdtjrbid");
		
		//lPro.add("lrcss");
		lPro.add("lrcyrys");
		lPro.add("yslicks");
		lPro.add("yjss");
		lPro.add("yffs");

    	List lCol=new ArrayList();
    	
    	Cjdtjrb getCjdtjrb=new Cjdtjrb();
    	
        this.setData(getCjdtjrb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylistQyd() throws Exception{
		try {
			Cjdtjrb setcjdtjrb = new Cjdtjrb();
			setcjdtjrb = (Cjdtjrb)this.setClass(setcjdtjrb, null);
			Map map = new HashMap();
			map.put("cjdbm", setcjdtjrb.getCjdbm());
			map.put("qssj", setcjdtjrb.getQssj());
			map.put("jzsj", setcjdtjrb.getJzsj());
			Page page = cjdtjrbService.getListForPageQyd(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lCjdtjrb=page.getData();
			setTabledataQyd(lCjdtjrb,setcjdtjrb); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	public String querylistExcelQydTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Cjdtjrb setcjdtjrb = new Cjdtjrb();
			setcjdtjrb = (Cjdtjrb)this.setClass(setcjdtjrb, null);
			Map map = new HashMap();
			map.put("cjdbm", setcjdtjrb.getCjdbm());
			map.put("qssj", setcjdtjrb.getQssj());
			map.put("jzsj", setcjdtjrb.getJzsj());
			Page page = cjdtjrbService.getListForPageQyd(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("cjdtjrbListQyd", page.getData());
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	public void querylistExcelQyd() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Cjdtjrb setcjdtjrb = new Cjdtjrb();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("cjdtjrbListQyd"));
			lResult.add(setcjdtjrb);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	public String query() throws Exception{
		try {
			Cjdtjrb setcjdtjrb=new Cjdtjrb();
			cjdtjrb=(Cjdtjrb)this.setClass(setcjdtjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cjdtjrb=cjdtjrbService.getCjdtjrb(cjdtjrb);
        lCjdtjrb.clear();
        lCjdtjrb.add(cjdtjrb);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Cjdtjrb setcjdtjrb=new Cjdtjrb();
			cjdtjrb=(Cjdtjrb)this.setClass(setcjdtjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cjdtjrb=cjdtjrbService.insertCjdtjrb(cjdtjrb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Cjdtjrb setcjdtjrb=new Cjdtjrb();
			cjdtjrb=(Cjdtjrb)this.setClass(setcjdtjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cjdtjrbService.updateCjdtjrb(cjdtjrb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Cjdtjrb setcjdtjrb=new Cjdtjrb();
			cjdtjrb=(Cjdtjrb)this.setClass(setcjdtjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cjdtjrbService.deleteCjdtjrb(cjdtjrb);
        this.result="success";
        return "success";
    }
	
	/**
	 * 采集点日报
	 * @return
	 * @throws Exception
	 */
	public String queryCjdrblist() throws Exception{
		try {
			//设置采集点编码(需要改动，从session用户信息中得到)
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Cjdtjrb setcjdtjrb = new Cjdtjrb();
			setcjdtjrb = (Cjdtjrb)this.setClass(setcjdtjrb, null);
			Map map = new HashMap();
			map.put("cjdbm", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			map.put("qssj", setcjdtjrb.getQssj());
			map.put("jzsj", setcjdtjrb.getJzsj());
			Page page = cjdtjrbService.getCjdrbListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lCjdtjrb=page.getData();
			setCjdrbTabledata(lCjdtjrb); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public void setCjdrbTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("cjdtjrq");
		lPro.add("cjdtjrq");
		lPro.add("lrcss");
		lPro.add("lrcyrys");
		lPro.add("yslicks");
		lPro.add("yffs");
		lPro.add("yjss");
		lPro.add("yzxs");
		lPro.add("bhks");

    	List lCol=new ArrayList();
    	
    	Cjdtjrb getCjdtjrb=new Cjdtjrb();
    	
        this.setData(getCjdtjrb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
}