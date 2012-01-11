package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.aisino2.common.PageUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.service.IFunctionService;
import com.aisino2.sysadmin.service.ISystemService;

public class FunctionAction extends PageAction{
	private IFunctionService functionService;
	private ISystemService systemService;
	private List lFunction;
	private Function function;
	private String tabledata;
	private int totalrows;
	private String result="";
	private String strResult;
	private String[] typename = {"内保单位","保安","娱乐","旅馆",
			"印章","类别6","类别7","类别8",
			"类别9","类别10","类别11","类别12",
			"类别13","类别14","类别15","类别16"};
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Function getFunction() {
		return function;
	}
	
	public List getLFunction() {
		return lFunction;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setFunctionService(IFunctionService functionService) {
		this.functionService = functionService;
	}
	
	public void setSystemService(ISystemService systemService) {
		this.systemService = systemService;
	}

	public String getStrResult() {
		return strResult;
	}

	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("funccode");
		lPro.add("funccode");
		lPro.add("funcname");
		lPro.add("functypename");
//		lPro.add("functype");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Function getFunction=new Function();
    	
        this.setData(getFunction,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public String queryFunction(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String systemcode = request.getParameter("systemcode");
		if(systemcode==null||"".equals(systemcode)){
			systemcode = "";
		}
		request.setAttribute("systemcode", systemcode);
		return SUCCESS;
	}
	
/*role_func系统树导航*/
	public String queryFuncForRole(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String systemcode = request.getParameter("systemcode");
		if(systemcode==null||"".equals(systemcode)){
			systemcode = "";
		}
		request.setAttribute("systemcode", systemcode);
		return "roleFunc";
	}
	
	public String querylist() throws Exception{
		try {
			Function setFunction=new Function();
			function=(Function)this.setClass(setFunction, null);
			Map map = new HashMap();
			map.put("funccode", function.getFunccode());
			map.put("funcname", function.getFuncname());
			map.put("systemcode", function.getSystemcode());
			Page page = functionService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			lFunction=page.getData();
			List listtemp = new ArrayList();
			if(lFunction!=null&&lFunction.size()>0){
				for(int index=0,max=lFunction.size();index<max;index++){
					Function temp = (Function)lFunction.get(index);
					if(temp!=null&&temp.getFunctype()!=null){
						temp.setFunctypename(typename[temp.getFunctype()-1]);
					}
					listtemp.add(temp);
				}
			}
			setTabledata(listtemp);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Function setFunction=new Function();
			function=(Function)this.setClass(setFunction, null);
			function=functionService.getFunction(function);
			if(function!=null&&function.getFunctype()!=null){
				function.setFunctypename(typename[function.getFunctype()-1]);
			}
			lFunction = new ArrayList();
			lFunction.add(function);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Function setFunction=new Function();
			function=(Function)this.setClass(setFunction, null);
			function=functionService.insertFunction(function);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Function setFunction=new Function();
			function=(Function)this.setClass(setFunction, null);
			functionService.updateFunction(function);
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
			Function setFunction=new Function();
			function=(Function)this.setClass(setFunction, null);
			functionService.deleteFunction(function);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	public String validateFunction(){
		try {
			Function setFunction=new Function();
			function=(Function)this.setClass(setFunction, null);
			String funccode = function.getFunccode();
			Map map = new HashMap();
			map.put("tableName", "t_function");
			if(funccode!=""){
				map.put("funccode", funccode);
			}
			boolean result = systemService.isExit(map);
			strResult = "";
			if(result){	
				strResult = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
	}
	
	public String checkFunction() throws Exception{
		try {
			if(result.equals("") || result.equals("0")){
				//验证单个功能权限
				this.result = PageUtil.checkFunction(dataxml)?"success":"failure";
				
			}else{
				//验证多个功能权限
				String[] functionArray = dataxml.split(",");
				lFunction = PageUtil.checkFunctionList(functionArray);
			}
			if(lFunction==null)lFunction = new ArrayList();
		} catch (Exception e) {
				e.printStackTrace();
				this.result="failure";
				return "success";
		}
			return "success";
	}
}