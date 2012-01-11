package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.basicsystem.service.IWpbjgzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class WpbjgzAction extends PageAction{
	private IWpbjgzService wpbjgzService;
	private List lWpbjgz=new ArrayList();
	private Wpbjgz wpbjgz=new Wpbjgz();
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

	public Wpbjgz getWpbjgz() {
		return wpbjgz;
	}
	
	public List getLWpbjgz() {
		return lWpbjgz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setWpbjgzService(IWpbjgzService wpbjgzService) {
		this.wpbjgzService = wpbjgzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjxxid2");
		lPro.add("wpbjgzid");
		lPro.add("ywbm");
		lPro.add("ywbzdm");
		lPro.add("bdbm");
		lPro.add("bdbzdm");
		lPro.add("bdlxdm");
		lPro.add("bdlx");
		lPro.add("sfyx");
		lPro.add("fbcl");
		lPro.add("fbfs");
		lPro.add("txdwzd");
		lPro.add("gxdwzd");
		lPro.add("bjjb");
		lPro.add("bjfs");
		lPro.add("bjlxdm");
		lPro.add("bjlx");
		lPro.add("hylbdm");
		lPro.add("hylb");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Wpbjgz getWpbjgz=new Wpbjgz();
    	
        this.setData(getWpbjgz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Wpbjgz setWpbjgz=new Wpbjgz();
        Map map = new HashMap();
        Page page = wpbjgzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lWpbjgz=page.getData();
        setTabledata(lWpbjgz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Wpbjgz setWpbjgz=new Wpbjgz();
			wpbjgz=(Wpbjgz)this.setClass(setWpbjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjgz=wpbjgzService.getWpbjgz(wpbjgz);
        lWpbjgz.clear();
        lWpbjgz.add(wpbjgz);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Wpbjgz setWpbjgz=new Wpbjgz();
			wpbjgz=(Wpbjgz)this.setClass(setWpbjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjgz=wpbjgzService.insertWpbjgz(wpbjgz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Wpbjgz setWpbjgz=new Wpbjgz();
			wpbjgz=(Wpbjgz)this.setClass(setWpbjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjgzService.updateWpbjgz(wpbjgz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Wpbjgz setWpbjgz=new Wpbjgz();
			wpbjgz=(Wpbjgz)this.setClass(setWpbjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjgzService.deleteWpbjgz(wpbjgz);
        this.result="success";
        return "success";
    }
}