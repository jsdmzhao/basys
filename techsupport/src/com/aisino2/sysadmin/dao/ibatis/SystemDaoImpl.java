package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.ISystemDao;
import com.aisino2.sysadmin.domain.System;

public class SystemDaoImpl extends BaseDao implements ISystemDao {
	/** @param 系统(t_system) 增加 */
	public System insertSystem(System system){
		// TODO: implement
		return (System)insert("insertSystem", system);
	}

	/** @param 系统(t_system) 删除 */
	public int deleteSystem(System system){
		// TODO: implement
		return delete("deleteSystem", system);
	}

	/** @param 系统(t_system) 修改 */
	public int updateSystem(System system){
		// TODO: implement
		return update("updateSystem", system);
	}

	/** @param 系统(t_system) 查询单条 */
	public System getSystem(System system){
		// TODO: implement
		return (System)queryForObject("getSystem", system);
	}

	/** @param 系统(t_system) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.systemcode "+ desc;
			else if(sort.equals("1"))
				sCol = " a.systemname "+ desc;
			else if(sort.equals("2"))
				sCol = " a.parentsystemcode "+ desc;
			else
				sCol = " a.nodeorder ";
		}else{
			sCol=" a.nodeorder ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getSystemList", map, pageNo,pageSize);
	}

	/** @param 系统(t_system) 多条查询 */
	public List getListSystem(System system){
		// TODO: implement
		return queryForList("getSystemListNoPage", system);
	}

	public List getChildSystem(System system) {
		// TODO Auto-generated method stub
	    return queryForList("getChildSystem", system);
	}
	
	/**
	 * 当前用户所拥有的菜单
	 */
	public List getTheUserChildSystem(System system){
		return queryForList("getTheUserChildSystem", system);
	}

	public boolean checkChild(System system) {
		// TODO Auto-generated method stub
		Object obj = queryForObject("checkChildSystem", system);
		return new Integer(obj.toString()).intValue()>0;
	}

	public List getAllChildSystem(System system) {
		// TODO Auto-generated method stub
		  return queryForList("getAllChildSystem", system);
	}

	public System getParentSystem(System system) {
		// TODO Auto-generated method stub
		  Object obj = queryForObject("getParentSystem", system);
		    return (obj == null) ? null : (System) obj;
	}

	public List getSystemByUserID(System system) {
		// TODO Auto-generated method stub
		  return queryForList("getSystemByUserID", system);
	}

	public boolean isExit(Map condition) {
		// TODO Auto-generated method stub
		 Object obj = queryForObject("isExit", condition);
		    return (obj == null) ? false : true;
	}
	
	/** 获得下一个排序号 */
	public  System getNextNodeorder(System system)
	{
		return (System) queryForObject("getNextSystemNodeorder", system);
	}


}
