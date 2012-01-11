package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Dltj;
import com.aisino2.sysadmin.domain.Loginlog;
import com.aisino2.sysadmin.service.ILoginlogService;

public class LoginlogAction extends PageAction{
	private ILoginlogService loginlogService;
	private List lLoginlog = new ArrayList();
	private Loginlog loginlog;
	private String tabledata;
	private int totalrows;
	private String result="";
	
	private String logNum = "";
	private String logNumAll = "";
	
	private Dltj dltj;
	
	
	public String getLogNumAll() {
		return logNumAll;
	}

	public void setLogNumAll(String logNumAll) {
		this.logNumAll = logNumAll;
	}

	public String getLogNum() {
		return logNum;
	}

	public void setLogNum(String logNum) {
		this.logNum = logNum;
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

	public Loginlog getLoginlog() {
		return loginlog;
	}
	
	public List getLLoginlog() {
		return lLoginlog;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setLoginlogService(ILoginlogService loginlogService) {
		this.loginlogService = loginlogService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("loginlogid");
		lPro.add("useraccount");
		lPro.add("username");
		lPro.add("loginip");
		lPro.add("loginmac");
		lPro.add("logintiime");

    	Loginlog getLoginlog=new Loginlog();
    	
        this.setData(getLoginlog,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Loginlog setLoginlog=new Loginlog();
        try{
        	loginlog = (Loginlog)this.setClass(setLoginlog, null);
        }catch(Exception e){
        	e.printStackTrace();
        }
        Map map = new HashMap();
        
        if(loginlog!=null){
        	if(loginlog.getUseraccount()!=null&&!loginlog.getUseraccount().equals(""))
        		map.put("useraccount", loginlog.getUseraccount());
        	if(loginlog.getUsername()!=null&&!loginlog.getUsername().equals(""))
        		map.put("username", loginlog.getUsername());
        	if(loginlog.getLoginip()!=null&&!loginlog.getLoginip().equals(""))
        		map.put("loginip", loginlog.getLoginip());
        	
        	map.put("logintiimef", loginlog.getLogintiimef());
        	map.put("logintiimet", loginlog.getLogintiimet());
        }
        Page page = loginlogService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lLoginlog=page.getData();
        setTabledata(lLoginlog); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Loginlog setLoginlog=new Loginlog();
			loginlog=(Loginlog)this.setClass(setLoginlog, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        loginlog=loginlogService.getLoginlog(loginlog);
        lLoginlog = new ArrayList();
        lLoginlog.add(loginlog);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Loginlog setLoginlog=new Loginlog();
			loginlog=(Loginlog)this.setClass(setLoginlog, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        loginlog=loginlogService.insertLoginlog(loginlog);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Loginlog setLoginlog=new Loginlog();
			loginlog=(Loginlog)this.setClass(setLoginlog, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        loginlogService.updateLoginlog(loginlog);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Loginlog setLoginlog=new Loginlog();
			loginlog=(Loginlog)this.setClass(setLoginlog, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        loginlogService.deleteLoginlog(loginlog);
        this.result="success";
        return "success";
    }
	
	public String getLoginlogNum() throws Exception{
		
		try {
			Map map = new HashMap();
	        map.put("kssj", new Date());
	        map.put("jssj", new Date());
	        logNum = loginlogService.getLoginlogNum(map);
	        map = new HashMap();
	        logNumAll = loginlogService.getLoginlogNum(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}
	
	/**
	 * 登陆统计的查询方法
	 * @return
	 * @throws Exception
	 */
	public String queryDltjlist() throws Exception {
		
		try {
			Dltj setDltj = new Dltj();
			dltj = (Dltj) this.setClass(setDltj, null);
			
			// 设定参数
			Map map = new HashMap();
			map.put("kssj", dltj.getKssj());
			map.put("jssj", dltj.getJssj());
			map.put("gxdwbm", StringUtil.trimEven0(dltj.getGxdwbm()));
			Page page = loginlogService.getDltjListForPage(map, pagesize, pagerow,sort,dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lLoginlog = page.getData();
			
			Dltj totalNum;
			HttpSession session = ServletActionContext.getRequest().getSession();
			if (dltj.getIsQuery().equals("1")) { // 计算合计值
	        	totalNum = loginlogService.getDltjTotalNum(map);
				session.setAttribute("totalNum", totalNum);
			} else { // 分页操作，合计值直接从session中取
				totalNum = (Dltj) session.getAttribute("totalNum");
			}
			lLoginlog.add(0,totalNum);	
			setTabledataDltj(lLoginlog);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 this.result="";
		     return "success";
		} 
		
		this.result="success";
        return "success";
		
	}
	
	public void setTabledataDltj(List lData) throws Exception {
		
		List lPro = new ArrayList();
		lPro.add("departbrevitycode");
		lPro.add("departname");
		lPro.add("dlzs");
		
		Dltj dltj = new Dltj();
		
		this.setData(dltj, lData, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	
	}
}