package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Xctbhf;
import com.aisino2.basicsystem.domain.Xctbjsdw;
import com.aisino2.basicsystem.service.IXctbhfService;
import com.aisino2.basicsystem.service.IXctbjsdwService;
import com.aisino2.common.DateToString;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class XctbhfAction extends PageAction{
	private IXctbhfService xctbhfService;
	private IXctbjsdwService xctbjsdwService;
	private List lXctbhf = new ArrayList();
	private Xctbhf xctbhf = new Xctbhf();
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

	public Xctbhf getXctbhf() {
		return xctbhf;
	}
	
	public List getLXctbhf() {
		return lXctbhf;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setXctbhfService(IXctbhfService xctbhfService) {
		this.xctbhfService = xctbhfService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("tbid");
		lPro.add("hfr");
		lPro.add("hfsj");
		lPro.add("hfnr");

    	List lCol=new ArrayList();
    	
    	Xctbhf getXctbhf=new Xctbhf();
    	
        this.setData(getXctbhf,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Xctbhf setXctbhf=new Xctbhf();
			xctbhf=(Xctbhf)this.setClass(setXctbhf, null);
			Map map = new HashMap();
			map.put("tbid",xctbhf.getTbid());
			
            ////////////////////
			int tbid = xctbhf.getTbid();
			Xctbjsdw xctbjsdw = new Xctbjsdw();
			xctbjsdw.setTbid(tbid);    //////////tbid 条件
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
		    user= (User)session.getAttribute(Constants.userKey);
		    
		    /*String userType = user.getUsertype();
		    String useraccount = user.getUseraccount();
			if("B02".equals(useraccount.substring(0,3))){
				xctbjsdw.setJsdwbm(user.getUseraccount().substring(0,15));
			}else{
				xctbjsdw.setJsdwbm(user.getUseraccount().substring(0,14));
			}*/
			
			xctbjsdw.setJsdwbm(user.getSsdwbm());
		    
		    xctbjsdw = xctbjsdwService.getXctbjsdw(xctbjsdw);
		    int jsdwid = xctbjsdw.getJsdwid();
		    /////////////////////////
		    map.put("jsdwid",jsdwid);
			Page page = xctbhfService.getcsListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lXctbhf=page.getData();
			setTabledata(lXctbhf); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Xctbhf setXctbhf=new Xctbhf();
			xctbhf=(Xctbhf)this.setClass(setXctbhf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        xctbhf=xctbhfService.getXctbhf(xctbhf);
        lXctbhf.clear();
        lXctbhf.add(xctbhf);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Xctbhf setXctbhf=new Xctbhf();
			xctbhf=(Xctbhf)this.setClass(setXctbhf, null);	
			xctbhf.setHfsj(new Date());  ///回复时间
			
			////////////////////
			int tbid = xctbhf.getTbid();
			Xctbjsdw xctbjsdw = new Xctbjsdw();
			xctbjsdw.setTbid(tbid);    //////////tbid 条件
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
		    user= (User)session.getAttribute(Constants.userKey);
		    
		   /* String userType = user.getUsertype();
		    String useraccount = user.getUseraccount();
			if("B02".equals(useraccount.substring(0,3))){
				xctbjsdw.setJsdwbm(user.getUseraccount().substring(0,15));
			}else{
				xctbjsdw.setJsdwbm(user.getUseraccount().substring(0,14));
			}*/
		    
		    xctbjsdw.setJsdwbm(user.getSsdwbm());
		    
		    xctbjsdw = xctbjsdwService.getXctbjsdw(xctbjsdw);
		    /////////////////////////
		    
		    int jsdwid = xctbjsdw.getJsdwid();
		    xctbhf.setJsdwid(jsdwid);
			xctbhf=xctbhfService.insertXctbhf(xctbhf);
			//xctbhf.setJsdwid(21);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Xctbhf setXctbhf=new Xctbhf();
			xctbhf=(Xctbhf)this.setClass(setXctbhf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        xctbhfService.updateXctbhf(xctbhf);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Xctbhf setXctbhf=new Xctbhf();
			xctbhf=(Xctbhf)this.setClass(setXctbhf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        xctbhfService.deleteXctbhf(xctbhf);
        this.result="success";
        return "success";
    }
	
	
	private User user;
	private String hftime;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 初始化 添加
	 * @return
	 * @throws Exception
	 */
	public String initxctbhfAdd() throws Exception{
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		user= (User)session.getAttribute(Constants.userKey);
		Date today = new Date();
		hftime = DateToString.getDateEn(today);	
		this.result="success";
		return "success";
	}

	public String getHftime() {
		return hftime;
	}

	public void setHftime(String hftime) {
		this.hftime = hftime;
	}

	public void setXctbjsdwService(IXctbjsdwService xctbjsdwService) {
		this.xctbjsdwService = xctbjsdwService;
	}
	
	////////////////////////////公安端列表
	public void setTabledataga(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("tbid");
		lPro.add("jsdwmc");
		lPro.add("hfr");
		lPro.add("hfsj");
		lPro.add("hfnr");

    	List lCol=new ArrayList();
    	
    	Xctbhf getXctbhf=new Xctbhf();
    	
        this.setData(getXctbhf,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylistga() throws Exception{
		try {
			Xctbhf setXctbhf=new Xctbhf();
			xctbhf=(Xctbhf)this.setClass(setXctbhf, null);
			Map map = new HashMap();
			map.put("tbid",xctbhf.getTbid());
		    map.put("jsdwid",xctbhf.getJsdwid());
			
			Page page = xctbhfService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lXctbhf=page.getData();
			setTabledataga(lXctbhf); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	
	
}