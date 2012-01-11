package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Kycl;
import com.aisino2.publicsystem.service.IKyclService;

public class KyclAction extends PageAction{
	private IKyclService kyclService;
	private List lKycl=new ArrayList();
	private Kycl kycl=new Kycl();
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

	public Kycl getKycl() {
		return kycl;
	}
	
	public List getLKycl() {
		return lKycl;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setKyclService(IKyclService kyclService) {
		this.kyclService = kyclService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		lPro.add("cljbxxid");
		lPro.add("kyqkclid");
		lPro.add("kyqklbbm");
		lPro.add("kyqklb");
		lPro.add("ydxxms");
		lPro.add("bgr");
		lPro.add("bgsj");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Kycl getKycl=new Kycl();
    	
        this.setData(getKycl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Kycl setKycl=new Kycl();
        Map map = new HashMap();
        Page page = kyclService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lKycl=page.getData();
        setTabledata(lKycl); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Kycl setKycl=new Kycl();
			setKycl=(Kycl)this.setClass(setKycl, null);
			setKycl=kyclService.getKycl(setKycl);
		    lKycl.clear();
		    lKycl.add(setKycl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Kycl setKycl=new Kycl();
			kycl=(Kycl)this.setClass(setKycl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        kycl=kyclService.insertKycl(kycl);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Kycl setKycl=new Kycl();
			kycl=(Kycl)this.setClass(setKycl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        kyclService.updateKycl(kycl);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Kycl setKycl=new Kycl();
			kycl=(Kycl)this.setClass(setKycl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        kyclService.deleteKycl(kycl);
        this.result="success";
        return "success";
    }
}