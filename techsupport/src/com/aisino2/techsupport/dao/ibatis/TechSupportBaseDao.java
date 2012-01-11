package com.aisino2.techsupport.dao.ibatis;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.core.dao.BaseDao;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 *  
 * 技术支持单基础DAO
 */
@Component("TechSupportBaseDao")
public class TechSupportBaseDao extends BaseDao {
	@Resource(name="sqlMapTechSupport")
	public void setSqlMap(SqlMapClient sqlMapClient){
		this.setSqlMapClient(sqlMapClient);
	}
}
