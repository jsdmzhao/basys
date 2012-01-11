package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.service.IQyry_zpService;

public class Qyry_zpAction extends PageAction{
	private IQyry_zpService qyry_zpService;
	private List lQyry_zp=new ArrayList();
	private Qyry_zp qyry_zp=new Qyry_zp();
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

	public Qyry_zp getQyry_zp() {
		return qyry_zp;
	}
	
	public List getLQyry_zp() {
		return lQyry_zp;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyry_zpService(IQyry_zpService qyry_zpService) {
		this.qyry_zpService = qyry_zpService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		lPro.add("ryid");
		lPro.add("zpid");
		lPro.add("tpmc");
		lPro.add("tplx");
		lPro.add("tpnr");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyry_zp getQyry_zp=new Qyry_zp();
    	
        this.setData(getQyry_zp,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyry_zp setQyry_zp=new Qyry_zp();
        Map map = new HashMap();
        Page page = qyry_zpService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyry_zp=page.getData();
        setTabledata(lQyry_zp); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyry_zp setQyry_zp=new Qyry_zp();
			qyry_zp=(Qyry_zp)this.setClass(setQyry_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyry_zp=qyry_zpService.getQyry_zp(qyry_zp);
        lQyry_zp.clear();
        lQyry_zp.add(qyry_zp);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyry_zp setQyry_zp=new Qyry_zp();
			qyry_zp=(Qyry_zp)this.setClass(setQyry_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyry_zp=qyry_zpService.insertQyry_zp(qyry_zp);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyry_zp setQyry_zp=new Qyry_zp();
			qyry_zp=(Qyry_zp)this.setClass(setQyry_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyry_zpService.updateQyry_zp(qyry_zp);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyry_zp setQyry_zp=new Qyry_zp();
			qyry_zp=(Qyry_zp)this.setClass(setQyry_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyry_zpService.deleteQyry_zp(qyry_zp);
        this.result="success";
        return "success";
    }
}