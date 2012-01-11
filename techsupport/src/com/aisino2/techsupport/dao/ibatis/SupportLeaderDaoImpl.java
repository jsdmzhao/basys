package com.aisino2.techsupport.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aisino2.techsupport.dao.ISupportLeaderRelationDao;
import com.aisino2.techsupport.domain.SupportLeaderRelation;

@Component
public class SupportLeaderDaoImpl extends TechSupportBaseDao implements
		ISupportLeaderRelationDao {

	public void insert(SupportLeaderRelation supportLeaderRelation) {
		this.insert("SupportLeaderRelation.insert", supportLeaderRelation);

	}

	public void delete(SupportLeaderRelation supportLeaderRelation) {
		if(supportLeaderRelation==null)
			throw new RuntimeException("技术负责人关联实体为空");
		if(supportLeaderRelation.getStId()==null && supportLeaderRelation.getSupportLeaderId() == null)
			throw new RuntimeException("技术负责人关联的支持单ID和负责人ID不能同时为空");
		this.delete("SupportLeaderRelation.delete", supportLeaderRelation);
	}

	@SuppressWarnings("unchecked")
	public List<SupportLeaderRelation> query(
			SupportLeaderRelation supportLeaderRelation) {
		return this.queryForList("SupportLeaderRelation.querylist", supportLeaderRelation);
	}

}
