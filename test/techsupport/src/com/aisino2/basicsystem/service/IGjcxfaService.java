package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Gjcxfa;
import com.aisino2.core.dao.Page;

public interface IGjcxfaService {
	/** @param 高级查询方案(t_gjcxfa) 增加 */
	Gjcxfa insertGjcxfa(Gjcxfa gjcxfa);

	/** @param 高级查询方案(t_gjcxfa) 删除 */
	boolean deleteGjcxfa(Gjcxfa gjcxfa);

	/** @param 高级查询方案(t_gjcxfa) 修改 */
	boolean updateGjcxfa(Gjcxfa gjcxfa);
	/** 
	 * @param 高级查询方案(t_gjcxfa) 修改方案名称
	 */
	boolean updateGjcxfamc(Gjcxfa gjcxfa);

	/** @param 高级查询方案(t_gjcxfa) 查询单条 */
	Gjcxfa getGjcxfa(Gjcxfa gjcxfa);

	/** @param 高级查询方案(t_gjcxfa) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 高级查询方案(t_gjcxfa) 多条查询 */
	List getListGjcxfa(Gjcxfa gjcxfa);
	
	/**
	 * 取得所有的高级查询方案
	 */
	List getAllGjcxfa();
	
	/**
	 * 返回SQL 的where条件,动态查询的默认表别名为""
	 */
	String getQueryCondition(Gjcxfa gjcxfa);
	
	/**
	 * 返回SQL 的where条件
	 * @param tableAlias为动态查询的表别名
	 */
	String getQueryCondition(Gjcxfa gjcxfa ,String tableAlias);
	
	/**
	 * 返回SQL的Where条件String数组，数组第一个值和第二个值分别为查询条件和排序条件
	 * 动态查询的默认表别名为""
	 */
	String []getQueryConditions(Gjcxfa gjcxfa);
	
	/**
	 * 返回SQL的Where条件String数组，数组第一个值和第二个值分别为查询条件和排序条件
	 * @param tableAlias为动态查询的表别名
	 */
	String []getQueryConditions(Gjcxfa gjcxfa,String tableAlias);
}
