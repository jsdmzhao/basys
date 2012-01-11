package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Dtcxtj;
import com.aisino2.basicsystem.service.IDtcxtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class DtcxtjAction extends PageAction{
	private IDtcxtjService dtcxtjService;
	private List lDtcxtj=new ArrayList();
	private Dtcxtj dtcxtj=new Dtcxtj();
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

	public Dtcxtj getDtcxtj() {
		return dtcxtj;
	}
	
	public List getLDtcxtj() {
		return lDtcxtj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setDtcxtjService(IDtcxtjService dtcxtjService) {
		this.dtcxtjService = dtcxtjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("dtcxtjid");
		lPro.add("gjcxfaid");
		lPro.add("sjbm");
		lPro.add("zdm");
		lPro.add("zdzwm");
		lPro.add("zdlx");
		lPro.add("zdz");
		lPro.add("xsz");
		lPro.add("ppf");
		lPro.add("kskh");
		lPro.add("jskh");
		lPro.add("gxf");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Dtcxtj getDtcxtj=new Dtcxtj();
    	
        this.setData(getDtcxtj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	public void setTabledataFa(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("sjbjgid");
		lPro.add("kskh");
		lPro.add("sjbzwm");
		lPro.add("zdzwm");
		lPro.add("ppf");
		lPro.add("xsz");
		lPro.add("jskh");
		lPro.add("gxf");
    	
    	Dtcxtj getDtcxtj=new Dtcxtj();
    	
    	List lcache = new ArrayList();
		List lcacheppf = this.getDictItemCacheList("ppf", "dm_ppf", "0");
		List lcachegxf = this.getDictItemCacheList("gxf", "dm_ljf", "0");

		lcache.add(lcacheppf);
		lcache.add(lcachegxf);

		this.setDataCustomerCache(getDtcxtj, lData, lPro, null,
				new ArrayList(), lcache);
		
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Dtcxtj setDtcxtj=new Dtcxtj();
        Map map = new HashMap();
        Page page = dtcxtjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lDtcxtj=page.getData();
        setTabledata(lDtcxtj); 
		 this.result="success";
        return "success";
    }	
	
	//依据方案id查询条件列表
	public String querylistByFa() throws Exception{
		try {
		Dtcxtj setDtcxtj=new Dtcxtj();
		dtcxtj=(Dtcxtj)this.setClass(setDtcxtj, null); 
		
        lDtcxtj = dtcxtjService.getListDtcxtj(dtcxtj);
        
        for(java.util.Iterator iter=lDtcxtj.iterator();iter.hasNext();){
        	Dtcxtj oneDtcxtj = (Dtcxtj)iter.next();
        	String zdzwm = oneDtcxtj.getZdzwm();
        	String xlknr = oneDtcxtj.getXlknr();
        	if(zdzwm==null)zdzwm="";
        	if(xlknr==null)xlknr="";
        	oneDtcxtj.setZdzwm(zdzwm + "<input type='hidden' name='lx' value='"+oneDtcxtj.getZdlx()+"' />" +
        			"<input type='hidden' name='nr' value='"+xlknr+"' />");
        }
        
        setTabledataFa(lDtcxtj); 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Dtcxtj setDtcxtj=new Dtcxtj();
			dtcxtj=(Dtcxtj)this.setClass(setDtcxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dtcxtj=dtcxtjService.getDtcxtj(dtcxtj);
        lDtcxtj.clear();
        lDtcxtj.add(dtcxtj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Dtcxtj setDtcxtj=new Dtcxtj();
			dtcxtj=(Dtcxtj)this.setClass(setDtcxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dtcxtj=dtcxtjService.insertDtcxtj(dtcxtj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Dtcxtj setDtcxtj=new Dtcxtj();
			dtcxtj=(Dtcxtj)this.setClass(setDtcxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dtcxtjService.updateDtcxtj(dtcxtj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Dtcxtj setDtcxtj=new Dtcxtj();
			dtcxtj=(Dtcxtj)this.setClass(setDtcxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dtcxtjService.deleteDtcxtj(dtcxtj);
        this.result="success";
        return "success";
    }
}