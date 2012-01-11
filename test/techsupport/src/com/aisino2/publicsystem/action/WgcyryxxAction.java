package com.aisino2.publicsystem.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;
import com.aisino2.publicsystem.domain.Wgcyryxx;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IQyryxx_lsxxService;
import com.aisino2.publicsystem.service.IWgcyryxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;


public class WgcyryxxAction extends PageAction{
	private IWgcyryxxService wgcyryxxService;
	private IQyryxxService qyryxxService;
	private IQyjbxxService qyjbxxService;
	private IQyryxx_lsxxService qyryxx_lsxxService;
	private List lWgcyryxx=new ArrayList();
	private Wgcyryxx wgcyryxx=new Wgcyryxx();
	private String tabledata="";
	private int totalrows=0;
	private String result="success";
	private int myPageSize=0;
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Wgcyryxx getWgcyryxx() {
		return wgcyryxx;
	}
	
	public List getLWgcyryxx() {
		return lWgcyryxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setWgcyryxxService(IWgcyryxxService wgcyryxxService) {
		this.wgcyryxxService = wgcyryxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("zt");
		lPro.add("cyryzt");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	List lTj=new ArrayList();
    	lTj.add("detailTjxx");
    	lTj.add("体检信息");
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	lCol.add(lTj);
    	Wgcyryxx getWgcyryxx=new Wgcyryxx();
    	
        this.setData(getWgcyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataGadsc(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		//lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("zxr");
		lPro.add("zxsj");
		lPro.add("cyryzt");
    	
    	
    	Wgcyryxx getWgcyryxx=new Wgcyryxx();
    	
        this.setData(getWgcyryxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataGadzx(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		//lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("zt");
		lPro.add("cyryzt");
    	
		List lXzcz = new ArrayList();

    	List lZx=new ArrayList();
    	//lZx.add("setCyryZx");
    	lZx.add("setWgcyryZx");
    	lZx.add("注销");
    	lZx.add("zxbz");
    	lZx.add("0");
    	lXzcz.add(lZx);
    	
    	lZx=new ArrayList();
    	//lZxhf.add("setCyryZxhf");
    	lZx.add("setWgcyryZxhf");
    	lZx.add("注销恢复");
    	lZx.add("zxbz");
    	lZx.add("1");
    	lXzcz.add(lZx);
    	
    	Wgcyryxx getWgcyryxx=new Wgcyryxx();
    	
      	this.setDataCustomer(getWgcyryxx, lData, lPro, null, lXzcz);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public String querylist() throws Exception{
        Wgcyryxx setWgcyryxx=new Wgcyryxx();
        setWgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
        Map map = new HashMap();
        map=addMap(setWgcyryxx);
        map.put("scbz", "0");
        if(map.get("qyid")!=null&&!"".equals(map.get("qyid").toString())){
	        Page page = wgcyryxxService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        
	        lWgcyryxx=page.getData();
	        String jdzkd = "" ;//从缓存中得到制卡点(全局参数)
			Globalpar globalpar = new Globalpar();
			globalpar.setGlobalparcode("jdzkd");
			List list = CacheManager.getCacheGlobalpar(globalpar);
			if(list!=null&&list.size()>0)
				jdzkd = ((Globalpar)list.get(0)).getGlobalparvalue();
	        for(int i=0;i<lWgcyryxx.size();i++){
	        	Wgcyryxx oneWgcyryxx=(Wgcyryxx)lWgcyryxx.get(i);
	        	String xm=oneWgcyryxx.getXm()+"<input type='hidden' id='qyid' value='"+oneWgcyryxx.getQyid()+"'>";
	        	String slid = String.valueOf(oneWgcyryxx.getIckslid());
	        	String sjscbz = oneWgcyryxx.getSjscbz();
	        	String zkztbs = oneWgcyryxx.getZkztbs();
	        	String cyryzt = oneWgcyryxx.getZt();
	        	if(slid==null)slid="";
	        	if(sjscbz==null)sjscbz="";
	        	if(zkztbs==null)zkztbs="";
	        	if(cyryzt==null)cyryzt="";
	        	oneWgcyryxx.setXm(oneWgcyryxx.getXm()+"<input type='hidden' id='qyid' value='"+oneWgcyryxx.getQyid()+"'>");
	        	oneWgcyryxx.setCyrybh("<input type='hidden' name='cs"+oneWgcyryxx.getRyid()+"' value='"+oneWgcyryxx.getQyid()+"' />" +
	        			"<input type='hidden' name='sl"+oneWgcyryxx.getRyid()+"' value='"+slid+"' />" +
	        					"<input type='hidden' name='zkzt"+oneWgcyryxx.getRyid()+"' value='"+zkztbs+"' />" +
	        							"<input type='hidden' name='ryzt"+oneWgcyryxx.getRyid()+"' value='"+cyryzt+"' />" +
	        							"<input type='hidden' name='wbzk"+oneWgcyryxx.getRyid()+"' value='"+sjscbz+"' />"+
	        							"<input type='hidden' name='zkd"+oneWgcyryxx.getRyid()+"' value='"+jdzkd+"' />"+oneWgcyryxx.getCyrybh());
	        	oneWgcyryxx.setXm(xm);
	        }
	        dictFanYi(page.getData());
        }
        setTabledata(lWgcyryxx); 
		 this.result="success";
        return "success";
    }
	public String querylistGad() throws Exception{
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Map map = new HashMap();
        map=addMap(wgcyryxx);
        Page page = wgcyryxxService.getListGadForPage(map, pagesize, pagerow,sort,dir);
        myPageSize = pagesize;
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
       
        dictFanYi(page.getData());
//        for(Iterator iter=lWgcyryxx.iterator();iter.hasNext();){
//        	Wgcyryxx oneWgcyryxx=(Wgcyryxx)iter.next();
//        	setCyryxxDict_itemList(oneWgcyryxx);
//        }
        lWgcyryxx=page.getData();
        setTabledataGad(lWgcyryxx); 
		 this.result="success";
        return "success";
    }
	
	/**
	 * 公安端 人员管理查询 2010-2-23 yb
	 * @return
	 * @throws Exception
	 */
	public String querylistGadGl() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			setWgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
			String gxdwbmTemp = setWgcyryxx.getGxdwbm();
			String gxdwbm = user.getDepartment().getDepartcode();
			gxdwbm = (gxdwbmTemp!=null&&!"".equals(gxdwbmTemp))?gxdwbmTemp:gxdwbm;
			
			Map map = new HashMap();
			map.put("hylbdm", setWgcyryxx.getHylbdm());
			map.put("cyrybh", setWgcyryxx.getCyrybh());
			if(gxdwbm.indexOf("CJD")==0){
				map.put("lrdwbm", StringUtil.trimEven0(gxdwbm));
			}else{
				map.put("gxdwbm", StringUtil.trimEven0(gxdwbm));
			}
			map.put("qybm", setWgcyryxx.getQybm());	
			map.put("ywx", setWgcyryxx.getYwx());
			map.put("ywm", setWgcyryxx.getYwm());
			map.put("gjdm", setWgcyryxx.getGjdm());
			map.put("zjhm", setWgcyryxx.getZjhm());
			map.put("xbdm", setWgcyryxx.getXbdm());
			map.put("gwbh", setWgcyryxx.getGwbh());
			map.put("scbz", "0");
			
			Page page = wgcyryxxService.getListGadForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			dictFanYi(page.getData());
			setTabledataGadGl(page.getData()); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	//场所端外国人员查询

	public String querylistCs() throws Exception{
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
			
			Map map = new HashMap();
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			 map=addMap(wgcyryxx);
			if(map.get("qyid")!=null&&!"".equals(map.get("qyid").toString())){
		        Page page = wgcyryxxService.getListQydForPage(map, pagesize, pagerow,sort,dir);
		        totalpage=page.getTotalPages();
		        totalrows=page.getTotalRows();
		        dictFanYi(page.getData());
		        lWgcyryxx=page.getData();
		        
		        for(Iterator iter=lWgcyryxx.iterator();iter.hasNext();){
		        	Wgcyryxx oneWgcyryxx=(Wgcyryxx)iter.next();
		        	oneWgcyryxx.setXb(oneWgcyryxx.getXb()+"<input type='hidden' name='ry"+oneWgcyryxx.getRyid()+"' value='"+oneWgcyryxx.getQyid()+"'/>");
		        }
			}
	        setTabledataCs(lWgcyryxx); 
			 this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 this.result="查询失败";
			e.printStackTrace();
		}
        
        return "success";
    }	
	public void setTabledataCs(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("rzrq");
		lPro.add("zt");
		lPro.add("cyryzt");
		lPro.add("cyryztdm");
    	
    	List lModify=new ArrayList();
    	lModify.add("updateWgyryxx");
    	lModify.add("修改");
    	
    	List lTjxx=new ArrayList();
    	lTjxx.add("detailTjxx");
    	lTjxx.add("体检信息");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lTjxx);
    	
    	Wgcyryxx getWgcyryxx=new Wgcyryxx();
    	
        this.setData(getWgcyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public String querylistCsls() throws Exception{
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
			
			Map map = new HashMap();
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			 map=addMap(wgcyryxx);
			 map.put("cyrylbdm", "1");
	        Page page = qyryxx_lsxxService.getCyryxx_lsxxListQydJwForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        
	        List lCyry_lsxx = null;
	        lCyry_lsxx=page.getData();
	        for(Iterator iter=lCyry_lsxx.iterator();iter.hasNext();){
	        	Qyryxx_lsxx oneCyryxx_lsxx = (Qyryxx_lsxx)iter.next();
	        }
	        setTabledataCsls(lCyry_lsxx); 
			 this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return "success";
    }	
	public void setTabledataCsls(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("rylsid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("rzrq");
		lPro.add("cyryzt");
    	
    	Qyryxx_lsxx getCyryxx_lsxx=new Qyryxx_lsxx();
    	
        this.setData(getCyryxx_lsxx,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataGad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("zt");
		lPro.add("cyryzt");

    	List lCygj=new ArrayList();
    	lCygj.add("setWgcyryCygj");
    	lCygj.add("从业轨迹");
    	
    	List lGzrz=new ArrayList();
    	lGzrz.add("setWgcyryGzrz");
    	lGzrz.add("工作日志");
    	
    	
    	List lCol=new ArrayList();
    	lCol.add(lCygj);
    	lCol.add(lGzrz);
//    	lCol.add(lDy);
    	
    	Wgcyryxx getWgcyryxx=new Wgcyryxx();
    	
        this.setData(getWgcyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataGadGl(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("zt");
		lPro.add("cyryzt");

    	List lCygj=new ArrayList();
    	lCygj.add("updateWgcyryxx");
    	lCygj.add("修改");
    	List lGzrz=new ArrayList();
    	lGzrz.add("setDelete");
    	lGzrz.add("删除");
    	List lCol=new ArrayList();
    	lCol.add(lCygj);
    	lCol.add(lGzrz);
    	Wgcyryxx getWgcyryxx=new Wgcyryxx();
        this.setData(getWgcyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public String queryCsls() throws Exception{
		try {
			Qyryxx_lsxx setQyryxx_lsxx=new Qyryxx_lsxx();
			setQyryxx_lsxx=(Qyryxx_lsxx)this.setClass(setQyryxx_lsxx, null);
	        
			setQyryxx_lsxx=qyryxx_lsxxService.getQyryxx_lsxx(setQyryxx_lsxx);
			lWgcyryxx = new ArrayList();

	        setCyry_lsxxDict_item(setQyryxx_lsxx);
	        lWgcyryxx.add(setQyryxx_lsxx);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	/**
	 * 外国人员变更查询列表--公安端
	 * @return
	 * @throws Exception
	 */
	public void setTabledataGadBg(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("zt");
		lPro.add("cyryzt");

    	List lCygj=new ArrayList();
    	lCygj.add("seWgcyryXq");
    	lCygj.add("变更轨迹");
    	
    	List lCol=new ArrayList();
    	lCol.add(lCygj);
    	
    	Wgcyryxx getWgcyryxx=new Wgcyryxx();
    	
        this.setData(getWgcyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 外国人员变更查询--公安端
	 * @return
	 * @throws Exception
	 */
	public String querylistGadBg() throws Exception{
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
			Map map = new HashMap();
	        map=addMap(wgcyryxx);
	        Page page = wgcyryxxService.getListGadForPage(map, pagesize, pagerow,sort,dir);
	        myPageSize = pagesize;
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	       
	        dictFanYi(page.getData());

	        lWgcyryxx=page.getData();
	        setTabledataGadBg(lWgcyryxx); 
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	/**
	 * 外国人员历史查询列表--公安端
	 * @return
	 * @throws Exception
	 */
	public void setTabledataGadLs(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("rylsid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("qymc");
		lPro.add("bcsj");
		lPro.add("cyryzt");

    	List lCygj=new ArrayList();
    	lCygj.add("wgcyrylsxx_setXqInfo");
    	lCygj.add("详情");
    	
    	List lCol=new ArrayList();
    	lCol.add(lCygj);
    	
    	Qyryxx_lsxx getCyryxx_lsxx=new Qyryxx_lsxx();
    	
        this.setData(getCyryxx_lsxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 外国人员历史查询--公安端
	 * @return
	 * @throws Exception
	 */
	public String querylistGadLs() throws Exception{
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			setWgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
			Map map = new HashMap();
			map.put("ryid", setWgcyryxx.getRyid());
			map.put("bcsjf", setWgcyryxx.getBcsj());
			map.put("bcsjt", setWgcyryxx.getBcsjt());
			//根据登陆用户 设置查询条件  只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
			map.put("deptCode", depertCode0);;
	        Page page = qyryxx_lsxxService.getCyryxx_lsxxListGadJwForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();

	        lWgcyryxx=page.getData();
	        setTabledataGadLs(lWgcyryxx); 
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	private void setCyry_lsxxDict_item(Qyryxx_lsxx data){
		String displayName;
		Dict_item dict_item = new Dict_item();
		if(data.getZt()!=null){
			displayName = "";
			dict_item.setDict_code("dm_jlzt");
			dict_item.setFact_value(data.getZt());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZt(displayName);
		}
		if(data.getHyzk()!=null){
			displayName = "";
			dict_item.setDict_code("dm_hyzk");
			dict_item.setFact_value(data.getHyzk());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setHyzk(displayName);
		}
		if(data.getZxyy()!=null){
			displayName = "";
			dict_item.setDict_code("dm_zxyy(cyry)");
			dict_item.setFact_value(data.getZxyy());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setZxyy(displayName);
		}
		if(data.getQzzldm()!=null){
			displayName = "";
			dict_item.setDict_code("dm_qzzl(lgy)");
			dict_item.setFact_value(data.getQzzldm());
			List list = CacheManager.getCacheDictitem(dict_item);
			if(list!=null&&list.size()>0)
				displayName = ((Dict_item)list.get(0)).getDisplay_name();
			data.setQzzldm(displayName);
		}
		
	}
	//注销查询
	public String querylistGadzx() throws Exception{
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Map map = new HashMap();
        map=addMap(wgcyryxx);
        map.put("scbz", "0");//设置删除标志(1:已删除人员信息)
        map.put("loselizhi", "yes");
        Page page = wgcyryxxService.getListGadForPage(map, pagesize, pagerow,sort,dir);
        myPageSize = pagesize;
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lWgcyryxx=page.getData();

        for(Iterator iter=lWgcyryxx.iterator();iter.hasNext();){
        	Wgcyryxx oneWgcyryxx=(Wgcyryxx)iter.next();
        	setCyryxxDict_itemList(oneWgcyryxx,false);
        }
        setTabledataGadzx(lWgcyryxx); 
		 this.result="success";
        return "success";
    }
	public String querylistGadsc() throws Exception{
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Map map = new HashMap();
        map=addMap(wgcyryxx);
        map.put("scbz", "1");
       
        Page page = wgcyryxxService.getScListGadForPage(map, pagesize, pagerow,sort,dir);
        myPageSize = pagesize;
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lWgcyryxx=page.getData();

        for(Iterator iter=lWgcyryxx.iterator();iter.hasNext();){
        	Wgcyryxx oneWgcyryxx=(Wgcyryxx)iter.next();
        	setCyryxxDict_itemList(oneWgcyryxx,true);
        }
        
        setTabledataGadsc(lWgcyryxx); 
		 this.result="success";
        return "success";
    }
	/**人员信息状态改变（从数字转换为汉字，友好显示列表信息）*/
	public void setCyryxxDict_itemList(Wgcyryxx data,boolean flag){
		String displayName;
		Dict_item dict_item = new Dict_item();
//		if(data.getCyryzt()!=null){
//			displayName = "";
//			dict_item.setDict_code("dm_jlzt");
//			dict_item.setFact_value(data.getCyryzt());
//			List list = CacheManager.getCacheDictitem(dict_item);
//			if(list!=null&&list.size()>0)
//				displayName = ((Dict_item)list.get(0)).getDisplay_name();
//			data.setCyryzt(displayName);
//		}
		if(flag){
			if(data.getZxbz()!=null){
				displayName = "";
				dict_item.setDict_code("dm_cszt");
				dict_item.setFact_value(data.getZxbz());
				List list = CacheManager.getCacheDictitem(dict_item);
				if(list!=null&&list.size()>0)
					displayName = ((Dict_item)list.get(0)).getDisplay_name();
				data.setZxbz(displayName);
			}
		}
		
		if(data.getZt()!=null){
			displayName = "";
			dict_item.setDict_code("dm_jlzt");
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
	public String query() throws Exception{
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
			 wgcyryxx=wgcyryxxService.getWgcyryxx(wgcyryxx);
			 setCyryxxDict_itemList(wgcyryxx,true);
			 //lWgcyryxx.clear();//刘峰注释
		        lWgcyryxx.add(wgcyryxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       
		this.result="success";
        return "success";
    }
	public String modifyZxhf() throws Exception{
		try {
			Wgcyryxx setWgcyryxx = new Wgcyryxx();
			wgcyryxx = (Wgcyryxx)this.setClass(setWgcyryxx, null);
			wgcyryxx = wgcyryxxService.getWgcyryxx(wgcyryxx);
			
	        javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			wgcyryxx.setCzr(user.getUseraccount());
			
	        qyryxxService.updateQyryxxZxhf(wgcyryxx);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "success";
	}
	public String modifyZx() throws Exception{
		try {
			Wgcyryxx setWgcyryxx = new Wgcyryxx();
			wgcyryxx = (Wgcyryxx)this.setClass(setWgcyryxx, null);
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			wgcyryxx.setZxr(user.getUseraccount());
	        qyryxxService.updateQyryxxZx(wgcyryxx);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "success";
	}
	public String insert() throws Exception{
		try {
			Qyryxx setQyryxx = new Qyryxx();
			setQyryxx = (Qyryxx)this.setClass(setQyryxx, null);
			
	        List isCyryExist = qyryxxService.getIsQyryxxExist(setQyryxx);
	        if(isCyryExist!=null && isCyryExist.size()>0){
		        this.result="证件号码已存在";
		        return "success";
	        }
	        
//			Cyry_zp cyry_zp = new Cyry_zp();
//			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
//			if(cyryxx.getFileload()!=null){
//				byte []by = base64Decoder.decodeBuffer(cyryxx.getFileload());
//				cyry_zp.setTpnr(by);
//			}
//			cyryxx.setCyry_zp(cyry_zp);
			setQyryxx.setCyrylbdm("1");
			setQyryxx.setCyrylbmc("境外从业人员");
			setQyryxx=findQyid(setQyryxx);
			setQyryxx.setCyryztdm("10");
			setQyryxx.setCyryzt(findqycyryzt("10"));
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
			wgcyryxx.setQyid(setQyryxx.getQyid());
			setQyryxx.setWgcyryxx(wgcyryxx);
			setQyryxx=fzQyryxx_zp(setQyryxx);
			qyryxxService.insertQyryxx(setQyryxx);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
	        this.result="修改失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyryxx setQyryxx = new Qyryxx();
			setQyryxx = (Qyryxx)this.setClass(setQyryxx, null);
			
//	        List isCyryExist = cyryxxService.getIsCyryExist(setCyryxx);
//	        if(isCyryExist!=null && isCyryExist.size()>0){
//		        this.result="证件号码已存在";
//		        return "success";
//	        }
	        
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
			setQyryxx.setWgcyryxx(wgcyryxx);
			setQyryxx=fzQyryxx_zp(setQyryxx);
			qyryxxService.updateQyryxx(setQyryxx);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
	        this.result="修改失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	/**
	 * 公安端 人员管理添加 2010-2-23 yb
	 * @return
	 * @throws Exception
	 */
	public String insertGad() throws Exception{
		try {
			Qyryxx setQyryxx = new Qyryxx();
			setQyryxx = (Qyryxx)this.setClass(setQyryxx, null);
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			setWgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
			
	        List isCyryExist = qyryxxService.getIsQyryxxExist(setQyryxx);
	        if(isCyryExist!=null && isCyryExist.size()>0){
		        this.result="证件号码已存在";
		        return "success";
	        }
	        
	        Qyjbxx qyjbxx =new Qyjbxx();
			qyjbxx.setQybm(setQyryxx.getQybm());
			qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
			setQyryxx.setQyid(qyjbxx.getQyid());
			setQyryxx.setHylb(qyjbxx.getHylb());
			setQyryxx.setHylbdm(qyjbxx.getHylbdm());
			setQyryxx.setLrdwbm(qyjbxx.getQybm());
			setQyryxx.setLrdwmc(qyjbxx.getQymc());
	        
			setQyryxx.setCyrylbdm("1");
			setQyryxx.setCyrylbmc("境外从业人员");
			setQyryxx=findQyid(setQyryxx);
			setQyryxx.setCyryztdm("10");
			setQyryxx.setCyryzt(findqycyryzt("10"));
			
			setWgcyryxx.setQyid(setQyryxx.getQyid());
			setQyryxx.setWgcyryxx(setWgcyryxx);
			setQyryxx=fzQyryxx_zp(setQyryxx);
			qyryxxService.insertQyryxx(setQyryxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="修改失败";
		}
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wgcyryxxService.deleteWgcyryxx(wgcyryxx);
        this.result="success";
        return "success";
    }
	public Qyryxx fzQyryxx_zp(Qyryxx setQyryxx){
		Qyry_zp zp=null;
		sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
		
		try {
			if(setQyryxx.getFileload()!=null&&!"".equals(setQyryxx.getFileload())){
				byte[] by;
				by = base64Decoder.decodeBuffer(setQyryxx.getFileload());
				zp=new Qyry_zp();
				zp.setTpnr(by);
				setQyryxx.setQyry_zp(zp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return setQyryxx;
	}
	private Qyryxx findQyid(Qyryxx setQyryxx){
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
	    int qyid=0;
	    String usercount="";
	    Qyjbxx qyjbxx =new Qyjbxx();
	    if(user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm()))
	    {
	    	usercount=user.getSsdwbm();
	    	qyjbxx.setQybm(usercount);
	 	    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
	    }else{
	    	qyjbxx=null;
	    }
	   
		if(qyjbxx!=null){
			setQyryxx.setQyid(qyjbxx.getQyid());
			setQyryxx.setHylb(qyjbxx.getHylb());
			setQyryxx.setHylbdm(qyjbxx.getHylbdm());
			setQyryxx.setLrdwbm(qyjbxx.getQybm());
			setQyryxx.setLrdwmc(qyjbxx.getQymc());
		}else{
			//String name=user.getUsername();
			//setQyryxx.setCzr(name);
			setQyryxx.setLrdwbm(user.getDepartment().getDepartcode());
			setQyryxx.setLrdwmc(user.getDepartment().getDepartname());
		}
		setQyryxx.setLrr(user.getUseraccount());
		return setQyryxx;
	}
	 /**
	 * 翻译字典项




	 */
	public void dictFanYi(List queryList){
		String displayName;
		if(queryList!=null&&queryList.size()>0){
			Map jlztMap = new HashMap();
			Dict_item dict_item = new Dict_item();
			dict_item.setDict_code("dm_jlzt");
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
				Qyryxx temp = (Qyryxx)queryList.get(index);
				jlztMap.get(temp.getZt());
				temp.setZt((String)jlztMap.get(temp.getZt()));
			}
		}
	}
	public void excelCreate() throws Exception{
		List lResult=this.getExcelResponse();
		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		
		Wgcyryxx setWgcyryxx=new Wgcyryxx();
		wgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);Map map = new HashMap();
		
		javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
        if(wgcyryxx!=null){
        	map=addMap(setWgcyryxx);

        }
        Page page = wgcyryxxService.getListForPage(map, 1, Integer.parseInt(maxRows),sort,dir);
        dictFanYi(page.getData());
        lWgcyryxx=page.getData();
		dealExcelData(lWgcyryxx,lResult);
		this.result="ok";
	}

	private void dealExcelData(List data,List lResult) {
		List lPro = new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("qymc");
		lPro.add("gwmc");
		lPro.add("zt");
		lPro.add("cyryzt");

		Qyryxx getQyryxx=new Qyryxx();
		List lcache = new ArrayList();
		//List lcache2 = this.getDictItemCacheList("cyryzt","dm_jlzt","0");
		
		//lcache.add(lcache2);
		
		data=this.getResultCache(getQyryxx.getClass().getName(), lPro, data, lcache);
		
        lResult.add(data);
        lResult.add(getQyryxx);
        try {
			this.setExcelCreate("cyryxx",lResult);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/**
	 * 公安端 场所查询
	 * @return
	 * @throws Exception
	 */
	public String querylistGadCscx() throws Exception{
		try {
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
			setWgcyryxx=(Wgcyryxx)this.setClass(setWgcyryxx, null);
			Map map = new HashMap();
			map.put("qyid", setWgcyryxx.getQyid());
	        map.put("qybm", setWgcyryxx.getQybm());
	        map.put("scbz","0");
	        map.put("zxbz","0");
			Page page = wgcyryxxService.getCyryxxListByCsidForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledataGadCscx(page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result="success";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	/**
	 * 公安端 场所查询
	 * @return
	 * @throws Exception
	 */
	public void setTabledataGadCscx(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("cylb");

    	List lCygj=new ArrayList();
    	lCygj.add("set_CscxWgCygj");
    	lCygj.add("从业轨迹");
    	
    	List lGzrz=new ArrayList();
    	lGzrz.add("set_CscxWgGzrz");
    	lGzrz.add("工作日志");
    	
    	List lCol=new ArrayList();
    	lCol.add(lCygj);
    	lCol.add(lGzrz);
    	
    	Wgcyryxx getWgcyryxx=new Wgcyryxx();
    	
        this.setData(getWgcyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public Map addMap(Wgcyryxx setWgcyryxx){
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
		String usercount="";
	    Qyjbxx qyjbxx =new Qyjbxx();
	    if(user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm()))
	    {
	    	usercount=user.getSsdwbm();
	    	qyjbxx.setQybm(usercount);
		    qyjbxx=qyjbxxService.getQyjbxx(qyjbxx);
	    } 
	    
		Map map=new HashMap();
		if(setWgcyryxx!=null){
			map.put("ywx", setWgcyryxx.getYwx());
			map.put("ywm", setWgcyryxx.getYwm());
			map.put("gjdm", setWgcyryxx.getGjdm());
			map.put("xm", setWgcyryxx.getXm());
        	map.put("zjhm", setWgcyryxx.getZjhm());
        	map.put("cyryztdm", setWgcyryxx.getCyryztdm());
        	map.put("xbdm", setWgcyryxx.getXbdm());
        	map.put("cyrybh", setWgcyryxx.getCyrybh());
        	map.put("cyrylbdm", setWgcyryxx.getCyrylbdm());
        	if(setWgcyryxx.getCylbdm()!=null&&!"".equals(setWgcyryxx.getCylbdm())){
        		map.put("cylbdm", StringUtil.trim0(setWgcyryxx.getCylbdm()));
        	}
        	map.put("cyryzt", setWgcyryxx.getCyryzt());
        	map.put("gwbh", setWgcyryxx.getGwbh());
        	map.put("qybm", setWgcyryxx.getQybm());
        	map.put("zt", setWgcyryxx.getZt());
        	map.put("cyrybh", setWgcyryxx.getCyrybh());
        	map.put("hylbdm", setWgcyryxx.getHylbdm());
        	map.put("hjdxzqhdm", setWgcyryxx.getHjdxzqhdm());
        	map.put("csrq", setWgcyryxx.getCsrq());
        	map.put("zxbz", setWgcyryxx.getZxbz());
        	map.put("isTongyin", setWgcyryxx.getSfty());
        	map.put("isZhaopianExist", setWgcyryxx.getSfyzp());
        	map.put("nianlingF", setWgcyryxx.getNianlingF());
        	map.put("nianlingT", setWgcyryxx.getNianlingT());
        	map.put("isZhaopianExist", setWgcyryxx.getSfyzp());
        	if(setWgcyryxx.getXm()!=null&&!"".equals(setWgcyryxx.getXm())){
        		map.put("xmpy", PinYinUtil.getHanyuPingYin(setWgcyryxx.getXm()));
        	}
        	if(setWgcyryxx.getGxdwbm()!=null&&!"".equals(setWgcyryxx.getGxdwbm())){
        		map.put("gxdwbm", StringUtil.trimEven0(setWgcyryxx.getGxdwbm()));
        	}else{
        		map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
        	}
        	if(qyjbxx!=null){
        		map.put("qyid", qyjbxx.getQyid());
        		map.put("qybm", qyjbxx.getQybm());
        	}
		}
		return map;
	}
	public String findqycyryzt(String dm){//根据代码找从业人员状态

		Map jlztMap = new HashMap();
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code("dm_cyryzt(yly)");
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
		return (String)jlztMap.get(dm);
	}
	public String querylistforgad() throws Exception{
		try{
			Wgcyryxx setWgcyryxx=new Wgcyryxx();
	        Map map = new HashMap();
	        setWgcyryxx = (Wgcyryxx)this.setClass(setWgcyryxx, null);
			map.put("qyid", setWgcyryxx.getQyid());
	    	Page page = wgcyryxxService.getListForPage(map, pagesize, pagerow,sort,"DESC");
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lWgcyryxx=page.getData();
	        translateDictZT();
	        setTabledata_gad(lWgcyryxx);
			 this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="";
		}
        return "success";
    }
	public void setTabledata_gad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("cyrybh");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("zhiwu");
		lPro.add("qymc");
		lPro.add("zzzhm");
		lPro.add("cyryzt");

    	List lCol=new ArrayList();
    	
    	Wgcyryxx setJxcyryxx=new Wgcyryxx();
    	
        this.setData(setJxcyryxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 翻译字典项
	 */
	public void translateDictZT(){
		if(lWgcyryxx!=null&&lWgcyryxx.size()>0){
			for(int index=0,max=lWgcyryxx.size();index<max;index++){
				Wgcyryxx tempJxcyryxx = (Wgcyryxx)lWgcyryxx.get(index);
				Dict_item dict_item = this.getCacheDictItem("dm_ryzt(jxy)", tempJxcyryxx
						.getCyryzt(), null, null, null);
				if (dict_item != null){
					tempJxcyryxx.setCyryzt(dict_item.getDisplay_name());
					lWgcyryxx.set(index, tempJxcyryxx);
				}
			}
		}
	}
	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}

	public void setQyryxx_lsxxService(IQyryxx_lsxxService qyryxx_lsxxService) {
		this.qyryxx_lsxxService = qyryxx_lsxxService;
	}
}