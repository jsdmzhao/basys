package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Bjgz;
import com.aisino2.basicsystem.service.IBjgzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class BjgzAction extends PageAction{
	private IBjgzService bjgzService;
	private List lBjgz;
	private Bjgz bjgz;
	private List lBjgzxx = new ArrayList();
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

	public Bjgz getBjgz() {
		return bjgz;
	}
	
	public List getLBjgz() {
		return lBjgz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBjgzService(IBjgzService bjgzService) {
		this.bjgzService = bjgzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjgzid");
		lPro.add("ywbm");
		lPro.add("bdbm");
		lPro.add("bdlx");
		lPro.add("sfyx");
		lPro.add("fbcl");
		lPro.add("fbfs");
		lPro.add("txdwzd");
		lPro.add("gxdwzd");
		lPro.add("bjjb");
		lPro.add("bjfs");
		lPro.add("bjlx");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Bjgz getBjgz=new Bjgz();
    	
        this.setData(getBjgz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Bjgz setBjgz=new Bjgz();
        Map map = new HashMap();
        Page page = bjgzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lBjgz=page.getData();
        setTabledata(lBjgz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Bjgz setBjgz=new Bjgz();
			bjgz=(Bjgz)this.setClass(setBjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bjgz=bjgzService.getBjgz(bjgz);
        lBjgz.clear();
        lBjgz.add(bjgz);
		this.result="success";
        return "success";
    }
	
	public String querysfyx() throws Exception{
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest requeset = ServletActionContext.getRequest();
			String bjgzid = requeset.getParameter("bjgzid");
			Bjgz setBjgz=new Bjgz();
			setBjgz.setBjgzid(Integer.parseInt(bjgzid.trim()));
			setBjgz=bjgzService.getBjgz(setBjgz);
			lBjgzxx.add(setBjgz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Bjgz setBjgz=new Bjgz();
			bjgz=(Bjgz)this.setClass(setBjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bjgz=bjgzService.insertBjgz(bjgz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bjgz setBjgz=new Bjgz();
			bjgz=(Bjgz)this.setClass(setBjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bjgzService.updateBjgz(bjgz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Bjgz setBjgz=new Bjgz();
			bjgz=(Bjgz)this.setClass(setBjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bjgzService.deleteBjgz(bjgz);
        this.result="success";
        return "success";
    }

	public List getLBjgzxx() {
		return lBjgzxx;
	}
}