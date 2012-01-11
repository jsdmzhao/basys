package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Gatztbjsdw;
import com.aisino2.basicsystem.service.IGatztbjsdwService;
import com.aisino2.common.IpMac;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class GatztbjsdwAction extends PageAction{
	private IGatztbjsdwService gatztbjsdwService;
	private List lGatztbjsdw=new ArrayList();
	private Gatztbjsdw gatztbjsdw=new Gatztbjsdw();
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

	public Gatztbjsdw getGatztbjsdw() {
		return gatztbjsdw;
	}
	
	public List getLGatztbjsdw() {
		return lGatztbjsdw;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setGatztbjsdwService(IGatztbjsdwService gatztbjsdwService) {
		this.gatztbjsdwService = gatztbjsdwService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("gatbid");
		lPro.add("gajsdwid");
		lPro.add("jsdwbm");
		lPro.add("jsdwmc");
		lPro.add("sqsj");
		lPro.add("hylxdm");
		lPro.add("hylx");
		lPro.add("sqip");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Gatztbjsdw getGatztbjsdw=new Gatztbjsdw();
    	
        this.setData(getGatztbjsdw,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataDetail(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("gajsdwid");
		lPro.add("jsdwmc");
		lPro.add("sqsj");
		lPro.add("sqip");
		
		
		
		Gatztbjsdw getGatztbjsdw=new Gatztbjsdw();
		
		this.setData(getGatztbjsdw,lData,lPro,null);
		this.tabledata=this.getData();
		totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Gatztbjsdw setGatztbjsdw=new Gatztbjsdw();
        Map map = new HashMap();
        Page page = gatztbjsdwService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lGatztbjsdw=page.getData();
        setTabledata(lGatztbjsdw); 
		 this.result="success";
        return "success";
    }
	public String querylistDetail() throws Exception{
		Gatztbjsdw setGatztbjsdw=new Gatztbjsdw();
		setGatztbjsdw=(Gatztbjsdw)this.setClass(setGatztbjsdw, null);
		Map map = new HashMap();
		map.put("gatbid", setGatztbjsdw.getGatbid());
		map.put("sjListflg", "1");
		Page page = gatztbjsdwService.getListForPage(map, pagesize, pagerow,sort,dir);
		totalpage=page.getTotalPages();
		totalrows=page.getTotalRows();
		lGatztbjsdw=page.getData();
		setTabledataDetail(lGatztbjsdw); 
		this.result="success";
		return "success";
	}
	public String querylistByName() throws Exception{
		Gatztbjsdw setGatztbjsdw=new Gatztbjsdw();
		setGatztbjsdw=(Gatztbjsdw)this.setClass(setGatztbjsdw, null);
		Map map = new HashMap();
		map.put("gatbid", setGatztbjsdw.getGatbid());
		lGatztbjsdw=gatztbjsdwService.getListGatztbjsdw(setGatztbjsdw);
		String name="";
		for(int i=0;i<lGatztbjsdw.size();i++){
			Gatztbjsdw dw=(Gatztbjsdw)lGatztbjsdw.get(i);
			name+=dw.getJsdwmc()+";";
		}
		gatztbjsdw.setJsdwmc(name);
		lGatztbjsdw=new ArrayList();
		lGatztbjsdw.add(gatztbjsdw);
		this.result="success";
		return "success";
	}
	public String query() throws Exception{
		try {
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
			HttpSession session= request.getSession();
			User user= (User)session.getAttribute(Constants.userKey);
			
			Gatztbjsdw setGatztbjsdw=new Gatztbjsdw();
			setGatztbjsdw=(Gatztbjsdw)this.setClass(setGatztbjsdw, null);
			setGatztbjsdw.setJsdwbm(user.getDepartment().getDepartcode());
			setGatztbjsdw=gatztbjsdwService.getGatztbjsdw(setGatztbjsdw);
	        lGatztbjsdw.clear();
	        lGatztbjsdw.add(setGatztbjsdw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Gatztbjsdw setGatztbjsdw=new Gatztbjsdw();
			gatztbjsdw=(Gatztbjsdw)this.setClass(setGatztbjsdw, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztbjsdw=gatztbjsdwService.insertGatztbjsdw(gatztbjsdw);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Gatztbjsdw setGatztbjsdw=new Gatztbjsdw();
			gatztbjsdw=(Gatztbjsdw)this.setClass(setGatztbjsdw, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztbjsdwService.updateGatztbjsdw(gatztbjsdw);
        this.result="success";
        return "success";
    }
	public String modifySb() throws Exception{
		try {
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
			HttpSession session= request.getSession();
			User user= (User)session.getAttribute(Constants.userKey);
			Gatztbjsdw setGatztbjsdw=new Gatztbjsdw();
			setGatztbjsdw=(Gatztbjsdw)this.setClass(setGatztbjsdw, null);
			setGatztbjsdw.setJsdwbm(user.getDepartment().getDepartcode());
			setGatztbjsdw=gatztbjsdwService.getGatztbjsdw(setGatztbjsdw);
			if(setGatztbjsdw!=null&&setGatztbjsdw.getSqsj()!=null){
				IpMac ipMac = new IpMac();
				String loginip = ipMac.getIpAddr(request);
				setGatztbjsdw.setSqsj(new Date());
				setGatztbjsdw.setSqip(loginip);
				gatztbjsdwService.updateGatztbjsdw(setGatztbjsdw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result="success";
		return "success";
	}
	
	public String delete() throws Exception{
		try {
			Gatztbjsdw setGatztbjsdw=new Gatztbjsdw();
			gatztbjsdw=(Gatztbjsdw)this.setClass(setGatztbjsdw, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztbjsdwService.deleteGatztbjsdw(gatztbjsdw);
        this.result="success";
        return "success";
    }
}