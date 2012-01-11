package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Icksl_wldj;
import com.aisino2.icksystem.service.IIcksl_wldjService;

public class Icksl_wldjAction extends PageAction{
	private IIcksl_wldjService icksl_wldjService;
	private List lIcksl_wldj;
	private Icksl_wldj icksl_wldj;
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

	public Icksl_wldj getIcksl_wldj() {
		return icksl_wldj;
	}
	
	public List getLIcksl_wldj() {
		return lIcksl_wldj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setIcksl_wldjService(IIcksl_wldjService icksl_wldjService) {
		this.icksl_wldjService = icksl_wldjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("ickslid");
		lPro.add("wlid");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Icksl_wldj getIcksl_wldj=new Icksl_wldj();
    	
        this.setData(getIcksl_wldj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Icksl_wldj setIcksl_wldj=new Icksl_wldj();
        Map map = new HashMap();
        Page page = icksl_wldjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lIcksl_wldj=page.getData();
        setTabledata(lIcksl_wldj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Icksl_wldj setIcksl_wldj=new Icksl_wldj();
			icksl_wldj=(Icksl_wldj)this.setClass(setIcksl_wldj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksl_wldj=icksl_wldjService.getIcksl_wldj(icksl_wldj);
        lIcksl_wldj.clear();
        lIcksl_wldj.add(icksl_wldj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Icksl_wldj setIcksl_wldj=new Icksl_wldj();
			icksl_wldj=(Icksl_wldj)this.setClass(setIcksl_wldj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksl_wldj=icksl_wldjService.insertIcksl_wldj(icksl_wldj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Icksl_wldj setIcksl_wldj=new Icksl_wldj();
			icksl_wldj=(Icksl_wldj)this.setClass(setIcksl_wldj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksl_wldjService.updateIcksl_wldj(icksl_wldj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Icksl_wldj setIcksl_wldj=new Icksl_wldj();
			icksl_wldj=(Icksl_wldj)this.setClass(setIcksl_wldj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        icksl_wldjService.deleteIcksl_wldj(icksl_wldj);
        this.result="success";
        return "success";
    }
}