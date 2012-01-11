package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyfltj;
import com.aisino2.publicsystem.domain.Rylbtj;
import com.aisino2.publicsystem.service.IQyfltjService;
import com.aisino2.publicsystem.service.IRylbtjService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class QyfltjAction extends PageAction {
	private IQyfltjService qyfltjService;
	private IRylbtjService rylbtjService;
	private List lQyfltj = new ArrayList();
	private Qyfltj qyfltj = new Qyfltj();
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

	public Qyfltj getQyfltj() {
		return qyfltj;
	}

	public List getLQyfltj() {
		return lQyfltj;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setQyfltjService(IQyfltjService qyfltjService) {
		this.qyfltjService = qyfltjService;
	}

	public void setTabledata(List lData, Qyfltj qyfltj) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qyfltjid");
		if ("1".equals(qyfltj.getGxdwbz())) {
			lPro.add("gxdwmc");
		} else if ("1".equals(qyfltj.getFxjbz())) {
			lPro.add("fxjmc");
		} else if ("1".equals(qyfltj.getDsjgbz())) {
			lPro.add("dsjgmc");
		}
		lPro.add("hjT");
		lPro.add("gwylT");
		lPro.add("yysdzyxtT");
		lPro.add("qtylcsT");
		lPro.add("snxyamT");
		lPro.add("mrmfzyT");
		lPro.add("qtfwcsT");
		lPro.add("hj");
		lPro.add("gwyl");
		lPro.add("yysdzyxt");
		lPro.add("qtylcs");
		lPro.add("snxyam");
		lPro.add("mrmfzy");
		lPro.add("qtfwcs");

		Qyfltj getQyfltj = new Qyfltj();

		this.setData(getQyfltj, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		try {
			int hjT = 0;
			int gwylT = 0;
			int yysdzyxtT = 0;
			int qtylcsT = 0;
			int snxyamT = 0;
			int mrmfzyT = 0;
			int qtfwcsT = 0;
			int hj = 0;
			int gwyl = 0;
			int yysdzyxt = 0;
			int qtylcs = 0;
			int snxyam = 0;
			int mrmfzy = 0;
			int qtfwcs = 0;
			Qyfltj sumQyfltj = new Qyfltj();
			Qyfltj setQyfltj = new Qyfltj();
			setQyfltj = (Qyfltj) this.setClass(setQyfltj, null);
			Map map = new HashMap();
			map.put("dsjgdm", setQyfltj.getDsjgdm());
			map.put("fxjdm", setQyfltj.getFxjdm());
			map.put("gxdwdm", setQyfltj.getGxdwdm());
			map.put("dsjgbz", setQyfltj.getDsjgbz());
			map.put("fxjbz", setQyfltj.getFxjbz());
			map.put("gxdwbz", setQyfltj.getGxdwbz());
			map.put("qsrq", setQyfltj.getQsrq());
			map.put("jzrq", setQyfltj.getJzrq());
			map.put("hylbdm", setQyfltj.getHylbdm());
			/***********new source 20101028*******************/
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
			User user= (User)session.getAttribute(Constants.userKey);
			String departTemp = user.getDepartment().getDepartcode();
			String sjName = "";// 市局名称(直辖市)
			if(departTemp.substring(0,2).equals("11")){
				sjName = "北京市公安局";
			}else if(departTemp.substring(0,2).equals("12")){
				sjName = "天津市公安局";
			}else if(departTemp.substring(0,2).equals("31")){
				sjName = "上海市公安局";
			}else if(departTemp.substring(0,2).equals("50")){
				sjName = "重庆市公安局";
			}
			if(departTemp.substring(0,2).equals("11")//属于四个直辖市
					||departTemp.substring(0,2).equals("12")
					||departTemp.substring(0,2).equals("31")
					||departTemp.substring(0,2).equals("50")){
				if("1".equals(setQyfltj.getGxdwbz())){
					setQyfltj.setGxdwbz("0");
					setQyfltj.setFxjbz("1");
					setQyfltj.setDsjgbz("1");
		        }else{
		            if("1".equals(setQyfltj.getFxjbz())){
		            	setQyfltj.setFxjbz("0");
						setQyfltj.setDsjgbz("1");
		            }else{
		            	setQyfltj.setDsjgbz("0");
		            }
		        }
			}
			if("1".equals(setQyfltj.getGxdwbz())){
				map.put("deptleave", "5");
			}else if("1".equals(setQyfltj.getFxjbz())){
				map.put("deptleave", "4");
			}else if("1".equals(setQyfltj.getDsjgbz())){
				map.put("deptleave", "3");
			}else{
				map.put("deptleave", "2");
			}
			if(setQyfltj.getGxdwdm()!=null&&!"".equals(setQyfltj.getGxdwdm())){
				map.put("deptcode", StringUtil.trimEven0(setQyfltj.getGxdwdm()));
			}else if(setQyfltj.getFxjdm()!=null&&!"".equals(setQyfltj.getFxjdm())){
				map.put("deptcode", StringUtil.trimEven0(setQyfltj.getFxjdm()));
			}else if(setQyfltj.getDsjgdm()!=null&&!"".equals(setQyfltj.getDsjgdm())){
				map.put("deptcode", StringUtil.trimEven0(setQyfltj.getDsjgdm()));
			}else{
				map.put("deptcode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			}
			/***********new source 20101028*******************/
			Page page = qyfltjService.getListForPage(map, pagesize, pagerow,
					sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQyfltj = page.getData();
			for (java.util.Iterator iter = lQyfltj.iterator(); iter.hasNext();) {
				Qyfltj oneQyfltj = (Qyfltj) iter.next();
				if(!"".equals(sjName)){
					oneQyfltj.setDsjgmc(sjName);
				}
				hjT += oneQyfltj.getHjT().intValue();
				gwylT += oneQyfltj.getGwylT().intValue();
				yysdzyxtT += oneQyfltj.getYysdzyxtT().intValue();
				qtylcsT += oneQyfltj.getQtylcsT().intValue();
				snxyamT += oneQyfltj.getSnxyamT().intValue();
				mrmfzyT += oneQyfltj.getMrmfzyT().intValue();
				qtfwcsT += oneQyfltj.getQtfwcsT().intValue();
				hj += oneQyfltj.getHj().intValue();
				gwyl += oneQyfltj.getGwyl().intValue();
				yysdzyxt += oneQyfltj.getYysdzyxt().intValue();
				qtylcs += oneQyfltj.getQtylcs().intValue();
				snxyam += oneQyfltj.getSnxyam().intValue();
				mrmfzy += oneQyfltj.getMrmfzy().intValue();
				qtfwcs += oneQyfltj.getQtfwcs().intValue();
			}
			sumQyfltj.setHjT(hjT);
			sumQyfltj.setGwylT(gwylT);
			sumQyfltj.setYysdzyxtT(yysdzyxtT);
			sumQyfltj.setQtylcsT(qtylcsT);
			sumQyfltj.setSnxyamT(snxyamT);
			sumQyfltj.setMrmfzyT(mrmfzyT);
			sumQyfltj.setQtfwcsT(qtfwcsT);
			sumQyfltj.setHj(hj);
			sumQyfltj.setGwyl(gwyl);
			sumQyfltj.setYysdzyxt(yysdzyxt);
			sumQyfltj.setQtylcs(qtylcs);
			sumQyfltj.setSnxyam(snxyam);
			sumQyfltj.setMrmfzy(mrmfzy);
			sumQyfltj.setQtfwcs(qtfwcs);
			sumQyfltj.setDsjgmc("总计");
			if("1".equals(setQyfltj.getDsjgbz())){
			    lQyfltj.add(sumQyfltj);
			}
			// setTabledata(lQyfltj,setQyfltj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public String xxcjqkTJ() throws Exception {
		try {
			int qczlqy = 0;
			int qczlry = 0;
			int escqy = 0;
			int escry = 0;
			int esjqy = 0;
			int esjry = 0;
			int jxqy = 0;
			int jxry = 0;
			int czcqy = 0;
			int czcry = 0;
			int ryhj = 0;
			int qyhj = 0;
			Qyfltj sumQyfltj = new Qyfltj();
			Qyfltj setQyfltj = new Qyfltj();
			setQyfltj = (Qyfltj) this.setClass(setQyfltj, null);
			Map map = new HashMap();
			map.put("dsjgdm", setQyfltj.getDsjgdm());
			map.put("fxjdm", setQyfltj.getFxjdm());
			map.put("gxdwdm", setQyfltj.getGxdwdm());
			map.put("dsjgbz", setQyfltj.getDsjgbz());
			map.put("fxjbz", setQyfltj.getFxjbz());
			map.put("gxdwbz", setQyfltj.getGxdwbz());
			map.put("qsrq", setQyfltj.getQsrq());
			map.put("jzrq", setQyfltj.getJzrq());
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
			User user= (User)session.getAttribute(Constants.userKey);
			String departTemp = user.getDepartment().getDepartcode();
			String sjName = "";// 市局名称(直辖市)
			if(departTemp.substring(0,2).equals("11")){
				sjName = "北京市公安局";
			}else if(departTemp.substring(0,2).equals("12")){
				sjName = "天津市公安局";
			}else if(departTemp.substring(0,2).equals("31")){
				sjName = "上海市公安局";
			}else if(departTemp.substring(0,2).equals("50")){
				sjName = "重庆市公安局";
			}
			if(departTemp.substring(0,2).equals("11")//属于四个直辖市
					||departTemp.substring(0,2).equals("12")
					||departTemp.substring(0,2).equals("31")
					||departTemp.substring(0,2).equals("50")){
				if("1".equals(setQyfltj.getGxdwbz())){
					setQyfltj.setGxdwbz("0");
					setQyfltj.setFxjbz("1");
					setQyfltj.setDsjgbz("1");
		        }else{
		            if("1".equals(setQyfltj.getFxjbz())){
		            	setQyfltj.setFxjbz("0");
						setQyfltj.setDsjgbz("1");
		            }else{
		            	setQyfltj.setDsjgbz("0");
		            }
		        }
			}
			if("1".equals(setQyfltj.getGxdwbz())){
				map.put("deptleave", "5");
			}else if("1".equals(setQyfltj.getFxjbz())){
				map.put("deptleave", "4");
			}else if("1".equals(setQyfltj.getDsjgbz())){
				map.put("deptleave", "3");
			}else{
				map.put("deptleave", "2");
				map.put("deptcode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			}
			if(setQyfltj.getDsjgdm()!=null&&!"".equals(setQyfltj.getDsjgdm())){
				map.put("deptcode", StringUtil.trimEven0(setQyfltj.getDsjgdm()));
			}
			if(setQyfltj.getFxjdm()!=null&&!"".equals(setQyfltj.getFxjdm())){
				map.put("deptcode", StringUtil.trimEven0(setQyfltj.getFxjdm()));
			}
			if(setQyfltj.getGxdwdm()!=null&&!"".equals(setQyfltj.getGxdwdm())){
				map.put("deptcode", StringUtil.trimEven0(setQyfltj.getGxdwdm()));
			}
			Page pageQy = qyfltjService.getListForPageQY(map, pagesize, pagerow,
					sort, dir);
			totalpage = pageQy.getTotalPages();
			totalrows = pageQy.getTotalRows();
			List qyList = pageQy.getData();

			Page pageRy = rylbtjService.getListForPageRY(map, pagesize, pagerow,
					sort, dir);
			List ryList = pageRy.getData();

			for (java.util.Iterator iterQy = qyList.iterator(); iterQy
					.hasNext();) {
				Qyfltj oneQyfltj = (Qyfltj) iterQy.next();
				if(!"".equals(sjName)){
					oneQyfltj.setDsjgmc(sjName);
				}
				oneQyfltj.setQczlry(0);
				oneQyfltj.setEscry(0);
				oneQyfltj.setEsjry(0);
				oneQyfltj.setJxry(0);
				oneQyfltj.setCzcry(0);
				oneQyfltj.setRyhj(0);
				for (java.util.Iterator iterRy = ryList.iterator(); iterRy
						.hasNext();) {
					Rylbtj oneRylbtj = (Rylbtj) iterRy.next();
					if("1".equals(setQyfltj.getGxdwbz())){//筛选到科所队
						if (oneQyfltj.getDsjgdm().equals(oneRylbtj.getDsjgdm())
								&& oneQyfltj.getFxjdm().equals(oneRylbtj.getFxjdm())
								&& oneQyfltj.getGxdwdm().equals(
										oneRylbtj.getGxdwdm())) {
							oneQyfltj.setQczlry(oneRylbtj.getQczlry());
							oneQyfltj.setEscry(oneRylbtj.getEscry());
							oneQyfltj.setEsjry(oneRylbtj.getEsjry());
							oneQyfltj.setJxry(oneRylbtj.getJxry());
							oneQyfltj.setCzcry(oneRylbtj.getCzcry());
							oneQyfltj.setRyhj(oneRylbtj.getRyhj());
							break;
						}
						
					}else if("1".equals(setQyfltj.getFxjbz())){// 筛选到分县局
						if (oneQyfltj.getDsjgdm().equals(oneRylbtj.getDsjgdm())
								&& oneQyfltj.getFxjdm().equals(oneRylbtj.getFxjdm())
								) {
							oneQyfltj.setQczlry(oneRylbtj.getQczlry());
							oneQyfltj.setEscry(oneRylbtj.getEscry());
							oneQyfltj.setEsjry(oneRylbtj.getEsjry());
							oneQyfltj.setJxry(oneRylbtj.getJxry());
							oneQyfltj.setCzcry(oneRylbtj.getCzcry());
							oneQyfltj.setRyhj(oneRylbtj.getRyhj());
							break;
						}
					}else if("1".equals(setQyfltj.getDsjgbz())){//筛选到地市级
						if (oneQyfltj.getDsjgdm().equals(oneRylbtj.getDsjgdm())) {
							oneQyfltj.setQczlry(oneRylbtj.getQczlry());
							oneQyfltj.setEscry(oneRylbtj.getEscry());
							oneQyfltj.setEsjry(oneRylbtj.getEsjry());
							oneQyfltj.setJxry(oneRylbtj.getJxry());
							oneQyfltj.setCzcry(oneRylbtj.getCzcry());
							oneQyfltj.setRyhj(oneRylbtj.getRyhj());
							break;
						}
					}else{//省厅
						oneQyfltj.setQczlry(oneRylbtj.getQczlry());
						oneQyfltj.setEscry(oneRylbtj.getEscry());
						oneQyfltj.setEsjry(oneRylbtj.getEsjry());
						oneQyfltj.setJxry(oneRylbtj.getJxry());
						oneQyfltj.setCzcry(oneRylbtj.getCzcry());
						oneQyfltj.setRyhj(oneRylbtj.getRyhj());
						break;
					}
				}
				lQyfltj.add(oneQyfltj);
				
				qczlqy += oneQyfltj.getQczlqy().intValue();
				qczlry += oneQyfltj.getQczlry().intValue();
				escqy += oneQyfltj.getEscqy().intValue();
				escry += oneQyfltj.getEscry().intValue();
				esjqy += oneQyfltj.getEsjqy().intValue();
				esjry += oneQyfltj.getEsjry().intValue();
				jxqy += oneQyfltj.getJxqy().intValue();
				jxry += oneQyfltj.getJxry().intValue();
				czcqy += oneQyfltj.getCzcqy().intValue();
				czcry += oneQyfltj.getCzcry().intValue();
				qyhj += oneQyfltj.getQyhj().intValue();
				ryhj += oneQyfltj.getRyhj().intValue();
			}
			sumQyfltj.setQczlqy(qczlqy);
			sumQyfltj.setQczlry(qczlry);
			sumQyfltj.setEscqy(escqy);
			sumQyfltj.setEscry(escry);
			sumQyfltj.setEsjqy(esjqy);
			sumQyfltj.setEsjry(esjry);
			sumQyfltj.setJxqy(jxqy);
			sumQyfltj.setJxry(jxry);
			sumQyfltj.setCzcqy(czcqy);
			sumQyfltj.setCzcry(czcry);
			sumQyfltj.setRyhj(ryhj);
			sumQyfltj.setQyhj(qyhj);
			sumQyfltj.setDsjgmc("总计");
			if("1".equals(setQyfltj.getDsjgbz())){
			    lQyfltj.add(sumQyfltj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public String querylistExcelTemp() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();

			Qyfltj setQyfltj = new Qyfltj();
			setQyfltj = (Qyfltj) this.setClass(setQyfltj, null);

			Map map = new HashMap();
			map.put("dsjgdm", setQyfltj.getDsjgdm());
			map.put("fxjdm", setQyfltj.getFxjdm());
			map.put("gxdwdm", setQyfltj.getGxdwdm());
			map.put("dsjgbz", setQyfltj.getDsjgbz());
			map.put("fxjbz", setQyfltj.getFxjbz());
			map.put("gxdwbz", setQyfltj.getGxdwbz());
			map.put("qsrq", setQyfltj.getQsrq());
			map.put("jzrq", setQyfltj.getJzrq());

			Page page = qyfltjService.getListForPage(map, 1, Integer
					.parseInt(maxRows), null, null);
			session.setAttribute("csfltjList", page.getData());
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
			Qyfltj setQyfltj = new Qyfltj();

			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			StringBuffer sb = new StringBuffer();
			sb.append("<tr>");
			sb.append(tabletitle);
			sb
					.append("<th name='l_hjT' datatype='Integer' sumflag='0'>场所总数（至截止日期）</th>");
			sb
					.append("<th name='l_gwylT' datatype='Integer' sumflag='0'>歌舞娱乐（至截止日期）</th>");
			sb
					.append("<th name='l_yysdzyxtT' datatype='Integer' sumflag='0'>游艺场所（至截止日期）</th>");
			sb
					.append("<th name='l_qtylcsT' datatype='Integer' sumflag='0'>其他娱乐场所（至截止日期）</th>");
			sb
					.append("<th name='l_snxyamT' datatype='Integer' sumflag='0'>桑拿、洗浴、按摩（至截止日期）</th>");
			sb
					.append("<th name='l_mrmfzyT' datatype='Integer' sumflag='0'>美容美发、足浴（至截止日期）</th>");
			sb
					.append("<th name='l_qtfwcsT' datatype='Integer' sumflag='0'>其他服务场所（至截止日期）</th>");
			sb
					.append("<th name='l_hj' datatype='Integer' sumflag='0'>周期内新增企业数</th>");
			sb
					.append("<th name='l_gwyl' datatype='Integer' sumflag='0'>歌舞娱乐(周期内新增)</th>");
			sb
					.append("<th name='l_yysdzyxt' datatype='Integer' sumflag='0'>游艺场所(周期内新增)</th>");
			sb
					.append("<th name='l_qtylcs' datatype='Integer' sumflag='0'>其他娱乐场所(周期内新增)</th>");
			sb
					.append("<th name='l_snxyam' datatype='Integer' sumflag='0'>桑拿、洗浴、按摩(周期内新增)</th>");
			sb
					.append("<th name='l_mrmfzy' datatype='Integer' sumflag='0'>美容美发、足浴(周期内新增)</th>");
			sb
					.append("<th name='l_qtfwcs' datatype='Integer' sumflag='0'>其他服务场所(周期内新增)</th>");
			sb.append("</tr>");

			List lColumn = this.getExcelColumn(sb.toString());
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List) session.getAttribute("csfltjList"));
			lResult.add(setQyfltj);
			this.setExcelCreate("fileName", lResult); // //ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
		}
		this.result = "success";
	}

	public String query() throws Exception {
		try {
			Qyfltj setQyfltj = new Qyfltj();
			qyfltj = (Qyfltj) this.setClass(setQyfltj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qyfltj = qyfltjService.getQyfltj(qyfltj);
		lQyfltj.clear();
		lQyfltj.add(qyfltj);
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Qyfltj setQyfltj = new Qyfltj();
			qyfltj = (Qyfltj) this.setClass(setQyfltj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qyfltj = qyfltjService.insertQyfltj(qyfltj);
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Qyfltj setQyfltj = new Qyfltj();
			qyfltj = (Qyfltj) this.setClass(setQyfltj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qyfltjService.updateQyfltj(qyfltj);
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Qyfltj setQyfltj = new Qyfltj();
			qyfltj = (Qyfltj) this.setClass(setQyfltj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qyfltjService.deleteQyfltj(qyfltj);
		this.result = "success";
		return "success";
	}

	public void setRylbtjService(IRylbtjService rylbtjService) {
		this.rylbtjService = rylbtjService;
	}
}