package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.ImageUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Wldj;
import com.aisino2.icksystem.service.IIckslService;
import com.aisino2.icksystem.service.IWldjService;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Wgcyryxx;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyry_zpService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IWgcyryxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDict_itemService;

public class WldjAction extends PageAction{
	private IWldjService wldjService;
	private IQyryxxService qyryxxService; //从业人员
	private IQyjbxxService qyjbxxService; //娱乐场所
	private IIckslService ickslService; //IC卡
	private IWgcyryxxService wgcyryxxService; //外国从业人员
	private IQyry_zpService cyry_zpService; //从业人员照片
	private IDict_itemService dict_itemService;
	private List lWldj;
	private Wldj wldj;
	private String tabledata;
	private int totalrows;
	private String result="";
	private Qyryxx qyryxx;
	
	private List exitIckslList;
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Wldj getWldj() {
		return wldj;
	}
	
	public List getLWldj() {
		return lWldj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setWldjService(IWldjService wldjService) {
		this.wldjService = wldjService;
	}
	
	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}

	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}

	public void setIckslService(IIckslService ickslService) {
		this.ickslService = ickslService;
	}

	public void setWgqyryxxService(IWgcyryxxService wgcyryxxService) {
		this.wgcyryxxService = wgcyryxxService;
	}

	public void setQyry_zpService(IQyry_zpService cyry_zpService) {
		this.cyry_zpService = cyry_zpService;
	}

	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}

	public Qyryxx getQyryxx() {
		return qyryxx;
	}

	public void setQyryxx(Qyryxx qyryxx) {
		this.qyryxx = qyryxx;
	}

	public List getExitIckslList() {
		return exitIckslList;
	}

	public void setExitIckslList(List exitIckslList) {
		this.exitIckslList = exitIckslList;
	}

	public void setTabledata(List lData) throws Exception{
		tabledata = "";
		List lPro=new ArrayList();
		lPro.add("wlid");
		lPro.add("wlpc");
		lPro.add("djr");
		lPro.add("zbsj");
		lPro.add("fssj");
		lPro.add("bnksl");
		lPro.add("ztdmmc");
		lPro.add("jsr");
		lPro.add("jssj");
		lPro.add("fksj");
		
		List lXzcz=new ArrayList();
    	List lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("查看");
    	lCk.add("ztdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("查看");
    	lCk.add("ztdm");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("查看");
    	lCk.add("ztdm");
    	lCk.add("2");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("查看");
    	lCk.add("ztdm");
    	lCk.add("3");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("查看");
    	lCk.add("ztdm");
    	lCk.add("4");
    	lXzcz.add(lCk);
    	
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("接收");
    	lCk.add("ztdm");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("接收");
    	lCk.add("ztdm");
    	lCk.add("2");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("接收");
    	lCk.add("ztdm");
    	lCk.add("4");
    	lXzcz.add(lCk);
    	
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("反馈");
    	lCk.add("ztdm");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("反馈");
    	lCk.add("ztdm");
    	lCk.add("2");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("反馈");
    	lCk.add("ztdm");
    	lCk.add("3");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("反馈");
    	lCk.add("ztdm");
    	lCk.add("4");
    	lXzcz.add(lCk);
    	
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("打印");
    	lCk.add("ztdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("打印");
    	lCk.add("ztdm");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("打印");
    	lCk.add("ztdm");
    	lCk.add("2");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("打印");
    	lCk.add("ztdm");
    	lCk.add("3");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("打印");
    	lCk.add("ztdm");
    	lCk.add("4");
    	lXzcz.add(lCk);
    	
    	Wldj getWldj=new Wldj();
    	this.setDataCustomer(getWldj,lData,lPro,null,lXzcz);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public void setTabledataBaoKa(List lData) throws Exception{
		tabledata = "";
		List lPro=new ArrayList();
		lPro.add("ryid");
		lPro.add("kh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("csrq");
		lPro.add("hjdxzqh");
		//lPro.add("zkztbs");
		lPro.add("zkztmc");
		
    	List lCol=new ArrayList();
    	Icksl setIcksl=new Icksl();
    	
        this.setData(setIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 物流组包
	 * @param lData
	 * @throws Exception
	 */
	public void setTabledataWlzb(List lData) throws Exception{
		tabledata = "";
		List lPro=new ArrayList();
		lPro.add("wlid");
		lPro.add("wlpc");
		lPro.add("djr");
		lPro.add("zbsj");
		lPro.add("fssj");
		lPro.add("bnksl");
		lPro.add("mbsldmc");
		lPro.add("ztdmmc");
		lPro.add("jsr");
		lPro.add("jssj");
		
		List lXzcz=new ArrayList();
    	List lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("查看");
    	lCk.add("ztdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("查看");
    	lCk.add("ztdm");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("查看");
    	lCk.add("ztdm");
    	lCk.add("2");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("查看");
    	lCk.add("ztdm");
    	lCk.add("3");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("查看");
    	lCk.add("ztdm");
    	lCk.add("4");
    	lXzcz.add(lCk);
    	
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("修改");
    	lCk.add("ztdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("删除");
    	lCk.add("ztdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("wldj");
    	lCk.add("发送");
    	lCk.add("ztdm");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	
    	Wldj getWldj=new Wldj();
    	this.setDataCustomer(getWldj,lData,lPro,null,lXzcz);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 物流组包 包内卡信息
	 * @param lData
	 * @throws Exception
	 */
	public void setTabledataWlzbBk(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("cyrybh");
		lPro.add("kh");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("zjhm");
		lPro.add("csrq");
		lPro.add("hjdxz");
		lPro.add("zkztmc");
		
    	List lCol=new ArrayList();
    	Icksl setIcksl=new Icksl();
    	
        this.setData(setIcksl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        try {
        	HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			Icksl setIcksl=new Icksl(); //IC卡
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			
			Map map = new HashMap();
			map.put("allhylbdm", setWldj.getHylbdm());
			map.put("deptCode", user.getDepartment().getDepartcode());
			map.put("wlpc", setWldj.getWlpc());
			map.put("jsr", setWldj.getJsr());
			map.put("ztdm", setWldj.getZtdm());
			
			map.put("kh", setIcksl.getKh());
			map.put("zjhm", setIcksl.getZjhm());
			map.put("cyzjdm", setIcksl.getCyzjdm());
			
			map.put("xm", setIcksl.getXm());
			map.put("jssjf", setWldj.getJssj());
			map.put("jssjt", setWldj.getJssjt());
			map.put("forCjd", "0");
			
			map.put("superbWhere", setWldj.getSuperbWhere()); //高级查询
			map.put("superbOrderBy", setWldj.getSuperbOrderBy()); //高级查询
			
			Date jssjf = setWldj.getJssj();
			Date jssjt = setWldj.getJssjt();
			
			if(isUseString(setIcksl.getKh())||isUseString(setIcksl.getZjhm())
					||isUseString(setIcksl.getHylbdm())
					||isUseString(setIcksl.getCyzjdm())||isUseString(setIcksl.getXm())){
				map.put("joinCyryxxAndIcksl", "1");
			}
			
			Page page = wldjService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lWldj=page.getData();
			setTabledata(lWldj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="success";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	/**
	 * 物流组包 请求列表
	 * @return
	 * @throws Exception
	 */
	public String querylistWlzb() throws Exception{
        try {
        	HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			Icksl setIcksl=new Icksl(); //IC卡
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			
			Map map = new HashMap();
			map.put("allhylbdm", setWldj.getHylbdm());
			map.put("wlpc", setWldj.getWlpc());
			map.put("jsr", setWldj.getJsr());
			map.put("ztdm", setWldj.getZtdm());
			
			map.put("kh", setIcksl.getKh());
			map.put("zjhm", setIcksl.getZjhm());
			map.put("cyzjdm", setIcksl.getCyzjdm());
			
			map.put("xm", setIcksl.getXm());
			map.put("jssjf", setWldj.getJssj());
			map.put("jssjt", setWldj.getJssjt());
			Date jssjf = setWldj.getJssj();
			Date jssjt = setWldj.getJssjt();
			
			if(isUseString(setIcksl.getKh())||isUseString(setIcksl.getZjhm())
					||isUseString(setIcksl.getHylbdm())
					||isUseString(setIcksl.getCyzjdm())||isUseString(setIcksl.getXm())){
				map.put("joinCyryxxAndIcksl", "1");
			}
			
			Page page = wldjService.getListZkdForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lWldj=page.getData();
			setTabledataWlzb(lWldj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="success";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	/**
	 * 物流组包
	 * @param lData
	 * @throws Exception
	 */
	public void setTabledataTzWlzb(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("wlid");
		lPro.add("wlpc");
		lPro.add("fssj");
		lPro.add("bnksl");
		lPro.add("mbsldmc");
		lPro.add("ztdmmc");
		lPro.add("jssj");
    	
    	Wldj getWldj=new Wldj();
    	this.setData(getWldj,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 物流组包 请求列表
	 * @return
	 * @throws Exception
	 */
	public String querylistTzWlzb() throws Exception{
        try {
			Map map = new HashMap();
			
			Page page = wldjService.getListZkdTzForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lWldj=page.getData();
			setTabledataTzWlzb(lWldj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	/**
	 * 包内卡信息列表 --- 物流组包修改
	 * @return
	 */
	public String querylistUpwlzb(){
		try {
			Map dictTemp = new HashMap();
			dictTemp.put("", ""); dictTemp.put(null, "");
			Map dict = new HashMap();
			dict.put("dict_code","dm_zkzt");
			Page dictpage = dict_itemService.getListForPage(dict, 1, 30,sort,dir);
			List dictList = dictpage.getData();
			if(dictList!=null&&dictList.size()>0){
				for(int index=0,max=dictList.size();index<max;index++){
					Dict_item temp = (Dict_item)dictList.get(index);
					dictTemp.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			
			lWldj = new ArrayList();
			Icksl setIcksl=new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			lWldj = ickslService.getIckslByWlidListNoPage(setIcksl);
			
			List resultList = new ArrayList();
			if(lWldj!=null&&lWldj.size()>0){
				for(int indexick=0,max=lWldj.size();indexick<max;indexick++){
					Icksl temp = (Icksl)lWldj.get(indexick);
					temp.setZkztmc((String)dictTemp.get(temp.getWlbzkztbs()));
					resultList.add(temp);
				}
			}
			setTabledataWlzbBk(resultList);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 判断是否可以反馈
	 * @return
	 */
	public String isCanFankui(){
		try {
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			setWldj=wldjService.getWldj(setWldj);
			if("0".equals(setWldj.getZtdm())){
				this.result=setWldj.getZtdmmc()+"状态下，不能进行反馈";
			} else if("1".equals(setWldj.getZtdm())){
				this.result=setWldj.getZtdmmc()+"状态下，不能进行反馈";
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result="错误，请重试";
	        return "success";
		}
	}
	
	/**
	 * 判断是否可以接收
	 * @return
	 */
	public String isCanJieShou(){
		try {
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			setWldj=wldjService.getWldj(setWldj);
			if("0".equals(setWldj.getZtdm())){
				this.result=setWldj.getZtdmmc()+"状态下，不能进行接收";
			} else if("3".equals(setWldj.getZtdm())){
				this.result=setWldj.getZtdmmc()+"状态下，不能进行接收";
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result="错误，请重试";
	        return "success";
		}
	}
	public String query() throws Exception{
		try {
			lWldj = new ArrayList();
			Wldj setWldj=new Wldj();
			wldj=(Wldj)this.setClass(setWldj, null);
			wldj=wldjService.getWldj(wldj);
			lWldj.add(wldj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
        return "success";
    }
	
	/**
	 * 制卡端 添加信息
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			if(isUseString(setWldj.getCyrybhSet())){
				setWldj.setCyrybhSet(setWldj.getCyrybhSet().substring(1, setWldj.getCyrybhSet().length()));
			}
			if(isUseString(setWldj.getKhSet())){
				setWldj.setKhSet(setWldj.getKhSet().substring(1, setWldj.getKhSet().length()));
			}
			setWldj.setDjr(user.getUseraccount());
			setWldj=wldjService.insertWldj(setWldj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	/**
	 * 制卡端 发送操作
	 * @throws Exception
	 */
	public String wlzbSend() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			setWldj.setFsr(user.getUseraccount());
			wldjService.updateWldjWlfs(setWldj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	/**
	 * 制卡端 删除操作
	 * @throws Exception
	 */
	public String wlzbDell() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			setWldj.setCzr(user.getUseraccount());
			wldjService.deleteWldj(setWldj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	/**
	 * 制卡端 添加信息 首次刷卡 验证
	 * @return
	 * @throws Exception
	 */
	public String validaterFirstShua() throws Exception{
		try {
			lWldj = new ArrayList();
			Icksl setIcksl = new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			Icksl temp = ickslService.isWlzb(setIcksl);
			lWldj.add(temp);
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        
        return "success";
    }
	/**
	 * 制卡端 添加信息 非首次刷卡 验证
	 * @return
	 * @throws Exception
	 */
	public String validaterNoFirstShua() throws Exception{
		try {
			lWldj = new ArrayList();
			Icksl setIcksl = new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			String isResult = ickslService.isWlzb2(setIcksl);
			lWldj.add(isResult);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	/**
	 * 制卡端 物流组包修改
	 * @return
	 * @throws Exception
	 */
	public String modifyWlzb() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			if(isUseString(setWldj.getCyrybhSet())){
				setWldj.setCyrybhSet(setWldj.getCyrybhSet().substring(1, setWldj.getCyrybhSet().length()));
			}
			if(isUseString(setWldj.getKhSet())){
				setWldj.setKhSet(setWldj.getKhSet().substring(1, setWldj.getKhSet().length()));
			}
			setWldj.setCzr(user.getUseraccount()); //操作人
			wldjService.updateWldj(setWldj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	/**
	 * 物流反馈
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception{
		try {
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			Wldj temp = wldjService.getWldj(setWldj);
			temp.setWlgs(setWldj.getWlgs());//物流公司
			temp.setYdh(setWldj.getYdh());//运单号
			temp.setFkxx(setWldj.getFkxx());
			wldjService.updateWldjWlfk(temp);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Wldj setWldj=new Wldj();
			wldj=(Wldj)this.setClass(setWldj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wldjService.deleteWldj(wldj);
        this.result="success";
        return "success";
    }
	/**
	 * 根据IC卡卡号、从业人员编号 查询从业人员信息 --- 未用
	 * @return
	 * @throws Exception
	 */
	public String queryWljsCyry() throws Exception{
		try {
			Map dictTemp = new HashMap();
			dictTemp.put("", ""); dictTemp.put(null, "");
			Map dict = new HashMap();
			dict.put("dict_code","dm_csjlzt");
			Page dictpage = dict_itemService.getListForPage(dict, 1, 30,sort,dir);
			List dictList = dictpage.getData();
			if(dictList!=null&&dictList.size()>0){
				for(int index=0,max=dictList.size();index<max;index++){
					Dict_item temp = (Dict_item)dictList.get(index);
					dictTemp.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			
			Wldj setWldj=new Wldj();
			wldj=(Wldj)this.setClass(setWldj, null);
			
			qyryxx = new Qyryxx();
			Qyryxx setQyryxx = new Qyryxx();
			setQyryxx = (Qyryxx)this.setClass(setQyryxx, null);
			qyryxx=qyryxxService.getQyryxx(setQyryxx);
			
			if(qyryxx!=null){
				Qyjbxx setQyjbxx = new Qyjbxx(); //服务场所
				setQyjbxx.setQyid(qyryxx.getQyid());
				setQyjbxx=qyjbxxService.getQyjbxx(setQyjbxx);
				if(setQyjbxx==null) setQyjbxx = new Qyjbxx(); //不在页面判断NULL了
				qyryxx.setQybm(setQyjbxx.getQybm());
				qyryxx.setQymc(setQyjbxx.getQymc());
				
				Icksl setIcksl=new Icksl(); //IC卡
				setIcksl.setRyid(qyryxx.getRyid());
				setIcksl.setZkztbs("23"); //制卡状态表示-23
				setIcksl=ickslService.getIcksl(setIcksl);
				if(setIcksl==null) setIcksl = new Icksl(); //不在页面判断NULL了
				//qyryxx.setIcksl(setIcksl);//为了不报错，暂时注释掉 20100112 mds
				
				Wgcyryxx setWgcyryxx=new Wgcyryxx(); //外国从业人员
				setWgcyryxx.setRyid(qyryxx.getRyid());
				setWgcyryxx=wgcyryxxService.getWgcyryxx(setWgcyryxx);
				if(setWgcyryxx==null) setWgcyryxx = new Wgcyryxx(); //不在页面判断NULL了
				qyryxx.setWgcyryxx(setWgcyryxx);
				
				qyryxx.setZt((String)dictTemp.get(qyryxx.getZt())); //记录状态
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
	 * 得到从业人员照片
	 */
	public void queryCyryzpImage(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest requeset = ServletActionContext.getRequest();
		String cyrybh = requeset.getParameter("cyrybh");
		try {
			byte[] tempbyteArr = null;
			
			Qyryxx setQyryxx = new Qyryxx();
			setQyryxx.setCyrybh(cyrybh);
			setQyryxx=qyryxxService.getQyryxx(setQyryxx);
			
			if(setQyryxx!=null){
				Qyry_zp setQyry_zp=new Qyry_zp();
				setQyry_zp.setRyid(setQyryxx.getRyid());
				setQyry_zp=cyry_zpService.getQyry_zp(setQyry_zp);
				if(setQyry_zp!=null){
					tempbyteArr = setQyry_zp.getTpnr();
				}
			}
			BASE64Decoder base64Decoder = new BASE64Decoder();
			if(!(tempbyteArr!=null&&tempbyteArr.length>0)){
				tempbyteArr = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
			}
			response.setCharacterEncoding("UTF-8");
			response.setContentType("image/jpeg");
			response.getOutputStream().write(tempbyteArr);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return;
		}
		this.result="success";
	}
	/**
	 * 包内卡信息列表 --- 反馈
	 * @return
	 */
	public String querylistBaoKa(){
		try {
			Map dictTemp = new HashMap();
			dictTemp.put("", ""); dictTemp.put(null, "");
			Map dict = new HashMap();
			dict.put("dict_code","dm_zkzt");
			Page dictpage = dict_itemService.getListForPage(dict, 1, 30,sort,dir);
			List dictList = dictpage.getData();
			if(dictList!=null&&dictList.size()>0){
				for(int index=0,max=dictList.size();index<max;index++){
					Dict_item temp = (Dict_item)dictList.get(index);
					dictTemp.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}
			
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			Map map = new HashMap();
			Integer test = setWldj.getWlid();
			map.put("wlid", setWldj.getWlid());
			Page page = ickslService.getListIckslByWlidForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			List resultList = new ArrayList();
			List ickList = page.getData();
			if(ickList!=null&&ickList.size()>0){
				for(int indexick=0,max=ickList.size();indexick<max;indexick++){
					Icksl temp = (Icksl)ickList.get(indexick);
					temp.setZkztmc((String)dictTemp.get(temp.getWlbzkztbs()));
					resultList.add(temp);
				}
			}
			setTabledataBaoKa(resultList); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 读取物流包内有多少张卡
	 * @return
	 */
	public String queryWldjIckCount(){
		try {
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			Map map = new HashMap();
			map.put("wlid", setWldj.getWlid());
			Page page = ickslService.getListIckslByWlidForPage(map, 1, 1,null,null);
			totalrows=page.getTotalRows();
		} catch(Exception e){
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 根据从业人员编号、卡号和物流ID 读数据库信息 显示到物流接收下部分 前台标志为 h_
	 * @return
	 */
	public String CyrybhExistInIcksl(){
		try {
			exitIckslList = new ArrayList();
			Icksl setIcksl=new Icksl(); //IC卡
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			Wldj setWldj=new Wldj(); //IC卡
			setWldj=(Wldj)this.setClass(setWldj, null);
			
			String a = setIcksl.getCyrybh();
			String b = setIcksl.getKh();
			Integer c = setWldj.getWlid();
			
			Map map = new HashMap();
			map.put("zkztbs", "23");
			map.put("cyrybh", setIcksl.getCyrybh());
			map.put("kh", setIcksl.getKh());
			map.put("wlid", setWldj.getWlid());
			exitIckslList = ickslService.isCyrybhExistInIckslAndWldj(map);
			if(exitIckslList!=null&&exitIckslList.size()>0){
				Icksl temp = (Icksl)exitIckslList.get(0);
				
				if(temp!=null){
//					dict_item.setDict_code("dm_gj(lgy)");
//					dict_item.setFact_value(temp.getGjdm());
//					String gjFactValue = dict_itemService.getDictItemNameByDcFv(dict_item);  //国籍
//					temp.setGjdm(gjFactValue);
					Dict_item dict_item = new Dict_item();
					dict_item.setDict_code("dm_jlzt");
					dict_item.setFact_value(temp.getZt());
					List list= CacheManager.getCacheDictitem(dict_item);
					if(list!=null&&list.size()>0){
						temp.setZt(((Dict_item)list.get(0)).getDisplay_name());
					}
				}
				exitIckslList.clear();
				exitIckslList.add(temp);
			}
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 物流接收
	 * @return
	 */
	public String wldjJieShou(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			if(isUseString(setWldj.getCyrybhSet())){
				setWldj.setCyrybhSet(setWldj.getCyrybhSet().substring(1, setWldj.getCyrybhSet().length()));
			}
			if(isUseString(setWldj.getKhSet())){
				setWldj.setKhSet(setWldj.getKhSet().substring(1, setWldj.getKhSet().length()));
			}
			setWldj.setJsr(user.getUseraccount());
			wldjService.updateWldjWljs(setWldj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 物流打印 信息
	 * @return
	 */
	public String printMessage(){
		try {
			lWldj = new ArrayList();
			Icksl setIcksl = new Icksl();
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			
			List ylcsWlList = ickslService.getYlcsListInWldj(setIcksl);
			if(ylcsWlList!=null&&ylcsWlList.size()>0){
				for(int indexylcs=0,max=ylcsWlList.size();indexylcs<max;indexylcs++){
					Icksl tempIck = (Icksl)ylcsWlList.get(indexylcs);
					lWldj.add(ickslService.getCyryAndIckInWldj(tempIck));
				}
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
	 * 数据校验 前台标志为 h_
	 * @return
	 */
	public String sjjyCyry(){
		try {
			exitIckslList = new ArrayList();
			Icksl setIcksl=new Icksl(); //IC卡
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			
			setIcksl = ickslService.getDxrValidate(setIcksl);
			if(setIcksl!=null){
				exitIckslList.add(setIcksl);
			}
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 数据校验后 业务需要
	 * @return
	 */
	public String sjjyBackYwxy(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Icksl setIcksl=new Icksl(); //IC卡
			setIcksl=(Icksl)this.setClass(setIcksl, null);
			
			String backFlag = ickslService.isExistWlzbByKh(setIcksl);
			if("2".equals(backFlag)){
				if(user!=null){
					setIcksl.setCzr(user.getUseraccount());
				}
				ickslService.updateIckslWlfs(setIcksl);
			}
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	public Boolean isUseString(String value){
		if(value!=null&&!"".equals(value.trim())){
			return true;
		}
		return false;
	}

	public void setWgcyryxxService(IWgcyryxxService wgcyryxxService) {
		this.wgcyryxxService = wgcyryxxService;
	}

	public void setCyry_zpService(IQyry_zpService cyry_zpService) {
		this.cyry_zpService = cyry_zpService;
	}
	
	/**
	 * 采集端台账--已接收物流包信息
	 * @return
	 * @throws Exception
	 */
	public String queryYjswlblist() throws Exception{
        try {
        	HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Wldj setWldj=new Wldj();
			setWldj=(Wldj)this.setClass(setWldj, null);
			
			Map map = new HashMap();
			map.put("hylbdm", "J");
			map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			map.put("jssj", setWldj.getJssj());
			map.put("ztdm", "3");// 已接收物流包
			
			Page page = wldjService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lWldj=page.getData();
			setTabledata(lWldj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
}