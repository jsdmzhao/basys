package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Yjbdtj;
import com.aisino2.basicsystem.service.IYjbdtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class YjbdtjAction extends PageAction{
	private IYjbdtjService yjbdtjService;
	private List lYjbdtj;
	private Yjbdtj yjbdtj;
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

	public Yjbdtj getYjbdtj() {
		return yjbdtj;
	}
	
	public List getLYjbdtj() {
		return lYjbdtj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setYjbdtjService(IYjbdtjService yjbdtjService) {
		this.yjbdtjService = yjbdtjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("yjgzid");
		lPro.add("yjbdtjid");
		lPro.add("tjlx");
		lPro.add("ywbzdm");
		lPro.add("bdbzdm");
		lPro.add("bdgx");
		lPro.add("gxc");
		lPro.add("zxsx");
		lPro.add("ljgx");
		lPro.add("jibie");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Yjbdtj getYjbdtj=new Yjbdtj();
    	
        this.setData(getYjbdtj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Yjbdtj setYjbdtj=new Yjbdtj();
        Map map = new HashMap();
        Page page = yjbdtjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lYjbdtj=page.getData();
        setTabledata(lYjbdtj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Yjbdtj setYjbdtj=new Yjbdtj();
			yjbdtj=(Yjbdtj)this.setClass(setYjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjbdtj=yjbdtjService.getYjbdtj(yjbdtj);
        lYjbdtj.clear();
        lYjbdtj.add(yjbdtj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Yjbdtj setYjbdtj=new Yjbdtj();
			yjbdtj=(Yjbdtj)this.setClass(setYjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjbdtj=yjbdtjService.insertYjbdtj(yjbdtj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Yjbdtj setYjbdtj=new Yjbdtj();
			yjbdtj=(Yjbdtj)this.setClass(setYjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjbdtjService.updateYjbdtj(yjbdtj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Yjbdtj setYjbdtj=new Yjbdtj();
			yjbdtj=(Yjbdtj)this.setClass(setYjbdtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        yjbdtjService.deleteYjbdtj(yjbdtj);
        this.result="success";
        return "success";
    }
}