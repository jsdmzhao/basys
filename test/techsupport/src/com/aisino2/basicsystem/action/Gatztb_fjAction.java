package com.aisino2.basicsystem.action;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Gatztb_fj;
import com.aisino2.basicsystem.service.IGatztb_fjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.opensymphony.xwork2.ActionContext;

public class Gatztb_fjAction extends PageAction{
	private IGatztb_fjService gatztb_fjService;
	private List lGatztb_fj=new ArrayList();
	private Gatztb_fj gatztb_fj=new Gatztb_fj();
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

	public Gatztb_fj getGatztb_fj() {
		return gatztb_fj;
	}
	
	public List getLGatztb_fj() {
		return lGatztb_fj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setGatztb_fjService(IGatztb_fjService gatztb_fjService) {
		this.gatztb_fjService = gatztb_fjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("gafjid");
		lPro.add("fjmc");
		lPro.add("fjlx");
    
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("xctb_fj_setDelete");
    	lDel.add("删除");
    	
    	/*List lDown=new ArrayList();
    	lDown.add("setDown");
    	lDown.add("下载")*/;
    	
    	List lTscl = new ArrayList();
    	lTscl.add("jyxh");//链接ID开头
    	lTscl.add("下载"); //链接显示文字
    	List lXzcz=new ArrayList();
    	
    	
    	List lCol=new ArrayList();
    	String oprflag = gatztb_fj.getOprflag();
    	if("download".equals(oprflag)){
    		
        	lXzcz.add(lTscl);
        	Gatztb_fj getXctb_fj=new Gatztb_fj();
        	this.setDataCustomer(getXctb_fj,lData,lPro,null,lXzcz);
    	   
    	}else if("del".equals(oprflag)){
    	   lCol.add(lDel);
    	   Gatztb_fj getXctb_fj=new Gatztb_fj();
           this.setData(getXctb_fj,lData,lPro,lCol);
    	}
    	this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Gatztb_fj setGatztb_fj=new Gatztb_fj();
        gatztb_fj=(Gatztb_fj)this.setClass(setGatztb_fj, null);
        Map map = new HashMap();
        map.put("gatbid", gatztb_fj.getGatbid());
        Page page = gatztb_fjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lGatztb_fj=page.getData();
        setTabledata(lGatztb_fj); 
		 this.result="success";
        return "success";
    }
	
	
	public String query() throws Exception{
		try {
			Gatztb_fj setGatztb_fj=new Gatztb_fj();
			gatztb_fj=(Gatztb_fj)this.setClass(setGatztb_fj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztb_fj=gatztb_fjService.getGatztb_fj(gatztb_fj);
        lGatztb_fj.clear();
        lGatztb_fj.add(gatztb_fj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Gatztb_fj setGatztb_fj=new Gatztb_fj();
			gatztb_fj=(Gatztb_fj)this.setClass(setGatztb_fj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztb_fj=gatztb_fjService.insertGatztb_fj(gatztb_fj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Gatztb_fj setGatztb_fj=new Gatztb_fj();
			gatztb_fj=(Gatztb_fj)this.setClass(setGatztb_fj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztb_fjService.updateGatztb_fj(gatztb_fj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Gatztb_fj setGatztb_fj=new Gatztb_fj();
			gatztb_fj=(Gatztb_fj)this.setClass(setGatztb_fj, null);
			gatztb_fj.setGatbid(null);
			gatztb_fjService.deleteGatztb_fj(gatztb_fj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        this.result="success";
        return "success";
    }
	/**
	 * 下载文件
	 * @return
	 * @throws Exception
	 */
	public void downfile() throws Exception{
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE); 
		dataxml=new String(request.getParameter("xml").getBytes("ISO8859_1"), "utf-8");
		
		FileInputStream fin = null;
		BufferedInputStream bin = null;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		try {
			Gatztb_fj setGatztb_fj=new Gatztb_fj();
			setGatztb_fj=(Gatztb_fj)this.setClass(setGatztb_fj, null);
			//System.out.println(xctb_fj.getFjid());
			setGatztb_fj=gatztb_fjService.getGatztb_fj(setGatztb_fj);
	        if(setGatztb_fj.getFjnr()!=null){
	        	
	        	response.setCharacterEncoding("UTF-8");
				response.setContentType("application/x-msdownload");
				response.addHeader("Content-Disposition","attachment;filename=\""
						+ new String(setGatztb_fj.getFjmc().getBytes("GB2312"), "ISO8859_1")+ "\"");
				response.getOutputStream().write(setGatztb_fj.getFjnr());
	        	
	        }
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		/*this.result="success";
		return "success";*/ 
	}
}