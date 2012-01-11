package com.aisino2.publicsystem.domain;

import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Wgtzrxx  {

	/** @param 外国投资人信息(t_wgtzrxx) */

	/** @ --外国投资人信息ID--wgtzrxxid--Integer--10-- */
	private Integer wgtzrxxid;

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --投资者姓名--tzzxm--String--100-- */
	private String tzzxm;

	/** @ --联系电话--lxdh--String--30-- */
	private String lxdh;

	/** @ --国籍代码--gjdm--String--40-- */
	private String gjdm;

	/** @ --国籍--gj--String--100-- */
	private String gj;

	/** @ --签证种类代码--qzzldm--String--40-- */
	private String qzzldm;

	/** @ --签证种类名称--qzzlmc--String--100-- */
	private String qzzlmc;

	/** @ --签证号码--qzhm--String--20-- */
	private String qzhm;

	/** @ --护照种类代码--hzzldm--String--40-- */
	private String hzzldm;

	/** @ --护照种类名称--hzzlmc--String--100-- */
	private String hzzlmc;

	/** @ --护照号码--hzhm--String--20-- */
	private String hzhm;
	
	private String wgtzrLxdh;

	/** 分页排序 */
	private String pageSort;
	
    private List lWgtzrxxList;
	
	/** @ --请求动作：查看、修改 - 查看则不给删除按钮(非数据库字段)- */
	private String wgtzrxxRequetType;

	/** @ 外国投资人信息ID(wgtzrxxid) */
	public Integer getWgtzrxxid() {
		return wgtzrxxid;
	}

	public void setWgtzrxxid(Integer wgtzrxxid) {
		this.wgtzrxxid = wgtzrxxid;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 投资者姓名(tzzxm) */
	public String getTzzxm() {
		return tzzxm;
	}

	public void setTzzxm(String tzzxm) {
		this.tzzxm = tzzxm;
	}

	/** @ 联系电话(lxdh) */
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	/** @ 国籍代码(gjdm) */
	public String getGjdm() {
		return gjdm;
	}

	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
	}

	/** @ 国籍(gj) */
	public String getGj() {
		return gj;
	}

	public void setGj(String gj) {
		this.gj = gj;
	}

	/** @ 签证种类代码(qzzldm) */
	public String getQzzldm() {
		return qzzldm;
	}

	public void setQzzldm(String qzzldm) {
		this.qzzldm = qzzldm;
	}

	/** @ 签证种类名称(qzzlmc) */
	public String getQzzlmc() {
		return qzzlmc;
	}

	public void setQzzlmc(String qzzlmc) {
		this.qzzlmc = qzzlmc;
	}

	/** @ 签证号码(qzhm) */
	public String getQzhm() {
		return qzhm;
	}

	public void setQzhm(String qzhm) {
		this.qzhm = qzhm;
	}

	/** @ 护照种类代码(hzzldm) */
	public String getHzzldm() {
		return hzzldm;
	}

	public void setHzzldm(String hzzldm) {
		this.hzzldm = hzzldm;
	}

	/** @ 护照种类名称(hzzlmc) */
	public String getHzzlmc() {
		return hzzlmc;
	}

	public void setHzzlmc(String hzzlmc) {
		this.hzzlmc = hzzlmc;
	}

	/** @ 护照号码(hzhm) */
	public String getHzhm() {
		return hzhm;
	}

	public void setHzhm(String hzhm) {
		this.hzhm = hzhm;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public List getLWgtzrxxList() {
		return lWgtzrxxList;
	}

	public void setLWgtzrxxList(List wgtzrxxList) {
		lWgtzrxxList = wgtzrxxList;
	}

	public String getWgtzrxxRequetType() {
		return wgtzrxxRequetType;
	}

	public void setWgtzrxxRequetType(String wgtzrxxRequetType) {
		this.wgtzrxxRequetType = wgtzrxxRequetType;
	}

	public String getWgtzrLxdh() {
		return wgtzrLxdh;
	}

	public void setWgtzrLxdh(String wgtzrLxdh) {
		this.wgtzrLxdh = wgtzrLxdh;
		this.lxdh = wgtzrLxdh;
	}
}
