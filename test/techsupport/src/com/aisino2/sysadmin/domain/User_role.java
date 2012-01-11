package com.aisino2.sysadmin.domain;

import com.aisino2.core.domain.BaseObject;

public class User_role  {

	/** @param 用户角色(t_user_role) */

	/** @ --角色ID--roleid--Integer--9-- */
	private Integer roleid;

	/** @ --用户ID--userid--Integer--9-- */
	private Integer userid;

	/** 分页排序 */
	private String pageSort;
	
	/** 角色名称 */
	private String rolename;
	
	/** @ --机构ID-- */
	private Integer departid;

	/** @ --角色描述-- */
	private String roledescription;

	/** @ --角色类别-- */
	private Integer roletype;
	
	/** @ --用户帐号名-- */
	private String useraccount;

	/** @ --用户姓名-- */
	private String username;

	/** @ --用户口令-- */
	private String password;

	/** @ --用户顺序-- */
	private Integer userorder;

	/** @ --是否有效-- */
	private String isvalid;

	/** @ --用户类别-- */
	private String usertype;


	
	 private User user;
	  private Role role;
	
	/** @ 角色ID(roleid) */
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/** @ 用户ID(userid) */
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getDepartid() {
		return departid;
	}

	public void setDepartid(Integer departid) {
		this.departid = departid;
	}

	public String getRoledescription() {
		return roledescription;
	}

	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}

	public Integer getRoletype() {
		return roletype;
	}

	public void setRoletype(Integer roletype) {
		this.roletype = roletype;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserorder() {
		return userorder;
	}

	public void setUserorder(Integer userorder) {
		this.userorder = userorder;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
}
