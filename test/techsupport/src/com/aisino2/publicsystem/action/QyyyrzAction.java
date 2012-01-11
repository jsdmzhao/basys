package com.aisino2.publicsystem.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyyyrz;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IQyyyrzService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class QyyyrzAction extends PageAction{
	private IQyyyrzService qyyyrzService;
	private IQyjbxxService qyjbxxService;
	private IQyryxxService qyryxxService;
	private Qyjbxx qyjbxx=new Qyjbxx();
	
	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}

	private List lQyyyrz=new ArrayList();
	private Qyyyrz qyyyrz=new Qyyyrz();
	private String tabledata="";
	private int totalrows=0;
	private String result="success";
	private User user;
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Qyyyrz getQyyyrz() {
		return qyyyrz;
	}
	
	public List getLQyyyrz() {
		return lQyyyrz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyyyrzService(IQyyyrzService qyyyrzService) {
		this.qyyyrzService = qyyyrzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("yyrzid");
		lPro.add("riqi");
		lPro.add("ksyysj");
		lPro.add("jsyysj");
		lPro.add("csfe");
		lPro.add("sffsaj");
		lPro.add("sfglbmjc");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setQuery");
    	lDel.add("详情");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	
    	Qyyyrz getQyyyrz=new Qyyyrz();
    	
        this.setData(getQyyyrz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataBzhGad(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("yyrzid");
		lPro.add("riqi");
		lPro.add("ksyysj");
		lPro.add("jsyysj");
		lPro.add("qymc");
		lPro.add("csfe");
		lPro.add("sffsaj");
		lPro.add("sfglbmjc");
    	
    	List lCol=new ArrayList();
    	Qyyyrz getQyyyrz=new Qyyyrz();
        this.setData(getQyyyrz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setChaXunYyrzTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("zrs");
		lPro.add("qyzflmc");
		lPro.add("yyztmc");
		lPro.add("zajbmc");
    	
		List lyyrz=new ArrayList();
		lyyrz.add("ylcshc_setYyrz");
		lyyrz.add("营业日志");
    	
    	List lskjl=new ArrayList();
    	lskjl.add("ylcshc_setSkjl");
    	lskjl.add("刷卡记录");
    	
    	List lCol=new ArrayList();
    	lCol.add(lyyrz);
    	lCol.add(lskjl);
    	
    	Qyjbxx getYlcsjbxx=new Qyjbxx();
    	
        this.setData(getYlcsjbxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		user= (User)session.getAttribute(Constants.userKey);
		String qybm=user.getUseraccount();
		String userType=user.getUsertype();
		Qyyyrz setQyyyrz=new Qyyyrz();
		setQyyyrz=(Qyyyrz)this.setClass(setQyyyrz, null);
        Map map = new HashMap();
        String[] utype = userType.split(",");
        for(int i=0;i<utype.length;i++){
        if(utype[i].equals("13")||utype[i].equals("143"))
        	{
        	map.put("qyid", getQyid(qybm));
        	break;
        	}
        }
        
        map.put("qybm", setQyyyrz.getQybm());
        map.put("qymc", setQyyyrz.getQymc());
        map.put("ksyysj", setQyyyrz.getKsyysj());
    	map.put("jsyysj", setQyyyrz.getJsyysj());
    	map.put("zafzrxm", setQyyyrz.getZafzrxm());
        Page page = qyyyrzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyyyrz=page.getData();
        translateDictZT();
        setTabledata(lQyyyrz); 
		 this.result="success";
        return "success";
    }
	
	public String querylistforga() throws Exception{
		Qyyyrz setQyyyrz=new Qyyyrz();
		setQyyyrz=(Qyyyrz)this.setClass(setQyyyrz, null);
        Map map = new HashMap();
        map.put("qyid", setQyyyrz.getQyid());
        map.put("riqif", setQyyyrz.getKsyysj());
    	map.put("riqit", setQyyyrz.getJsyysj());
    	map.put("zafzrxm", setQyyyrz.getZafzrxm());
        Page page = qyyyrzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lQyyyrz=page.getData();
        translateDictZT();
        setTabledata(lQyyyrz); 
		 this.result="success";
        return "success";
    }
	
	/**
	 * 企业营业日志查询 标准化公安端
	 * @return
	 */
	public String querylistforYlybzhGad() {
		try{
			Qyyyrz setQyyyrz=new Qyyyrz();
			setQyyyrz=(Qyyyrz)this.setClass(setQyyyrz, null);
			Map map = new HashMap();
			map.put("ksyysj", setQyyyrz.getKsyysj());
			map.put("jsyysj", setQyyyrz.getJsyysj());
			map.put("zafzrxm", setQyyyrz.getZafzrxm());
			map.put("qybm", setQyyyrz.getQybm());
			map.put("qymc", setQyyyrz.getQymc());
			map.put("hylbdm", setQyyyrz.getHylbdm());
			//根据登陆用户 设置查询条件  只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
			user= (User)session.getAttribute(Constants.userKey);
			String a=setQyyyrz.getGxdwbm();
			if("".equals(setQyyyrz.getGxdwbm())||setQyyyrz.getGxdwbm()==null){
				String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
				map.put("deptCode", depertCode0);
			}
			Page page = qyyyrzService.getListForPageYlyBzhGad(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lQyyyrz=page.getData();
			translateDictZT();
			setTabledataBzhGad(lQyyyrz); 
		} catch (Exception e) {
			e.printStackTrace();
			lQyyyrz=null;
			this.result="";
		}
        return "success";
    }

	/**
	 * 场所营业日志查询 请求列表
	 * @return
	 * @throws Exception
	 */
	public String queryCsChaxunYyrzList() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Qyjbxx setqyjbxx=new Qyjbxx();
			setqyjbxx=(Qyjbxx)this.setClass(setqyjbxx, null);
			Map map = new HashMap();
			
			map.put("hylbdm", setqyjbxx.getHylbdm());
			map.put("sfyx", "1"); //是否有效
			map.put("qymc", setqyjbxx.getQymc());
			map.put("qybm", setqyjbxx.getQybm());
			map.put("qyzflbm", setqyjbxx.getQyzflbm());
			map.put("zjbh", setqyjbxx.getZjbh());
			map.put("gxdwbm", StringUtil.trimEven0(setqyjbxx.getGxdwbm())); //7.27取简项代�?
			map.put("zabdm", setqyjbxx.getZabdm());
			map.put("zrs", setqyjbxx.getZrs());
			map.put("relation", setqyjbxx.getRelation());
			map.put("yyztdm", setqyjbxx.getYyztdm());
			
			if("".equals(setqyjbxx.getGxdwbm())){
				String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
				map.put("deptCode", depertCode0);
			}
			
			Page page = qyjbxxService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			
			lQyyyrz = page.getData();
			setChaXunYyrzTabledata(lQyyyrz);
			lQyyyrz=null;
		} catch (Exception e) {
			e.printStackTrace();
			lQyyyrz=null;
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyyyrz setQyyyrz=new Qyyyrz();
			setQyyyrz=(Qyyyrz)this.setClass(setQyyyrz, null);
			qyyyrz=qyyyrzService.getQyyyrz(setQyyyrz);
		    lQyyyrz.clear();
		    lQyyyrz.add(qyyyrz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyyyrz setQyyyrz=new Qyyyrz();
			setQyyyrz=(Qyyyrz)this.setClass(setQyyyrz, null);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			if(setQyyyrz!=null){
				Date nowDate = formatter.parse(setQyyyrz.getPageSort());
				setQyyyrz.setRiqi(nowDate);
			}
			qyyyrz=qyyyrzService.insertQyyyrz(setQyyyrz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyyyrz setQyyyrz=new Qyyyrz();
			qyyyrz=(Qyyyrz)this.setClass(setQyyyrz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyyyrzService.updateQyyyrz(qyyyrz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyyyrz setQyyyrz=new Qyyyrz();
			qyyyrz=(Qyyyrz)this.setClass(setQyyyrz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyyyrzService.deleteQyyyrz(qyyyrz);
        this.result="success";
        return "success";
    }
	/*
	 * 获取企业id
	 */
	private int getQyid(String qybm){
		int qyid=0;
		try{
			Qyjbxx setQyjbxx=new Qyjbxx();
			setQyjbxx.setQybm(qybm);
			setQyjbxx=qyjbxxService.getQyjbxx(setQyjbxx);
			qyid=setQyjbxx.getQyid();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qyid;
	}
	/*
	 * 获取企业负责人信息
	 */
	public String queryfzry() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			lQyyyrz = new ArrayList();
			Qyyyrz setQyyyrz = new Qyyyrz();
			setQyyyrz.setQybm(user.getUseraccount());
			//采用独立方法查询企业负责人信息，以提高速度
			qyyyrz=qyyyrzService.getQyyyrzFzry(setQyyyrz);
			lQyyyrz.clear();
		    lQyyyrz.add(qyyyrz);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.result="success";
        return "success";
    }
	/*
	 * 字典项转�?
	 */
	public void translateDictZT(){
		if(lQyyyrz!=null&&lQyyyrz.size()>0){
			for(int index=0,max=lQyyyrz.size();index<max;index++){
				Qyyyrz tempQy = (Qyyyrz)lQyyyrz.get(index);
				Dict_item dict_item1=CacheManager.getCacheDictitemOne("dm_bez", tempQy.getSffsaj());
				Dict_item dict_item2=CacheManager.getCacheDictitemOne("dm_bez", tempQy.getSfglbmjc());
				if (dict_item1 != null){
					tempQy.setSffsaj(dict_item1.getDisplay_name());
				}
				if (dict_item2!=null){
					tempQy.setSfglbmjc(dict_item2.getDisplay_name());
				}
				lQyyyrz.set(index, tempQy);
			}
		}
	}
	
	/**
	 * 企业营业日志查询 标准化公安端台账
	 * @return
	 */
	public String querylistforYlybzhGadTz() {
		try{
			Map map = new HashMap();
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			if(user!=null){
				String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
				map.put("deptCode", depertCode0);
				Page page = qyyyrzService.getListForPageYlyBzhGad(map, 1, 50,null,"DESC");
				lQyyyrz=page.getData();
			}
		} catch (Exception e) {
			e.printStackTrace();
			lQyyyrz=null;
			this.result="";
		}
        return "success";
    }

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}

}