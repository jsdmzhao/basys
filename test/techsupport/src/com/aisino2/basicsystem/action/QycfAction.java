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

import com.aisino2.basicsystem.domain.Qycf;
import com.aisino2.basicsystem.service.IQycfService;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class QycfAction extends PageAction {
	private IQycfService qycfService;

	private List lQycf = new ArrayList();

	private Qycf qycf;

	private String tabledata;

	private int totalrows;

	private String result = "";

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Qycf getQycf() {
		return qycf;
	}

	public List getLQycf() {
		return lQycf;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setQycfService(IQycfService qycfService) {
		this.qycfService = qycfService;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qycfid");
		lPro.add("qymc");
		lPro.add("cfjg");
		lPro.add("cfrq");
		lPro.add("djsj");
		lPro.add("ssdwmc");
		/*
		 * 
		 * 
		 * lPro.add("hylb"); lPro.add("qybm");
		 * 
		 * lPro.add("ssdwbm");
		 * 
		 * lPro.add("wgqkms"); lPro.add("cfyj"); lPro.add("cflx");
		 * 
		 * lPro.add("pzjgbm"); lPro.add("pzjgmc"); lPro.add("pzrxm");
		 * lPro.add("cfzxrxm");
		 * 
		 * 
		 * lPro.add("djr");
		 */

		// 这里需要根据flag参数来决定操作那要些什么项目
		Qycf setQycf = new Qycf();
		qycf = (Qycf) this.setClass(setQycf, null);
		String flag = qycf.getFlag();
		List lModify = new ArrayList();
		List lDel = new ArrayList();
		List lCol = new ArrayList();
		// 如果是管理菜单，则加入操作项
		if ("manage".equals(flag)) {
			lModify.add("setModifyQuery");
			lModify.add("修改");
			lDel.add("setDelete");
			lDel.add("删除");
			lCol.add(lModify);
			lCol.add(lDel);
			// 如果是注销页面，则只要加入注销标识,查询菜单没有操作项
		}else if("query".equals(flag)){
			lModify.add("setQycfXq");
			lModify.add("详细信息");
			lCol.add(lModify);
		}

		Qycf getQycf = new Qycf();

		this.setData(getQycf, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		Qycf setQycf = new Qycf();
		qycf = (Qycf) this.setClass(setQycf, null);
		Map map = new HashMap();

		map.put("cflbbm", qycf.getCflbbm());
		map.put("hylb", qycf.getHylb());
		map.put("qymc", qycf.getQymc());
		map.put("qybm", qycf.getQybm());
		if (qycf.getSsdwbm() == null || qycf.getSsdwbm().length() == 0) {
			User user = gerUser();
			String code=user.getDepartment().getDepartcode();
			code=StringUtil.trimEven0(code);
			map.put("ssdwbm", code);
		} else {
			map.put("ssdwbm", qycf.getSsdwbm());
		}
		map.put("cfjg", qycf.getCfjg());
		map.put("cfrq", qycf.getCfrq());
		map.put("cfrq2", qycf.getCfrq2());
		
		
		Page page = qycfService.getListForPage(map, pagesize, pagerow, sort,
				dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();

		lQycf = new ArrayList();
		lQycf = page.getData();

		// 为企业名称那个地方的链结加的
		for (java.util.Iterator iter = lQycf.iterator(); iter.hasNext();) {
			Qycf oneIcksl = (Qycf) iter.next();
			oneIcksl.setQymc(oneIcksl.getQymc() + "<input type='hidden' name='cs"
					+ oneIcksl.getQycfid() + "' value='" + oneIcksl.getQybm()
					+ "'/>");
		}

		setTabledata(lQycf);
		this.result = "success";
		return "success";
	}

	public String query() throws Exception {
		try {
			Qycf setQycf = new Qycf();
			qycf = (Qycf) this.setClass(setQycf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qycf = qycfService.getQycf(qycf);
		lQycf.clear();
		lQycf.add(qycf);
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Qycf setQycf = new Qycf();
			qycf = (Qycf) this.setClass(setQycf, null);
			//qycf.setCflx(qycf.getCfjgdm());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qycf = qycfService.insertQycf(qycf);
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Qycf setQycf = new Qycf();
			qycf = (Qycf) this.setClass(setQycf, null);
			//qycf.setCflx(qycf.getCfjgdm());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qycfService.updateQycf(qycf);
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Qycf setQycf = new Qycf();
			qycf = (Qycf) this.setClass(setQycf, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qycfService.deleteQycf(qycf);
		this.result = "success";
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
		session.removeAttribute("qycfExportResult");
		// User user= (User)session.getAttribute(Constants.userKey);
		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		try {
			Qycf setQycf = new Qycf();
			qycf = (Qycf) this.setClass(setQycf, null);
			Map map = new HashMap();
			
			map.put("cflbbm", qycf.getCflbbm());
			map.put("hylb", qycf.getHylb());
			map.put("qymc", qycf.getQymc());
			map.put("qybm", qycf.getQybm());
			if (qycf.getSsdwbm() == null || qycf.getSsdwbm().length() == 0) {
				User user = gerUser();
				map.put("ssdwbm", user.getDepartment().getDepartcode().subSequence(
						0, 6));
			} else {
				map.put("ssdwbm", qycf.getSsdwbm());
			}
			map.put("cfjg", qycf.getCfjg());
			map.put("cfrq", qycf.getCfrq());
			map.put("cfrq2", qycf.getCfrq2());
			map.put("endRow", maxRows);
			// Excel输出
			lQycf = qycfService.getListExportQycf(map, sort, dir);
			// ///cache 替换
			List lPro = new ArrayList();
			lPro.add("qymc");
			lPro.add("cfjg");
			lPro.add("cfrq");
			lPro.add("djsj");
			lPro.add("ssdwmc");
			
			List lcache = new ArrayList();

			Qycf getQycf = new Qycf();
			lQycf = this.getResultCache(getQycf.getClass().getName(), lPro, lQycf, lcache);
			session.setAttribute("qycfExportResult", lQycf);
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
			List qycfList = (List) session.getAttribute("qycfExportResult");
			Qycf setQycf = new Qycf();
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add(qycfList);
			lResult.add(setQycf);
			this.setExcelCreate("qycf", lResult);
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