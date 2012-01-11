package com.aisino2.techsupport.dao;

import java.util.List;

import com.aisino2.techsupport.domain.SupportLeaderRelation;


/**
 * 技术负责人关联 数据库访问接口
 *
 */
public interface ISupportLeaderRelationDao {
	/**
	 * 插入
	 * @param supportLeaderRelation
	 */
	void insert(SupportLeaderRelation supportLeaderRelation);
	/**
	 * 删除
	 * @param supportLeaderRelation
	 */
	void delete(SupportLeaderRelation supportLeaderRelation);
	/**
	 * 获取列表
	 * @param supportLeaderRelation
	 * @return
	 */
	List<SupportLeaderRelation> query(SupportLeaderRelation supportLeaderRelation);
}
