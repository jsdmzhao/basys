package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Zktjrb;
import com.aisino2.icksystem.service.IZktjrbService;

public class ZktjrbAction extends PageAction{
	private IZktjrbService zktjrbService;
	private List lZktjrb;
	private Zktjrb zktjrb;
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

	public Zktjrb getZktjrb() {
		return zktjrb;
	}
	
	public List getLZktjrb() {
		return lZktjrb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setZktjrbService(IZktjrbService zktjrbService) {
		this.zktjrbService = zktjrbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("zktjrbid");
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
    	
    	Zktjrb getZktjrb=new Zktjrb();
    	
        this.setData(getZktjrb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Zktjrb setZktjrb=new Zktjrb();
        Map map = new HashMap();
        Page page = zktjrbService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lZktjrb=page.getData();
        setTabledata(lZktjrb); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Zktjrb setZktjrb=new Zktjrb();
			zktjrb=(Zktjrb)this.setClass(setZktjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjrb=zktjrbService.getZktjrb(zktjrb);
        lZktjrb.clear();
        lZktjrb.add(zktjrb);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Zktjrb setZktjrb=new Zktjrb();
			zktjrb=(Zktjrb)this.setClass(setZktjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjrb=zktjrbService.insertZktjrb(zktjrb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Zktjrb setZktjrb=new Zktjrb();
			zktjrb=(Zktjrb)this.setClass(setZktjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjrbService.updateZktjrb(zktjrb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Zktjrb setZktjrb=new Zktjrb();
			zktjrb=(Zktjrb)this.setClass(setZktjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjrbService.deleteZktjrb(zktjrb);
        this.result="success";
        return "success";
    }
}