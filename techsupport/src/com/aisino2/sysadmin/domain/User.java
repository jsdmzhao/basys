package com.aisino2.sysadmin.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.core.domain.BaseObject;

public class User  {

	/** @param 用户(t_user) */

	/** @ --用户ID--userid--Integer--9-- */
	private Integer userid;

	/** @ --机构ID--departid--Integer--9-- */
	private Integer departid;

	/** @ --用户帐号名--useraccount--String--20-- */
	private String useraccount;

	/** @ --用户姓名--username--String--20-- */
	private String username;

	/** @ --用户口令--password--String--100-- */
	private String password;

	/** @ --用户顺序--userorder--Integer--9-- */
	private Integer userorder;

	/** @ --是否有效--isvalid--String--1-- */
	private String isvalid;

	/** @ --用户类别--usertype--String--2-- */
	private String usertype;
	
	/** @ --用户身份证号--usertype--String--2-- */
	private String idnum;
	
	private String idnum15;  ///15位的身份证号
	
	/** @ --用户移动电话--usertype--String--2-- */
	private String mobilephone;

	/** 分页排序 */
	private String pageSort;
	/** @ --部门代码-- */
	private String departcode;
	
	/** @ --用户新密码-- */
	private String passwordNew;
	/** @ ---- 全局参数中默认角色Map*/
	private Map defaultRoleMap;
	/**
	 * 用户类别名称 - 非数据库字段 -
	 */
	private String usertypename;
	/**
	 * 是否有效 值 - 非数据库字段 -
	 */
	private String isvalidValue;
	
	/** 移动方式 */
	private String way;

	/**机构名称*/
	private String departname;
	
	/**userId 集合属性*/
	private String useridSet;
	
	private String checkbox;
	
	/** 用户角色 */
	private List lUserRoleList;
	
	private String userAccP; ///用户的用户名||密码
	
	//ukey属性
	private String ukeyid;
	
	/** @ --证书申请日期--zssqrq--Date---- */
	private Date zssqrq;

	/** @ --证书有效日期--zsyxrq--Date---- */
	private Date zsyxrq;
	
	/** @ --使用姓名--xm_syr--String--120-- */
	private String xm_syr;
	
	/** @ --使用姓名--cyrybh--String--120-- */
	private String cyrybh;
	/**
	 *  新密码
	 */
	  private String newpwd;
	  
	  private Department department;
	  private List userRoles;
	  private Loginlog loginlog;

	  private String baojingflag;
	  private String loginip;
	  private String loginmac;
	  
	  /**
	   *  ssdwbm-用户所属单位编码。企业用户及员工用户放置企业编码，其他用户为空
	   *  added by mds at 20100121
	   */
	  private String ssdwbm;
	  private String ssdwmc;
	  
	  private String jzlbdm;
	  private String jzlbmc;
	  
	public String getUseridSet() {
		return useridSet;
	}

	public void setUseridSet(String useridSet) {
		this.useridSet = useridSet;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public String getDepartname() {
			return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List userRoles) {
		this.userRoles = userRoles;
	}

	/** @ 用户ID(userid) */
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/** @ 机构ID(departid) */
	public Integer getDepartid() {
		return departid;
	}

	public void setDepartid(Integer departid) {
		this.departid = departid;
	}

	/** @ 用户帐号名(useraccount) */
	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	/** @ 用户姓名(username) */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/** @ 用户口令(password) */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/** @ 用户顺序(userorder) */
	public Integer getUserorder() {
		return userorder;
	}

	public void setUserorder(Integer userorder) {
		this.userorder = userorder;
	}

	/** @ 是否有效(isvalid) */
	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	/** @ 用户类别(usertype) */
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getUsertypename() {
		return usertypename;
	}

	public void setUsertypename(String usertypename) {
		this.usertypename = usertypename;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}

	public List getLUserRoleList() {
		return lUserRoleList;
	}

	public void setLUserRoleList(List userRoleList) {
		lUserRoleList = userRoleList;
	}

	public String getIsvalidValue() {
		return isvalidValue;
	}

	public void setIsvalidValue(String isvalidValue) {
		this.isvalidValue = isvalidValue;
	}

	public String getDepartcode() {
		return departcode;
	}

	public void setDepartcode(String departcode) {
		this.departcode = departcode;
	}

	public Loginlog getLoginlog() {
		return loginlog;
	}

	public void setLoginlog(Loginlog loginlog) {
		this.loginlog = loginlog;
	}

	public Map getDefaultRoleMap() {
		return defaultRoleMap;
	}

	public void setDefaultRoleMap(Map defaultRoleMap) {
		this.defaultRoleMap = defaultRoleMap;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getBaojingflag() {
		return baojingflag;
	}

	public void setBaojingflag(String baojingflag) {
		this.baojingflag = baojingflag;
	}

	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public String getLoginmac() {
		return loginmac;
	}

	public void setLoginmac(String loginmac) {
		this.loginmac = loginmac;
	}

	public String getUserAccP() {
		return userAccP;
	}

	public void setUserAccP(String userAccP) {
		this.userAccP = userAccP;
	}

	public String getIdnum15() {
		return idnum15;
	}

	public void setIdnum15(String idnum15) {
		this.idnum15 = idnum15;
	}

	public String getSsdwbm() {
		return ssdwbm;
	}

	public void setSsdwbm(String ssdwbm) {
		this.ssdwbm = ssdwbm;
	}

	public String getSsdwmc() {
		return ssdwmc;
	}

	public void setSsdwmc(String ssdwmc) {
		this.ssdwmc = ssdwmc;
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
	
	public String getUkeyid() {
		return ukeyid;
	}

	public void setUkeyid(String ukeyid) {
		this.ukeyid = ukeyid;
	}

	public Date getZsyxrq() {
		return zsyxrq;
	}

	public void setZsyxrq(Date zsyxrq) {
		this.zsyxrq = zsyxrq;
	}

	public Date getZssqrq() {
		return zssqrq;
	}

	public void setZssqrq(Date zssqrq) {
		this.zssqrq = zssqrq;
	}

	public String getXm_syr() {
		return xm_syr;
	}

	public void setXm_syr(String xm_syr) {
		this.xm_syr = xm_syr;
	}

	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}
	
	
}
