package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyrysh;
import com.aisino2.publicsystem.service.IQyryshService;

public class QyryshAction extends PageAction{
	private IQyryshService qyryshService;
	private List lQyrysh=new ArrayList();
	private Qyrysh qyrysh=new Qyrysh();
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

	public Qyrysh getQyrysh() {
		return qyrysh;
	}
	
	public List getLQyrysh() {
		return lQyrysh;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyryshService(IQyryshService qyryshService) {
		this.qyryshService = qyryshService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryshid");
		lPro.add("qyid");
		lPro.add("ryid");
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
    	
    	Qyrysh getQyrysh=new Qyrysh();
    	
        this.setData(getQyrysh,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyrysh setQyrysh=new Qyrysh();
        Map map = new HashMap();
        Page page = qyryshService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyrysh=page.getData();
        setTabledata(lQyrysh); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyrysh setQyrysh=new Qyrysh();
			qyrysh=(Qyrysh)this.setClass(setQyrysh, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyrysh=qyryshService.getQyrysh(qyrysh);
        lQyrysh.clear();
        lQyrysh.add(qyrysh);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyrysh setQyrysh=new Qyrysh();
			qyrysh=(Qyrysh)this.setClass(setQyrysh, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyrysh=qyryshService.insertQyrysh(qyrysh);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyrysh setQyrysh=new Qyrysh();
			qyrysh=(Qyrysh)this.setClass(setQyrysh, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryshService.updateQyrysh(qyrysh);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyrysh setQyrysh=new Qyrysh();
			qyrysh=(Qyrysh)this.setClass(setQyrysh, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryshService.deleteQyrysh(qyrysh);
        this.result="success";
        return "success";
    }
}