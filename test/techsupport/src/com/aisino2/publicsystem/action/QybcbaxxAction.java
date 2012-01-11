package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qybcbaxx;
import com.aisino2.publicsystem.service.IQybcbaxxService;

public class QybcbaxxAction extends PageAction{
	private IQybcbaxxService qybcbaxxService;
	private List lQybcbaxx=new ArrayList();
	private Qybcbaxx qybcbaxx=new Qybcbaxx();
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

	public Qybcbaxx getQybcbaxx() {
		return qybcbaxx;
	}
	
	public List getLQybcbaxx() {
		return lQybcbaxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQybcbaxxService(IQybcbaxxService qybcbaxxService) {
		this.qybcbaxxService = qybcbaxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		lPro.add("qybaxxid");
		lPro.add("bbgzrq");
		lPro.add("bbyy");
		lPro.add("bbwcrq");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qybcbaxx getQybcbaxx=new Qybcbaxx();
    	
        this.setData(getQybcbaxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qybcbaxx setQybcbaxx=new Qybcbaxx();
        Map map = new HashMap();
        Page page = qybcbaxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQybcbaxx=page.getData();
        setTabledata(lQybcbaxx); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qybcbaxx setQybcbaxx=new Qybcbaxx();
			qybcbaxx=(Qybcbaxx)this.setClass(setQybcbaxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qybcbaxx=qybcbaxxService.getQybcbaxx(qybcbaxx);
        lQybcbaxx.clear();
        lQybcbaxx.add(qybcbaxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qybcbaxx setQybcbaxx=new Qybcbaxx();
			qybcbaxx=(Qybcbaxx)this.setClass(setQybcbaxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qybcbaxx=qybcbaxxService.insertQybcbaxx(qybcbaxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qybcbaxx setQybcbaxx=new Qybcbaxx();
			qybcbaxx=(Qybcbaxx)this.setClass(setQybcbaxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qybcbaxxService.updateQybcbaxx(qybcbaxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qybcbaxx setQybcbaxx=new Qybcbaxx();
			qybcbaxx=(Qybcbaxx)this.setClass(setQybcbaxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qybcbaxxService.deleteQybcbaxx(qybcbaxx);
        this.result="success";
        return "success";
    }
}