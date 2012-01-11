package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Clxxwgryxx;
import com.aisino2.publicsystem.service.IClxxwgryxxService;

public class ClxxwgryxxAction extends PageAction{
	private IClxxwgryxxService clxxwgryxxService;
	private List lClxxwgryxx=new ArrayList();
	private Clxxwgryxx clxxwgryxx=new Clxxwgryxx();
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

	public Clxxwgryxx getClxxwgryxx() {
		return clxxwgryxx;
	}
	
	public List getLClxxwgryxx() {
		return lClxxwgryxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setClxxwgryxxService(IClxxwgryxxService clxxwgryxxService) {
		this.clxxwgryxxService = clxxwgryxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("cljbxxid");
		lPro.add("wgrxxid");
		lPro.add("wgrylb");
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
    	
    	Clxxwgryxx getClxxwgryxx=new Clxxwgryxx();
    	
        this.setData(getClxxwgryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Clxxwgryxx setClxxwgryxx=new Clxxwgryxx();
        Map map = new HashMap();
        Page page = clxxwgryxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lClxxwgryxx=page.getData();
        setTabledata(lClxxwgryxx); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Clxxwgryxx setClxxwgryxx=new Clxxwgryxx();
			clxxwgryxx=(Clxxwgryxx)this.setClass(setClxxwgryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxxwgryxx=clxxwgryxxService.getClxxwgryxx(clxxwgryxx);
        lClxxwgryxx.clear();
        lClxxwgryxx.add(clxxwgryxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Clxxwgryxx setClxxwgryxx=new Clxxwgryxx();
			clxxwgryxx=(Clxxwgryxx)this.setClass(setClxxwgryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxxwgryxx=clxxwgryxxService.insertClxxwgryxx(clxxwgryxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Clxxwgryxx setClxxwgryxx=new Clxxwgryxx();
			clxxwgryxx=(Clxxwgryxx)this.setClass(setClxxwgryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxxwgryxxService.updateClxxwgryxx(clxxwgryxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Clxxwgryxx setClxxwgryxx=new Clxxwgryxx();
			clxxwgryxx=(Clxxwgryxx)this.setClass(setClxxwgryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxxwgryxxService.deleteClxxwgryxx(clxxwgryxx);
        this.result="success";
        return "success";
    }
}