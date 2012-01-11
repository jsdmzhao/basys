package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Gatztbhf;
import com.aisino2.basicsystem.service.IGatztbhfService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class GatztbhfAction extends PageAction{
	private IGatztbhfService gatztbhfService;
	private List lGatztbhf=new ArrayList();
	private Gatztbhf gatztbhf=new Gatztbhf();
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

	public Gatztbhf getGatztbhf() {
		return gatztbhf;
	}
	
	public List getLGatztbhf() {
		return lGatztbhf;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setGatztbhfService(IGatztbhfService gatztbhfService) {
		this.gatztbhfService = gatztbhfService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("gatbid");
		lPro.add("gajsdwid");
		lPro.add("gatztbhfid");
		lPro.add("hfsj");
		lPro.add("hfnr");
		lPro.add("hfr");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Gatztbhf getGatztbhf=new Gatztbhf();
    	
        this.setData(getGatztbhf,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Gatztbhf setGatztbhf=new Gatztbhf();
        Map map = new HashMap();
        Page page = gatztbhfService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lGatztbhf=page.getData();
        setTabledata(lGatztbhf); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Gatztbhf setGatztbhf=new Gatztbhf();
			gatztbhf=(Gatztbhf)this.setClass(setGatztbhf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztbhf=gatztbhfService.getGatztbhf(gatztbhf);
        lGatztbhf.clear();
        lGatztbhf.add(gatztbhf);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Gatztbhf setGatztbhf=new Gatztbhf();
			gatztbhf=(Gatztbhf)this.setClass(setGatztbhf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztbhf=gatztbhfService.insertGatztbhf(gatztbhf);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Gatztbhf setGatztbhf=new Gatztbhf();
			gatztbhf=(Gatztbhf)this.setClass(setGatztbhf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztbhfService.updateGatztbhf(gatztbhf);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Gatztbhf setGatztbhf=new Gatztbhf();
			gatztbhf=(Gatztbhf)this.setClass(setGatztbhf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztbhfService.deleteGatztbhf(gatztbhf);
        this.result="success";
        return "success";
    }
}