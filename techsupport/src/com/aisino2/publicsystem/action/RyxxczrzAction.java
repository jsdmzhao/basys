package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Ryxxczrz;
import com.aisino2.publicsystem.service.IRyxxczrzService;

public class RyxxczrzAction extends PageAction{
	private IRyxxczrzService ryxxczrzService;
	private List lRyxxczrz=new ArrayList();
	private Ryxxczrz ryxxczrz=new Ryxxczrz();
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

	public Ryxxczrz getRyxxczrz() {
		return ryxxczrz;
	}
	
	public List getLRyxxczrz() {
		return lRyxxczrz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setRyxxczrzService(IRyxxczrzService ryxxczrzService) {
		this.ryxxczrzService = ryxxczrzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryxxczrzid");
		lPro.add("czsj");
		lPro.add("czlx");
		lPro.add("cznr");
		lPro.add("czr");
		lPro.add("qybm");
		lPro.add("cyrybh");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Ryxxczrz getRyxxczrz=new Ryxxczrz();
    	
        this.setData(getRyxxczrz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Ryxxczrz setRyxxczrz=new Ryxxczrz();
        Map map = new HashMap();
        Page page = ryxxczrzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lRyxxczrz=page.getData();
        setTabledata(lRyxxczrz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Ryxxczrz setRyxxczrz=new Ryxxczrz();
			ryxxczrz=(Ryxxczrz)this.setClass(setRyxxczrz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ryxxczrz=ryxxczrzService.getRyxxczrz(ryxxczrz);
        lRyxxczrz.clear();
        lRyxxczrz.add(ryxxczrz);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Ryxxczrz setRyxxczrz=new Ryxxczrz();
			ryxxczrz=(Ryxxczrz)this.setClass(setRyxxczrz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ryxxczrz=ryxxczrzService.insertRyxxczrz(ryxxczrz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Ryxxczrz setRyxxczrz=new Ryxxczrz();
			ryxxczrz=(Ryxxczrz)this.setClass(setRyxxczrz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ryxxczrzService.updateRyxxczrz(ryxxczrz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Ryxxczrz setRyxxczrz=new Ryxxczrz();
			ryxxczrz=(Ryxxczrz)this.setClass(setRyxxczrz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ryxxczrzService.deleteRyxxczrz(ryxxczrz);
        this.result="success";
        return "success";
    }
}