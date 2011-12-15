package com.aisino2.sysadmin.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


class User_rolePk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2583508784722631958L;
	private Integer userid;
	private Integer roleid;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	
}
@Entity
@Table(name="t_user_role")
@IdClass(User_rolePk.class)
public class User_role implements Serializable {

	/** @param 用户角色(t_user_role) */

	private User_rolePk id;
	@Id
	/** @ --角色ID--roleid--Integer--9-- */
	private Integer roleid;

	@Id
	/** @ --用户ID--userid--Integer--9-- */
	private Integer userid;


	
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

	public User_rolePk getId() {
		return id;
	}

	public void setId(User_rolePk id) {
		this.id = id;
	}

}
