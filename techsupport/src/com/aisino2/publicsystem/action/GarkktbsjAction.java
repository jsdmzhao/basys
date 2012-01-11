package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Garkktbsj;
import com.aisino2.publicsystem.service.IGarkktbsjService;

public class GarkktbsjAction extends PageAction{
	private IGarkktbsjService garkktbsjService;
	private List lGarkktbsj=new ArrayList();
	private Garkktbsj garkktbsj=new Garkktbsj();
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

	public Garkktbsj getGarkktbsj() {
		return garkktbsj;
	}
	
	public List getLGarkktbsj() {
		return lGarkktbsj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setGarkktbsjService(IGarkktbsjService garkktbsjService) {
		this.garkktbsjService = garkktbsjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("garkktbsjid");
		lPro.add("gmsfzhm");
		lPro.add("xm");
		lPro.add("xb");
		lPro.add("mz");
		lPro.add("hyzk");
		lPro.add("hjsx");
		lPro.add("hjdxz");
		lPro.add("csrq");
		lPro.add("zp");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Garkktbsj getGarkktbsj=new Garkktbsj();
    	
        this.setData(getGarkktbsj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Garkktbsj setGarkktbsj=new Garkktbsj();
        Map map = new HashMap();
        Page page = garkktbsjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lGarkktbsj=page.getData();
        setTabledata(lGarkktbsj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Garkktbsj setGarkktbsj=new Garkktbsj();
			garkktbsj=(Garkktbsj)this.setClass(setGarkktbsj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        garkktbsj=garkktbsjService.getGarkktbsj(garkktbsj);
        lGarkktbsj.clear();
        lGarkktbsj.add(garkktbsj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Garkktbsj setGarkktbsj=new Garkktbsj();
			garkktbsj=(Garkktbsj)this.setClass(setGarkktbsj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        garkktbsj=garkktbsjService.insertGarkktbsj(garkktbsj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Garkktbsj setGarkktbsj=new Garkktbsj();
			garkktbsj=(Garkktbsj)this.setClass(setGarkktbsj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        garkktbsjService.updateGarkktbsj(garkktbsj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Garkktbsj setGarkktbsj=new Garkktbsj();
			garkktbsj=(Garkktbsj)this.setClass(setGarkktbsj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        garkktbsjService.deleteGarkktbsj(garkktbsj);
        this.result="success";
        return "success";
    }
}