package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Dxbj;
import com.aisino2.basicsystem.service.IDxbjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class DxbjAction extends PageAction{
	private IDxbjService dxbjService;
	private List lDxbj;
	private Dxbj dxbj;
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

	public Dxbj getDxbj() {
		return dxbj;
	}
	
	public List getLDxbj() {
		return lDxbj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setDxbjService(IDxbjService dxbjService) {
		this.dxbjService = dxbjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjgzid");
		lPro.add("bjxxid");
		lPro.add("dxbjid");
		lPro.add("dxhm");
		lPro.add("dycfssj");
		lPro.add("zhycfssj");
		lPro.add("fscs");
		lPro.add("dxzt");
		lPro.add("dxnr");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Dxbj getDxbj=new Dxbj();
    	
        this.setData(getDxbj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Dxbj setDxbj=new Dxbj();
        Map map = new HashMap();
        Page page = dxbjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lDxbj=page.getData();
        setTabledata(lDxbj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Dxbj setDxbj=new Dxbj();
			dxbj=(Dxbj)this.setClass(setDxbj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dxbj=dxbjService.getDxbj(dxbj);
        lDxbj.clear();
        lDxbj.add(dxbj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Dxbj setDxbj=new Dxbj();
			dxbj=(Dxbj)this.setClass(setDxbj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dxbj=dxbjService.insertDxbj(dxbj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Dxbj setDxbj=new Dxbj();
			dxbj=(Dxbj)this.setClass(setDxbj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dxbjService.updateDxbj(dxbj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Dxbj setDxbj=new Dxbj();
			dxbj=(Dxbj)this.setClass(setDxbj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dxbjService.deleteDxbj(dxbj);
        this.result="success";
        return "success";
    }
}