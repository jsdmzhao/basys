package com.aisino2.icksystem.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.StringUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.service.IGzrztjService;
import com.aisino2.publicsystem.domain.Qyyyrztj;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class GzrztjAction extends PageAction {
	private IGzrztjService gzrztjService;
	private List lQyyyrztj = new ArrayList();

	private Qyyyrztj qyyyrztj;

	private String tabledata = "";
	private int totalrows = 0;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/** 信息状态改变（从数字转换为汉字，友好显示列表信息） */
	private String setDict_itemList(String dict_code, String fact_value) {
		String displayName;
		Dict_item dict_item = new Dict_item();

		displayName = "";
		dict_item.setDict_code(dict_code);
		dict_item.setFact_value(fact_value);
		List list = CacheManager.getCacheDictitem(dict_item);
		if (list != null && list.size() > 0)
			displayName = ((Dict_item) list.get(0)).getDisplay_name();
		return displayName;

	}

	public void setTabledatary(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("cyrybh");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("sksj");
		lPro.add("qymc");
		lPro.add("gxdwmc");
		 
	 
		
		Qyyyrztj getQyyyrztj = new Qyyyrztj();
		this.setData(getQyyyrztj, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	public void setTabledataqy(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bqycyrybh");
		lPro.add("bqycyryxm");
		lPro.add("bqycyrybh");
		lPro.add("crqycyryxm");
		lPro.add("crqycyrybh");
		lPro.add("sksj");
		
		Qyyyrztj getQyyyrztj = new Qyyyrztj();
		this.setData(getQyyyrztj, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	public static Date toDate1(String sDate){
		Date reDate = null;
		if (sDate!=null && !sDate.equals("") ){
			
			if(sDate.length()>10)
				sDate = sDate.substring(0,10);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if (sDate.length()==10){
					//sDate=sDate.substring(0, 4)+"/"+sDate.substring(4, 6)+"/"+sDate.substring(6, 8);
					reDate = formatter.parse(sDate);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return reDate;
	}
	
	public String queryListForPagePeop() throws Exception {

		try {
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
			
			Qyyyrztj setQyyyrztj = new Qyyyrztj();
			qyyyrztj = (Qyyyrztj) this.setClass(setQyyyrztj, null);
//             if(qyyyrztj.getKsyysj()!=null){
//            	qyyyrztj.setKsyysj(toDate1(DateUtil.shortFmt(qyyyrztj.getKsyysj())));
//             }
//             if(qyyyrztj.getJsyysj()!=null){
//            	 qyyyrztj.setJsyysj(toDate1(DateUtil.shortFmt(qyyyrztj.getJsyysj())));
//             }
			
			  
			
			int beginRow = pagerow*(pagesize-1);
			int endRow  =  pagesize*pagerow;
			qyyyrztj.setBeginRow(beginRow);
			qyyyrztj.setEndRow(endRow);
			
			HttpSession session = request.getSession();
			User user = new User();
			user = (User)session.getAttribute(Constants.userKey);
			String departCode = user.getDepartment().getDepartcode();
			qyyyrztj.setGxdwbm(StringUtil.trimEven0(departCode));
			
			qyyyrztj.setSort(sort);
			qyyyrztj.setDir(dir);
			lQyyyrztj = gzrztjService.getListForPagePeop(qyyyrztj);
			totalrows = gzrztjService.getPeopRows(qyyyrztj);
			totalpage = (int)Math.ceil(totalrows/pagesize);
//			lQyyyrztj = new ArrayList();
//			totalrows = 0;
//			totalpage = 0;
			
			
			

			setTabledatary(lQyyyrztj);
			this.result = "success";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result = "查询失败";
			e.printStackTrace();
		}

		return "success";
	}

	
	//按部门


	public String queryListForPageUnit() throws Exception{
		
		
		try {
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
			
			Qyyyrztj setQyyyrztj = new Qyyyrztj();
			qyyyrztj = (Qyyyrztj) this.setClass(setQyyyrztj, null);
			
				
			
			
			int beginRow = pagerow*(pagesize-1);
			int endRow  =  pagesize*pagerow;
			qyyyrztj.setBeginRow(beginRow);
			qyyyrztj.setEndRow(endRow);
			
			HttpSession session = request.getSession();
			User user = new User();
			user = (User)session.getAttribute(Constants.userKey);
			String departCode = user.getDepartment().getDepartcode();
			qyyyrztj.setGxdwbm(StringUtil.trimEven0(departCode));
			
			qyyyrztj.setSort(sort);
			qyyyrztj.setDir(dir);
			lQyyyrztj = gzrztjService.getListForPageUnit(qyyyrztj);
			totalrows = gzrztjService.getUnitRows(qyyyrztj);
			totalpage = (int)Math.ceil(totalrows/pagesize);
//			lQyyyrztj = new ArrayList();
//			totalrows = 0;
//			totalpage = 0;
			
			
			

			setTabledataqy(lQyyyrztj);
			this.result = "success";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result = "查询失败";
			e.printStackTrace();
		}

		return "success";
		
		
		
		
		
	}
	
	
	
	public void setGzrztjService(IGzrztjService gzrztjService) {
		this.gzrztjService = gzrztjService;
	}

	public Qyyyrztj getQyyyrztj() {
		return qyyyrztj;
	}

	public List getLQyyyrztj() {
		return lQyyyrztj;
	}

}