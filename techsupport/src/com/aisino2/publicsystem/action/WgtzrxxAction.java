package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Wgtzrxx;
import com.aisino2.publicsystem.service.IWgtzrxxService;
import com.aisino2.sysadmin.domain.Dict_item;

public class WgtzrxxAction extends PageAction{
	private IWgtzrxxService wgtzrxxService;
	private List lWgtzrxx=new ArrayList();
	private Wgtzrxx wgtzrxx=new Wgtzrxx();
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

	public Wgtzrxx getWgtzrxx() {
		return wgtzrxx;
	}
	
	public List getLWgtzrxx() {
		return lWgtzrxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setWgtzrxxService(IWgtzrxxService wgtzrxxService) {
		this.wgtzrxxService = wgtzrxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("wgtzrxxid");
		lPro.add("tzzxm");
		lPro.add("gj");
		lPro.add("hzzlmc");
		lPro.add("hzhm");
		lPro.add("qzzlmc");
		lPro.add("qzhm");
		lPro.add("lxdh");
		lPro.add("gjdm");
		lPro.add("qzzldm");
		lPro.add("hzzldm");
		
		List lCol=new ArrayList();
    	List lDel=new ArrayList();
    	lDel.add("wgtzrxx_setDelete");
        lDel.add("删除");
        lCol.add(lDel);
    	
    	Wgtzrxx getWgtzrxx=new Wgtzrxx();
    	
        this.setData(getWgtzrxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			requestType = "";
			Wgtzrxx setWgtzrxx=new Wgtzrxx();
			setWgtzrxx=(Wgtzrxx)this.setClass(setWgtzrxx, null);
			requestType = setWgtzrxx.getWgtzrxxRequetType();
			Map map = new HashMap();
			map.put("qyid", setWgtzrxx.getQyid());
			Page page = wgtzrxxService.getListForPage(map, pagesize, pagerow,null,null);
			lWgtzrxx=page.getData();
			setTabledata(lWgtzrxx); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Wgtzrxx setWgtzrxx=new Wgtzrxx();
			Object[] objA={setWgtzrxx};
			setWgtzrxx=(Wgtzrxx)this.setClass(setWgtzrxx, objA);
			oldList = setWgtzrxx.getLWgtzrxxList();
			lWgtzrxx = new ArrayList();
			setWgtzrxx = (Wgtzrxx)oldList.get(setWgtzrxx.getWgtzrxxid());
			if(setWgtzrxx!=null){
				Dict_item dict_item = this.getCacheDictItem("dm_gj(lgy)", setWgtzrxx.getGjdm(), null, null, null);
				if(dict_item!=null){
					setWgtzrxx.setGjdm(dict_item.getAppend_value());
				}
			}
	        lWgtzrxx.add(setWgtzrxx);
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
			Wgtzrxx setWgtzrxx=new Wgtzrxx();
			Object[] objA={setWgtzrxx};
			setWgtzrxx=(Wgtzrxx)this.setClass(setWgtzrxx, objA);
			oldList = setWgtzrxx.getLWgtzrxxList();
			oldList.add(setWgtzrxx);
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
			Wgtzrxx setWgtzrxx=new Wgtzrxx();
			wgtzrxx=(Wgtzrxx)this.setClass(setWgtzrxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wgtzrxxService.updateWgtzrxx(wgtzrxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Wgtzrxx setWgtzrxx=new Wgtzrxx();
			Object[] objA={setWgtzrxx};
			setWgtzrxx=(Wgtzrxx)this.setClass(setWgtzrxx, objA);
			oldList = setWgtzrxx.getLWgtzrxxList();
			int delId = setWgtzrxx.getWgtzrxxid();
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
				Wgtzrxx temp = (Wgtzrxx)allResult.get(index);
				temp.setWgtzrxxid(1);
				result.add(temp);
			}
		}
		return result;
	}
}