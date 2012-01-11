package com.aisino2.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.System;

public interface ISystemService {
	/** @param 系统(t_system) 增加 */
	System insertSystem(System system);

	/** @param 系统(t_system) 删除 */
	boolean deleteSystem(System system);

	/** @param 系统(t_system) 修改 */
	boolean updateSystem(System system);

	/** @param 系统(t_system) 查询单条 */
	System getSystem(System system);

	/** @param 系统(t_system) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 系统(t_system) 多条查询 */
	List getListSystem(System system);
	
	/**
	 *  根据systemcode取得子系统
	 * @param system
	 * @return
	 */
	List getChildSystem(System system);
	
	/**
	 * 当前用户所拥有的菜单
	 */
	List getTheUserChildSystem(System system);
	
	  /**
	   * 根据parentCode取得父系统
	   * @param system
	   * @return
	   */
	  System getParentSystem(System system);
	  
	  /**
	   * 1当新增对象时
	   * 根据 表名：（tableName和code）或是（tableName和name）
	   * 
	   * 判断t_menu，t_system，t_function，t_department表中是否存在将新增的code或name了
	   * 
	   *
	   *2新增user对象时根据（tableName和name）或是（tableName和account）判断否存在将新增的name或account了
	   *  3*新增role对象时根据tableName和name判断否存在将新增的name
	   * 
	   * @param condition
	   * @return
	   */
	  boolean isExit(Map condition);
	  /**
	   * 根据用户userid取得用户拥有的系统权限
	   * @param userid
	   * @return
	   */
	  List getSystemByUserID(System system);
	  
	  /**
	    * 系统的上移、下移、置顶、置底
	    * @param system
	    * system.way取值：上移,下移,置顶,置底
	    * @return
	    */
	  boolean updateSystemEditEdOrder(System system);
	  /**
	   * 获得下一个排序号
	   * @param system.parentsystemcode
	   * @return 
		*/
	Integer getNextNodeorder(System system);
}
