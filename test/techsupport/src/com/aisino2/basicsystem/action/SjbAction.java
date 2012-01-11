package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Sjb;
import com.aisino2.basicsystem.service.ISjbService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class SjbAction extends PageAction{
	private ISjbService sjbService;
	private List lSjb=new ArrayList();
	private Sjb sjb=new Sjb();
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

	public Sjb getSjb() {
		return sjb;
	}
	
	public List getLSjb() {
		return lSjb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setSjbService(ISjbService sjbService) {
		this.sjbService = sjbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("sjbid");
		lPro.add("sjbm");
		lPro.add("sjbzwm");
		lPro.add("dyldx");
		lPro.add("sfjlczrz");
		lPro.add("sfxtzd");
		lPro.add("sssjkyh");
		lPro.add("zj");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Sjb getSjb=new Sjb();
    	
        this.setData(getSjb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Sjb setSjb=new Sjb();
        Map map = new HashMap();
        Page page = sjbService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lSjb=page.getData();
        setTabledata(lSjb); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Sjb setSjb=new Sjb();
			sjb=(Sjb)this.setClass(setSjb, null);
			
			String sjbidSet = sjb.getSjbidSet();
			if(sjbidSet!=null && !sjbidSet.equals("")){
				String [] sjbidArry = sjbidSet.split(",");
		       // sjb.setSjbidSet("("+sjb.getSjbidSet()+")");
			}else{
				String sjbmSet = sjb.getSjbmSet(); 
				if(sjbmSet!=null && !sjbmSet.equals("")){
					String [] sjbmArry = sjbmSet.split(",");
					sjbmSet = "";
			       // sjb.setSjbmSet("("+sjb.getSjbmSet()+")");
					for(int index=0;index<sjbmArry.length;index++){
						sjbmSet += ",'"+sjbmArry[index]+"'";
					}
					int dhIndex;
					if((dhIndex=sjbmSet.indexOf(","))>-1)
						sjbmSet = sjbmSet.substring(dhIndex+1);
					sjb.setSjbmSet(sjbmSet);
				}
			}
			lSjb = sjbService.getListSjb(sjb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Sjb setSjb=new Sjb();
			sjb=(Sjb)this.setClass(setSjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjb=sjbService.insertSjb(sjb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Sjb setSjb=new Sjb();
			sjb=(Sjb)this.setClass(setSjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjbService.updateSjb(sjb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Sjb setSjb=new Sjb();
			sjb=(Sjb)this.setClass(setSjb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjbService.deleteSjb(sjb);
        this.result="success";
        return "success";
    }
}