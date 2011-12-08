package com.aisino2.sysadmin.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "t_role")
public class Role implements Serializable{

	public Role(Integer roleid, Integer departid, String rolename,
			String roledescription, Integer roletype) {
		super();
		this.roleid = roleid;
		this.departid = departid;
		this.rolename = rolename;
		this.roledescription = roledescription;
		this.roletype = roletype;
	}

	/**
	 * @param 角色
	 *            (t_role)
	 */

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** @ --角色ID--roleid--Integer--9-- */
	@Id
	@GeneratedValue(generator = "SEQ_GEN_ROLEID", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "SEQ_GEN_ROLEID", sequenceName = "roleid")
	private Integer roleid;

	@Column
	/** @ --机构ID--departid--Integer--9-- */
	private Integer departid;

	@Column
	/** @ --角色名称--rolename--String--50-- */
	private String rolename;

	@Column
	/** @ --角色描述--roledescription--String--100-- */
	private String roledescription;

	@Column
	/** @ --角色类别--roletype--Integer--1-- */
	private Integer roletype;

	/** 分页排序 */
	private String pageSort;

	/** 移动方式 */
	private String way;

	/** 选中菜单 */
	private String menucode;

	/** 角色ID串 */
	private String roleidString;

	/** 部门名称 */
	private String departname;

	/** 部门代码 */
	private String departcode;

	/** 筛选字段 */
	private String query_simplepin;
	@ManyToOne
	@JoinColumn(name="departid",insertable=false,updatable=false)
	private Department department;
	@OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST},targetEntity=Function.class)
	@JoinTable(name="t_role_func",joinColumns=@JoinColumn(name="roleid"),inverseJoinColumns=@JoinColumn(name="funccode"))
	private List<Function> roleFunctions;
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST},targetEntity=User.class)
	@JoinTable(name="t_user_role",joinColumns=@JoinColumn(name="roleid"),inverseJoinColumns=@JoinColumn(name="userid"))
	private List<User> roleUsers;
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST},targetEntity=Menu.class)
	@JoinTable(name="t_role_menu",joinColumns=@JoinColumn(name="roleid"),inverseJoinColumns=@JoinColumn(name="menucode"))
	private List<Menu> roleMenus;

	private String systemcode;

	private String roleNameType = "0";

	/** 设置复选框的属性 */
	private String checkbox;



	private String jzlbdm;
	private String jzlbmc;

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

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
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

	public List<Function> getRoleFunctions() {
		return roleFunctions;
	}

	public void setRoleFunctions(List<Function> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	public List<User> getRoleUsers() {
		return roleUsers;
	}

	public void setRoleUsers(List<User> roleUsers) {
		this.roleUsers = roleUsers;
	}

	public List<Menu> getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(List<Menu> roleMenus) {
		this.roleMenus = roleMenus;
	}
}
