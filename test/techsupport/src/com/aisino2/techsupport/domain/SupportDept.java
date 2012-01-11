package com.aisino2.techsupport.domain;

/**
 * 支持单指派关联单位
 *
 */
public class SupportDept {
	/**
	 * 唯一标识
	 */
	private Integer id;
	/**
	 * 支持单ID，唯一标识
	 */
	private Integer stId;
	/**
	 * 单位ID
	 */
	private Integer deptId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStId() {
		return stId;
	}
	public void setStId(Integer stId) {
		this.stId = stId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SupportDept){
			SupportDept tobj=(SupportDept)obj;
			return ((tobj.deptId.equals(this.deptId)) && (tobj.stId.equals(this.stId)));
		}
		else
			return super.equals(obj);
	}
	
	
	
	
}
