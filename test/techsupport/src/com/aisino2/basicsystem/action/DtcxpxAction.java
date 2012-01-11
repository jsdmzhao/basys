package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Dtcxpx;
import com.aisino2.basicsystem.service.IDtcxpxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class DtcxpxAction extends PageAction{
	private IDtcxpxService dtcxpxService;
	private List lDtcxpx=new ArrayList();
	private Dtcxpx dtcxpx=new Dtcxpx();
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

	public Dtcxpx getDtcxpx() {
		return dtcxpx;
	}
	
	public List getLDtcxpx() {
		return lDtcxpx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setDtcxpxService(IDtcxpxService dtcxpxService) {
		this.dtcxpxService = dtcxpxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("dtcxpxid");
		lPro.add("gjcxfaid");
		lPro.add("sjbm");
		lPro.add("zdm");
		lPro.add("zdzwm");
		lPro.add("pxfs");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Dtcxpx getDtcxpx=new Dtcxpx();
    	
        this.setData(getDtcxpx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataFa(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("sjbjgid");
		lPro.add("sjbzwm");
		lPro.add("zdzwm");
		lPro.add("pxfs");
    	
		Dtcxpx getDtcxpx=new Dtcxpx();
    	
    	List lcache = new ArrayList();
		List lcachepxfs = this.getDictItemCacheList("pxfs", "dm_pxfs", "0");

		lcache.add(lcachepxfs);

		this.setDataCustomerCache(getDtcxpx, lData, lPro, null,
				new ArrayList(), lcache);
		
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Dtcxpx setDtcxpx=new Dtcxpx();
        Map map = new HashMap();
        Page page = dtcxpxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lDtcxpx=page.getData();
        setTabledata(lDtcxpx); 
		 this.result="success";
        return "success";
    }
	
	//依据方案id查询排序列表
	public String querylistByFa() throws Exception{
		try {
			Dtcxpx setDtcxpx=new Dtcxpx();
			dtcxpx=(Dtcxpx)this.setClass(setDtcxpx, null);
        
			lDtcxpx = dtcxpxService.getListDtcxpx(dtcxpx);
        
			setTabledataFa(lDtcxpx); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			this.result="success";
	        return "success";
	}
	
	public String query() throws Exception{
		try {
			Dtcxpx setDtcxpx=new Dtcxpx();
			dtcxpx=(Dtcxpx)this.setClass(setDtcxpx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dtcxpx=dtcxpxService.getDtcxpx(dtcxpx);
        lDtcxpx.clear();
        lDtcxpx.add(dtcxpx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Dtcxpx setDtcxpx=new Dtcxpx();
			dtcxpx=(Dtcxpx)this.setClass(setDtcxpx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dtcxpx=dtcxpxService.insertDtcxpx(dtcxpx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Dtcxpx setDtcxpx=new Dtcxpx();
			dtcxpx=(Dtcxpx)this.setClass(setDtcxpx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dtcxpxService.updateDtcxpx(dtcxpx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Dtcxpx setDtcxpx=new Dtcxpx();
			dtcxpx=(Dtcxpx)this.setClass(setDtcxpx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dtcxpxService.deleteDtcxpx(dtcxpx);
        this.result="success";
        return "success";
    }
}