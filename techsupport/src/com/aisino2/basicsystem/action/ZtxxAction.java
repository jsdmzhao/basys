package com.aisino2.basicsystem.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Ztxx;
import com.aisino2.basicsystem.service.IZtxxService;
import com.aisino2.common.PageUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Globalpar;
import com.opensymphony.xwork2.ActionContext;

public class ZtxxAction extends PageAction {
	private IZtxxService ztxxService;
	private List lZtxx = new ArrayList();
	private Ztxx ztxx = new Ztxx();
	private String tabledata;
	private int totalrows;
	private String result = "";

	public List getLZtxx() {
		return lZtxx;
	}

	public void setLZtxx(List ztxx) {
		lZtxx = ztxx;
	}

	public Ztxx getZtxx() {
		return ztxx;
	}

	public void setZtxx(Ztxx ztxx) {
		this.ztxx = ztxx;
	}

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

	public void setZtxxService(IZtxxService ztxxService) {
		this.ztxxService = ztxxService;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("departbrevitycode");
		lPro.add("departname");
		lPro.add("bjzs");
		lPro.add("yxbjs");
		lPro.add("zts");
		lPro.add("lws");
		lPro.add("zhqgztrs");
		lPro.add("zhbdbkrs");
		lPro.add("bdbkydzhs");
		lPro.add("ztl");
		lPro.add("cjl");

		Ztxx ztxx = new Ztxx();

		this.setData(ztxx, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		Ztxx setZtxx = new Ztxx();
		ztxx = (Ztxx) this.setClass(setZtxx, null);

		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();

		String ZTXXStasLevel; // 抓逃信息统计下属级数
		Globalpar gp = this.getCacheGlobalpar("ZTXXStasLevel");
		ZTXXStasLevel = gp.getGlobalparvalue();

		// 所选公安机关的等级加参数确定的等级
		String gxdwlevel = null;
		String gxdwSelfLevel = null;
		
		if("N".equals(ztxx.getIsleaf())){
			if ("0".equals(ZTXXStasLevel)) {// 管辖单位自身及其下一级
				gxdwSelfLevel = ztxx.getGxdwlevel();
				gxdwlevel = String.valueOf(1 + Integer.parseInt(ztxx.getGxdwlevel()));
			} else {
				gxdwlevel = String.valueOf(Integer.parseInt(ZTXXStasLevel) + Integer.parseInt(ztxx.getGxdwlevel()));
			}
		}else{
			gxdwlevel = ztxx.getGxdwlevel();
			gxdwSelfLevel = ztxx.getGxdwlevel();
		}

		// 设定参数
		Map map = new HashMap();
		map.put("bjsj1", ztxx.getBjsj1());
		map.put("bjsj2", ztxx.getBjsj2());
		//map.put("gxdwbm", ztxx.getGxdwbm() + "%");
		map.put("gxdwbm_full", ztxx.getGxdwbm_full());
		map.put("gxdwlevel", gxdwlevel);
		map.put("hylbdm", ztxx.getHylbdm());
		map.put("gxdwSelfLevel", gxdwSelfLevel);
		map.put("isleaf", ztxx.getIsleaf());
		String bool=(String)session.getAttribute("pageSate");
		Page page = null;
		//判断是否调用service进行数据查询，点击查按钮及排序需调用service进行数据查询
		if((pagesize==1&&bool==null)||sort!=null){
			page = ztxxService.getListForPage(map, 1, 999999,sort,dir);
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
		lZtxx = PageUtil.pageList(getList, pagesize, pagerow);

		Ztxx totalZtxx = new Ztxx();
		int intBjzs = 0;
		int intYxbjs = 0;
		int intZts = 0;
		int intLws = 0;
		int intZhqgztrs = 0;
		int intZhbdbkrs = 0;
		int intBdbkydzhs = 0;
		int intCjs = 0;

		for (java.util.Iterator iter = getList.iterator(); iter.hasNext();)
		{
			Ztxx oneZtxx = (Ztxx) iter.next();
			intBjzs += oneZtxx.getBjzs();
			intYxbjs += oneZtxx.getYxbjs();
			intZts += oneZtxx.getZts();
			intLws += oneZtxx.getLws();
			intZhqgztrs += oneZtxx.getZhqgztrs();
			intZhbdbkrs += oneZtxx.getZhbdbkrs();
			intBdbkydzhs += oneZtxx.getBdbkydzhs();
			intCjs += oneZtxx.getCjs();
		}
		
		totalZtxx.setBjzs(intBjzs);
		totalZtxx.setYxbjs(intYxbjs);
		totalZtxx.setZts(intZts);
		totalZtxx.setLws(intLws);
		totalZtxx.setZhbdbkrs(intZhbdbkrs);
		totalZtxx.setZhqgztrs(intZhqgztrs);
		totalZtxx.setBdbkydzhs(intBdbkydzhs);
		totalZtxx.setCjs(intCjs);
		totalZtxx.setDepartname("合计");
		lZtxx.add(0, totalZtxx);
		session.setAttribute("totalPageDataListSession", totalZtxx);
		setTabledata(lZtxx);
		this.result = "success";
		return "success";
	}	

	// 导出excel
	public void getExcelCreate() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		try {
			// Excel输出
			List lResult = this.getExcelResponse();
			Ztxx setZtxx = new Ztxx();
			lZtxx = (List) session.getAttribute("pageDataListSession");
			lZtxx.add(0,(Ztxx)session.getAttribute("totalPageDataListSession"));
			lResult.add(lZtxx);
			lResult.add(setZtxx);
			this.setExcelCreate("ztxx", lResult);
			lZtxx.remove(0);
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