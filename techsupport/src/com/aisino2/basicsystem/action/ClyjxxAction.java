package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Clyjxx;
import com.aisino2.basicsystem.service.IClyjxxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class ClyjxxAction extends PageAction{
	private IClyjxxService clyjxxService;
	private List lClyjxx=new ArrayList();
	private Clyjxx clyjxx=new Clyjxx();
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

	public Clyjxx getClyjxx() {
		return clyjxx;
	}
	
	public List getLClyjxx() {
		return lClyjxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setClyjxxService(IClyjxxService clyjxxService) {
		this.clyjxxService = clyjxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("clyjxxid");
		lPro.add("cllx");
     	lPro.add("cszs");
     	lPro.add("cph");
     	lPro.add("fdjh");
     	lPro.add("cjh");
     	lPro.add("clpp");
     	lPro.add("czm");
     	lPro.add("czzjhm");
     	lPro.add("yjsj");
    	
    	Clyjxx getClyjxx=new Clyjxx();
    	
        this.setData(getClyjxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Clyjxx setClyjxx=new Clyjxx();
			clyjxx=(Clyjxx)this.setClass(setClyjxx, null); 
			Map map = new HashMap();
			map.put("cllxbm", clyjxx.getCllxbm());
			map.put("cszs", clyjxx.getCszs());
			map.put("dyfs", clyjxx.getDyfs());
			map.put("drfs", clyjxx.getDrfs());
			map.put("cph", clyjxx.getCph());
			map.put("fdjh", clyjxx.getFdjh());
			map.put("cjh", clyjxx.getCjh());
			map.put("czm", clyjxx.getCzm());
			map.put("czdh", clyjxx.getCzdh());
			map.put("czzjhm", clyjxx.getCzzjhm());
			
	        Page page = clyjxxService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lClyjxx=page.getData();
	        setTabledata(lClyjxx); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Clyjxx setClyjxx=new Clyjxx();
			clyjxx=(Clyjxx)this.setClass(setClyjxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clyjxx=clyjxxService.getClyjxx(clyjxx);
        lClyjxx.clear();
        lClyjxx.add(clyjxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Clyjxx setClyjxx=new Clyjxx();
			clyjxx=(Clyjxx)this.setClass(setClyjxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clyjxx=clyjxxService.insertClyjxx(clyjxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Clyjxx setClyjxx=new Clyjxx();
			clyjxx=(Clyjxx)this.setClass(setClyjxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clyjxxService.updateClyjxx(clyjxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Clyjxx setClyjxx=new Clyjxx();
			clyjxx=(Clyjxx)this.setClass(setClyjxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clyjxxService.deleteClyjxx(clyjxx);
        this.result="success";
        return "success";
    }
}