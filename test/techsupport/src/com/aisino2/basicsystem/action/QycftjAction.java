package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Qycftj;
import com.aisino2.basicsystem.service.IQycftjService;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.service.IDepartmentService;

public class QycftjAction extends PageAction {
	private IQycftjService qycftjService;
	private IDepartmentService departmentService;
	private List lQycftj = new ArrayList();
	private Qycftj qycftj = new Qycftj();
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

	public Qycftj getQycftj() {
		return qycftj;
	}

	public List getLQycftj() {
		return lQycftj;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setQycftjService(IQycftjService qycftjService) {
		this.qycftjService = qycftjService;
	}

	public void setTabledata(List lData, Qycftj setQycftj) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qycftjid");

		if ("1".equals(setQycftj.getCsbz())) {
			lPro.add("csbm");
			lPro.add("csmc");
		} else if ("1".equals(setQycftj.getGxdwbz())) {
			lPro.add("gxdwmc");
		} else if ("1".equals(setQycftj.getFxjbz())) {
			lPro.add("fxjmc");
		} else if ("1".equals(setQycftj.getDsjgbz())) {
			lPro.add("dsjgmc");
		}
		lPro.add("jgcs");
		lPro.add("fmcs");
		lPro.add("tdcs");
		lPro.add("zjcs");
		lPro.add("qtfmcs");
		lPro.add("xiaoji");

		List lCol = new ArrayList();

		Qycftj getQycftj = new Qycftj();

		this.setData(getQycftj, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		try {
			Qycftj setQycftj = new Qycftj();
			Map map = new HashMap();
			setQycftj = (Qycftj) this.setClass(setQycftj, null);
			map.put("dsjgbz", setQycftj.getDsjgbz());
			map.put("fxjbz", setQycftj.getFxjbz());
			map.put("gxdwbz", setQycftj.getGxdwbz());
			map.put("csbz", setQycftj.getCsbz());
			map.put("dsjgdm", setQycftj.getDsjgdm());
			map.put("fxjdm", setQycftj.getFxjdm());
			map.put("gxdwdm", setQycftj.getGxdwdm());
			map.put("csbm", setQycftj.getCsbm());
			map.put("tjrq", setQycftj.getTjrq());
			map.put("tjrqzhi", setQycftj.getTjrqzhi());
			map.put("hylbdm", setQycftj.getHylbdm());
			Page page = qycftjService.getListForPage(map, pagesize, pagerow,
					sort, "DESC");
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQycftj = page.getData();
			setTabledata(lQycftj, setQycftj);
			this.result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public void setTabledataBzh(List lData, Qycftj setQycftj) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qycftjid");

		if ("1".equals(setQycftj.getCsbz())) {
			lPro.add("csbm");
			lPro.add("csmc");
		} else if ("1".equals(setQycftj.getGxdwbz())) {
			lPro.add("gxdwmc");
		} else if ("1".equals(setQycftj.getFxjbz())) {
			lPro.add("fxjmc");
		} else if ("1".equals(setQycftj.getDsjgbz())) {
			lPro.add("dsjgmc");
		}
		lPro.add("jczsT");
		lPro.add("cfzsT");
		lPro.add("jlzsT");
		lPro.add("jczs");
		lPro.add("cfzs");
		lPro.add("jgcs");
		lPro.add("fmcs");
		lPro.add("tdcs");
		lPro.add("zjcs");
		lPro.add("qtfmcs");
		lPro.add("jlzs");
		lPro.add("tbbycs");
		lPro.add("wzjlcs");
		lPro.add("qtjlcs");
		List lCol = new ArrayList();

		Qycftj getQycftj = new Qycftj();

		this.setData(getQycftj, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	
	public String querylistBzh() throws Exception {
		try {
			int jczsT = 0;
			int cfzsT = 0;
			int jlzsT = 0;
			int jczs = 0;
			int cfzs = 0;
			int jgcs = 0;
			int fmcs = 0;
			int tdcs = 0;
			int zjcs = 0;
			int qtfmcs = 0;
			int jlzs = 0;
			int tbbycs = 0;
			int wzjlcs = 0;
			int qtjlcs = 0;
			Qycftj sumQycftj = new Qycftj();
			Qycftj setQycftj = new Qycftj();
			Map map = new HashMap();
			setQycftj = (Qycftj) this.setClass(setQycftj, null);
			map.put("dsjgbz", setQycftj.getDsjgbz());
			map.put("fxjbz", setQycftj.getFxjbz());
			map.put("gxdwbz", setQycftj.getGxdwbz());
			map.put("csbz", setQycftj.getCsbz());
			map.put("dsjgdm", setQycftj.getDsjgdm());
			map.put("fxjdm", setQycftj.getFxjdm());
			map.put("gxdwdm", setQycftj.getGxdwdm());
			map.put("csbm", setQycftj.getCsbm());
			map.put("qsrq", setQycftj.getTjrq());
			map.put("jzrq", setQycftj.getTjrqzhi());
			map.put("hylbdm", setQycftj.getHylbdm());
			Page page = qycftjService.getListForPageBzh(map, pagesize, pagerow,
					sort, "DESC");
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQycftj = page.getData();
			for(java.util.Iterator iter = lQycftj.iterator(); iter.hasNext();){
				Qycftj oneQycftj = (Qycftj)iter.next();
				jczsT += oneQycftj.getJczsT().intValue();
				cfzsT += oneQycftj.getCfzsT().intValue();
				jlzsT += oneQycftj.getJlzsT().intValue();
				jczs += oneQycftj.getJczs().intValue();
				cfzs += oneQycftj.getCfzs().intValue();
				jgcs += oneQycftj.getJgcs().intValue();
				fmcs += oneQycftj.getFmcs().intValue();
				tdcs += oneQycftj.getTdcs().intValue();
				zjcs += oneQycftj.getZjcs().intValue();
				qtfmcs += oneQycftj.getQtfmcs().intValue();
				jlzs += oneQycftj.getJlzs().intValue();
				tbbycs += oneQycftj.getTbbycs().intValue();
				wzjlcs += oneQycftj.getWzjlcs().intValue();
				qtjlcs += oneQycftj.getQtjlcs().intValue();
			}
			sumQycftj.setJczsT(jczsT);
			sumQycftj.setCfzsT(cfzsT);
			sumQycftj.setJlzsT(jlzsT);
			sumQycftj.setJczs(jczs);
			sumQycftj.setCfzs(cfzs);
			sumQycftj.setJgcs(jgcs);
			sumQycftj.setFmcs(fmcs);
			sumQycftj.setTdcs(tdcs);
			sumQycftj.setZjcs(zjcs);
			sumQycftj.setQtfmcs(qtfmcs);
			sumQycftj.setJlzs(jlzs);
			sumQycftj.setTbbycs(tbbycs);
			sumQycftj.setWzjlcs(wzjlcs);
			sumQycftj.setQtjlcs(qtjlcs);
			sumQycftj.setDsjgmc("总计");
			if("1".equals(setQycftj.getDsjgbz())){
			    lQycftj.add(sumQycftj);
			}
			//setTabledataBzh(lQycftj, setQycftj);
			this.result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String querylistExcelTempBzh() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();

			Qycftj setQycftj = new Qycftj();
			Map map = new HashMap();
			setQycftj = (Qycftj) this.setClass(setQycftj, null);
			map.put("dsjgbz", setQycftj.getDsjgbz());
			map.put("fxjbz", setQycftj.getFxjbz());
			map.put("gxdwbz", setQycftj.getGxdwbz());
			map.put("csbz", setQycftj.getCsbz());
			map.put("dsjgdm", setQycftj.getDsjgdm());
			map.put("fxjdm", setQycftj.getFxjdm());
			map.put("gxdwdm", setQycftj.getGxdwdm());
			map.put("csbm", setQycftj.getCsbm());
			map.put("qsrq", setQycftj.getTjrq());
			map.put("jzrq", setQycftj.getTjrqzhi());
			Page page = qycftjService.getListForPageBzh(map, 1, Integer
					.parseInt(maxRows), null, "DESC");
			session.setAttribute("jxqyxxList", page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}
	
	public void querylistExcelBzh() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Qycftj setQycftj = new Qycftj();

			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			StringBuffer sb = new StringBuffer();
			sb.append("<tr>");
			sb.append(tabletitle);
			sb.append("<th name='l_jczsT' datatype='Integer' sumflag='0'>企业奖惩总数(至截止日期)</th>");
	     	sb.append("<th name='l_cfzsT' datatype='Integer' sumflag='0'>企业处罚总数(至截止日期)</th>");
	     	sb.append("<th name='l_jlzsT' datatype='Integer' sumflag='0'>企业奖励总数(至截止日期)</th>");
	     	sb.append("<th name='l_jczs' datatype='Integer' sumflag='0'>企业奖惩总数(周期内新增)</th>");
			sb.append("<th name='l_cfzs' datatype='Integer' sumflag='0'>企业处罚总数(周期内新增)</th>");
			sb.append("<th name='l_jgcs' datatype='Integer' sumflag='0'>警告次数(周期内新增)</th>");
			sb.append("<th name='l_fmcs' datatype='Integer' sumflag='0'>罚没次数(周期内新增)</th>");
			sb.append("<th name='l_tdcs' datatype='Integer' sumflag='0'>停吊次数(周期内新增)</th>");
			sb.append("<th name='l_zjcs' datatype='Integer' sumflag='0'>追究次数(周期内新增)</th>");
			sb.append("<th name='l_qtfmcs' datatype='Integer' sumflag='0'>其他处罚次数(周期内新增)</th>");
			sb.append("<th name='l_jlzs' datatype='Integer' sumflag='0'>企业奖励总数(周期内新增)</th>");
			sb.append("<th name='l_tbbycs' datatype='Integer' sumflag='0'>通报表扬次数(周期内新增)</th>");
			sb.append("<th name='l_wzjlcs' datatype='Integer' sumflag='0'>物质奖励次数(周期内新增)</th>");
			sb.append("<th name='l_qtjlcs' datatype='Integer' sumflag='0'>其他奖励次数(周期内新增)</th>");
			sb.append("</tr>");

			List lColumn = this.getExcelColumn(sb.toString());
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List) session.getAttribute("jxqyxxList"));
			lResult.add(setQycftj);
			this.setExcelCreate("Qycftj", lResult); // //ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
		}
		this.result = "success";
	}

	public String querylistExcelTemp() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();

			Qycftj setQycftj = new Qycftj();
			Map map = new HashMap();
			setQycftj = (Qycftj) this.setClass(setQycftj, null);
			map.put("dsjgbz", setQycftj.getDsjgbz());
			map.put("fxjbz", setQycftj.getFxjbz());
			map.put("gxdwbz", setQycftj.getGxdwbz());
			map.put("csbz", setQycftj.getCsbz());
			map.put("dsjgdm", setQycftj.getDsjgdm());
			map.put("fxjdm", setQycftj.getFxjdm());
			map.put("gxdwdm", setQycftj.getGxdwdm());
			map.put("csbm", setQycftj.getCsbm());
			map.put("tjrq", setQycftj.getTjrq());
			map.put("tjrqzhi", setQycftj.getTjrqzhi());
			map.put("hylbdm", setQycftj.getHylbdm());
			Page page = qycftjService.getListForPage(map, 1, Integer
					.parseInt(maxRows), null, "DESC");
			session.setAttribute("jxqyxxList", page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public void querylistExcel() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Qycftj setQycftj = new Qycftj();

			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel

			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List) session.getAttribute("jxqyxxList"));
			lResult.add(setQycftj);
			this.setExcelCreate("Qycftj", lResult); // //ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
		}
		this.result = "success";
	}

	public String query() throws Exception {
		try {
			Qycftj setQycftj = new Qycftj();
			qycftj = (Qycftj) this.setClass(setQycftj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qycftj = qycftjService.getQycftj(qycftj);
		lQycftj.clear();
		lQycftj.add(qycftj);
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Qycftj setQycftj = new Qycftj();
			qycftj = (Qycftj) this.setClass(setQycftj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qycftj = qycftjService.insertQycftj(qycftj);
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Qycftj setQycftj = new Qycftj();
			qycftj = (Qycftj) this.setClass(setQycftj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qycftjService.updateQycftj(qycftj);
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Qycftj setQycftj = new Qycftj();
			qycftj = (Qycftj) this.setClass(setQycftj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qycftjService.deleteQycftj(qycftj);
		this.result = "success";
		return "success";
	}

	/**
	 * 印章业企业处罚统计
	 * 
	 * @return
	 * @throws Exception
	 */
	public String querylistYz() throws Exception {
		try {
			Qycftj setQycftj = new Qycftj();
			setQycftj = (Qycftj) this.setClass(setQycftj, null);

			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			// User user = new User();
			// //获得登录用户session
			// user = (User) session.getAttribute(Constants.userKey);
			// 所选公安机关的等级加参数确定的等级
			Department department = new Department();
			department.setDepartcode(setQycftj.getGxdwdm());
			department = departmentService.getDepartment(department);

			String gxdwlevel = String.valueOf(department.getDepartlevel()
					.intValue() + 1);

			Map map = new HashMap();
			map.put("gxdwbm", StringUtil.trimEven0(department.getDepartcode())
					+ "%");
			map.put("gxdwbmall", department.getDepartcode());
			map.put("gxdwlevel", gxdwlevel);
			map.put("qssj", setQycftj.getQssj());
			map.put("jzsj", setQycftj.getJzsj());
			map.put("hylbdm", "B"); // /先固定为印章业
			session.setAttribute("mapForExcel", map);
			Page page = qycftjService.getListForPageAlldw(map, pagesize,
					pagerow, sort, "DESC");

			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQycftj = page.getData();

			Qycftj totalNum;

			if (setQycftj.getIsQuery().equals("1")) { // 计算合计值
				totalNum = qycftjService.getQycftjTotalNum(map);
				session.setAttribute("totalNum", totalNum);
			} else { // 分页操作，合计值直接从session中取
				totalNum = (Qycftj) session.getAttribute("totalNum");
			}
			lQycftj.add(0, totalNum);
			setTabledataYz(lQycftj, setQycftj);
			this.result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public void setTabledataYz(List lData, Qycftj setQycftj) throws Exception {
		List lPro = new ArrayList();

		lPro.add("gxdwdm");
		lPro.add("gxdwmc");

		lPro.add("xiaoji");
		lPro.add("jgcs");
		lPro.add("fmcs");
		lPro.add("tdcs");
		lPro.add("zjcs");
		lPro.add("qtfmcs");

		List lCol = new ArrayList();

		Qycftj getQycftj = new Qycftj();

		this.setData(getQycftj, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String queryqycflistExcelTemp() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();

			Qycftj setQycftj = new Qycftj();
			Map map = (Map) session.getAttribute("mapForExcel");
			Page page = qycftjService.getListForPageAlldw(map, 1, Integer
					.parseInt(maxRows), null, "DESC");
			session.setAttribute("jxqyxxList", page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
}