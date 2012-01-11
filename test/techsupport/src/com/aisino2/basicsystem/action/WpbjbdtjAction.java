package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Wpbjbdtj;
import com.aisino2.basicsystem.service.IWpbjbdtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class WpbjbdtjAction extends PageAction{
	private IWpbjbdtjService wpbjbdtjService;
	private List lWpbjbdtj=new ArrayList();
	private Wpbjbdtj wpbjbdtj=new Wpbjbdtj();
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

	public Wpbjbdtj getWpbjbdtj() {
		return wpbjbdtj;
	}
	
	public List getLWpbjbdtj() {
		return lWpbjbdtj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setWpbjbdtjService(IWpbjbdtjService wpbjbdtjService) {
		this.wpbjbdtjService = wpbjbdtjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjxxid2");
		lPro.add("wpbjgzid");
		lPro.add("wpbjbdtjid");
		lPro.add("tjlx");
		lPro.add("ywbzdm");
		lPro.add("bdbzdm");
		lPro.add("bdgx");
		lPro.add("gxc");
		lPro.add("zxsx");
		lPro.add("ljgx");
		lPro.add("jibie");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Wpbjbdtj getWpbjbdtj=new Wpbjbdtj();
    	
        this.setData(getWpbjbdtj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Wpbjbdtj setWpbjbdtj=new Wpbjbdtj();
        Map map = new HashMap();
        Page page = wpbjbdtjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lWpbjbdtj=page.getData();
        setTabledata(lWpbjbdtj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Wpbjbdtj setWpbjbdtj=new Wpbjbdtj();
			wpbjbdtj=(Wpbjbdtj)this.setClass(setWpbjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjbdtj=wpbjbdtjService.getWpbjbdtj(wpbjbdtj);
        lWpbjbdtj.clear();
        lWpbjbdtj.add(wpbjbdtj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Wpbjbdtj setWpbjbdtj=new Wpbjbdtj();
			wpbjbdtj=(Wpbjbdtj)this.setClass(setWpbjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjbdtj=wpbjbdtjService.insertWpbjbdtj(wpbjbdtj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Wpbjbdtj setWpbjbdtj=new Wpbjbdtj();
			wpbjbdtj=(Wpbjbdtj)this.setClass(setWpbjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjbdtjService.updateWpbjbdtj(wpbjbdtj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Wpbjbdtj setWpbjbdtj=new Wpbjbdtj();
			wpbjbdtj=(Wpbjbdtj)this.setClass(setWpbjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjbdtjService.deleteWpbjbdtj(wpbjbdtj);
        this.result="success";
        return "success";
    }
}