package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyjbxx_ls;
import com.aisino2.publicsystem.service.IQyjbxx_lsService;

public class Qyjbxx_lsAction extends PageAction{
	private IQyjbxx_lsService qyjbxx_lsService;
	private List lQyjbxx_ls=new ArrayList();
	private Qyjbxx_ls qyjbxx_ls=new Qyjbxx_ls();
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

	public Qyjbxx_ls getQyjbxx_ls() {
		return qyjbxx_ls;
	}
	
	public List getLQyjbxx_ls() {
		return lQyjbxx_ls;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyjbxx_lsService(IQyjbxx_lsService qyjbxx_lsService) {
		this.qyjbxx_lsService = qyjbxx_lsService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		lPro.add("qylsid");
		lPro.add("hylbdm");
		lPro.add("hylb");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("qyqp");
		lPro.add("qyjp");
		lPro.add("qyzflbm");
		lPro.add("qyzflmc");
		lPro.add("qyfflbm");
		lPro.add("qyfflmc");
		lPro.add("gxdwbm");
		lPro.add("gxdwmc");
		lPro.add("ssdxjgajgdm");
		lPro.add("ssdxjgajgmc");
		lPro.add("ssdpcsjgdm");
		lPro.add("ssdpcsjgmc");
		lPro.add("qyzzjgdm");
		lPro.add("lxdh");
		lPro.add("yzbm");
		lPro.add("chzh");
		lPro.add("jwdzb");
		lPro.add("jjlxbm");
		lPro.add("jjlxmc");
		lPro.add("jyfwzy");
		lPro.add("jyfwjy");
		lPro.add("zczj");
		lPro.add("jymj");
		lPro.add("zabdm");
		lPro.add("zajbmc");
		lPro.add("yyztdm");
		lPro.add("yyztmc");
		lPro.add("frdb");
		lPro.add("frdbzjlb");
		lPro.add("frdbzjhm");
		lPro.add("frdblxfs");
		lPro.add("kyrq");
		lPro.add("yysj");
		lPro.add("babh");
		lPro.add("barq");
		lPro.add("tyrq");
		lPro.add("jyfs");
		lPro.add("jydz");
		lPro.add("dwfzrzjlb");
		lPro.add("dwfzrzjhm");
		lPro.add("dwfzr");
		lPro.add("dwfzrlxfs");
		lPro.add("xfshdw");
		lPro.add("xfhgzh");
		lPro.add("hcdw");
		lPro.add("hcr");
		lPro.add("hcsj");
		lPro.add("gdxx");
		lPro.add("zrs");
		lPro.add("hdrs");
		lPro.add("bagsmc");
		lPro.add("bafzrgmsfhm");
		lPro.add("bafzrxm");
		lPro.add("bafzrdh");
		lPro.add("bars");
		lPro.add("jgpxrs");
		lPro.add("bagsyj");
		lPro.add("cksl");
		lPro.add("bxbjsl");
		lPro.add("bz");
		lPro.add("dcbs");
		lPro.add("dcsj");
		lPro.add("zt");
		lPro.add("ztgbrq");
		lPro.add("scbz");
		lPro.add("jqbm");
		lPro.add("zxbz");
		lPro.add("zxyy");
		lPro.add("zdskb");
		lPro.add("bcsj");
		lPro.add("lrsj");
		lPro.add("lrr");
		lPro.add("lrdwbm");
		lPro.add("lrdwmc");
		lPro.add("czlx");
		lPro.add("bgyy");
		lPro.add("bglbdm");
		lPro.add("bglb");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyjbxx_ls getQyjbxx_ls=new Qyjbxx_ls();
    	
        this.setData(getQyjbxx_ls,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyjbxx_ls setQyjbxx_ls=new Qyjbxx_ls();
        Map map = new HashMap();
        Page page = qyjbxx_lsService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyjbxx_ls=page.getData();
        setTabledata(lQyjbxx_ls); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyjbxx_ls setQyjbxx_ls=new Qyjbxx_ls();
			qyjbxx_ls=(Qyjbxx_ls)this.setClass(setQyjbxx_ls, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyjbxx_ls=qyjbxx_lsService.getQyjbxx_ls(qyjbxx_ls);
        lQyjbxx_ls.clear();
        lQyjbxx_ls.add(qyjbxx_ls);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyjbxx_ls setQyjbxx_ls=new Qyjbxx_ls();
			qyjbxx_ls=(Qyjbxx_ls)this.setClass(setQyjbxx_ls, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyjbxx_ls=qyjbxx_lsService.insertQyjbxx_ls(qyjbxx_ls);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyjbxx_ls setQyjbxx_ls=new Qyjbxx_ls();
			qyjbxx_ls=(Qyjbxx_ls)this.setClass(setQyjbxx_ls, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyjbxx_lsService.updateQyjbxx_ls(qyjbxx_ls);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyjbxx_ls setQyjbxx_ls=new Qyjbxx_ls();
			qyjbxx_ls=(Qyjbxx_ls)this.setClass(setQyjbxx_ls, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyjbxx_lsService.deleteQyjbxx_ls(qyjbxx_ls);
        this.result="success";
        return "success";
    }
}