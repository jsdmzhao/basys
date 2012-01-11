package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.StxzTzxx;
import com.aisino2.publicsystem.service.IStxzTzxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
public class StxzTzxxAction extends PageAction{
	private IStxzTzxxService stxzTzxxService;
	private List lStxzTzxx=new ArrayList();
	private String tabledata="";
	private int totalrows=0;
	private String result="success";
	
	public int getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}
	public String getTabledata() {
		return tabledata;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void tzsetTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("gxdwmc");
		lPro.add("jjlxmc");
		lPro.add("zrs");
		lPro.add("lxdh");
		lPro.add("zt");
		
		List lCol = new ArrayList();
		Qyjbxx getJxqyxx = new Qyjbxx();
		
		this.setData(getJxqyxx,lData,lPro,lCol);
		this.tabledata=this.getData();
		totalrows=this.getTotalrows();
	}
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("departcode");
		
		lPro.add("departcode");
		lPro.add("departname");
		lPro.add("scyws");
		lPro.add("wscqys");
		lPro.add("qyzs");
		lPro.add("ryzs");

		List lCol = new ArrayList();
		StxzTzxx getStxzTzxx = new StxzTzxx();
    	
        this.setData(getStxzTzxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public String querylist() throws Exception{
		javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		if(user==null){
			result="";
			return "success";
		}
		String likeCode = StringUtil.trimEven0(user.getDepartment().getDepartcode())+"__";
		Integer subCodeLen = new Integer(likeCode.length());
		try {
			StxzTzxx setStxzTzxx = new StxzTzxx();
			setStxzTzxx = (StxzTzxx) this.setClass(setStxzTzxx, null);
			setStxzTzxx.setSubCodeLen(subCodeLen);
			setStxzTzxx.setLikeDepartCode(StringUtil.add0(likeCode, 12));
			List list=new ArrayList();
			 list = stxzTzxxService.getListStxzTzxx(setStxzTzxx);
			setTabledata(list);
		} catch (Exception e) {
			result="";
			e.printStackTrace();
		}
        return "success";
    }
	public String wscqyquerylist() throws Exception{
		try {
			StxzTzxx setStxzTzxx = new StxzTzxx();
			setStxzTzxx = (StxzTzxx) this.setClass(setStxzTzxx, null);
			Page page = stxzTzxxService.getListWscQyxxForPage(findCode(setStxzTzxx),
					pagesize, pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lStxzTzxx = page.getData();
			dictFanYi(lStxzTzxx);
			tzsetTabledata(lStxzTzxx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result="success";
		return "success";
	}
	public String xxquerylist() throws Exception{
		try {
			StxzTzxx setStxzTzxx = new StxzTzxx();
			setStxzTzxx = (StxzTzxx) this.setClass(setStxzTzxx, null);
			Page page = stxzTzxxService.getListScQyxxForPage(findCode(setStxzTzxx),
					pagesize, pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lStxzTzxx = page.getData();
			dictFanYi(lStxzTzxx);
			tzsetTabledata(lStxzTzxx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    this.result="success";
        return "success";
	}
	public String qyzsquerylist() throws Exception{
		try {
			StxzTzxx setStxzTzxx = new StxzTzxx();
			setStxzTzxx = (StxzTzxx) this.setClass(setStxzTzxx, null);
			Page page = stxzTzxxService.getListAllQyxxForPage(findCode(setStxzTzxx),
					pagesize, pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lStxzTzxx = page.getData();
			dictFanYi(lStxzTzxx);
			tzsetTabledata(lStxzTzxx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result="success";
		return "success";
	}
	public Map findCode(StxzTzxx setJxtzxx){
		javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String likeCode = StringUtil.trimEven0(user.getDepartment().getDepartcode())+"__";
		Integer subCodeLen = new Integer(likeCode.length());
		String code="";
		if(user!=null){
			int temp=StringUtil.trimEven0(user.getDepartment().getDepartcode()).length()+2;
			if(setJxtzxx.getDepartcode()!=null&&!"".equals(setJxtzxx.getDepartcode())){
				code=setJxtzxx.getDepartcode().substring(0,temp);
			}
		}
		Map map=new HashMap();
		map.put("gxdwbm", code);
		map.put("hylbdm", setJxtzxx.getHylbdm());
		map.put("zrs", setJxtzxx.getZrs());
		map.put("subCodeLen", subCodeLen);
		map.put("qymc", setJxtzxx.getQymc());
		return map;
	}
	/**
	 * 获取 未上传企业数  = 企业总数-上传企业数
	 * @param list
	 */
//	public void queryWscqyzs(List list){
//		Jxtzxx temp = null;
//		if(list!=null&&list.size()>0){
//			for(int index=0,max=list.size();index<max;index++){
//				temp = (Jxtzxx)list.get(index);
//				temp.setWscqyzs(new Integer(temp.getJxqyzs())-new Integer(temp.getScqyzs()));
//			}
//		}
//		
//	}

	 /**
	 * 翻译字典项



	 */
	public void dictFanYi(List queryList){
		String displayName;
		if(queryList!=null&&queryList.size()>0){
			Map jlztMap = new HashMap();
			Dict_item dict_item = new Dict_item();
			dict_item.setDict_code("dm_jxqyzt");
			dict_item.setItem_allpin("");
			dict_item.setItem_simplepin("");
			dict_item.setFact_value("");
			dict_item.setDisplay_name("");
			dict_item.setAppend_value("");
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Dict_item temp = (Dict_item)list.get(index);
					jlztMap.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			for(int index=0,max=queryList.size();index<max;index++){
				Qyjbxx temp = (Qyjbxx)queryList.get(index);
				jlztMap.get(temp.getZt());
				temp.setZt((String)jlztMap.get(temp.getZt()));
			}
		}
	}
	public void setStxzTzxxService(IStxzTzxxService stxzTzxxService) {
		this.stxzTzxxService = stxzTzxxService;
	}
	public void setLStxzTzxx(List stxzTzxx) {
		lStxzTzxx = stxzTzxx;
	}
}
