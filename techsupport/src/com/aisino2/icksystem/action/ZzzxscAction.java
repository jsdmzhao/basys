package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Zzzxsc;
import com.aisino2.icksystem.service.IZzzxscService;

public class ZzzxscAction extends PageAction{
	private IZzzxscService zzzxscService;
	private List lZzzxsc;
	private Zzzxsc zzzxsc;
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

	public Zzzxsc getZzzxsc() {
		return zzzxsc;
	}
	
	public List getLZzzxsc() {
		return lZzzxsc;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setZzzxscService(IZzzxscService zzzxscService) {
		this.zzzxscService = zzzxscService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("ickslid");
		lPro.add("zzzxscid");
		lPro.add("sjscbz");
		lPro.add("fssj");
		lPro.add("hksj");
		lPro.add("zzzxjlbh");
		lPro.add("zzcwyy");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Zzzxsc getZzzxsc=new Zzzxsc();
    	
        this.setData(getZzzxsc,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Zzzxsc setZzzxsc=new Zzzxsc();
        Map map = new HashMap();
        Page page = zzzxscService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lZzzxsc=page.getData();
        setTabledata(lZzzxsc); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Zzzxsc setZzzxsc=new Zzzxsc();
			zzzxsc=(Zzzxsc)this.setClass(setZzzxsc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zzzxsc=zzzxscService.getZzzxsc(zzzxsc);
        lZzzxsc.clear();
        lZzzxsc.add(zzzxsc);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Zzzxsc setZzzxsc=new Zzzxsc();
			zzzxsc=(Zzzxsc)this.setClass(setZzzxsc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zzzxsc=zzzxscService.insertZzzxsc(zzzxsc);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Zzzxsc setZzzxsc=new Zzzxsc();
			zzzxsc=(Zzzxsc)this.setClass(setZzzxsc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zzzxscService.updateZzzxsc(zzzxsc);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Zzzxsc setZzzxsc=new Zzzxsc();
			zzzxsc=(Zzzxsc)this.setClass(setZzzxsc, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zzzxscService.deleteZzzxsc(zzzxsc);
        this.result="success";
        return "success";
    }
}