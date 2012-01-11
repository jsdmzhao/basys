package com.aisino2.basicsystem.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Cjtj;
import com.aisino2.basicsystem.service.ICjtjService;
import com.aisino2.common.PageUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Globalpar;
import com.opensymphony.xwork2.ActionContext;

public class CjtjAction extends PageAction {
	private ICjtjService cjtjService;
	private List lCjtj = new ArrayList();
	private Cjtj cjtj = new Cjtj();
	private String tabledata;
	private int totalrows;
	private String result = "";

	public String getTabledata() {
		return tabledata;
	}

	public void setTabledata(String tabledata) {
		this.tabledata = tabledata;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("departbrevitycode");
		lPro.add("departname");
		lPro.add("jjzs");
		lPro.add("yxbjs");
		lPro.add("hfs");
		lPro.add("hfl");

		Cjtj cjtj = new Cjtj();

		this.setData(cjtj, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		Cjtj cjtj = new Cjtj();
		cjtj = (Cjtj) this.setClass(cjtj, null);

		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();

		String CjtjStasLevel; // 处警统计下属级数

		Globalpar gp = this.getCacheGlobalpar("CjtjStasLevel");
		CjtjStasLevel = gp.getGlobalparvalue();

		// 所选公安机关的等级加参数确定的等级
		String gxdwlevel = null;
		String gxdwSelfLevel = null;
		
		if("N".equals(cjtj.getIsleaf())){//科所队以上级别
			if("0".equals(CjtjStasLevel)){//管辖单位自身及其下一级
				gxdwSelfLevel = cjtj.getGxdwlevel();
				gxdwlevel = String.valueOf(1 + Integer.parseInt(cjtj.getGxdwlevel()));
			}else{
		        gxdwlevel = String.valueOf(Integer.parseInt(CjtjStasLevel) + Integer.parseInt(cjtj.getGxdwlevel()));
			}
		}else{// 科所队级别
			gxdwlevel = cjtj.getGxdwlevel();
			gxdwSelfLevel = cjtj.getGxdwlevel();
		}

		// 设定参数
		Map map = new HashMap();
		map.put("bjsj1", cjtj.getBjsj1());
		map.put("bjsj2", cjtj.getBjsj2());
		map.put("gxdwlevel", gxdwlevel);
		map.put("gxdwbm_full", cjtj.getGxdwbm_full());
		map.put("hylbdm", cjtj.getHylbdm());
		map.put("gxdwSelfLevel", gxdwSelfLevel);
		map.put("isleaf", cjtj.getIsleaf());
		
		String bool=(String)session.getAttribute("pageSate");
		Page page= null;
		//判断是否调用service进行数据查询，点击查按钮及排序需调用service进行数据查询
		if((pagesize==1&&bool==null)||sort!=null){
			page = cjtjService.getListForPage(map, 1, 999999,sort,dir);
			session.setAttribute("pageDataListSession", page.getData());
			session.setAttribute("pageSate", "true");
		}
		//Page page = cjtjService.getListForPage(map, pagesize, pagerow, sort, dir);
		//从session中获取查询结果
		List getList=(List)session.getAttribute("pageDataListSession");
		//查询结果为空
		if(getList == null){
			getList = new ArrayList(); 
		}
		// 获取查询结果的总页数、总行数
		totalpage = getList.size() / pagerow;
		totalrows = getList.size();
		lCjtj = PageUtil.pageList(getList, pagesize, pagerow);

		Cjtj totaljtj = new Cjtj();
		int intJjzs = 0;
		int intYxbjs = 0;
		int intHfs = 0;
		double douHfl = 0;
		String strHfl = "";
		for (java.util.Iterator iter = getList.iterator(); iter.hasNext();)
		{
			Cjtj oneCjtj = (Cjtj) iter.next();
			intJjzs += oneCjtj.getJjzs();
			intYxbjs += oneCjtj.getYxbjs();
			intHfs += oneCjtj.getHfs();
		}
		totaljtj.setJjzs(intJjzs);
		totaljtj.setYxbjs(intYxbjs);
		totaljtj.setHfs(intHfs);	
		totaljtj.setDepartname("合计");
		lCjtj.add(0, totaljtj);
		session.setAttribute("totalPageDataListSession", totaljtj);
		setTabledata(lCjtj);
		this.result = "success";
		return "success";
	}

	public List getLCjtj() {
		return lCjtj;
	}

	public void setLCjtj(List cjtj) {
		lCjtj = cjtj;
	}

	public Cjtj getCjtj() {
		return cjtj;
	}

	public void setCjtj(Cjtj cjtj) {
		this.cjtj = cjtj;
	}

	public void setCjtjService(ICjtjService cjtjService) {
		this.cjtjService = cjtjService;
	}

	// 导出excel
	public void getExcelCreate() throws Exception {

		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();

		try {
			// Excel输出
			List lResult = this.getExcelResponse(); // //开头excel
			Cjtj setCjtj = new Cjtj();
			lCjtj = (List) session.getAttribute("pageDataListSession");
			lCjtj.add(0,(Cjtj)session.getAttribute("totalPageDataListSession"));
			lResult.add(lCjtj);
			lResult.add(setCjtj);
			this.setExcelCreate("cjtj", lResult); // //cjtj 默认文件名字的开头excel
			lCjtj.remove(0);
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
	//20100804修改查询功能，清除session
	public String removeSession(){
		PageUtil.removeSession("pageSate");
		return this.SUCCESS;
	}
}