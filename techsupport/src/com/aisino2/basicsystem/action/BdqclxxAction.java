package com.aisino2.basicsystem.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Bdqclxx;
import com.aisino2.basicsystem.service.IBdqclxxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class BdqclxxAction extends PageAction{
	private IBdqclxxService bdqclxxService;
	private List lBdqclxx=new ArrayList();
	private Bdqclxx bdqclxx=new Bdqclxx();
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

	public Bdqclxx getBdqclxx() {
		return bdqclxx;
	}
	
	public List getLBdqclxx() {
		return lBdqclxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBdqclxxService(IBdqclxxService bdqclxxService) {
		this.bdqclxxService = bdqclxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bdqclxxid");
		lPro.add("syr");
		lPro.add("hphm");
		lPro.add("clpp");
		lPro.add("clxh");
		lPro.add("fdjh");
		lPro.add("cjh");
		lPro.add("ccdjrq");
		lPro.add("ajbh");
    	
    	List lCol=new ArrayList();
    	
    	Bdqclxx getBdqclxx=new Bdqclxx();
    	
        this.setData(getBdqclxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Bdqclxx setBdqclxx=new Bdqclxx();
        Map map = new HashMap();
        try{
        	setBdqclxx = (Bdqclxx)this.setClass(setBdqclxx, null);
        	map.put("clpp",setBdqclxx.getClpp());
        	map.put("clxh",setBdqclxx.getClxh());
        	map.put("hphm",setBdqclxx.getHphm());
        	map.put("fdjh",setBdqclxx.getFdjh());
        	map.put("cjh",setBdqclxx.getCjh());
        	map.put("syr",setBdqclxx.getSyr());
        	map.put("ccdjrq",setBdqclxx.getCcdjrq());
        	map.put("ajbh",setBdqclxx.getAjbh());
        	map.put("lasjF",setBdqclxx.getLasjF());
        	map.put("lasjT",setBdqclxx.getLasjT());
        	// 高级查询条件
        	map.put("superbWhere", setBdqclxx.getSuperbWhere()); 
			map.put("superbOrderBy", setBdqclxx.getSuperbOrderBy());
        	Page page = bdqclxxService.getListForPage(map, pagesize, pagerow,sort,dir);
            totalpage=page.getTotalPages();
            totalrows=page.getTotalRows();
            lBdqclxx=page.getData();
            setTabledata(lBdqclxx); 
    		this.result="success";
        }catch(Exception e){
        	// TODO Auto-generated catch block
			e.printStackTrace();
        	this.result="";
        }
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Bdqclxx setBdqclxx=new Bdqclxx();
			bdqclxx=(Bdqclxx)this.setClass(setBdqclxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxx=bdqclxxService.getBdqclxx(bdqclxx);
        lBdqclxx.clear();
        lBdqclxx.add(bdqclxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Bdqclxx setBdqclxx=new Bdqclxx();
			bdqclxx=(Bdqclxx)this.setClass(setBdqclxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxx=bdqclxxService.insertBdqclxx(bdqclxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bdqclxx setBdqclxx=new Bdqclxx();
			bdqclxx=(Bdqclxx)this.setClass(setBdqclxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxxService.updateBdqclxx(bdqclxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Bdqclxx setBdqclxx=new Bdqclxx();
			bdqclxx=(Bdqclxx)this.setClass(setBdqclxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bdqclxxService.deleteBdqclxx(bdqclxx);
        this.result="success";
        return "success";
    }
	
	public String queryForExport() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		session.removeAttribute("bdqclxxExportResult");
		User user= (User)session.getAttribute(Constants.userKey);
		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		try {
			Bdqclxx setBdqclxx=new Bdqclxx();
	        Map map = new HashMap();
			setBdqclxx = (Bdqclxx)this.setClass(setBdqclxx, null);
        	map.put("clpp",setBdqclxx.getClpp());
        	map.put("clxh",setBdqclxx.getClxh());
        	map.put("hphm",setBdqclxx.getHphm());
        	map.put("fdjh",setBdqclxx.getFdjh());
        	map.put("cjh",setBdqclxx.getCjh());
        	map.put("syr",setBdqclxx.getSyr());
        	map.put("ccdjrq",setBdqclxx.getCcdjrq());
        	map.put("ajbh",setBdqclxx.getAjbh());
        	map.put("lasjF",setBdqclxx.getLasjF());
        	map.put("lasjT",setBdqclxx.getLasjT());
			map.put("endRow", maxRows);
			// Excel输出
			Page page = bdqclxxService.getListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("bdqclxxExportResult", page.getData());
			this.result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result = e.getMessage();
		}
		return "success";
	}
	
	// 导出excel
	public void getExcelCreateRz() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		try {
			String bbmc = request.getParameter("bbmc");

			String tabletitle = request.getParameter("tabletitle");
			// Excel输出
			List lResult = new ArrayList();//开头excel
			List bdqclxxList = (List) session.getAttribute("bdqclxxExportResult");
			Bdqclxx getBdqclxx=new Bdqclxx();
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add(bdqclxxList);
			lResult.add(getBdqclxx);
			this.setExcelCreate("bdqclxx", lResult);
			this.result = "ok";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = e.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = e.getMessage();
		}
	}
}