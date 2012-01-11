package com.aisino2.sysadmin.domain;

import java.util.List;
import java.util.Map;

import com.aisino2.core.domain.BaseObject;

public class Role  {

	/** @param 角色(t_role) */

	/** @ --角色ID--roleid--Integer--9-- */
	private Integer roleid;

	/** @ --机构ID--departid--Integer--9-- */
	private Integer departid;

	/** @ --角色名称--rolename--String--50-- */
	private String rolename;

	/** @ --角色描述--roledescription--String--100-- */
	private String roledescription;

	/** @ --角色类别--roletype--Integer--1-- */
	private Integer roletype;

	/** 分页排序 */
	private String pageSort;
	
	/** 移动方式 */
	private String way;
	
	/**选中菜单*/
	private String menucode;
	
	/** 角色ID串 */
	private String roleidString;
	
	/** 部门名称 */
	private String departname;

	/** 部门代码 */
	private String departcode;
	
	/** 筛选字段*/
	private String query_simplepin;
	
	
	private Department department;
	private List roleFunctions;
	private List roleUsers;
	private List roleMenus;
	private List lUserRoleList;

private String systemcode;  

private String roleNameType = "0";

/**设置复选框的属性*/
private String checkbox;

	/** 角色-菜单 */
	private List<Role_menu> lRoleMenu;
	
	/** 角色-功能 */
	private List<Role_func> lRoleFunc;

	/**存储角色菜单,key:系统code,value:系统下的菜单*/
	private Map roleMenuMap;
	
	private String jzlbdm;
	private String jzlbmc;

	public Map getRoleMenuMap() {
		return roleMenuMap;
	}

	public void setRoleMenuMap(Map roleMenuMap) {
		this.roleMenuMap = roleMenuMap;
	}

	public String getRoleNameType() {
		return roleNameType;
	}

	public void setRoleNameType(String roleNameType) {
		this.roleNameType = roleNameType;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public String getMenucode() {
		return menucode;
	}

	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}
	

	public String getSystemcode() {
	return systemcode;
}

public void setSystemcode(String systemcode) {
	this.systemcode = systemcode;
}

	/** @ 角色ID(roleid) */
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/** @ 机构ID(departid) */
	public Integer getDepartid() {
		return departid;
	}

	public void setDepartid(Integer departid) {
		this.departid = departid;
	}

	/** @ 角色名称(rolename) */
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/** @ 角色描述(roledescription) */
	public String getRoledescription() {
		return roledescription;
	}

	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}

	/** @ 角色类别(roletype) */
	public Integer getRoletype() {
		return roletype;
	}

	public void setRoletype(Integer roletype) {
		this.roletype = roletype;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List getRoleFunctions() {
		return roleFunctions;
	}

	public void setRoleFunctions(List roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	public List getRoleUsers() {
		return roleUsers;
	}

	public void setRoleUsers(List roleUsers) {
		this.roleUsers = roleUsers;
	}

	public List getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(List roleMenus) {
		this.roleMenus = roleMenus;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public List<Role_menu> getLRoleMenu() {
		return lRoleMenu;
	}

	public void setLRoleMenu(List<Role_menu> roleMenu) {
		lRoleMenu = roleMenu;
	}

	public List<Role_func> getLRoleFunc() {
		return lRoleFunc;
	}

	public void setLRoleFunc(List<Role_func> roleFunc) {
		lRoleFunc = roleFunc;
	}

	public String getRoleidString() {
		return roleidString;
	}

	public void setRoleidString(String roleidString) {
		this.roleidString = roleidString;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	public String getDepartcode() {
		return departcode;
	}

	public void setDepartcode(String departcode) {
		this.departcode = departcode;
	}

	public List getLUserRoleList() {
		return lUserRoleList;
	}

	public void setLUserRoleList(List userRoleList) {
		lUserRoleList = userRoleList;
	}

	public String getQuery_simplepin() {
		return query_simplepin;
	}

	public void setQuery_simplepin(String query_simplepin) {
		this.query_simplepin = query_simplepin;
	}

	public String getJzlbdm() {
		return jzlbdm;
	}

	public void setJzlbdm(String jzlbdm) {
		this.jzlbdm = jzlbdm;
	}

	public String getJzlbmc() {
		return jzlbmc;
	}

	public void setJzlbmc(String jzlbmc) {
		this.jzlbmc = jzlbmc;
	}
}
