package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyry_tjxx;
import com.aisino2.publicsystem.service.IQyry_tjxxService;

public class Qyry_tjxxAction extends PageAction{
	private IQyry_tjxxService qyry_tjxxService;
	private List lQyry_tjxx=new ArrayList();
	private Qyry_tjxx qyry_tjxx=new Qyry_tjxx();
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

	public Qyry_tjxx getQyry_tjxx() {
		return qyry_tjxx;
	}
	
	public List getLQyry_tjxx() {
		return lQyry_tjxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyry_tjxxService(IQyry_tjxxService qyry_tjxxService) {
		this.qyry_tjxxService = qyry_tjxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		
		List lPro=new ArrayList();
		lPro.add("tjxxid");
		lPro.add("tijianrq");
		lPro.add("tjzkjms");
		lPro.add("lrr");
		lPro.add("lrrq");

    	
		List lModify=new ArrayList();
    	lModify.add("setCyry_tjxxXg");
    	lModify.add("修改");
    	
    	List lCol=new ArrayList();
//    	lCol.add(lXq);
    	lCol.add(lModify);
    	
    	Qyry_tjxx getQyry_tjxx=new Qyry_tjxx();
    	
        this.setData(getQyry_tjxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Qyry_tjxx setCyry_tjxx=new Qyry_tjxx();
			qyry_tjxx=(Qyry_tjxx)this.setClass(setCyry_tjxx, null);
        
			Map map = new HashMap();
			if(qyry_tjxx!=null){
				map.put("ryid", qyry_tjxx.getRyid());
			}
			Page page = qyry_tjxxService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lQyry_tjxx=page.getData();
			setTabledata(lQyry_tjxx); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
		return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyry_tjxx setQyry_tjxx=new Qyry_tjxx();
			qyry_tjxx=(Qyry_tjxx)this.setClass(setQyry_tjxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyry_tjxx=qyry_tjxxService.getQyry_tjxx(qyry_tjxx);
        lQyry_tjxx.clear();
        lQyry_tjxx.add(qyry_tjxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyry_tjxx setQyry_tjxx=new Qyry_tjxx();
			qyry_tjxx=(Qyry_tjxx)this.setClass(setQyry_tjxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyry_tjxx=qyry_tjxxService.insertQyry_tjxx(qyry_tjxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyry_tjxx setQyry_tjxx=new Qyry_tjxx();
			qyry_tjxx=(Qyry_tjxx)this.setClass(setQyry_tjxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyry_tjxxService.updateQyry_tjxx(qyry_tjxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyry_tjxx setQyry_tjxx=new Qyry_tjxx();
			qyry_tjxx=(Qyry_tjxx)this.setClass(setQyry_tjxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyry_tjxxService.deleteQyry_tjxx(qyry_tjxx);
        this.result="success";
        return "success";
    }
}