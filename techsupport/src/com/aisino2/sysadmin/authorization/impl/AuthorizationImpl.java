package com.aisino2.sysadmin.authorization.impl;

import javax.servlet.http.HttpServletRequest;

import com.aisino2.core.web.Authorization;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.authorization.IFunctionAuthorization;
import com.aisino2.sysadmin.domain.User;

public class AuthorizationImpl implements Authorization {

	private IFunctionAuthorization functionAuthorization;


	public String getUserSessionKey() {
		return Constants.userKey;
	}

	public int getUserID(HttpServletRequest request) {
		int userID=-1;
		User user = (User)request.getSession().getAttribute(Constants.userKey);
		if (user != null)
			userID = user.getUserid();
		return userID;
	}

	public boolean hasFunction(int userID, String functionDefine) {
		return functionAuthorization.checkFunction(userID,functionDefine);
	}

	public String getFunctionParam(int userID, String functionDefine) {
		return functionAuthorization.getParam(userID,functionDefine);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public IFunctionAuthorization getFunctionAuthorization() {
		return functionAuthorization;
	}

	public void setFunctionAuthorization(IFunctionAuthorization functionAuthorization) {
		this.functionAuthorization = functionAuthorization;
	}

}
