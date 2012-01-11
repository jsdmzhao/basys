package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bksjkz;
import com.aisino2.basicsystem.service.IBksjkzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class BksjkzAction extends PageAction{
	private IBksjkzService bksjkzService;
	private List lBksjkz=new ArrayList();
	private Bksjkz bksjkz=new Bksjkz();
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

	public Bksjkz getBksjkz() {
		return bksjkz;
	}
	
	public List getLBksjkz() {
		return lBksjkz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBksjkzService(IBksjkzService bksjkzService) {
		this.bksjkzService = bksjkzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjxxid2");
		lPro.add("bkwpjbxxkzid");
		lPro.add("bksjkzid");
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
    	
    	Bksjkz getBksjkz=new Bksjkz();
    	
        this.setData(getBksjkz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Bksjkz setBksjkz=new Bksjkz();
        Map map = new HashMap();
        Page page = bksjkzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lBksjkz=page.getData();
        setTabledata(lBksjkz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Bksjkz setBksjkz=new Bksjkz();
			bksjkz=(Bksjkz)this.setClass(setBksjkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bksjkz=bksjkzService.getBksjkz(bksjkz);
        lBksjkz.clear();
        lBksjkz.add(bksjkz);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Bksjkz setBksjkz=new Bksjkz();
			bksjkz=(Bksjkz)this.setClass(setBksjkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bksjkz=bksjkzService.insertBksjkz(bksjkz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bksjkz setBksjkz=new Bksjkz();
			bksjkz=(Bksjkz)this.setClass(setBksjkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bksjkzService.updateBksjkz(bksjkz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Bksjkz setBksjkz=new Bksjkz();
			bksjkz=(Bksjkz)this.setClass(setBksjkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bksjkzService.deleteBksjkz(bksjkz);
        this.result="success";
        return "success";
    }
}