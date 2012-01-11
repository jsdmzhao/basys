package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qysh;
import com.aisino2.publicsystem.service.IQyshService;

public class QyshAction extends PageAction{
	private IQyshService qyshService;
	private List lQysh=new ArrayList();
	private Qysh qysh=new Qysh();
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

	public Qysh getQysh() {
		return qysh;
	}
	
	public List getLQysh() {
		return lQysh;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyshService(IQyshService qyshService) {
		this.qyshService = qyshService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyshid");
		lPro.add("qyid");
		lPro.add("shsj");
		lPro.add("shr");
		lPro.add("shdwdm");
		lPro.add("shdwmc");
		lPro.add("shsbyy");
		lPro.add("sjshid");
		lPro.add("shzt");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qysh getQysh=new Qysh();
    	
        this.setData(getQysh,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qysh setQysh=new Qysh();
        Map map = new HashMap();
        Page page = qyshService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQysh=page.getData();
        setTabledata(lQysh); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qysh setQysh=new Qysh();
			qysh=(Qysh)this.setClass(setQysh, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qysh=qyshService.getQysh(qysh);
        lQysh.clear();
        lQysh.add(qysh);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qysh setQysh=new Qysh();
			qysh=(Qysh)this.setClass(setQysh, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qysh=qyshService.insertQysh(qysh);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qysh setQysh=new Qysh();
			qysh=(Qysh)this.setClass(setQysh, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyshService.updateQysh(qysh);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qysh setQysh=new Qysh();
			qysh=(Qysh)this.setClass(setQysh, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyshService.deleteQysh(qysh);
        this.result="success";
        return "success";
    }
}