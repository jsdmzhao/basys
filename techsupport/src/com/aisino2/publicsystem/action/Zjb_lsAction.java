package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Zjb_ls;
import com.aisino2.publicsystem.service.IZjb_lsService;

public class Zjb_lsAction extends PageAction{
	private IZjb_lsService zjb_lsService;
	private List lZjb_ls=new ArrayList();
	private Zjb_ls zjb_ls=new Zjb_ls();
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

	public Zjb_ls getZjb_ls() {
		return zjb_ls;
	}
	
	public List getLZjb_ls() {
		return lZjb_ls;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setZjb_lsService(IZjb_lsService zjb_lsService) {
		this.zjb_lsService = zjb_lsService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		lPro.add("qylsid");
		lPro.add("zjlsid");
		lPro.add("fk_zjid");
		lPro.add("zjfl");
		lPro.add("zjbh");
		lPro.add("fzjg");
		lPro.add("qsrq");
		lPro.add("jzrq");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Zjb_ls getZjb_ls=new Zjb_ls();
    	
        this.setData(getZjb_ls,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Zjb_ls setZjb_ls=new Zjb_ls();
        Map map = new HashMap();
        Page page = zjb_lsService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lZjb_ls=page.getData();
        setTabledata(lZjb_ls); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Zjb_ls setZjb_ls=new Zjb_ls();
			zjb_ls=(Zjb_ls)this.setClass(setZjb_ls, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zjb_ls=zjb_lsService.getZjb_ls(zjb_ls);
        lZjb_ls.clear();
        lZjb_ls.add(zjb_ls);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Zjb_ls setZjb_ls=new Zjb_ls();
			zjb_ls=(Zjb_ls)this.setClass(setZjb_ls, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zjb_ls=zjb_lsService.insertZjb_ls(zjb_ls);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Zjb_ls setZjb_ls=new Zjb_ls();
			zjb_ls=(Zjb_ls)this.setClass(setZjb_ls, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zjb_lsService.updateZjb_ls(zjb_ls);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Zjb_ls setZjb_ls=new Zjb_ls();
			zjb_ls=(Zjb_ls)this.setClass(setZjb_ls, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zjb_lsService.deleteZjb_ls(zjb_ls);
        this.result="success";
        return "success";
    }
}