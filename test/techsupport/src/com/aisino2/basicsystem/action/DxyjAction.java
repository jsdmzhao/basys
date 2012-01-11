package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Dxyj;
import com.aisino2.basicsystem.service.IDxyjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class DxyjAction extends PageAction{
	private IDxyjService dxyjService;
	private List lDxyj;
	private Dxyj dxyj;
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

	public Dxyj getDxyj() {
		return dxyj;
	}
	
	public List getLDxyj() {
		return lDxyj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setDxyjService(IDxyjService dxyjService) {
		this.dxyjService = dxyjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("yjgzid");
		lPro.add("yjxxid");
		lPro.add("dxyjid");
		lPro.add("dxhm");
		lPro.add("dycfssj");
		lPro.add("zhycfssj");
		lPro.add("fscs");
		lPro.add("dxzt");
		lPro.add("dxnr");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Dxyj getDxyj=new Dxyj();
    	
        this.setData(getDxyj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Dxyj setDxyj=new Dxyj();
        Map map = new HashMap();
        Page page = dxyjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lDxyj=page.getData();
        setTabledata(lDxyj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Dxyj setDxyj=new Dxyj();
			dxyj=(Dxyj)this.setClass(setDxyj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dxyj=dxyjService.getDxyj(dxyj);
        lDxyj.clear();
        lDxyj.add(dxyj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Dxyj setDxyj=new Dxyj();
			dxyj=(Dxyj)this.setClass(setDxyj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dxyj=dxyjService.insertDxyj(dxyj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Dxyj setDxyj=new Dxyj();
			dxyj=(Dxyj)this.setClass(setDxyj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dxyjService.updateDxyj(dxyj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Dxyj setDxyj=new Dxyj();
			dxyj=(Dxyj)this.setClass(setDxyj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dxyjService.deleteDxyj(dxyj);
        this.result="success";
        return "success";
    }
}