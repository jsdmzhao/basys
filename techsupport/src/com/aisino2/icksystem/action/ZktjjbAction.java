package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Zktjjb;
import com.aisino2.icksystem.service.IZktjjbService;

public class ZktjjbAction extends PageAction{
	private IZktjjbService zktjjbService;
	private List lZktjjb;
	private Zktjjb zktjjb;
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

	public Zktjjb getZktjjb() {
		return zktjjb;
	}
	
	public List getLZktjjb() {
		return lZktjjb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setZktjjbService(IZktjjbService zktjjbService) {
		this.zktjjbService = zktjjbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("zktjjbid");
		lPro.add("ylfwzagltjrq");
		lPro.add("ylfwzaglbm");
		lPro.add("ylfwzaglmc");
		lPro.add("zkzxbm");
		lPro.add("zkzxmc");
		lPro.add("zks");
		lPro.add("yss");
		lPro.add("cys");
		lPro.add("dycws");
		lPro.add("sfcws");
		lPro.add("ckcws");
		lPro.add("kpshs");
		lPro.add("wnjss");
		lPro.add("qt");
		lPro.add("dxrcws");
		lPro.add("pjzkl");
		lPro.add("pjfkl");
		lPro.add("fkl");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Zktjjb getZktjjb=new Zktjjb();
    	
        this.setData(getZktjjb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Zktjjb setZktjjb=new Zktjjb();
        Map map = new HashMap();
        Page page = zktjjbService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lZktjjb=page.getData();
        setTabledata(lZktjjb); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Zktjjb setZktjjb=new Zktjjb();
			zktjjb=(Zktjjb)this.setClass(setZktjjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjjb=zktjjbService.getZktjjb(zktjjb);
        lZktjjb.clear();
        lZktjjb.add(zktjjb);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Zktjjb setZktjjb=new Zktjjb();
			zktjjb=(Zktjjb)this.setClass(setZktjjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjjb=zktjjbService.insertZktjjb(zktjjb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Zktjjb setZktjjb=new Zktjjb();
			zktjjb=(Zktjjb)this.setClass(setZktjjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjjbService.updateZktjjb(zktjjb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Zktjjb setZktjjb=new Zktjjb();
			zktjjb=(Zktjjb)this.setClass(setZktjjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjjbService.deleteZktjjb(zktjjb);
        this.result="success";
        return "success";
    }
}