package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Sjbdqxxkz;
import com.aisino2.basicsystem.service.ISjbdqxxkzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class SjbdqxxkzAction extends PageAction{
	private ISjbdqxxkzService sjbdqxxkzService;
	private List lSjbdqxxkz=new ArrayList();
	private Sjbdqxxkz sjbdqxxkz=new Sjbdqxxkz();
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

	public Sjbdqxxkz getSjbdqxxkz() {
		return sjbdqxxkz;
	}
	
	public List getLSjbdqxxkz() {
		return lSjbdqxxkz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setSjbdqxxkzService(ISjbdqxxkzService sjbdqxxkzService) {
		this.sjbdqxxkzService = sjbdqxxkzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjxxid2");
		lPro.add("sjbdqxxkzid");
		lPro.add("xzqhbm");
		lPro.add("xzqh");
		lPro.add("sjch");
		lPro.add("pp");
		lPro.add("xh");
		lPro.add("ys");
		lPro.add("ajjbbm");
		lPro.add("ajjb");
		lPro.add("ajlbbm");
		lPro.add("ajlb");
		lPro.add("jyaq");
		lPro.add("djrq");
		lPro.add("djr");
		lPro.add("ladqbm");
		lPro.add("ladq");
		lPro.add("badwbm");
		lPro.add("badw");
		lPro.add("tbr");
		lPro.add("lxr");
		lPro.add("lxfs");
		lPro.add("lxrsfhm");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Sjbdqxxkz getSjbdqxxkz=new Sjbdqxxkz();
    	
        this.setData(getSjbdqxxkz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Sjbdqxxkz setSjbdqxxkz=new Sjbdqxxkz();
        Map map = new HashMap();
        Page page = sjbdqxxkzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lSjbdqxxkz=page.getData();
        setTabledata(lSjbdqxxkz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Sjbdqxxkz setSjbdqxxkz=new Sjbdqxxkz();
			sjbdqxxkz=(Sjbdqxxkz)this.setClass(setSjbdqxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjbdqxxkz=sjbdqxxkzService.getSjbdqxxkz(sjbdqxxkz);
        lSjbdqxxkz.clear();
        lSjbdqxxkz.add(sjbdqxxkz);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Sjbdqxxkz setSjbdqxxkz=new Sjbdqxxkz();
			sjbdqxxkz=(Sjbdqxxkz)this.setClass(setSjbdqxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjbdqxxkz=sjbdqxxkzService.insertSjbdqxxkz(sjbdqxxkz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Sjbdqxxkz setSjbdqxxkz=new Sjbdqxxkz();
			sjbdqxxkz=(Sjbdqxxkz)this.setClass(setSjbdqxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjbdqxxkzService.updateSjbdqxxkz(sjbdqxxkz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Sjbdqxxkz setSjbdqxxkz=new Sjbdqxxkz();
			sjbdqxxkz=(Sjbdqxxkz)this.setClass(setSjbdqxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjbdqxxkzService.deleteSjbdqxxkz(sjbdqxxkz);
        this.result="success";
        return "success";
    }
}