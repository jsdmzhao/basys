package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Zktjhjrb;
import com.aisino2.icksystem.service.IZktjhjrbService;

public class ZktjhjrbAction extends PageAction{
	private IZktjhjrbService zktjhjrbService;
	private List lZktjhjrb;
	private Zktjhjrb zktjhjrb;
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

	public Zktjhjrb getZktjhjrb() {
		return zktjhjrb;
	}
	
	public List getLZktjhjrb() {
		return lZktjhjrb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setZktjhjrbService(IZktjhjrbService zktjhjrbService) {
		this.zktjhjrbService = zktjhjrbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("zktjhzrbid");
		lPro.add("ylfwzagltjrq");
		lPro.add("ylfwzaglbm");
		lPro.add("ylfwzaglmc");
		lPro.add("zkzxbm");
		lPro.add("zkzxmc");
		lPro.add("tjkpzs");
		lPro.add("zzks");
		lPro.add("wzks");
		lPro.add("yzbs");
		lPro.add("yfss");
		lPro.add("yfks");
		lPro.add("czks");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Zktjhjrb getZktjhjrb=new Zktjhjrb();
    	
        this.setData(getZktjhjrb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Zktjhjrb setZktjhjrb=new Zktjhjrb();
        Map map = new HashMap();
        Page page = zktjhjrbService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lZktjhjrb=page.getData();
        setTabledata(lZktjhjrb); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Zktjhjrb setZktjhjrb=new Zktjhjrb();
			zktjhjrb=(Zktjhjrb)this.setClass(setZktjhjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjhjrb=zktjhjrbService.getZktjhjrb(zktjhjrb);
        lZktjhjrb.clear();
        lZktjhjrb.add(zktjhjrb);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Zktjhjrb setZktjhjrb=new Zktjhjrb();
			zktjhjrb=(Zktjhjrb)this.setClass(setZktjhjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjhjrb=zktjhjrbService.insertZktjhjrb(zktjhjrb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Zktjhjrb setZktjhjrb=new Zktjhjrb();
			zktjhjrb=(Zktjhjrb)this.setClass(setZktjhjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjhjrbService.updateZktjhjrb(zktjhjrb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Zktjhjrb setZktjhjrb=new Zktjhjrb();
			zktjhjrb=(Zktjhjrb)this.setClass(setZktjhjrb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjhjrbService.deleteZktjhjrb(zktjhjrb);
        this.result="success";
        return "success";
    }
}