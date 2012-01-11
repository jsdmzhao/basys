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

import com.aisino2.basicsystem.domain.Asjgl;
import com.aisino2.basicsystem.service.IAsjglService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class AsjglAction extends PageAction{
	private IAsjglService asjglService;
	private List lAsjgl = new ArrayList();
	private Asjgl asjgl;
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

	public Asjgl getAsjgl() {
		return asjgl;
	}
	
	public List getLAsjgl() {
		return lAsjgl;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setAsjglService(IAsjglService asjglService) {
		this.asjglService = asjglService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("asjglid");
		lPro.add("qymc");
		lPro.add("ajxz");
		lPro.add("ajlb");
		lPro.add("fasj");
		lPro.add("ssdwmc");
		/*
		 * lPro.add("hylb"); lPro.add("qybm");
		 * 
		 * lPro.add("ajbh");
		 * 
		 * 
		 * 
		 * lPro.add("fadd"); lPro.add("qkms"); lPro.add("ssdwbm");
		 * 
		 * lPro.add("qysalx"); lPro.add("djr"); lPro.add("djdwbm");
		 * lPro.add("djdwmc"); lPro.add("djsj");
		 * 
		 */
    	List lModify=new ArrayList();
    	lModify.add("setModifyAsj");
    	lModify.add("修改");
    	
    	List lQuery=new ArrayList();
    	lQuery.add("setQueryXq");
    	lQuery.add("详情");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lQuery);
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Asjgl getAsjgl=new Asjgl();
    	
        this.setData(getAsjgl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		String deptCode = "";
        Asjgl setAsjgl=new Asjgl();
        Map map = new HashMap();
        asjgl = (Asjgl) this.setClass(setAsjgl, null);
        map.put("hylbdm", asjgl.getHylbdm());
		map.put("qymc", asjgl.getQymc());
		map.put("qybm", asjgl.getQybm());
		
		map.put("ajxzdm", asjgl.getAjxzdm());
		map.put("ajlbdm", asjgl.getAjlbdm());
		map.put("fasj", asjgl.getFasj());
		map.put("fasj2",asjgl.getFasj2());
		
		if (asjgl.getSsdwbm() == null || asjgl.getSsdwbm().length() == 0) {
			User user = gerUser();
			//去偶数个零
			deptCode = com.aisino2.common.StringUtil.trimEven0(user.getDepartment().getDepartcode());
		} else {
			deptCode =com.aisino2.common.StringUtil.trimEven0(asjgl.getSsdwbm());
		}
		int level=-1;
		if(asjgl.getSsdwlevel()!=null&&!"".equals(asjgl.getSsdwlevel())){
			level=asjgl.getSsdwlevel();
		}
		if(level>=3){
			map.put("ssdwbm",deptCode);
		}
        Page page = asjglService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lAsjgl=page.getData();
        
        
//      为企业名称那个地方的链结加的
		for (java.util.Iterator iter = lAsjgl.iterator(); iter.hasNext();) {
			Asjgl oneIcksl = (Asjgl) iter.next();
			oneIcksl.setQymc(oneIcksl.getQymc() + "<input type='hidden' name='cs"
					+ oneIcksl.getAsjglid() + "' value='" + oneIcksl.getQybm()
					+ "'/>");
		}
        
        setTabledata(lAsjgl); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Asjgl setAsjgl=new Asjgl();
			asjgl=(Asjgl)this.setClass(setAsjgl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        asjgl=asjglService.getAsjgl(asjgl);
        lAsjgl.clear();
        lAsjgl.add(asjgl);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Asjgl setAsjgl=new Asjgl();
			asjgl=(Asjgl)this.setClass(setAsjgl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        asjgl=asjglService.insertAsjgl(asjgl);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Asjgl setAsjgl=new Asjgl();
			asjgl=(Asjgl)this.setClass(setAsjgl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        asjglService.updateAsjgl(asjgl);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Asjgl setAsjgl=new Asjgl();
			asjgl=(Asjgl)this.setClass(setAsjgl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        asjglService.deleteAsjgl(asjgl);
        this.result="success";
        return "success";
    }
	public User gerUser() {
		int userid = 0;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		userid = user.getUserid();
		String deptCode = user.getDepartment().getDepartcode();
		return user;
	}
	
	public String queryForExport() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		session.removeAttribute("asjglExportResult");
		// User user= (User)session.getAttribute(Constants.userKey);
		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		String deptCode = "";
		try {
			Asjgl setAsjgl = new Asjgl();
			asjgl = (Asjgl) this.setClass(setAsjgl, null);
			Map map = new HashMap();
	        map.put("hylbdm", asjgl.getHylbdm());
			map.put("qymc", asjgl.getQymc());
			map.put("qybm", asjgl.getQybm());
			
			map.put("ajxzdm", asjgl.getAjxzdm());
			map.put("ajlbdm", asjgl.getAjlbdm());
			map.put("fasj", asjgl.getFasj());
			map.put("fasj2",asjgl.getFasj2());
			
			if (asjgl.getSsdwbm() == null || asjgl.getSsdwbm().length() == 0) {
				User user = gerUser();
				//去偶数个零
				deptCode = com.aisino2.common.StringUtil.trimEven0(user.getDepartment().getDepartcode());
			} else {
				deptCode =com.aisino2.common.StringUtil.trimEven0(asjgl.getSsdwbm());
			}
			map.put("ssdwbm",deptCode);
			map.put("endRow", maxRows);
			// Excel输出
			lAsjgl = asjglService.getListExportAsjgl(map, sort, dir);
			// ///cache 替换
			List lPro = new ArrayList();
			lPro.add("qymc");
			lPro.add("ajxz");
			lPro.add("ajlb");
			lPro.add("fasj");
			lPro.add("ssdwmc");
			List lcache = new ArrayList();
			
			Asjgl getAsjgl = new Asjgl();
			lAsjgl = this.getResultCache(getAsjgl.getClass().getName(), lPro, lAsjgl, lcache);
			session.setAttribute("asjglExportResult", lAsjgl);
			this.result = "success";
		} catch (IOException e) {
			e.printStackTrace();
			this.result = e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			this.result = e.getMessage();
		}
		return "success";
	}

	// 导出excel
	public void getExcelCreate() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		try {
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			// Excel输出
			List lResult = new ArrayList(); // //开头excel
			List asjglList = (List) session.getAttribute("asjglExportResult");
			Asjgl setAsjgl = new Asjgl();
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add(asjglList);
			lResult.add(setAsjgl);
			this.setExcelCreate("asjgl", lResult);
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