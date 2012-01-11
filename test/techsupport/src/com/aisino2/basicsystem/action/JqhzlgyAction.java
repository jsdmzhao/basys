package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Jqhzlgy;
import com.aisino2.basicsystem.service.IJqhzlgyService;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.User;

public class JqhzlgyAction extends PageAction {
	private IJqhzlgyService jqhzlgyService;
	private List lJqhzlgy = new ArrayList();
	private Jqhzlgy jqhzlgy = new Jqhzlgy();
	private String tabledata;
	private int totalrows;
	private String result = "";

	public void setJqhzlgyService(IJqhzlgyService jqhzlgyService) {
		this.jqhzlgyService = jqhzlgyService;
	}

	public List getLJqhzlgy() {
		return lJqhzlgy;
	}

	public void setLJqhzlgy(List jqhzlgy) {
		lJqhzlgy = jqhzlgy;
	}

	public Jqhzlgy getJqhzlgy() {
		return jqhzlgy;
	}

	public void setJqhzlgy(Jqhzlgy jqhzlgy) {
		this.jqhzlgy = jqhzlgy;
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

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("departbrevitycode");
		lPro.add("departname");
		lPro.add("bjzs");
		lPro.add("zhs");
		lPro.add("bdzhs");
		lPro.add("bszhs");
		lPro.add("kszhs");

		Jqhzlgy jqhzlgy = new Jqhzlgy();

		this.setData(jqhzlgy, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		Jqhzlgy setZtxx = new Jqhzlgy();
		jqhzlgy = (Jqhzlgy) this.setClass(setZtxx, null);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = new User();
		//获得登录用户session
		user = (User) session.getAttribute(Constants.userKey);
		// 所选公安机关的等级加参数确定的等级
		Department department = user.getDepartment();
		String gxdwlevel = String.valueOf(department.getDepartlevel().intValue() + 1);
        
		// 设定参数
		Map map = new HashMap();
		map.put("bjsj1", jqhzlgy.getBjsj1());
		map.put("bjsj2", new Date(jqhzlgy.getBjsj2().getTime()+1000*24*60*60*1));
		map.put("gxdwbm", StringUtil.trimEven0(department.getDepartcode()) + "%");
		map.put("gxdwlevel", gxdwlevel);
		map.put("hylbdm", "A");

		Page page = jqhzlgyService.getListForPage(map, pagesize, pagerow, sort, dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lJqhzlgy = page.getData();

		// 添加合计值
		Jqhzlgy totalNum;
		if (jqhzlgy.getIsQuery().equals("1")) { // 计算合计值
			totalNum = jqhzlgyService.getJqhzlgyTotalNum(map);
			session.setAttribute("totalNum", totalNum);
		} else { // 分页操作，合计值直接从session中取
			totalNum = (Jqhzlgy) session.getAttribute("totalNum");
		}

		lJqhzlgy.add(0, totalNum);

		setTabledata(lJqhzlgy);
		this.result = "success";
		return "success";
	}

}