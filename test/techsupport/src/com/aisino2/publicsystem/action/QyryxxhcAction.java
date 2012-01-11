package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyryxxhc;
import com.aisino2.publicsystem.service.IQyryxxhcService;

public class QyryxxhcAction extends PageAction{
	private IQyryxxhcService qyryxxhcService;
	private List lQyryxxhc=new ArrayList();
	private Qyryxxhc qyryxxhc=new Qyryxxhc();
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

	public Qyryxxhc getQyryxxhc() {
		return qyryxxhc;
	}
	
	public List getLQyryxxhc() {
		return lQyryxxhc;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyryxxhcService(IQyryxxhcService qyryxxhcService) {
		this.qyryxxhcService = qyryxxhcService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("garkktbsjid");
		lPro.add("qyid");
		lPro.add("ryid");
		lPro.add("hcid");
		lPro.add("dsjgdm");
		lPro.add("dsjgmc");
		lPro.add("fxjdm");
		lPro.add("fxjmc");
		lPro.add("gxdwdm");
		lPro.add("gxdwmc");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("xm");
		lPro.add("xbdm");
		lPro.add("xb");
		lPro.add("ywm");
		lPro.add("ywx");
		lPro.add("wgrjyxkz");
		lPro.add("cyzjdm");
		lPro.add("cyzj");
		lPro.add("zjhm");
		lPro.add("gwbh");
		lPro.add("gemc");
		lPro.add("xmpy");
		lPro.add("bdsj");
		lPro.add("hcsj");
		lPro.add("hcwt");
		lPro.add("hcyj");
		lPro.add("hcr");
		lPro.add("hcdw");
		lPro.add("hcdwdm");
		lPro.add("hczt");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyryxxhc getQyryxxhc=new Qyryxxhc();
    	
        this.setData(getQyryxxhc,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyryxxhc setQyryxxhc=new Qyryxxhc();
        Map map = new HashMap();
        Page page = qyryxxhcService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyryxxhc=page.getData();
        setTabledata(lQyryxxhc); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyryxxhc setQyryxxhc=new Qyryxxhc();
			qyryxxhc=(Qyryxxhc)this.setClass(setQyryxxhc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxxhc=qyryxxhcService.getQyryxxhc(qyryxxhc);
        lQyryxxhc.clear();
        lQyryxxhc.add(qyryxxhc);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyryxxhc setQyryxxhc=new Qyryxxhc();
			qyryxxhc=(Qyryxxhc)this.setClass(setQyryxxhc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxxhc=qyryxxhcService.insertQyryxxhc(qyryxxhc);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyryxxhc setQyryxxhc=new Qyryxxhc();
			qyryxxhc=(Qyryxxhc)this.setClass(setQyryxxhc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxxhcService.updateQyryxxhc(qyryxxhc);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyryxxhc setQyryxxhc=new Qyryxxhc();
			qyryxxhc=(Qyryxxhc)this.setClass(setQyryxxhc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxxhcService.deleteQyryxxhc(qyryxxhc);
        this.result="success";
        return "success";
    }
}