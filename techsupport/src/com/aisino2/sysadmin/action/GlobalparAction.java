package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IGlobalparService;

public class GlobalparAction extends PageAction{
	private IGlobalparService globalparService;
	private List lGlobalpar = new ArrayList();
	private Globalpar globalpar;
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

	public Globalpar getGlobalpar() {
		return globalpar;
	}
	
	public List getLGlobalpar() {
		return lGlobalpar;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setGlobalparService(IGlobalparService globalparService) {
		this.globalparService = globalparService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("globalparcode");
		lPro.add("globalparcode");
		lPro.add("globalparname");
		lPro.add("globalparvalue");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lDel);
    	
    	Globalpar getGlobalpar=new Globalpar();
    	
        this.setData(getGlobalpar,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Globalpar setGlobalpar=new Globalpar();
        try{
        	globalpar = (Globalpar)this.setClass(setGlobalpar, null);
        }catch(Exception e){
        	e.printStackTrace();
        }
        Map map = new HashMap();
        if(globalpar!=null){
        	if(globalpar.getGlobalparcode()!=null&&!globalpar.getGlobalparcode().equals(""))
        		map.put("globalparcode", globalpar.getGlobalparcode());
        	if(globalpar.getGlobalparname()!=null&&!globalpar.getGlobalparname().equals(""))
        		map.put("globalparname", globalpar.getGlobalparname());
        }
        Page page = globalparService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lGlobalpar=page.getData();
        setTabledata(lGlobalpar); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Globalpar setGlobalpar=new Globalpar();
			globalpar=(Globalpar)this.setClass(setGlobalpar, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        globalpar=globalparService.getGlobalpar(globalpar);
        lGlobalpar = new ArrayList();
       
        lGlobalpar.add(globalpar);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Globalpar setGlobalpar=new Globalpar();
			globalpar=(Globalpar)this.setClass(setGlobalpar, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Globalpar isGlobalpar = globalparService.getGlobalpar(globalpar);
		
		if(isGlobalpar==null){
			globalpar=globalparService.insertGlobalpar(globalpar);
			this.result="success";
		}else{
			this.result="参数编码已存在！";
		}
		return "success";
    }
	
	public String modify() throws Exception{
		try {
			Globalpar setGlobalpar=new Globalpar();
			globalpar=(Globalpar)this.setClass(setGlobalpar, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        globalparService.updateGlobalpar(globalpar);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Globalpar setGlobalpar=new Globalpar();
			globalpar=(Globalpar)this.setClass(setGlobalpar, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        globalparService.deleteGlobalpar(globalpar);
        this.result="success";
        return "success";
    }
	
	//检查网闸状态
	public String checkWzzt() throws Exception{
		try {
			Globalpar setGlobalpar=new Globalpar();
			globalpar=(Globalpar)this.setClass(setGlobalpar, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        globalpar=globalparService.getGlobalpar(globalpar);

        int sessionShiFouGuoQi = 0;
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		if(user==null)sessionShiFouGuoQi = 1;
        lGlobalpar.add(globalpar);
        lGlobalpar.add(sessionShiFouGuoQi);
		this.result="success";
        return "success";
    }
}