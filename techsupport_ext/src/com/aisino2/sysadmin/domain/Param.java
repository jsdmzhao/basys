package com.aisino2.sysadmin.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name="t_param")
public class Param implements Serializable {

	/** @param 参数设置(t_param) */

	@Id
	/** @ --参数编码--paramcode--String--50-- */
	private String paramcode;
	@Column
	/** @ --参数名称--paramname--String--50-- */
	private String paramname;
	@Column
	/** @ --参数值--paramvalue--String--1000-- */
	private String paramvalue;
	

	public String getParamcode() {
		return paramcode;
	}


	public void setParamcode(String paramcode) {
		this.paramcode = paramcode;
	}

	/** @ 参数名称(paramname) */
	public String getParamname() {
		return paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	/** @ 参数值(paramvalue) */
	public String getParamvalue() {
		return paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

}
