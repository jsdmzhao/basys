package com.aisino2.icksystem.action;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.DateToString;
import com.aisino2.common.ImageUtil;
import com.aisino2.common.QjblUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.DateUtil;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Ickrzjl;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Icksl_ickzb;
import com.aisino2.icksystem.domain.Icksl_wldj;
import com.aisino2.icksystem.domain.Ickzb;
import com.aisino2.icksystem.domain.Wldj;
import com.aisino2.icksystem.domain.Zzzxsc;
import com.aisino2.icksystem.service.IIckrzjlService;
import com.aisino2.icksystem.service.IIckslService;
import com.aisino2.icksystem.service.IIcksl_ickzbService;
import com.aisino2.icksystem.service.IIcksl_wldjService;
import com.aisino2.icksystem.service.IIckzbService;
import com.aisino2.icksystem.service.IWldjService;
import com.aisino2.icksystem.service.IZzzxscService;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Wgcyryxx;
import com.aisino2.publicsystem.service.IQyry_zpService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IWgcyryxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDict_itemService;

public class IckslAction extends PageAction{
	private IIckslService ickslService;
	private IQyryxxService qyryxxService;	//从业人员
	private IWgcyryxxService wgcyryxxService;//外国从业人员
	private IQyry_zpService qyry_zpService;//从业人员照片
	private IDict_itemService dict_itemService;//字典项
	private IIcksl_ickzbService icksl_ickzbService;//IC卡受理组包
	private IIckzbService ickzbService;//IC卡组包
	private IIcksl_wldjService icksl_wldjService;//IC卡受理物流登记
	private IWldjService wldjService;//物流登记
	private IIckrzjlService ickrzjlService; //日志记录
	private IZzzxscService zzzxscService;
	private Qyryxx qyryxx;
	private Wgcyryxx wgcyryxx;
	private Ickzb ickzb;
	private Wldj wldj;
    private String fileload;
	private List lIcksl = new ArrayList();
	private Icksl icksl;
	private Zzzxsc zzzxsc;
	private String tabledata;
	private int totalrows;
	private String result="";
	
	public Zzzxsc getZzzxsc() {
		return zzzxsc;
	}

	public void setZzzxsc(Zzzxsc zzzxsc) {
		this.zzzxsc = zzzxsc;
	}

	public Wldj getWldj() {
		return wldj;
	}

	public void setWldj(Wldj wldj) {
		this.wldj = wldj;
	}

	public void setZzzxscService(IZzzxscService zzzxscService) {
		this.zzzxscService = zzzxscService;
	}

	public void setIcksl_wldjService(IIcksl_wldjService icksl_wldjService) {
		this.icksl_wldjService = icksl_wldjService;
	}

	public void setWldjService(IWldjService wldjService) {
		this.wldjService = wldjService;
	}

	public void setIcksl_ickzbService(IIcksl_ickzbService icksl_ickzbService) {
		this.icksl_ickzbService = icksl_ickzbService;
	}

	public void setIckzbService(IIckzbService ickzbService) {
		this.ickzbService = ickzbService;
	}

	public void setWgcyryxxService(IWgcyryxxService wgcyryxxService) {
		this.wgcyryxxService = wgcyryxxService;
	}

	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}

	public void setQyry_zpService(IQyry_zpService qyry_zpService) {
		this.qyry_zpService = qyry_zpService;
	}

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}

	public Ickzb getIckzb() {
		return ickzb;
	}

	public void setIckzb(Ickzb ickzb) {
		this.ickzb = ickzb;
	}

	public Wgcyryxx getWgcyryxx() {
		return wgcyryxx;
	}

	public void setWgcyryxx(Wgcyryxx wgcyryxx) {
		this.wgcyryxx = wgcyryxx;
	}

	public Qyryxx getQyryxx() {
		return qyryxx;
	}

	public void setQyryxx(Qyryxx qyryxx) {
		this.qyryxx = qyryxx;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public String getFileload() {
		return fileload;
	}

	public void setFileload(String fileload) {
		this.fileload = fileload;
	}

	public Icksl getIcksl() {
		return icksl;
	}
	
	public List getLIcksl() {
		return lIcksl;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setIckslService(IIckslService ickslService) {
		this.ickslService = ickslService;
	}
	
	public void setIckrzjlService(IIckrzjlService ickrzjlService) {
		this.ickrzjlService = ickrzjlService;
	}

	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("qymc");
		lPro.add("lrsj");
		lPro.add("cylb");
		lPro.add("cyryzt");
		lPro.add("cyrylbdm");
		lPro.add("qyid");

		List lModify=new ArrayList();
    	lModify.add("setSlIck");
    	lModify.add("受理");
 	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	
    	Icksl getIcksl=new Icksl();
    	
        this.setData(getIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	private void setTabledatabh(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ickslid");
		//lPro.add("ickslid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("qymc");
		lPro.add("cjsj");
		lPro.add("cylb");
		lPro.add("cyryzt");

		List lModify=new ArrayList();
    	lModify.add("setBhIck");
    	lModify.add("补换卡");
 	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	
    	Icksl getIcksl=new Icksl();
    	
        this.setData(getIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}	
	
	private void setTabledatazkxx(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ickslid");
		lPro.add("kh");
		lPro.add("pch");
		lPro.add("xm");
		lPro.add("cyrybh");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("slsj");
		lPro.add("cjdmc");
		lPro.add("zkztmc");

		List lModify=new ArrayList();
    	lModify.add("");
    	lModify.add("");
 	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	
    	Icksl getIcksl=new Icksl();
    	
        this.setData(getIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	private void setTabledataff(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ickslid");
		lPro.add("ickslid");
		lPro.add("kh");
		lPro.add("xm");
		lPro.add("xb");
		lPro.add("qymc");
		lPro.add("yxqhzrq");
		lPro.add("wlpc");
    	
    	List lQzff=new ArrayList();
    	lQzff.add("setQzffIck");
    	lQzff.add("强制发放");
 	
    	List lCol=new ArrayList();
    	lCol.add(lQzff);
    	
    	Icksl getIcksl=new Icksl();
    	
        this.setData(getIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	private void setTabledatazx(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ickslid");
		lPro.add("ickslid");
		lPro.add("kh");
		lPro.add("xm");
		lPro.add("xb");
		lPro.add("qymc");
		lPro.add("yxqhzrq");
		lPro.add("wlpc");
    	
    	List lQzff=new ArrayList();
    	lQzff.add("setZxIck");
    	lQzff.add("注销");
 	
    	List lCol=new ArrayList();
    	lCol.add(lQzff);
    	
    	Icksl getIcksl=new Icksl();
    	
        this.setData(getIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	private void setTabledatazh(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ickslid");
		//lPro.add("ickslid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("xb");
		lPro.add("csrq");
		lPro.add("gj");
		lPro.add("zjhm");
		lPro.add("qymc");
		lPro.add("kh");
		lPro.add("zkztmc");
    	
//    	List lQzff=new ArrayList();
//    	lQzff.add("setIckxq");
//    	lQzff.add("详情");
// 	
//    	List lCol=new ArrayList();
//    	lCol.add(lQzff);
    	
    	Icksl getIcksl=new Icksl();
    	
        this.setData(getIcksl,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	/**人员信息状态改变（从数字转换为汉字，友好显示详细信息）*/
	private void setQyryxxDict_item(Qyryxx data){
		String displayName;
		Dict_item dict_item = new Dict_item();
		if(data.getCyryzt()!=null){
			displayName = "";
			dict_item.setDict_code("dm_jlzt");
			dict_item.setFact_value(data.getCyryzt());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setCyryzt(displayName);
		}
		/*if(data.getHyzk()!=null){
			displayName = "";
			dict_item.setDict_code("dm_hyzk");
			dict_item.setFact_value(data.getHyzk());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setHyzk(displayName);
		}*/
		if(data.getZxyy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zxyy(ylcs)");
			dict_item.setFact_value(data.getZxyy());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZxyy(displayName);
		}
		
	}
	
	private void setIckzhDict_item(Icksl data){
		String displayName;
		Dict_item dict_item = new Dict_item();
		if(data.getZkztbs()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zkzt");
			dict_item.setFact_value(data.getZkztbs());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZkztmc(displayName);
		}
		if(data.getSlyy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_ickslyy");
			dict_item.setFact_value(data.getSlyy());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setSlyy(displayName);
		}
		if(data.getIckzxyy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_ickzxyy");
			dict_item.setFact_value(data.getIckzxyy());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			if(displayName!=null && !displayName.equals(""))
				data.setIckzxyy(displayName);
			else{
				dict_item.setDict_code("dm_bhkyy");
				list = CacheManager.getCacheDictitem(dict_item);
				if(list!=null&&list.size()>0)
					displayName = ((Dict_item)list.get(0)).getDisplay_name();
				if(displayName!=null && !displayName.equals(""))
					data.setIckzxyy(displayName);
			}
		}
		if(data.getBhkyy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_bhkyy");
			dict_item.setFact_value(data.getBhkyy());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			if(displayName!=null && !displayName.equals(""))
				data.setBhkyy(displayName);
		}
		if(data.getCdxryy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_ickcxryy");
			dict_item.setFact_value(data.getCdxryy());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			if(displayName!=null && !displayName.equals(""))
				data.setCdxryy(displayName);
		}
		if(data.getCysyy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_ickcysyy");
			dict_item.setFact_value(data.getCysyy());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			if(displayName!=null && !displayName.equals(""))
				data.setCysyy(displayName);
		}if(data.getCyryzt()!=null){
			displayName = "";
			dict_item.setDict_code("dm_jlzt");
			dict_item.setFact_value(data.getCyryzt());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setCyryzt(displayName);
		}
		
		String yksfsh = data.getYksfsh();
		if(yksfsh!=null){
			if(yksfsh.equals("0"))
				data.setYksfsh("否");
			else
				data.setYksfsh("是");
		}
	}
	
	private void setIckDict_item(Icksl data){
		String displayName;
		Dict_item dict_item = new Dict_item();
		if(data.getZkztbs()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zkzt");
			dict_item.setFact_value(data.getZkztbs());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZkztmc(displayName);
		}if(data.getZt()!=null){
			displayName = "";
			dict_item.setDict_code("dm_jlzt");
			dict_item.setFact_value(data.getZt());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setCyryzt(displayName);
		}
	}
	
	/**IC卡受理列表信息*/
	public String querylist() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("hylbdm", icksl.getHylbdm());
				map.put("qymc", icksl.getQymc());
				map.put("qybm", icksl.getQybm());
				map.put("xm", icksl.getXm());
				map.put("cyzjdm", icksl.getCyzjdm());
				map.put("zjhm", icksl.getZjhm());
				map.put("lrsjf", icksl.getCjsjf());
				map.put("lrsjt", icksl.getCjsjt());
			}
			map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
			//设置采集点编码(需要改动，从session用户信息中得到)
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			String ssdwbm = user.getSsdwbm();
			if(ssdwbm!=null && !"".equals(ssdwbm)){
				map.put("deptCode", ssdwbm);//需要登录
			} else{
			    map.put("deptCode", user.getDepartment().getDepartcode());//需要登录
			}
			//人员单向核查开关开时（rydxhckg=1），人员提交后才能受理 20100910根据重庆娱乐业需求
			String ryhcdxkg = QjblUtil.queryQjblVal("ryhcdxkg");
			map.put("ryhcdxkg", ryhcdxkg);
			
	        Page page = ickslService.getWslIckslCyryxxList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
//	        	oneIcksl.setCyrybh(oneIcksl.getCyrybh()+
//	        			"<input type='hidden' name='"+oneIcksl.getRyid()+"' value='"+oneIcksl.getCyrylbdm()+"'/>" +
//	        					"<input type='hidden' name='cs"+oneIcksl.getRyid()+"' value='"+oneIcksl.getQyid()+"'/>");
	        	setIckDict_item(oneIcksl);
	        }
	        setTabledata(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }
	
	/**IC卡补换卡列表信息*/
	public String bhkIckList() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("hylbdm", icksl.getHylbdm());
				map.put("qymc", icksl.getQymc());
				map.put("qybm", icksl.getQybm());
				map.put("xm", icksl.getXm());
				map.put("cyzjdm", icksl.getCyzjdm());
				map.put("cjsjf", icksl.getCjsjf());
				map.put("cjsjt", icksl.getCjsjt());
				map.put("zjhm", icksl.getZjhm());
			}
				map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
			//每个采集点可对全省所有从业人员进行补换卡，因此无需使用登录用户所在部门进行权限限制 modified by mds at 20100728
			//设置采集点编码(需要改动，从session用户信息中得到)
			/*javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			map.put("deptCode", user.getDepartment().getDepartcode());*/
			Page page = ickslService.getBhkIckslList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIcksl = new ArrayList();
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
	        	oneIcksl.setCyrybh(oneIcksl.getCyrybh() + "<input type='hidden' name='"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrylbdm()+"'/>" +
	        					"<input type='hidden' name='ryid"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getRyid()+"'/>"+
	        						"<input type='hidden' name='qy"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getQyid()+"'/>");
	        	setIckDict_item(oneIcksl);
	        }
	        setTabledatabh(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }	
	
	/**IC卡发放列表信息*/
	public String ffIckList() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("hylbdm", icksl.getHylbdm());
				map.put("qymc", icksl.getQymc());
				map.put("xm", icksl.getXm());
				map.put("cyrybh", icksl.getCyrybh());
				map.put("kh", icksl.getKh());
				map.put("slsjf", icksl.getCjsjf());
				map.put("slsjt", icksl.getCjsjt());
			}
			map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
			map.put("zkztbs","24");//IC卡物流已接收
			//设置采集点编码(需要改动，从session用户信息中得到)
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			map.put("deptCode", user.getDepartment().getDepartcode());//需要登录
	        Page page = ickslService.getWffOrWzxIckslList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIcksl = new ArrayList();
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
	        	oneIcksl.setKh(oneIcksl.getKh()+"<input type='hidden' name='kh"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getKh()+"'/>" +
	         			"<input type='hidden' name='rylb"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrylbdm()+"'/>" + 
	         				"<input type='hidden' name='ryid"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getRyid()+"'/>"+
	        					"<input type='hidden' name='rybh"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrybh()+"'/>" + 
	        						"<input type='hidden' name='qy"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getQyid()+"'/>");
	        }
	        setTabledataff(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }	
	
	/**IC卡注销列表信息*/
	public String zxIckList() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("hylbdm", icksl.getHylbdm());
				map.put("qymc", icksl.getQymc());
				map.put("xm", icksl.getXm());
				map.put("cyrybh", icksl.getCyrybh());
				map.put("kh", icksl.getKh());
				map.put("slsjf", icksl.getCjsjf());
				map.put("slsjt", icksl.getCjsjt());
				map.put("zkztbs","6");//IC卡已发放
				
				//每个采集点能注销其他采集点的卡
				//设置采集点编码(需要改动，从session用户信息中得到)
				javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User)session.getAttribute(Constants.userKey);
				map.put("deptCode", user.getDepartment().getDepartcode());//需要登录
			}
				map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
	        Page page = ickslService.getWffOrWzxIckslList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIcksl = new ArrayList();
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
	        	oneIcksl.setKh(oneIcksl.getKh()+"<input type='hidden' name='kh"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getKh()+"'/>" +
	         			"<input type='hidden' name='rylb"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrylbdm()+"'/>" + 
	         				"<input type='hidden' name='ryid"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getRyid()+"'/>"+
	        					"<input type='hidden' name='rybh"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrybh()+"'/>" + 
	        						"<input type='hidden' name='qy"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getQyid()+"'/>");
	        }
	        setTabledatazx(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }	
	
	/**IC卡受理综合查询列表信息*/
	public String zhcxlist() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("hylbdm", icksl.getHylbdm());
				map.put("cyrybh", icksl.getCyrybh());
				map.put("kh", icksl.getKh());
				map.put("xm", icksl.getXm());
				map.put("ywx", icksl.getYwx());
				map.put("ywm", icksl.getYwm());
				map.put("qymc", icksl.getQymc());
				map.put("gmsfhm", icksl.getZjhm());
				map.put("sfzx", icksl.getSfzx());
				map.put("dqzt", icksl.getDqzt());
				
				map.put("hz", icksl.getQzhm());
				map.put("zkztbs", icksl.getZkztbs());
				map.put("slyy", icksl.getSlyy());
				//设置采集点编码(需要改动，从session用户信息中得到)
				javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User)session.getAttribute(Constants.userKey);
				map.put("deptCode", user.getDepartment().getDepartcode());//需要登录	
			}
				map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
	        Page page = ickslService.getIckslZhList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIcksl = new ArrayList();
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
	        	oneIcksl.setCyrybh(oneIcksl.getCyrybh() + "<input type='hidden' name='"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrylbdm()+"'/>" +
	        				"<input type='hidden' name='ryid"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getRyid()+"'/>" + 
        						"<input type='hidden' name='qy"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getQyid()+"'/>");
	        	setIckzhDict_item(oneIcksl);
	        }
	        setTabledatazh(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }
	
	
	/**查询IC卡受理单条信息*/
	public String query() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);
			String cyrylbdm = icksl.getCyrylbdm();
			if(cyrylbdm!=null){
				if(cyrylbdm.equals("0")){
					qyryxx = new Qyryxx();
					qyryxx.setRyid(icksl.getRyid());
				    qyryxx = qyryxxService.getQyryxx(qyryxx);
				    setQyryxxDict_item(qyryxx);
				}else{
					wgcyryxx = new Wgcyryxx();
					wgcyryxx.setRyid(icksl.getRyid());
				    wgcyryxx = wgcyryxxService.getWgcyryxx(wgcyryxx);
				    setQyryxxDict_item(wgcyryxx);
					if(wgcyryxx.getQzzldm()!=null){
						String displayName;
						Dict_item dict_item = new Dict_item();
						dict_item.setDict_code("dm_qzzl(lgy)");
						dict_item.setFact_value(wgcyryxx.getQzzldm());
						displayName = dict_itemService.getDictItemNameByDcFv(dict_item);
						wgcyryxx.setQzzldm(displayName);
					}
				}
			}
			// IC卡有效期从全局参数中取得，默认值为1年
			String ickyxq = QjblUtil.queryQjblVal("ickyxq");
			if(ickyxq == null || "".equals(ickyxq)){
				ickyxq = "1";
			}

	        Calendar currDate = Calendar.getInstance();
	        currDate.add(Calendar.DAY_OF_MONTH, 20);
	        currDate.set(Calendar.HOUR_OF_DAY, 0);
	        currDate.set(Calendar.MINUTE, 0);
	        currDate.set(Calendar.SECOND, 0);
	        icksl.setLqsj(currDate.getTime());
	        
	        currDate = Calendar.getInstance();
	        currDate.add(Calendar.YEAR, Integer.parseInt(ickyxq));
	        currDate.set(Calendar.HOUR_OF_DAY, 0);
	        currDate.set(Calendar.MINUTE, 0);
	        currDate.set(Calendar.SECOND, 0);
	        icksl.setYxqhzrq(currDate.getTime());
	        
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			icksl.setCjdbm(user.getDepartment().getDepartcode());
			icksl.setCjdmc(user.getDepartment().getDepartname());
			icksl.setSlr(user.getUseraccount());
			
	        lIcksl = new ArrayList();
	        lIcksl.clear();
	        lIcksl.add(icksl);
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }

	/**查询IC卡补换卡单条信息*/
	public String queryBhk() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);
			String cyrylbdm = icksl.getCyrylbdm();
	        icksl=ickslService.getIcksl(icksl);
	        
	        if(cyrylbdm!=null){
				if(cyrylbdm.equals("0")){
					qyryxx = new Qyryxx();
					qyryxx.setRyid(icksl.getRyid());
				    qyryxx = qyryxxService.getQyryxx(qyryxx);
				    setQyryxxDict_item(qyryxx);
				}else{
					wgcyryxx = new Wgcyryxx();
					wgcyryxx.setRyid(icksl.getRyid());
				    wgcyryxx = wgcyryxxService.getWgcyryxx(wgcyryxx);
				    setQyryxxDict_item(wgcyryxx);
				    if(wgcyryxx.getQzzldm()!=null){
						String displayName;
						Dict_item dict_item = new Dict_item();
						dict_item.setDict_code("dm_qzzl(lgy)");
						dict_item.setFact_value(wgcyryxx.getQzzldm());
						displayName = dict_itemService.getDictItemNameByDcFv(dict_item);
						wgcyryxx.setQzzldm(displayName);
					}
				}
				
				 Qyry_zp qyry_zp = new Qyry_zp();
			        qyry_zp.setRyid(icksl.getRyid());
			        qyry_zp = qyry_zpService.getQyry_zp(qyry_zp);
			        String fileload = null;
			        if(qyry_zp!=null&&qyry_zp.getTpnr()!=null&&qyry_zp.getTpnr().length>0){
			        	byte []bt = qyry_zp.getTpnr();
			        	sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
			        	fileload = base64Encoder.encode(bt);
			        	
			        	 StringReader sr = new StringReader(fileload);   
							BufferedReader br = new BufferedReader(sr);   
							String line = null;   
							String temp = "";   
							while((line=br.readLine())!=null)
							{   
							    temp += line;    
							}   
							fileload = temp;
			        }
			        if(qyryxx!=null)
			        	qyryxx.setFileload(fileload); 
			        else if(wgcyryxx!=null)
			        	wgcyryxx.setFileload(fileload); 
			}
	        
	        lIcksl.clear();
	        lIcksl.add(icksl);
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	

	/**查询IC卡发放单条信息*/
	public String queryFf() throws Exception{
		
		try {
			
		String kffsfxycs = null ;//从缓存中得到 "卡发放是否需要选择场所"(全局参数)
		Globalpar globalpar = new Globalpar();
		globalpar.setGlobalparcode("kffsfxycs");
		List list = CacheManager.getCacheGlobalpar(globalpar);
		if(list!=null&&list.size()>0){
			kffsfxycs = ((Globalpar)list.get(0)).getGlobalparvalue();
		}
		
		Icksl setIcksl=new Icksl();
		icksl=(Icksl)this.setClass(setIcksl, null);
		String qybm = icksl.getQybm();
		
		if(kffsfxycs!=null && "1".equals(kffsfxycs)){
			if((qybm==null || "".equals(qybm))){
			    this.result="请选择人员所在的企业名称,并重新刷卡";
			    return "success";
			}
		}else{
			Qyryxx qyryxx = new Qyryxx();
			qyryxx.setCyrybh(icksl.getCyrybh());
			qyryxx = qyryxxService.getQyryxx(qyryxx);
			qybm = qyryxx.getQybm();
		}
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("cyrybh", icksl.getCyrybh());
				map.put("kh", icksl.getKh());
				map.put("wlid","");
				map.put("zkztbs","24");//IC卡物流已接收
			}
			lIcksl = new ArrayList();
			lIcksl.clear();
	        lIcksl = ickslService.isCyrybhExistInIckslAndWldj(map);
	        
	        if(lIcksl!=null && lIcksl.size()>0){
	        	Icksl oneIcksl = (Icksl)lIcksl.get(0);
	        	setIckDict_item(oneIcksl);
	        	if(!(oneIcksl.getQybm().equals(qybm))){
	        		this.result="该人员不属于所选择的企业，不能发放";
					return "success";
	        	}
	        }
	        
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }

	/**查询IC卡综合信息单条信息*/
	public String queryZh() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);
	        icksl=ickslService.getIcksl(icksl);
	        setIckzhDict_item(icksl);
			Qyryxx setQyryxx = new Qyryxx();
			setQyryxx.setRyid(icksl.getRyid());
			qyryxx = qyryxxService.getQyryxx(setQyryxx);
			//setQyryxxDict_item(qyryxx);
			//依据IC卡受理ID得到IC卡受理组包Bean
			Icksl_ickzb oneIckzb = new Icksl_ickzb();
			oneIckzb.setIckslid(icksl.getIckslid());
			oneIckzb = icksl_ickzbService.getIcksl_ickzb(oneIckzb);
			
			//依据组包ID得到IC卡组包Bean
			ickzb = null;
			if(oneIckzb!=null && oneIckzb.getZbid()!=null){
				ickzb = new Ickzb();
				ickzb.setZbid(oneIckzb.getZbid());
				ickzb = ickzbService.getIckzb(ickzb);
			}
			//依据IC卡受理ID得到IC卡受理物流登记Bean
			Icksl_wldj oneIckwldj = new Icksl_wldj();
			oneIckwldj.setIckslid(icksl.getIckslid());
			oneIckwldj = icksl_wldjService.getIcksl_wldj(oneIckwldj);
			//依据组包ID得到IC卡组包Bean
			wldj = null;
			if(oneIckwldj!=null && oneIckwldj.getWlid()!=null){
				wldj = new Wldj();
				wldj.setWlid(oneIckwldj.getWlid());
				wldj = wldjService.getWldj(wldj);
			}
			
			zzzxsc = new Zzzxsc();
			//zzzxsc.setRyid(icksl.getRyid());
			zzzxsc.setIckslid(icksl.getIckslid());
			zzzxsc = zzzxscService.getZzzxsc(zzzxsc);
			
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }

	
	/**IC卡受理*/
	public String insert() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);
			
			Qyryxx qyryxx = new Qyryxx();
			qyryxx.setRyid(icksl.getRyid());
			qyryxx = qyryxxService.getQyryxx(qyryxx);
			
			//设置有效期开始日期(不要时间)
			Date date = new Date();
			try {
				date = DateUtil.convertStringToDate(DateToString.getDateEn(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			icksl.setYxsksrq(date);
			
			icksl.setQyryxx(qyryxx);
			
			HttpSession session = ServletActionContext.getRequest().getSession();
			
			String sssf = null ;//从缓存中得到所属省份(全局参数)
			Globalpar globalpar = new Globalpar();
			globalpar.setGlobalparcode("sssf");
			List list = CacheManager.getCacheGlobalpar(globalpar);
			if(list!=null&&list.size()>0)
				sssf = ((Globalpar)list.get(0)).getGlobalparvalue();
			icksl.setSssf(sssf);
			
	        icksl=ickslService.insertIcksl(icksl);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
	        this.result="受理失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	/**IC卡补换卡*/
	public String insertBhk() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String lrdwbm = user.getDepartment().getDepartcode();
		String lrdwmc = user.getDepartment().getDepartname();
		if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
			lrdwbm = user.getSsdwbm();
			lrdwmc = user.getSsdwmc();
		}
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);

			Qyryxx setQyryxx=new Qyryxx();
			qyryxx=(Qyryxx)this.setClass(setQyryxx, null);
			
			//qyryxx.setIcksl(icksl);
			
			Qyry_zp qyry_zp = new Qyry_zp();
			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
			if(qyryxx.getFileload()!=null&&!"".equals(qyryxx.getFileload())){
				byte []by = base64Decoder.decodeBuffer(qyryxx.getFileload());
				qyry_zp.setTpnr(by);
				qyryxx.setQyry_zp(qyry_zp);
			}
			qyryxx.setLrr(user.getUseraccount());
			qyryxx.setLrdwbm(lrdwbm);
			qyryxx.setLrdwmc(lrdwmc);
			
			icksl.setQyryxx(qyryxx);
			icksl.setIckzxr(user.getUseraccount());//注销人
			
			ickslService.updateIckslBhk(icksl);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
	        this.result="补换卡失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	/**IC卡常规发放*/
	public String modifyff() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);
			
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			icksl.setFfr(user.getUseraccount());//发放人
			
			ickslService.updateIckslFf(icksl);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result="发放失败";
			e.printStackTrace();
		}
        return "success";
    }

	/**IC卡强制发放*/
	public String modifyQzff() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);
			
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			icksl.setFfr(user.getUseraccount());//发放人
			
	        ickslService.updateIckslQzff(icksl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result="强制发放失败";
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
	
	/**IC卡常规发放*/
	public String modifyzx() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);
			
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			icksl.setIckzxr(user.getUseraccount());//注销人
			icksl.setCzlx("IC卡注销");
			ickslService.updateIckslZx(icksl);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result="注销失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ickslService.deleteIcksl(icksl);
        this.result="success";
        return "success";
    }	

	public void setTabledataZBData(List lData) throws Exception {
		List lPro = new ArrayList();

		lPro.add("ickslid");
		lPro.add("zjhm");
		lPro.add("xm");
		lPro.add("ryid");
		lPro.add("qyid");
		lPro.add("cjdbm");

		Icksl getIcksl=new Icksl();

		this.setData(getIcksl,lData,lPro,null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	/**IC卡受理信息多选列表查询*/
	public String listOfIck() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			
			//if(icksl==null)
			//	icksl = new Icksl();
			//icksl.setZkztbs("2");
			//if(icksl.getQybm()!=null &&!"".equals(icksl.getQybm()))
			//	icksl.setCjdbm(icksl.getQybm());
			List icksList = ickslService.getWzbIckslList(setIcksl);
			
			if(icksList.size()>80){
				icksList = icksList.subList(0, 80);//一次最多取80条记录
			}
			
			totalrows = icksList.size();
			setTabledataZBData(icksList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
	
	/**IC卡照片审核列表查询*/
	public String listOfZpsh() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);

			HttpSession session = ServletActionContext.getRequest().getSession();
			Map map = new HashMap();
			if(icksl!=null){
				map.put("hylbdm", icksl.getHylbdm());
				map.put("cjdbm",icksl.getCjdbm());
				map.put("gxdwbm",StringUtil.trimEven0(icksl.getGxdwbm()));
				
				String sfjxgarkkbd = null;
				Globalpar globalpar = new Globalpar();
				globalpar.setGlobalparcode("sfjxgarkkbd");
				List list = CacheManager.getCacheGlobalpar(globalpar);
				if(list!=null&&list.size()>0)
					sfjxgarkkbd = ((Globalpar)list.get(0)).getGlobalparvalue();
				map.put("sfjxgarkkbd",sfjxgarkkbd);
			}
			Page page = ickslService.getWshzpList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIcksl=page.getData();

			Map rytpMap = new HashMap();
			for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
				Icksl oneIcksl = (Icksl)iter.next();
				rytpMap.put(oneIcksl.getRyid(),oneIcksl.getTpnr());
				oneIcksl.setTpnr(null);
			}
			session.setAttribute("rytpnr", rytpMap);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
    
	//根据人员ID查询人员照片
	public void queryTp() throws Exception{
		javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest requeset = ServletActionContext.getRequest();
		OutputStream out = response.getOutputStream();
		try{
    		
			Map rytpMap = (Map)session.getAttribute("rytpnr");
			
        	String ryId = requeset.getParameter("ryId");
        	
    		
			response.setCharacterEncoding("UTF-8");
			response.setContentType("image/jpeg");
			byte [] by = (byte[])rytpMap.get(new Integer(ryId));
    		if(by==null && by.length==0){
    			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
				by = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
    		}
        		
    		out.write(by);
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		if(out!=null)
    			out.close();
    	}
	}
	
	/**IC卡照片审核*/
	public String modifyZpsh() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);

			//从Session中去是否进行公安人口库比对全局参数及当前登陆用户
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			icksl.setCzr(user.getUseraccount());
			
			String sfjxgarkkbd = null;
			Globalpar globalpar = new Globalpar();
			globalpar.setGlobalparcode("sfjxgarkkbd");
			List list = CacheManager.getCacheGlobalpar(globalpar);
			if(list!=null&&list.size()>0)
				sfjxgarkkbd = ((Globalpar)list.get(0)).getGlobalparvalue();
			icksl.setSfjxgarkkbd(sfjxgarkkbd);

			//得到及组织前台拼写的参数串(解析成数组，存放到icksl和cyryxx list中)
			String ryidSet = icksl.getRyidSet();
			String ickslidSet = icksl.getIckslidSet();
			String qyidSet = icksl.getQyidSet();
			String zpsftgSet = icksl.getZpsftgSet();
			String wtgyySet = icksl.getWtgyySet();
			
			if(ryidSet!=null && !ryidSet.equals("")){
				String[] ryidArry = ryidSet.split("_,,");
				String[] ickslidArry = ickslidSet.split("_,,");
				String[] qyidArry = qyidSet.split("_,,");
				String[] zpsftgArry = zpsftgSet.split("_,,");
				String[] wtgyyArry = wtgyySet.split("_,,");

				List ickslList = new ArrayList();
				List cyryxxList = new ArrayList();
				for(int index=0,max=ryidArry.length;index<max;index++){
					Icksl temp = new Icksl();
					temp.setRyid(new Integer(ryidArry[index]));
					temp.setIckslid(new Integer(ickslidArry[index]));
					temp.setSftg(zpsftgArry[index]);
					
					Qyryxx oneQyryxx = new Qyryxx();
					oneQyryxx.setRyid(new Integer(ryidArry[index]));
					oneQyryxx.setQyid(new Integer(qyidArry[index]));
					
					oneQyryxx.setZpwtgyy(wtgyyArry[index].replaceAll("@##@", ""));
					
					ickslList.add(temp);
					cyryxxList.add(oneQyryxx);
				}			
				icksl.setLIcksl(ickslList);
				icksl.setLQyryxx(cyryxxList);
			}
			
	        if(ickslService.updateIckslZpsh(icksl))
	            this.result="success";
	        else
	            this.result="审核失败";
	        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result="审核失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	/**IC卡照片全部审核*/
	public String modifyZpqbsh() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);

			//从Session中去是否进行公安人口库比对全局参数及当前登陆用户
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			icksl.setCzr(user.getUseraccount());
			
			String sfjxgarkkbd = null;
			Globalpar globalpar = new Globalpar();
			globalpar.setGlobalparcode("sfjxgarkkbd");
			List list = CacheManager.getCacheGlobalpar(globalpar);
			if(list!=null&&list.size()>0)
				sfjxgarkkbd = ((Globalpar)list.get(0)).getGlobalparvalue();
			icksl.setSfjxgarkkbd(sfjxgarkkbd);
			
	        ickslService.updateIckslZpshAll(icksl);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result="照片审核失败";
			e.printStackTrace();
		}
        return "success";
    }	
	
	
	/**制卡信息列表查询*/
	public String querylistZkxx() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("hylbdm", icksl.getHylbdm());
				map.put("cjdbm", StringUtil.trimEven0(icksl.getCjdbm()));
				map.put("cyrybh", icksl.getCyrybh());
				map.put("xm", icksl.getXm());
				map.put("zkztbs", icksl.getZkztbs());
				map.put("mzdm", icksl.getMzdm());
				map.put("xbdm", icksl.getXbdm());
	        	map.put("cylbdm", StringUtil.trim0(icksl.getCylbdm()));
				map.put("slsjf", icksl.getSlsjf());
				map.put("slsjt", icksl.getSlsjt());
				map.put("pch", icksl.getPch());
				map.put("cyzjdm", icksl.getCyzjdm());
				map.put("zjhm", icksl.getZjhm());
				map.put("isTongyin",icksl.getSfty());
				map.put("xmpy",PinYinUtil.getHanyuPingYin(icksl.getXm()));
				map.put("dqzt", icksl.getDqzt());
			}
			
	        Page page = ickslService.getIckslZkdForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIcksl = new ArrayList();
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
	        	oneIcksl.setCyrybh(oneIcksl.getCyrybh() + "<input type='hidden' name='"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrylbdm()+"'/>" +
	        				"<input type='hidden' name='ryid"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getRyid()+"'/>" +
	        						"<input type='hidden' name='zkzt"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getZkztbs()+"'/>");
	        	setIckzhDict_item(oneIcksl);
	        }
	        setTabledatazkxx(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }
	
	/**IC卡重印*/
	public String modifyCy() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);

			//从Session中得到当前登陆用户
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			icksl.setCzr(user.getUseraccount());
			
	        if(ickslService.updateIckslCys(icksl))
				this.result="success";
	        else
				this.result="重印失败";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result="重印失败";
			e.printStackTrace();
		}
        return "success";
    }	
	
	
	/**IC卡重写*/
	public String modifyCx() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);

			//从Session中得到当前登陆用户
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			icksl.setCzr(user.getUseraccount());
			
	        if(ickslService.updateIckslCdxr(icksl))
				this.result="success";
	        else
				this.result="重写失败";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result="重写失败";
			e.printStackTrace();
		}
        return "success";
    }	
	
	
	/**
	 * 制卡端 IC卡 请求列表
	 * @return
	 * @throws Exception
	 */
	public String queryIckZkdList() throws Exception{
		try {
			Map dictTemp = new HashMap();
			dictTemp.put("", ""); dictTemp.put(null, "");
			Map dict = new HashMap();
			dict.put("dict_code","dm_zkzt");
			Page dictpage = dict_itemService.getListForPage(dict, 1, 30,null,null);
			List dictList = dictpage.getData();
			if(dictList!=null&&dictList.size()>0){
				for(int index=0,max=dictList.size();index<max;index++){
					Dict_item temp = (Dict_item)dictList.get(index);
					dictTemp.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			
			Icksl setIcksl = new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
	        Map map = new HashMap();
	        map.put("hylbdm", setIcksl.getHylbdm());
	        map.put("kh", setIcksl.getKh());
	        map.put("cyrybh", setIcksl.getCyrybh());
	        map.put("xm", setIcksl.getXm());
	        map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
	        Page page = ickslService.getIckslZkdglcxList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        List tempList = page.getData();
        	List resList = new ArrayList();
        	if(tempList!=null&&tempList.size()>0){
    			for(int index=0,max=tempList.size();index<max;index++){
    				Icksl temp = (Icksl)tempList.get(index);
    				temp.setZkztbs((String)dictTemp.get(temp.getZkztbs()));
    				resList.add(temp);
    			}
    		}
        	
	        if(setIcksl.getZkdCyryIck()!=null&&"1".equals(setIcksl.getZkdCyryIck())){ //人员信息 查询 IC卡信息
	        	setQyryIckZkdTabledata(resList);
	        } else {
	        	setIckZkdTabledata(resList); 
	        }
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		    return "success";
		}
		this.result="success";
	    return "success";
	}
	/**
	 *  制卡端 IC卡 列表
	 * @return
	 * @throws Exception
	 */
	public void setIckZkdTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("kh");
		lPro.add("cyrybh");
		lPro.add("gj");
		lPro.add("xb");
		lPro.add("yxqhzrq");
		lPro.add("zkztbs");
		
		List lXzcz=new ArrayList();
		List lCk = new ArrayList();
    	lCk.add("gn");
    	lCk.add("相关从业人员");
    	lCk.add("cyrylbdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("gw");
    	lCk.add("相关从业人员");
    	lCk.add("cyrylbdm");
    	lCk.add("1");
    	lXzcz.add(lCk);

    	Icksl setIcksl = new Icksl();
        this.setDataCustomer(setIcksl,lData,lPro,null,lXzcz);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 *  制卡端 从业人员 查询 IC卡 列表
	 * @return
	 * @throws Exception
	 */
	public void setQyryIckZkdTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ickslid");
		lPro.add("kh");
		lPro.add("gj");
		lPro.add("xb");
		lPro.add("yxqhzrq");
		lPro.add("zkztbs");
    	
    	List lCol=new ArrayList();
    	
    	Icksl setIcksl = new Icksl();
    	
        this.setData(setIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 制卡端 日志查询 请求类表
	 * @return
	 * @throws Exception
	 */
	public String queryRzcxZkdList() throws Exception{
		try {
			Ickrzjl setIckrzjl = new Ickrzjl();
			setIckrzjl=(Ickrzjl)this.setClass(setIckrzjl, null);
	        Map map = new HashMap();
	        map.put("xm", setIckrzjl.getXm());
	        map.put("cyrybh", setIckrzjl.getCyrybh());
	        map.put("czlb", setIckrzjl.getCzlb());
	        map.put("hylbdm",setIckrzjl.getHylbdm());
	        Page page = ickrzjlService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setRzcxZkdTabledata(page.getData()); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		    return "success";
		}
		this.result="success";
	    return "success";
	}
	/**
	 *  制卡端 IC卡 列表
	 * @return
	 * @throws Exception
	 */
	public void setRzcxZkdTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("rzbh");
		lPro.add("glbh");
		lPro.add("pch");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("czlb");
		lPro.add("czr");
		lPro.add("czsj");
    	
    	List lCol=new ArrayList();
    	
    	Ickrzjl setIckrzjl = new Ickrzjl();
    	
        this.setData(setIckrzjl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	/**
	 * 第三方制卡统计 请求列表
	 * @return
	 * @throws Exception
	 */
	public String queryDsfzkTjList() throws Exception{
		try {
			Icksl setIcksl = new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
	        Map map = new HashMap();
	        map.put("hylbdm", setIcksl.getHylbdm());  //20110110 添加行业类别筛选条件
	        map.put("deptCode", setIcksl.getDeptCode());
	        map.put("ssdsbm", setIcksl.getSsdsbm());
			map.put("cjdbm", setIcksl.getCjdbm());
			map.put("ssdsbz", setIcksl.getSsdsbz());
			map.put("cjdbz", setIcksl.getCjdbz());
			map.put("cjsjf", setIcksl.getQssj());
			map.put("cjsjt", setIcksl.getJzsj());
	        Page page = ickslService.getDsfzktjList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        List list = page.getData();
	        dsfZhengheId(list);
	        setDsfzkTjTabledata(list,setIcksl); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		    return "success";
		}
		this.result="success";
	    return "success";
	}
	/**
	 *  第三方制卡统计--企业端 列表
	 * @return
	 * @throws Exception
	 */
	public void setDsfzkTjTabledataQyd(List lData,Icksl setIcksl) throws Exception{
		List lPro=new ArrayList();
		lPro.add("sssf");
		
		lPro.add("yfssl");
		lPro.add("yfksl");
		lPro.add("yzksl");
		lPro.add("fksbsl");
		lPro.add("yffsl");
    	
    	List lCol=new ArrayList();
    	Icksl getIcksl = new Icksl();
        this.setData(getIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 第三方制卡统计--企业端 请求列表
	 * @return
	 * @throws Exception
	 */
	public String queryDsfzkTjListQyd() throws Exception{
		try {
			Icksl setIcksl = new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
	        Map map = new HashMap();
			map.put("cjdbm", setIcksl.getCjdbm());
			map.put("cjsjf", setIcksl.getQssj());
			map.put("cjsjt", setIcksl.getJzsj());
	        Page page = ickslService.getDsfzktjListQyd(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        List list = page.getData();
	        dsfZhengheId(list);
	        setDsfzkTjTabledataQyd(list,setIcksl); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		    return "success";
		}
		this.result="success";
	    return "success";
	}
	
	public String queryIckZhuanQuListExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Icksl setIcksl = new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			Map map = new HashMap();
			map.put("deptCode", setIcksl.getDeptCode());
	        map.put("ssdsbm", setIcksl.getSsdsbm());
			map.put("cjdbm", setIcksl.getCjdbm());
			map.put("ssdsbz", setIcksl.getSsdsbz());
			map.put("cjdbz", setIcksl.getCjdbz());
			map.put("cjsjf", setIcksl.getQssj());
			map.put("cjsjt", setIcksl.getJzsj());
			
			Page page = ickslService.getDsfzktjList(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("dswtjList", page.getData());
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	
	public void queryIckZhuanQuListExcel(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Icksl setIcksl = new Icksl();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("dswtjList"));
			lResult.add(setIcksl);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
	}
	public String queryIckZhuanQuListExcelQydTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Icksl setIcksl = new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			Map map = new HashMap();
			map.put("cjdbm", setIcksl.getCjdbm());
			map.put("cjsjf", setIcksl.getQssj());
			map.put("cjsjt", setIcksl.getJzsj());
			
			Page page = ickslService.getDsfzktjListQyd(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("dswtjQydList", page.getData());
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	
	public void queryIckZhuanQuListExcelQyd(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Icksl setIcksl = new Icksl();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("dswtjQydList"));
			lResult.add(setIcksl);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
	}
	/**
	 * 第三方制卡统计 砖取 请求列表
	 * @return
	 * @throws Exception
	 */
	public String queryIckZhuanQuList() throws Exception{
		try {
			Map dictTemp = new HashMap();
			dictTemp.put("", ""); dictTemp.put(null, "");
			Map dict = new HashMap();
			dict.put("dict_code","dm_zkzt");
			Page dictpage = dict_itemService.getListForPage(dict, 1, 30,null,null);
			List dictList = dictpage.getData();
			if(dictList!=null&&dictList.size()>0){
				for(int index=0,max=dictList.size();index<max;index++){
					Dict_item temp = (Dict_item)dictList.get(index);
					dictTemp.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			
			Icksl setIcksl = new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
	        Map map = new HashMap();
	        map.put("ssdsbm", setIcksl.getSsdsbm());
			map.put("cjdbm", setIcksl.getCjdbm());
			map.put("zqsjx", setIcksl.getZqsjx());
			map.put("deptCode", setIcksl.getDeptCode());
			map.put("cjsjf", setIcksl.getCjsjf());
			map.put("cjsjt", setIcksl.getCjsjt());
			map.put("hylbdm",setIcksl.getHylbdm());
	        Page page = ickslService.getIckslZkdglcxList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        List tempList = page.getData();
        	List resList = new ArrayList();
        	if(tempList!=null&&tempList.size()>0){
    			for(int index=0,max=tempList.size();index<max;index++){
    				Icksl temp = (Icksl)tempList.get(index);
    				temp.setZkztbs((String)dictTemp.get(temp.getZkztbs()));
    				resList.add(temp);
    			}
    		}
	        setIckZkdTabledata(resList); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		    return "success";
		}
		this.result="success";
	    return "success";
	}
	
	/**
	 *  第三方制卡统计 列表
	 * @return
	 * @throws Exception
	 */
	public void setDsfzkTjTabledata(List lData,Icksl setIcksl) throws Exception{
		List lPro=new ArrayList();
		lPro.add("sssf");
		
		if("1".equals(setIcksl.getSsdsbz())){
			lPro.add("ssdsmc");
		}
		if("1".equals(setIcksl.getCjdbz())){
			lPro.add("cjdmc");
		}
		lPro.add("hylb");
		lPro.add("hylbdm");
		lPro.add("yfssl");
		lPro.add("yfksl");
		lPro.add("yzksl");
		lPro.add("fksbsl");
		lPro.add("yffsl");
    	
    	List lCol=new ArrayList();
    	Icksl getIcksl = new Icksl();
        this.setData(getIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void dsfZhengheId(List list){
		if(list!=null&&list.size()>0){
			for(int index=0,max=list.size();index<max;index++){
				Icksl temp = (Icksl)list.get(index);
				temp.setSssf(temp.getSsdsbm()+"---"+temp.getCjdbm());
			}
		}
	}
	
	/**
	 * 定时调用方法
	 * 1、根据从业人员状态对制卡状态置位
	 * 2、自动审核照片
	 */
	public void checkZkztAndZpsh() throws Exception
	{
		String sfjxgarkkbd = QjblUtil.queryQjblVal("sfjxgarkkbd");//是否进行人口库核查 1-进行核查
		String sfsdshzp = QjblUtil.queryQjblVal("sfsdshzp");//是否需要自动审核照片 0-自动审核
		
		//制卡状态标识置位
		if("1".equals(sfjxgarkkbd))
		{
			//查询状态为1、4、5的从业人员
			List yhcCyryxxList = new ArrayList();
			Qyryxx qyryxx = null;
			yhcCyryxxList = qyryxxService.getYhcCyryxxList(qyryxx);
			if(yhcCyryxxList!=null && yhcCyryxxList.size()>0)
			{
				for(int i = 0;i<yhcCyryxxList.size();i++)
				{
					qyryxx = new Qyryxx();
					qyryxx = (Qyryxx)yhcCyryxxList.get(i);
					
					//查询该人员是否已受理，且制卡状态为0(IC卡受理未结束)，若存在则制卡状态置为1(IC卡受理已结束)
					Icksl icksl = new Icksl();
					icksl.setRyid(qyryxx.getRyid());
					icksl.setZkztbs("0");
					icksl = ickslService.getIcksl(icksl);
					if(icksl != null)
					{
						icksl.setZkztbs("1");// IC卡受理已结束
						icksl.setCzlx("与公安人口库比对");
						icksl.setCzr("公安人口库比对程序");
						ickslService.updateIcksl(icksl);
					}
				}
			}
		}
		
		//自动审核照片
		if("0".equals(sfsdshzp))
		{
			Icksl icksl = new Icksl();
			icksl.setSfjxgarkkbd(sfjxgarkkbd);
			icksl.setCzr("自动审核照片程序");
			ickslService.updateIckslZpshAll(icksl);
		}
	}
	/**
	 * 制卡端--台账--信息统计
	 */
	public String zkdtzxxtj() throws Exception {
		try {
			Icksl slxx = new Icksl();
			Map map = new HashMap();
			String ejshkg = "0";//二级审核开关

			String sfjxgarkkbd = "0";//是否进行公安人口库比对

			ejshkg = QjblUtil.queryQjblVal("ejshkg");
			if(ejshkg==null||"".equals(ejshkg))
				ejshkg = "0";
			sfjxgarkkbd = QjblUtil.queryQjblVal("sfjxgarkkbd");
			map.put("ejshkg", ejshkg);
			map.put("sfjxgarkkbd", sfjxgarkkbd);
			slxx = ickslService.getIckTjxx(map);
			lIcksl.add(slxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
	}
	
	/**
	 *  采集端--台账--第三方制卡统计 列表
	 * @return
	 * @throws Exception
	 */
	public void tzDsfzkTjTabledata(List lData,Icksl setIcksl) throws Exception{
		List lPro=new ArrayList();
		lPro.add("sssf");
		
		if("1".equals(setIcksl.getSsdsbz())){
			lPro.add("ssdsmc");
		}
		if("1".equals(setIcksl.getCjdbz())){
			lPro.add("cjdmc");
		}
		lPro.add("qysl");
		lPro.add("rysl");
		lPro.add("yslick");
		lPro.add("yfssl");
		lPro.add("yfksl");
		lPro.add("yzksl");
		lPro.add("fksbsl");
		lPro.add("yffsl");
    	
    	List lCol=new ArrayList();
    	Icksl getIcksl = new Icksl();
        this.setData(getIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	/**
	 * 采集端--台账--第三方制卡统计 
	 * @return
	 * @throws Exception
	 */
	public String tzDsfzkTjList() throws Exception{
		try {
			Icksl setIcksl = new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
	        Map map = new HashMap();
	        map.put("ssdsbm", setIcksl.getSsdsbm());
			map.put("cjdbm", setIcksl.getCjdbm());
			map.put("ssdsbz", setIcksl.getSsdsbz());
			map.put("cjdbz", setIcksl.getCjdbz());
	        Page page = ickslService.getDsfzkxxList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        List list = page.getData();
	        dsfZhengheId(list);
	        tzDsfzkTjTabledata(list,setIcksl); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		    return "success";
		}
		this.result="success";
	    return "success";
	}
	/**
	 * 制卡端--台账--信息统计
	 */
	public String cjdtzxxtj() throws Exception {
		try {
			Icksl setIcksl=new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);  
			Icksl slxx = new Icksl();
			Map map = new HashMap();
			//设置采集点编码(需要改动，从session用户信息中得到)
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			map.put("allhylbdm", setIcksl.getHylbdm());//娱乐业
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));//需要登录
			slxx = ickslService.getCjdIckTjxx(map);
			lIcksl.add(slxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
	}
	/**制卡端--台账--信息统计--IC卡待受理列表信息*/
	public String querylistCount() throws Exception{
		try {
			Map map = new HashMap();
			//设置采集点编码(需要改动，从session用户信息中得到)
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));//需要登录
			map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
			int dslicksl = ickslService.getCjdIckDslCount(map);
			lIcksl.add(dslicksl);
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }
	
	/**IC卡受理超时未办理列表信息*/
	public String ickcswbllist() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(setIcksl!=null){
				map.put("hylbdm", "J");
				String ickcsblts = QjblUtil.queryQjblVal("ickcsblts");//ick超时办理天数
				map.put("ickcsblts", ickcsblts);
				//设置采集点编码(需要改动，从session用户信息中得到)
				javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User)session.getAttribute(Constants.userKey);
				map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));//需要登录
			}
			map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
	        Page page = ickslService.getIckslZhList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIcksl = new ArrayList();
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
	        	oneIcksl.setCyrybh(oneIcksl.getCyrybh() + "<input type='hidden' name='"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrylbdm()+"'/>" +
	        				"<input type='hidden' name='ryid"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getRyid()+"'/>" + 
        						"<input type='hidden' name='qy"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getQyid()+"'/>");
	        	setIckzhDict_item(oneIcksl);
	        }
	        setTabledatazh(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }
	
	/**IC卡已受理列表信息*/
	public String queryYsllist() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("allhylbdm", icksl.getHylbdm());
				map.put("lrsj", icksl.getLrsj());
			}
			//设置采集点编码(需要改动，从session用户信息中得到)
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
	        Page page = ickslService.getYslIckslCyryxxList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
	        	setIckDict_item(oneIcksl);
	        }
	        setYslTabledata(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }
	public void setYslTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("qymc");
		lPro.add("lrsj");
		lPro.add("cylb");
		lPro.add("cyryzt");
		lPro.add("cyrylbdm");
		lPro.add("qyid");

    	Icksl getIcksl=new Icksl();
    	
        this.setData(getIcksl,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**IC卡受理综合查询列表信息---已发放IC卡*/
	public String yfficklist() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("allhylbdm", icksl.getHylbdm());
				map.put("yffickxx", "1");
				map.put("ffsj", icksl.getFfsj());
				//设置采集点编码(需要改动，从session用户信息中得到)
				javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User)session.getAttribute(Constants.userKey);
				map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));//需要登录
			}
			
	        Page page = ickslService.getIckslZhList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIcksl = new ArrayList();
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
	        	oneIcksl.setCyrybh(oneIcksl.getCyrybh() + "<input type='hidden' name='"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrylbdm()+"'/>" +
	        				"<input type='hidden' name='ryid"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getRyid()+"'/>" + 
        						"<input type='hidden' name='qy"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getQyid()+"'/>");
	        	setIckzhDict_item(oneIcksl);
	        }
	        setTabledatazh(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }
	/**IC卡受理综合查询列表信息---已注销IC卡*/
	public String yzxicklist() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("allhylbdm", icksl.getHylbdm());
				map.put("yzxickxx", "1");
				map.put("zxsj", icksl.getIckzxsj());
				//设置采集点编码(需要改动，从session用户信息中得到)
				javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User)session.getAttribute(Constants.userKey);
				map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));//需要登录
			}
			
	        Page page = ickslService.getIckslZhList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIcksl = new ArrayList();
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
	        	oneIcksl.setCyrybh(oneIcksl.getCyrybh() + "<input type='hidden' name='"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrylbdm()+"'/>" +
	        				"<input type='hidden' name='ryid"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getRyid()+"'/>" + 
        						"<input type='hidden' name='qy"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getQyid()+"'/>");
	        	setIckzhDict_item(oneIcksl);
	        }
	        setTabledatazh(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }
	/**IC卡受理综合查询列表信息---补换IC卡*/
	public String bhicklist() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			icksl=(Icksl)this.setClass(setIcksl, null);  
			
			Map map = new HashMap();
			if(icksl!=null){
				map.put("allhylbdm", icksl.getHylbdm());
				map.put("bhickxx", "1");
				map.put("bhksj", icksl.getIckzxsj());
				//设置采集点编码(需要改动，从session用户信息中得到)
				javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User)session.getAttribute(Constants.userKey);
				map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));//需要登录
			}
			
	        Page page = ickslService.getIckslZhList(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIcksl = new ArrayList();
	        lIcksl=page.getData();
	        
	        for(java.util.Iterator iter=lIcksl.iterator();iter.hasNext();){
	        	Icksl oneIcksl = (Icksl)iter.next();
	        	oneIcksl.setCyrybh(oneIcksl.getCyrybh() + "<input type='hidden' name='"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getCyrylbdm()+"'/>" +
	        				"<input type='hidden' name='ryid"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getRyid()+"'/>" + 
        						"<input type='hidden' name='qy"+oneIcksl.getIckslid()+"' value='"+oneIcksl.getQyid()+"'/>");
	        	setIckzhDict_item(oneIcksl);
	        }
	        setTabledatazh(lIcksl); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return "success";
    }
	/**通过芯片号查询IC卡受理相关信息-卡号、从业人员编码等*/
	public String queryKhcyrybm() throws Exception{
		try {
			Icksl setIcksl=new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			Map map = new HashMap();
			if(setIcksl!=null){
				map.put("ickh", setIcksl.getIckh());
				map.put("zkztbs",setIcksl.getZkztbs());
			}
			List temp=ickslService.getIckslByCyrybhAndKh(map);
			if (temp.size()==1){
				icksl=(Icksl)temp.get(0);
				lIcksl = new ArrayList();
		        lIcksl.clear();
		        lIcksl.add(icksl);
				this.result="success";
			} else {
				this.result="获取旧卡从业人员编码和卡号失败";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
}