package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Icksltj;
import com.aisino2.icksystem.service.IIcksltjService;

public class IcksltjAction extends PageAction{
	private IIcksltjService icksltjService;
	private List lIcksltj;
	private Icksltj icksltj;
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

	public Icksltj getIcksltj() {
		return icksltj;
	}
	
	public List getLIcksltj() {
		return lIcksltj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setIcksltjService(IIcksltjService icksltjService) {
		this.icksltjService = icksltjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("icksltjid");
		lPro.add("dsjgdm");
		lPro.add("dsjgmc");
		lPro.add("fxjdm");
		lPro.add("fxjmc");
		lPro.add("gxdwdm");
		lPro.add("gxdwmc");
		lPro.add("csmc");
		lPro.add("csbm");
		lPro.add("dqzzrs");
		lPro.add("yslrs");
		lPro.add("ffs");
		lPro.add("zt");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Icksltj getIcksltj=new Icksltj();
    	
        this.setData(getIcksltj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Icksltj setIcksltj=new Icksltj();
        Map map = new HashMap();
        Page page = icksltjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lIcksltj=page.getData();
        setTabledata(lIcksltj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Icksltj setIcksltj=new Icksltj();
			icksltj=(Icksltj)this.setClass(setIcksltj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksltj=icksltjService.getIcksltj(icksltj);
        lIcksltj.clear();
        lIcksltj.add(icksltj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Icksltj setIcksltj=new Icksltj();
			icksltj=(Icksltj)this.setClass(setIcksltj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksltj=icksltjService.insertIcksltj(icksltj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Icksltj setIcksltj=new Icksltj();
			icksltj=(Icksltj)this.setClass(setIcksltj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksltjService.updateIcksltj(icksltj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Icksltj setIcksltj=new Icksltj();
			icksltj=(Icksltj)this.setClass(setIcksltj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksltjService.deleteIcksltj(icksltj);
        this.result="success";
        return "success";
    }
}