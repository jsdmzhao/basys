package com.aisino2.sysadmin.domain;

import com.aisino2.core.domain.BaseObject;
public class Dict_item  {

	/** @param 字典项(t_dict_item) */

	/** @ --字典项ID--item_id--Integer--9-- */
	private Integer item_id;

	/** @ --字典编码--dict_code--String--10-- */
	private String dict_code;

	/** @ --显示名称--display_name--String--100-- */
	private String display_name;

	/** @ --实际值--fact_value--String--50-- */
	private String fact_value;

	/** @ --附加值--append_value--String--50-- */
	private String append_value;

	/** @ --上级字典项ID--super_item_id--Integer--9-- */
	private Integer super_item_id;

	/** @ --兄弟排序--sib_order--Integer--5-- */
	private Integer sib_order;

	/** @ --叶节点标志--leaf_flag--String--1-- */
	private String leaf_flag;

	/** @ --显示标志--display_flag--Integer--1-- */
	private Integer display_flag;

	/** @ --有效标志--valid_flag--Integer--1-- */
	private Integer valid_flag;

	/** @ --字典项名称简拼--item_simplepin--String--50-- */
	private String item_simplepin;

	/** @ 字典项简拼查询 */
	private String query_simplepin;
	
	/** @ --查询所有子节点-- */
	private String like_factValue;
	
	/** @ --查询不含本节点的其他所有节点-- */
	private String exclude_factValue;
	
	/** @ --指定排序字段-- 0-按fact_value排序 1-按sib_order排序*/
	private String orderBySib_order;

	
	/** 移动方式 */
	private String way;

	public String getLike_factValue() {
		return like_factValue;
	}

	public void setLike_factValue(String like_factValue) {
		this.like_factValue = like_factValue;
	}

	public String getQuery_simplepin() {
		return query_simplepin;
	}

	public void setQuery_simplepin(String query_simplepin) {
		this.query_simplepin = query_simplepin;
	}

	/** @ --字典项名称全拼--item_allpin--String--200-- */
	private String item_allpin;

	/** 分页排序 */
	private String pageSort;
	/**
	 * 字典id
	 */
	private Integer Dict_id;
	

	public Integer getDict_id() {
		return Dict_id;
	}

	public void setDict_id(Integer dict_id) {
		Dict_id = dict_id;
	}

	/** @ 字典项ID(item_id) */
	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	/** @ 字典编码(dict_code) */
	public String getDict_code() {
		return dict_code;
	}

	public void setDict_code(String dict_code) {
		this.dict_code = dict_code;
	}

	/** @ 显示名称(display_name) */
	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	/** @ 实际值(fact_value) */
	public String getFact_value() {
		return fact_value;
	}

	public void setFact_value(String fact_value) {
		this.fact_value = fact_value;
	}

	/** @ 附加值(append_value) */
	public String getAppend_value() {
		return append_value;
	}

	public void setAppend_value(String append_value) {
		this.append_value = append_value;
	}

	/** @ 上级字典项ID(super_item_id) */
	public Integer getSuper_item_id() {
		return super_item_id;
	}

	public void setSuper_item_id(Integer super_item_id) {
		this.super_item_id = super_item_id;
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

	/** @ 显示标志(display_flag) */
	public Integer getDisplay_flag() {
		return display_flag;
	}

	public void setDisplay_flag(Integer display_flag) {
		this.display_flag = display_flag;
	}

	/** @ 有效标志(valid_flag) */
	public Integer getValid_flag() {
		return valid_flag;
	}

	public void setValid_flag(Integer valid_flag) {
		this.valid_flag = valid_flag;
	}

	/** @ 字典项名称简拼(item_simplepin) */
	public String getItem_simplepin() {
		return item_simplepin;
	}

	public void setItem_simplepin(String item_simplepin) {
		this.item_simplepin = item_simplepin;
	}

	/** @ 字典项名称全拼(item_allpin) */
	public String getItem_allpin() {
		return item_allpin;
	}

	public void setItem_allpin(String item_allpin) {
		this.item_allpin = item_allpin;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getExclude_factValue() {
		return exclude_factValue;
	}

	public void setExclude_factValue(String exclude_factValue) {
		this.exclude_factValue = exclude_factValue;
	}
	
	public String getOrderBySib_order() {
		return orderBySib_order;
	}

	public void setOrderBySib_order(String orderBySib_order) {
		this.orderBySib_order = orderBySib_order;
	}
}
