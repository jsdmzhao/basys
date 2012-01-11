package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Gzdx_kz;
import com.aisino2.basicsystem.service.IGzdx_kzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class Gzdx_kzAction extends PageAction{
	private IGzdx_kzService gzdx_kzService;
	private List lGzdx_kz;
	private Gzdx_kz gzdx_kz;
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

	public Gzdx_kz getGzdx_kz() {
		return gzdx_kz;
	}
	
	public List getLGzdx_kz() {
		return lGzdx_kz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setGzdx_kzService(IGzdx_kzService gzdx_kzService) {
		this.gzdx_kzService = gzdx_kzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("gzdxid");
		lPro.add("yjgzid");
		lPro.add("yjxxid");
		lPro.add("gzdxkzid");
		lPro.add("xm");
		lPro.add("bm");
		lPro.add("xmpy");
		lPro.add("mzdm");
		lPro.add("minzu");
		lPro.add("xbdm");
		lPro.add("xb");
		lPro.add("csrq");
		lPro.add("hjdxzqh");
		lPro.add("hjdxzqhdm");
		lPro.add("hjdxz");
		lPro.add("cyzjdm");
		lPro.add("cyzj");
		lPro.add("zjhm");
		lPro.add("whcd");
		lPro.add("gzdxsf");
		lPro.add("shengao");
		lPro.add("xzdq");
		lPro.add("xzdqxz");
		lPro.add("tbdw");
		lPro.add("tbr");
		lPro.add("tbrq");
		lPro.add("tbdabm");
		lPro.add("zxbz");
		lPro.add("zxrq");
		lPro.add("zxr");
		lPro.add("bz");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Gzdx_kz getGzdx_kz=new Gzdx_kz();
    	
        this.setData(getGzdx_kz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Gzdx_kz setGzdx_kz=new Gzdx_kz();
        Map map = new HashMap();
        Page page = gzdx_kzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lGzdx_kz=page.getData();
        setTabledata(lGzdx_kz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Gzdx_kz setGzdx_kz=new Gzdx_kz();
			gzdx_kz=(Gzdx_kz)this.setClass(setGzdx_kz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gzdx_kz=gzdx_kzService.getGzdx_kz(gzdx_kz);
        lGzdx_kz.clear();
        lGzdx_kz.add(gzdx_kz);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Gzdx_kz setGzdx_kz=new Gzdx_kz();
			gzdx_kz=(Gzdx_kz)this.setClass(setGzdx_kz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gzdx_kz=gzdx_kzService.insertGzdx_kz(gzdx_kz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Gzdx_kz setGzdx_kz=new Gzdx_kz();
			gzdx_kz=(Gzdx_kz)this.setClass(setGzdx_kz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gzdx_kzService.updateGzdx_kz(gzdx_kz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Gzdx_kz setGzdx_kz=new Gzdx_kz();
			gzdx_kz=(Gzdx_kz)this.setClass(setGzdx_kz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gzdx_kzService.deleteGzdx_kz(gzdx_kz);
        this.result="success";
        return "success";
    }
}