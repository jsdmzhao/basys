package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Yjgz;
import com.aisino2.basicsystem.service.IYjgzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class YjgzAction extends PageAction{
	private IYjgzService yjgzService;
	private List lYjgz;
	private Yjgz yjgz;
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

	public Yjgz getYjgz() {
		return yjgz;
	}
	
	public List getLYjgz() {
		return lYjgz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setYjgzService(IYjgzService yjgzService) {
		this.yjgzService = yjgzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("yjgzid");
		lPro.add("ywbm");
		lPro.add("bdbm");
		lPro.add("bdlx");
		lPro.add("sfyx");
		lPro.add("fbcl");
		lPro.add("fbfs");
		lPro.add("txdwzd");
		lPro.add("gxdwzd");
		lPro.add("yjjb");
		lPro.add("yjfs");
		lPro.add("yjlx");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Yjgz getYjgz=new Yjgz();
    	
        this.setData(getYjgz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Yjgz setYjgz=new Yjgz();
        Map map = new HashMap();
        Page page = yjgzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lYjgz=page.getData();
        setTabledata(lYjgz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Yjgz setYjgz=new Yjgz();
			yjgz=(Yjgz)this.setClass(setYjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjgz=yjgzService.getYjgz(yjgz);
        lYjgz.clear();
        lYjgz.add(yjgz);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Yjgz setYjgz=new Yjgz();
			yjgz=(Yjgz)this.setClass(setYjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjgz=yjgzService.insertYjgz(yjgz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Yjgz setYjgz=new Yjgz();
			yjgz=(Yjgz)this.setClass(setYjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjgzService.updateYjgz(yjgz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Yjgz setYjgz=new Yjgz();
			yjgz=(Yjgz)this.setClass(setYjgz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjgzService.deleteYjgz(yjgz);
        this.result="success";
        return "success";
    }
}