package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Yjxxb;
import com.aisino2.basicsystem.service.IYjxxbService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class YjxxbAction extends PageAction{
	private IYjxxbService yjxxbService;
	private List lYjxxb;
	private Yjxxb yjxxb;
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

	public Yjxxb getYjxxb() {
		return yjxxb;
	}
	
	public List getLYjxxb() {
		return lYjxxb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setYjxxbService(IYjxxbService yjxxbService) {
		this.yjxxbService = yjxxbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("yjgzid");
		lPro.add("yjxxid");
		lPro.add("ssqymc");
		lPro.add("ssqydz");
		lPro.add("gxdwbm");
		lPro.add("gxdwmc");
		lPro.add("yjlx");
		lPro.add("yjsj");
		lPro.add("bdbm");
		lPro.add("ywbm");
		lPro.add("hylb");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("gxbbh");
		lPro.add("ywlb");
		lPro.add("lxdh");
		lPro.add("qkms");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Yjxxb getYjxxb=new Yjxxb();
    	
        this.setData(getYjxxb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Yjxxb setYjxxb=new Yjxxb();
        Map map = new HashMap();
        Page page = yjxxbService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lYjxxb=page.getData();
        setTabledata(lYjxxb); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Yjxxb setYjxxb=new Yjxxb();
			yjxxb=(Yjxxb)this.setClass(setYjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjxxb=yjxxbService.getYjxxb(yjxxb);
        lYjxxb.clear();
        lYjxxb.add(yjxxb);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Yjxxb setYjxxb=new Yjxxb();
			yjxxb=(Yjxxb)this.setClass(setYjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjxxb=yjxxbService.insertYjxxb(yjxxb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Yjxxb setYjxxb=new Yjxxb();
			yjxxb=(Yjxxb)this.setClass(setYjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjxxbService.updateYjxxb(yjxxb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Yjxxb setYjxxb=new Yjxxb();
			yjxxb=(Yjxxb)this.setClass(setYjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjxxbService.deleteYjxxb(yjxxb);
        this.result="success";
        return "success";
    }
}