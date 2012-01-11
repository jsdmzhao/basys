package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyffl;
import com.aisino2.publicsystem.service.IQyfflService;

public class QyfflAction extends PageAction{
	private IQyfflService qyfflService;
	private List lQyffl=new ArrayList();
	private Qyffl qyffl=new Qyffl();
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

	public Qyffl getQyffl() {
		return qyffl;
	}
	
	public List getLQyffl() {
		return lQyffl;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyfflService(IQyfflService qyfflService) {
		this.qyfflService = qyfflService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyflid");
		lPro.add("qyid");
		lPro.add("qyflbm");
		lPro.add("sjcsflmc");
		lPro.add("qyflmc");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyffl getQyffl=new Qyffl();
    	
        this.setData(getQyffl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyffl setQyffl=new Qyffl();
        Map map = new HashMap();
        Page page = qyfflService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyffl=page.getData();
        setTabledata(lQyffl); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyffl setQyffl=new Qyffl();
			qyffl=(Qyffl)this.setClass(setQyffl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyffl=qyfflService.getQyffl(qyffl);
        lQyffl.clear();
        lQyffl.add(qyffl);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyffl setQyffl=new Qyffl();
			qyffl=(Qyffl)this.setClass(setQyffl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyffl=qyfflService.insertQyffl(qyffl);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyffl setQyffl=new Qyffl();
			qyffl=(Qyffl)this.setClass(setQyffl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyfflService.updateQyffl(qyffl);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyffl setQyffl=new Qyffl();
			qyffl=(Qyffl)this.setClass(setQyffl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyfflService.deleteQyffl(qyffl);
        this.result="success";
        return "success";
    }
}