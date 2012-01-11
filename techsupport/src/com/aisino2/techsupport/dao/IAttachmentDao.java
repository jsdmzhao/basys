package com.aisino2.techsupport.dao;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.domain.Attachment;

/**
 * 附件 数据访问
 *
 */
public interface IAttachmentDao {
	/**
	 * 插入
	 * @param attachement
	 */
	void insert(Attachment attachement);
	/**
	 * 删除
	 * @param attachement
	 */
	void delete(Attachment attachement);
	/**
	 * 更新
	 * @param attachement
	 */
	void update(Attachment attachement);
	/**
	 * 分页查询
	 * @param map
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param desc
	 * @return
	 */
	Page queryForPage(Map<String, Object> map,
			int pageno, int pagesize, String sort, String desc);
	/**
	 * 查询
	 * @param attachement
	 * @return
	 */
	List<Attachment> query(Attachment attachement);
	
	/**
	 * 查询单个
	 * @param attachment
	 * @return
	 */
	Attachment get(Attachment attachment);
}
