package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class YlcsjbxxForTree  {
	/** @ --场所ID-- */
	private Integer csid;
	
	/** @ --场所编码-- */
	private String csbm;

	/** @ --场所名称- */
	private String csmc;
	
	/** 行业类型编码 */
	private String hylxbm;
	
	/** 行业类型名称 */
	private String hylxmc;

	/** 管辖单位编码 */
	private String gxdwbm;
	
	/** 管辖单位名称*/
	private String gxdwmc;
	
	/** 管辖单位编码是否完整 0-不完整，1-完整 */
	private String isAllGxdwbm;

	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	public String getCsbm() {
		return csbm;
	}

	public void setCsbm(String csbm) {
		this.csbm = csbm;
	}

	public String getCsmc() {
		return csmc;
	}

	public void setCsmc(String csmc) {
		this.csmc = csmc;
	}

	public String getHylxbm() {
		return hylxbm;
	}

	public void setHylxbm(String hylxbm) {
		this.hylxbm = hylxbm;
	}

	public String getHylxmc() {
		return hylxmc;
	}

	public void setHylxmc(String hylxmc) {
		this.hylxmc = hylxmc;
	}

	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getIsAllGxdwbm() {
		return isAllGxdwbm;
	}

	public void setIsAllGxdwbm(String isAllGxdwbm) {
		this.isAllGxdwbm = isAllGxdwbm;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return csbm.equals(((YlcsjbxxForTree)obj).getCsbm());
	}
	


}
