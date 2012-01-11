package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bkclkz;
import com.aisino2.basicsystem.service.IBkclkzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class BkclkzAction extends PageAction{
	private IBkclkzService bkclkzService;
	private List lBkclkz=new ArrayList();
	private Bkclkz bkclkz=new Bkclkz();
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

	public Bkclkz getBkclkz() {
		return bkclkz;
	}
	
	public List getLBkclkz() {
		return lBkclkz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBkclkzService(IBkclkzService bkclkzService) {
		this.bkclkzService = bkclkzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjxxid2");
		lPro.add("bkwpjbxxkzid");
		lPro.add("bkclkzid");
		lPro.add("cllxdm");
		lPro.add("cllx");
		lPro.add("clpp");
		lPro.add("clxh");
		lPro.add("hpzldm");
		lPro.add("hpzl");
		lPro.add("hphm");
		lPro.add("csys");
		lPro.add("syr");
		lPro.add("ccdjrq");
		lPro.add("fdjh");
		lPro.add("clsbdh");
		lPro.add("cjh");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Bkclkz getBkclkz=new Bkclkz();
    	
        this.setData(getBkclkz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Bkclkz setBkclkz=new Bkclkz();
        Map map = new HashMap();
        Page page = bkclkzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lBkclkz=page.getData();
        setTabledata(lBkclkz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Bkclkz setBkclkz=new Bkclkz();
			bkclkz=(Bkclkz)this.setClass(setBkclkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bkclkz=bkclkzService.getBkclkz(bkclkz);
        lBkclkz.clear();
        lBkclkz.add(bkclkz);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Bkclkz setBkclkz=new Bkclkz();
			bkclkz=(Bkclkz)this.setClass(setBkclkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bkclkz=bkclkzService.insertBkclkz(bkclkz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bkclkz setBkclkz=new Bkclkz();
			bkclkz=(Bkclkz)this.setClass(setBkclkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bkclkzService.updateBkclkz(bkclkz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Bkclkz setBkclkz=new Bkclkz();
			bkclkz=(Bkclkz)this.setClass(setBkclkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bkclkzService.deleteBkclkz(bkclkz);
        this.result="success";
        return "success";
    }
}