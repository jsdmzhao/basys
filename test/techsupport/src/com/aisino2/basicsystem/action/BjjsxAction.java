package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bjjsx;
import com.aisino2.basicsystem.service.IBjjsxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class BjjsxAction extends PageAction {
	private IBjjsxService bjjsxService;
	private List lBjjsx;
	private Bjjsx bjjsx;
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

	public Bjjsx getBjjsx() {
		return bjjsx;
	}

	public List getLBjjsx() {
		return lBjjsx;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setBjjsxService(IBjjsxService bjjsxService) {
		this.bjjsxService = bjjsxService;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bjjxh");
		lPro.add("gajgbm");
		lPro.add("gajgmc");
		lPro.add("bjjipdz");
		lPro.add("bjjsxj");
		lPro.add("yscsxsjdjg");

		List lCol = new ArrayList();

		Bjjsx getBjjsx = new Bjjsx();

		this.setData(getBjjsx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		Bjjsx setBjjsx = new Bjjsx();
		bjjsx = (Bjjsx) this.setClass(setBjjsx, null);

		Map map = new HashMap();
		map.put("GAJGBM", bjjsx.getGajgbm() + "%");
		map.put("YSCSXSJDJG", bjjsx.getYscsxsjdjg().intValue() * 60);

		Page page = bjjsxService.getListForPage(map, pagesize, pagerow, sort, dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBjjsx = page.getData();
		setTabledata(lBjjsx);
		this.result = "success";
		return "success";
	}

	public String query() throws Exception {
		try {
			Bjjsx setBjjsx = new Bjjsx();
			bjjsx = (Bjjsx) this.setClass(setBjjsx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjjsx = bjjsxService.getBjjsx(bjjsx);
		lBjjsx.clear();
		lBjjsx.add(bjjsx);
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Bjjsx setBjjsx = new Bjjsx();
			bjjsx = (Bjjsx) this.setClass(setBjjsx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjjsx = bjjsxService.insertBjjsx(bjjsx);
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Bjjsx setBjjsx = new Bjjsx();
			bjjsx = (Bjjsx) this.setClass(setBjjsx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjjsxService.updateBjjsx(bjjsx);
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Bjjsx setBjjsx = new Bjjsx();
			bjjsx = (Bjjsx) this.setClass(setBjjsx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjjsxService.deleteBjjsx(bjjsx);
		this.result = "success";
		return "success";
	}
}