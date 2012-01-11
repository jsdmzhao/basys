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
import com.aisino2.icksystem.domain.Qyryskxxtj;
import com.aisino2.icksystem.service.IQyryskxxtjService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;

public class QyryskxxtjAction extends PageAction{
	private IQyryskxxtjService qyryskxxtjService;
	private List lQyryskxxtj;
	private Qyryskxxtj qyryskxxtj;
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

	public Qyryskxxtj getQyryskxxtj() {
		return qyryskxxtj;
	}
	
	public List getLQyryskxxtj() {
		return lQyryskxxtj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyryskxxtjService(IQyryskxxtjService qyryskxxtjService) {
		this.qyryskxxtjService = qyryskxxtjService;
	}
	
	public void setTabledata(List lData,Qyryskxxtj setQyryskxxtj) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qybm");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("kh");
		lPro.add("sksj");
		if("ry".equals(setQyryskxxtj.getCsOrryFlag())){
			lPro.add("qymc");
		}
		lPro.add("gxdwmc");
		
    	List lCol=new ArrayList();
    	
    	Qyryskxxtj getQyryskxxtj=new Qyryskxxtj();
    	
        this.setData(getQyryskxxtj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 频繁变换场所请求列表
	 * 
	 * @param lData
	 * @throws Exception
	 */
	public void setTabledataPfbhcs(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("ryid");
		lPro.add("cyrybh");
		lPro.add("xm");
		lPro.add("zjhm");
		lPro.add("bhNum");

		List lModify = new ArrayList();
		lModify.add("setCyryCygj");
		lModify.add("从业轨迹");

		List lCol = new ArrayList();
		lCol.add(lModify);

		Qyryskxxtj getQyryskxxtj=new Qyryskxxtj();
		
		this.setData(getQyryskxxtj, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	public String querylist() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Qyryskxxtj setQyryskxxtj = new Qyryskxxtj();
			setQyryskxxtj = (Qyryskxxtj)this.setClass(setQyryskxxtj, null);
			Map map = new HashMap();
			map.put("gxdwdm", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			map.put("xm", setQyryskxxtj.getXm());
			map.put("cyrybh", setQyryskxxtj.getCyrybh());
			map.put("wgrjyxkz", setQyryskxxtj.getWgrjyxkz());
			map.put("qssj", setQyryskxxtj.getQssj());
			map.put("jzsj", setQyryskxxtj.getJzsj());
			map.put("zjhm", setQyryskxxtj.getZjhm());
			map.put("kh", setQyryskxxtj.getKh());
			map.put("qybm", setQyryskxxtj.getQybm());
			Page page = qyryskxxtjService.getStatistics(map, pagesize, pagerow,sort,dir);
			
			List list = page.getData();
			List listTemp = new ArrayList();
			if(list!=null&&list.size()>0){
				for(int index=0,max=list.size();index<max;index++){
					Qyryskxxtj qyryskxxtjTemp = (Qyryskxxtj)list.get(index);
					//qyryskxxtjTemp.setQybm(qyryskxxtjTemp.getCyrylbdm()+"___"+qyryskxxtjTemp.getRyid()+"---"+qyryskxxtjTemp.getQyid());
					qyryskxxtjTemp.setQybm(qyryskxxtjTemp.getCyrylbdm()+"___"+qyryskxxtjTemp.getRyid());
					listTemp.add(qyryskxxtjTemp);
				}
			}
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledata(listTemp,setQyryskxxtj); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	public String querylistExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Qyryskxxtj setQyryskxxtj = new Qyryskxxtj();
			setQyryskxxtj = (Qyryskxxtj)this.setClass(setQyryskxxtj, null);
			Map map = new HashMap();
			map.put("gxdwdm", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			map.put("xm", setQyryskxxtj.getXm());
			map.put("cyrybh", setQyryskxxtj.getCyrybh());
			map.put("wgrjyxkz", setQyryskxxtj.getWgrjyxkz());
			map.put("qssj", setQyryskxxtj.getQssj());
			map.put("jzsj", setQyryskxxtj.getJzsj());
			map.put("zjhm", setQyryskxxtj.getZjhm());
			map.put("kh", setQyryskxxtj.getKh());
			map.put("qybm", setQyryskxxtj.getQybm());
			
			Page page = qyryskxxtjService.getStatistics(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("skxxtjRyList", page.getData());
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
			Qyryskxxtj setQyryskxxtj = new Qyryskxxtj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("skxxtjRyList"));
			lResult.add(setQyryskxxtj);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	public String query() throws Exception{
		try {
			Qyryskxxtj setQyryskxxtj=new Qyryskxxtj();
			qyryskxxtj=(Qyryskxxtj)this.setClass(setQyryskxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryskxxtj=qyryskxxtjService.getQyryskxxtj(qyryskxxtj);
        lQyryskxxtj.clear();
        lQyryskxxtj.add(qyryskxxtj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyryskxxtj setQyryskxxtj=new Qyryskxxtj();
			qyryskxxtj=(Qyryskxxtj)this.setClass(setQyryskxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryskxxtj=qyryskxxtjService.insertQyryskxxtj(qyryskxxtj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyryskxxtj setQyryskxxtj=new Qyryskxxtj();
			qyryskxxtj=(Qyryskxxtj)this.setClass(setQyryskxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryskxxtjService.updateQyryskxxtj(qyryskxxtj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyryskxxtj setQyryskxxtj=new Qyryskxxtj();
			qyryskxxtj=(Qyryskxxtj)this.setClass(setQyryskxxtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryskxxtjService.deleteQyryskxxtj(qyryskxxtj);
        this.result="success";
        return "success";
    }
	/**
	 * 频繁变换场所查询
	 * @return
	 * @throws Exception
	 */
	public String querylistPfbhcs() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			
			Qyryskxxtj setQyryskxxtj = new Qyryskxxtj();
			setQyryskxxtj = (Qyryskxxtj)this.setClass(setQyryskxxtj, null);
			Map map = new HashMap();
			
			map.put("bhNum", setQyryskxxtj.getBhNum());
			map.put("flg", setQyryskxxtj.getFlg());
			map.put("qssj", setQyryskxxtj.getQssj());
			map.put("jzsj", setQyryskxxtj.getJzsj());
			//map.put("hylbdm", setQyryskxxtj.getHylbdm());
			if(setQyryskxxtj.getGxdwbm()!=null&&!"".equals(setQyryskxxtj.getGxdwbm())){
				map.put("gxdwbm", StringUtil.trimEven0(setQyryskxxtj.getGxdwbm()));
			}else{
				map.put("gxdwbm", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			}
			
			Page page = qyryskxxtjService.getPfbhcsForPage(map, pagesize, pagerow,sort,dir);
			List lis=page.getData();
			for(int i=0;i<lis.size();i++){
				Qyryskxxtj QyryskxxtjTemp = (Qyryskxxtj)lis.get(i);
				String cyrylb="<input type='hidden' id='cyrylb' value='"+QyryskxxtjTemp.getCyrylbdm()+"'>";
				QyryskxxtjTemp.setBhNum(QyryskxxtjTemp.getBhNum()+cyrylb);
			}
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledataPfbhcs(lis); 
			
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	public String querylistPfbhcsExcelTemp() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Qyryskxxtj setQyryskxxtj = new Qyryskxxtj();
			setQyryskxxtj = (Qyryskxxtj)this.setClass(setQyryskxxtj, null);
			Map map = new HashMap();
			
			map.put("bhNum", setQyryskxxtj.getBhNum());
			map.put("flg", setQyryskxxtj.getFlg());
			map.put("qssj", setQyryskxxtj.getQssj());
			map.put("jzsj", setQyryskxxtj.getJzsj());
			map.put("hylbdm", setQyryskxxtj.getHylbdm());
			if(setQyryskxxtj.getGxdwbm()!=null&&!"".equals(setQyryskxxtj.getGxdwbm())){
				map.put("gxdwbm", StringUtil.trimEven0(setQyryskxxtj.getGxdwbm()));
			}else{
				map.put("gxdwbm", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
			}
			Page page = qyryskxxtjService.getPfbhcsForPage(map, 1, Integer.parseInt(maxRows),null,null);
			 session.setAttribute("pfbhcstjxxList", page.getData());
			List lis=page.getData();
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledataPfbhcs(lis); 
			
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	public void querylistPfbhcsExcel() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Qyryskxxtj setQyryskxxtj = new Qyryskxxtj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			
			List lColumn = this.getExcelColumn(tabletitle);
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("pfbhcstjxxList"));
			session.removeAttribute("pfbhcstjxxList");
			lResult.add(setQyryskxxtj);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
			
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
}