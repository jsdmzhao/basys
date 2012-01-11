package com.aisino2.techsupport.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.techsupport.dao.ISupportDeptDao;
import com.aisino2.techsupport.domain.SupportDept;

/**
 * 
 * 支持单关联单位 数据库层服务
 *
 */
@Component("SupportDeptDaoImpl")
public class SupportDeptDaoImpl extends TechSupportBaseDao implements ISupportDeptDao {

	public void insertSupportDept(SupportDept supportDept) {
		supportDept.setId(this.getNextID("SEQ_TS_STDEPT"));
		this.insert("SupportDept.insert", supportDept);
	}

	public void removeSupportDept(SupportDept supportDept) {
		this.delete("SupportDept.delete", supportDept);
	}

	@SuppressWarnings("unchecked")
	public List<SupportDept> getListSupportDepts(SupportDept supportDept) {
		
		return this.queryForList("SupportDept.querylist", supportDept);
	}

}
