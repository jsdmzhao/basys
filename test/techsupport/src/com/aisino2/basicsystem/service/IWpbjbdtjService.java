package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Wpbjbdtj;
import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.basicsystem.domain.Wpbjxxb;
import com.aisino2.core.dao.Page;

public interface IWpbjbdtjService {
	/** @param 物品报警比对条件(t_wpbjbdtj) 增加 */
	Wpbjbdtj insertWpbjbdtj(Wpbjbdtj wpbjbdtj);

	/** @param 物品报警比对条件(t_wpbjbdtj) 删除 */
	boolean deleteWpbjbdtj(Wpbjbdtj wpbjbdtj);

	/** @param 物品报警比对条件(t_wpbjbdtj) 修改 */
	boolean updateWpbjbdtj(Wpbjbdtj wpbjbdtj);

	/** @param 物品报警比对条件(t_wpbjbdtj) 查询单条 */
	Wpbjbdtj getWpbjbdtj(Wpbjbdtj wpbjbdtj);

	/** @param 物品报警比对条件(t_wpbjbdtj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 物品报警比对条件(t_wpbjbdtj) 多条查询 */
	List getListWpbjbdtj(Wpbjbdtj wpbjbdtj);
	
	/**
	 * 得到报警比对的sql
	 * @param bjgz
	 * @return
	 */
	String getBjbdtjSql(Wpbjgz wpbjgz,Wpbjxxb wpbjxxbIn);
	
	//List getWpBaojingTempList(Wpbjgz wpbjgz,Integer rowNum);
}
