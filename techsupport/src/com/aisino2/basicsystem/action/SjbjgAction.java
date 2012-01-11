package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Sjb;
import com.aisino2.basicsystem.domain.Sjbjg;
import com.aisino2.basicsystem.service.ISjbjgService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class SjbjgAction extends PageAction{
	private ISjbjgService sjbjgService;
	private List lSjbjg=new ArrayList();
	private Sjbjg sjbjg=new Sjbjg();
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

	public Sjbjg getSjbjg() {
		return sjbjg;
	}
	
	public List getLSjbjg() {
		return lSjbjg;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setSjbjgService(ISjbjgService sjbjgService) {
		this.sjbjgService = sjbjgService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("sjbjgid");
		lPro.add("sjbid");
		lPro.add("zdm");
		lPro.add("zdzwm");
		lPro.add("zdlx");
		lPro.add("zdcd");
		lPro.add("qsz");
		lPro.add("px");
		lPro.add("gs");
		lPro.add("sfdjhwb");
		lPro.add("sfbt");
		lPro.add("sfzd");
		lPro.add("sfkj");
		lPro.add("sfcx");
		lPro.add("xlklx");
		lPro.add("dzxlkdqy");
		lPro.add("xlkkd");
		lPro.add("xlkgd");
		lPro.add("bz");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Sjbjg getSjbjg=new Sjbjg();
    	
        this.setData(getSjbjg,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	
	public void setTabledataXszd(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("zdm");
		lPro.add("zdzwm");

    	Sjbjg getSjbjg=new Sjbjg();
    	
        this.setData(getSjbjg,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Sjbjg setSjbjg=new Sjbjg();
        Map map = new HashMap();
        Page page = sjbjgService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lSjbjg=page.getData();
      
        setTabledata(lSjbjg); 
		 this.result="success";
        return "success";
    }
	
	public String querylistXszd() throws Exception{
		try {
			Sjbjg setSjbjg=new Sjbjg();
			sjbjg=(Sjbjg)this.setClass(setSjbjg, null);

			Sjb setSjb = new Sjb();
			Sjb sjb = (Sjb)this.setClass(setSjb, null);
			String sjbidSet = sjb.getSjbidSet();
			sjbidSet = sjbidSet.replace(sjb.getSjbid().toString(), "");
			String []sjbidArry = sjbidSet.split(",");
			
	        if(sjbjg!=null){
	        	sjbjg.setSfkj("1");
	        	sjbjg.setSfcx("1");
	        }
	        lSjbjg = sjbjgService.getListSjbjg(sjbjg);
	        
	        for(int index=0,length=sjbidArry.length;index<length;index++){
	        	if(sjbidArry[index].equals(""))
	        		continue;
	        	sjbjg.setSjbid(new Integer(sjbidArry[index]));
	        	List newList = sjbjgService.getListSjbjg(sjbjg);
	        	
	        	for(Iterator iter=newList.iterator();iter.hasNext();){
	        		Sjbjg oneSjbjg = (Sjbjg)iter.next();
	        		
	        		 for(Iterator iter2=lSjbjg.iterator();iter2.hasNext();){
	     	        	Sjbjg oneSjbjg2 = (Sjbjg)iter2.next();
	     	        	if(oneSjbjg.getZdm().equals(oneSjbjg2.getZdm())){
	     	        		iter2.remove();
	     	        	}
	     	        }
	        		
	        	}
	        }
	        
	        for(Iterator iter=lSjbjg.iterator();iter.hasNext();){
	        	Sjbjg oneSjbjg = (Sjbjg)iter.next();
	        	String xlknr = oneSjbjg.getXlknr();
	        	if(xlknr==null)xlknr="";
	        	oneSjbjg.setZdm(oneSjbjg.getSjbjgid()+"_||_"+oneSjbjg.getZdlx()+"_||_"+xlknr+"_||_"+oneSjbjg.getZdm());
	        }
	        setTabledataXszd(lSjbjg); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 this.result="success";
		    return "success";
    }
	
	public String query() throws Exception{
		try {
			Sjbjg setSjbjg=new Sjbjg();
			sjbjg=(Sjbjg)this.setClass(setSjbjg, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjbjg=sjbjgService.getSjbjg(sjbjg);
        lSjbjg.clear();
        lSjbjg.add(sjbjg);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Sjbjg setSjbjg=new Sjbjg();
			sjbjg=(Sjbjg)this.setClass(setSjbjg, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjbjg=sjbjgService.insertSjbjg(sjbjg);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Sjbjg setSjbjg=new Sjbjg();
			sjbjg=(Sjbjg)this.setClass(setSjbjg, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjbjgService.updateSjbjg(sjbjg);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Sjbjg setSjbjg=new Sjbjg();
			sjbjg=(Sjbjg)this.setClass(setSjbjg, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sjbjgService.deleteSjbjg(sjbjg);
        this.result="success";
        return "success";
    }
}