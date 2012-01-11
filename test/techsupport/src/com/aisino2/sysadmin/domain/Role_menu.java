package com.aisino2.sysadmin.domain;

import com.aisino2.core.domain.BaseObject;

public class Role_menu  {

	/** @param 角色菜单(t_role_menu) */

	/** @ --菜单代码--menucode--String--40-- */
	private String menucode;

	/** @ --角色ID--roleid--Integer--9-- */
	private Integer roleid;

	/** 分页排序 */
	private String pageSort;
	

	private String systemcode;
	
	  private Menu menu;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getSystemcode() {
		return systemcode;
	}

	public void setSystemcode(String systemcode) {
		this.systemcode = systemcode;
	}

	/** @ 菜单代码(menucode) */

	public String getMenucode() {
		return menucode;
	}

	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}

	/** @ 角色ID(roleid) */
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
