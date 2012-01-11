package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyyyzttj;
import com.aisino2.publicsystem.service.IQyyyzttjService;
import com.aisino2.sysadmin.domain.Globalpar;

public class QyyyzttjAction extends PageAction {
	private IQyyyzttjService qyyyzttjService;
	private List lQyyyzttj = new ArrayList();
	private Qyyyzttj qyyyzttj = new Qyyyzttj();
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

	public Qyyyzttj getQyyyzttj() {
		return qyyyzttj;
	}

	public List getLQyyyzttj() {
		return lQyyyzttj;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setQyyyzttjService(IQyyyzttjService qyyyzttjService) {
		this.qyyyzttjService = qyyyzttjService;
	}

	public void setTabledata(List lData,Qyyyzttj qyyyzttj) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qyyyzttjid");
		if("1".equals(qyyyzttj.getGxdwbz())){
			lPro.add("gxdwmc");
		} else if("1".equals(qyyyzttj.getFxjbz())){
			lPro.add("fxjmc");
		} else if("1".equals(qyyyzttj.getDsjgbz())){
			lPro.add("dsjgmc");
		}
		lPro.add("hjT");
		lPro.add("yyT");
		lPro.add("zztyT");
		lPro.add("lltyT");
		lPro.add("xyT");
		lPro.add("zxT");
		lPro.add("qtT");

		Qyyyzttj getQyyyzttj = new Qyyyzttj();

		this.setData(getQyyyzttj, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		try {
			int hjT = 0;
			int yyT = 0;
			int zztyT = 0;
			int lltyT = 0;
			int xyT = 0;
			int zxT = 0;
			int qtT = 0;
			Qyyyzttj sumQyyyzttj = new Qyyyzttj();
			Qyyyzttj setQyyyzttj = new Qyyyzttj();
			setQyyyzttj = (Qyyyzttj) this.setClass(setQyyyzttj, null);
			Map map = new HashMap();
			map.put("dsjgdm", setQyyyzttj.getDsjgdm());
			map.put("fxjdm", setQyyyzttj.getFxjdm());
			map.put("gxdwdm", setQyyyzttj.getGxdwdm());
			map.put("dsjgbz", setQyyyzttj.getDsjgbz());
			map.put("fxjbz", setQyyyzttj.getFxjbz());
			map.put("gxdwbz", setQyyyzttj.getGxdwbz());
			//map.put("qsrq", setQyyyzttj.getQsrq());
			//map.put("jzrq", setQyyyzttj.getJzrq());
			map.put("tjrq", setQyyyzttj.getTjrq());
			map.put("hylbdm", setQyyyzttj.getHylbdm());
			
			Page page = qyyyzttjService.getListForPage(map, pagesize, pagerow,
					sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQyyyzttj = page.getData();
			for(java.util.Iterator iter = lQyyyzttj.iterator(); iter.hasNext();){
				Qyyyzttj oneQyyyzttj = (Qyyyzttj)iter.next();
				hjT += oneQyyyzttj.getHjT().intValue();
				yyT += oneQyyyzttj.getYyT().intValue();
				zztyT += oneQyyyzttj.getZztyT().intValue();
				lltyT += oneQyyyzttj.getLltyT().intValue();
				xyT += oneQyyyzttj.getXyT().intValue();
				zxT += oneQyyyzttj.getZxT().intValue();
				qtT += oneQyyyzttj.getQtT().intValue();
			}
			sumQyyyzttj.setHjT(hjT);
			sumQyyyzttj.setYyT(yyT);
			sumQyyyzttj.setZztyT(zztyT);
			sumQyyyzttj.setLltyT(lltyT);
			sumQyyyzttj.setXyT(xyT);
			sumQyyyzttj.setZxT(zxT);
			sumQyyyzttj.setQtT(qtT);
			sumQyyyzttj.setDsjgmc("总计");
			if("1".equals(setQyyyzttj.getDsjgbz())){
			    lQyyyzttj.add(sumQyyyzttj);
			}
			//setTabledata(lQyyyzttj, setQyyyzttj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}
	
	public String querylistExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Qyyyzttj setQyyyzttj = new Qyyyzttj();
			setQyyyzttj = (Qyyyzttj) this.setClass(setQyyyzttj, null);
			Map map = new HashMap();
			map.put("dsjgdm", setQyyyzttj.getDsjgdm());
			map.put("fxjdm", setQyyyzttj.getFxjdm());
			map.put("gxdwdm", setQyyyzttj.getGxdwdm());
			map.put("dsjgbz", setQyyyzttj.getDsjgbz());
			map.put("fxjbz", setQyyyzttj.getFxjbz());
			map.put("gxdwbz", setQyyyzttj.getGxdwbz());
			//map.put("qsrq", setQyyyzttj.getQsrq());
			//map.put("jzrq", setQyyyzttj.getJzrq());
			map.put("tjrq", setQyyyzttj.getTjrq());
			
			Page page = qyyyzttjService.getListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("qyyyzttjList", page.getData());
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	public void querylistExcel() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Qyyyzttj setQyyyzttj = new Qyyyzttj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("qyyyzttjList"));
			lResult.add(setQyyyzttj);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }

	public String query() throws Exception {
		try {
			Qyyyzttj setQyyyzttj = new Qyyyzttj();
			qyyyzttj = (Qyyyzttj) this.setClass(setQyyyzttj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qyyyzttj = qyyyzttjService.getQyyyzttj(qyyyzttj);
		lQyyyzttj.clear();
		lQyyyzttj.add(qyyyzttj);
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Qyyyzttj setQyyyzttj = new Qyyyzttj();
			qyyyzttj = (Qyyyzttj) this.setClass(setQyyyzttj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qyyyzttj = qyyyzttjService.insertQyyyzttj(qyyyzttj);
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Qyyyzttj setQyyyzttj = new Qyyyzttj();
			qyyyzttj = (Qyyyzttj) this.setClass(setQyyyzttj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qyyyzttjService.updateQyyyzttj(qyyyzttj);
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Qyyyzttj setQyyyzttj = new Qyyyzttj();
			qyyyzttj = (Qyyyzttj) this.setClass(setQyyyzttj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qyyyzttjService.deleteQyyyzttj(qyyyzttj);
		this.result = "success";
		return "success";
	}
}