package com.aisino2.basicsystem.action;

import java.io.IOException;
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

import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.basicsystem.service.IBjxxbService;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class BjxxbAction extends PageAction {
	private IBjxxbService bjxxbService;
	private List lBjxxb = new ArrayList();
	private Bjxxb bjxxb = new Bjxxb();
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

	public Bjxxb getBjxxb() {
		return bjxxb;
	}

	public List getLBjxxb() {
		return lBjxxb;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setBjxxbService(IBjxxbService bjxxbService) {
		this.bjxxbService = bjxxbService;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bjxxid");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("ssqymc");
		lPro.add("gxdwmc");
		lPro.add("bjsj");
		lPro.add("bjlx");
		lPro.add("sfyxbj");
		lPro.add("jqzt");
		lPro.add("chjjg");

		List lXzcz = new ArrayList();

		List lTsclXbj = new ArrayList();
		lTsclXbj.add("");// 链接ID开头
		lTsclXbj.add("派警"); // 链接显示文字

		List lTsclHf = new ArrayList();
		lTsclHf.add("");// 链接ID开头
		lTsclHf.add("回复"); // 链接显示文字

		List lTsclCk = new ArrayList();
		lTsclCk.add("");// 链接ID开头
		lTsclCk.add("修改回复"); // 链接显示文字

		List lTsclWxbj = new ArrayList();
		lTsclWxbj.add("");// 链接ID开头
		lTsclWxbj.add("无效报警"); // 链接显示文字

		// 比对属性
		List lWhereXbj = new ArrayList(); // 新报警
		lWhereXbj.add("jqzt");

		List lWhereHf = new ArrayList(); // 回复
		lWhereHf.add("sfyxbj");
		lWhereHf.add("jqzt");
		lWhereHf.add("gxdwmc");

		List lWhereCk = new ArrayList();// 查看
		lWhereCk.add("sfyxbj");
		lWhereCk.add("jqzt");
		lWhereCk.add("gxdwmc");

		List lWhereWxbj = new ArrayList();// 无效报警
		lWhereWxbj.add("sfyxbj");

		// 比对值
		List lWhereXbjValue = new ArrayList();
		lWhereXbjValue.add("新报警");

		List lWhereHfValue = new ArrayList();
		lWhereHfValue.add("是");
		lWhereHfValue.add("未回复报警");
		lWhereHfValue.add(getUserDeptName());

		List lWhereCkValue = new ArrayList();
		lWhereCkValue.add("是");
		lWhereCkValue.add("已回复报警");
		lWhereCkValue.add(getUserDeptName());

		List lWhereWxbjValue = new ArrayList();
		lWhereWxbjValue.add("否");

		// 需要比对的属性
		lTsclXbj.add(lWhereXbj);
		lTsclHf.add(lWhereHf);
		lTsclCk.add(lWhereCk);
		lTsclWxbj.add(lWhereWxbj);

		// 需要比对的属性的值
		lTsclXbj.add(lWhereXbjValue);
		lTsclHf.add(lWhereHfValue);
		lTsclCk.add(lWhereCkValue);
		lTsclWxbj.add(lWhereWxbjValue);

		lXzcz.add(lTsclXbj);
		lXzcz.add(lTsclHf);
		lXzcz.add(lTsclCk);
		lXzcz.add(lTsclWxbj);

		Bjxxb getBjxxb = new Bjxxb();

		this.setDataCustomer(getBjxxb, lData, lPro, null, lXzcz);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public void setTabledataStats(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bjxxid");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("ssqymc");
		lPro.add("gxdwmc");
		lPro.add("bjsj");
		lPro.add("bjlx");
		lPro.add("sfyxbj");
		lPro.add("jqzt");
		lPro.add("chjjg");

		Bjxxb getBjxxb = new Bjxxb();

		this.setData(getBjxxb, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		Bjxxb setBjxxb = new Bjxxb();
		bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
		int Departlevel=user.getDepartment().getDepartlevel();

		Map map = new HashMap();
		if(Departlevel>2){
			map.put("deptCode", StringUtil.trimEven0(getUserDept(1)) + "%");
		}
		if(bjxxb.getGxdwlevel()!=null){
			if(bjxxb.getGxdwlevel()>2){
				map.put("gxdwbm", bjxxb.getGxdwbm() + "%");
			}
		}
		map.put("xm", bjxxb.getXm());
		map.put("gmsfhm", bjxxb.getGmsfhm());
		map.put("hylbdm", bjxxb.getHylbdm());
		map.put("ywlbdm", bjxxb.getYwlbdm());
		map.put("ssqymc", bjxxb.getSsqymc());
		map.put("bjsj1", bjxxb.getBjsj1());
		map.put("bjsj2", bjxxb.getBjsj2());
		map.put("cjjgdm", bjxxb.getCjjgdm());
		map.put("bjlxdm", bjxxb.getBjlxdm());
		map.put("cjbmbm", bjxxb.getCjbmbm());
		map.put("pjbmbm", bjxxb.getPjbmbm());
		map.put("jqztdm", bjxxb.getJqztdm());
		map.put("sfyxbjdm", bjxxb.getSfyxbjdm());

		Page page = bjxxbService.getListForPage(map, pagesize, pagerow, sort, dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBjxxb = page.getData();
		setTabledata(lBjxxb);
		this.result = "success";
		return "success";
	}

	public String querylistStats() throws Exception {
		Bjxxb setBjxxb = new Bjxxb();
		bjxxb = (Bjxxb) this.setClass(setBjxxb, null);

		Map map = new HashMap();
		bjxxChaXunTj(map);

		Page page = bjxxbService.getListForPage(map, pagesize, pagerow, sort, dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBjxxb = page.getData();
		setTabledataStats(lBjxxb);
		this.result = "success";
		return "success";
	}

	private void bjxxChaXunTj(Map map){		
		String selfDepartCode = getUserDept(1);
		if(selfDepartCode.length()>2){
			map.put("deptCode", selfDepartCode + "%");
		}
		map.put("xm", bjxxb.getXm());
		map.put("gmsfhm", bjxxb.getGmsfhm());
		map.put("hylbdm", bjxxb.getHylbdm());
		map.put("ywlbdm", bjxxb.getYwlbdm());
		map.put("ssqymc", bjxxb.getSsqymc());
		map.put("gxdwlevel", bjxxb.getGxdwlevel());
		String queryGxdwbm = StringUtil.trimEven0(bjxxb.getGxdwbm_full());//检索中的管辖单位简码
		if (bjxxb.getGxdwbm() != null && !bjxxb.getGxdwbm().equals("")) {
			String gxdwbm_trimEven0=StringUtil.trimEven0(bjxxb.getGxdwbm());
			Integer gxdwLevel = bjxxb.getGxdwlevel();
			int level = 100;
			if(gxdwLevel != null){
				level = gxdwLevel;
			}
			//当前查询行公安机关编码与检索中的管辖单位编码相同时只显示本级  和 叶子节点
			if(gxdwbm_trimEven0.equals(queryGxdwbm)&& "N".equals(bjxxb.getIsleaf())){
				if ("cjtj".equals(bjxxb.getState()) || ("zttj").equals(bjxxb.getState())){//在处警统计和抓逃查询中只显示本级
					map.put("gxdwbm", bjxxb.getGxdwbm_full());
				}else{
					map.put("gxdwbm_full", bjxxb.getGxdwbm_full());
					if(level>=3){//为显示80单位而加
						map.put("gxdwbm", queryGxdwbm + "%");
					}
				}				
			}else{//当前查询行公安机关编码与检索中的管辖单位编码不同时显示本级及下级
			    map.put("gxdwbm", gxdwbm_trimEven0+ "%");
			}
		}else{//选择"合计"链接,按照检索条件查询，显示本级和下级
			Integer gxdwLevel = bjxxb.getGxdwlevel();
			int level = 100;
			if(gxdwLevel != null){
				level = gxdwLevel;
			}
			if(level>=3){//为显示80单位而加
				map.put("gxdwbm", queryGxdwbm + "%");

			}
			if ("cjtj".equals(bjxxb.getState()) || ("zttj").equals(bjxxb.getState())){//在处警统计和抓逃查询中
				Globalpar gcj = this.getCacheGlobalpar("CjtjStasLevel");
				String CjtjStasLevel; // 处警统计下属级数
				CjtjStasLevel = gcj.getGlobalparvalue();
				if ("1".equals(CjtjStasLevel))//处警统计下属级数为1时只显示下级，否则本级和下级
				{
					if (("Y").equals(bjxxb.getIsleaf()))//叶子节点只显示本级
					{
						map.put("gxdwlevel_cjzt", bjxxb.getGxdwlevel());
					}
					else//非叶子节点显示下级
					{
						map.put("gxdwlevel_cjzt", bjxxb.getGxdwlevel() + Integer.parseInt(CjtjStasLevel));
					}
				}
				Globalpar gzt = this.getCacheGlobalpar("ZTXXStasLevel");
				String ZTXXStasLevel; // 抓逃统计下属级数
				ZTXXStasLevel = gzt.getGlobalparvalue();
				if ("1".equals(ZTXXStasLevel))//抓逃统计下属级数为1时只显示下级，否则本级和下级
				{
					if (("Y").equals(bjxxb.getIsleaf()))//叶子节点只显示本级
					{
						map.put("gxdwlevel_cjzt", bjxxb.getGxdwlevel());
					}
					else//非叶子节点显示下级
					{
						map.put("gxdwlevel_cjzt", bjxxb.getGxdwlevel() + Integer.parseInt(ZTXXStasLevel));
					}
				}
			}					
		}
		map.put("bjsj1", bjxxb.getBjsj1());
		map.put("bjsj2", bjxxb.getBjsj2());
		map.put("zhsj1", bjxxb.getZhsj1());
		map.put("zhsj2", bjxxb.getZhsj2());
		map.put("cjjgdm", bjxxb.getCjjgdm());
		map.put("bjlxdm", bjxxb.getBjlxdm());
		map.put("cjbmbm", bjxxb.getCjbmbm());
		map.put("pjbmbm", bjxxb.getPjbmbm());
		map.put("jqztdm", bjxxb.getJqztdm());
		map.put("sfyxbjdm", bjxxb.getSfyxbjdm());
		map.put("tjlx", bjxxb.getTjlx());
	    map.put("sfpj", bjxxb.getSfpj());//新派警以外数据
	}

	public String query() throws Exception {
		try {
			Bjxxb setBjxxb = new Bjxxb();
			bjxxb = new Bjxxb();
			bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjxxb = bjxxbService.getBjxxb(bjxxb);

		// 接处警基本情况
		if (bjxxb.getSfyxbj() != null && bjxxb.getSfyxbj() != "") // 是否确认报警
			bjxxb.setShow_sfqrbj("是");
		else
			bjxxb.setShow_sfqrbj("否");

		if (bjxxb.getChjsj() != null) // 是否处警
			bjxxb.setShow_sfcj("是");
		else
			bjxxb.setShow_sfcj("否");

		if (lBjxxb == null)
			lBjxxb = new ArrayList();
		else
			lBjxxb.clear();
		lBjxxb.add(bjxxb);
		this.result = "success";
		return "success";
	}

	public String wxbj() throws Exception {
		try {
			Bjxxb setBjxxb = new Bjxxb();
			bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjxxb = bjxxbService.getBjxxb(bjxxb);

		lBjxxb.clear();
		lBjxxb.add(bjxxb);
		this.result = "success";
		return "success";
	}

	public String cjhf() throws Exception {
		try {
			Bjxxb setBjxxb = new Bjxxb();
			bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjxxb = bjxxbService.getBjxxb(bjxxb);

		Globalpar gp = this.getCacheGlobalpar("cjhfModifyExpiredTime");
		String cjhfModifyExpiredTime = gp.getGlobalparvalue();

		bjxxb.setCanModify(canModify(bjxxb.getFkrq(), cjhfModifyExpiredTime));// 设定是否可以修改

		lBjxxb.clear();
		lBjxxb.add(bjxxb);
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Bjxxb setBjxxb = new Bjxxb();
			bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjxxbService.updateBjxxb(bjxxb);
		this.result = "success";
		return "success";
	}

	public String xbjUpdate() throws Exception {
		try {
			Bjxxb setBjxxb = new Bjxxb();
			bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjxxb.setPjsj(new Date());

		bjxxbService.updateBjxxb(bjxxb);
		this.result = "success";
		return "success";
	}

	public String cjhfUpdate() throws Exception {
		try {
			Bjxxb setBjxxb = new Bjxxb();
			bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
			bjxxb.setFkrq(new Date());
			bjxxb.setGxbbh(bjxxb.getGxbbh().intValue() + 1);// 更新版本号自增1
			if (bjxxb.getChjjg().equals("未抓获")) {
				bjxxb.setZhsj(null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjxxbService.updateBjxxb(bjxxb);
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Bjxxb setBjxxb = new Bjxxb();
			bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjxxb = bjxxbService.insertBjxxb(bjxxb);
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Bjxxb setBjxxb = new Bjxxb();
			bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bjxxbService.deleteBjxxb(bjxxb);
		this.result = "success";
		return "success";
	}

	public String canModify(Date fkrq, String jgsj) {
		if (fkrq == null)
			return "1";
		Calendar expiredTime = Calendar.getInstance();
		Calendar now = Calendar.getInstance();

		expiredTime.setTime(fkrq);
		expiredTime.add(Calendar.DAY_OF_MONTH, Integer.parseInt(jgsj));

		if (now.compareTo(expiredTime) < 0)
			return "1";
		else
			return "0";
	}

	public String getUserDept(int type) { // type 1:简项 type 2:全项
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();

		// 取得用户和所在部门信息
		User user = (User) session.getAttribute(Constants.userKey);
		Department userDepartment = user.getDepartment();
		if (type == 1)
			return StringUtil.trimEven0(userDepartment.getDepartbrevitycode());
		else
			return userDepartment.getDepartcode();
	}

	public String getUserDeptName() { // type 1:简项 type 2:全项
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();

		// 取得用户和所在部门信息
		User user = (User) session.getAttribute(Constants.userKey);
		Department userDepartment = user.getDepartment();
		return userDepartment.getDepartname();

	}

	/**
	 * 报警信息 主页面显示
	 * 
	 * @return
	 * @throws Exception
	 */
	public String querylistMain() throws Exception {
		Bjxxb setBjxxb = new Bjxxb();
		bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);
		HttpSession session = request.getSession();
		User user = new User();
		user = (User) session.getAttribute(Constants.userKey);
		String usertype = user.getUsertype();
		
		String hylbdm = bjxxb.getHylbdm();
		Map map = new HashMap();
		if(usertype.indexOf("24")==-1&&usertype.indexOf("14")!=-1){
			///娱乐业用户
			map.put("hylbdm", "J");
			
		}else if(usertype.indexOf("24")!=-1&&usertype.indexOf("14")==-1){
			///旅馆业用户
			map.put("hylbdm", "A");
			
		}
		if(hylbdm!=null&&!"".equals(hylbdm)){ //传入行业类别
			map.put("hylbdm",hylbdm);
		}
		
		int level = user.getDepartment().getDepartlevel().intValue();
		if(level>=3){
			map.put("deptCode", getUserDept(1) + "%");
		}
		map.put("jqztdm", "0");
		// map.put("sfyxbjdm", bjxxb.getSfyxbjdm());

		Page page = bjxxbService.getMainListForPage(map, pagesize, pagerow, sort, dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBjxxb = page.getData();

		for (java.util.Iterator iter = lBjxxb.iterator(); iter.hasNext();) {
			Bjxxb oneBjxxb = (Bjxxb) iter.next();
			oneBjxxb.setXm(oneBjxxb.getXm() + "<input type='hidden' name='lx" + oneBjxxb.getBjxxid() + "' value='" 
					+ oneBjxxb.getBjlx() +"_" + oneBjxxb.getHylbdm()+"_"+ oneBjxxb.getGmsfhm()  
					+ "'/>");
		}

		setTabledataMain(lBjxxb);
		this.result = "success";
		return "success";
	}

	public void setTabledataMain(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bjxxid");
		lPro.add("xm");
		lPro.add("ssqymc");
		lPro.add("gxdwmc");
		//lPro.add("ruzhusj");
		lPro.add("bjsj");

		List lDetail = new ArrayList();
		lDetail.add("setdeailxx");
		lDetail.add("详细信息");

		List lCygj=new ArrayList();
    	lCygj.add("setCyryCygj");
    	lCygj.add("从业轨迹");
    	List lGzrz=new ArrayList();
    	lGzrz.add("setCyryGzrz");
    	lGzrz.add("工作日志");
    	
		List lModify = new ArrayList();
		lModify.add("setPaiJing");
		lModify.add("派警");

		List lCol = new ArrayList();
		lCol.add(lDetail);
		lCol.add(lModify);
		lCol.add(lCygj);
		lCol.add(lGzrz);
		Bjxxb getBjxxb = new Bjxxb();
		this.setData(getBjxxb, lData, lPro, lCol);
		// this.setDataCustomer(getBjxxb, lData, lPro, null, null);

		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	/**
	 * 报警信息 主页面显示
	 * 
	 * @return
	 * @throws Exception
	 */
	public String querylistFjjsMain() throws Exception {
		Bjxxb setBjxxb = new Bjxxb();
		bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);
		HttpSession session = request.getSession();
		User user = new User();
		user = (User) session.getAttribute(Constants.userKey);
		String usertype = user.getUsertype();
		
		Map map = new HashMap();
		if(usertype.indexOf("24")==-1&&usertype.indexOf("14")!=-1){
			///娱乐业用户
			map.put("hylbdm", "J");
			
		}else if(usertype.indexOf("24")!=-1&&usertype.indexOf("14")==-1){
			///旅馆业用户
			map.put("hylbdm", "A");
			
		}else{
			//System.out.println(bjxxb.getHylbdm());
			map.put("hylbdm",bjxxb.getHylbdm());
			
		}
		
		map.put("deptCode", getUserDept(1) + "%");
		map.put("jqztdm", "0");
		// map.put("sfyxbjdm", bjxxb.getSfyxbjdm());

		Page page = bjxxbService.getMainListForPage(map, pagesize, pagerow, sort, dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBjxxb = page.getData();

		for (java.util.Iterator iter = lBjxxb.iterator(); iter.hasNext();) {
			Bjxxb oneBjxxb = (Bjxxb) iter.next();
			oneBjxxb.setXm(oneBjxxb.getXm() + "<input type='hidden' name='lx" + oneBjxxb.getBjxxid() + "' value='" + oneBjxxb.getBjlx() + "'/>");
		}

		setTabledataFjjsMain(lBjxxb);
		this.result = "success";
		return "success";
	}

	public void setTabledataFjjsMain(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bjxxid");
		lPro.add("xm");
		lPro.add("ssqymc");
		lPro.add("gxdwmc");
		lPro.add("bjlx");
		lPro.add("bjsj");
		lPro.add("sfyxbj");
		lPro.add("cjjg"); 

		List lDetail = new ArrayList();
		lDetail.add("setdeailxx");
		lDetail.add("详细信息");

		List lModify = new ArrayList();
		lModify.add("setPaiJing");
		lModify.add("派警");

		List lCol = new ArrayList();
		lCol.add(lDetail);
		lCol.add(lModify);

		Bjxxb getBjxxb = new Bjxxb();
		this.setData(getBjxxb, lData, lPro, lCol);
		// this.setDataCustomer(getBjxxb, lData, lPro, null, null);

		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
    
	/**
	 * 报警信息客户端 页面
	 * @return
	 * @throws Exception
	 */
	public String querylistClient() throws Exception{
		
		Bjxxb setBjxxb = new Bjxxb();
		bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);
		HttpSession session = request.getSession();
		User user = new User();
		user = (User) session.getAttribute(Constants.userKey);
		String usertype = user.getUsertype();
		
		Map map = new HashMap();
		/*if(usertype.indexOf("24")==-1&&usertype.indexOf("14")!=-1){
			///娱乐业用户
			map.put("hylbdm", "J");
			
		}else if(usertype.indexOf("24")!=-1&&usertype.indexOf("14")==-1){
			///旅馆业用户
			map.put("hylbdm", "A");
			
		}else if(usertype.indexOf("24")!=-1&&usertype.indexOf("24")!=-1){
			
		}*/
		
		Department userDepartment = user.getDepartment();
		String deptCode = userDepartment.getDepartcode();
		
		int lev=userDepartment.getDepartlevel();
		//map.put("deptCode", getUserDept(1) + "%");
		if(lev>=3){
			map.put("deptCode", StringUtil.trimEven0(deptCode) + "%");
		}
		
		map.put("bjsj1", bjxxb.getBjsj1());
		map.put("bjsj2", bjxxb.getBjsj2());
		map.put("jqztdm", bjxxb.getJqztdm());     ////警情状态
		map.put("sfyxbjdm", bjxxb.getSfyxbjdm());  ///是否有效
		
		/*System.out.println(bjxxb.getSfyxbjdm());
		if("".equals(bjxxb.getJqztdm())&&"".equals(bjxxb.getSfyxbjdm())){
			map.put("sfyxbjdm2", "1");
		}*/
		
		Page page = bjxxbService.getClientListForPage(map, pagesize, pagerow, sort, dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBjxxb = page.getData();

		for (java.util.Iterator iter = lBjxxb.iterator(); iter.hasNext();) {
			Bjxxb oneBjxxb = (Bjxxb) iter.next();
			oneBjxxb.setXm(oneBjxxb.getXm() + "<input type='hidden' name='lx" + oneBjxxb.getBjxxid() + "' value='" + oneBjxxb.getBjlx() + "'/>");
		}

		setTabledataClient(lBjxxb);
		this.result = "success";
		return "success";
		
	}
	
	public void setTabledataClient(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bjxxid");
		lPro.add("xm");
		lPro.add("ssqymc");
		lPro.add("gxdwmc");
		//lPro.add("ruzhusj");
		lPro.add("bjsj");
		lPro.add("sfyxbj");
		lPro.add("jqzt");

		//////
		
		List lXzcz = new ArrayList();

		List lTsclXbj = new ArrayList();
		lTsclXbj.add("");// 链接ID开头
		lTsclXbj.add("派警"); // 链接显示文字

		List lTsclHf = new ArrayList();
		lTsclHf.add("");// 链接ID开头
		lTsclHf.add("回复"); // 链接显示文字

		List lTsclCk = new ArrayList();
		lTsclCk.add("");// 链接ID开头
		lTsclCk.add("修改回复"); // 链接显示文字

		List lTsclWxbj = new ArrayList();
		lTsclWxbj.add("");// 链接ID开头
		lTsclWxbj.add("无效报警"); // 链接显示文字

		// 比对属性
		List lWhereXbj = new ArrayList(); // 新报警
		lWhereXbj.add("jqzt");

		List lWhereHf = new ArrayList(); // 回复
		lWhereHf.add("sfyxbj");
		lWhereHf.add("jqzt");
		lWhereHf.add("gxdwmc");

		List lWhereCk = new ArrayList();// 查看
		lWhereCk.add("sfyxbj");
		lWhereCk.add("jqzt");
		lWhereCk.add("gxdwmc");

		List lWhereWxbj = new ArrayList();// 无效报警
		lWhereWxbj.add("sfyxbj");

		// 比对值
		List lWhereXbjValue = new ArrayList();
		lWhereXbjValue.add("新报警");

		List lWhereHfValue = new ArrayList();
		lWhereHfValue.add("是");
		lWhereHfValue.add("未回复报警");
		lWhereHfValue.add(getUserDeptName());

		List lWhereCkValue = new ArrayList();
		lWhereCkValue.add("是");
		lWhereCkValue.add("已回复报警");
		lWhereCkValue.add(getUserDeptName());

		List lWhereWxbjValue = new ArrayList();
		lWhereWxbjValue.add("否");

		// 需要比对的属性
		lTsclXbj.add(lWhereXbj);
		lTsclHf.add(lWhereHf);
		lTsclCk.add(lWhereCk);
		lTsclWxbj.add(lWhereWxbj);

		// 需要比对的属性的值
		lTsclXbj.add(lWhereXbjValue);
		lTsclHf.add(lWhereHfValue);
		lTsclCk.add(lWhereCkValue);
		lTsclWxbj.add(lWhereWxbjValue);

		lXzcz.add(lTsclXbj);
		lXzcz.add(lTsclHf);
		lXzcz.add(lTsclCk);
		lXzcz.add(lTsclWxbj);
		//////
		
		List lDetail = new ArrayList();
		lDetail.add("setdeailxx");
		lDetail.add("详细信息");
		List lCol = new ArrayList();
		lCol.add(lDetail);

		Bjxxb getBjxxb = new Bjxxb();
		this.setDataCustomer(getBjxxb, lData, lPro, lCol, lXzcz);
		// this.setDataCustomer(getBjxxb, lData, lPro, null, null);

		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	
	
	
	/*public void getExcelCreateRz() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		// String maxRows = (String)session.getAttribute("exportmacrows");

		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();

		try {
			// Excel输出
			List lResult = this.getExcelResponse(); // //开头excel
			Bjxxb setBjxxb = new Bjxxb();
			bjxxb = (Bjxxb) this.setClass(setBjxxb, null);

			Map map = new HashMap();
			map.put("deptCode", getUserDept(1) + "%");
			map.put("xm", bjxxb.getXm());
			map.put("gmsfhm", bjxxb.getGmsfhm());
			map.put("hylbdm", bjxxb.getHylbdm());
			map.put("ywlbdm", bjxxb.getYwlbdm());
			map.put("ssqymc", bjxxb.getSsqymc());
			if (bjxxb.getGxdwbm() != null && !bjxxb.getGxdwbm().equals("")) {
				map.put("gxdwbm", bjxxb.getGxdwbm() + "%");
			}
			map.put("bjsj1", bjxxb.getBjsj1());
			map.put("bjsj2", bjxxb.getBjsj2());
			map.put("cjjgdm", bjxxb.getCjjgdm());
			map.put("bjlxdm", bjxxb.getBjlxdm());
			map.put("cjbmbm", bjxxb.getCjbmbm());
			map.put("pjbmbm", bjxxb.getPjbmbm());
			map.put("jqztdm", bjxxb.getJqztdm());
			map.put("sfyxbjdm", bjxxb.getSfyxbjdm());
			map.put("endRow", maxRows); // //必有条件
			// Excel输出
			Page page = bjxxbService.getListForPage(map, 1, Integer.parseInt(maxRows), sort, dir);
			lBjxxb = page.getData();

			lResult.add(lBjxxb);
			lResult.add(setBjxxb);
			this.setExcelCreate("bjxxb", lResult); // //bjxxb 默认文件名字的开头excel
			this.result = "ok";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = e.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = e.getMessage();
		}
	}
	*/
	public String queryForExport() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		session.removeAttribute("bjxxbExportResult");
		// User user= (User)session.getAttribute(Constants.userKey);
		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		
		User user= (User)session.getAttribute(Constants.userKey);
		int Departlevel=user.getDepartment().getDepartlevel();
		
		try {
			Bjxxb setBjxxb = new Bjxxb();
			bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
			Map map = new HashMap();
			if(Departlevel>2){
				map.put("deptCode", StringUtil.trimEven0(getUserDept(1)) + "%");
			}
			map.put("xm", bjxxb.getXm());
			map.put("gmsfhm", bjxxb.getGmsfhm());
			map.put("hylbdm", bjxxb.getHylbdm());
			map.put("ywlbdm", bjxxb.getYwlbdm());
			map.put("ssqymc", bjxxb.getSsqymc());
			if (bjxxb.getGxdwbm() != null && !bjxxb.getGxdwbm().equals("")) {
				map.put("gxdwbm", bjxxb.getGxdwbm() + "%");
			}
			map.put("bjsj1", bjxxb.getBjsj1());
			map.put("bjsj2", bjxxb.getBjsj2());
			map.put("cjjgdm", bjxxb.getCjjgdm());
			map.put("bjlxdm", bjxxb.getBjlxdm());
			map.put("cjbmbm", bjxxb.getCjbmbm());
			map.put("pjbmbm", bjxxb.getPjbmbm());
			map.put("jqztdm", bjxxb.getJqztdm());
			map.put("sfyxbjdm", bjxxb.getSfyxbjdm());
			map.put("endRow", maxRows);
			// Excel输出
			lBjxxb = bjxxbService.getListExportBjxxb(map, sort, dir);
			// ///cache 替换
			List lPro = new ArrayList();
			lPro.add("xm");
			lPro.add("gmsfhm");
			lPro.add("ssqymc");
			lPro.add("gxdwmc");
			lPro.add("bjsj");
			lPro.add("bjlx");
			lPro.add("sfyxbj");
			lPro.add("jqzt");
			lPro.add("chjjg");
			
			List lcache = new ArrayList();
			/*List lcache_mz = this.getDictItemCacheList("minzu", "dm_mz", "0"); //民族替换  "0"为不加列  "1"替换列
			lcache.add(lcache_mz);
			List lcache_xb = this.getDictItemCacheList("xingbie", "dm_xb", "0"); // 性别  "0"为不加列  "1"替换列
			lcache.add(lcache_xb);*/
			Bjxxb getBjxxb = new Bjxxb();
			lBjxxb = this.getResultCache(getBjxxb.getClass().getName(), lPro, lBjxxb, lcache);
			session.setAttribute("bjxxbExportResult", lBjxxb);
			this.result = "success";
		} catch (IOException e) {
			e.printStackTrace();
			this.result = e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			this.result = e.getMessage();
		}
		return "success";
	}

	// 导出excel
	public void getExcelCreateRz() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		try {
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			// Excel输出
			List lResult = new ArrayList(); // //开头excel
			List bjxxbList = (List) session.getAttribute("bjxxbExportResult");
			Bjxxb setBjxxb = new Bjxxb();
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add(bjxxbList);
			lResult.add(setBjxxb);
			this.setExcelCreate("bjxx", lResult);
			this.result = "ok";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = e.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = e.getMessage();
		}
	}

	//报警信息导出(统计链接列表页面)
	public void getExcelCreateBjxxStats() throws Exception {
		// Excel输出
		List lResult = this.getExcelResponse(); // //开头excel
		Bjxxb setBjxxb = new Bjxxb();
		bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		Map map = new HashMap();
		bjxxChaXunTj(map);
		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		if(maxRows==null ||!com.aisino2.core.util.StringUtil.isNumeric(maxRows)){
			maxRows = "10";
		}
		Page page = bjxxbService.getListForPage(map, 1, Integer.parseInt(maxRows), sort, dir);
		lBjxxb = page.getData();

		lResult.add(lBjxxb);
		lResult.add(setBjxxb);
		this.setExcelCreate("bjxx", lResult);
		lBjxxb = null;
		this.result = "ok";
	}
	
	private String gethylbdm(String usertype){
		String hylbdm="";
		if("102".equals(usertype)||"103".equals(usertype)||"104".equals(usertype)){
			hylbdm="F02";//汽车租赁业
		}else if("11".equals(usertype)||"12".equals(usertype)||"13".equals(usertype)||"14".equals(usertype)){
			hylbdm="J";//娱乐业
		}else if("51".equals(usertype)||"52".equals(usertype)||"53".equals(usertype)){
			hylbdm="B";//印章业
		}else if("92".equals(usertype)||"93".equals(usertype)||"94".equals(usertype)){
			hylbdm="F01";//出租汽车业
		}else if("91".equals(usertype)){
			hylbdm="Z";//出租屋行业
		}else if("32".equals(usertype)||"33".equals(usertype)||"34".equals(usertype)){
			hylbdm="E03";//典当业
		}else if("62".equals(usertype)||"63".equals(usertype)||"64".equals(usertype)){
			hylbdm="E01";//二手车交易业
		}else if("82".equals(usertype)||"83".equals(usertype)||"84".equals(usertype)){
			hylbdm="E04";//废旧金属收购业
		}else if("152".equals(usertype)||"153".equals(usertype)||"154".equals(usertype)){
			hylbdm="C01";//机动车拆解业
		}else if("42".equals(usertype)||"43".equals(usertype)||"44".equals(usertype)){
			hylbdm="C";//机修业
		}else if("72".equals(usertype)||"73".equals(usertype)||"74".equals(usertype)){
			hylbdm="E02";//旧移动电话交易业
		}else if("24".equals(usertype)){
			hylbdm="A";//旅馆业
		}else if("162".equals(usertype)||"163".equals(usertype)||"164".equals(usertype)){
			hylbdm="E07";//委托寄卖
		}else if("112".equals(usertype)||"113".equals(usertype)||"114".equals(usertype)){
			hylbdm="X";//浙江省剧毒化学品
		}else if("122".equals(usertype)||"123".equals(usertype)||"124".equals(usertype)){
			hylbdm="N";//重点单位
		}else{
			hylbdm="";
		}
		return hylbdm;
	}
	
	/**
	 * 多行业首页警情信息
	 * @return
	 * @throws Exception
	 */
	public String querylistByDhyIndex() throws Exception {
		Bjxxb setBjxxb = new Bjxxb();
		bjxxb = (Bjxxb) this.setClass(setBjxxb, null);
		Map map = new HashMap();	
		String[] usertypes=bjxxb.getUsertype().split(",");
		String usertype="";
		int len=usertypes.length;
		for (int i = 0; i < len; i++) {
			if(i!=len-1){
				usertype+="'"+this.gethylbdm(usertypes[i].toString())+"',";
			}else{
				usertype+="'"+this.gethylbdm(usertypes[i].toString())+"'";
			}
		}
		map.put("hylbdms", usertype);
		
		int level = 0;
		if(bjxxb.getGxdwlevel()!=null){
			level=bjxxb.getGxdwlevel();
		}
		if(level>2){
			map.put("deptCode", bjxxb.getGxdwbm() + "%");
		}
		map.put("jqztdm", "0");
		// map.put("sfyxbjdm", bjxxb.getSfyxbjdm());

		Page page = bjxxbService.getMainListForPage(map, pagesize, pagerow, sort, dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBjxxb = page.getData();

		setTabledataByDhyIndex(lBjxxb);
		this.result = "success";
		return "success";
	}

	public void setTabledataByDhyIndex(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bjxxid");
		lPro.add("xm");
		lPro.add("ssqymc");
		lPro.add("gxdwmc");
		//lPro.add("ruzhusj");
		lPro.add("bjsj");
		lPro.add("bjlx");
		List lDetail = new ArrayList();
		lDetail.add("setdeailxx");
		lDetail.add("详细信息");
		List lCol = new ArrayList();
		lCol.add(lDetail);
		Bjxxb getBjxxb = new Bjxxb();
		this.setData(getBjxxb, lData, lPro, lCol);
		// this.setDataCustomer(getBjxxb, lData, lPro, null, null);

		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
}