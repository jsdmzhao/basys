package com.aisino2.sysadmin.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@Table(name="t_function")
public class Function  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7176627159913223073L;
	/** @param 功能(t_function) */

	@Id
	/** @ --功能代码--funccode--String--50-- */
	private String funccode;
	@Column
	/** @ --系统代码--systemcode--String--20-- */
	private String systemcode;
	@Column
	/** @ --功能名称--funcname--String--100-- */
	private String funcname;
	@Column
	/** @ --功能定义--funcdefine--String--200-- */
	private String funcdefine;
	@Column
	/** @ --功能类别--functype--Integer--1-- */
	private Integer functype;

	/**
	 * 功能类别名称
	 */
	private String functypename;

	/**
	 * 用户userid
	 */
	private  Integer userid;

	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/** @ 功能代码(funccode) */
	public String getFunccode() {
		return funccode;
	}

	public void setFunccode(String funccode) {
		this.funccode = funccode;
	}

	/** @ 系统代码(systemcode) */
	public String getSystemcode() {
		return systemcode;
	}

	public void setSystemcode(String systemcode) {
		this.systemcode = systemcode;
	}

	/** @ 功能名称(funcname) */
	public String getFuncname() {
		return funcname;
	}

	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}

	/** @ 功能定义(funcdefine) */
	public String getFuncdefine() {
		return funcdefine;
	}

	public void setFuncdefine(String funcdefine) {
		this.funcdefine = funcdefine;
	}

	/** @ 功能类别(functype) */
	public Integer getFunctype() {
		return functype;
	}

	public void setFunctype(Integer functype) {
		this.functype = functype;
	}


	public String getFunctypename() {
		return functypename;
	}

	public void setFunctypename(String functypename) {
		this.functypename = functypename;
	}
}
