package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Wgkhxx;
import com.aisino2.publicsystem.service.IWgkhxxService;

public class WgkhxxAction extends PageAction{
	private IWgkhxxService wgkhxxService;
	private List lWgkhxx=new ArrayList();
	private Wgkhxx wgkhxx=new Wgkhxx();
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

	public Wgkhxx getWgkhxx() {
		return wgkhxx;
	}
	
	public List getLWgkhxx() {
		return lWgkhxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setWgkhxxService(IWgkhxxService wgkhxxService) {
		this.wgkhxxService = wgkhxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("khxxid");
		lPro.add("ywx");
		lPro.add("ywm");
		lPro.add("qzzldm");
		lPro.add("qzzl");
		lPro.add("qzhm");
		lPro.add("zatlq");
		lPro.add("qfjg");
		lPro.add("rjrq");
		lPro.add("rjka");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Wgkhxx getWgkhxx=new Wgkhxx();
    	
        this.setData(getWgkhxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Wgkhxx setWgkhxx=new Wgkhxx();
        Map map = new HashMap();
        Page page = wgkhxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lWgkhxx=page.getData();
        setTabledata(lWgkhxx); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Wgkhxx setWgkhxx=new Wgkhxx();
			wgkhxx=(Wgkhxx)this.setClass(setWgkhxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wgkhxx=wgkhxxService.getWgkhxx(wgkhxx);
        lWgkhxx.clear();
        lWgkhxx.add(wgkhxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Wgkhxx setWgkhxx=new Wgkhxx();
			wgkhxx=(Wgkhxx)this.setClass(setWgkhxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wgkhxx=wgkhxxService.insertWgkhxx(wgkhxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Wgkhxx setWgkhxx=new Wgkhxx();
			wgkhxx=(Wgkhxx)this.setClass(setWgkhxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wgkhxxService.updateWgkhxx(wgkhxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Wgkhxx setWgkhxx=new Wgkhxx();
			wgkhxx=(Wgkhxx)this.setClass(setWgkhxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wgkhxxService.deleteWgkhxx(wgkhxx);
        this.result="success";
        return "success";
    }
}