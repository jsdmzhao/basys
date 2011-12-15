package com.aisino2.sysadmin.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


class RoleMenuPk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4724390669933713741L;
	private String menucode;
	private Integer roleid;
	public String getMenucode() {
		return menucode;
	}
	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
}
@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@Table(name="t_role_menu")
@IdClass(RoleMenuPk.class)
public class Role_menu implements Serializable {

	/** @param 角色菜单(t_role_menu) */

	private RoleMenuPk id;
	@Id
	/** @ --菜单代码--menucode--String--40-- */
	private String menucode;
	@Id
	/** @ --角色ID--roleid--Integer--9-- */
	private Integer roleid;
	
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

	public RoleMenuPk getId() {
		return id;
	}

	public void setId(RoleMenuPk id) {
		this.id = id;
	}

}
