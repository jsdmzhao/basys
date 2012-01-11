package com.aisino2.basicsystem.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aisino2.basicsystem.domain.Qgztjx;
import com.aisino2.basicsystem.service.IQgztjxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class QgztjxAction extends PageAction {
	private IQgztjxService qgztjxService;

	private List lQgztjx = new ArrayList();

	private Qgztjx qgztjx;

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

	public Qgztjx getQgztjx() {
		return qgztjx;
	}

	public List getLQgztjx() {
		return lQgztjx;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setQgztjxService(IQgztjxService qgztjxService) {
		this.qgztjxService = qgztjxService;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qgztjxid");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("csrq");
		lPro.add("xb");
		lPro.add("hjd");
		lPro.add("hjxxdz");
		lPro.add("djrq");
		lPro.add("tbbh");

		/*
		 * 
		 * 
		 * lPro.add("xzqhbm"); lPro.add("xzqh"); lPro.add("xmpy");
		 * 
		 * lPro.add("bm"); lPro.add("xbdm");
		 * 
		 * 
		 * 
		 * lPro.add("hjdbm");
		 * 
		 * 
		 * lPro.add("xzdqbm"); lPro.add("xzdq"); lPro.add("xzdxxdz");
		 * lPro.add("qtzjlx"); lPro.add("qtzjhm"); lPro.add("ajjbbm");
		 * lPro.add("ajjb"); lPro.add("ajlbbm"); lPro.add("ajlb");
		 * lPro.add("jyaq");
		 * 
		 * lPro.add("djr"); lPro.add("ladqbm"); lPro.add("ladq");
		 * lPro.add("badwbm"); lPro.add("badw"); lPro.add("tbr");
		 * lPro.add("lxr"); lPro.add("lxfs");
		 */

		List lModify = new ArrayList();
		lModify.add("setModifyQuery");
		lModify.add("修改");

		List lDel = new ArrayList();
		lDel.add("setDelete");
		lDel.add("删除");

		List lCol = new ArrayList();
		// lCol.add(lModify);
		// lCol.add(lDel);

		Qgztjx getQgztjx = new Qgztjx();

		this.setData(getQgztjx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		Qgztjx setQgztjx = new Qgztjx();
		qgztjx = (Qgztjx) this.setClass(setQgztjx, null);
		Map map = new HashMap();
		map.put("xm", qgztjx.getXm());
		map.put("gmsfhm", qgztjx.getGmsfhm());
		map.put("xbdm", qgztjx.getXb());
		map.put("hjdbm", qgztjx.getHjdbm());
		map.put("djrq", qgztjx.getDjrq());
		map.put("tbbh", qgztjx.getTbbh());
		
		if ("1".equals(qgztjx.getSfty())) {
			map.put("xmpy", PinYinUtil.getHanyuPingYinInitial(qgztjx.getXm()));
			map.put("xm", "");
			
			//System.out.println(PinYinUtil.getHanyuPingYinInitial(qgztjx.getXm()));
		}
		
		Page page = qgztjxService.getListForPage(map, pagesize, pagerow, sort,
				dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lQgztjx = page.getData();
		setTabledata(lQgztjx);
		this.result = "success";
		return "success";
	}

	public String query() throws Exception {
		try {
			Qgztjx setQgztjx = new Qgztjx();
			qgztjx = (Qgztjx) this.setClass(setQgztjx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qgztjx = qgztjxService.getQgztjx(qgztjx);
		lQgztjx.clear();
		lQgztjx.add(qgztjx);
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Qgztjx setQgztjx = new Qgztjx();
			qgztjx = (Qgztjx) this.setClass(setQgztjx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qgztjx = qgztjxService.insertQgztjx(qgztjx);
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Qgztjx setQgztjx = new Qgztjx();
			qgztjx = (Qgztjx) this.setClass(setQgztjx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qgztjxService.updateQgztjx(qgztjx);
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Qgztjx setQgztjx = new Qgztjx();
			qgztjx = (Qgztjx) this.setClass(setQgztjx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qgztjxService.deleteQgztjx(qgztjx);
		this.result = "success";
		return "success";
	}
	
	public void getFtpUpdate() {
		Date date=new Date();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] {	"config/spring/applicationContext.xml",
								"config/spring/sysadmin-dao.xml",
								"config/spring/sysadmin-service.xml",
								"config/spring/basicsystem-dao.xml",
								"config/spring/basicsystem-service.xml",
								"config/spring/icksystem-dao.xml",
								"config/spring/icksystem-service.xml",
								"config/spring/publicsystem-service.xml",
								"config/spring/publicsystem-dao.xml"});
		//完成依赖注入
		qgztjxService = (IQgztjxService)ctx.getBean("qgztjxService");
		if (qgztjxService!=null)
			qgztjxService.getFtpUpdate();
		
	}
	
	public String queryForExport() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		session.removeAttribute("qgztjxExportResult");
		// User user= (User)session.getAttribute(Constants.userKey);
		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		try {
			Qgztjx setQgztjx = new Qgztjx();
			qgztjx = (Qgztjx) this.setClass(setQgztjx, null);
			Map map = new HashMap();
			map.put("xm", qgztjx.getXm());
			map.put("gmsfhm", qgztjx.getGmsfhm());
			map.put("xbdm", qgztjx.getXb());
			map.put("hjdbm", qgztjx.getHjdbm());
			map.put("djrq", qgztjx.getDjrq());
			map.put("tbbh", qgztjx.getTbbh());
			map.put("endRow", maxRows);
			
			
			if ("1".equals(qgztjx.getSfty())) {
				map.put("xmpy", PinYinUtil.getHanyuPingYinInitial(qgztjx.getXm()));
				map.put("xm", "");
				
				//System.out.println(PinYinUtil.getHanyuPingYinInitial(qgztjx.getXm()));
			}
			
			
			Page page = qgztjxService.getListForPage(map,1, Integer.parseInt(maxRows), sort,dir);
			lQgztjx = page.getData();
			
			// Excel输出
			//lQgztjx = qgztjxService.getListExportQgztjx(map, sort, dir);
			
			
			
			// ///cache 替换
			List lPro = new ArrayList();
			lPro.add("xm");
			lPro.add("gmsfhm");
			lPro.add("csrq");
			lPro.add("xb");
			lPro.add("hjd");
			lPro.add("hjxxdz");
			lPro.add("djrq");
			lPro.add("tbbh");
			
			List lcache = new ArrayList();
			
			Qgztjx getQgztjx = new Qgztjx();
			lQgztjx = this.getResultCache(getQgztjx.getClass().getName(), lPro, lQgztjx, lcache);
			session.setAttribute("qgztjxExportResult", lQgztjx);
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
			List qgztjxList = (List) session.getAttribute("qgztjxExportResult");
			Qgztjx setQgztjx = new Qgztjx();
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add(qgztjxList);
			lResult.add(setQgztjx);
			this.setExcelCreate("qgztjx", lResult);
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