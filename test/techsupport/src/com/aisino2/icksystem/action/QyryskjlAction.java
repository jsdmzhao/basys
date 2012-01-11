package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Qyryskjl;
import com.aisino2.icksystem.service.IQyryskjlService;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;

public class QyryskjlAction extends PageAction {
	private IQyryskjlService qyryskjlService;
	private IQyjbxxService qyjbxxService;
	private IQyryxxService qyryxxService; // 从业人员信息
	private List lQyryskjl = new ArrayList();
	private Qyryskjl qyryskjl;
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

	public Qyryskjl getQyryskjl() {
		return qyryskjl;
	}

	public List getLQyryskjl() {
		return lQyryskjl;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setQyryskjlService(IQyryskjlService qyryskjlService) {
		this.qyryskjlService = qyryskjlService;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("skid");
		lPro.add("kh");
		lPro.add("xm");
		lPro.add("sksj");
		lPro.add("qymc");
		lPro.add("gxdwmc");

		List lCol = new ArrayList();

		Qyryskjl getQyryskjl = new Qyryskjl();

		this.setData(getQyryskjl, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public void setTabledataGzrz(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("skid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("sksj");
		lPro.add("qymc");
		lPro.add("gxdwmc");

		List lCol = new ArrayList();

		Qyryskjl getQyryskjl = new Qyryskjl();

		this.setData(getQyryskjl, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public void setTabledataPfsk(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bds");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("skcs");
		
    	List lModify=new ArrayList();
    	lModify.add("setSkgj");
    	lModify.add("刷卡轨迹");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	Qyryskjl setQyryskjl = new Qyryskjl();
        this.setData(setQyryskjl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataGj(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("cyrybh");
		lPro.add("sksj");
		lPro.add("scsj");
		lPro.add("qymc");
		lPro.add("gxdwmc");
    	
    	List lCol=new ArrayList();
    	Qyryskjl setQyryskjl = new Qyryskjl();
        this.setData(setQyryskjl,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public String querylist() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			Map map = new HashMap();
			if (setQyryskjl != null) {
				map.put("cyrybh", setQyryskjl.getCyrybh());
			}
			Page page = qyryskjlService.getListForPage(map, pagesize, pagerow,
					sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQyryskjl = page.getData();
			setTabledata(lQyryskjl);
			this.result = "success";
		} catch (Exception e) {
			this.result = "查询失败";
			e.printStackTrace();
		}
		return "success";
	}

	public String listGzrz() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			Map map = new HashMap();

			if (setQyryskjl != null) {
				map.put("cyrybh", setQyryskjl.getCyrybh());
			}
			Page page = qyryskjlService.getCyrygzrzForPage(map, pagesize,
					pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQyryskjl = page.getData();
			setTabledataGzrz(lQyryskjl);
			this.result = "success";
		} catch (Exception e) {
			this.result = "查询失败";
			e.printStackTrace();
		}
		return "success";
	}

	public String listGzrzGad() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			Map map = new HashMap();

			if (setQyryskjl != null) {
				map.put("cyrybh", setQyryskjl.getCyrybh());
				map.put("kh", setQyryskjl.getKh());
				map.put("cyzj", setQyryskjl.getCyzj());
				map.put("cyzjdm", setQyryskjl.getCyzjdm());
				map.put("zjhm", setQyryskjl.getZjhm());
				map.put("xm", setQyryskjl.getXm());
				map.put("sksjf", setQyryskjl.getSksjf());
				map.put("sksjt", setQyryskjl.getSksjt());
				map.put("gxdwbm", setQyryskjl.getGxdwbm()); // /管辖单位编码
				map.put("csid", setQyryskjl.getQyid()); // /场所id

				javax.servlet.http.HttpSession session = ServletActionContext
						.getRequest().getSession();
				User user = (User) session.getAttribute(Constants.userKey);
				map.put("gxdwbm1", StringUtil.trimEven0(user.getDepartment()
						.getDepartcode()));
			}
			Page page = qyryskjlService.getCyrygzrzForPage(map, pagesize,
					pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQyryskjl = page.getData();
			for (java.util.Iterator iter = lQyryskjl.iterator(); iter.hasNext();) {
				Qyryskjl oneQyryskjl = (Qyryskjl) iter.next();
				oneQyryskjl.setCyrybh(oneQyryskjl.getCyrybh()
						+ "<input type='hidden' name='ryid"
						+ oneQyryskjl.getSkid() + "' value='"
						+ oneQyryskjl.getRyid() + "'/>"
						+ "<input type='hidden' name='rylb"
						+ oneQyryskjl.getSkid() + "' value='"
						+ oneQyryskjl.getCyrylbdm() + "'/>");
			}
			setTabledataCsGzrz(lQyryskjl);
			this.result = "success";
		} catch (Exception e) {
			this.result = "查询失败";
			e.printStackTrace();
		}
		return "success";
	}

	// 场所端人员工作日志

	public void setTabledataCsGzrz(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("skid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("zhiwu");
		lPro.add("sksj");

		Qyryskjl getQyryskjl = new Qyryskjl();

		this.setData(getQyryskjl, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	


	public String listCsGzrz() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			Map map = new HashMap();
			if (setQyryskjl != null) {
				map.put("kh", setQyryskjl.getKh());
				map.put("cyzj", setQyryskjl.getCyzj());
				map.put("cyzjdm", setQyryskjl.getCyzjdm());
				map.put("zjhm", setQyryskjl.getZjhm());
				map.put("xm", setQyryskjl.getXm());
				map.put("sksjf", setQyryskjl.getSksjf());
				map.put("sksjt", setQyryskjl.getSksjt());
				javax.servlet.http.HttpSession session = ServletActionContext
						.getRequest().getSession();
				User user = (User) session.getAttribute(Constants.userKey);
				map.put("csbm", user.getUseraccount());
			}
			Page page = qyryskjlService.getListForPage(map, pagesize, pagerow,
					sort, dir);

			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQyryskjl = page.getData();
			for (java.util.Iterator iter = lQyryskjl.iterator(); iter.hasNext();) {
				Qyryskjl oneQyryskjl = (Qyryskjl) iter.next();
				oneQyryskjl.setCyrybh(oneQyryskjl.getCyrybh()
						+ "<input type='hidden' name='ryid"
						+ oneQyryskjl.getSkid() + "' value='"
						+ oneQyryskjl.getRyid() + "'/>"
						+ "<input type='hidden' name='rylb"
						+ oneQyryskjl.getSkid() + "' value='"
						+ oneQyryskjl.getCyrylbdm() + "'/>"
						+ "<input type='hidden' name='sfzt"
						+ oneQyryskjl.getSkid() + "' value='"
						+ oneQyryskjl.getSfzt() + "'/>");
			}
			setTabledataCsGzrz(lQyryskjl);
			this.result = "success";
		} catch (Exception e) {
			this.result = "查询失败";
			e.printStackTrace();
		}
		return "success";
	}

	/**
	 * 安全巡查日志
	 * 
	 * @return
	 * @throws Exception
	 */
	public String listCsGzrzBA() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			Map map = new HashMap();
			if (setQyryskjl != null) {
				map.put("kh", setQyryskjl.getKh());
				map.put("cyzj", setQyryskjl.getCyzj());
				map.put("cyzjdm", setQyryskjl.getCyzjdm());
				map.put("zjhm", setQyryskjl.getZjhm());
				map.put("xm", setQyryskjl.getXm());
				map.put("sksjf", setQyryskjl.getSksjf());
				map.put("sksjt", setQyryskjl.getSksjt());
				map.put("gxdwbm", setQyryskjl.getGxdwbm()); // /管辖单位编码
				map.put("csid", setQyryskjl.getQyid()); // /场所id

				javax.servlet.http.HttpSession session = ServletActionContext
						.getRequest().getSession();
				User user = (User) session.getAttribute(Constants.userKey);
				map.put("gxdwbm1", StringUtil.trimEven0(user.getDepartment()
						.getDepartcode()));

				map.put("cylbdm", "30");
			}
			Page page = qyryskjlService.getCyrygzrzForPage(map, pagesize,
					pagerow, sort, dir);

			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQyryskjl = page.getData();
			for (java.util.Iterator iter = lQyryskjl.iterator(); iter.hasNext();) {
				Qyryskjl oneQyryskjl = (Qyryskjl) iter.next();
				oneQyryskjl.setCyrybh(oneQyryskjl.getCyrybh()
						+ "<input type='hidden' name='ryid"
						+ oneQyryskjl.getSkid() + "' value='"
						+ oneQyryskjl.getRyid() + "'/>"
						+ "<input type='hidden' name='rylb"
						+ oneQyryskjl.getSkid() + "' value='"
						+ oneQyryskjl.getCyrylbdm() + "'/>");
			}
			setTabledataCsGzrz(lQyryskjl);
			this.result = "success";
		} catch (Exception e) {
			this.result = "查询失败";
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 频繁刷卡
	 * @return
	 * @throws Exception
	 */
	public String querylistPfsk() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl)this.setClass(setQyryskjl, null);
			Map map = new HashMap();
			map.put("sksjf", setQyryskjl.getSksjf());
			map.put("sksjt", setQyryskjl.getSksjt());
			map.put("bds", setQyryskjl.getBds());
			map.put("skcs", setQyryskjl.getSkcs());
			map.put("gxdwbm", StringUtil.trimEven0(setQyryskjl.getGxdwbm()));
			map.put("hylbdm", setQyryskjl.getHylbdm());
			if(!StringUtil.isNotEmpty((String)map.get("gxdwbm")))
			{
				javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User) session.getAttribute(Constants.userKey);
				map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			}
			
	        Page page = qyryskjlService.getPfskForPage(map, pagesize, pagerow,sort,dir);
	        List list = page.getData();
			List listTemp = new ArrayList();
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Qyryskjl skxxtjmxTemp = (Qyryskjl)list.get(index);
					skxxtjmxTemp.setBds(skxxtjmxTemp.getCyrybh()+"___"+skxxtjmxTemp.getRyid()+"---"+skxxtjmxTemp.getCyrylbdm()+"==="+skxxtjmxTemp.getHylbdm());
					listTemp.add(skxxtjmxTemp);
				}
			}
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataPfsk(listTemp); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return "success";
	}
	
	public String querylistPfskExcelTemp() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl)this.setClass(setQyryskjl, null);
			Map map = new HashMap();
			map.put("sksjf", setQyryskjl.getSksjf());
			map.put("sksjt", setQyryskjl.getSksjt());
			map.put("bds", setQyryskjl.getBds());
			map.put("skcs", setQyryskjl.getSkcs());
			map.put("gxdwbm", StringUtil.trimEven0(setQyryskjl.getGxdwbm()));
			map.put("hylbdm", setQyryskjl.getHylbdm());
			if(!StringUtil.isNotEmpty((String)map.get("gxdwbm")))
			{
				User user = (User) session.getAttribute(Constants.userKey);
				map.put("deptCode", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			}
			
	        Page page = qyryskjlService.getPfskForPage(map, 1, Integer.parseInt(maxRows),null,null);
	        session.setAttribute("pfsktjList", page.getData());
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
	    return "success";
	}
	
	public void querylistPfskExcel() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Qyryskjl setQyryskjl = new Qyryskjl();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("pfsktjList"));
			lResult.add(setQyryskjl);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	/**
	 * 频繁刷卡-刷卡轨迹请求列表
	 * @return
	 * @throws Exception
	 */
	public String querylistGj() throws Exception{
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl)this.setClass(setQyryskjl, null);
			Map map = new HashMap();
			map.put("sksjf", setQyryskjl.getSksjf());
			map.put("sksjt", setQyryskjl.getSksjt());
			map.put("cyrybh", setQyryskjl.getCyrybh());
			map.put("hylbdm", setQyryskjl.getHylbdm());
			
	        Page page = qyryskjlService.getPfskGjForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        setTabledataGj(page.getData());
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
    }
	
	public String query() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			setQyryskjl = qyryskjlService.getQyryskjl(setQyryskjl);
			lQyryskjl.clear();
			lQyryskjl.add(setQyryskjl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			setQyryskjl = qyryskjlService.insertQyryskjl(setQyryskjl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			qyryskjlService.updateQyryskjl(setQyryskjl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			qyryskjlService.deleteQyryskjl(setQyryskjl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.result = "success";
		return "success";
	}

	// 下面是公安端 场所营业日志中的 刷卡记录查询

	public void setTabledataCsrzSkjl(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("skid");
		lPro.add("xmzc");
		lPro.add("xmfzc");
		lPro.add("cyrybh");
		lPro.add("shouji");
		lPro.add("sksj");
		lPro.add("scsj");

		List lCol = new ArrayList();

		Qyryskjl getQyryskjl = new Qyryskjl();

		this.setData(getQyryskjl, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylistCsrzSkjl() throws Exception {
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			Map map = new HashMap();
			map.put("qyid", setQyryskjl.getQyid());
			map.put("qybm", setQyryskjl.getQybm());
			map.put("sksjf", setQyryskjl.getSksjf());
			map.put("sksjt", setQyryskjl.getSksjt());
			map.put("cyrybh", setQyryskjl.getCyrybh());
			Page page = qyryskjlService.getQyryskjlGadForPage(map, pagesize,pagerow, sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			setTabledataCsrzSkjl(page.getData());
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	/**
	 * offline手动输入功能
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sdsrOper() throws Exception {
		result = "success";
		try {
			Icksl setIcksl = new Icksl();
			setIcksl = (Icksl) this.setClass(setIcksl, null);

			Qyryskjl skjl = qyryskjlService.insertQyryskjlSdsr(setIcksl);
			if (skjl == null) { // 失败
				result = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "";
			return "success";
		}
		return "success";
	}
	
	

	// 从业人员历史刷卡记录
	public void setTabledataSkjllsxx(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("skid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("sksj");
		Qyryskjl getQyryskjl = new Qyryskjl();

		this.setData(getQyryskjl, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	//从业人员历史刷卡记录
	public String querylistSkjllsxx() throws Exception { 
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			Map map = new HashMap();
			if (setQyryskjl != null) {
				map.put("cyrybh", setQyryskjl.getCyrybh());
				map.put("qybm", setQyryskjl.getQybm());
			}
			Page page = qyryskjlService.getListForPage(map, pagesize, pagerow,
					sort, dir);

			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQyryskjl = page.getData();
		
			setTabledataSkjllsxx(lQyryskjl);
			this.result = "success";
		} catch (Exception e) {
			this.result = "查询失败";
			e.printStackTrace();
		}
		return "success";
	}
	
	// 从业人员历史刷卡记录
	public void setTabledataFiveSkjl(List lData) throws Exception {
		
		List lPro = new ArrayList();
		lPro.add("skid");
		lPro.add("qymc");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("sksj");
		Qyryskjl getQyryskjl = new Qyryskjl();

		this.setData(getQyryskjl, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	//从业人员最近5条刷卡记录

	public String querylistFiveSkjl() throws Exception { 
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			Map map = new HashMap();
			if (setQyryskjl != null) {
				map.put("cyrybh", setQyryskjl.getCyrybh());
			}
			Page page = qyryskjlService.getListForPage(map, 1, 5,
					sort, dir);

			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lQyryskjl = page.getData();
			
			setTabledataFiveSkjl(lQyryskjl);
			this.result = "success";
		} catch (Exception e) {
			this.result = "查询失败";
			e.printStackTrace();
		}
		return "success";
	}
	
	public String  ryzc(){
		// 人员注册 - OK
		
		try {
			Qyryskjl setQyryskjl = new Qyryskjl();
			setQyryskjl = (Qyryskjl) this.setClass(setQyryskjl, null);
			
			Qyjbxx qyjbxx = new Qyjbxx();
			qyjbxx.setQybm(setQyryskjl.getQybm());
			
			Qyryxx qyryxx = new Qyryxx();
          	qyryxx.setCyrybh(setQyryskjl.getCyrybh());
          	
          	
        	qyjbxx = qyjbxxService.getQyjbxx(qyjbxx);
        	
			if (qyjbxx != null) {
				int qyid = qyjbxx.getQyid();
			
				try {
					qyryxx = qyryxxService.getQyryxx(qyryxx);
					if (qyryxx != null) {
						int qyrrxxQyid = qyryxx.getQyid();
						if (qyrrxxQyid == qyid) {
							this.result = "success";
						} else {
							qyryxx.setQyid(qyid);
							qyryxxService.updateQyryxx(qyryxx); // 人员注册就是人员场所更新
							this.result = "success";
						}
					} else {
						
						this.result = "从业人员不存在";
					}
				} catch (Exception e) {
				
					this.result = "此人员信息有问题，核查数据库";
				}
			} else {
				
				this.result = "场所不存在";
			}

			
			
		} catch (Exception e) {
			this.result = "注册失败";
			e.printStackTrace();
		}
		return "success";
		

		
		
	}

	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}
		

}
