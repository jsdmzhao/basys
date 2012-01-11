package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Bdbjtj;
import com.aisino2.basicsystem.service.IBdbjtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Globalpar;

public class BdbjtjAction extends PageAction{
	private IBdbjtjService bdbjtjService;
	private List lBdbjtj=new ArrayList();
	private Bdbjtj bdbjtj=new Bdbjtj();
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

	public Bdbjtj getBdbjtj() {
		return bdbjtj;
	}
	
	public List getLBdbjtj() {
		return lBdbjtj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBdbjtjService(IBdbjtjService bdbjtjService) {
		this.bdbjtjService = bdbjtjService;
	}
	
	public void setTabledata(List lData,Bdbjtj setBdbjtj) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bdbjtjid");
		
		if("1".equals(setBdbjtj.getCsbz())){
			lPro.add("csbm");
			lPro.add("csmc");
		} else if("1".equals(setBdbjtj.getGxdwbz())){
			lPro.add("gxdwmc");
		} else if("1".equals(setBdbjtj.getFxjbz())){
			lPro.add("fxjmc");
		} else if("1".equals(setBdbjtj.getDsjgbz())){
			lPro.add("dsjgmc");
		}
		lPro.add("clbjcs");
		lPro.add("cyrybjcs");
		lPro.add("scrybjcs");
		lPro.add("kyclbjcs");
		lPro.add("xiaoji");

    	List lCol=new ArrayList();
    	
    	Bdbjtj getBdbjtj=new Bdbjtj();
    	
        this.setData(getBdbjtj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        try{
        	 Bdbjtj setBdbjtj=new Bdbjtj();
             Map map = new HashMap();
             setBdbjtj = (Bdbjtj)this.setClass(setBdbjtj, null);
             map.put("dsjgbz", setBdbjtj.getDsjgbz());
     		 map.put("fxjbz", setBdbjtj.getFxjbz());
     		 map.put("gxdwbz", setBdbjtj.getGxdwbz());
     		 map.put("csbz", setBdbjtj.getCsbz());
     		 map.put("dsjgdm", setBdbjtj.getDsjgdm());
     		 map.put("fxjdm", setBdbjtj.getFxjdm());
     		 map.put("gxdwdm", setBdbjtj.getGxdwdm());
     		 map.put("csbm", setBdbjtj.getCsbm());
     		 map.put("tjrq", setBdbjtj.getTjrq());
     		 map.put("tjrqzhi", setBdbjtj.getTjrqzhi());
     		 map.put("hylbdm", setBdbjtj.getHylbdm());
             Page page = bdbjtjService.getListForPage(map, pagesize, pagerow,sort,"DESC");
             totalpage=page.getTotalPages();
             totalrows=page.getTotalRows();
             lBdbjtj=page.getData();
             setTabledata(lBdbjtj,setBdbjtj); 
     		this.result="success";
        }catch (Exception e) {
	        e.printStackTrace();
	    }
        return "success";
    }
	
	public String querylistExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Bdbjtj setBdbjtj=new Bdbjtj();
            Map map = new HashMap();
            setBdbjtj = (Bdbjtj)this.setClass(setBdbjtj, null);
            map.put("dsjgbz", setBdbjtj.getDsjgbz());
    		 map.put("fxjbz", setBdbjtj.getFxjbz());
    		 map.put("gxdwbz", setBdbjtj.getGxdwbz());
    		 map.put("csbz", setBdbjtj.getCsbz());
    		 map.put("dsjgdm", setBdbjtj.getDsjgdm());
    		 map.put("fxjdm", setBdbjtj.getFxjdm());
    		 map.put("gxdwdm", setBdbjtj.getGxdwdm());
    		 map.put("csbm", setBdbjtj.getCsbm());
    		 map.put("tjrq", setBdbjtj.getTjrq());
    		 map.put("tjrqzhi", setBdbjtj.getTjrqzhi());
    		 map.put("hylbdm", setBdbjtj.getHylbdm());
    		Page page = bdbjtjService.getListForPage(map, 1, Integer.parseInt(maxRows),null,"DESC");
			session.setAttribute("jxqyxxList", page.getData());
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	
	public void querylistExcel() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Bdbjtj setBdbjtj=new Bdbjtj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("jxqyxxList"));
			lResult.add(setBdbjtj);
			this.setExcelCreate("Bdbjtj",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	public String query() throws Exception{
		try {
			Bdbjtj setBdbjtj=new Bdbjtj();
			bdbjtj=(Bdbjtj)this.setClass(setBdbjtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdbjtj=bdbjtjService.getBdbjtj(bdbjtj);
        lBdbjtj.clear();
        lBdbjtj.add(bdbjtj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Bdbjtj setBdbjtj=new Bdbjtj();
			bdbjtj=(Bdbjtj)this.setClass(setBdbjtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdbjtj=bdbjtjService.insertBdbjtj(bdbjtj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bdbjtj setBdbjtj=new Bdbjtj();
			bdbjtj=(Bdbjtj)this.setClass(setBdbjtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdbjtjService.updateBdbjtj(bdbjtj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Bdbjtj setBdbjtj=new Bdbjtj();
			bdbjtj=(Bdbjtj)this.setClass(setBdbjtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdbjtjService.deleteBdbjtj(bdbjtj);
        this.result="success";
        return "success";
    }
}