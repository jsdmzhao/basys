package com.aisino2.sysadmin.authorization.impl;

import java.util.List;

import com.aisino2.sysadmin.authorization.IFunctionAuthorization;
import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.service.IFunctionService;
import com.aisino2.sysadmin.service.IRole_funcService;

public class FunctionAuthorizationImpl implements IFunctionAuthorization {
	private IFunctionService functionService;
	private  IRole_funcService  role_funcService;
	public IRole_funcService getRole_funcService() {
		return role_funcService;
	}

	public void setRole_funcService(IRole_funcService role_funcService) {
		this.role_funcService = role_funcService;
	}

	public List getOwnFunction(int userID, String systemID) {
		// TODO Auto-generated method stub
		Function function = new Function();
		function.setUserid(userID);
		function.setSystemcode(systemID);
		return functionService.getOwnFunction(function);
		
	}

	public String getParam(int userID, String funcDefine) {
		// TODO Auto-generated method stub
		Role_func role_func = new Role_func();
		role_func.setUserid(userID);
		role_func.setFuncdefine(funcDefine);
		List lst=role_funcService.getParam(role_func);
		Object param=lst!=null ?lst.get(0):null;
		return param!=null ?(String)param:null;
	}

	public IFunctionService getFunctionService() {
		return functionService;
	}

	public void setFunctionService(IFunctionService functionService) {
		this.functionService = functionService;
	}

	public boolean checkFunction(int userID, String funcDefine) {
		// TODO Auto-generated method stub
		Function function = new Function();
		function.setUserid(userID);
		function.setFuncdefine(funcDefine);
		return !functionService.findFuncDefine(function)||functionService.checkFunction(function);
	}


}
