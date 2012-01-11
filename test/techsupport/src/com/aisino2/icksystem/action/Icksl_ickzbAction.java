package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Icksl_ickzb;
import com.aisino2.icksystem.service.IIcksl_ickzbService;

public class Icksl_ickzbAction extends PageAction{
	private IIcksl_ickzbService icksl_ickzbService;
	private List lIcksl_ickzb;
	private Icksl_ickzb icksl_ickzb;
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

	public Icksl_ickzb getIcksl_ickzb() {
		return icksl_ickzb;
	}
	
	public List getLIcksl_ickzb() {
		return lIcksl_ickzb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setIcksl_ickzbService(IIcksl_ickzbService icksl_ickzbService) {
		this.icksl_ickzbService = icksl_ickzbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("ickslid");
		lPro.add("zbid");
		lPro.add("pczdpbh");
		lPro.add("zbhsuym");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Icksl_ickzb getIcksl_ickzb=new Icksl_ickzb();
    	
        this.setData(getIcksl_ickzb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Icksl_ickzb setIcksl_ickzb=new Icksl_ickzb();
        Map map = new HashMap();
        Page page = icksl_ickzbService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lIcksl_ickzb=page.getData();
        setTabledata(lIcksl_ickzb); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Icksl_ickzb setIcksl_ickzb=new Icksl_ickzb();
			icksl_ickzb=(Icksl_ickzb)this.setClass(setIcksl_ickzb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksl_ickzb=icksl_ickzbService.getIcksl_ickzb(icksl_ickzb);
        lIcksl_ickzb.clear();
        lIcksl_ickzb.add(icksl_ickzb);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Icksl_ickzb setIcksl_ickzb=new Icksl_ickzb();
			icksl_ickzb=(Icksl_ickzb)this.setClass(setIcksl_ickzb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksl_ickzb=icksl_ickzbService.insertIcksl_ickzb(icksl_ickzb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Icksl_ickzb setIcksl_ickzb=new Icksl_ickzb();
			icksl_ickzb=(Icksl_ickzb)this.setClass(setIcksl_ickzb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksl_ickzbService.updateIcksl_ickzb(icksl_ickzb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Icksl_ickzb setIcksl_ickzb=new Icksl_ickzb();
			icksl_ickzb=(Icksl_ickzb)this.setClass(setIcksl_ickzb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksl_ickzbService.deleteIcksl_ickzb(icksl_ickzb);
        this.result="success";
        return "success";
    }
}