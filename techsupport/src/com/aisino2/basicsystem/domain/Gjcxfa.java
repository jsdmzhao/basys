package com.aisino2.basicsystem.domain;

import java.util.ArrayList;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Gjcxfa  {

	/** @param 高级查询方案(t_gjcxfa) */

	/** @ --高级查询方案ID--gjcxfaid--Integer--10-- */
	private Integer gjcxfaid;

	/** @ --高级查询方案名称--gjcxfamc--String--100-- */
	private String gjcxfamc;

	/** @ --所属用户帐号--ssyhzh--String--60-- */
	private String ssyhzh;

	/** @ --所属功能名称--ssgnmc--String--100-- */
	private String ssgnmc;

	/** @ --高级查询类型--gjcxlx--String--20-- */
	private String gjcxlx;

	/**匹配条件(动态查询条件)List*/
	private List lPptj_table = new ArrayList();
	
	/**排序规则List*/
	private List lPxgz_table = new ArrayList();

	/** 分页排序 */
	private String pageSort;
	
	/** 自定义查询bean*/
	private Zdycxtj zdycxtj;
	
   //方案下拉列表使用属性
   private String display_name;
   
   private Integer fact_value;

   
	public Zdycxtj getZdycxtj() {
		return zdycxtj;
	}

	public void setZdycxtj(Zdycxtj zdycxtj) {
		this.zdycxtj = zdycxtj;
	}

	public String getDisplay_name() {
		return gjcxfamc;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	
	public Integer getFact_value() {
		return gjcxfaid;
	}
	
	public void setFact_value(Integer fact_value) {
		this.fact_value = fact_value;
	}

	public List getLPptj_table() {
		return lPptj_table;
	}

	public void setLPptj_table(List pptj_table) {
		lPptj_table = pptj_table;
	}

	public List getLPxgz_table() {
		return lPxgz_table;
	}

	public void setLPxgz_table(List pxgz_table) {
		lPxgz_table = pxgz_table;
	}

	/** @ 高级查询方案ID(gjcxfaid) */
	public Integer getGjcxfaid() {
		return gjcxfaid;
	}

	public void setGjcxfaid(Integer gjcxfaid) {
		this.gjcxfaid = gjcxfaid;
	}

	/** @ 高级查询方案名称(gjcxfamc) */
	public String getGjcxfamc() {
		return gjcxfamc;
	}

	public void setGjcxfamc(String gjcxfamc) {
		this.gjcxfamc = gjcxfamc;
	}

	/** @ 所属用户帐号(ssyhzh) */
	public String getSsyhzh() {
		return ssyhzh;
	}

	public void setSsyhzh(String ssyhzh) {
		this.ssyhzh = ssyhzh;
	}

	/** @ 所属功能名称(ssgnmc) */
	public String getSsgnmc() {
		return ssgnmc;
	}

	public void setSsgnmc(String ssgnmc) {
		this.ssgnmc = ssgnmc;
	}

	/** @ 高级查询类型(gjcxlx) */
	public String getGjcxlx() {
		return gjcxlx;
	}

	public void setGjcxlx(String gjcxlx) {
		this.gjcxlx = gjcxlx;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
