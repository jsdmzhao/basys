package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bdqclxxkz;
import com.aisino2.basicsystem.service.IBdqclxxkzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class BdqclxxkzAction extends PageAction{
	private IBdqclxxkzService bdqclxxkzService;
	private List lBdqclxxkz=new ArrayList();
	private Bdqclxxkz bdqclxxkz=new Bdqclxxkz();
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

	public Bdqclxxkz getBdqclxxkz() {
		return bdqclxxkz;
	}
	
	public List getLBdqclxxkz() {
		return lBdqclxxkz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBdqclxxkzService(IBdqclxxkzService bdqclxxkzService) {
		this.bdqclxxkzService = bdqclxxkzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjxxid2");
		lPro.add("bdqclxxkzid");
		lPro.add("id");
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
		lPro.add("sfbx");
		lPro.add("bar");
		lPro.add("ladwqhbm");
		lPro.add("ladwqh");
		lPro.add("ladwbm");
		lPro.add("ladwmc");
		lPro.add("lasj");
		lPro.add("lajbr");
		lPro.add("ladh");
		lPro.add("sldwqhbm");
		lPro.add("sldwqh");
		lPro.add("sldwbm");
		lPro.add("sldwmc");
		lPro.add("slsj");
		lPro.add("sljbr");
		lPro.add("sldh");
		lPro.add("bz");
		lPro.add("tbdwqhbm");
		lPro.add("tbdwqh");
		lPro.add("tbdwbm");
		lPro.add("tbdwmc");
		lPro.add("tbtbr");
		lPro.add("tbsj3");
		lPro.add("zt");
		lPro.add("scbz");
		lPro.add("lrdwbm");
		lPro.add("lrdw");
		lPro.add("lrr");
		lPro.add("lrsj");
		lPro.add("xgdwbm");
		lPro.add("xgdw");
		lPro.add("xgr");
		lPro.add("xgsj");
		lPro.add("spr3");
		lPro.add("spyj");
		lPro.add("sydwbm");
		lPro.add("sydw");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Bdqclxxkz getBdqclxxkz=new Bdqclxxkz();
    	
        this.setData(getBdqclxxkz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Bdqclxxkz setBdqclxxkz=new Bdqclxxkz();
        Map map = new HashMap();
        Page page = bdqclxxkzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lBdqclxxkz=page.getData();
        setTabledata(lBdqclxxkz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Bdqclxxkz setBdqclxxkz=new Bdqclxxkz();
			bdqclxxkz=(Bdqclxxkz)this.setClass(setBdqclxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxxkz=bdqclxxkzService.getBdqclxxkz(bdqclxxkz);
        lBdqclxxkz.clear();
        lBdqclxxkz.add(bdqclxxkz);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Bdqclxxkz setBdqclxxkz=new Bdqclxxkz();
			bdqclxxkz=(Bdqclxxkz)this.setClass(setBdqclxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxxkz=bdqclxxkzService.insertBdqclxxkz(bdqclxxkz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bdqclxxkz setBdqclxxkz=new Bdqclxxkz();
			bdqclxxkz=(Bdqclxxkz)this.setClass(setBdqclxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxxkzService.updateBdqclxxkz(bdqclxxkz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Bdqclxxkz setBdqclxxkz=new Bdqclxxkz();
			bdqclxxkz=(Bdqclxxkz)this.setClass(setBdqclxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxxkzService.deleteBdqclxxkz(bdqclxxkz);
        this.result="success";
        return "success";
    }
}