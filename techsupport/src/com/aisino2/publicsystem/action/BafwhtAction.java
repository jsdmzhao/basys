package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Bafwht;
import com.aisino2.publicsystem.service.IBafwhtService;

public class BafwhtAction extends PageAction{
	private IBafwhtService bafwhtService;
	private List lBafwht=new ArrayList();
	private Bafwht bafwht=new Bafwht();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	private String requestType="";
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Bafwht getBafwht() {
		return bafwht;
	}
	
	public List getLBafwht() {
		return lBafwht;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBafwhtService(IBafwhtService bafwhtService) {
		this.bafwhtService = bafwhtService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bafwhtid");
		lPro.add("bafwgsmc");
		lPro.add("htbh");
		lPro.add("qdrq");
		lPro.add("jsrq");
		lPro.add("htyxq");
		lPro.add("balxmc");
		lPro.add("fzjgmc");
		
		lPro.add("balxdm");
		lPro.add("barypxjsrq");
		lPro.add("baryzgzsmc");
		lPro.add("barypxnr");

//		List lCol=new ArrayList();
//    	List lDel=new ArrayList();
//    	lDel.add("bafwht_setDelete");
//    	lDel.add("删除");
//    	lCol.add(lDel);
    	
    	Bafwht getBafwht=new Bafwht();
    	
        this.setData(getBafwht,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try{
			requestType="";
			Bafwht setBafwht=new Bafwht();
			setBafwht=(Bafwht)this.setClass(setBafwht, null);
			requestType = setBafwht.getBafwhtRequetType();
	        Map map = new HashMap();
	        map.put("qyid", setBafwht.getQyid());
	        Page page = bafwhtService.getListForPage(map, pagesize, pagerow,null,null);
	        lBafwht=page.getData();
	        setTabledata(lBafwht); 
		} catch (Exception e) {
		e.printStackTrace();
		this.result="";
		return "success";
	}
	this.result="success";
    return "success";
    }
	
	public String query() throws Exception{
		try {
			List oldList = new ArrayList();
			Bafwht setBafwht=new Bafwht();
			Object[] objA={setBafwht};
			setBafwht=(Bafwht)this.setClass(setBafwht, objA);
			oldList = setBafwht.getLBafwhtList();
			lBafwht = new ArrayList();
			lBafwht.add(oldList.get(setBafwht.getBafwhtid()));
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Bafwht setBafwht=new Bafwht();
			Object[] objA={setBafwht};
			setBafwht=(Bafwht)this.setClass(setBafwht, objA);
			oldList = setBafwht.getLBafwhtList();
			oldList.add(setBafwht);
			setTabledata(setObjectIdForHtmlList(oldList)); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			List oldList = new ArrayList();
			Bafwht setBafwht=new Bafwht();
			Bafwht newBafwht=new Bafwht();
			Object[] objA={setBafwht};
			setBafwht=(Bafwht)this.setClass(setBafwht, objA);
			newBafwht=(Bafwht)this.setClass(setBafwht, null);
			oldList = setBafwht.getLBafwhtList();
			int modify = setBafwht.getBafwhtid();
			oldList.set(modify, newBafwht);
			setTabledata(setObjectIdForHtmlList(oldList)); 
		} catch (Exception e) {
			this.result="";
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Bafwht setBafwht=new Bafwht();
			Object[] objA={setBafwht};
			setBafwht=(Bafwht)this.setClass(setBafwht, objA);
			oldList = setBafwht.getLBafwhtList();
			int delId = setBafwht.getBafwhtid();
			oldList.remove(delId);
			setTabledata(setObjectIdForHtmlList(oldList));
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	public List setObjectIdForHtmlList(List allResult){
		List result = new ArrayList();
		if(allResult!=null&&allResult.size()>0){
			for(int index=0,max=allResult.size();index<max;index++){
				Bafwht temp = (Bafwht)allResult.get(index);
				temp.setBafwhtid(1);
				result.add(temp);
			}
		}
		return result;
	}
}