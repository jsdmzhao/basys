package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Zktjyb;
import com.aisino2.icksystem.service.IZktjybService;

public class ZktjybAction extends PageAction{
	private IZktjybService zktjybService;
	private List lZktjyb;
	private Zktjyb zktjyb;
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

	public Zktjyb getZktjyb() {
		return zktjyb;
	}
	
	public List getLZktjyb() {
		return lZktjyb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setZktjybService(IZktjybService zktjybService) {
		this.zktjybService = zktjybService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("zktjybid");
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
    	
    	Zktjyb getZktjyb=new Zktjyb();
    	
        this.setData(getZktjyb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Zktjyb setZktjyb=new Zktjyb();
        Map map = new HashMap();
        Page page = zktjybService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lZktjyb=page.getData();
        setTabledata(lZktjyb); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Zktjyb setZktjyb=new Zktjyb();
			zktjyb=(Zktjyb)this.setClass(setZktjyb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjyb=zktjybService.getZktjyb(zktjyb);
        lZktjyb.clear();
        lZktjyb.add(zktjyb);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Zktjyb setZktjyb=new Zktjyb();
			zktjyb=(Zktjyb)this.setClass(setZktjyb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjyb=zktjybService.insertZktjyb(zktjyb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Zktjyb setZktjyb=new Zktjyb();
			zktjyb=(Zktjyb)this.setClass(setZktjyb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjybService.updateZktjyb(zktjyb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Zktjyb setZktjyb=new Zktjyb();
			zktjyb=(Zktjyb)this.setClass(setZktjyb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zktjybService.deleteZktjyb(zktjyb);
        this.result="success";
        return "success";
    }
}