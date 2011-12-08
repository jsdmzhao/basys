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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
@Table(name="t_user")
public class User  implements Serializable{

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userid, Integer departid, String useraccount,
			String username, String password, Integer userorder,
			String isvalid, String usertype, String idnum, String mobilephone, String jzlbdm, String jzlbmc) {
		super();
		this.userid = userid;
		this.departid = departid;
		this.useraccount = useraccount;
		this.username = username;
		this.password = password;
		this.userorder = userorder;
		this.isvalid = isvalid;
		this.usertype = usertype;
		this.idnum = idnum;
		this.mobilephone = mobilephone;
		this.jzlbdm = jzlbdm;
		this.jzlbmc = jzlbmc;
	}

	
	/** @param 用户(t_user) */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_GEN_USERID")
	@SequenceGenerator(name="SEQ_GEN_USERID",sequenceName="userid")
	/** @ --用户ID--userid--Integer--9-- */
	private Integer userid;
	
	@Column
	/** @ --机构ID--departid--Integer--9-- */
	private Integer departid;

	@Column
	/** @ --用户帐号名--useraccount--String--20-- */
	private String useraccount;

	@Column
	/** @ --用户姓名--username--String--20-- */
	private String username;

	@Column
	/** @ --用户口令--password--String--100-- */
	private String password;

	@Column
	/** @ --用户顺序--userorder--Integer--9-- */
	private Integer userorder;

	@Column
	/** @ --是否有效--isvalid--String--1-- */
	private String isvalid;

	@Column
	/** @ --用户类别--usertype--String--2-- */
	private String usertype;
	
	@Column
	/** @ --用户身份证号--usertype--String--2-- */
	private String idnum;
	
	private String idnum15;  ///15位的身份证号
	
	@Column
	/** @ --用户移动电话--usertype--String--2-- */
	private String mobilephone;

	/** 分页排序 */
	private String pageSort;
	/** @ --部门代码-- */
	private String departcode;
	
	/** @ --用户新密码-- */
	private String passwordNew;
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
	
	private String userAccP; ///用户的用户名||密码
	
	//ukey属性
	private String ukeyid;
	
	
	  
	  @ManyToOne(cascade=CascadeType.ALL)
	  @JoinColumn(name="departid",insertable=false,updatable=false)
	  private Department department;
	  
	  @ManyToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST},targetEntity=Role.class)
	  @JoinTable(name="t_user_role",joinColumns=@JoinColumn(name="userid"),inverseJoinColumns=@JoinColumn(name="roleid"))
	  private List<Role> roles;

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}
	
	
}
