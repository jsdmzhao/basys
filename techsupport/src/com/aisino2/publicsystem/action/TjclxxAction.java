package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Tjclxx;
import com.aisino2.publicsystem.service.ITjclxxService;

public class TjclxxAction extends PageAction{
	private ITjclxxService tjclxxService;
	private List lTjclxx=new ArrayList();
	private Tjclxx tjclxx=new Tjclxx();
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

	public Tjclxx getTjclxx() {
		return tjclxx;
	}
	
	public List getLTjclxx() {
		return lTjclxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setTjclxxService(ITjclxxService tjclxxService) {
		this.tjclxxService = tjclxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("tjclxxid");
		lPro.add("qyid");
		lPro.add("qybaxxid");
		lPro.add("tjcllxdm");
		lPro.add("tjcllx");
		lPro.add("tijiaorq");
		lPro.add("tjrxm");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Tjclxx getTjclxx=new Tjclxx();
    	
        this.setData(getTjclxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Tjclxx setTjclxx=new Tjclxx();
        Map map = new HashMap();
        Page page = tjclxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lTjclxx=page.getData();
        setTabledata(lTjclxx); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Tjclxx setTjclxx=new Tjclxx();
			tjclxx=(Tjclxx)this.setClass(setTjclxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tjclxx=tjclxxService.getTjclxx(tjclxx);
        lTjclxx.clear();
        lTjclxx.add(tjclxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Tjclxx setTjclxx=new Tjclxx();
			tjclxx=(Tjclxx)this.setClass(setTjclxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tjclxx=tjclxxService.insertTjclxx(tjclxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Tjclxx setTjclxx=new Tjclxx();
			tjclxx=(Tjclxx)this.setClass(setTjclxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tjclxxService.updateTjclxx(tjclxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Tjclxx setTjclxx=new Tjclxx();
			tjclxx=(Tjclxx)this.setClass(setTjclxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tjclxxService.deleteTjclxx(tjclxx);
        this.result="success";
        return "success";
    }
}