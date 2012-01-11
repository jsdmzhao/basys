package com.aisino2.sysadmin.authorization.impl;

import java.util.Map;

import com.aisino2.sysadmin.authorization.IIdentityAuthorization;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IUserService;

public class IdentityAuthorizationImpl implements IIdentityAuthorization {
	  private IUserService userService;
	public Object getUser(String account, String passWord) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUseraccount(account);
		user = userService.checkUser(user);
		if(user!=null){
			String password = user.getPassword();
			if(password == null)
				password = "";
			//if(password.equals(EncryptUtil.getMD5Code(passWord)))
			if(password.equals(passWord))
				return user;
		}
		return null;
	}

	public Object getUser(Map paramMap) {
		// TODO Auto-generated method stub
		String account = String.valueOf(paramMap.get("account"));
		String passWord = String.valueOf(paramMap.get("passWord"));
		return getUser(account,passWord);
	}

	public boolean userIsExist(String account, String passWord) {
		// TODO Auto-generated method stub
		if(getUser(account,passWord)!=null)
			return true;
		return false;
	}

	public boolean userIsExist(Map paramMap) {
		// TODO Auto-generated method stub
		String account = String.valueOf(paramMap.get("account"));
		String passWord = String.valueOf(paramMap.get("passWord"));
		if(getUser(account,passWord)!=null)
			return true;
		return false;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	

	public Object getUserAcc(String account) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUseraccount(account);
		user = userService.checkUser(user);
		if(user!=null){
			return user;
		}
		return null;
	}



}
