package com.aisino2.sysadmin.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


class RoleFuncPk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -857114628740613891L;
	private Integer roleid;
	private String funccode;
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getFunccode() {
		return funccode;
	}
	public void setFunccode(String funccode) {
		this.funccode = funccode;
	}
}

@Entity
@Table(name="t_role_func")
@IdClass(RoleFuncPk.class)
public class Role_func implements Serializable {

	private RoleFuncPk id;
	/** @param 角色功能(t_role_func) */
	@Id
	/** @ --角色ID--roleid--Integer--9-- */
	private Integer roleid;
	@Id
	/** @ --功能代码--funccode--String--50-- */
	private String funccode;

	/** @ --参数--param--String--200-- */
	@Column
	private String param;

	
	@ManyToOne
	@JoinColumn(name="param",insertable=false,updatable=false)
	private Param paramObject;


	/** @ 角色ID(roleid) */
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/** @ 功能代码(funccode) */
	public String getFunccode() {
		return funccode;
	}

	public void setFunccode(String funccode) {
		this.funccode = funccode;
	}

	/** @ 参数(param) */
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}


	public Param getParamObject() {
		return paramObject;
	}

	public void setParamObject(Param paramObject) {
		this.paramObject = paramObject;
	}

	public RoleFuncPk getId() {
		return id;
	}

	public void setId(RoleFuncPk id) {
		this.id = id;
	}
}
