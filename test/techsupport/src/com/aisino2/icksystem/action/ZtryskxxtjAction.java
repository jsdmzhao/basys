package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Ztryskxxtj;
import com.aisino2.icksystem.service.IZtryskxxtjService;

public class ZtryskxxtjAction extends PageAction{
	private IZtryskxxtjService ztryskxxtjService;
	private List lZtryskxxtj=new ArrayList();
	private Ztryskxxtj ztryskxxtj=new Ztryskxxtj();
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

	public Ztryskxxtj getZtryskxxtj() {
		return ztryskxxtj;
	}
	
	public List getLZtryskxxtj() {
		return lZtryskxxtj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setZtryskxxtjService(IZtryskxxtjService ztryskxxtjService) {
		this.ztryskxxtjService = ztryskxxtjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyryskxxtjmxid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("qyzflbm");
		lPro.add("qyzflmc");
		lPro.add("qyfflbm");
		lPro.add("qyfflmc");
		lPro.add("gxdwbm");
		lPro.add("gxdwmc");
		lPro.add("ssqyid");
		lPro.add("ssqybm");
		lPro.add("ssqymc");
		lPro.add("ssqygxdwdm");
		lPro.add("ssqygxdwmc");
		lPro.add("ssqyzfldm");
		lPro.add("ssqyzflmc");
		lPro.add("hylbdm");
		lPro.add("hylb");
		lPro.add("sksj");
		lPro.add("scsj");
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("cyrylbdm");
		lPro.add("cyrylbmc");
		lPro.add("xm");
		lPro.add("qm");
		lPro.add("bm");
		lPro.add("xmpy");
		lPro.add("gjdm");
		lPro.add("gj");
		lPro.add("mzdm");
		lPro.add("minzu");
		lPro.add("xbdm");
		lPro.add("xb");
		lPro.add("csrq");
		lPro.add("hyzkdm");
		lPro.add("hyzk");
		lPro.add("shengao");
		lPro.add("tizh");
		lPro.add("xxdm");
		lPro.add("xx");
		lPro.add("hjdxzqh");
		lPro.add("hjdxzqhdm");
		lPro.add("hjdxz");
		lPro.add("cyzjdm");
		lPro.add("cyzj");
		lPro.add("zjhm");
		lPro.add("zzzhm");
		lPro.add("zzdz");
		lPro.add("gwbh");
		lPro.add("gwmc");
		lPro.add("gwzrms");
		lPro.add("shouji");
		lPro.add("lxdh");
		lPro.add("jjlxr");
		lPro.add("jjlxrdh");
		lPro.add("gzdm");
		lPro.add("gz");
		lPro.add("zhiwu");
		lPro.add("rzrq");
		lPro.add("lzrq");
		lPro.add("cyryztdm");
		lPro.add("cyryzt");
		lPro.add("cxr");
		lPro.add("zxbz");
		lPro.add("cxsj");
		lPro.add("lrsj");
		lPro.add("lrr");
		lPro.add("lrdwbm");
		lPro.add("lrdwmc");
		lPro.add("hcdw");
		lPro.add("hcr");
		lPro.add("hcsj");
		lPro.add("zxyy");
		lPro.add("zkzt");
		lPro.add("bcsj");
		lPro.add("dcbs");
		lPro.add("bz");
		lPro.add("scbz");
		lPro.add("biduiflag");
		lPro.add("zpwtgyy");
		lPro.add("zt");
		lPro.add("ywx");
		lPro.add("ywm");
		lPro.add("wgrjyxkz");
		lPro.add("qzzldm");
		lPro.add("qzhm");
		lPro.add("zatlq");
		lPro.add("qfjg");
		lPro.add("rjrq");
		lPro.add("rjka");
		lPro.add("kh");
		lPro.add("ickh");
		lPro.add("slyy");
		lPro.add("slr");
		lPro.add("slsj");
		lPro.add("yxsksrq");
		lPro.add("yxqhzrq");
		lPro.add("ickcjsj");
		lPro.add("ickcjr");
		lPro.add("ickcjdbm");
		lPro.add("ickcjdmc");
		lPro.add("jssj");
		lPro.add("jsbmc");
		lPro.add("ffr");
		lPro.add("ffsj");
		lPro.add("lqr");
		lPro.add("lqsj");
		lPro.add("lqrzjlx");
		lPro.add("lqrzjhm");
		lPro.add("ickzxr");
		lPro.add("ickzxsj");
		lPro.add("ickzxyy");
		lPro.add("njr");
		lPro.add("njsj");
		lPro.add("zkztbs");
		lPro.add("sfqr");
		lPro.add("ysr");
		lPro.add("yssj");
		lPro.add("dxrr");
		lPro.add("dxrsj");
		lPro.add("cyssj");
		lPro.add("cysyy");
		lPro.add("cdxrsj");
		lPro.add("cdxryy");
		lPro.add("bhkyy");
		lPro.add("yksfsh");
		lPro.add("ztryskxxtjmxid");
		lPro.add("skid3");
		lPro.add("tjrq");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Ztryskxxtj getZtryskxxtj=new Ztryskxxtj();
    	
        this.setData(getZtryskxxtj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Ztryskxxtj setZtryskxxtj=new Ztryskxxtj();
        Map map = new HashMap();
        Page page = ztryskxxtjService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lZtryskxxtj=page.getData();
        setTabledata(lZtryskxxtj); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Ztryskxxtj setZtryskxxtj=new Ztryskxxtj();
			ztryskxxtj=(Ztryskxxtj)this.setClass(setZtryskxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ztryskxxtj=ztryskxxtjService.getZtryskxxtj(ztryskxxtj);
        lZtryskxxtj.clear();
        lZtryskxxtj.add(ztryskxxtj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Ztryskxxtj setZtryskxxtj=new Ztryskxxtj();
			ztryskxxtj=(Ztryskxxtj)this.setClass(setZtryskxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ztryskxxtj=ztryskxxtjService.insertZtryskxxtj(ztryskxxtj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Ztryskxxtj setZtryskxxtj=new Ztryskxxtj();
			ztryskxxtj=(Ztryskxxtj)this.setClass(setZtryskxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ztryskxxtjService.updateZtryskxxtj(ztryskxxtj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Ztryskxxtj setZtryskxxtj=new Ztryskxxtj();
			ztryskxxtj=(Ztryskxxtj)this.setClass(setZtryskxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ztryskxxtjService.deleteZtryskxxtj(ztryskxxtj);
        this.result="success";
        return "success";
    }
}