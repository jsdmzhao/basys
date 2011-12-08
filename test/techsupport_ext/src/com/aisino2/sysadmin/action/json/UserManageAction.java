package com.aisino2.sysadmin.action.json;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.action.PageAction;

@Component
@Scope("prototype")
public class UserManageAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8965936252677047815L;
	
	/**
	 * 用户列表查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception{
		
		return SUCCESS;
	}
	/**
	 * 添加用户
	 * @return
	 * @throws Exception
	 */
	public String add_user() throws Exception{
		return SUCCESS;
	}
	
	/**
	 * 修改用户
	 * @return
	 * @throws Exception
	 */
	public String mod_user() throws Exception{
		return SUCCESS;
	}
	/**
	 * 删除用户
	 * @return
	 * @throws Exception
	 */
	public String remove_user() throws Exception{
		return SUCCESS;
	}
	/**
	 * 用户检查
	 * @return
	 * @throws Exception
	 */
	public String check_user() throws Exception{
		return SUCCESS;
	}
}
