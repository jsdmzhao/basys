package com.aisino2.publicsystem.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Aqjcsb;
import com.aisino2.publicsystem.domain.Baryxx;
import com.aisino2.publicsystem.domain.Bldsjksb;
import com.aisino2.publicsystem.domain.Bwryxx;
import com.aisino2.publicsystem.domain.Pmt;
import com.aisino2.publicsystem.domain.Qyffl;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyjbxx_ls;
import com.aisino2.publicsystem.domain.Qyzjb;
import com.aisino2.publicsystem.domain.Zjb_ls;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyjbxx_lsService;
import com.aisino2.publicsystem.service.IQyzjbService;
import com.aisino2.publicsystem.service.IZjb_lsService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.opensymphony.xwork2.ActionContext;

public class QyjbxxAction extends PageAction {
	private IDict_itemService dict_itemService;
	private IQyjbxxService qyjbxxService;
	private IQyzjbService qyzjbService;
	private IQyjbxx_lsService qyjbxx_lsService;
	private IZjb_lsService zjb_lsService;
	private List lQyjbxx = new ArrayList();
	private Qyjbxx qyjbxx = new Qyjbxx();
	private String tabledata = "";
	private int totalrows = 0;
	private String result = "success";
	private User user;
	private String valiResult;

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Qyjbxx getQyjbxx() {
		return qyjbxx;
	}

	public List getLQyjbxx() {
		return lQyjbxx;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}

	public void setQyzjbService(IQyzjbService qyzjbService) {
		this.qyzjbService = qyzjbService;
	}

	public void setQyjbxx_lsService(IQyjbxx_lsService qyjbxx_lsService) {
		this.qyjbxx_lsService = qyjbxx_lsService;
	}

	public void setZjb_lsService(IZjb_lsService zjb_lsService) {
		this.zjb_lsService = zjb_lsService;
	}

	public String getValiResult() {
		return valiResult;
	}

	public void setSelTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qyid");
		lPro.add("qymc");
		lPro.add("qybm");

		List lCol = new ArrayList();

		Qyjbxx getQyjbxx = new Qyjbxx();

		this.setData(getQyjbxx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qyid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("jjlxmc");
		lPro.add("zrs");
		lPro.add("lxdh");
		lPro.add("ztmc");

		List lXzcz = new ArrayList();
		List lTscl = new ArrayList();
		lTscl.add("qyxg");// 链接ID开头

		lTscl.add("修改"); // 链接显示文字
		lTscl.add("zt");// 需要比对的属性

		lTscl.add("0");// 需要比对的属性的值

		lXzcz.add(lTscl);

		lTscl = new ArrayList();
		lTscl.add("qyxg");// 链接ID开头

		lTscl.add("修改"); // 链接显示文字
		lTscl.add("zt");// 需要比对的属性

		lTscl.add("11");// 需要比对的属性的值

		lXzcz.add(lTscl);

		lTscl = new ArrayList();
		lTscl.add("qyxg");// 链接ID开头

		lTscl.add(""); // 链接显示文字
		lTscl.add("zt");// 需要比对的属性

		lTscl.add("1");// 需要比对的属性的值

		lXzcz.add(lTscl);

		lTscl = new ArrayList();
		lTscl.add("qyxg");// 链接ID开头

		lTscl.add(""); // 链接显示文字
		lTscl.add("zt");// 需要比对的属性

		lTscl.add("2");// 需要比对的属性的值

		lXzcz.add(lTscl);

		lTscl = new ArrayList();
		lTscl.add("qyxg");// 链接ID开头

		lTscl.add(""); // 链接显示文字
		lTscl.add("zt");// 需要比对的属性

		lTscl.add("10");// 需要比对的属性的值

		lXzcz.add(lTscl);

		lTscl = new ArrayList();
		lTscl.add("qyxg");// 链接ID开头

		lTscl.add(""); // 链接显示文字
		lTscl.add("zt");// 需要比对的属性

		lTscl.add("12");// 需要比对的属性的值

		lXzcz.add(lTscl);

		lTscl = new ArrayList();
		lTscl.add("qyxg");// 链接ID开头

		lTscl.add(""); // 链接显示文字
		lTscl.add("zt");// 需要比对的属性

		lTscl.add("13");// 需要比对的属性的值

		lXzcz.add(lTscl);

		Qyjbxx getQyjbxx = new Qyjbxx();

		this.setDataCustomer(getQyjbxx, lData, lPro, null, lXzcz);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	/**
	 * 查询请求列表
	 * 
	 * @param lData
	 * @throws Exception
	 */
	public void setChaXunTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qyid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("zrs");
		lPro.add("qyzflmc");
		lPro.add("yyztmc");
		lPro.add("zjztmc");
		lPro.add("zajbmc");

		List lModify = new ArrayList();
		lModify.add("qyhc_setCongye");
		lModify.add("从业人员");

		List lCol = new ArrayList();
		lCol.add(lModify);

		Qyjbxx getQyjbxx = new Qyjbxx();

		this.setData(getQyjbxx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	/**
	 * 核查请求列表
	 * 
	 * @param lData
	 * @throws Exception
	 */
	public void setHechaTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qyid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("zrs");
		lPro.add("qyzflmc");
		lPro.add("ztmc");

		List lModify = new ArrayList();
		lModify.add("qyhc_setHecha");
		lModify.add("核查");

		List lCol = new ArrayList();
		lCol.add(lModify);

		Qyjbxx getQyjbxx = new Qyjbxx();

		this.setData(getQyjbxx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	/**
	 * 变更请求列表
	 * 
	 * @param lData
	 * @throws Exception
	 */
	public void setBianGengTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qyid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("zrs");
		lPro.add("qyzflmc");
		lPro.add("gxdwmc");

		List lxq = new ArrayList();
		lxq.add("qybg_setXiangQing");
		lxq.add("详情");

		List lbg = new ArrayList();
		lbg.add("qybg_setBianGeng");
		lbg.add("变更");

		List lCol = new ArrayList();
		lCol.add(lxq);
		lCol.add(lbg);

		Qyjbxx getQyjbxx = new Qyjbxx();

		this.setData(getQyjbxx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	/**
	 * 注销请求列表
	 * 
	 * @param lData
	 * @throws Exception
	 */
	public void setZhuXiaoTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qyid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("zrs");
		lPro.add("qyzflmc");
		lPro.add("gxdwmc");

		List lbg = new ArrayList();
		lbg.add("qyzx_setZhuXiao");
		lbg.add("注销");

		List lCol = new ArrayList();
		lCol.add(lbg);

		Qyjbxx getQyjbxx = new Qyjbxx();

		this.setData(getQyjbxx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	/**
	 * 变更详细请求列表
	 * 
	 * @param lData
	 * @throws Exception
	 */
	public void setBianGengXxTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qylsid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("zrs");
		lPro.add("qyzflmc");
		lPro.add("ztgbrq");

		List lxq = new ArrayList();
		lxq.add("qybg_setXqInfo");
		lxq.add("详情");

		List lCol = new ArrayList();
		lCol.add(lxq);

		Qyjbxx_ls getQyjbxx = new Qyjbxx_ls();

		this.setData(getQyjbxx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String queryTYlist() throws Exception{// 筛选企业

		try{
			Qyjbxx setQyjbxx=new Qyjbxx();
			Map map = new HashMap();
			setQyjbxx=(Qyjbxx)this.setClass(setQyjbxx, null);
			
			map.put("query_simplepin",setQyjbxx.getQuery_simplepin());
			map.put("hylbdm",setQyjbxx.getHylbdm());
			map.put("zxbz",setQyjbxx.getZxbz());
			map.put("allhylbdm",setQyjbxx.getAllhylbdm());
			// 根据登陆用户 设置查询条件 只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
			user= (User)session.getAttribute(Constants.userKey);
			
			if(user!=null){
				if(setQyjbxx.getGxdwbm()!=null&&!"".equals(setQyjbxx.getGxdwbm())){
					map.put("deptCode", StringUtil.trimEven0(setQyjbxx.getGxdwbm()));
				}else{
					String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
					String ssdwbm = user.getSsdwbm();
					if(depertCode0.indexOf("CJD")!=-1){//采集端
						if("ickff".equals(setQyjbxx.getYmgn()))//IC卡发放
						{
							map.put("deptCode", StringUtil.trimEven0(StringUtil.add0(depertCode0.substring(3), 6).substring(0, 4)));
						}
						else if("ickbhk".equals(setQyjbxx.getYmgn()))
						{
							map.put("lrdwbm", null);
						}
						else
						{
							map.put("lrdwbm", depertCode0);
						}
						
					}else if(ssdwbm!=null&&!"".equals(ssdwbm)){//企业端

						    map.put("deptCode", depertCode0);
					}else if(depertCode0.indexOf("ZKD")!=-1){//制卡端

						    
					}else if(user.getDepartment().getDepartcode().length()==12){// 公安端

						    map.put("deptCode", depertCode0);
					}
				}
				
				
				map.put("superbWhere", setQyjbxx.getSuperbWhere()); // 高级查询条件
				map.put("superbOrderBy", setQyjbxx.getSuperbOrderBy());
				
				//江苏公安端查询统计用到的变量
				if(setQyjbxx.getFlagTj()!=null&&!setQyjbxx.getFlagTj().equals("")){
					map.put("flagTj", setQyjbxx.getFlagTj());
				}
				
				//是否有效，核查过的企业即为有效企业
				if(StringUtil.isNotEmpty(setQyjbxx.getSfyx())) {
					map.put("sfyx", setQyjbxx.getSfyx());
				} 
				//是否核查
				if(StringUtil.isNotEmpty(setQyjbxx.getSfhc())) {
					map.put("sfhc", setQyjbxx.getSfhc());
				}
				map.put("sftjyg", "1");//是否统计异构数据，sfyx为1时才生效
				
				//装机状态
				if(StringUtil.isNotEmpty(setQyjbxx.getZjztdm()))
				{
					map.put("zjztdm", setQyjbxx.getZjztdm());
				}
				map.put("sfglyg", "1");//是否过滤异构数据
				
				Page page = qyjbxxService.getListForPage(map, pagesize, pagerow,sort,dir);
				totalpage=page.getTotalPages();
				totalrows=page.getTotalRows();
				lQyjbxx=page.getData();
				// translateDictZT();
			}
			setSelTabledata(lQyjbxx); 
		}catch(Exception e){
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}

	public String querylist() throws Exception {
		try {
			Qyjbxx setQyjbxx = new Qyjbxx();
			Map map = new HashMap();
			setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);

			map.put("qymc", setQyjbxx.getQymc());
			map.put("qybm", setQyjbxx.getQybm());
			map.put("hylbdm", setQyjbxx.getHylbdm());
			map.put("qyzflbm", setQyjbxx.getQyzflbm());
			map.put("gxdwbm", StringUtil.trimEven0(setQyjbxx.getGxdwbm())); // 7.27取简项代码

			map.put("zt", setQyjbxx.getZt());
			map.put("zjbh", setQyjbxx.getZjbh());
			map.put("zxbz", "0");// 注销标志
			// 根据登陆用户 设置查询条件 只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session = request.getSession();
			user = (User) session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment()
					.getDepartcode());
			if(depertCode0.indexOf("CJD")==0){
				map.put("lrdwbm", depertCode0);
			}else{
				map.put("deptCode", depertCode0);
			}

			map.put("superbWhere", setQyjbxx.getSuperbWhere()); // 高级查询条件
			map.put("superbOrderBy", setQyjbxx.getSuperbOrderBy());

			Page page = qyjbxxService.getListForPage(map, pagesize, pagerow,
					sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQyjbxx = page.getData();
			translateDictZT();
			setTabledata(lQyjbxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 企业查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryQyChaxunList() throws Exception {
		try {
			Qyjbxx setQyjbxx = new Qyjbxx();
			Map map = new HashMap();
			setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);

			map.put("qymc", setQyjbxx.getQymc());
			map.put("qybm", setQyjbxx.getQybm());
			map.put("hylbdm", setQyjbxx.getHylbdm());
			map.put("qyzflbm", setQyjbxx.getQyzflbm());
			map.put("gxdwbm", StringUtil.trimEven0(setQyjbxx.getGxdwbm())); // 7.27取简项代码

			map.put("zabdm", setQyjbxx.getZabdm());
			map.put("zrs", setQyjbxx.getZrs());
			map.put("relation", setQyjbxx.getRelation());
			map.put("yyztdm", setQyjbxx.getYyztdm());
			map.put("zjbh", setQyjbxx.getZjbh());
			map.put("sfyx", "1"); // 是否有效
			// 根据登陆用户 设置查询条件 只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session = request.getSession();
			user = (User) session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment()
					.getDepartcode());
			map.put("deptCode", depertCode0);
			map.put("superbWhere", setQyjbxx.getSuperbWhere()); // 高级查询条件
			map.put("superbOrderBy", setQyjbxx.getSuperbOrderBy());

			Page page = qyjbxxService.getListForPageQycx(map, pagesize,
					pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			List list = page.getData();
			setChaXunTabledata(list);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 企业核查
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryQyhcList() throws Exception {
		try {
			String ejshkg = "";
			Globalpar glo_ejshkg = new Globalpar();
			Globalpar temp_ejshkg = null;
			List globList_ejshkg = null;

			glo_ejshkg.setGlobalparcode("ejshkg"); // 二级审核开关

			globList_ejshkg = CacheManager.getCacheGlobalpar(glo_ejshkg);
			if (globList_ejshkg != null && globList_ejshkg.size() > 0) {
				temp_ejshkg = (Globalpar) globList_ejshkg.get(0);
				ejshkg = temp_ejshkg.getGlobalparvalue();
			}

			if ("1".equals(ejshkg)) { // 执行二级审核
				setHechaTabledata(new ArrayList());
			} else { // 不二级审核

				Qyjbxx setQyjbxx = new Qyjbxx();
				Map map = new HashMap();
				setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);

				map.put("qymc", setQyjbxx.getQymc());
				map.put("qybm", setQyjbxx.getQybm());
				map.put("hylbdm", setQyjbxx.getHylbdm());
				map.put("qyzflbm", setQyjbxx.getQyzflbm());
				map.put("gxdwbm", StringUtil.trimEven0(setQyjbxx.getGxdwbm())); // 7.27取简项代码

				map.put("zabdm", setQyjbxx.getZabdm());
				map.put("zrs", setQyjbxx.getZrs());
				map.put("relation", setQyjbxx.getRelation());
				map.put("zjbh", setQyjbxx.getZjbh());
				map.put("sfhc", "0"); // 为核查的场所
				map.put("zxbz", "0"); // 注销标志
				// 根据登陆用户 设置查询条件 只能查询管辖单位和下属单位的信息
				ActionContext ctx = ActionContext.getContext();
				HttpServletRequest request = (HttpServletRequest) ctx
						.get(ServletActionContext.HTTP_REQUEST);
				HttpSession session = request.getSession();
				user = (User) session.getAttribute(Constants.userKey);
				String depertCode0 = StringUtil.trimEven0(user.getDepartment()
						.getDepartcode());
				map.put("deptCode", depertCode0);
				map.put("superbWhere", setQyjbxx.getSuperbWhere()); // 高级查询条件
				map.put("superbOrderBy", setQyjbxx.getSuperbOrderBy());

				Page page = qyjbxxService.getListForPageHc(map, pagesize,
						pagerow, sort, dir);
				totalpage = page.getTotalPages();
				totalrows = page.getTotalRows();
				lQyjbxx = page.getData();
				translateDictZT();
				setHechaTabledata(lQyjbxx);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 企业变更
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryQyBianGengList() throws Exception {
		try {
			Qyjbxx setQyjbxx = new Qyjbxx();
			Map map = new HashMap();
			setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);
			map.put("qymc", setQyjbxx.getQymc());
			map.put("qybm", setQyjbxx.getQybm());
			map.put("hylbdm", setQyjbxx.getHylbdm());
			map.put("qyzflbm", setQyjbxx.getQyzflbm());
			map.put("zjbh", setQyjbxx.getZjbh());
			map.put("gxdwbm", StringUtil.trimEven0(setQyjbxx.getGxdwbm())); // 7.27取简项代码

			map.put("zrs", setQyjbxx.getZrs());
			map.put("relation", setQyjbxx.getRelation());
			map.put("sfhc", "1"); // 为核查的场所
			map.put("zxbz", "0"); // 注销标志
			// 根据登陆用户 设置查询条件 只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session = request.getSession();
			user = (User) session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment()
					.getDepartcode());
			if(depertCode0.indexOf("CJD")==0){
				map.put("lrdwbm", depertCode0);
			}else{
				map.put("deptCode", depertCode0);
			}
			map.put("superbWhere", setQyjbxx.getSuperbWhere()); // 高级查询条件
			map.put("superbOrderBy", setQyjbxx.getSuperbOrderBy());

			Page page = qyjbxxService.getListForPageQybg(map, pagesize,
					pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			setBianGengTabledata(page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 企业注销
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryQyZhuXiaoList() throws Exception {
		try {
			Qyjbxx setQyjbxx = new Qyjbxx();
			Map map = new HashMap();
			setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);

			map.put("qymc", setQyjbxx.getQymc());
			map.put("qybm", setQyjbxx.getQybm());
			map.put("hylbdm", setQyjbxx.getHylbdm());
			map.put("qyzflbm", setQyjbxx.getQyzflbm());
			map.put("zjbh", setQyjbxx.getZjbh());
			map.put("gxdwbm", StringUtil.trimEven0(setQyjbxx.getGxdwbm())); // 7.27取简项代码

			map.put("zrs", setQyjbxx.getZrs());
			map.put("relation", setQyjbxx.getRelation());
			map.put("sfhc", "1"); // 为核查的场所
			map.put("zxbz", "0"); // 注销标志
			// 根据登陆用户 设置查询条件 只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session = request.getSession();
			user = (User) session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment()
					.getDepartcode());
			if(depertCode0.indexOf("CJD")==0){
				map.put("lrdwbm", depertCode0);
			}else{
				map.put("deptCode", depertCode0);
			}
			map.put("superbWhere", setQyjbxx.getSuperbWhere()); // 高级查询条件
			map.put("superbOrderBy", setQyjbxx.getSuperbOrderBy());

			Page page = qyjbxxService.getListForPageQybg(map, pagesize,
					pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			setZhuXiaoTabledata(page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 企业变更详细
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryQyBianGengXiangxiList() throws Exception {
		try {
			Qyjbxx setQyjbxx = new Qyjbxx();
			Map map = new HashMap();
			setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);
			map.put("qyid", setQyjbxx.getQyid());
			map.put("bcsjf", setQyjbxx.getBcsj());
			map.put("bcsjt", setQyjbxx.getBcsjt());
			// 根据登陆用户 设置查询条件 只能查询管辖单位和下属单位的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session = request.getSession();
			user = (User) session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment()
					.getDepartcode());
			map.put("deptCode", depertCode0);
			Page page = qyjbxxService.getListForPageQybgxq(map, pagesize,
					pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			setBianGengXxTabledata(page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 请求单条企业信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryOne() throws Exception {
		try {
			Qyjbxx setQyjbxx = new Qyjbxx();
			setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);
			setQyjbxx = qyjbxxService.getQyjbxxAll(setQyjbxx);
			lQyjbxx = new ArrayList();
			lQyjbxx.add(setQyjbxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public String query() throws Exception {
		try {
			Qyjbxx setQyjbxx = new Qyjbxx();
			setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);
			setQyjbxx = qyjbxxService.getQyjbxxAll(setQyjbxx);
			queryQyMes(setQyjbxx);
		} catch (Exception e) {
			e.printStackTrace();
			result = "";
			return "success";
		}
		return "success";
	}
	
	/**
	 * 查询企业名称
	 * @return
	 * @throws Exception
	 */
	public String querymc() throws Exception {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest requeset = ServletActionContext.getRequest();
			String qyid = requeset.getParameter("qyid");
			Qyjbxx setQyjbxx = new Qyjbxx();
			setQyjbxx.setQyid(Integer.parseInt(qyid.trim()));
			setQyjbxx = qyjbxxService.getQyjbxx(setQyjbxx);
			lQyjbxx.add(setQyjbxx);
		} catch (Exception e) {
			e.printStackTrace();
			result = "";
			return "success";
		}
		return "success";
	}

	/**
	 * 变更历史信息
	 * 
	 * @return
	 */
	public String queryLs() {
		try {
			Qyjbxx_ls qyjbxx_ls = new Qyjbxx_ls();
			qyjbxx_ls = (Qyjbxx_ls) this.setClass(qyjbxx_ls, null);
			qyjbxx_ls = qyjbxx_lsService.getQyjbxx_ls(qyjbxx_ls);
			queryQyLsMes(qyjbxx_ls);
		} catch (Exception e) {
			e.printStackTrace();
			result = "";
			return "success";
		}
		return "success";
	}

	/**
	 * 变更历史对比信息
	 * 
	 * @return
	 */
	public String queryLsBalance() {
		try {
			Qyjbxx_ls qyjbxx_ls = new Qyjbxx_ls();
			qyjbxx_ls = (Qyjbxx_ls) this.setClass(qyjbxx_ls, null);
			String isLast = qyjbxx_lsService.isLatestBgQyjbxx_ls(qyjbxx_ls); // 判断是否是最新记录


			if ("0".equals(isLast)) { // 不是最新记录

				qyjbxx_ls = qyjbxx_lsService.getNextBgQyjbxx_ls(qyjbxx_ls);
				queryQyLsMes(qyjbxx_ls);
			}
			if ("1".equals(isLast)) { // 是最新记录 则取娱乐场所信息
				Qyjbxx setQyjbxx = new Qyjbxx();
				setQyjbxx.setQyid(qyjbxx_ls.getQyid());
				setQyjbxx = qyjbxxService.getQyjbxx(setQyjbxx);
				queryQyMes(setQyjbxx);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/** 企业信息 */
	public void queryQyMes(Qyjbxx setQyjbxx) {
		Map map = new HashMap();
		map.put("qyid", setQyjbxx.getQyid());
		Page zjbPage = qyzjbService.getListForPage(map, 1, 10, null, null);
		List zjbList = zjbPage.getData();
		Qyzjb resu = new Qyzjb();
		if (zjbList != null && zjbList.size() > 0) {
			for (int indexzjb = 0, max = zjbList.size(); indexzjb < max; indexzjb++) {
				Qyzjb temp = (Qyzjb) zjbList.get(indexzjb);
				if (temp.getZjfl() != null && "营业执照".equals(temp.getZjfl())) {
					resu.setYyzzZjbh(temp.getZjbh());
					resu.setYyzzFzjg(temp.getFzjg());
					resu.setYyzzQsrq(temp.getQsrq());
					resu.setYyzzJzrq(temp.getJzrq());
					resu.setYyzzFzjgdm(temp.getFzjgdm());
				}
				if (temp.getZjfl() != null && "经营许可证".equals(temp.getZjfl())) {
					resu.setJyxkZjbh(temp.getZjbh());
					resu.setJyxkFzjg(temp.getFzjg());
					resu.setJyxkQsrq(temp.getQsrq());
					resu.setJyxkJzrq(temp.getJzrq());
					resu.setJyxkFzjgdm(temp.getFzjgdm());
				}
				if (temp.getZjfl() != null && "特行许可证".equals(temp.getZjfl())) {
					resu.setThxkZjbh(temp.getZjbh());
					resu.setThxkFzjg(temp.getFzjg());
					resu.setThxkQsrq(temp.getQsrq());
					resu.setThxkJzrq(temp.getJzrq());
					resu.setThxkFzjgdm(temp.getFzjgdm());
				}
				if (temp.getZjfl() != null && "税务登记证".equals(temp.getZjfl())) {
					resu.setSwdjZjbh(temp.getZjbh());
					resu.setSwdjFzjg(temp.getFzjg());
					resu.setSwdjQsrq(temp.getQsrq());
					resu.setSwdjJzrq(temp.getJzrq());
					resu.setSwdjFzjgdm(temp.getFzjgdm());
				}
			}
		}
		lQyjbxx.add(setQyjbxx);
		lQyjbxx.add(resu);
	}

	/** 企业历史信息 */
	public void queryQyLsMes(Qyjbxx_ls qyjbxx_ls) {
		Map map = new HashMap();
		map.put("qylsid", qyjbxx_ls.getQylsid());
		Page zjbPage = zjb_lsService.getListForPage(map, 1, 10, null, null);
		List zjbList = zjbPage.getData();
		Zjb_ls resu = new Zjb_ls();
		if (zjbList != null && zjbList.size() > 0) {
			for (int indexzjb = 0, max = zjbList.size(); indexzjb < max; indexzjb++) {
				Zjb_ls temp = (Zjb_ls) zjbList.get(indexzjb);
				if (temp.getZjfl() != null && "营业执照".equals(temp.getZjfl())) {
					resu.setYyzzZjbh(temp.getZjbh());
					resu.setYyzzFzjg(temp.getFzjg());
					resu.setYyzzQsrq(temp.getQsrq());
					resu.setYyzzJzrq(temp.getJzrq());
				}
				if (temp.getZjfl() != null && "经营许可证".equals(temp.getZjfl())) {
					resu.setJyxkZjbh(temp.getZjbh());
					resu.setJyxkFzjg(temp.getFzjg());
					resu.setJyxkQsrq(temp.getQsrq());
					resu.setJyxkJzrq(temp.getJzrq());
				}
				if (temp.getZjfl() != null && "特行许可证".equals(temp.getZjfl())) {
					resu.setThxkZjbh(temp.getZjbh());
					resu.setThxkFzjg(temp.getFzjg());
					resu.setThxkQsrq(temp.getQsrq());
					resu.setThxkJzrq(temp.getJzrq());
				}
				if (temp.getZjfl() != null && "税务登记证".equals(temp.getZjfl())) {
					resu.setSwdjZjbh(temp.getZjbh());
					resu.setSwdjFzjg(temp.getFzjg());
					resu.setSwdjQsrq(temp.getQsrq());
					resu.setSwdjJzrq(temp.getJzrq());
				}
			}
		}
		lQyjbxx.add(qyjbxx_ls);
		lQyjbxx.add(resu);
	}

	public String insert() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		try {
			qyjbxxMessage();
			qyjbxx.setLrr(user.getUsername());
			qyjbxx.setLrdwbm(user.getDepartment().getDepartcode());
			qyjbxx.setLrdwmc(user.getDepartment().getDepartname());
			Qyjbxx temp = qyjbxxService.insertQyjbxx(qyjbxx);
			if (temp != null) {
				delePmt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			qyjbxx = null;
			result = "";
			return "success";
		}
		qyjbxx = null;
		return "success";
	}

	/**
	 * 注销
	 * 
	 * @return
	 * @throws Exception
	 */
	public String zhuxiao() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(Constants.userKey);

			Qyjbxx setQyjbxx = new Qyjbxx();
			setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);
			setQyjbxx.setCzr(user.getUsername());
			qyjbxxService.updateQyjbxxZx(setQyjbxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public void qyjbxxMessage() throws Exception {
		//Bafwht bafwht = new Bafwht();//保安服务合同信息
		//Pmt pmt = new Pmt();//平面图信息
		Baryxx baryxx = new Baryxx();//保安人员信息
		Bwryxx bwryxx = new Bwryxx();//保卫人员信息
		Bldsjksb bldsjksb = new Bldsjksb();//视频监控信息
		Aqjcsb aqjcsb = new Aqjcsb();//技防设备信息
		//Wgtzrxx wgtzrxx = new Wgtzrxx();// 外国投资人信息
		Object[] child = { baryxx, bwryxx, bldsjksb, aqjcsb };
		Qyjbxx setQyjbxx = new Qyjbxx();
		qyjbxx = (Qyjbxx) this.setClass(setQyjbxx, child);

		/*BASE64Decoder base64Decoder = new BASE64Decoder();
		List pmtListTemp = qyjbxx.getLPmtList();
		List pmtList = new ArrayList();
		if (pmtListTemp != null && pmtListTemp.size() > 0) {
			String serviceFile = ServletActionContext.getRequest().getRealPath(
					"pmtUploadTemp");
			for (int index = 0, max = pmtListTemp.size(); index < max; index++) {
				byte[] bytetemp = null;
				Pmt temp = (Pmt) pmtListTemp.get(index);
				String sPmtId = temp.getSPmtid();
				if (sPmtId.contains("NEW")) { // 新增加

					BufferedInputStream bis = null;
					try {
						bis = new BufferedInputStream(
								new FileInputStream(serviceFile + "\\"
										+ sPmtId.replace("NEW=", "")));
						bytetemp = new byte[bis.available()];
						bis.read(bytetemp);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							if (bis != null) {
								bis.close();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				temp.setPmtz(bytetemp);
				pmtList.add(temp);
			}
		}
		qyjbxx.setLPmtList(pmtList);*/

		Qyzjb qyzjb = new Qyzjb();
		qyzjb = (Qyzjb) this.setClass(qyzjb, child);
		List zjbList = new ArrayList();
		Qyzjb yyzz = new Qyzjb(); // 营业执照
		yyzz.setZjfl("营业执照");
		yyzz.setZjbh(qyzjb.getYyzzZjbh());
		yyzz.setFzjg(qyzjb.getYyzzFzjg());
		yyzz.setQsrq(qyzjb.getYyzzQsrq());
		yyzz.setJzrq(qyzjb.getYyzzJzrq());
		yyzz.setFzjgdm(qyzjb.getYyzzFzjgdm());
		Qyzjb jyxk = new Qyzjb(); // 经营许可
		jyxk.setZjfl("经营许可证");
		jyxk.setZjbh(qyzjb.getJyxkZjbh());
		jyxk.setFzjg(qyzjb.getJyxkFzjg());
		jyxk.setQsrq(qyzjb.getJyxkQsrq());
		jyxk.setJzrq(qyzjb.getJyxkJzrq());
		jyxk.setFzjgdm(qyzjb.getJyxkFzjgdm());
		Qyzjb thxk = new Qyzjb(); // 特行许可证

		thxk.setZjfl("特行许可证");
		thxk.setZjbh(qyzjb.getThxkZjbh());
		thxk.setFzjg(qyzjb.getThxkFzjg());
		thxk.setQsrq(qyzjb.getThxkQsrq());
		thxk.setJzrq(qyzjb.getThxkJzrq());
		thxk.setFzjgdm(qyzjb.getThxkFzjgdm());
		Qyzjb swdj = new Qyzjb(); // 税务登记证

		swdj.setZjfl("税务登记证");
		swdj.setZjbh(qyzjb.getSwdjZjbh());
		swdj.setFzjg(qyzjb.getSwdjFzjg());
		swdj.setQsrq(qyzjb.getSwdjQsrq());
		swdj.setJzrq(qyzjb.getSwdjJzrq());
		swdj.setFzjgdm(qyzjb.getSwdjFzjgdm());
		List qyzjbList = new ArrayList();
		qyzjbList.add(yyzz);
		qyzjbList.add(jyxk);
		qyzjbList.add(thxk);
		qyzjbList.add(swdj);
		qyjbxx.setLQyzjbList(qyzjbList);

		List qyfflList = new ArrayList();
		String csfflbm = qyjbxx.getQyfflbm();
		String csfflmc = qyjbxx.getQyfflmc();
		String[] csfflbmArr = null;
		String[] csfflmcArr = null;
		if (csfflbm != null && !"".equals(csfflbm)) {
			csfflbmArr = csfflbm.split("\\|");
		}
		if (csfflmc != null && !"".equals(csfflmc)) {
			csfflmcArr = csfflmc.split("\\|");
		}
		if (csfflbmArr != null && csfflmcArr != null
				&& csfflbmArr.length == csfflmcArr.length) {
			for (int indexcsffl = 0, max = csfflbmArr.length; indexcsffl < max; indexcsffl++) {
				Qyffl temp = new Qyffl();
				temp.setQyflbm(csfflbmArr[indexcsffl]);
				temp.setQyflmc(csfflmcArr[indexcsffl]);
				qyfflList.add(temp);
			}
		}
		qyjbxx.setLQyfflList(qyfflList);
		qyjbxx.setDwfzrzjlb("居民身份证"); // 默认负责人证件为 居民身份证

	}

	public void delePmt() { // 添加或修改成功后 删除服务器上的平面图
		List pmtListTemp = qyjbxx.getLPmtList();
		if (pmtListTemp != null && pmtListTemp.size() > 0) {
			String serviceFile = ServletActionContext.getRequest().getRealPath(
					"pmtUploadTemp");
			for (int index = 0, max = pmtListTemp.size(); index < max; index++) {
				byte[] bytetemp = null;
				Pmt temp = (Pmt) pmtListTemp.get(index);
				String sPmtId = temp.getSPmtid();
				if (sPmtId.contains("NEW")) { // 新增加

					File file = new File(serviceFile + "\\"
							+ sPmtId.replace("NEW=", ""));
					if (file.exists()) {
						file.delete(); // 删除文件
					}
				}
			}
		}
	}

	public String modify() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		try {
			qyjbxxMessage();
			Date barq = qyjbxx.getBarq();
			Date tyrq = qyjbxx.getTyrq();
			if (barq == null) {
				qyjbxx.setIsBarqNull("1");
			}
			if (tyrq == null) {
				qyjbxx.setIsTyrqNull("1");
			}

			qyjbxx.setCzr(user.getUsername());
			boolean res = qyjbxxService.updateQyjbxx(qyjbxx);
			if (res) {
				delePmt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			qyjbxx = null;
			result = "";
			return "success";
		}
		qyjbxx = null;
		return "success";
	}

	public String biangeng() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		try {
			qyjbxxMessage();
			Date barq = qyjbxx.getBarq();
			Date tyrq = qyjbxx.getTyrq();
			if (barq == null) {
				qyjbxx.setIsBarqNull("1");
			}
			if (tyrq == null) {
				qyjbxx.setIsTyrqNull("1");
			}

			qyjbxx.setCzr(user.getUsername());
			boolean res = qyjbxxService.updateQyjbxxBg(qyjbxx);
			if (res) {
				delePmt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			qyjbxx = null;
			result = "";
			return "success";
		}
		qyjbxx = null;
		return "success";
	}

	public String hecha() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		try {
			qyjbxxMessage();
			Date barq = qyjbxx.getBarq();
			Date tyrq = qyjbxx.getTyrq();
			if (barq == null) {
				qyjbxx.setIsBarqNull("1");
			}
			if (tyrq == null) {
				qyjbxx.setIsTyrqNull("1");
			}

			qyjbxx.setHcr(user.getUsername());
			qyjbxx.setHcdw(user.getDepartment().getDepartname());
			boolean res = qyjbxxService.updateQyjbxxHc(qyjbxx);
			if (res) {
				delePmt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			qyjbxx = null;
			result = "";
			return "success";
		}
		qyjbxx = null;
		return "success";
	}

	public String delete() throws Exception {
		try {
			Qyjbxx setQyjbxx = new Qyjbxx();
			qyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qyjbxxService.deleteQyjbxx(qyjbxx);
		this.result = "success";
		return "success";
	}

	/**
	 * 验证营业执照编号 唯一性

	 * 
	 * @return
	 */
	public String valadateYyzz() {
		try {
			Qyjbxx setQyjbxx = new Qyjbxx();
			setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);

			Qyzjb setQyzjb = new Qyzjb(); // 证件表

			setQyzjb = (Qyzjb) this.setClass(setQyzjb, null);
			setQyjbxx.setZjbh(setQyzjb.getYyzzZjbh());
			valiResult = qyjbxxService.isQyjbxxExist(setQyjbxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		return "success";
	}

	/**
	 * 翻译字典项

	 */
	public void translateDictZT() {
		if (lQyjbxx != null && lQyjbxx.size() > 0) {
			for (int index = 0, max = lQyjbxx.size(); index < max; index++) {
				Qyjbxx tempQy = (Qyjbxx) lQyjbxx.get(index);
				Dict_item dict_item = CacheManager.getCacheDictitemOne(
						"dm_csjlzt", tempQy.getZt());
				if (dict_item != null) {
					tempQy.setZtmc(dict_item.getDisplay_name());
					lQyjbxx.set(index, tempQy);
				}
			}
		}
	}

	/**
	 * 制卡端 企业信息 请求列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryQyMessList() throws Exception {
		try {
			Map dictTemp = new HashMap();
			dictTemp.put("", "");
			dictTemp.put(null, "");
			Map dict = new HashMap();
			dict.put("dict_code", "dm_csjlzt");
			Page dictpage = dict_itemService.getListForPage(dict, 1, 30, null,
					null);
			List dictList = dictpage.getData();
			if (dictList != null && dictList.size() > 0) {
				for (int index = 0, max = dictList.size(); index < max; index++) {
					Dict_item temp = (Dict_item) dictList.get(index);
					dictTemp.put(temp.getFact_value(), temp.getDisplay_name());
				}
			}

			Qyjbxx setQyjbxx = new Qyjbxx();
			setQyjbxx = (Qyjbxx) this.setClass(setQyjbxx, null);

			Map map = new HashMap();
			map.put("hylbdm", setQyjbxx.getHylbdm());
			map.put("qybm", setQyjbxx.getQybm());
			map.put("qymc", setQyjbxx.getQymc());
			map.put("sfglyg", "1");//是否过滤异构系统，1为过滤，0为不过滤
			Page page = qyjbxxService.getListForPageZkd(map, pagesize, pagerow,
					sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			List list = page.getData();
			List temp = new ArrayList();
			if (list != null && list.size() > 0) {
				for (int index = 0, max = list.size(); index < max; index++) {
					Qyjbxx tempylqy = (Qyjbxx) list.get(index);
					tempylqy.setZtmc((String) dictTemp.get(tempylqy.getZt()));
					temp.add(tempylqy);
				}
			}
			setQyMessTabledata(temp);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * 制卡端 企业信息
	 * 
	 * @param lData
	 * @throws Exception
	 */
	public void setQyMessTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("qyid");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("frdb");
		lPro.add("ztmc");

		List lDetail = new ArrayList();
		lDetail.add("glcxcsxx_setQuery");
		lDetail.add("查看");
		List lRyqd = new ArrayList();
		lRyqd.add("cyryqk_setQuery");
		lRyqd.add("从业人员清单");

		List lCol = new ArrayList();
		lCol.add(lDetail);
		lCol.add(lRyqd);

		Qyjbxx getQyjbxx = new Qyjbxx();

		this.setData(getQyjbxx, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	
	/**
	 * 获取 废旧金属业 旧货流通类型
	 * @return
	 */
	public String findFjjsJhltType(){
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code("dm_jhltlx");
		List listDictItem = dict_itemService.getListDict_item(dict_item);
		if(listDictItem!=null&&listDictItem.size()>0){
			result = "";
			for(int index=0,max=listDictItem.size();index<max;index++){
				Dict_item dictItemTemp = (Dict_item)listDictItem.get(index);
				result += "<input type='checkbox' id='jhltlx_"+dictItemTemp.getFact_value()+
							"' name='"+dictItemTemp.getDisplay_name()+"'/>"+dictItemTemp.getDisplay_name();
			}
		}
        return "success";
	}
	
	/**获取企业基本信息*/
	
	public String queryQyjbxx() {
		try {
			Qyjbxx setqyjbxx = new Qyjbxx();
			qyjbxx = (Qyjbxx) this.setClass(setqyjbxx, null);
			qyjbxx = qyjbxxService.getQyjbxx(qyjbxx);
			lQyjbxx.add(qyjbxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}
}