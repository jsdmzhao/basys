package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyzjb;
import com.aisino2.publicsystem.service.IQyzjbService;

public class QyzjbAction extends PageAction{
	private IQyzjbService qyzjbService;
	private List lQyzjb=new ArrayList();
	private Qyzjb qyzjb=new Qyzjb();
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

	public Qyzjb getQyzjb() {
		return qyzjb;
	}
	
	public List getLQyzjb() {
		return lQyzjb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyzjbService(IQyzjbService qyzjbService) {
		this.qyzjbService = qyzjbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("zjid");
		lPro.add("qyid");
		lPro.add("zjfl");
		lPro.add("zjbh");
		lPro.add("fzjg");
		lPro.add("qsrq");
		lPro.add("jzrq");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyzjb getQyzjb=new Qyzjb();
    	
        this.setData(getQyzjb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyzjb setQyzjb=new Qyzjb();
        Map map = new HashMap();
        Page page = qyzjbService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyzjb=page.getData();
        setTabledata(lQyzjb); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyzjb setQyzjb=new Qyzjb();
			qyzjb=(Qyzjb)this.setClass(setQyzjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyzjb=qyzjbService.getQyzjb(qyzjb);
        lQyzjb.clear();
        lQyzjb.add(qyzjb);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyzjb setQyzjb=new Qyzjb();
			qyzjb=(Qyzjb)this.setClass(setQyzjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyzjb=qyzjbService.insertQyzjb(qyzjb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyzjb setQyzjb=new Qyzjb();
			qyzjb=(Qyzjb)this.setClass(setQyzjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyzjbService.updateQyzjb(qyzjb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyzjb setQyzjb=new Qyzjb();
			qyzjb=(Qyzjb)this.setClass(setQyzjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyzjbService.deleteQyzjb(qyzjb);
        this.result="success";
        return "success";
    }
}