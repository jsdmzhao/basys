package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bjbdtj;
import com.aisino2.basicsystem.service.IBjbdtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class BjbdtjAction extends PageAction{
	private IBjbdtjService bjbdtjService;
	private List lBjbdtj;
	private Bjbdtj bjbdtj;
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

	public Bjbdtj getBjbdtj() {
		return bjbdtj;
	}
	
	public List getLBjbdtj() {
		return lBjbdtj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBjbdtjService(IBjbdtjService bjbdtjService) {
		this.bjbdtjService = bjbdtjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjgzid");
		lPro.add("bjbdtjid");
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
    	
    	Bjbdtj getBjbdtj=new Bjbdtj();
    	
        this.setData(getBjbdtj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Bjbdtj setBjbdtj=new Bjbdtj();
        Map map = new HashMap();
        Page page = bjbdtjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lBjbdtj=page.getData();
        setTabledata(lBjbdtj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Bjbdtj setBjbdtj=new Bjbdtj();
			bjbdtj=(Bjbdtj)this.setClass(setBjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bjbdtj=bjbdtjService.getBjbdtj(bjbdtj);
        lBjbdtj.clear();
        lBjbdtj.add(bjbdtj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Bjbdtj setBjbdtj=new Bjbdtj();
			bjbdtj=(Bjbdtj)this.setClass(setBjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bjbdtj=bjbdtjService.insertBjbdtj(bjbdtj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bjbdtj setBjbdtj=new Bjbdtj();
			bjbdtj=(Bjbdtj)this.setClass(setBjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bjbdtjService.updateBjbdtj(bjbdtj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Bjbdtj setBjbdtj=new Bjbdtj();
			bjbdtj=(Bjbdtj)this.setClass(setBjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bjbdtjService.deleteBjbdtj(bjbdtj);
        this.result="success";
        return "success";
    }
}