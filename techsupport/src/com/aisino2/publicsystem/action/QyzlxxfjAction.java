package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyzlxxfj;
import com.aisino2.publicsystem.service.IQyzlxxfjService;


public class QyzlxxfjAction extends PageAction{
	private IQyzlxxfjService qyzlxxfjService;
	private List lQyzlxxfj=new ArrayList();
	private Qyzlxxfj qyzlxxfj=new Qyzlxxfj();
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

	public Qyzlxxfj getQyzlxxfj() {
		return qyzlxxfj;
	}
	
	public List getLQyzlxxfj() {
		return lQyzlxxfj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyzlxxfjService(IQyzlxxfjService qyzlxxfjService) {
		this.qyzlxxfjService = qyzlxxfjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyzlxxfjid");
		lPro.add("qyzlxxid");
		lPro.add("fjmc");
		lPro.add("fjlx");
		lPro.add("fjnr");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyzlxxfj getQyzlxxfj=new Qyzlxxfj();
    	
        this.setData(getQyzlxxfj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyzlxxfj setQyzlxxfj=new Qyzlxxfj();
        Map map = new HashMap();
        Page page = qyzlxxfjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyzlxxfj=page.getData();
        setTabledata(lQyzlxxfj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyzlxxfj setQyzlxxfj=new Qyzlxxfj();
			qyzlxxfj=(Qyzlxxfj)this.setClass(setQyzlxxfj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyzlxxfj=qyzlxxfjService.getQyzlxxfj(qyzlxxfj);
        lQyzlxxfj.clear();
        lQyzlxxfj.add(qyzlxxfj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyzlxxfj setQyzlxxfj=new Qyzlxxfj();
			qyzlxxfj=(Qyzlxxfj)this.setClass(setQyzlxxfj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyzlxxfj=qyzlxxfjService.insertQyzlxxfj(qyzlxxfj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyzlxxfj setQyzlxxfj=new Qyzlxxfj();
			qyzlxxfj=(Qyzlxxfj)this.setClass(setQyzlxxfj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyzlxxfjService.updateQyzlxxfj(qyzlxxfj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyzlxxfj setQyzlxxfj=new Qyzlxxfj();
			qyzlxxfj=(Qyzlxxfj)this.setClass(setQyzlxxfj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyzlxxfjService.deleteQyzlxxfj(qyzlxxfj);
        this.result="success";
        return "success";
    }
}