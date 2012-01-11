package com.aisino2.sysadmin.domain;

import com.aisino2.core.domain.BaseObject;
import com.aisino2.core.util.PinYinUtil;

public class Dict  {

	/** @param 字典(t_dict) */

	/** @ --字典编码--dict_code--String--10-- */
	private String dict_code;

	/** @ --字典名--dict_name--String--50-- */
	private String dict_name;

	/** @ --上级字典编码--super_dict_code--String--10-- */
	private String super_dict_code;

	/** @ --兄弟排序--sib_order--Integer--5-- */
	private Integer sib_order;

	/** @ --叶节点标志--leaf_flag--String--1-- */
	private String leaf_flag;

	/** @ --维护标志--maint_flag--Integer--1-- */
	private Integer maint_flag;

	/** @ --字典类型--dict_type--String--2-- */
	private String dict_type;

	/** @ --字典名称简拼--dict_simplepin--String--50-- */
	private String dict_simplepin;

	/** @ --字典名称全拼--dict_allpin--String--200-- */
	private String dict_allpin;

	/** @ --字典项的表名--dict_itemtablename--String--20-- */
	private String dict_itemtablename;

	/** @ --版本号--dict_versionid--String--20-- */
	private String dict_versionid;

	/** @ --字典id--dict_id--Integer--8-- */
	private Integer dict_id;

	/** 分页排序 */
	private String pageSort;

	private String dict_type_name;
	
	/**联动字典筛选字段*/
	private String query_simplepin;
	
	/**offline用查询字段*/
	private String kongjianDicts;
	
	
	public String getQuery_simplepin() {
		return query_simplepin;
	}

	public void setQuery_simplepin(String query_simplepin) {
		this.query_simplepin = query_simplepin;
	}

	public String getDict_type_name() {
		return dict_type_name;
	}

	public void setDict_type_name(String dict_type_name) {
		this.dict_type_name = dict_type_name;
	}

	/** @ 字典编码(dict_code) */
	public String getDict_code() {
		return dict_code;
	}

	public void setDict_code(String dict_code) {
		this.dict_code = dict_code;
	}

	/** @ 字典名(dict_name) */
	public String getDict_name() {
		return dict_name;
	}

	public void setDict_name(String dict_name) {
		this.dict_name = dict_name;
	}

	/** @ 上级字典编码(super_dict_code) */
	public String getSuper_dict_code() {
		return super_dict_code;
	}

	public void setSuper_dict_code(String super_dict_code) {
		this.super_dict_code = super_dict_code;
	}

	/** @ 兄弟排序(sib_order) */
	public Integer getSib_order() {
		return sib_order;
	}

	public void setSib_order(Integer sib_order) {
		this.sib_order = sib_order;
	}

	/** @ 叶节点标志(leaf_flag) */
	public String getLeaf_flag() {
		return leaf_flag;
	}

	public void setLeaf_flag(String leaf_flag) {
		this.leaf_flag = leaf_flag;
	}

	/** @ 维护标志(maint_flag) */
	public Integer getMaint_flag() {
		return maint_flag;
	}

	public void setMaint_flag(Integer maint_flag) {
		this.maint_flag = maint_flag;
	}

	/** @ 字典类型(dict_type) */
	public String getDict_type() {
		return dict_type;
	}

	public void setDict_type(String dict_type) {
		this.dict_type = dict_type;
	}

	/** @ 字典名称简拼(dict_simplepin) */
	public String getDict_simplepin() {
		if(dict_name==null||dict_name.equals("")){
			return "";
		}else{
			return PinYinUtil.getHanyuPingYinInitial(dict_name);
		}
	}

	public void setDict_simplepin(String dict_simplepin) {
		this.dict_simplepin = dict_simplepin;
	}

	/** @ 字典名称全拼(dict_allpin) */
	public String getDict_allpin() {
		if(dict_name==null||dict_name.equals("")){
			return "";
		}else{
			return PinYinUtil.getHanyuPingYin(dict_name);
		}
	}

	public void setDict_allpin(String dict_allpin) {
		this.dict_allpin = dict_allpin;
	}

	/** @ 字典项的表名(dict_itemtablename) */
	public String getDict_itemtablename() {
		return dict_itemtablename;
	}

	public void setDict_itemtablename(String dict_itemtablename) {
		this.dict_itemtablename = dict_itemtablename;
	}

	/** @ 版本号(dict_versionid) */
	public String getDict_versionid() {
		return dict_versionid;
	}

	public void setDict_versionid(String dict_versionid) {
		this.dict_versionid = dict_versionid;
	}

	/** @ 字典id(dict_id) */
	public Integer getDict_id() {
		return dict_id;
	}

	public void setDict_id(Integer dict_id) {
		this.dict_id = dict_id;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getKongjianDicts() {
		return kongjianDicts;
	}

	public void setKongjianDicts(String kongjianDicts) {
		this.kongjianDicts = kongjianDicts;
	}
}
