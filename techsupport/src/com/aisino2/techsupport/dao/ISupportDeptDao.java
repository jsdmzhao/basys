package com.aisino2.techsupport.dao;

import java.util.List;

import com.aisino2.techsupport.domain.SupportDept;

/**
 * 支持单关联单位 数据库层服务
 *
 */
public interface ISupportDeptDao {
	void insertSupportDept(SupportDept supportDept);
	void removeSupportDept(SupportDept supportDept);
	List<SupportDept> getListSupportDepts(SupportDept supportDept);
}
