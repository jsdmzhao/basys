package com.aisino2.sysadmin.domain;

import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Menu  {

	/**
	 * @param 菜单
	 *            (t_menu)
	 */

	/** @ --菜单代码--menucode--String--40-- */
	private String menucode;

	/** @ --系统代码--systemcode--String--20-- */
	private String systemcode;

	/** @ --菜单名称--menuname--String--50-- */
	private String menuname;

	/** @ --功能入口--funcentry--String--500-- */
	private String funcentry;

	/** @ --菜单层次--menulevel--Integer--1-- */
	private Integer menulevel;

	/** @ --上级菜单代码--parentmenucode--String--40-- */
	private String parentmenucode;

	/** @ --菜单全路径代码--menufullcode--String--400-- */
	private String menufullcode;

	/** @ --节点顺序--nodeorder--Integer--9-- */
	private Integer nodeorder;

	/** @ --是否叶结点--isleaf--String--1-- */
	private String isleaf;

	/** 分页排序 */
	private String pageSort;

	/** 用户ID */
	private Integer userid;

	/** 子菜单 */
	private List lChildMenu;

	/** 移动方式 */
	private String way;
	/**
	 * 上级菜单名称
	 */
	private String parentmenuname;

	private System system;

	// 菜单下拉列表使用属性
	private String display_name;

	private String fact_value;

	// 是否选中:某个角色是否有该菜单的操作权限
	private Integer ischecked;

	/** @ --角色ID -- */
	private Integer roleid;

	private String menuTypeCode;// 菜单类型代码

	private String menuTypeName;// 菜单类型名称

	private String singleHylb;// 登录用户是否只属于一个行业 0-否，1-是

	/** @ --机构ID -- */
	private Integer departid;
	
	/**@ fullcode like条件 #%*/
	private String fullcodelike;
	
	/**@ menucode in条件 in()*/
	private String menucodein;

	public String getFullcodelike() {
		return fullcodelike;
	}

	public void setFullcodelike(String fullcodelike) {
		this.fullcodelike = fullcodelike;
	}

	public String getMenucodein() {
		return menucodein;
	}

	public void setMenucodein(String menucodein) {
		this.menucodein = menucodein;
	}

	public Integer getDepartid() {
		return departid;
	}

	public void setDepartid(Integer departid) {
		this.departid = departid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getIschecked() {
		return ischecked;
	}

	public void setIschecked(Integer ischecked) {
		this.ischecked = ischecked;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getFact_value() {
		return fact_value;
	}

	public void setFact_value(String fact_value) {
		this.fact_value = fact_value;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/** @ 菜单代码(menucode) */
	public String getMenucode() {
		return menucode;
	}

	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}

	/** @ 系统代码(systemcode) */
	public String getSystemcode() {
		return systemcode;
	}

	public void setSystemcode(String systemcode) {
		this.systemcode = systemcode;
	}

	/** @ 菜单名称(menuname) */
	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	/** @ 功能入口(funcentry) */
	public String getFuncentry() {
		return funcentry;
	}

	public void setFuncentry(String funcentry) {
		this.funcentry = funcentry;
	}

	/** @ 菜单层次(menulevel) */
	public Integer getMenulevel() {
		return menulevel;
	}

	public void setMenulevel(Integer menulevel) {
		this.menulevel = menulevel;
	}

	/** @ 上级菜单代码(parentmenucode) */
	public String getParentmenucode() {
		return parentmenucode;
	}

	public void setParentmenucode(String parentmenucode) {
		this.parentmenucode = parentmenucode;
	}

	/** @ 菜单全路径代码(menufullcode) */
	public String getMenufullcode() {
		return menufullcode;
	}

	public void setMenufullcode(String menufullcode) {
		this.menufullcode = menufullcode;
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

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getParentmenuname() {
		return parentmenuname;
	}

	public void setParentmenuname(String parentmenuname) {
		this.parentmenuname = parentmenuname;
	}

	public List getLChildMenu() {
		return lChildMenu;
	}

	public void setLChildMenu(List childMenu) {
		lChildMenu = childMenu;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getMenuTypeCode() {
		return menuTypeCode;
	}

	public void setMenuTypeCode(String menuTypeCode) {
		this.menuTypeCode = menuTypeCode;
	}

	public String getMenuTypeName() {
		return menuTypeName;
	}

	public void setMenuTypeName(String menuTypeName) {
		this.menuTypeName = menuTypeName;
	}

	public String getSingleHylb() {
		return singleHylb;
	}

	public void setSingleHylb(String singleHylb) {
		this.singleHylb = singleHylb;
	}
}
