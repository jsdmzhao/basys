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

import com.aisino2.basicsystem.domain.Gzdx;
import com.aisino2.basicsystem.service.IGzdxService;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class GzdxAction extends PageAction {
	private IGzdxService gzdxService;

	private List lGzdx = new ArrayList();

	private Gzdx gzdx;

	private String tabledata;

	private int totalrows;

	private String strResult;

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

	public Gzdx getGzdx() {
		return gzdx;
	}

	public List getLGzdx() {
		return lGzdx;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setGzdxService(IGzdxService gzdxService) {
		this.gzdxService = gzdxService;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("gzdxid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("csrq");
		lPro.add("minzu");
		lPro.add("whcd");
		lPro.add("hjdxzqh");
		lPro.add("hjdxz");
	
		// 这里需要根据flag参数来决定操作那要些什么项目
		Gzdx setGzdx = new Gzdx();
		gzdx = (Gzdx) this.setClass(setGzdx, null);
		String flag = gzdx.getFlag();
		List lModify = new ArrayList();
		List lDel = new ArrayList();
		List lCol = new ArrayList();
		// 如果是管理菜单，则加入操作项
		if ("manage".equals(flag)) {
			lPro.add("num");
			lPro.add("zxbz");
			lModify.add("setModifyQuery");
			lModify.add("修改");
			lDel.add("setDelete");
			lDel.add("删除");
			lCol.add(lModify);
			lCol.add(lDel);
			// 如果是注销页面，则只要加入注销标识,查询菜单没有操作项
		} else if ("cancel".equals(flag)) {
			lPro.add("num");
			
			lDel.add("setModifyQuery");
			lDel.add("注销");
			lCol.add(lDel);
		}

		Gzdx getGzdx = new Gzdx();

		this.setData(getGzdx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		Gzdx setGzdx = new Gzdx();
		gzdx = (Gzdx) this.setClass(setGzdx, null);
		Map map = new HashMap();
		map.put("xm", gzdx.getXm());
		map.put("xb", gzdx.getXb());
		map.put("zjhm", gzdx.getZjhm());
		map.put("csrq", gzdx.getCsrq());
		map.put("csrq2", gzdx.getCsrq2());
		map.put("mzdm", gzdx.getMzdm());
		map.put("hjdxzqhdm", gzdx.getHjdxzqhdm());
		map.put("hylbdm", gzdx.getHylbdm());
		User user = (User)this.getRequest().getSession().getAttribute(Constants.userKey);
		if(user!=null){
			String dqdwbm = user.getDepartment().getDepartcode();
			int level = user.getDepartment().getDepartlevel().intValue();
			if(level>=3)
				map.put("tbdabm",StringUtil.trimEven0(dqdwbm)+"%");
			map.put("dqdwbm",dqdwbm);
		}
		
		// 如果查询菜单是注销管理，则应该要加一个默认条件为未注销
		if ("cancel".equals(gzdx.getFlag())) {
			map.put("zxbz", "0");
		}
		//如果选择了姓名拼音的同音查询，则需要得到姓名的拼音
		if("1".equals(gzdx.getTyCheck())){
			map.put("xmpy", PinYinUtil.getHanyuPingYin(gzdx.getXm()));
			map.put("xm", "");
		}
		Page page = gzdxService.getListForPage(map, pagesize, pagerow, sort,
				dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lGzdx = page.getData();
		setTabledata(lGzdx);
		this.result = "success";
		return "success";
	}

	public String query() throws Exception {
		try {
			Gzdx setGzdx = new Gzdx();
			gzdx = (Gzdx) this.setClass(setGzdx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gzdx = gzdxService.getGzdx(gzdx);
		lGzdx.clear();
		lGzdx.add(gzdx);
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Gzdx setGzdx = new Gzdx();
			gzdx = (Gzdx) this.setClass(setGzdx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gzdx = gzdxService.insertGzdx(gzdx);
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Gzdx setGzdx = new Gzdx();
			gzdx = (Gzdx) this.setClass(setGzdx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gzdxService.updateGzdx(gzdx);
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Gzdx setGzdx = new Gzdx();
			gzdx = (Gzdx) this.setClass(setGzdx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gzdxService.deleteGzdx(gzdx);
		this.result = "success";
		return "success";
	}

	public String validateZjhm() {
		try {
			Gzdx setGzdx = new Gzdx();
			gzdx = (Gzdx) this.setClass(setGzdx, null);

			strResult = gzdxService.validateZjhm(gzdx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public String getStrResult() {
		return strResult;
	}

	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}
	
	public String queryForExport() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		session.removeAttribute("gzdxExportResult");
		// User user= (User)session.getAttribute(Constants.userKey);
		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		try {
			Gzdx setGzdx = new Gzdx();
			gzdx = (Gzdx) this.setClass(setGzdx, null);
			Map map = new HashMap();
			map.put("xm", gzdx.getXm());
			map.put("xb", gzdx.getXb());
			map.put("zjhm", gzdx.getZjhm());
			map.put("csrq", gzdx.getCsrq());
			map.put("csrq2", gzdx.getCsrq2());
			map.put("mzdm", gzdx.getMzdm());
			map.put("hjdxzqhdm", gzdx.getHjdxzqhdm());
			//如果选择了姓名拼音的同音查询，则需要得到姓名的拼音
			if("1".equals(gzdx.getTyCheck())){
				map.put("xmpy", PinYinUtil.getHanyuPingYin(gzdx.getXm()));
				map.put("xm", "");
			}
			map.put("endRow", maxRows);
			// Excel输出
			lGzdx = gzdxService.getListExportGzdx(map, sort, dir);
			// ///cache 替换
			List lPro = new ArrayList();
			lPro.add("xm");
			lPro.add("zjhm");
			lPro.add("xb");
			lPro.add("csrq");
			lPro.add("minzu");
			lPro.add("whcd");
			lPro.add("hjdxzqh");
			lPro.add("hjdxz");
			List lcache = new ArrayList();
			/*List lcache_mz = this.getDictItemCacheList("minzu", "dm_mz", "0"); //民族替换  "0"为不加列  "1"替换列
			lcache.add(lcache_mz);
			List lcache_xb = this.getDictItemCacheList("xingbie", "dm_xb", "0"); // 性别  "0"为不加列  "1"替换列
			lcache.add(lcache_xb);*/
			Gzdx getGzdx = new Gzdx();
			lGzdx = this.getResultCache(getGzdx.getClass().getName(), lPro, lGzdx, lcache);
			session.setAttribute("gzdxExportResult", lGzdx);
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
			List gzdxList = (List) session.getAttribute("gzdxExportResult");
			Gzdx setGzdx = new Gzdx();
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add(gzdxList);
			lResult.add(setGzdx);
			this.setExcelCreate("gzdx", lResult);
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