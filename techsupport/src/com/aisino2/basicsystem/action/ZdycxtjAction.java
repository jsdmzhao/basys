package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Zdycxtj;
import com.aisino2.basicsystem.service.IZdycxtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class ZdycxtjAction extends PageAction{
	private IZdycxtjService zdycxtjService;
	private List lZdycxtj=new ArrayList();
	private Zdycxtj zdycxtj=new Zdycxtj();
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

	public Zdycxtj getZdycxtj() {
		return zdycxtj;
	}
	
	public List getLZdycxtj() {
		return lZdycxtj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setZdycxtjService(IZdycxtjService zdycxtjService) {
		this.zdycxtjService = zdycxtjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("zdycxtjid");
		lPro.add("gjcxfaid");
		lPro.add("cxtj");
		lPro.add("cxpx");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Zdycxtj getZdycxtj=new Zdycxtj();
    	
        this.setData(getZdycxtj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Zdycxtj setZdycxtj=new Zdycxtj();
        Map map = new HashMap();
        Page page = zdycxtjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lZdycxtj=page.getData();
        setTabledata(lZdycxtj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Zdycxtj setZdycxtj=new Zdycxtj();
			zdycxtj=(Zdycxtj)this.setClass(setZdycxtj, null);
	        zdycxtj=zdycxtjService.getZdycxtj(zdycxtj);
	        lZdycxtj.clear();
	        lZdycxtj.add(zdycxtj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Zdycxtj setZdycxtj=new Zdycxtj();
			zdycxtj=(Zdycxtj)this.setClass(setZdycxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zdycxtj=zdycxtjService.insertZdycxtj(zdycxtj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Zdycxtj setZdycxtj=new Zdycxtj();
			zdycxtj=(Zdycxtj)this.setClass(setZdycxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zdycxtjService.updateZdycxtj(zdycxtj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Zdycxtj setZdycxtj=new Zdycxtj();
			zdycxtj=(Zdycxtj)this.setClass(setZdycxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zdycxtjService.deleteZdycxtj(zdycxtj);
        this.result="success";
        return "success";
    }
}