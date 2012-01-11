package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Qgztjx_kz;
import com.aisino2.basicsystem.service.IQgztjx_kzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class Qgztjx_kzAction extends PageAction {
	private IQgztjx_kzService qgztjx_kzService;
	private List lQgztjx_kz;
	private Qgztjx_kz qgztjx_kz;
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

	public Qgztjx_kz getQgztjx_kz() {
		return qgztjx_kz;
	}

	public List getLQgztjx_kz() {
		return lQgztjx_kz;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setQgztjx_kzService(IQgztjx_kzService qgztjx_kzService) {
		this.qgztjx_kzService = qgztjx_kzService;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qgztjxid");
		lPro.add("bjgzid");
		lPro.add("bjxxid");
		lPro.add("qgztjxkzid");
		lPro.add("tbbh");
		lPro.add("xzqhbm");
		lPro.add("xzqh");
		lPro.add("xmpy");
		lPro.add("xm");
		lPro.add("bm");
		lPro.add("xbdm");
		lPro.add("xb");
		lPro.add("csrq");
		lPro.add("gmsfhm");
		lPro.add("hjdbm");
		lPro.add("hjd");
		lPro.add("hjxxdz");
		lPro.add("xzdqbm");
		lPro.add("xzdq");
		lPro.add("xzdxxdz");
		lPro.add("qtzjlx");
		lPro.add("qtzjhm");
		lPro.add("ajjbbm");
		lPro.add("ajjb");
		lPro.add("ajlbbm");
		lPro.add("ajlb");
		lPro.add("jyaq");
		lPro.add("djrq");
		lPro.add("djr");
		lPro.add("ladqbm");
		lPro.add("ladq");
		lPro.add("badwbm");
		lPro.add("badw");
		lPro.add("tbr");
		lPro.add("lxr");
		lPro.add("lxfs");

		List lModify = new ArrayList();
		lModify.add("setModifyQuery");
		lModify.add("修改");

		List lDel = new ArrayList();
		lDel.add("setDelete");
		lDel.add("删除");

		List lCol = new ArrayList();
		lCol.add(lModify);
		lCol.add(lDel);

		Qgztjx_kz getQgztjx_kz = new Qgztjx_kz();

		this.setData(getQgztjx_kz, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		Qgztjx_kz setQgztjx_kz = new Qgztjx_kz();
		Map map = new HashMap();
		Page page = qgztjx_kzService.getListForPage(map, pagesize, pagerow, sort, dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lQgztjx_kz = page.getData();
		setTabledata(lQgztjx_kz);
		this.result = "success";
		return "success";
	}

	public String query() throws Exception {
		try {
			Qgztjx_kz setQgztjx_kz = new Qgztjx_kz();
			qgztjx_kz = (Qgztjx_kz) this.setClass(setQgztjx_kz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qgztjx_kz = qgztjx_kzService.getQgztjx_kz(qgztjx_kz);
		lQgztjx_kz = new ArrayList();
		lQgztjx_kz.add(qgztjx_kz);
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Qgztjx_kz setQgztjx_kz = new Qgztjx_kz();
			qgztjx_kz = (Qgztjx_kz) this.setClass(setQgztjx_kz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qgztjx_kz = qgztjx_kzService.insertQgztjx_kz(qgztjx_kz);
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Qgztjx_kz setQgztjx_kz = new Qgztjx_kz();
			qgztjx_kz = (Qgztjx_kz) this.setClass(setQgztjx_kz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qgztjx_kzService.updateQgztjx_kz(qgztjx_kz);
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Qgztjx_kz setQgztjx_kz = new Qgztjx_kz();
			qgztjx_kz = (Qgztjx_kz) this.setClass(setQgztjx_kz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qgztjx_kzService.deleteQgztjx_kz(qgztjx_kz);
		this.result = "success";
		return "success";
	}
}