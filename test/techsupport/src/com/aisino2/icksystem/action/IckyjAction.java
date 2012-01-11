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
import com.aisino2.icksystem.domain.Ickyj;
import com.aisino2.icksystem.service.IIckyjService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;

public class IckyjAction extends PageAction{
	private IIckyjService ickyjService;
	private List lIckyj;
	private Ickyj ickyj;
	private String tabledata;
	private int totalrows;
	private String result="";
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Ickyj getIckyj() {
		return ickyj;
	}
	
	public List getLIckyj() {
		return lIckyj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setIckyjService(IIckyjService ickyjService) {
		this.ickyjService = ickyjService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bds");
		lPro.add("xm");
		lPro.add("cyrybh");
		lPro.add("sksj");
		lPro.add("sxsj");
		lPro.add("qymc");
		lPro.add("gxdwmc");

    	List lCol=new ArrayList();
    	Ickyj getIckyj=new Ickyj();
        this.setData(getIckyj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Ickyj setIckyj = new Ickyj();
			setIckyj = (Ickyj)this.setClass(setIckyj, null);
			Map map = new HashMap();
			map.put("hylbdm", setIckyj.getHylbdm());
			map.put("qymc", setIckyj.getQymc());
			map.put("sksjf", setIckyj.getSksjf());
			map.put("sksjt", setIckyj.getSksjt());
			map.put("fkflag", "1");//不查询假卡
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User) session.getAttribute(Constants.userKey);
			map.put("gxdwdm", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			Page page = ickyjService.getListForPage(map, pagesize, pagerow,sort,dir);
			
			List list = page.getData();
			List listTemp = new ArrayList();
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Ickyj ickyjTemp = (Ickyj)list.get(index);
					ickyjTemp.setBds(ickyjTemp.getIckyjid()+"___"+ickyjTemp.getQyid()+"---"+ickyjTemp.getHylbdm());
					listTemp.add(ickyjTemp);
				}
			}
			
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledata(listTemp); 
			this.result="success";
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
    }
	public String querylistExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Ickyj setIckyj = new Ickyj();
			setIckyj = (Ickyj)this.setClass(setIckyj, null);
			Map map = new HashMap();
			map.put("hylbdm", setIckyj.getHylbdm());
			map.put("qymc", setIckyj.getQymc());
			map.put("sksjf", setIckyj.getSksjf());
			map.put("sksjt", setIckyj.getSksjt());
			map.put("fkflag", "1");//不查询假卡
			User user = (User) session.getAttribute(Constants.userKey);
			map.put("gxdwdm", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			Page page = ickyjService.getListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			
			List list = page.getData();
			List listTemp = new ArrayList();
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Ickyj ickyjTemp = (Ickyj)list.get(index);
					ickyjTemp.setBds(ickyjTemp.getIckyjid()+"___"+ickyjTemp.getQyid()+"---"+ickyjTemp.getHylbdm());
					listTemp.add(ickyjTemp);
				}
			}
			session.setAttribute("ickyjList", listTemp);
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	public void querylistExcel() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Ickyj setIckyj = new Ickyj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("ickyjList"));
			lResult.add(setIckyj);
			this.setExcelCreate("fileName",lResult); //ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	public String query() throws Exception{
		try {
			Ickyj setIckyj=new Ickyj();
			ickyj=(Ickyj)this.setClass(setIckyj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ickyj=ickyjService.getIckyj(ickyj);
        lIckyj.clear();
        lIckyj.add(ickyj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Ickyj setIckyj=new Ickyj();
			ickyj=(Ickyj)this.setClass(setIckyj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ickyj=ickyjService.insertIckyj(ickyj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Ickyj setIckyj=new Ickyj();
			ickyj=(Ickyj)this.setClass(setIckyj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ickyjService.updateIckyj(ickyj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Ickyj setIckyj=new Ickyj();
			ickyj=(Ickyj)this.setClass(setIckyj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ickyjService.deleteIckyj(ickyj);
        this.result="success";
        return "success";
    }
}