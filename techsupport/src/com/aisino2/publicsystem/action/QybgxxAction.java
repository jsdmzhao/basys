package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qybgxx;
import com.aisino2.publicsystem.service.IQybgxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;

public class QybgxxAction extends PageAction{
	
	private IQybgxxService qybgxxService;
	private List lQybgxx=new ArrayList();
	private Qybgxx qybgxx=new Qybgxx();
	private String tabledata="";
	private int totalrows=0;
	private String result="success";
	
	public int getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}
	public String getTabledata() {
		return tabledata;
	}
	public Qybgxx getQybgxx() {
		return qybgxx;
	}
	
	public List getLQybgxx() {
		return lQybgxx;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setQybgxxService(IQybgxxService qybgxxService) {
		this.qybgxxService = qybgxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qybgxxid");
		lPro.add("bgdjxh");
		lPro.add("bglx");
		lPro.add("bgrq");
		lPro.add("bgyy");
    	
    	List lCol=new ArrayList();
    	Qybgxx getQybgxx=new Qybgxx();
        this.setData(getQybgxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataByGad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qybgxxid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("qyzflmc");
		lPro.add("bgdjxh");
		lPro.add("bglx");
		lPro.add("bgyy");
		lPro.add("bgrq");
    	
		
		List lModify=new ArrayList();
    	lModify.add("QybgxxCx_queryDetail");
    	lModify.add("详细");
    	List lCol=new ArrayList();
    	lCol.add(lModify);
        
    	Qybgxx getQybgxx=new Qybgxx();
        this.setData(getQybgxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qybgxx setQybgxx=new Qybgxx();
        setQybgxx=(Qybgxx)this.setClass(setQybgxx, null);
        Map map = new HashMap();
        
        Page page = qybgxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQybgxx=page.getData();
        setTabledata(lQybgxx); 
		 this.result="success";
        return "success";
    }
	
	public String queryforlist() throws Exception{
		try{
			Qybgxx setQybgxx=new Qybgxx();
			setQybgxx=(Qybgxx)this.setClass(setQybgxx, null);
			lQybgxx=qybgxxService.getListQybgxx(setQybgxx);
			setTabledata(lQybgxx);
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
			Qybgxx setQybgxx=new Qybgxx();
			setQybgxx=(Qybgxx)this.setClass(setQybgxx, null);
			setQybgxx=qybgxxService.getQybgxx(setQybgxx);
			lQybgxx.add(setQybgxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qybgxx setQybgxx=new Qybgxx();
			qybgxx=(Qybgxx)this.setClass(setQybgxx, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
        qybgxx=qybgxxService.insertQybgxx(qybgxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qybgxx setQybgxx=new Qybgxx();
			qybgxx=(Qybgxx)this.setClass(setQybgxx, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
        qybgxxService.updateQybgxx(qybgxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qybgxx setQybgxx=new Qybgxx();
			qybgxx=(Qybgxx)this.setClass(setQybgxx, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
        qybgxxService.deleteQybgxx(qybgxx);
        this.result="success";
        return "success";
    }
	
	public String queryListByGad() throws Exception{
		try{
			Qybgxx setQybgxx=new Qybgxx();
			setQybgxx=(Qybgxx)this.setClass(setQybgxx, null);
			Map map = new HashMap();
			queryMapTool(map, setQybgxx);
	        Page page = qybgxxService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage = page.getTotalPages();
	        totalrows = page.getTotalRows();
	        List temp = page.getData();
			setTabledataByGad(temp);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	public void queryMapTool(Map map,Qybgxx setQybgxx){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
		String gxdwbm = setQybgxx.getGxdwbm();
		depertCode0 = (gxdwbm!=null&&!"".equals(gxdwbm))?gxdwbm:depertCode0;
		
		map.put("hylbdm", "J"); //娱乐业
		map.put("qyzflbm", setQybgxx.getQyzflbm());
		map.put("qybm", setQybgxx.getQybm());
		map.put("gxdwbm", depertCode0);
		map.put("zjbh", setQybgxx.getZjbh());
		map.put("frdb", setQybgxx.getFrdb());
		map.put("jydz", setQybgxx.getJydz());
		map.put("bgdjxh", setQybgxx.getBgdjxh());
		map.put("bglxdm", setQybgxx.getBglxdm());
		map.put("bgyy", setQybgxx.getBgyy());
		map.put("bgrqf", setQybgxx.getBgrqf());
		map.put("bgrqt", setQybgxx.getBgrqt());
	}
	
}
