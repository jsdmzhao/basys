package com.aisino2.sysadmin.domain;

import com.aisino2.core.domain.BaseObject;
import com.aisino2.core.util.GB2Alpha;
public class Department  {

	/** @param 机构(t_department) */

	/** @ --机构ID--departid--Integer--9-- */
	private Integer departid;

	/** @ --机构代码--departcode--String--20-- */
	private String departcode;

	/** @ --机构名称--departname--String--50-- */
	private String departname;

	/** @ --机构层次--departlevel--Integer--1-- */
	private Integer departlevel;

	/** @ --父机构ID--parentdepartid--Integer--9-- */
	private Integer parentdepartid;

	/** @ --机构全路径代码--departfullcode--String--200-- */
	private String departfullcode;

	/** @ --节点顺序--nodeorder--Integer--9-- */
	private Integer nodeorder;

	/** @ --是否叶结点--isleaf--String--1-- */
	private String isleaf;

	/** @ --机构名称简拼--departsimplepin--String--50-- */
	private String departsimplepin;

	/** @ --机构名称全拼--departallpin--String--200-- */
	private String departallpin;
	
	/** @ --机构去偶数个0代码--departbrevitycode--String--20-- */
	private String departbrevitycode;
	
	/** @ --筛选条件-- */
	private String query_simplepin;
	
	/** @ --登录用户所在部门-- */
	private String deptCode;
	
	/** @ --部门下是否有用户和角色 0-无，1-有-- */
	private String child_count;

	
	/** 分页排序 */
	private String pageSort;
	
	private String flag;
	
	private Integer hndeptId;
	/** 上级机构名称 */
	private String  parentdepartname;
	
	/** 是否采集点 */
	private String  isCjd;
	
	private Integer length;
	
	
	/**
	 * 上级机构
	 */
	  private Department parent;
	  /**
	   * 显示名称索引
	   */
		private String alphaDisplayName;
	
	
	
	//移动方式
   private String way;
	
  //调整到那个部门的id
   private Integer departidTo;
   
   //采集点下拉列表使用属性
   private String display_name;
   
   private String fact_value;
   
	public String getDisplay_name() {
	return departname;
}

public void setDisplay_name(String display_name) {
	this.display_name = display_name;
}

public String getFact_value() {
	return departcode;
}

public void setFact_value(String fact_value) {
	this.fact_value = fact_value;
}

	public String getWay() {
	return way;
}

public void setWay(String way) {
	this.way = way;
}

	public Integer getHndeptId() {
		return hndeptId;
	}

	public void setHndeptId(Integer hndeptId) {
		this.hndeptId = hndeptId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

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

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getParentdepartname() {
		return parentdepartname;
	}

	public void setParentdepartname(String parentdepartname) {
		this.parentdepartname = parentdepartname;
	}

	public Integer getDepartidTo() {
		return departidTo;
	}

	public void setDepartidTo(Integer departidTo) {
		this.departidTo = departidTo;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public String getQuery_simplepin() {
		return query_simplepin;
	}

	public void setQuery_simplepin(String query_simplepin) {
		this.query_simplepin = query_simplepin;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getAlphaDisplayName() {
		String alphaDisplayName="";
		if(this.getDepartname()!=null){
			alphaDisplayName = GB2Alpha.String2Alpha(this.getDepartname())+"-"+this.getDepartname();
		}
		return alphaDisplayName;
	}

	public void setAlphaDisplayName(String alphaDisplayName) {
		this.alphaDisplayName = alphaDisplayName;
	}

	public String getDepartbrevitycode() {
		return departbrevitycode;
	}

	public void setDepartbrevitycode(String departbrevitycode) {
		this.departbrevitycode = departbrevitycode;
	}

	public String getIsCjd() {
		return isCjd;
	}

	public void setIsCjd(String isCjd) {
		this.isCjd = isCjd;
	}

	public String getChild_count() {
		return child_count;
	}

	public void setChild_count(String child_count) {
		this.child_count = child_count;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
}
