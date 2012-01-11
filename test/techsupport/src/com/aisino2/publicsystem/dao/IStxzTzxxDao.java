package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.StxzTzxx;

public interface IStxzTzxxDao {

	/** @param 机修台帐信息 多条查询 */
	List getListStxzTzxx(StxzTzxx stxzTzxx);
	
	/** @param 所有企业信息(企业总数、从业人员总数 点击查看) 
	 * 输入参数： gxdwbm ：管辖单位代码的前N位	N的意义见JxtzxxAction
	 * 分页查询 
	 */
	Page getListAllQyxxForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 未上传企业信息(未上传企业总数 点击查看) 
	 * 输入参数： gxdwbm ：管辖单位代码的前N位	N的意义见JxtzxxAction
	 * 分页查询 
	 */
	Page getListWscQyxxForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 上传企业信息(上传机修信息总数 点击查看) 
	 * 输入参数： gxdwbm ：管辖单位代码的前N位	N的意义见JxtzxxAction
	 * 分页查询 
	 */
	Page getListScQyxxForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
