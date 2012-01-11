package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bdqclxxlsb;
import com.aisino2.basicsystem.service.IBdqclxxlsbService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class BdqclxxlsbAction extends PageAction{
	private IBdqclxxlsbService bdqclxxlsbService;
	private List lBdqclxxlsb=new ArrayList();
	private Bdqclxxlsb bdqclxxlsb=new Bdqclxxlsb();
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

	public Bdqclxxlsb getBdqclxxlsb() {
		return bdqclxxlsb;
	}
	
	public List getLBdqclxxlsb() {
		return lBdqclxxlsb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBdqclxxlsbService(IBdqclxxlsbService bdqclxxlsbService) {
		this.bdqclxxlsbService = bdqclxxlsbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bdqclxxid");
		lPro.add("id");
		lPro.add("ajbh");
		lPro.add("ajxzdm");
		lPro.add("ajxz");
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
    	
    	Bdqclxxlsb getBdqclxxlsb=new Bdqclxxlsb();
    	
        this.setData(getBdqclxxlsb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Bdqclxxlsb setBdqclxxlsb=new Bdqclxxlsb();
        Map map = new HashMap();
        Page page = bdqclxxlsbService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lBdqclxxlsb=page.getData();
        setTabledata(lBdqclxxlsb); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Bdqclxxlsb setBdqclxxlsb=new Bdqclxxlsb();
			bdqclxxlsb=(Bdqclxxlsb)this.setClass(setBdqclxxlsb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxxlsb=bdqclxxlsbService.getBdqclxxlsb(bdqclxxlsb);
        lBdqclxxlsb.clear();
        lBdqclxxlsb.add(bdqclxxlsb);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Bdqclxxlsb setBdqclxxlsb=new Bdqclxxlsb();
			bdqclxxlsb=(Bdqclxxlsb)this.setClass(setBdqclxxlsb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxxlsb=bdqclxxlsbService.insertBdqclxxlsb(bdqclxxlsb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bdqclxxlsb setBdqclxxlsb=new Bdqclxxlsb();
			bdqclxxlsb=(Bdqclxxlsb)this.setClass(setBdqclxxlsb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxxlsbService.updateBdqclxxlsb(bdqclxxlsb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Bdqclxxlsb setBdqclxxlsb=new Bdqclxxlsb();
			bdqclxxlsb=(Bdqclxxlsb)this.setClass(setBdqclxxlsb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxxlsbService.deleteBdqclxxlsb(bdqclxxlsb);
        this.result="success";
        return "success";
    }
}