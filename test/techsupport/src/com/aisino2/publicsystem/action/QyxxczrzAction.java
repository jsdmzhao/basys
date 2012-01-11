package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyxxczrz;
import com.aisino2.publicsystem.service.IQyxxczrzService;

public class QyxxczrzAction extends PageAction{
	private IQyxxczrzService qyxxczrzService;
	private List lQyxxczrz=new ArrayList();
	private Qyxxczrz qyxxczrz=new Qyxxczrz();
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

	public Qyxxczrz getQyxxczrz() {
		return qyxxczrz;
	}
	
	public List getLQyxxczrz() {
		return lQyxxczrz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyxxczrzService(IQyxxczrzService qyxxczrzService) {
		this.qyxxczrzService = qyxxczrzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyxxczrzid");
		lPro.add("czsj");
		lPro.add("czlx");
		lPro.add("cznr");
		lPro.add("czr");
		lPro.add("qybm");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyxxczrz getQyxxczrz=new Qyxxczrz();
    	
        this.setData(getQyxxczrz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyxxczrz setQyxxczrz=new Qyxxczrz();
        Map map = new HashMap();
        Page page = qyxxczrzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyxxczrz=page.getData();
        setTabledata(lQyxxczrz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyxxczrz setQyxxczrz=new Qyxxczrz();
			qyxxczrz=(Qyxxczrz)this.setClass(setQyxxczrz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyxxczrz=qyxxczrzService.getQyxxczrz(qyxxczrz);
        lQyxxczrz.clear();
        lQyxxczrz.add(qyxxczrz);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyxxczrz setQyxxczrz=new Qyxxczrz();
			qyxxczrz=(Qyxxczrz)this.setClass(setQyxxczrz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyxxczrz=qyxxczrzService.insertQyxxczrz(qyxxczrz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyxxczrz setQyxxczrz=new Qyxxczrz();
			qyxxczrz=(Qyxxczrz)this.setClass(setQyxxczrz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyxxczrzService.updateQyxxczrz(qyxxczrz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyxxczrz setQyxxczrz=new Qyxxczrz();
			qyxxczrz=(Qyxxczrz)this.setClass(setQyxxczrz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyxxczrzService.deleteQyxxczrz(qyxxczrz);
        this.result="success";
        return "success";
    }
}