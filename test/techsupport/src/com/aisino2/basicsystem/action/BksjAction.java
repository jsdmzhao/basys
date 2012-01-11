package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bksj;
import com.aisino2.basicsystem.service.IBksjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class BksjAction extends PageAction{
	private IBksjService bksjService;
	private List lBksj=new ArrayList();
	private Bksj bksj=new Bksj();
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

	public Bksj getBksj() {
		return bksj;
	}
	
	public List getLBksj() {
		return lBksj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBksjService(IBksjService bksjService) {
		this.bksjService = bksjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bkwpjbxxid");
		lPro.add("bksjid");
		lPro.add("sjch");
		lPro.add("pp");
		lPro.add("xh");
		lPro.add("ys");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Bksj getBksj=new Bksj();
    	
        this.setData(getBksj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Bksj setBksj=new Bksj();
        Map map = new HashMap();
        Page page = bksjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lBksj=page.getData();
        setTabledata(lBksj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Bksj setBksj=new Bksj();
			bksj=(Bksj)this.setClass(setBksj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bksj=bksjService.getBksj(bksj);
        lBksj.clear();
        lBksj.add(bksj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Bksj setBksj=new Bksj();
			bksj=(Bksj)this.setClass(setBksj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bksj=bksjService.insertBksj(bksj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bksj setBksj=new Bksj();
			bksj=(Bksj)this.setClass(setBksj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bksjService.updateBksj(bksj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Bksj setBksj=new Bksj();
			bksj=(Bksj)this.setClass(setBksj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bksjService.deleteBksj(bksj);
        this.result="success";
        return "success";
    }
}