package com.aisino2.basicsystem.action;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Xctb_fj;
import com.aisino2.basicsystem.service.IXctb_fjService;
import com.aisino2.core.web.PageAction;
import com.opensymphony.xwork2.ActionContext;

public class Xctb_fjAction extends PageAction{
	private IXctb_fjService xctb_fjService;
	private List lXctb_fj = new ArrayList();
	private Xctb_fj xctb_fj = new Xctb_fj();
	private String tabledata;
	private int totalrows;
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

	public Xctb_fj getXctb_fj() {
		return xctb_fj;
	}
	
	public List getLXctb_fj() {
		return lXctb_fj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setXctb_fjService(IXctb_fjService xctb_fjService) {
		this.xctb_fjService = xctb_fjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("fjid");
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
    	lTscl.add("setXZ");//链接ID开头
    	lTscl.add("下载"); //链接显示文字
    	List lXzcz=new ArrayList();
    	
    	
    	List lCol=new ArrayList();
    	String oprflag = xctb_fj.getOprflag();
    	if("download".equals(oprflag)){
    		
        	lXzcz.add(lTscl);
        	Xctb_fj getXctb_fj=new Xctb_fj();
        	this.setData(getXctb_fj,lData,lPro,lXzcz);
    	   
    	}else if("del".equals(oprflag)){
    	   lCol.add(lDel);
    	   Xctb_fj getXctb_fj=new Xctb_fj();
           this.setData(getXctb_fj,lData,lPro,lCol);
    	}
    	
    	
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Xctb_fj setXctb_fj=new Xctb_fj();
			xctb_fj=(Xctb_fj)this.setClass(setXctb_fj, null);
			
			lXctb_fj = xctb_fjService.getListXctb_fj(xctb_fj);//xctb_fjService.getListForPage(map, pagesize, pagerow,sort,dir);
	        setTabledata(lXctb_fj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Xctb_fj setXctb_fj=new Xctb_fj();
			xctb_fj=(Xctb_fj)this.setClass(setXctb_fj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        xctb_fj=xctb_fjService.getXctb_fj(xctb_fj);
        lXctb_fj.clear();
        lXctb_fj.add(xctb_fj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Xctb_fj setXctb_fj=new Xctb_fj();
			xctb_fj=(Xctb_fj)this.setClass(setXctb_fj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        xctb_fj=xctb_fjService.insertXctb_fj(xctb_fj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Xctb_fj setXctb_fj=new Xctb_fj();
			xctb_fj=(Xctb_fj)this.setClass(setXctb_fj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        xctb_fjService.updateXctb_fj(xctb_fj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Xctb_fj setXctb_fj=new Xctb_fj();
			xctb_fj=(Xctb_fj)this.setClass(setXctb_fj, null);
			
			xctb_fjService.deleteXctb_fj(xctb_fj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
			 return "success";
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
			Xctb_fj setXctb_fj=new Xctb_fj();
			xctb_fj=(Xctb_fj)this.setClass(setXctb_fj, null);
			//System.out.println(xctb_fj.getFjid());
			xctb_fj=xctb_fjService.getXctb_fj(xctb_fj);
	        if(xctb_fj.getFjnr()!=null){
	        	
	        	response.setCharacterEncoding("UTF-8");
				response.setContentType("application/x-msdownload");
				response.addHeader("Content-Disposition","attachment;filename=\""
						+ new String(xctb_fj.getFjmc().getBytes("GB2312"), "ISO8859_1")+ "\"");
				response.getOutputStream().write(xctb_fj.getFjnr());
	        	
	        }
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		/*this.result="success";
		return "success";*/ 
	}
	
	
	
}

