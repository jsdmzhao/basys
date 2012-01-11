package com.aisino2.sysadmin.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.System;
public interface ISystemDao {
	/** @param 系统(t_system) 增加 */
	System insertSystem(System system);

	/** @param 系统(t_system) 删除 */
	int deleteSystem(System system);

	/** @param 系统(t_system) 修改 */
	int updateSystem(System system);

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
	
	  System getParentSystem(System system);
	  /**
	   *  根据systemcode取得所有子系统
	   * @param system
	   * @return
	   */
	  List getAllChildSystem(System system);
	  
	  /**
	   * 判断是否存在；

	   * @param condition
	   * @return
	   */
	  boolean isExit(Map condition);
	  
	  /**
	   * 检查是否还有子类；
	   * @param condition
	   * @return
	   */
	  boolean checkChild(System system);
	  

	  /**
	   * 根据用户userid取得用户拥有的系统权限
	   * @param userid
	   * @return
	   */
	  List getSystemByUserID(System system);
	  /** 获得下一个排序号 */
	  System getNextNodeorder(System system);
}
