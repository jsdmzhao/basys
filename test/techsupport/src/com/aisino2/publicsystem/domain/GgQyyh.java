package com.aisino2.publicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class GgQyyh  {
	/** 存储过程返回的第一个参数 */
	private Integer errCode;
	/** 
	 * 存储过程返回的第二个参数
	 * 如果异常次参数不为空  
	 */
	private String errMsg;
	/** 存储过程输入参数 */
	private String ddqybm;
	
	/** 从业人员编号 */
	private Integer ryid;
	/** 用户是否可用 */
	private String isval;
	
	private String systemflag;//系统标识。例如典当：ddy，机修业:jxy
	
	private String qybm ;//企业编码
	
	public String getQybm() {
		return qybm;
	}
	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}
	public String getSystemflag() {
		return systemflag;
	}
	public void setSystemflag(String systemflag) {
		this.systemflag = systemflag;
	}
	public Integer getErrCode() {
		return errCode;
	}
	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getDdqybm() {
		return ddqybm;
	}
	public void setDdqybm(String ddqybm) {
		this.ddqybm = ddqybm;
	}
	public String getIsval() {
		return isval;
	}
	public void setIsval(String isval) {
		this.isval = isval;
	}
	public Integer getRyid() {
		return ryid;
	}
	public void setRyid(Integer ryid) {
		this.ryid = ryid;
	}
}
