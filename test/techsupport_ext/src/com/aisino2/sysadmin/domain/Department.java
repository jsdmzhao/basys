package com.aisino2.sysadmin.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@javax.persistence.Entity
@Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "t_department")
public class Department implements Serializable  {

	/**
	 * @param 机构
	 *            (t_department)
	 */

	/** @ --机构ID--departid--Integer--9-- */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN_DEPARTID")
	@SequenceGenerator(name = "SEQ_GEN_DEPARTID", sequenceName = "departid")
	private Integer departid;

	/** @ --机构代码--departcode--String--20-- */
	@Column(name = "departcode")
	private String departcode;

	/** @ --机构名称--departname--String--50-- */
	@Column(name = "departname")
	private String departname;

	/** @ --机构层次--departlevel--Integer--1-- */
	@Column(name = "departlevel")
	private Integer departlevel;

	/** @ --父机构ID--parentdepartid--Integer--9-- */
	@Column(name = "parentdepartid")
	private Integer parentdepartid;

	/** @ --机构全路径代码--departfullcode--String--200-- */
	@Column(name = "departfullcode")
	private String departfullcode;

	/** @ --节点顺序--nodeorder--Integer--9-- */
	@Column
	private Integer nodeorder;

	/** @ --是否叶结点--isleaf--String--1-- */
	@Column(name = "isleaf")
	private String isleaf;

	/** @ --机构名称简拼--departsimplepin--String--50-- */
	@Column(name = "departsimplepin")
	private String departsimplepin;

	/** @ --机构名称全拼--departallpin--String--200-- */
	@Column(name = "departallpin")
	private String departallpin;

	/** @ --机构去偶数个0代码--departbrevitycode--String--20-- */
	@Column(name = "departbrevitycode")
	private String departbrevitycode;

	/**
	 * 上级机构
	 */
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parentdepartid", insertable = false, updatable = false)
	private Department parent;


	/** @ 机构ID(departid) */
	public Integer getDepartid() {
		return departid;
	}

	public void setDepartid(Integer departid) {
		this.departid = departid;
	}

	/** @ 机构代码(departcode) */
	public String getDepartcode() {
		return departcode;
	}

	public void setDepartcode(String departcode) {
		this.departcode = departcode;
	}

	/** @ 机构名称(departname) */
	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	/** @ 机构层次(departlevel) */
	public Integer getDepartlevel() {
		return departlevel;
	}

	public void setDepartlevel(Integer departlevel) {
		this.departlevel = departlevel;
	}

	/** @ 父机构ID(parentdepartid) */
	public Integer getParentdepartid() {
		return parentdepartid;
	}

	public void setParentdepartid(Integer parentdepartid) {
		this.parentdepartid = parentdepartid;
	}

	/** @ 机构全路径代码(departfullcode) */
	public String getDepartfullcode() {
		return departfullcode;
	}

	public void setDepartfullcode(String departfullcode) {
		this.departfullcode = departfullcode;
	}

	/** @ 节点顺序(nodeorder) */
	public Integer getNodeorder() {
		return nodeorder;
	}

	public void setNodeorder(Integer nodeorder) {
		this.nodeorder = nodeorder;
	}

	/** @ 是否叶结点(isleaf) */
	public String getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}

	public String getDepartsimplepin() {
		return departsimplepin;
	}

	public void setDepartsimplepin(String departsimplepin) {
		this.departsimplepin = departsimplepin;
	}

	public void setDepartallpin(String departallpin) {
		this.departallpin = departallpin;
	}

	public String getDepartallpin() {
		return departallpin;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}


	public String getDepartbrevitycode() {
		return departbrevitycode;
	}

	public void setDepartbrevitycode(String departbrevitycode) {
		this.departbrevitycode = departbrevitycode;
	}

}
