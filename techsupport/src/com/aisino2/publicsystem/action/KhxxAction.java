package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Khxx;
import com.aisino2.publicsystem.service.IKhxxService;

public class KhxxAction extends PageAction{
	private IKhxxService khxxService;
	private List lKhxx=new ArrayList();
	private Khxx khxx=new Khxx();
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

	public Khxx getKhxx() {
		return khxx;
	}
	
	public List getLKhxx() {
		return lKhxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setKhxxService(IKhxxService khxxService) {
		this.khxxService = khxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("khxxid");
		lPro.add("xm");
		lPro.add("lxdh");
		lPro.add("mzdm");
		lPro.add("minzu");
		lPro.add("xbdm");
		lPro.add("xb");
		lPro.add("hjdxz");
		lPro.add("cyzjdm");
		lPro.add("cyzj");
		lPro.add("zjhm");
		lPro.add("biduiflag");
		lPro.add("zt");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Khxx getKhxx=new Khxx();
    	
        this.setData(getKhxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Khxx setKhxx=new Khxx();
        Map map = new HashMap();
        Page page = khxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lKhxx=page.getData();
        setTabledata(lKhxx); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Khxx setKhxx=new Khxx();
			khxx=(Khxx)this.setClass(setKhxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        khxx=khxxService.getKhxx(khxx);
        lKhxx.clear();
        lKhxx.add(khxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Khxx setKhxx=new Khxx();
			khxx=(Khxx)this.setClass(setKhxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        khxx=khxxService.insertKhxx(khxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Khxx setKhxx=new Khxx();
			khxx=(Khxx)this.setClass(setKhxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        khxxService.updateKhxx(khxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Khxx setKhxx=new Khxx();
			khxx=(Khxx)this.setClass(setKhxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        khxxService.deleteKhxx(khxx);
        this.result="success";
        return "success";
    }
}