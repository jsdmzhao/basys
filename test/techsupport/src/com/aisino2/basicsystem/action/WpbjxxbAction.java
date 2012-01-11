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

import com.aisino2.basicsystem.domain.Wpbjxxb;
import com.aisino2.basicsystem.service.IWpbjxxbService;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class WpbjxxbAction extends PageAction{
	private IWpbjxxbService wpbjxxbService;
	private List lWpbjxxb = new ArrayList();
	private List lDdxx = new ArrayList();
	private Wpbjxxb wpbjxxb = new Wpbjxxb();
	private String tabledata = "";
	private int totalrows = 0;
	private String result = "";
	private Integer recordNum;
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Wpbjxxb getWpbjxxb() {
		return wpbjxxb;
	}
	
	public List getLWpbjxxb() {
		return lWpbjxxb;
	}
	
	public List getLDdxx() {
		return lDdxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setWpbjxxbService(IWpbjxxbService wpbjxxbService) {
		this.wpbjxxbService = wpbjxxbService;
	}
	
	public Integer getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(Integer recordNum) {
		this.recordNum = recordNum;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjxxid2");
		lPro.add("wpmc");
		lPro.add("ssqymc");
		lPro.add("gxdwmc");
		lPro.add("bjsj");
		lPro.add("bjlxdm");
		lPro.add("bjlx");
		lPro.add("jqzt");
		lPro.add("chjjg");

		List lCol=new ArrayList();
		
		List lTsclXbj = new ArrayList();
		lTsclXbj.add("");// 链接ID开头
		lTsclXbj.add("新报警"); // 链接显示文字

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
		//lWhereHf.add("sfyxbj");
		lWhereHf.add("jqzt");
		lWhereHf.add("gxdwmc");

		List lWhereCk = new ArrayList();// 查看
		//lWhereCk.add("sfyxbj");
		lWhereCk.add("jqzt");
		lWhereCk.add("gxdwmc");

		List lWhereWxbj = new ArrayList();// 无效报警
		//lWhereWxbj.add("sfyxbj");
		lWhereWxbj.add("jqzt");

		// 比对值
		List lWhereXbjValue = new ArrayList();
		lWhereXbjValue.add("新报警");

		List lWhereHfValue = new ArrayList();
		//lWhereHfValue.add("是");
		lWhereHfValue.add("未回复报警");
		lWhereHfValue.add(getUserDeptName());

		List lWhereCkValue = new ArrayList();
		//lWhereCkValue.add("是");
		lWhereCkValue.add("已回复报警");
		lWhereCkValue.add(getUserDeptName());

		List lWhereWxbjValue = new ArrayList();
		//lWhereWxbjValue.add("否");
		lWhereWxbjValue.add("");

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
    	
		lCol.add(lTsclXbj);
		lCol.add(lTsclHf);
		lCol.add(lTsclCk);
		lCol.add(lTsclWxbj);
    	
    	Wpbjxxb getWpbjxxb=new Wpbjxxb();
    	
        this.setData(getWpbjxxb,lData,lPro,lCol);
        this.setDataCustomer(getWpbjxxb, lData, lPro, null, lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Wpbjxxb setWpbjxxb = new Wpbjxxb();
        Map map = new HashMap();
        try{
        	wpbjxxb = (Wpbjxxb)this.setClass(setWpbjxxb, null);
        	
        	//根据登陆用户 设置查询条件  只能查询本部门和所属部门的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
			User user= (User)session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
			map.put("gxdwbm1", depertCode0);
			// 如果选择了姓名拼音的同音查询，则需要得到姓名的拼音
			if ("1".equals(wpbjxxb.getTyCheck())) {
				map.put("wpqp", PinYinUtil.getHanyuPingYinInitial(wpbjxxb.getWpmc()));
				map.put("wpmc", "");
			} else{
				map.put("wpmc", wpbjxxb.getWpmc());
			}
			// 行业类别
			map.put("hylbdm", wpbjxxb.getHylbdm());
			// 企业名称
			map.put("ssqymc", wpbjxxb.getSsqymc());
			// 处警结果
			map.put("cjjgdm", wpbjxxb.getCjjgdm());
			// 报警时间开始
			map.put("bjsjks", wpbjxxb.getBjsjks());
			// 报警时间结束
			map.put("bjsjjs", wpbjxxb.getBjsjjs());
			// 出警时间开始
			map.put("chjsjks", wpbjxxb.getChjsjks());
			// 出警时间结束
			map.put("chjsjjs", wpbjxxb.getChjsjjs());
        	// 所属单位
			map.put("gxdwbm", wpbjxxb.getGxdwbm());
			// 警情是否有效
			map.put("sfyxbjdm", wpbjxxb.getSfyxbjdm());
			// 报警类别
			map.put("bjlxdm", wpbjxxb.getBjlxdm());
			
        	Page page = wpbjxxbService.getListForPage(map, pagesize, pagerow,sort,dir);
            totalpage=page.getTotalPages();
            totalrows=page.getTotalRows();
            lWpbjxxb=page.getData();
            setTabledata(lWpbjxxb); 
    		this.result="success";
        } catch(Exception e){
        	// TODO Auto-generated catch block
			e.printStackTrace();
        	this.result="";
        }
        
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Wpbjxxb setWpbjxxb=new Wpbjxxb();
			wpbjxxb = (Wpbjxxb)this.setClass(setWpbjxxb, null);
            wpbjxxb = wpbjxxbService.getWpbjxxb(wpbjxxb);
            
            // 是否确认报警
            if(wpbjxxb.getSfyxbj() != null && !wpbjxxb.getSfyxbj().equals("")){
            	wpbjxxb.setShow_sfqrbj("是");
            } else{
            	wpbjxxb.setShow_sfqrbj("否");
            }            
            // 是否出警    
            if(wpbjxxb.getSfyxbj() != null && wpbjxxb.getSfyxbj().equals("1")){
            	wpbjxxb.setShow_sfcj("是");
            	 // 是否漏网    
                if(wpbjxxb.getCjjgdm() != null && wpbjxxb.getCjjgdm().equals("1")){
                	wpbjxxb.setShow_sflw("否");
                } else{
                	wpbjxxb.setShow_sflw("是");
                }
            } else{
            	wpbjxxb.setShow_sfcj("否");
            }
            // 是否撤销    
            if(wpbjxxb.getWxyy() != null && !wpbjxxb.getWxyy().equals("")){
            	wpbjxxb.setShow_sfcx("是");
            } else{
            	wpbjxxb.setShow_sfcx("否");
            }  
            // 撤销时间 
            if(wpbjxxb.getShow_sfcx().equals("是")){
            	wpbjxxb.setShow_cxsj(wpbjxxb.getPjsj());
            }
            
            if (lWpbjxxb == null){
            	lWpbjxxb = new ArrayList();
            } else{
    			lWpbjxxb.clear();
    		}
            lWpbjxxb.add(wpbjxxb);
		    this.result = "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = "";
		}
        return "success";
    }
	
	public String queryCjhf() throws Exception {
		try {
			Wpbjxxb setWpbjxxb=new Wpbjxxb();
			wpbjxxb = (Wpbjxxb)this.setClass(setWpbjxxb, null);
			
			wpbjxxb = wpbjxxbService.getWpbjxxb(wpbjxxb);

			Globalpar gp = this.getCacheGlobalpar("cjhfModifyExpiredTime");
			String cjhfModifyExpiredTime = gp.getGlobalparvalue();

			wpbjxxb.setCanModify(canModify(wpbjxxb.getFkrq(), cjhfModifyExpiredTime));// 设定是否可以修改

			lWpbjxxb.clear();
			lWpbjxxb.add(wpbjxxb);
			this.result = "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = "";
		}
		return "success";
	}
	
	public String xbjUpdate() throws Exception {
		try {
			Wpbjxxb setWpbjxxb=new Wpbjxxb();
			wpbjxxb = (Wpbjxxb) this.setClass(setWpbjxxb, null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 派警时间
		wpbjxxb.setPjsj(new Date());
		
		if(wpbjxxb.getGxdwbm() != null && wpbjxxb.getGxdwbm().equals("")){
			wpbjxxb.setGxdwbm(null);
			wpbjxxb.setGxdwmc(null);
		}

		wpbjxxbService.updateWpbjxxb(wpbjxxb);
		this.result = "success";
		return "success";
	}
	
	public String cjhfUpdate() throws Exception {
		try {
			Wpbjxxb setWpbjxxb=new Wpbjxxb();
			wpbjxxb = (Wpbjxxb) this.setClass(setWpbjxxb, null);
			wpbjxxb.setFkrq(new Date());
			//wpbjxxb.setGxbbh(wpbjxxb.getGxbbh().intValue() + 1);// 更新版本号自增1
			if (wpbjxxb.getChjjg().equals("未抓获")) {
				wpbjxxb.setZhsj(null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wpbjxxbService.updateWpbjxxb(wpbjxxb);
		this.result = "success";
		return "success";
	}
	
	public String insert() throws Exception{
		try {
			Wpbjxxb setWpbjxxb=new Wpbjxxb();
			wpbjxxb=(Wpbjxxb)this.setClass(setWpbjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjxxb=wpbjxxbService.insertWpbjxxb(wpbjxxb);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Wpbjxxb setWpbjxxb=new Wpbjxxb();
			wpbjxxb=(Wpbjxxb)this.setClass(setWpbjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjxxbService.updateWpbjxxb(wpbjxxb);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Wpbjxxb setWpbjxxb=new Wpbjxxb();
			wpbjxxb=(Wpbjxxb)this.setClass(setWpbjxxb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        wpbjxxbService.deleteWpbjxxb(wpbjxxb);
        this.result="success";
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
	
	public String getUserDeptName() { // type 1:简项 type 2:全项
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();

		// 取得用户和所在部门信息
		User user = (User) session.getAttribute(Constants.userKey);
		Department userDepartment = user.getDepartment();
		return userDepartment.getDepartname();

	}
	
	public String queryForExport() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		session.removeAttribute("wpbjxxbExportResult");
		User user= (User)session.getAttribute(Constants.userKey);
		Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
		String maxRows = glo.getGlobalparvalue();
		try {
			Wpbjxxb setWpbjxxb = new Wpbjxxb();
			setWpbjxxb =(Wpbjxxb)this.setClass(setWpbjxxb, null);
	        Map map = new HashMap();
	        String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
			map.put("gxdwbm1", depertCode0);
			// 如果选择了姓名拼音的同音查询，则需要得到姓名的拼音
			if ("1".equals(setWpbjxxb.getTyCheck())) {
				map.put("wpjp", PinYinUtil.getHanyuPingYinInitial(setWpbjxxb.getWpmc()));
				map.put("wpmc", "");
			} else{
				map.put("wpmc", setWpbjxxb.getWpmc());
			}
			// 行业类别
			map.put("hylbdm", setWpbjxxb.getHylbdm());
			// 企业名称
			map.put("ssqymc", setWpbjxxb.getSsqymc());
			// 处警结果
			map.put("cjjgdm", setWpbjxxb.getCjjgdm());
			// 报警时间开始
			map.put("bjsjks", setWpbjxxb.getBjsjks());
			// 报警时间结束
			map.put("bjsjjs", setWpbjxxb.getBjsjjs());
			// 出警时间开始
			map.put("chjsjks", setWpbjxxb.getChjsjks());
			// 出警时间结束
			map.put("chjsjjs", setWpbjxxb.getChjsjjs());
        	// 所属单位
			map.put("gxdwbm", setWpbjxxb.getGxdwbm());
			// 警情是否有效
			map.put("sfyxbjdm", setWpbjxxb.getSfyxbjdm());
			// 报警类别
			map.put("bjlxdm", setWpbjxxb.getBjlxdm());
			map.put("endRow", maxRows);
			// Excel输出
			Page page = wpbjxxbService.getListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("wpbjxxbExportResult", page.getData());
			this.result = "success";
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
			//tabletitle = java.net.URLEncoder.encode(tabletitle,"UTF-8");
			// Excel输出
			List lResult = new ArrayList();//开头excel
			List wpbjxxbList = (List) session.getAttribute("wpbjxxbExportResult");
			Wpbjxxb getWpbjxxb = new Wpbjxxb();
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add(wpbjxxbList);
			lResult.add(getWpbjxxb);
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
}