package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.cache.CacheManager;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;
import com.aisino2.publicsystem.service.IQyryxx_lsxxService;
import com.aisino2.sysadmin.domain.Dict_item;

public class Qyryxx_lsxxAction extends PageAction{
	private IQyryxx_lsxxService qyryxx_lsxxService;
	private List lQyryxx_lsxx=new ArrayList();
	private Qyryxx_lsxx qyryxx_lsxx=new Qyryxx_lsxx();
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

	public Qyryxx_lsxx getQyryxx_lsxx() {
		return qyryxx_lsxx;
	}
	
	public List getLQyryxx_lsxx() {
		return lQyryxx_lsxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyryxx_lsxxService(IQyryxx_lsxxService qyryxx_lsxxService) {
		this.qyryxx_lsxxService = qyryxx_lsxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("rylsid");
		lPro.add("qyid");
		lPro.add("ryid");
		lPro.add("hylbdm");
		lPro.add("hylb");
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
		lPro.add("zhiwu");
		lPro.add("rzrq");
		lPro.add("cyryztdm");
		lPro.add("cyryzt");
		lPro.add("zxr");
		lPro.add("zxbz");
		lPro.add("zxsj");
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
		lPro.add("czlx");
		lPro.add("bgyy");
		lPro.add("bglbdm");
		lPro.add("bglb");
		lPro.add("gzdm");
		lPro.add("gz");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyryxx_lsxx getQyryxx_lsxx=new Qyryxx_lsxx();
    	
        this.setData(getQyryxx_lsxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyryxx_lsxx setQyryxx_lsxx=new Qyryxx_lsxx();
        Map map = new HashMap();
        Page page = qyryxx_lsxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyryxx_lsxx=page.getData();
        setTabledata(lQyryxx_lsxx); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyryxx_lsxx setQyryxx_lsxx=new Qyryxx_lsxx();
			setQyryxx_lsxx=(Qyryxx_lsxx)this.setClass(setQyryxx_lsxx, null);
			setQyryxx_lsxx=qyryxx_lsxxService.getQyryxx_lsxx(setQyryxx_lsxx);
			cyryxx_LsDict_item(setQyryxx_lsxx);
			lQyryxx_lsxx.add(setQyryxx_lsxx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyryxx_lsxx setQyryxx_lsxx=new Qyryxx_lsxx();
			qyryxx_lsxx=(Qyryxx_lsxx)this.setClass(setQyryxx_lsxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxx_lsxx=qyryxx_lsxxService.insertQyryxx_lsxx(qyryxx_lsxx);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyryxx_lsxx setQyryxx_lsxx=new Qyryxx_lsxx();
			qyryxx_lsxx=(Qyryxx_lsxx)this.setClass(setQyryxx_lsxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxx_lsxxService.updateQyryxx_lsxx(qyryxx_lsxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyryxx_lsxx setQyryxx_lsxx=new Qyryxx_lsxx();
			qyryxx_lsxx=(Qyryxx_lsxx)this.setClass(setQyryxx_lsxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryxx_lsxxService.deleteQyryxx_lsxx(qyryxx_lsxx);
        this.result="success";
        return "success";
    }
	
	public void cyryxx_LsDict_item(Qyryxx_lsxx data){
		String displayName;
		Dict_item dict_item = new Dict_item();
		if(data.getZxbz()!=null){
			displayName = "";
			dict_item.setDict_code("dm_cszt");
			dict_item.setFact_value(data.getZxbz());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZxbz(displayName);
		}
		if(data.getZt()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zxbz");
			dict_item.setFact_value(data.getZt());
			List list = CacheManager.getCacheDictitem(dict_item);
			Map jlztMap = new HashMap();
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Dict_item temp = (Dict_item)list.get(index);
					jlztMap.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
				jlztMap.get(data.getCyryzt());
				data.setZt((String)jlztMap.get(data.getZt()));
		}
		if(data.getZxyy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zxyy(cyry)");
			dict_item.setFact_value(data.getZxyy());
			List list = CacheManager.getCacheDictitem(dict_item);
			Map jlztMap = new HashMap();
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Dict_item temp = (Dict_item)list.get(index);
					jlztMap.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			data.setZxyy((String)jlztMap.get(data.getZxyy()));
		}
		 
		if(data.getQzzldm()!=null){
			displayName = "";
			dict_item.setDict_code("dm_qzzl(lgy)");
			dict_item.setFact_value(data.getQzzldm());
			List list = CacheManager.getCacheDictitem(dict_item);
			Map jlztMap = new HashMap();
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Dict_item temp = (Dict_item)list.get(index);
					jlztMap.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			data.setQzzldm((String)jlztMap.get(data.getQzzldm()));
		}
	}
}