package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Cljbxx;
import com.aisino2.publicsystem.service.ICljbxxService;

public class CljbxxAction extends PageAction{
	private ICljbxxService cljbxxService;
	private List lCljbxx=new ArrayList();
	private Cljbxx cljbxx=new Cljbxx();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Cljbxx getCljbxx() {
		return cljbxx;
	}
	
	public List getLCljbxx() {
		return lCljbxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setCljbxxService(ICljbxxService cljbxxService) {
		this.cljbxxService = cljbxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("cljbxxid");
		lPro.add("cldjxh");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("cllx");
		lPro.add("clpp");
		lPro.add("cph");
		lPro.add("czcyzj");
		lPro.add("czzjhm");
		lPro.add("lrsj");
		

    	
//    	List lModify=new ArrayList();
//    	lModify.add("setModifyQuery");
//    	lModify.add("修改");
//    	
//    	List lDel=new ArrayList();
//    	lDel.add("setDelete");
//    	lDel.add("删除");
//    	
//    	List lCol=new ArrayList();
//    	lCol.add(lModify);
//    	lCol.add(lDel);
    	
    	Cljbxx getCljbxx=new Cljbxx();
    	
        this.setData(getCljbxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		Cljbxx setCljbxx=new Cljbxx();
		setCljbxx=(Cljbxx)this.setClass(setCljbxx, null);
        Map map = new HashMap();
        map.put("superbWhere", setCljbxx.getSuperbWhere()); //高级查询条件
        map.put("superbOrderBy", setCljbxx.getSuperbOrderBy());
        map.put("hylbdm", setCljbxx.getHylbdm());
        map.put("cldjxh", setCljbxx.getCldjxh());
        map.put("cph", setCljbxx.getCph());
        map.put("clcdbm", setCljbxx.getClcdbm());
        map.put("clcsbm", setCljbxx.getClcsbm());
        map.put("clppbm", setCljbxx.getClppbm());
        map.put("clxh", setCljbxx.getClxh());
        map.put("gxdwdm", StringUtil.trimEven0(setCljbxx.getGxdwdm()));
        map.put("cllxbm", setCljbxx.getCllxbm());
        map.put("fdjh", setCljbxx.getFdjh());
        map.put("cjh", setCljbxx.getCjh());
        map.put("cszsbm", setCljbxx.getCszsbm());
        map.put("czcyzjlxdm", setCljbxx.getCzcyzjlxdm());
        map.put("czzjhm", setCljbxx.getCzzjhm());
        Page page = cljbxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lCljbxx=page.getData();
        setTabledata(lCljbxx); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Cljbxx setCljbxx=new Cljbxx();
			cljbxx=(Cljbxx)this.setClass(setCljbxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cljbxx=cljbxxService.getCljbxx(cljbxx);
        lCljbxx.clear();
        lCljbxx.add(cljbxx);
		this.result="success";
        return "success";
    }
	/**
	 * 查询车辆基本信息(t_cljbxx) 查询单条(包括人员照片、外国车主等信息)
	 * */
	public String queryAllInfo() throws Exception{
		try {
			Cljbxx setCljbxx=new Cljbxx();
			setCljbxx=(Cljbxx)this.setClass(setCljbxx, null);
			setCljbxx=cljbxxService.getCljbxxCommon(setCljbxx);
			lCljbxx.clear();
		    lCljbxx.add(setCljbxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Cljbxx setCljbxx=new Cljbxx();
			cljbxx=(Cljbxx)this.setClass(setCljbxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cljbxx=cljbxxService.insertCljbxx(cljbxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Cljbxx setCljbxx=new Cljbxx();
			cljbxx=(Cljbxx)this.setClass(setCljbxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cljbxxService.updateCljbxx(cljbxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Cljbxx setCljbxx=new Cljbxx();
			cljbxx=(Cljbxx)this.setClass(setCljbxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cljbxxService.deleteCljbxx(cljbxx);
        this.result="success";
        return "success";
    }
}